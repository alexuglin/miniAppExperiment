import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PrefixNameFile {

    DEFAULT("default-"),
    UPLOAD("upload-");

    private final String description;

}
