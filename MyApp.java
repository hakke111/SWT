import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class MyApp {

	protected Shell shell;
	private Text txtUnidades;
	private Text txtPrecio;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MyApp window = new MyApp();
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
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		
		txtUnidades = new Text(shell, SWT.BORDER);
		txtUnidades.setBounds(249, 45, 76, 21);
		
		
		txtPrecio = new Text(shell, SWT.BORDER);
		txtPrecio.setBounds(249, 88, 76, 21);
		
		Label lblTotal = new Label(shell, SWT.NONE);
		lblTotal.setBounds(158, 204, 55, 15);
		
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				
				int c = Integer.parseInt(txtUnidades.getText());
				double p = Double.parseDouble(txtPrecio.getText());
				String Total = Double.toString(c*p);
				
				if (c==0) {
					lblTotal.setText("ERROR");
				}else {
					lblTotal.setText(Total);
				}
				
				
				
				
				
			
			}
		});
		
		btnCalcular.setBounds(158, 147, 75, 25);
		btnCalcular.setText("Calcular");
		
		Label lblUnidades = new Label(shell, SWT.NONE);
		lblUnidades.setBounds(132, 45, 55, 15);
		lblUnidades.setText("Unidades");
		
		Label lblPrecio = new Label(shell, SWT.NONE);
		lblPrecio.setBounds(132, 94, 55, 15);
		lblPrecio.setText("Precio");
		
		

	}
}
