package com.example.technomakers.springbatch.exercice.config;

import com.example.technomakers.springbatch.exercice.model.Currency;
import com.example.technomakers.springbatch.exercice.model.Student;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.file.transform.FieldExtractor;
import org.springframework.core.io.FileSystemResource;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CurrencytItemWriter extends FlatFileItemWriter<Currency> {

    private static final String HEADER = "Code,Symbol,Name";
    private static final String FILE_NAME = "edited_currency.csv"; // Specify the output folder here

    public CurrencytItemWriter() {
        setResource(new FileSystemResource(FILE_NAME));
        setLineAggregator(new DelimitedLineAggregator<Currency>() {{
            setDelimiter(",");
            setFieldExtractor((FieldExtractor<Currency>) currency -> new Object[] {
                    currency.getCode(), currency.getSymbole(), currency.getName()
            });
        }});
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        super.open(executionContext);
        writeHeader();
    }

    private void writeHeader() {
        Path path = Paths.get(FILE_NAME);
        if (!Files.exists(path) || isFileEmpty(path)) {
            try (Writer writer = Files.newBufferedWriter(path)) {
                writer.write(HEADER);
                writer.write(System.lineSeparator());
            } catch (IOException e) {
                throw new ItemStreamException("Erreur de création de header", e);
            }
        }
    }

    private boolean isFileEmpty(Path path) {
        try {
            return Files.size(path) == 0;
        } catch (IOException e) {
            throw new ItemStreamException("Pas de possibilté de vérifier l'existance de fichier", e);
        }
    }
}