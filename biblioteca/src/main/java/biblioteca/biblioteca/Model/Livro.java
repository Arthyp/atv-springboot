package biblioteca.biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "tb_autor")
@AllArgsConstructor
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name = "ds_tituloLivro", nullable = false)
    @JsonProperty("tituloLivro")
    private String tituloLivro;

    @Column(name = "ds_ISBN", nullable = false)
    @JsonProperty("ISBN")
    private Long ISBN;

    @Column(name = "ds_Ano", nullable = false)
    @JsonProperty("Ano")
    private Int Ano;

    @Column(name = "ds_nomeEdicao", nullable = false)
    @JsonProperty("nomeEdicao")
    private String nomeEdicao;

    //Criar coluna de relacionamento para Autor e livro aqui a baixo
    //@Column
}