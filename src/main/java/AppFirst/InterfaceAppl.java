package AppFirst;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceAppl {


    public static void main(String[] args) {
        ZZR zZros = new ZZR("Акріс, СЕ (10 л)", "диметенамід-П 280 г/л, тербутилазин 250 г/кг ","гербіцид");
        ZZR zZros1 = new ZZR("Амістар Голд 250 SC, к. с. (4х5 л)", "азоксистробін 125 г/л; дифеноконазол 125 г/л","фунгіцид");

        ArrayList<ZZR> list = new ArrayList<ZZR>();
        list.add(zZros);
        list.add(zZros1);


        JFrame window = new JFrame("Тест калькулятор");
        window.setBounds(5, 5, 500, 500);
        window.setLayout(null);

        JTextField a_Field = new JTextField();
        JTextField b_Field = new JTextField();
        a_Field.setBounds(5, 5, 150, 50);

        window.add(a_Field);
        window.add(b_Field);
        JButton button = new JButton("Інфа");
        button.setBounds(400, 5, 80, 50);
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.BLACK);
        window.add(button);
        JLabel label = new JLabel("ДВ");
        label.setBounds(5, 200, 450, 200);
        label.setBackground(Color.BLACK);
        window.add(label);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                a = a_Field.getText();
                for (ZZR arrayList: list){
                    if (arrayList.getName().toUpperCase().contains(a.toUpperCase())){
                        label.setText(arrayList.getDv().toString());

                    }
                }
            }
        };
        button.addActionListener(actionListener);
        window.setVisible(true);

    }
}


