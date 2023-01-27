package co.com.ias.projectBird.domain.model.zone;

import org.springframework.util.Assert;

public class ZoneName {

    private final String value;

    public ZoneName(String value) {
        Assert.notNull(value, "El nombre no debe de estar vacio");
        Assert.isTrue(value.length() <= 20, "El nombre no debe de contener mas de 20 caracteres");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
