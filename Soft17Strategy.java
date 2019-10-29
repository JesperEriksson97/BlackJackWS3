package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;
import BlackJack.model.Card.Value;

public class Soft17Strategy implements IHitStrategy {

	private final int g_hitLimit = 17;
	int m_dealerScore;
	
	public boolean DoHit(Player a_dealer) {
		m_dealerScore = a_dealer.CalcScore();
		
		/* Problem:
		 * - If we get an ace + 6 it works. But if we then get a hard 17 we still hit. Which shouldnt be the case.
		 * - How do we check for Hard 17?
		 */
		
		if(CheckIfAceIsPresent(a_dealer) && a_dealer.CalcScore() == g_hitLimit) {
			if (!checkForHard17(a_dealer)) {
				return true;
			}
		}
		
		return a_dealer.CalcScore() < g_hitLimit;  
	}
	
	public boolean CheckIfAceIsPresent(Player a_dealer) {
		for(Card c : a_dealer.GetHand()) {
			if(c.GetValue() == Value.Ace) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean checkForHard17(Player a_dealer) {
		int total = 0;
		for(Card c : a_dealer.GetHand()) {
			total += c.GetValue().ordinal();
		}
		
		if(total > 17 && a_dealer.CalcScore() == 17) {
			return true;
		} else {
			return false;
		}
	}

}
