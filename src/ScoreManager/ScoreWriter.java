package ScoreManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ScoreWriter extends JFrame {
    private JTextField nameTextField;
    private JButton saveButton;

    public ScoreWriter() {
        setTitle("Score Writer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("기록을 저장하실 이름을 입력해주세요: ");
        nameTextField = new JTextField(10);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveScoreToFile();
            }
        });

        add(nameLabel);
        add(nameTextField);
        add(saveButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void saveScoreToFile() {
        String name = nameTextField.getText();
        int score = 0; // score점수는 일단 0으로 설정하였습니다.

        try {
            PrintWriter writer = new PrintWriter(new FileWriter("score.txt", true));
            writer.println(name + ":" + score);
            writer.close();
            JOptionPane.showMessageDialog(this, "입력이 파일에 저장되었습니다.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "파일에 입력을 저장하는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ScoreWriter::new);
    }
}
