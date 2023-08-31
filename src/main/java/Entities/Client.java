package entities;



import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor  //construtores
@AllArgsConstructor  //construtores
@Builder             //padrao de projeto
@Table(name = "client")


public class Client {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)   //geração automatica do id no BD
    @Column (nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "dependents", nullable = false)
    private int dependents;

    @Column(name = "income", nullable = false) 
    private double income;

    @Column(name = "marital_status", nullable = false) 
    private String maritalStatus;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt = LocalDateTime.now();  // cria o atributo com a data/hora exata do momento

    @Column(name = "update_at", nullable = true) 
    private Data updateAt;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<House> houses;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Insurance> insurances;

    
}