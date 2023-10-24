package personal.learning.resources;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import personal.learning.model.entity.Currency;

@Provider
public class CurrencyParamConverterProvider implements ParamConverterProvider {

	@Override
	public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
		return new ParamConverter<T>() {

			@Override
			public T fromString(String code) {
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
				return (T) currency;
			}

			@Override
			public String toString(T currency) {
				return currency.toString();
			}
			
		};
	}

}
