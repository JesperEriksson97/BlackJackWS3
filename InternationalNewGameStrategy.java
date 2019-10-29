package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player; 
//import BlackJack.model.Card;

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    // Card c; the refactoring of code duplication removes the association InternationalNewGameStrategy to Card
	  
	 a_dealer.Hit(a_player, true);
	 a_dealer.Hit(a_dealer, true);
	 a_dealer.Hit(a_player, true);
	  
	  
    /*a_dealer.HandOutCard(a_deck, true, a_player);
    a_dealer.HandOutCard(a_deck, true, a_dealer);
    a_dealer.HandOutCard(a_deck, true, a_player);*/
    
    /*c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);
  
    c = a_deck.GetCard();
    c.Show(true);
    a_dealer.DealCard(c);
  
    c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);*/
  
    return true;
  }
}