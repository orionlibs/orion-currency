package io.github.orionlibs.orion_currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class CurrencyService
{
    private static CurrenciesModel currencies;

    static
    {
        currencies = CurrenciesModel.of(new ArrayList<>(CurrencyBO.getUniqueCurrencies()));
    }

    public static Currency getCurrencyByLocale(Locale locale)
    {
        return CurrencyBO.getCurrencyByLocale(locale);
    }


    public static String getCurrencySymbolByCurrencyCode(CurrencyCode currencyCode)
    {
        return CurrencySymbolBO.getCurrencySymbolByCurrencyCode(currencyCode);
    }


    public static String getCurrencySymbolByCurrencyCode(String currencyCode)
    {
        return CurrencySymbolBO.getCurrencySymbolByCurrencyCode(currencyCode);
    }


    public static Locale getLocaleByCurrencyCode(CurrencyCode currencyCode)
    {
        return getLocaleByCurrencyCode(currencyCode.get());
    }


    public static Locale getLocaleByCurrencyCode(String currencyCode)
    {
        return CurrencySymbolBO.getLocaleByCurrencyCode(currencyCode);
    }


    public static String formatCurrency(BigDecimal amount, Locale locale)// throws CurrencyFormatException
    {
        return CurrencyFormatterBO.formatCurrency(amount, locale);
    }


    public static String formatCurrency(BigDecimal amount, CurrencyCode currencyCode)// throws CurrencyFormatException
    {
        return CurrencyFormatterBO.formatCurrency(amount, currencyCode);
    }


    public static String formatCurrency(BigDecimal amount, String currencyCode)// throws CurrencyFormatException
    {
        return CurrencyFormatterBO.formatCurrency(amount, currencyCode);
    }


    public static String formatCurrency(long amount, Locale locale)// throws CurrencyFormatException
    {
        return CurrencyFormatterBO.formatCurrency(amount, locale);
    }


    public static String formatCurrency(long amount, CurrencyCode currencyCode)// throws CurrencyFormatException
    {
        return CurrencyFormatterBO.formatCurrency(amount, currencyCode);
    }


    public static String formatCurrency(long amount, String currencyCode)// throws CurrencyFormatException
    {
        return CurrencyFormatterBO.formatCurrency(amount, currencyCode);
    }


    public static String formatCurrencyWithoutCurrencySymbol(long amount)// throws CurrencyFormatException
    {
        return CurrencyFormatterBO.formatCurrency(amount).substring(1);
    }


    public static String formatCurrency(BigDecimal amount)// throws CurrencyFormatException
    {
        return formatCurrency(amount, Locale.UK);
    }


    public static String formatCurrency(long amount)// throws CurrencyFormatException
    {
        return formatCurrency(amount, Locale.UK);
    }


    public static int convertAmountToPence(BigDecimal amount) throws NumberFormatException
    {
        return CurrencyBO.convertAmountToPence(amount);
    }


    public static int convertFormattedAmountToPence(String amount) throws NumberFormatException
    {
        return CurrencyBO.convertFormattedAmountToPence(amount);
    }


    public static boolean doesFormattedAmountHaveCurrencySymbol(String amount)
    {
        return CurrencyBO.doesFormattedAmountHaveCurrencySymbol(amount);
    }


    public static CurrenciesModel getCurrencies()
    {
        return currencies;
    }
}