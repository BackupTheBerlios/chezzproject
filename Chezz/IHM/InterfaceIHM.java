/*
 * Created on 3 nov. 2003
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

package IHM;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;


/**
 * @author Nicolas
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class InterfaceIHM {
	public InterfaceIHM() {
		   // déclaration de l'affichage
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(500,300);
		
		   // déclaration des éléments 
		Label label = new Label(shell, SWT.BORDER);
		label.setText("Test de label");
		label.setSize(150,20);
		label.setLocation(30,30);
		
		Label label1 = new Label(shell, SWT.BORDER);
		label1.setText("Test de label");
		label1.setSize(150,20);
		label1.setLocation(30,30);
				
		PlateauIHM plateau = new PlateauIHM();
		
		Label label2 = new Label(shell, SWT.BORDER);
		label2.setText("Test de label");
		label2.setSize(150,20);
		label2.setLocation(30,30);
		
		   // déclaration des layouts et positionnement des objets
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		
		   // Menu (partie haute de l'écran)
		shell.setLayout(layout);
		GridData gridMenu = new GridData();
		gridMenu.horizontalSpan = 2;
		label.setLayoutData(gridMenu);
		
		   // Partie basse de l'écran
		GridData data = new GridData();
		   // Partie gauche
		label1.setLayoutData(data);
		data = new GridData();
		   // Partie droite
		//label2.setLayoutData(data);
		
		data = new GridData();
		
		

		

		
		
		   // affichage de l'écran
		shell.open();
				while(!shell.isDisposed()) {
					if(!display.readAndDispatch()) {
						display.sleep();
					}
				}
				display.dispose();
		
	}
}
