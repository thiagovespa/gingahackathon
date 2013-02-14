import java.io.IOException;

import javax.microedition.xlet.Xlet;
import javax.microedition.xlet.XletContext;
import javax.microedition.xlet.XletStateChangeException;

import net.java.gingahackathon.Galeria;

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
		// formStyle.setBgColor(Color.black);
		formStyle.setBgTransparency(0);

		Button btn = new Button("Botão");
		Style btnStyle = btn.getStyle();

		btnStyle.setFont(Font.createSystemFont(Font.FACE_SYSTEM,
				Font.STYLE_PLAIN, Font.SIZE_LARGE));

		final Galeria galeria = new Galeria(1, 3);
		final Galeria galeria2 = new Galeria(2, 5);

		btn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < 13; i++) {
					Image image = null;
					try {
						image = Image.createImage("image/duke.jpg");
					} catch (IOException e) {
						e.printStackTrace();
					}
					if(i<3) {
						galeria.adicionarImage(image);
					} else {
						galeria2.adicionarImage(image);
					}

				}
				f.addComponent(galeria);
				f.addComponent(galeria2);
				f.repaint();

			}
		});
		f.addComponent(btn);

		f.show();
	}

}
