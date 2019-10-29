package BlackJack.model;

import java.util.ArrayList;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private Deck m_cast;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinVariable m_winVariable;
  private ArrayList<ICardDealtObserver> m_subscribers;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winVariable = a_rulesFactory.GetWinVariable();
    m_subscribers = new ArrayList<ICardDealtObserver>();
    m_cast = new Cast();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  public void AddSubscriber(ICardDealtObserver a_sub) {
	  
		m_subscribers.add(a_sub);
		  
  }
  
  public void RemoveSubscriber(ICardDealtObserver a_sub) {
	  
		m_subscribers.remove(a_sub);
		  
  }
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player, boolean b) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      HandOutCard(m_deck, b, a_player);
      NotifyObservers();
      return true;
    }
    return false;
  }

  private void NotifyObservers() {
	  for(ICardDealtObserver obs : m_subscribers) {
	      	obs.CardDealt();
	  }
  }

public boolean IsDealerWinner(Player a_player) {
	// Four standard win options in BlackJack, one of the two parts getting fat or one part have more than the other
	// If none works (even) the win variable will decide who wins. This one is changeable.
    if (a_player.CalcScore() > g_maxScore) {
      return true;
    } else if (CalcScore() > g_maxScore) {
      return false;
    } else if (CalcScore() > a_player.CalcScore()) {
      return true;
    } else if (CalcScore() < a_player.CalcScore()) {
      return false;
    } else {
      return m_winVariable.whoWins(a_player, this, g_maxScore);
    }
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  public boolean Stand() {
	  if(m_deck != null) {
		  this.ShowHand();
		  for(Card c : this.GetHand()) {
			m_cast.AddCard(c);
			c.Show(true);
		  }
		  
		  while (m_hitRule.DoHit(this)) {
			  Hit(this, true); 
		  }
		  return true;
	  }  else {
		  return false;
	  }
  }
  
  public void HandOutCard(Deck a_deck, boolean show, Player a_player) {
	    Card c;
	    c = a_deck.GetCard();
	    c.Show(show);
	    a_player.DealCard(c);
  }
  
}