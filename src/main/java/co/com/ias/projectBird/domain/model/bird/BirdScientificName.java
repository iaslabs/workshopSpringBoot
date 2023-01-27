package co.com.ias.projectBird.domain.model.bird;

import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

public class BirdScientificName {

    private final String value;

    public BirdScientificName(String value) {
        notNull(value, "El nombre no debe estar vacio");
        Assert.isTrue(value.length() <= 20, "El nombre no debe de superar los 20 caracteres");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
