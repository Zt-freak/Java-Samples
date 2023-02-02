import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Example {
    public static void main(String[] args) throws MalformedURLException {
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setLayout(new GridBagLayout());

        ImageIcon chungus = new ImageIcon(
            new URL(
                "https://static.wikia.nocookie.net/supermarioglitchy4/images/f/f3/Big_chungus.png/revision/latest?cb=20200511041102"
            ),
            "Big Chungus"
        );
        
        int width = 200;
        int height = 200;
        int x = 200;
        int y = 200;

        JButton button = new JButton();
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBounds(x, y, width, height);
        button.setIcon(chungus);
        int offset = button.getInsets().left;
        button.setIcon(resizeIcon(chungus, button.getWidth() - offset, button.getHeight() - offset));
        button.addActionListener(
            e -> {
                button.setBounds(x, y, button.getWidth() + 1, height);
                button.setIcon(resizeIcon(chungus, button.getWidth() - offset, button.getHeight() - offset));
            }
        );

        frame.add(button, new GridBagConstraints());

        frame.setVisible(true);
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();  
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
        return new ImageIcon(resizedImage);
    }
}