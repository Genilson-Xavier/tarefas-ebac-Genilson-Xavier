package br.com.ebac.animalservice.repositorios;

import br.com.ebac.animalservice.model.Porte;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import javax.sound.sampled.Port;

@Converter(autoApply = true)
public class PorteConverter implements AttributeConverter<Porte, String> {
    @Override
    public String convertToDatabaseColumn(Porte attribute) {
        return "porte";
    }

    @Override
    public Porte convertToEntityAttribute(String dbData) {
        return Porte.valueOf(dbData.toUpperCase());
    }
}
