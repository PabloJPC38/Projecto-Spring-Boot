package com.car_agency.car_agency.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.hibernate.annotations.GenericGenerator;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class imagen {
    
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] cont;
   /*  private String mime;
    private String name;
   */
    public imagen() {
    } 

    
}
