package com.au.service_project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "categoryId", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<Service> services;
    
    @Lob
    @Column(name="cateogoryPic")
    @JsonIgnore
    private Byte[] categoryPic;

	//Getters and setters
    
    public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public Byte[] getCategoryPic() {
		return categoryPic;
	}

	public void setCategoryPic(Byte[] categoryPic) {
		this.categoryPic = categoryPic;
	}


	//
    
    


}
