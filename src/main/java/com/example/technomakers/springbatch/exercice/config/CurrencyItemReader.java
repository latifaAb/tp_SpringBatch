package com.example.technomakers.springbatch.exercice.config;


import com.example.technomakers.springbatch.exercice.model.Currency;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;


public class CurrencyItemReader extends FlatFileItemReader<Currency> {
    public CurrencyItemReader() {
        setResource(new ClassPathResource("currency.csv"));
        setLinesToSkip(1);
        setLineMapper(new DefaultLineMapper<Currency>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("code", "symbol", "Name");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Currency>() {{
                setTargetType(Currency.class);
            }});
        }});
    }
}

