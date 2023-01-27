package co.com.ias.projectBird.domain.model.bird;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

import static org.springframework.util.Assert.notNull;

public class BirdCommonName {

    private final String value;

    public BirdCommonName(String value) {
        notNull(value, "El nombre no debe estar vacio");
        Assert.isTrue(value.length() <= 20, "El nombre no debe de superar los 20 caracteres");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", value), "EL nombre solo puede contener letas y espacios");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
