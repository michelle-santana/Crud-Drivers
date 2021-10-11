package projetocar.domain.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class DriverDTO {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Date birthDate;
}
