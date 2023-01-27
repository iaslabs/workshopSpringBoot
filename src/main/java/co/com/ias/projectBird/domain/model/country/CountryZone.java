package co.com.ias.projectBird.domain.model.country;

import org.springframework.util.Assert;

public class CountryZone {

    private final String value;

    public CountryZone(String value) {
        Assert.notNull(value, "El nombre no debe de estar vacio");
        Assert.isTrue(value.length() <= 20, "El nombre no debe de contener mas de 20 caracteres");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
