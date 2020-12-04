package digital.innovationone.personapi.enums;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public enum phoneType {
    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");
    private final String description;

    phoneType(String description) {
        this.description = description;
    }
}
