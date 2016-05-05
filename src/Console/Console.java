package Console;

import java.awt.event.ActionEvent;
import javax.swing.*;
import Game.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Dragos-Alexandru
 */
public class Console extends JFrame{
    private static Console instance;
    private final JTextArea output;
    private final JTextField textInput;
    private final JButton buttonInput;
    private final JScrollPane scroll;
    private final String senderName = "Console";
    private Console(){
        
        super("Village - Console 0.01 Alpha");
        this.setSize(400,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        output = new JTextArea();
        scroll = new JScrollPane(output);
        scroll.setPreferredSize(new Dimension(20, this.HEIGHT));
        output.setEditable(false);
        textInput = new JTextField();
        textInput.setEditable(true);
        buttonInput = new JButton("SEND");
        buttonInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(!textInput.getText().isEmpty()){
                    Game theGame = Game.getInstance();
                    theGame.sendCommand(textInput.getText());
                    print(senderName,"<"+textInput.getText()+">");
                    textInput.setText("");
                }
            }
        });
        this.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.add(output,BorderLayout.CENTER);
        outputPanel.add(scroll,BorderLayout.EAST);
        inputPanel.setLayout(new BorderLayout());
        this.add(outputPanel,BorderLayout.CENTER);
        
        inputPanel.add(textInput,BorderLayout.CENTER);
        inputPanel.add(buttonInput,BorderLayout.EAST);
        this.add(inputPanel,BorderLayout.SOUTH);
        
        this.pack();
        this.setVisible(true);
        
        print(senderName,"Created");
    }
    public static Console getInstance(){
        if(instance == null){
            instance = new Console();
        }
        return instance;
    }
    
    public final void print(String sender, String message){
        output.append(sender+": " + message+"\n");
        this.pack();
    }
    
}
