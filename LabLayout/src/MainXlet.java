import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;

import com.sun.dtv.lwuit.Button;
import com.sun.dtv.lwuit.Component;
import com.sun.dtv.lwuit.Form;
import com.sun.dtv.lwuit.Label;
import com.sun.dtv.lwuit.layouts.BorderLayout;
import com.sun.dtv.lwuit.layouts.BoxLayout;
import com.sun.dtv.lwuit.layouts.CoordinateLayout;
import com.sun.dtv.lwuit.layouts.FlowLayout;
import com.sun.dtv.lwuit.layouts.GridLayout;
import com.sun.dtv.lwuit.layouts.GroupLayout;

/**
 * Exemplo de uso de layout
 * 
 * @author Thiago Galbiatti Vespa
 */
public class MainXlet implements Xlet {

	public void destroyXlet(boolean arg0) throws XletStateChangeException {
	}

	public void initXlet(XletContext arg0) throws XletStateChangeException {
	}

	public void pauseXlet() {
	}

	public void startXlet() throws XletStateChangeException {
		final Form f = new Form();
		//BorderLayout layout = new BorderLayout();
		BoxLayout layout = new BoxLayout(BoxLayout.X_AXIS);
		//BoxLayout layout = new BoxLayout(BoxLayout.Y_AXIS);
		//FlowLayout layout = new FlowLayout();
		//FlowLayout layout = new FlowLayout(Component.RIGHT);
		//GridLayout layout = new GridLayout(0, 2);
		//GroupLayout layout = new GroupLayout(f);
		//CoordinateLayout layout = new CoordinateLayout(200,100);


		f.setLayout(layout);
		Button btn = new Button("Botão");
		Label l1 = new Label("Label 1");
		Label l2 = new Label("Label 2");
		Label l3 = new Label("Label 3");
		Label l4 = new Label("Label 4");
		
		Component[] comps = {btn,l1,l2,l3,l4};
		for(int cmpIdx = 0;cmpIdx<comps.length;cmpIdx++) {
			Component cmp = comps[cmpIdx];
			/* Coordinate Layout 
			cmp.setWidth(10);
			cmp.setHeight(5);
			cmp.setX(cmpIdx*10);
			cmp.setY(cmpIdx*10); */
			f.addComponent(cmp);
		}
		
		/* Border Layout 
		f.addComponent(BorderLayout.CENTER, btn);
		f.addComponent(BorderLayout.EAST, l2);
		f.addComponent(BorderLayout.WEST, l3);
		f.addComponent(BorderLayout.NORTH, l4);
		f.addComponent(BorderLayout.SOUTH, l1);
		*/
		f.show();
	}

}
