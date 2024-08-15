package io.github.orionlibs.orion_currency.tasks;

import io.github.orionlibs.orion_assert.Assert;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class FormatCurrencyTask
{
    public static String run(BigDecimal amount, Locale locale)// throws CurrencyFormatException
    {
        Assert.notNull(amount, "amount input cannot be null.");
        Assert.notNull(locale, "locale input cannot be null.");
        try
        {
            return DecimalFormat.getCurrencyInstance(locale).format(amount);
        }
        catch(IllegalArgumentException e)
        {
            //throw new CurrencyFormatException(e.getMessage());
        }
        return "";
    }


    public static String run(long amount, Locale locale)// throws CurrencyFormatException
    {
        Assert.notNull(locale, "locale input cannot be null.");
        BigDecimal amountTemp = null;
        long tempAmount = Math.abs(amount);
        if(tempAmount < 100)
        {
            if(tempAmount == 0L)
            {
                amountTemp = new BigDecimal("0.00");
            }
            else if(tempAmount < 10)
            {
                amountTemp = new BigDecimal("0.0" + Long.toString(tempAmount));
            }
            else
            {
                amountTemp = new BigDecimal("0." + Long.toString(tempAmount));
            }
        }
        else
        {
            String amountString = Long.toString(tempAmount);
            amountTemp = new BigDecimal(amountString.substring(0, amountString.length() - 2) + "." + amountString.substring(amountString.length() - 2));
        }
        try
        {
            String result = DecimalFormat.getCurrencyInstance(locale).format(amountTemp);
            if(amount < 0L)
            {
                return "-" + result;
            }
            else
            {
                return result;
            }
        }
        catch(IllegalArgumentException e)
        {
            //throw new CurrencyFormatException(e.getMessage());
        }
        return "";
    }
}