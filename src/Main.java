import javax.swing.*;
import java.io.IOException;

public class Main {

    private static void createWindow()throws IOException{
        JFrame main_windows = new JFrame("Material Price Calculator");

        JPanel sell_layout = new Customer_windows();
        JPanel buy_layout = new Shop_windows();
        JPanel sellMoreInOneCalculator = new CustomerMoreMatriealWindows();


        JTabbedPane j_tabbed_pane = new JTabbedPane( JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);

        // Main windows
        main_windows.setSize(800,850);
        main_windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // JTabbed pane Add
        j_tabbed_pane.addTab("selling multiple materials",sell_layout);
        j_tabbed_pane.addTab("sell a material", sellMoreInOneCalculator);
        j_tabbed_pane.addTab("material list and price", buy_layout );




        // Windows Add
      main_windows.add(j_tabbed_pane);
      main_windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      main_windows.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    createWindow();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}