package clients.cashier;

import catalogue.*;
import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;

/**
 * The Improved Cashier Client
 * @author  Jayanshi Rawat
 * @version 1.0
 */
public class BetterCashierModel extends CashierModel
{

	public BetterCashierModel(MiddleFactory mf) 
	{
		super(mf);
	}

	//Override makeBasket() to return BetterBasket()
	@Override
    public BetterBasket makeBasket() 
	{
        return new BetterBasket();
    }
  
}
