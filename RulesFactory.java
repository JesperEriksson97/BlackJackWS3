package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    // return new BasicHitStrategy();
	return new Soft17Strategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IWinVariable GetWinVariable() {
	 // return new BasicWinVariable();
	  return new PlayerEqualWinVariable();
  }
}