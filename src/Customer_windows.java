import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Customer_windows extends  JPanel {

    PulsMatierInfo smallJpanal1 =  new PulsMatierInfo();
    PulsMatierInfo smallJpanal2 =  new PulsMatierInfo();
    PulsMatierInfo smallJpanal3 =  new PulsMatierInfo();
    PulsMatierInfo smallJpanal4 =  new PulsMatierInfo();
    PulsMatierInfo smallJpanal5 =  new PulsMatierInfo();
    PulsMatierInfo smallJpanal6 =  new PulsMatierInfo();
    PulsMatierInfo smallJpanal7 =  new PulsMatierInfo();

    Info_keeper info_keeper = new Info_keeper();
     JButton button_calculator = new JButton("Rechnen");
     JTextArea text_result = new JTextArea();
     JScrollPane scrollPane_text_result = new JScrollPane(text_result);
 //   JRadioButton jRadioButtonA = new JRadioButton("A",true);
 //   JRadioButton jRadioButtonB = new JRadioButton("B");
    JLabel textDiscount = new JLabel("Discount");
    JTextField textFieldDiscount = new JTextField();
    JLabel textDiscountSymbol = new JLabel(" %" );
    ButtonGroup jRadioButtonABGroup = new ButtonGroup();

    public Customer_windows() throws IOException {
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
        button_calculator.setForeground(Color.BLUE);
        button_calculator.setFont(new Font("arial", Font.BOLD, 20));
        smallJpanal1.setBounds(00,10,700,70);
        smallJpanal2.setBounds(00,80,700,70);
        smallJpanal3.setBounds(00,150,700,70);
        smallJpanal4.setBounds(00,220,700,70);
        smallJpanal5.setBounds(00,290,700,70);
        smallJpanal6.setBounds(00,360,700,70);
        smallJpanal7.setBounds(00,430,700,70);
        textDiscount.setBounds(50,530, 70, 20 );
        textFieldDiscount.setBounds(120,530, 100, 20);
        textDiscountSymbol.setBounds(230,530, 100, 20);
//        jRadioButtonA.setBounds(350,500,50,70);
//        jRadioButtonB.setBounds(450,500,50,70);
        button_calculator.setBounds(30,600, 160, 70);
        scrollPane_text_result.setBounds(230, 600, 360, 100);

        this.setLayout(null);
        this.add(smallJpanal1);
        this.add(smallJpanal2);
        this.add(smallJpanal3);
        this.add(smallJpanal4);
        this.add(smallJpanal5);
        this.add(smallJpanal6);
        this.add(smallJpanal7);
        this.add(textDiscount);
        this.add(textFieldDiscount);
        this.add(textDiscountSymbol);
 //       this.add(jRadioButtonA);
 //       this.add(jRadioButtonB);
        this.add(button_calculator);
        this.add(scrollPane_text_result);
        this.setVisible(true);
//        jRadioButtonABGroup.add(jRadioButtonA);
//        jRadioButtonABGroup.add(jRadioButtonB);
        List<PulsMatierInfo>pulsMatierInfoList = new ArrayList<>();
        pulsMatierInfoList.add(smallJpanal1);
        pulsMatierInfoList.add(smallJpanal2);
        pulsMatierInfoList.add(smallJpanal3);
        pulsMatierInfoList.add(smallJpanal4);
        pulsMatierInfoList.add(smallJpanal5);
        pulsMatierInfoList.add(smallJpanal6);
        pulsMatierInfoList.add(smallJpanal7);


        // Button Calculator
        button_calculator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String>listNAmeMaterial= new ArrayList<>();
                List<Float>listmaterialPreis = new ArrayList<>();
                /*
                int workProcess = 1;
                if (jRadioButtonA.isSelected()){
                    workProcess =2;
                }else if (jRadioButtonB.isSelected()){

                    workProcess=3;
                }
                 */
                String result = "";
                for (PulsMatierInfo pmi:pulsMatierInfoList) {
                    if (pmi.text_height_measure.getText() != null && pmi.text_weight_measure.getText()!= null){
                        result += calMethd(pmi.material_list_box, material_list_name,pmi.text_height_measure, pmi.text_weight_measure,material_list_price);
                        listNAmeMaterial.add(calMethd(pmi.material_list_box, material_list_name,pmi.text_height_measure, pmi.text_weight_measure,material_list_price).get(0));
                        listmaterialPreis.add((float) Float.valueOf(calMethd(pmi.material_list_box, material_list_name,pmi.text_height_measure, pmi.text_weight_measure,material_list_price).get(1)));
                    }
                }

                float discount ;
                    if (textFieldDiscount.getText().isEmpty()){
                        discount = 0.0F;
                    }else {
                        discount = Float.valueOf(textFieldDiscount.getText().toString());
                    }


                String resultTestOutput = "Result is it ";
                String resultText ="";
                float totlaPreis = 0.0f;
                for(int i=0;i<listmaterialPreis.size();i++){
                    if (listmaterialPreis.get(i)!= 0.00){
                        resultText+= listNAmeMaterial.get(i).toString()+" = "+listmaterialPreis.get(i)+"\n";
                        totlaPreis+= listmaterialPreis.get(i);
                    }
                }

//                float fialPreis = (totlaPreis * workProcess) + 10;
                float discountPries = ((discount * totlaPreis)/100);
                float preisTotalFinal = totlaPreis - discountPries;
                text_result.setText(resultText+"\nTotal Preis : "+preisTotalFinal+" € ");
                System.out.println("discount : "+discount);
                System.out.println("fialPreis : " +totlaPreis);
                System.out.println("discountPries : "+discountPries);
                System.out.println(resultText+"preisTotalFinal : "+preisTotalFinal);
                JOptionPane.showMessageDialog(null,resultText+"\nTotal Preis : "+preisTotalFinal+" € ","Result",JOptionPane.INFORMATION_MESSAGE);
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

        public List<String> calMethd(JComboBox ma, String[] MatName, JTextField masuerHeight, JTextField masuerWeight ,double [] material_list){
            List<String> SectionOfResults = new ArrayList<>();

            String changed_word = (String) ma.getSelectedItem();
            int element_nu_of_changed_word_of_material_list ;
            element_nu_of_changed_word_of_material_list = getArrayIndex(MatName,changed_word);
            float height_measure_in_float = preisCheck(masuerHeight);
            float weight_measure_in_float = preisCheck(masuerWeight);
            float price_calculator = (float)(((height_measure_in_float * weight_measure_in_float) * material_list[element_nu_of_changed_word_of_material_list]));
            String  result = "Result is it \n"+ price_calculator+" €";
            SectionOfResults.add(changed_word);
            SectionOfResults.add(String.valueOf(price_calculator));
            return SectionOfResults;
        }

        public float preisCheck (JTextField text){
        String inputText = text.getText().toString();
        if (inputText.isEmpty()){
            return 0.00F;
        }else if (!inputText.isEmpty()){
            return Float.valueOf(text.getText().toString());
        }else {
            return 0.00F;
        }
        }

    }






