package entities;


import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@Entity
@NoArgsConstructor  //construtores
@AllArgsConstructor  //construtores
@Builder             //padrao de projeto

public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (nullable = false, updatable = false, unique = true)
    private Long id;
    @Column(name = "owner_ship_status", nullable = false)
    private String ownerShipStatus;
    @Column(name = "location", nullable = false)
    private String location;
    @Column(name = "zipcode", nullable = false)
    private String zipcode;   
    
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference  //força a parada da busca qundo encontra o que busca
    private Client client;

    
}
