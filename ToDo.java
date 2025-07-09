import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ToDo implements ActionListener{
    public static void main(String[] args){
        /*  want to use JFrame/Swing to build a To Do list
        Need these things:
         * Button for completion (DONE)
         * button for deleting (DONE)
         * boxes that hold the "to do" values (DONE)
         * a box to type in the string that is wanted as a item (DONE)
         * some how hold the value in a string, probably some sort of reader object (DONE)
         * a title that says "TO DO" (DONE)
         * A scanner to take in the "to do" items (DONE)
         * 
         * 
         * Finished with main part of project, things that could be tweaked:
         * 
         * better UI
         * 
         * make things fill the first avaliable space instead of always going 
         * down by 30 pixels
         * 
         * 
         * 
         */

        // making basic window
        JFrame window = new JFrame("To Do List");
        window.setSize(500,400);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // I'm pretty sure this makes it so only set bounded things get added
        window.getContentPane().setLayout(null);

        // making title for the app
        JLabel title = new JLabel("To Do List");
        title.setBounds(180,10,340,75);
        title.setFont(new Font("Dialog",BOLD,26));
        window.add(title);

        // making text field for people to type in their lists
        JTextField itemTextField = new JTextField();
        // this value is going to be updated everytime a label is made or deleted
        final int[] itemYValue = {130};

        itemTextField.setBounds(130,100,220,20);
        itemTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                // makes button to for when the user completes their task
                JButton checkButton = new JButton("");
                checkButton.setBounds(155,itemYValue[0] +5,10,10);
                // gets text and makes a new label for it
                String userInput = itemTextField.getText();
                JLabel newItem = new JLabel(userInput);
                newItem.setBounds(175, itemYValue[0],100,20);
                newItem.setText(userInput);
                checkButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        window.remove(newItem);
                        window.remove(checkButton);
                        window.repaint();
                        window.revalidate();
                    }
                });
                // adds the changes and reloads the window
                window.add(newItem);
                window.add(checkButton);
                window.repaint();
                window.revalidate();
                // increments the y value so things don't overlap
                itemYValue[0] += 30;
                itemTextField.setText("");
            }
        });
        
        

        window.add(itemTextField);

        // making the add button
        JButton addButton = new JButton("Add");
        addButton.setBounds(350,100,60,20);
        /*  STILL IN PROGRESS: trying to make it save the input in the jtextfield
        and put that into a jlabel and put the label under the most current one;
        */
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 // makes button to for when the user completes their task
                JButton checkButton = new JButton("");
                checkButton.setBounds(155,itemYValue[0] +5,10,10);
                // gets text and makes a new label for it
                String userInput = itemTextField.getText();
                JLabel newItem = new JLabel(userInput);
                newItem.setBounds(175, itemYValue[0],100,20);
                newItem.setText(userInput);
                checkButton.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        window.remove(newItem);
                        window.remove(checkButton);
                        window.repaint();
                        window.revalidate();
                    }
                });
                // adds the changes and reloads the window
                window.add(newItem);
                window.add(checkButton);
                window.repaint();
                window.revalidate();
                // increments the y value so things don't overlap
                itemYValue[0] += 30;
                itemTextField.setText("");
            }
        });
        window.add(addButton);

        window.setVisible(true);
        
    }
}