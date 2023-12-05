package com.brtest.brtest.Entities.Sale;

import com.brtest.brtest.Entities.Client.Client;
import com.brtest.brtest.Entities.User.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @ManyToOne
    @JoinColumn(name = "idclient")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "idSaler")
    private User Saler;

    @Column(name = "commission")
    private Double commission;

    @Column(name = "releasedValue")
    private  Double releasedValue;




}
