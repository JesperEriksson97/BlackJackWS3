package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Card;
import BlackJack.model.Game;

public class PlayGame implements BlackJack.model.ICardDealtObserver {
	
  private IView a_view;
  private Game a_game;
  
  public PlayGame(IView a_view, Game a_game) {
	  this.a_view = a_view;
	  this.a_game = a_game;
	  a_game.getDealerObj().AddSubscriber(this);
  }
	
  public void CardDealt() {
		
	  try {
			Thread.sleep(1500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		a_view.DisplayDealerHand(a_game.getDealerObj().GetHand(), a_game.getDealerObj().CalcScore());
		a_view.DisplayPlayerHand(a_game.getPlayerObj().GetHand(), a_game.getPlayerObj().CalcScore());
  }	

  public boolean Play() {
    a_view.DisplayWelcomeMessage();
    
    // HERE THE PRINTING HAPPENS
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner());
    }

    int input = a_view.GetInput();
    
    if (input == a_view.getPlayButton())
    {
        a_game.NewGame();
    }
    else if (input == a_view.getHitButton())
    {
        a_game.Hit();
    }
    else if (input == a_view.getStandButton())
    {
        a_game.Stand();
    }

    return input != a_view.getQuitButton();
    }

}