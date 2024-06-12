package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Currency;
import com.example.technomakers.springbatch.exercice.model.Student;
import org.springframework.batch.item.ItemProcessor;

public class CurrencytItemProcessor implements ItemProcessor<Currency, Currency> {
    @Override
    public Currency process(Currency currency) throws Exception {
        if (currency.getSymbole().equals("") ){
            currency.setCode("nulle");

        }
        return currency;
    }
}
