package io.github.orionlibs.orion_currency;

import io.github.orionlibs.orion_currency.tasks.FormatCurrencyTask;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

public class CurrencyFormatterBO
{
    public static String formatCurrency(BigDecimal amount, Locale locale)// throws CurrencyFormatException
    {
        return FormatCurrencyTask.run(amount, locale);
    }


    public static String formatCurrency(BigDecimal amount, CurrencyCode currencyCode)// throws CurrencyFormatException
    {
        return FormatCurrencyTask.run(amount, CurrencyService.getLocaleByCurrencyCode(currencyCode));
    }


    public static String formatCurrency(BigDecimal amount, String currencyCode)// throws CurrencyFormatException
    {
        return FormatCurrencyTask.run(amount, CurrencyService.getLocaleByCurrencyCode(currencyCode));
    }


    public static String formatCurrency(long amount, Locale locale)// throws CurrencyFormatException
    {
        return FormatCurrencyTask.run(amount, locale);
    }


    public static String formatCurrency(long amount, CurrencyCode currencyCode)// throws CurrencyFormatException
    {
        return FormatCurrencyTask.run(amount, CurrencyService.getLocaleByCurrencyCode(currencyCode));
    }


    public static String formatCurrency(long amount, String currencyCode)// throws CurrencyFormatException
    {
        return FormatCurrencyTask.run(amount, CurrencyService.getLocaleByCurrencyCode(currencyCode));
    }


    public static String formatCurrencyWithoutCurrencySymbol(long amount)// throws CurrencyFormatException
    {
        BigDecimal amountTemp = null;
        long tempAmount = Math.abs(amount);
        if(amount < 100)
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
            String amountString = Long.toString(amount);
            amountTemp = new BigDecimal(amountString.substring(0, amountString.length() - 2) + "." + amountString.substring(amountString.length() - 2));
        }
        return new DecimalFormat("###,###,##0.00").format(amountTemp.doubleValue());
    }


    public static String formatCurrency(BigDecimal amount)// throws CurrencyFormatException
    {
        return formatCurrency(amount, Locale.UK);
    }


    public static String formatCurrency(long amount)// throws CurrencyFormatException
    {
        return formatCurrency(amount, Locale.UK);
    }
}