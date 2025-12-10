package hust.soict.dsai.screen;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.cart.Cart;

public class MediaStore extends JPanel {
    private Media media;
    private Cart currentCart;
    
    public MediaStore(Media media, Cart currentCart) {
        this.media = media;
        this.currentCart = currentCart;

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(300, 150));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        ButtonListener listener = new ButtonListener();

        JButton addCartButton = new JButton("Add to cart");
        addCartButton.addActionListener(listener); 
        container.add(addCartButton);

        if (media instanceof Playable) {
            JButton play = new JButton("Play");
            play.addActionListener(listener);
            container.add(play);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Add to cart")) {
                currentCart.addMedia(media);
                System.out.println("Added " + media.getTitle());
            } 
            else if (button.equals("Play")) {
                if (media instanceof Playable) {
                    JDialog d = new JDialog();
                    d.setTitle("Media Player");
                    d.setSize(300, 200);
            
                    JLabel label = new JLabel("Playing: " + media.getTitle());
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    d.add(label);
            
                    d.setVisible(true);
                }
            }
        }
    }
}