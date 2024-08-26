import javax.swing.*;
public class Main {
    public static void main(String[] args) throws Exception {
        int boardWidth=750;
        int boardHeight=250;

        JFrame frame=new JFrame("Dinosaurs");
        frame.setVisible(true);//window visible on the screen
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);//center of the computer
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dinosaur dinosaur=new Dinosaur();
        frame.add(dinosaur);
        frame.pack();//метод установки мин размера окна для отображения всего
        dinosaur.requestFocus();
        frame.setVisible(true);
    }
}