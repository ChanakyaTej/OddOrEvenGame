import javax.swing.*;
import java.util.Random;

//backend
public class oddoreven {
    private static final int computerchoices[] = {1, 2, 3, 4, 5};
    private Random random;
    private int compchoice;

    public int getCompchoice() {
        return compchoice;
    }

    public int getPlayerchoice() {
        return playerchoice;
    }

    public int getPlayscore() {
        return playscore;
    }

    public int getCompscore() {
        return compscore;
    }

    public void setPlayerchoice(int playerchoice) {
        this.playerchoice = playerchoice;
    }

    private int playerchoice;
    private int playscore = 0;
    private int compscore = 0;

    public String getOre() {
        return ore;
    }

    public void setOre(String ore) {
        this.ore = ore;
    }

    private String ore=null;

    oddoreven() {
        random = new Random();
    }

    public void set(String x){
        ore=x;
    }

    public String choose(int playerchoice) {
        compchoice=computerchoices[random.nextInt(computerchoices.length)];
         String result=null;

        if (ore==null) {
            JOptionPane.showMessageDialog(null, "Select odd or even");
        } else if (ore.equals("ODD")) {
            if((playerchoice+compchoice)%2==0){
                result="Computer Wins";
                compscore++;
            }
            else{
                result="Player Wins";
                playscore++;
            }
        }
        else{
            if((playerchoice+compchoice)%2==0){
                result="Player Wins";
            playscore++;
            }
            else{
                result="Computer Wins";
            compscore++;
            }
        }
        return result;
    }


}
