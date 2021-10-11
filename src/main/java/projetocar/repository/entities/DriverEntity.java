package projetocar.repository.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.NoArgsConstructor;
import projetocar.config.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
    @Table(name = "TB_DRIVER")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class DriverEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID")
        private Long id;

        @Column(name = "NAME")
        private String name;

        @Column(name = "DT_BIRTH")
        @ApiModelProperty(value = "Data de aniversário", name = "birthDate", dataType = "LocalDateTime", example =  "28/04")
        @JsonFormat(pattern = Constants.DATE_PATTERN, locale = "pt-BR", timezone = "Brazil/East")
        private Date birthDate;
}
