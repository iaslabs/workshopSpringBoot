package co.com.ias.projectBird.domain.model.country;

import org.springframework.util.Assert;

import java.util.regex.Pattern;

public class CountryZone {

    private final String value;

    public CountryZone(String value) {
        Assert.notNull(value, "El nombre no debe de estar vacio");
        Assert.isTrue(value.length() <= 20, "El nombre no debe de contener mas de 20 caracteres");
        Assert.isTrue(Pattern.matches("^[A-z\\s]+(?<!\\s)$", value), "EL nombre solo puede contener letas y espacios");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
