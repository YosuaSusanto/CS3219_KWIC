import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class appWindow {

	protected Shell shell;
	private Text textOutput;
	private Text textInputFile;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			appWindow window = new appWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(540, 410);
		shell.setText("SWT Application");
		
		Group grpInput = new Group(shell, SWT.NONE);
		grpInput.setText("Input");
		grpInput.setBounds(10, 10, 504, 172);
		
		Label lblChooseFile = new Label(grpInput, SWT.NONE);
		lblChooseFile.setBounds(0, 29, 67, 15);
		lblChooseFile.setText("Choose file:");
		
		textInputFile = new Text(grpInput, SWT.BORDER);
		textInputFile.setBounds(73, 23, 267, 21);
		
		DropTarget dropTarget = new DropTarget(textInputFile, DND.DROP_MOVE);
		Transfer[] transferAgents = {FileTransfer.getInstance()};
		dropTarget.setTransfer(transferAgents);
		dropTarget.addDropListener(new DropTargetAdapter() {
            public void drop(DropTargetEvent event) {
                String fileList[] = null;
                FileTransfer ft = FileTransfer.getInstance();
                if (ft.isSupportedType(event.currentDataType)) {
                    fileList = (String[]) event.data;
                    if (fileList.length > 1) {
                    	textOutput.setText("Please select only 1 file");
                    	MessageBox messageBox = new MessageBox(shell, SWT.ICON_WARNING
                                | SWT.OK);
                        messageBox.setMessage("Please select only 1 file!");
                        messageBox.setText("Multiple file selected!");
                        messageBox.open();
                    	fileList = null;
                    }
                    else {
                    	textInputFile.setText(fileList[0]);
                    }
                }
            }
        });
		
		Button btnOk = new Button(grpInput, SWT.NONE);
		
		final Button btnAdt = new Button(grpInput, SWT.RADIO);
		btnAdt.setBounds(75, 79, 90, 16);
		btnAdt.setText("ADT");

		final Button btnPipeFilter = new Button(grpInput, SWT.RADIO);
		btnPipeFilter.setBounds(172, 79, 90, 16);
		btnPipeFilter.setText("Pipe & Filter");
		
		Group grpOutput = new Group(shell, SWT.NONE);
		grpOutput.setText("Output");
		grpOutput.setBounds(10, 190, 504, 172);
		
		textOutput = new Text(grpOutput, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI);
		textOutput.setBounds(0, 21, 494, 141);

		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				textOutput.setText("Please select an input file");
				if (!textInputFile.getText().isEmpty()) {
					String words = "", wordsToIgnore = "";
					try {
						BufferedReader in = new BufferedReader(new FileReader(textInputFile.getText()));
						words = in.readLine();
						wordsToIgnore = in.readLine();
						startProcessing(btnAdt.getSelection(), words, wordsToIgnore);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		
		btnOk.setBounds(428, 19, 52, 25);
		btnOk.setText("OK");
		
		Button btnBrowse = new Button(grpInput, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
		        fd.setText("Choose");
		        fd.setFilterPath(System.getProperty("user.dir"));
		        String[] filterExt = { "*.txt" };
		        fd.setFilterExtensions(filterExt);
		        String selected = fd.open();
		        if (selected != null) {
		        	textInputFile.setText(selected);
		        }
			}
		});
		btnBrowse.setBounds(346, 19, 75, 25);
		btnBrowse.setText("Browse...");
	}
	
	public void startProcessing(boolean isStyleADT, String words, String wordsToIgnore) throws IOException {
		if (isStyleADT == true) {
			KWIC_ADT app = new KWIC_ADT();
			app.run(words, wordsToIgnore);
			textOutput.setText(app.getOutputText());
		}
		else {
			Build build = new Build();
			textOutput.setText(build.KWIC_PipeAndFilter(words, wordsToIgnore));
		}
	}
}
