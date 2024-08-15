package io.github.orionlibs.orion_currency;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencySymbolBO
{
    public static String getCurrencySymbolByCurrencyCode(CurrencyCode currencyCode)
    {
        try
        {
            return Currency.getInstance(getLocaleByCurrencyCode(currencyCode)).getSymbol();
        }
        catch(IllegalArgumentException e)
        {
            return null;
        }
    }


    public static String getCurrencySymbolByCurrencyCode(String currencyCode)
    {
        try
        {
            return Currency.getInstance(getLocaleByCurrencyCode(currencyCode)).getSymbol();
        }
        catch(IllegalArgumentException e)
        {
            return null;
        }
    }


    public static Locale getLocaleByCurrencyCode(CurrencyCode currencyCode)
    {
        return getLocaleByCurrencyCode(currencyCode.get());
    }


    public static Locale getLocaleByCurrencyCode(String currencyCode)
    {
        for(Locale locale : NumberFormat.getAvailableLocales())
        {
            String code = NumberFormat.getCurrencyInstance(locale).getCurrency().getCurrencyCode();
            if(currencyCode.equals(code))
            {
                return locale;
            }
        }
        return null;
    }
}