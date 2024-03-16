import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PulsMatierInfo extends JPanel {
    JLabel text_height ;
    JLabel text_weight ;
    JLabel text_MM1 ;
    JLabel text_MM2 ;
    JTextField text_height_measure ;
    JTextField text_weight_measure ;
    JComboBox material_list_box ;
    Info_keeper info_keeper = new Info_keeper();


    public PulsMatierInfo() throws IOException {
        String [][] list_from_file = info_keeper.mat_list;
        String [] material_list_name = new String[list_from_file.length];
        double [] material_list_price = new double[list_from_file.length];
        for (int i=0;i<list_from_file.length;i++){
            for(int j =0;j<list_from_file[i].length;j++){
                if (j == 0){
                    material_list_name[i] = list_from_file[i][j];
                }else if (j == 1){
                    double from_string_to_float = Double.valueOf(list_from_file[i][j]);
                    material_list_price[i] = from_string_to_float;
                }
            }
        }
        text_height = new JLabel();
        text_weight = new JLabel();
        text_MM1 = new JLabel();
        text_MM2 = new JLabel();
        text_height_measure = new JTextField();
        text_weight_measure = new JTextField();
        material_list_box = new JComboBox(material_list_name);
        this.setLayout(null);
        this.setSize(700,70);
        text_height.setText("Länge");
        text_weight.setText("Breite");
        text_MM1.setText(" :m");
        text_MM2.setText(" :m");
        text_height.setBounds(40, 10, 50, 20);
        text_weight.setBounds(40, 40, 50, 20);
        //(200, 230, 120, 20);
        text_MM1.setBounds(230, 10, 70, 20);
        text_MM2.setBounds(230, 40, 70, 20);
        text_height_measure.setBounds(100, 10, 120, 20);
        text_weight_measure.setBounds(100, 40, 120, 20);
        material_list_box.setBounds(330, 25, 230, 30);


        this.add(text_height);
        this.add(text_weight);
        this.add(text_height_measure);
        this.add(text_weight_measure);
        this.add(material_list_box);
        this.add(text_MM1);
        this.add(text_MM2);
        this.setVisible(true);

    }

    public JTextField getText_height_measure() {
        return text_height_measure;
    }

    public JTextField getText_weight_measure() {
        return text_weight_measure;
    }

    public JComboBox getMaterial_list_box() {
        return (JComboBox) material_list_box.getSelectedItem();
    }

    public int getArrayIndex(String [] arr,String word) {

        int k=0;
        for(int i=0;i<arr.length;i++){

            if(arr[i].equals(word)){
                k=i;
                break;
            }
        }
        return k;
    }

}
