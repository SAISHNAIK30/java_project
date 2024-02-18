
package universitymanagementsystem;

import java.awt.Image;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Splash extends JFrame implements Runnable
{
    Thread t;
    
    Splash() {
        final ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/PCCE.jpg"));
        final Image i2 = i1.getImage().getScaledInstance(1000, 700, 1);
        final ImageIcon i3 = new ImageIcon(i2);
        final JLabel image = new JLabel(i3);
        this.add(image);
        (this.t = new Thread(this)).start();
        this.setVisible(true);
        for (int x = 1, j = 2; j <= 600; j += 4, ++x) {
            this.setLocation(600 - (j + x) / 2, 350 - j / 2);
            this.setSize(j + 3 * x, j + x / 2);
            try {
                Thread.sleep(10L);
            }
            catch (Exception ex) {}
        }
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(7000L);
            this.setVisible(false);
            new Login();
        }
        catch (Exception ex) {}
    }
    
    public static void main(final String[] args) {
        new Splash();
    }
}

