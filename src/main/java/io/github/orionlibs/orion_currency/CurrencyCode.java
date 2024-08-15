package io.github.orionlibs.orion_currency;

import io.github.orionlibs.orion_enumeration.OrionEnumeration;

public enum CurrencyCode implements OrionEnumeration
{
    Euro("EUR"),
    BritishPound("GBP"),
    USDollar("USD");
    private String name;


    private CurrencyCode(String name)
    {
        setName(name);
    }


    @Override
    public String get()
    {
        return getName();
    }


    public String getName()
    {
        return this.name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    @Override
    public boolean is(OrionEnumeration other)
    {
        return other instanceof CurrencyCode && this == other;
    }


    @Override
    public boolean isNot(OrionEnumeration other)
    {
        return other instanceof CurrencyCode && this != other;
    }


    public static boolean valueExists(String other)
    {
        CurrencyCode[] values = values();
        for(CurrencyCode value : values)
        {
            if(value.get().equals(other))
            {
                return true;
            }
        }
        return false;
    }


    public static CurrencyCode getEnumForValue(String other)
    {
        CurrencyCode[] values = values();
        for(CurrencyCode value : values)
        {
            if(value.get().equals(other))
            {
                return value;
            }
        }
        return null;
    }
}