/*
 * Created on 3 nov. 2003
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package IHM;


import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;


/**
 * @author Nicolas
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class PlateauIHM {
	public PlateauIHM() {
		Display display = new Display();
		Shell shell = new Shell(display);

		shell.setSize(500,300);

		
		Label label = new Label(shell, SWT.BORDER);
		label.setText("Plateau");
		label.setSize(150,20);
		label.setLocation(30,30);

		


		shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
	}
}
