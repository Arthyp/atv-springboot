
package biblioteca.biblioteca.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_livro")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    @Id
    @Column(name = "ds_isbn", nullable = false, unique = true)
    private String ISBN;

    @Column(name = "ds_tituloLivro", nullable = false)
    private String tituloLivro;

    @Column(name = "ds_ano", nullable = false)
    private Integer ano;

    @Column(name = "ds_nomeEdicao", nullable = false)
    private String nomeEdicao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
}