package BlackJack.model.rules;

import BlackJack.model.Player;

public class BasicWinVariable implements IWinVariable {

	@Override
	public boolean whoWins(Player a_player, Player a_dealer, int g_maxScore) {
		 if (a_dealer.CalcScore() == a_player.CalcScore()) {
		      return true; // Dealer wins on equal
		    }
		 
		 return false;
	}
}
