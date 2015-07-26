package solutioncode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class RockPaperScissorsListener implements ActionListener{

    RockPaperScissors model;

    JLabel playerChoiceLabel;
    JLabel computerChoiceLabel;
    JLabel outcomeLabel;

    JButton rockButton;
    JButton paperButton;
    JButton scissorsButton;

    JLabel winsLabel;
    JLabel lossesLabel;
    JLabel tiesLabel;

    public RockPaperScissorsListener(JLabel playerChoiceLabel, JLabel computerChoiceLabel, JLabel outcomeLabel,
            JButton rockButton, JButton paperButton, JButton scissorsButton,
            JLabel winsLabel, JLabel lossesLabel, JLabel tiesLabel){

        this.model = new RockPaperScissors();

        this.playerChoiceLabel = playerChoiceLabel;
        this.computerChoiceLabel = computerChoiceLabel;
        this.outcomeLabel = outcomeLabel;
        this.rockButton = rockButton;
        this.paperButton = paperButton;
        this.scissorsButton = scissorsButton;
        this.winsLabel = winsLabel;
        this.lossesLabel = lossesLabel;
        this.tiesLabel = tiesLabel;

    }

    public void actionPerformed(ActionEvent e) {

        int humanMove;
        int computerMove;

        if(e.getSource() == rockButton){
            humanMove = RockPaperScissors.ROCK;
        }
        else if(e.getSource() == paperButton){
        	humanMove = RockPaperScissors.PAPER;
        }
        else if(e.getSource() == scissorsButton){
        	humanMove = RockPaperScissors.SCISSORS;
        }

        computerMove = RockPaperScissors.getComputerMove();

        //update the outcome labels
        //playerChoiceLabel.setText("You chose " + playerChoice + ".");
        //computerChoiceLabel.setText("CPU chose " + computerChoice + ".");

        //who won?
        //RockPaperScissors.GameOutcome outcome = model.getGameOutcome(playerChoice, computerChoice);

        //if(outcome == RockPaperScissorsModel.GameOutcome.WIN){
           // outcomeLabel.setText("You won the game!");
       // }
       // else if(outcome == RockPaperScissorsModel.GameOutcome.LOSE){
          //  outcomeLabel.setText("The computer won the game!");
       // }
        //else{
        //    outcomeLabel.setText("The game was a tie!");
      //  }

        //update the totals labels
        //winsLabel.setText("Wins: " + model.getWins());
        //lossesLabel.setText("Losses: " + model.getLosses());
        //tiesLabel.setText("Ties: " + model.getTies());

    }

}