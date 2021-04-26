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


        JFrame window = new JFrame("ДОВІДНИК ЗАСОБІВ ЗАХИСТУ РОСЛИН");
        window.setBounds(5, 5, 500, 300);
        window.setLayout(null);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        JTextField a_Field = new JTextField();
        a_Field.setBounds(5, 5, 350, 30);
        window.add(a_Field);
        JButton button = new JButton("Інфо по ЗЗР");
        button.setBounds(360, 5, 120, 30);
        button.setBackground(Color.GREEN);
        button.setForeground(Color.BLACK);
        window.add(button);
        JLabel label = new JLabel("Діюча речовина");
        JLabel label1 = new JLabel("Вид ззр");
        JLabel label2 = new JLabel("Назва препарату");
        JLabel label100 = new JLabel("v.2.1");

        label2.setBounds(5, -55, 450, 200);
        label.setBounds(5, -30, 450, 200);
        label1.setBounds(5, -10, 450, 200);
        label100.setBounds(453, 225, 50, 50);

        label.setBackground(Color.BLACK);
        label1.setBackground(Color.BLACK);
        label2.setBackground(Color.BLACK);
        label100.setBackground(Color.BLACK);

        window.add(label);
        window.add(label1);
        window.add(label2);
        window.add(label100);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                a = a_Field.getText();
                int counter = 0;
                for (ZZR arrayList : list) {
                    if (arrayList.getName().toUpperCase().contains(a.toUpperCase())) {
                        label.setText(arrayList.getDv());
                        label1.setText(arrayList.getVid());
                        label2.setText(arrayList.getName().toUpperCase());
                        break;
                    } else if (!(arrayList.getName().toUpperCase().contains(a.toUpperCase()))) {
                        label.setText("");
                        label1.setText("");
                        label2.setText("ЗЗР не знайдено");
                    }
                }
            }
        };
        button.addActionListener(actionListener);
        window.setVisible(true);

    }
}


