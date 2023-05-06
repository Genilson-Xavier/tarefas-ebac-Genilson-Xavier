package br.com.ebac.animalservice.repositorios;

import br.com.ebac.animalservice.model.TipoAnimal;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoAnimalConverter implements AttributeConverter<TipoAnimal, String> {
    @Override
    public String convertToDatabaseColumn(TipoAnimal attribute) {
        return "tipo_animal";
    }

    @Override
    public TipoAnimal convertToEntityAttribute(String dbData) {
        return TipoAnimal.valueOf(dbData.toUpperCase());
    }
}
