import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI {

    JButton ChooseIn, ChooseOut, RunButton;
    JFileChooser InputChooser, OutputChooser;
    JRadioButton E, D, Override, NewFile;
    JTextField CurrentPath, ToPath, Key;
    JFrame mainFrame;

    int InReturn, OutReturn;

    public void UI() {
        ChooseIn = new JButton("Choose File");
        ChooseOut = new JButton("Choose File");
        RunButton = new JButton(("Run"));
        InputChooser = new JFileChooser();
        OutputChooser = new JFileChooser();
        mainFrame = new JFrame("Vigenère cipher tool");


        SpringLayout sr = new SpringLayout();
        JPanel mainPanel = new JPanel(sr);
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        Font title = new Font("Consolas", Font.BOLD, 20);
        Font font = new Font("Consolas", Font.PLAIN, 14);
        Font bold = new Font("Consolas", Font.BOLD, 14);
        Font bigBold = new Font("Consolas", Font.BOLD, 18);

        Dimension ButtonSize = new Dimension(130, 25);
        Dimension BigButtonSize = new Dimension(110, 30);
        Dimension RadioSize = new Dimension(100, 15);
        Dimension LabelSize = new Dimension(110, 15);
        Dimension LongRadioSize = new Dimension(160, 15);
        Dimension ShortRadioSize = new Dimension(85, 15);

        JLabel Title = new JLabel("Vigenère Cipher Tool");
        JLabel CurrentPathLabel = new JLabel("Source:");
        JLabel ToPathLabel = new JLabel("Destination:");
        JLabel KeyLabel = new JLabel("Key:");
        Title.setFont(title);
        CurrentPathLabel.setFont(bold);
        CurrentPathLabel.setPreferredSize(LabelSize);
        ToPathLabel.setFont(bold);
        ToPathLabel.setPreferredSize(LabelSize);
        KeyLabel.setFont(bold);
        KeyLabel.setPreferredSize(LabelSize);


        ChooseIn.setPreferredSize(ButtonSize);
        ChooseIn.setFont(bold);
        ChooseOut.setPreferredSize(ButtonSize);
        ChooseOut.setFont(bold);
        RunButton.setPreferredSize(BigButtonSize);
        RunButton.setFont(bigBold);

        ButtonGroup EorD = new ButtonGroup();
        E = new JRadioButton("Encrypt", true);
        D = new JRadioButton("Decrypt", false);
        E.setFont(font);
        E.setPreferredSize(ShortRadioSize);
        D.setPreferredSize(ShortRadioSize);
        D.setFont(font);
        EorD.add(E);
        EorD.add(D);

        ButtonGroup OverOrNew = new ButtonGroup();
        Override = new JRadioButton("Override", true);
        NewFile = new JRadioButton("Save as new file", false);
        Override.setFont(font);
        Override.setPreferredSize(RadioSize);
        NewFile.setPreferredSize(LongRadioSize);
        NewFile.setFont(font);
        OverOrNew.add(Override);
        OverOrNew.add(NewFile);

        CurrentPath = new JTextField();
        ToPath = new JTextField();
        Key = new JTextField();
        CurrentPath.setFont(font);
        ToPath.setFont(font);
        Key.setFont(font);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Documents", "txt");

        sr.putConstraint(SpringLayout.NORTH, Title, 0, SpringLayout.NORTH, mainPanel);
        sr.putConstraint(SpringLayout.HORIZONTAL_CENTER, Title, 0, SpringLayout.HORIZONTAL_CENTER, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, E, 20, SpringLayout.SOUTH, Title);
        sr.putConstraint(SpringLayout.EAST, E, 5, SpringLayout.HORIZONTAL_CENTER, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, D, 0, SpringLayout.NORTH, E);
        sr.putConstraint(SpringLayout.WEST, D, 5, SpringLayout.HORIZONTAL_CENTER, mainPanel);

        sr.putConstraint(SpringLayout.WEST, CurrentPathLabel, 0, SpringLayout.WEST, mainPanel);
        sr.putConstraint(SpringLayout.NORTH, CurrentPathLabel, 24, SpringLayout.SOUTH, E);

        sr.putConstraint(SpringLayout.NORTH, CurrentPath, 20, SpringLayout.SOUTH, E);
        sr.putConstraint(SpringLayout.WEST, CurrentPath, 10, SpringLayout.EAST, CurrentPathLabel);
        sr.putConstraint(SpringLayout.EAST, CurrentPath, 0, SpringLayout.EAST, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, ChooseIn, 5, SpringLayout.SOUTH, CurrentPath);
        sr.putConstraint(SpringLayout.EAST, ChooseIn, 0, SpringLayout.EAST, mainPanel);

        sr.putConstraint(SpringLayout.EAST, Override, 5, SpringLayout.HORIZONTAL_CENTER, mainPanel);
        sr.putConstraint(SpringLayout.NORTH, Override, 20, SpringLayout.SOUTH, ChooseIn);

        sr.putConstraint(SpringLayout.WEST, NewFile, 5, SpringLayout.HORIZONTAL_CENTER, mainPanel);
        sr.putConstraint(SpringLayout.NORTH, NewFile, 20, SpringLayout.SOUTH, ChooseIn);

        sr.putConstraint(SpringLayout.NORTH, ToPathLabel, 24, SpringLayout.SOUTH, NewFile);
        sr.putConstraint(SpringLayout.WEST, ToPathLabel, 0, SpringLayout.WEST, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, ToPath, 20, SpringLayout.SOUTH, NewFile);
        sr.putConstraint(SpringLayout.WEST, ToPath, 10, SpringLayout.EAST, ToPathLabel);
        sr.putConstraint(SpringLayout.EAST, ToPath, 0, SpringLayout.EAST, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, ChooseOut, 5, SpringLayout.SOUTH, ToPath);
        sr.putConstraint(SpringLayout.EAST, ChooseOut, 0, SpringLayout.EAST, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, KeyLabel, 24, SpringLayout.SOUTH, ChooseOut);
        sr.putConstraint(SpringLayout.WEST, KeyLabel, 0, SpringLayout.WEST, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, Key, 20, SpringLayout.SOUTH, ChooseOut);
        sr.putConstraint(SpringLayout.WEST, Key, 10, SpringLayout.EAST, KeyLabel);
        sr.putConstraint(SpringLayout.EAST, Key, 0, SpringLayout.EAST, mainPanel);

        sr.putConstraint(SpringLayout.NORTH, RunButton, 30, SpringLayout.SOUTH, Key);
        sr.putConstraint(SpringLayout.HORIZONTAL_CENTER, RunButton, 0, SpringLayout.HORIZONTAL_CENTER, mainPanel);

        ChooseIn.addActionListener(new ButtonListener());
        ChooseOut.addActionListener(new ButtonListener());
        RunButton.addActionListener(new ButtonListener());
        E.addActionListener(new ButtonListener());
        D.addActionListener(new ButtonListener());
        Override.addActionListener(new ButtonListener());
        NewFile.addActionListener(new ButtonListener());

        InputChooser.setFileFilter(filter);
        OutputChooser.setFileFilter(filter);

        mainPanel.add(Title);
        mainPanel.add(E);
        mainPanel.add(D);
        mainPanel.add(CurrentPathLabel);
        mainPanel.add(CurrentPath);
        mainPanel.add(ChooseIn);
        mainPanel.add(Override);
        mainPanel.add(NewFile);
        mainPanel.add(ToPathLabel);
        mainPanel.add(ToPath);
        mainPanel.add(ChooseOut);
        mainPanel.add(KeyLabel);
        mainPanel.add(Key);
        mainPanel.add(RunButton);

        ToPath.setEnabled(false);
        ChooseOut.setEnabled(false);

        mainFrame.add(mainPanel);

        mainFrame.setSize(600, 420);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ChooseIn) {
                InReturn = InputChooser.showDialog(mainFrame, "Select");
                if (InReturn == JFileChooser.APPROVE_OPTION) {
                    CurrentPath.setText(InputChooser.getSelectedFile().getAbsolutePath());
                }
            } else if (e.getSource() == ChooseOut) {
                OutReturn = OutputChooser.showDialog(mainFrame, "Choose");
                if (OutReturn == JFileChooser.APPROVE_OPTION) {
                    ToPath.setText(OutputChooser.getSelectedFile().getAbsolutePath());
                }
            } else if (e.getSource() == RunButton) {
                mainClass main = new mainClass();
                String toPath = ToPath.getText();
                if (NewFile.isSelected()) {
                    if (toPath.lastIndexOf(".") == -1) {
                        JOptionPane.showMessageDialog(mainFrame, "Error: Please enter a valid path to a valid .txt file", "Error: Invalid Path", JOptionPane.ERROR_MESSAGE);
                    } else if ((!toPath.substring(toPath.lastIndexOf('.')).equals(".txt"))) {
                        JOptionPane.showMessageDialog(mainFrame, "Error: Please enter the path to a .txt file only", "Error: Invalid Path", JOptionPane.ERROR_MESSAGE);
                    } else if (Key.getText() == null || !isEnglish(Key.getText())) {
                        JOptionPane.showMessageDialog(mainFrame, "Error: Please enter a valid key (letters only)", "Error: Invalid Key", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            main.execute(E.isSelected(), Override.isSelected(), CurrentPath.getText(), ToPath.getText(), Key.getText());
                            JOptionPane.showMessageDialog(mainFrame, "Success: Operation Successful", "Success", JOptionPane.PLAIN_MESSAGE);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(mainFrame, "Error: The source file does not exist or cannot be read", "Error: File not exist", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    if (Key.getText() == null || !isEnglish(Key.getText())) {
                        JOptionPane.showMessageDialog(mainFrame, "Error: Please enter a valid key (letters only)", "Error: Invalid Key", JOptionPane.ERROR_MESSAGE);
                    } else {
                        try {
                            main.execute(E.isSelected(), Override.isSelected(), CurrentPath.getText(), ToPath.getText(), Key.getText());
                            JOptionPane.showMessageDialog(mainFrame, "Success: Operation Successful", "Success", JOptionPane.PLAIN_MESSAGE);
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(mainFrame, "Error: The source file does not exist or cannot be read", "Error: File not exist", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else if (e.getSource() == E) {
            } else if (e.getSource() == D) {
            } else if (e.getSource() == Override) {
                ToPath.setEnabled(false);
                ChooseOut.setEnabled(false);
            } else if (e.getSource() == NewFile) {
                ToPath.setEnabled(true);
                ChooseOut.setEnabled(true);
            }
        }

        boolean isEnglish(String str) {
            for (int i = 0; i < str.length(); i++) {
                if (!(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') && !(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
                    return false;
                }
            }
            return true;
        }
    }
}
