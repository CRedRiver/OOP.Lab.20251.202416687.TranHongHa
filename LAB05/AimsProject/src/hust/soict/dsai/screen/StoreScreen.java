package hust.soict.dsai.screen;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;       
import javax.swing.*; 
import hust.soict.dsai.aims.StoreCreator;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

public class StoreScreen extends JFrame{
    private Store store;
    private Cart currentCart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.currentCart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        
        cp.add(createNorth(), BorderLayout.NORTH);

        JPanel centerPanel = createCenter();
        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cp.add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    public static void main(String[] args) {
        Store store = StoreCreator.createStore();
        Cart cart = new Cart();
        new StoreScreen(store, cart);
    }
    private class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("View Store")){
                System.out.println("Switching to Store Menu");
                new StoreScreen(store, currentCart);
                dispose();
            }
            else if (command.equals("View Cart")) {
                new CartScreen(store , currentCart);
            }
            else if (command.equals("Add Book")) {
                new AddBookToStoreScreen(store);
            }
            else if (command.equals("Add CD")) {
                new AddCDToStoreScreen(store);
            }
            else if (command.equals("Add DVD")) {
                new AddDVDToStoreScreen(store);
            }
        }
    }
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        MenuListener listener = new MenuListener();

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        smUpdateStore.add(addBook);
        addBook.addActionListener(listener);

        JMenuItem addCD = new JMenuItem("Add CD");
        smUpdateStore.add(addCD);
        addCD.addActionListener(listener);
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(listener);

        menu.add(smUpdateStore);
        JMenuItem viewStoreButton = new JMenuItem("View Store");
        menu.add(viewStoreButton);
        viewStoreButton.addActionListener(listener);

        JMenuItem viewCartButton = new JMenuItem("View Cart");
        menu.add(viewCartButton);
        viewCartButton.addActionListener(listener);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        MenuListener listener = new MenuListener();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cart = new JButton("View Cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.addActionListener(listener);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        
        GridLayout layout = new GridLayout(0, 3, 2, 2);
        center.setLayout(layout);

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        for (int i = 0; i < mediaInStore.size(); i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), currentCart);
            center.add(cell);
        }
    
        return center;
    }
}
