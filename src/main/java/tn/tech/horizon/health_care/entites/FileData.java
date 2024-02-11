package tn.tech.horizon.health_care.entites;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "files")
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idFilesOwner;

    @Column(length = 255)
    private String name;

    @Column(length = 50)
    private String type;

    @Column(length = 255)
    private String filePath;

}
