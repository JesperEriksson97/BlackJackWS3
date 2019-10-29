package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IWinVariable {
	public boolean whoWins(Player a_player, Player a_dealer, int g_maxScore);
}
