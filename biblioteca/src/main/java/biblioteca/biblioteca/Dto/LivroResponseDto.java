
package biblioteca.biblioteca.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponseDto {

    @JsonProperty("ISBN")
    private String ISBN;

    @JsonProperty("tituloLivro")
    private String tituloLivro;

    @JsonProperty("ano")
    private Integer ano;

    @JsonProperty("nomeEdicao")
    private String nomeEdicao;

    @JsonProperty("autorId")
    private Long autorId;
}