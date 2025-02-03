package mynotepad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyNotepad extends JFrame implements ActionListener {

    JTextArea area;

    MyNotepad() {
        setTitle("Notepad");

        // Set Notepad icon
        ImageIcon notepad_icon = new ImageIcon(ClassLoader.getSystemResource("mynotepad/icons/notepad.png"));
        Image icon = notepad_icon.getImage();
        setIconImage(icon);

        // Menu bar setup
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);

        // File menu
        JMenu file = new JMenu("File");
        file.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem newdoc = new JMenuItem("New");
        newdoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newdoc.addActionListener(this);

        JMenuItem open = new JMenuItem("Open");
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        open.addActionListener(this);

        JMenuItem save = new JMenuItem("Save");
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        save.addActionListener(this);

        JMenuItem print = new JMenuItem("Print");
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        print.addActionListener(this);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, ActionEvent.CTRL_MASK));
        exit.addActionListener(this);

        file.add(newdoc);
        file.add(open);
        file.add(save);
        file.add(print);
        file.add(exit);
        menuBar.add(file);

        // Edit menu
        JMenu edit = new JMenu("Edit");
        edit.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem cut = new JMenuItem("Cut");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cut.addActionListener(this);

        JMenuItem copy = new JMenuItem("Copy");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copy.addActionListener(this);

        JMenuItem paste = new JMenuItem("Paste");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        paste.addActionListener(this);

        JMenuItem selectAll = new JMenuItem("Select All");
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        selectAll.addActionListener(this);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        menuBar.add(edit);

        // Help menu
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setFont(new Font("Arial", Font.BOLD, 14));

        JMenuItem help = new JMenuItem("Help");
        help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        help.addActionListener(this);
        helpMenu.add(help);
        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        // Text area setup
        area = new JTextArea();
        area.setFont(new Font("Consolas", Font.PLAIN, 14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        JScrollPane pane = new JScrollPane(area);
        add(pane);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();
        switch (command) {
            case "New":
                area.setText("");
                break;
            case "Exit":
                System.exit(0);
                break;
            case "Cut":
                area.cut();
                break;
            case "Copy":
                area.copy();
                break;
            case "Paste":
                area.paste();
                break;
            case "Select All":
                area.selectAll();
                break;
            // Additional cases for Open, Save, Print, and Help can be added here
            default:
                JOptionPane.showMessageDialog(this, "Feature not implemented");
        }
    }

    public static void main(String[] args) {
        new MyNotepad();
    }
}
