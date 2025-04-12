import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui extends JFrame implements ActionListener {
    oddoreven oregame;
    JLabel compchoice;
    JLabel compscore;
    JLabel playscore;

    gui() {
        //setting the title of the game
        setTitle("Odd or Even");
        //size of the screen
        setSize(450, 574);
        setLayout(null);
        //the game opens on middle everytime
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //a method to add the components
        addcomponents();
        setVisible(true);
        setResizable(false);
        oregame=new oddoreven();
    }

    private void addcomponents() {
        //score of the computer
        compscore = new JLabel("Computer:0");
        compscore.setBounds(0, 43, 450, 30);
        compscore.setHorizontalAlignment(SwingConstants.CENTER);
        add(compscore);
        compscore.setFont(new Font("Dialog", Font.BOLD, 26));
        //the computer choice
        compchoice = new JLabel("?");
        compchoice.setBounds(175, 118, 98, 81);
        compchoice.setHorizontalAlignment(SwingConstants.CENTER);
        compchoice.setFont(new Font("Dialog", Font.PLAIN, 18));
        compchoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(compchoice);

        //player score
        playscore = new JLabel("Player:0");
        playscore.setBounds(0, 317, 450, 30);
        playscore.setFont(new Font("Dialog", Font.BOLD, 26));
        playscore.setHorizontalAlignment(SwingConstants.CENTER);
        add(playscore);

        //buttons for the player to choose
        JButton b1 = new JButton("1");
        b1.setBounds(100, 450, 50, 50);
        b1.setFocusable(false);
        add(b1);
        b1.addActionListener(this);

        JButton b2 = new JButton("2");
        b2.setBounds(150, 450, 50, 50);
        b2.setFocusable(false);
        add(b2);
        b2.addActionListener(this);

        JButton b3 = new JButton("3");
        b3.setBounds(200, 450, 50, 50);
        b3.setFocusable(false);
        add(b3);
        b3.addActionListener(this);

        JButton b4 = new JButton("4");
        b4.setBounds(250, 450, 50, 50);
        b4.setFocusable(false);
        add(b4);
        b4.addActionListener(this);

        JButton b5 = new JButton("5");
        b5.setBounds(300, 450, 50, 50);
        b5.setFocusable(false);
        add(b5);
        b5.addActionListener(this);

        //odd or even buttons
        JButton odd = new JButton("ODD");
        odd.setBounds(150, 350, 75, 75);
        add(odd);
        odd.setFocusable(false);
        odd.addActionListener(this);

        JButton even = new JButton("EVEN");
        even.setBounds(250, 350, 75, 75);
        add(even);
        even.setFocusable(false);
        even.addActionListener(this);

    }

    //displays the result box
    private void displayresult(String message) {
        JDialog resultbox=new JDialog(this,"Result",true);
        resultbox.setSize(227,124);
        resultbox.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultbox.setResizable(false);
        resultbox.setLocationRelativeTo(this);

        JLabel text=new JLabel(message);
        text.setFont(new Font("Dialog",Font.BOLD,18));
        text.setHorizontalAlignment(SwingConstants.CENTER);
        resultbox.add(text,BorderLayout.CENTER);

        JButton tryg=new JButton("Try Again?");
        tryg.setFocusable(false);
        tryg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //resets the computers choice
                compchoice.setText("?");
                //sets the ore to null so we need to choose again after pressing tryagain
                oregame.setOre(null);
                //disposes the resultbox
                resultbox.dispose();
            }
        });
        resultbox.add(tryg,BorderLayout.SOUTH);
        compscore.setText("Computer:"+Integer.toString(oregame.getCompscore()));
        playscore.setText("Player:"+Integer.toString(oregame.getPlayscore()));
        resultbox.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String re;
        if(e.getActionCommand().equals("ODD")){
        oregame.set("ODD");
        }
        else if(e.getActionCommand().equals("EVEN")){
            oregame.set("EVEN");
        }
        else if(e.getActionCommand().equals("1")){
            re=oregame.choose(1);
            if(re!=null){
            oregame.setPlayerchoice(1);

            compchoice.setText(Integer.toString(oregame.getCompchoice()));
            displayresult(re);}
        }
        else if(e.getActionCommand().equals("2")){
            re=oregame.choose(2);
            //added this if condition so that resultbox will not be displayed if we did not select odd or even
            if(re!=null){
                oregame.setPlayerchoice(2);

                compchoice.setText(Integer.toString(oregame.getCompchoice()));
                displayresult(re);}
        }
        else if(e.getActionCommand().equals("3")){
            re=oregame.choose(3);
            if(re!=null){
                oregame.setPlayerchoice(3);

                compchoice.setText(Integer.toString(oregame.getCompchoice()));
                displayresult(re);}
        }
        else if(e.getActionCommand().equals("4")){
            re=oregame.choose(4);
            if(re!=null){
                oregame.setPlayerchoice(4);

                compchoice.setText(Integer.toString(oregame.getCompchoice()));
                displayresult(re);}
        }
        else if(e.getActionCommand().equals("5")){
            re=oregame.choose(5);
            if(re!=null){
                oregame.setPlayerchoice(5);

                compchoice.setText(Integer.toString(oregame.getCompchoice()));
                displayresult(re);}
        }

    }
}
