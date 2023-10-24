package personal.learning.resources;

import javax.ws.rs.ext.ParamConverter;

import personal.learning.model.entity.Currency;

public class CurrencyParamConverter implements ParamConverter<Currency> {

	@Override
	public Currency fromString(String code) {
		Currency currency = null;
		switch(code) {
			case "EUR":
				currency = new Currency(code, "Euro");
			break;
			case "USD":
				currency = new Currency(code, "US Dollar");
			break;
			case "INR":
				currency = new Currency(code, "Indian Rupees");
			break;
			default:
				currency = new Currency(code, "Unknown currency");
			break;
		}
		return currency;
	}

	@Override
	public String toString(Currency currency) {
		return currency.toString();
	}

}
