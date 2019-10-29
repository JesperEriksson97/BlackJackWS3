package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;
// import BlackJack.model.Card;  

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
	// Card c; the refactoring of code duplication removes the association InternationalNewGameStrategy to Card

	  a_dealer.Hit(a_player, true);
	  a_dealer.Hit(a_dealer, true);
	  a_dealer.Hit(a_player, true);
	  a_dealer.Hit(a_dealer, false);
	  
    /*a_dealer.HandOutCard(a_deck, true, a_player);
    a_dealer.HandOutCard(a_deck, true, a_dealer);
    a_dealer.HandOutCard(a_deck, true, a_player);
    a_dealer.HandOutCard(a_deck, false, a_dealer);*/
    /*c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);

    c = a_deck.GetCard();
    c.Show(true);
    a_dealer.DealCard(c);

    c = a_deck.GetCard();
    c.Show(true);
    a_player.DealCard(c);

    c = a_deck.GetCard();
    c.Show(false);
    a_dealer.DealCard(c);*/

    return true;
  }
}