import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMoreMatriealWindows extends JPanel {

     JComboBox material_list_box1;
    JComboBox material_list_box2;
    JComboBox material_list_box3;
    JComboBox material_list_box4;
    JComboBox material_list_box5;
    JComboBox material_list_box6;
    JComboBox material_list_box7;
    JComboBox material_list_box8;
    JComboBox material_list_box9;
    JRadioButton jRadioButton1 = new JRadioButton("Selected", true);
    JRadioButton jRadioButton2 = new JRadioButton("Add");
    JRadioButton jRadioButton3 = new JRadioButton("Add" );
    JRadioButton jRadioButton4 = new JRadioButton("Add" );
    JRadioButton jRadioButton5 = new JRadioButton("Add" );
    JRadioButton jRadioButton6 = new JRadioButton("Add" );
    JRadioButton jRadioButton7 = new JRadioButton("Add" );
    JRadioButton jRadioButton8 = new JRadioButton("Add" );
    JRadioButton jRadioButton9 = new JRadioButton("Add" );
//    JRadioButton jRadioButtonA = new JRadioButton("A",true);
//    JRadioButton jRadioButtonB = new JRadioButton("B");
     JButton button_calculator = new JButton("Rechnen");
     JLabel text_height = new JLabel();
     JLabel text_weight = new JLabel();
     JLabel text_MM1 = new JLabel();
     JLabel text_MM2 = new JLabel();
     JTextField textFieldDiscount = new JTextField();
    JLabel textDiscount = new JLabel("Discount");
    JLabel textDiscountSymbol = new JLabel(" %" );
     JTextField text_height_measure = new JTextField(7);
     JTextField text_weight_measure = new JTextField(7);
     JTextArea text_result = new JTextArea();
     JScrollPane scrollPane_text_result = new JScrollPane(text_result);
    Info_keeper info_keeper = new Info_keeper();
    ButtonGroup jRadioButtonABGroup = new ButtonGroup();

    public CustomerMoreMatriealWindows() throws IOException {
        this.setLayout(null);
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

        material_list_box1 = new JComboBox(material_list_name);
        material_list_box2 = new JComboBox(material_list_name);
        material_list_box3 = new JComboBox(material_list_name);
         material_list_box4= new JComboBox(material_list_name);
         material_list_box5= new JComboBox(material_list_name);
         material_list_box6= new JComboBox(material_list_name);
         material_list_box7= new JComboBox(material_list_name);
        material_list_box8= new JComboBox(material_list_name);
        material_list_box9= new JComboBox(material_list_name);
        text_height.setText("Länge");
        text_weight.setText("Breite");
        text_result.setText("Ergbnisse");
        text_MM1.setText(" :m");
        text_MM2.setText(" :m");
        //
        button_calculator.setForeground(Color.BLUE);
        button_calculator.setFont(new Font("arial", Font.BOLD, 20));
        material_list_box1.setBounds(425, 50, 250, 30);
        material_list_box2.setBounds(425, 90, 250, 30);
        material_list_box3.setBounds(425, 130, 250, 30);
        material_list_box4.setBounds(425, 170, 250, 30);
        material_list_box5.setBounds(425, 210, 250, 30);
        material_list_box6.setBounds(425, 250, 250, 30);
        material_list_box7.setBounds(425, 290, 250, 30);
        material_list_box8.setBounds(425, 330, 250, 30);
        material_list_box9.setBounds(425, 370, 250, 30);
        jRadioButton1.setBounds(300,50,80,30);
        jRadioButton2.setBounds(300,90,80,30);
        jRadioButton3.setBounds(300,130,80,30);
        jRadioButton4.setBounds(300,170,80,30);
        jRadioButton5.setBounds(300,210,80,30);
        jRadioButton6.setBounds(300,250,80,30);
        jRadioButton7.setBounds(300,290,80,30);
        jRadioButton8.setBounds(300,330,80,30);
        jRadioButton9.setBounds(300,370,80,30);
        //
         text_MM1.setBounds(200, 230, 120, 20);
         text_MM2.setBounds(200, 260, 120, 20);
        textDiscount.setBounds(50,530, 70, 20);
         textFieldDiscount.setBounds(120,530, 100, 20);
         textDiscountSymbol.setBounds(230,530, 100, 20);
        text_height.setBounds(40, 230, 50, 20);
        text_weight.setBounds(40, 260, 50, 20);
        text_height_measure.setBounds(100, 230, 100, 20);
        text_weight_measure.setBounds(100, 260, 100, 20);
 //       jRadioButtonA.setBounds(350,500,50,70);
 //       jRadioButtonB.setBounds(450,500,50,70);
        button_calculator.setBounds(30,600, 160, 70);
        scrollPane_text_result.setBounds(230, 600, 360, 100);
        this.add(text_MM1);
        this.add(text_MM2);
        this.add(textDiscount);
        this.add(textDiscountSymbol);
        this.add(textFieldDiscount);
        this.add(material_list_box1);
        this.add(material_list_box2);
        this.add(material_list_box3);
        this.add(material_list_box4);
        this.add(material_list_box5);
        this.add(material_list_box6);
        this.add(material_list_box7);
        this.add(material_list_box8);
        this.add(material_list_box9);
        this.add(jRadioButton1);
        this.add(jRadioButton2);
        this.add(jRadioButton3);
        this.add(jRadioButton4);
        this.add(jRadioButton5);
        this.add(jRadioButton6);
        this.add(jRadioButton7);
        this.add(jRadioButton8);
        this.add(jRadioButton9);
        this.add(text_height);
        this.add(text_weight);
        this.add(text_height_measure);
        this.add(text_weight_measure);
//        this.add(jRadioButtonA);
//        this.add(jRadioButtonB);
        this.add(button_calculator);
        this.add(scrollPane_text_result);

        this.setVisible(true);

//        jRadioButtonABGroup.add(jRadioButtonA);
//        jRadioButtonABGroup.add(jRadioButtonB);
        List<JRadioButton> jRadioButtonList = new ArrayList<>();
        jRadioButtonList.add(jRadioButton2);
        jRadioButtonList.add(jRadioButton3);
        jRadioButtonList.add(jRadioButton4);
        jRadioButtonList.add(jRadioButton5);
        jRadioButtonList.add(jRadioButton6);
        jRadioButtonList.add(jRadioButton7);
        jRadioButtonList.add(jRadioButton8);
        jRadioButtonList.add(jRadioButton9);
        List<JComboBox> jComboBoxList = new ArrayList<>();
        jComboBoxList.add(material_list_box2);
        jComboBoxList.add(material_list_box3);
        jComboBoxList.add(material_list_box4);
        jComboBoxList.add(material_list_box5);
        jComboBoxList.add(material_list_box6);
        jComboBoxList.add(material_list_box7);
        jComboBoxList.add(material_list_box8);
        jComboBoxList.add(material_list_box9);


        button_calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                int workProcess = 1;
                if (jRadioButtonA.isSelected()){
                    workProcess =2;
                }else if (jRadioButtonB.isSelected()){

                    workProcess=3;
                }
*/
                float materialPriec = 1;

                materialPriec=Float.valueOf(process(material_list_box1, text_height_measure,text_weight_measure,material_list_name,material_list_price).get(1));
                for (int i =0; i< jRadioButtonList.size();i++){
                    if ((jRadioButtonList.get(i)).isSelected()){
                        materialPriec+=Float.valueOf(process(jComboBoxList.get(i), text_height_measure,text_weight_measure,material_list_name,material_list_price).get(1));
                    }
                }
                float discount ;
                if (textFieldDiscount.getText().isEmpty()){
                    discount = 0.0F;
                }else {
                    discount = Float.valueOf(textFieldDiscount.getText().toString());
                }
 //               float fialPreis = (materialPriec * workProcess) + 10;
                float discountPries = ((discount * materialPriec)/100);
                float preisTotalFinal = materialPriec - discountPries;
                text_result.setText("\nTotal Preis : "+preisTotalFinal+" € ");
                System.out.println("discount : "+discount);
                System.out.println("fialPreis : " +materialPriec);
                System.out.println("discountPries : "+discountPries);
                System.out.println("preisTotalFinal : "+preisTotalFinal);
                JOptionPane.showMessageDialog(null,"Total Preis : "+preisTotalFinal+" € ","Result",JOptionPane.INFORMATION_MESSAGE);


            }
        });




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

    public List<String> process (JComboBox jComboBox, JTextField heightMasuer, JTextField weightMasuer, String[] matriealName, double[] matriealPries ){
        List<String> strList = new ArrayList<>();
        String changed_word = (String) jComboBox.getSelectedItem();
        int element_nu_of_changed_word_of_material_list ;
        element_nu_of_changed_word_of_material_list = getArrayIndex(matriealName,changed_word);
        String height_measure_in_string = heightMasuer.getText().toString();
        String weight_measure_in_string = weightMasuer.getText().toString();
        float height_measure_in_float = Float.valueOf(height_measure_in_string);
        float  weight_measure_in_float = Float.valueOf(weight_measure_in_string);
        float price_calculator = (float)((((height_measure_in_float * weight_measure_in_float)) * matriealPries[element_nu_of_changed_word_of_material_list]));
        strList.add(changed_word);
        strList.add(String.valueOf(price_calculator));
        return strList;
    }

    public int Calculator (JRadioButton jRadioButtonOne, JRadioButton jRadioButtonTwo ){
        int calNumber =0;

        if (jRadioButtonOne.isSelected()){
            jRadioButtonOne.setBackground(Color.green);
            jRadioButtonTwo.setBackground(Color.RED);
            calNumber = 2;
        } else if (jRadioButtonTwo.isSelected()) {
            jRadioButtonTwo.setBackground(Color.green);
            jRadioButtonOne.setBackground(Color.red);
            calNumber = 3;
        }else{
            System.err.printf(jRadioButtonTwo.getAction().toString());
        }
        return calNumber;
    }


}