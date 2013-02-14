
import java.io.IOException;

import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;

import com.sun.dtv.lwuit.Button;
import com.sun.dtv.lwuit.Container;
import com.sun.dtv.lwuit.Font;
import com.sun.dtv.lwuit.Form;
import com.sun.dtv.lwuit.Image;
import com.sun.dtv.lwuit.Label;
import com.sun.dtv.lwuit.events.ActionEvent;
import com.sun.dtv.lwuit.events.ActionListener;
import com.sun.dtv.lwuit.layouts.BoxLayout;
import com.sun.dtv.lwuit.layouts.GridLayout;
import com.sun.dtv.lwuit.plaf.Style;

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
		BoxLayout layout = new BoxLayout(BoxLayout.Y_AXIS);
		f.setLayout(layout);
		Style formStyle = f.getStyle();
		//formStyle.setBgColor(Color.black);
		formStyle.setBgTransparency(0);
		
		Button btn = new Button("Botão");
		Style btnStyle = btn.getStyle();
		
		btnStyle.setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_LARGE));
		
		final Container labelContainer = new Container(new GridLayout(3, 5));
		btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				for (int i=0;i<15;i++) {
					Label l = new Label();
					try {
						Image image = Image.createImage("image/duke.jpg");
						l.setIcon(image);
					} catch (IOException e) {
						l.setText("Sem imagem.");
						e.printStackTrace();
					}
					
					Style labelStyle = l.getStyle();
					//l.setPreferredSize(new Dimension(10,60));
					labelStyle.setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
					labelStyle.setBgTransparency(0);
					labelContainer.addComponent(l);
					
				
				}
				f.addComponent(labelContainer);
				f.repaint();
				
			}
		});
		f.addComponent(btn);
		
		
		
		f.show();
	}

}
