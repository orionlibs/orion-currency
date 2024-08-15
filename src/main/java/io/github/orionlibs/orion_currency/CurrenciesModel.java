package io.github.orionlibs.orion_currency;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CurrenciesModel implements Serializable
{
    private List<CurrencyModel> currencies;


    public static CurrenciesModel of()
    {
        return CurrenciesModel.builder().build();
    }


    public static CurrenciesModel of(List<CurrencyModel> currencies)
    {
        return CurrenciesModel.builder().currencies(currencies).build();
    }
}