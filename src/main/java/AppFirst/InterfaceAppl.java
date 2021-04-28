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
            ZZR zzr = new ZZR(t.getName(), t.getDv(), t.getVid(), t.getVirobnik(), t.getNormaVneseniy(), t.getKultura(), t.getSpectr());
            list.add(zzr);
        }
        System.out.println(list);


        JFrame window = new JFrame("ДОВІДНИК ЗАСОБІВ ЗАХИСТУ РОСЛИН");
        window.setBounds(5, 5, 500, 400);
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
        window.getRootPane().setDefaultButton(button);
        window.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("ENTER"), "none");
        window.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(KeyStroke.getKeyStroke("released ENTER"), "press");
        window.add(button);

        JLabel label = new JLabel("Назва препарату");
        JLabel label1 = new JLabel("Вид ззр");
        JLabel label2 = new JLabel("Діюча речовина");
        JLabel label100 = new JLabel("v.3.0");
        JLabel label3 = new JLabel("Виробник");
        JLabel label4 = new JLabel("Норма внесення");
        JLabel label5 = new JLabel("Культура");
        JLabel label6 = new JLabel("Спектр шкідливих об*єктів");

        label.setBounds(5, -50, 450, 200); // назва
        label1.setBounds(5, -30, 450, 200); // вид
        label3.setBounds(5, -10, 450, 200); //Виробник
        label4.setBounds(5, 10, 450, 200); //Норма внесення
        label5.setBounds(5, 40, 450, 300); //культура
        label2.setBounds(5, 10, 450, 280); //ДВ
        label6.setBounds(5, 120, 450, 300); // спектр

        label100.setBounds(453, 325, 50, 50);
        Font font = new Font("Arial", Font.BOLD, 12);

        label.setFont(font);
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
        label6.setFont(font);


        label.setBackground(Color.BLACK);
        label1.setBackground(Color.BLACK);
        label2.setBackground(Color.BLACK);
        label3.setBackground(Color.BLACK);
        label4.setBackground(Color.BLACK);
        label5.setBackground(Color.BLACK);
        label6.setBackground(Color.BLACK);
        label100.setBackground(Color.BLACK);

        window.add(label);
        window.add(label1);
        window.add(label2);
        window.add(label3);
        window.add(label4);
        window.add(label5);
        window.add(label6);
        window.add(label100);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a, b;
                a = a_Field.getText();
                for (ZZR arrayList : list) {
                    if (arrayList.getName().toUpperCase().contains(a.toUpperCase())) {
                        label.setText("<html>Назва препарату: " + arrayList.getName().toUpperCase() + "</html>");
                        label2.setText("<html>Діюча речовина: " + arrayList.getDv() + "</html>");
                        label1.setText("<html>Вид ззр: " + arrayList.getVid() + "</html>");
                        label3.setText("<html>Виробник: " + arrayList.getVirobnik() + "</html>");
                        label4.setText("<html>Норма внесення: " + arrayList.getNormaVneseniy() + "</html>");
                        label5.setText("<html>Культура: " + arrayList.getKultura() + "</html>");
                        label6.setText("<html>Спектр шкідливих об*єктів: " + arrayList.getSpectr() + "</html>");
                        break;
                    } else if (!(arrayList.getName().toUpperCase().contains(a.toUpperCase()))) {
                        label2.setText("");
                        label1.setText("");
                        label.setText("ЗЗР не знайдено");
                        label3.setText("");
                        label4.setText("");
                        label5.setText("");
                        label6.setText("");
                    }
                }
            }
        };
        button.addActionListener(actionListener);
        window.setVisible(true);

    }
}


