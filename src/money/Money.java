package money;

class Money {
	private double fAmount;
	private String fCurrency;
	private final static double PLNCHF = 3.95;
	private final static double PLNUSD = 3.80;
	
//	private final static double CHFPLN = 0.25;
	

	public Money(double amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	public double amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
	}

	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
	}

	public Money addDiffCurrency(Money m) {

		if (currency().equals("PLN") && m.currency().equals("PLN")) {
			return new Money((amount()) + (m.amount()), currency());
		}
		if (currency().equals("CHF") && m.currency().equals("CHF")) {
			return new Money((amount() * PLNCHF) + (m.amount() * PLNCHF), "PLN");
		}
		if (currency().equals("CHF") && m.currency().equals("PLN")) {
			return new Money((amount() * PLNCHF) + (m.amount()), "PLN");
		}
		if (currency().equals("PLN") && m.currency().equals("CHF")) {
			return new Money((amount()) + (m.amount() * PLNCHF), "PLN");
		}
		if (currency().equals("USD") && m.currency().equals("USD")) {
			return new Money((amount() * PLNUSD) + (m.amount() * PLNUSD), "PLN");
		}
		if (currency().equals("USD") && m.currency().equals("PLN")) {
			return new Money((amount() * PLNUSD) + (m.amount()), "PLN");
		}
		if (currency().equals("PLN") && m.currency().equals("USD")) {
			return new Money((amount()) + (m.amount() * PLNUSD), "PLN");
		}
		if (currency().equals("USD") && m.currency().equals("CHF")) {
			return new Money((amount() * PLNUSD) + (m.amount())*PLNCHF, "PLN");
		}
		if (currency().equals("CHF") && m.currency().equals("USD")) {
			return new Money((amount() * PLNCHF) + (m.amount() * PLNUSD), "PLN");
		}
		return null;
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;
			
			return a.currency().equals(currency()) && amount() == a.amount();
		}
		return false;

	}
	public boolean equalsDiffrentCurrencyAmount(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;
			if (currency().equals("CHF") && a.currency().equals("CHF")) {
				return amount() == a.amount();
			}
			if (currency().equals("PLN") && a.currency().equals("PLN")) {
				return amount() == a.amount();
			}
			if (currency().equals("USD") && a.currency().equals("USD")) {
				return amount() == a.amount();
			}
			if (currency().equals("CHF") && a.currency().equals("PLN")) {
				return amount()*PLNCHF == a.amount();
			}
			if (currency().equals("PLN") && a.currency().equals("CHF")) {
				return amount() == a.amount()*PLNCHF;
			}
			if (currency().equals("USD") && a.currency().equals("PLN")) {
				return amount()*PLNUSD == a.amount();
			}
			if (currency().equals("PLN") && a.currency().equals("USD")) {
				return amount()== a.amount()*PLNUSD;
			}		
			if (currency().equals("CHF") && a.currency().equals("USD")) {
				return amount()*PLNCHF == a.amount()*PLNUSD;
			}
			if (currency().equals("USD") && a.currency().equals("CHF")) {
				return amount()*PLNUSD == a.amount()*PLNCHF;
			}
		}
		return false;

	}
	
	public Money multiply(int i) {
		return new Money(amount() * i, currency());
	}
}