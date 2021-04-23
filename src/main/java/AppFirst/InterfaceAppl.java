package AppFirst;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InvalidObjectException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class InterfaceAppl {

    final static Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws InvalidObjectException, UnsupportedEncodingException {
        ArrayList<ZZR> list = new ArrayList<ZZR>();

        BaseJson baseJson = new BaseJson();
        String s = String.valueOf(baseJson.deserializatior());
        String s1 = new String(s.getBytes("ISO-8859-1"), "UTF-8");

        ZZR[] taskWorks = GSON.fromJson(s1, ZZR[].class);
        for (ZZR t : taskWorks) {
            ZZR zzr = new ZZR(t.getName(), t.getDv(), t.getVid());
            list.add(zzr);
        }
        System.out.println(list);


        JFrame window = new JFrame("Тест калькулятор");
        window.setBounds(5, 5, 500, 500);
        window.setLayout(null);
        JTextField a_Field = new JTextField();
        JTextField b_Field = new JTextField();
        a_Field.setBounds(5, 5, 350, 50);
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
                for (ZZR arrayList : list) {
                    if (arrayList.getName().toUpperCase().contains(a.toUpperCase())) {
                        label.setText(arrayList.getDv());
                        break;
                    } else if (!(arrayList.getName().toUpperCase().contains(a.toUpperCase()))) {
                        label.setText("ЗЗР не знайдено");
                    }
                }
            }
        };
        button.addActionListener(actionListener);
        window.setVisible(true);



    }
}


