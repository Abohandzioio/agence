	package com.vehicule.model;
	
	import java.util.List;

import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
	import lombok.Setter;
	@Entity
	@Getter
	@Setter
	public class Agence {
		 @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Integer id_agence;
		 
		    @Column( length = 30 )
		    private String nom;
		    
		    @Column( length = 30 )
		    private String email;
		    
		    @Column( length = 10 )
		    private int tel;
		    
		    @Column( length = 8 )
		    private String rue;
		    
		    @Column( length = 5 )
		    private int cp;
		    
		    @Column( length = 20 )
		    private String ville;
		    
		    
		    
		    @OneToMany(mappedBy= "agence")
		    private List<Vehicule>vehicule;



			@Override
			public String toString() {
				return "Agence [id_agence=" + id_agence + ", nom=" + nom + ", email=" + email + ", tel=" + tel
						+ ", rue=" + rue + ", cp=" + cp + ", ville=" + ville + "]";
			}
		    
		    
}
