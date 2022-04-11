/**
 * Copyright (C) 2022, 1C
 */
package my.local.project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Hermezzis
 *
 */
@Data
@Entity
@Table(name="user")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
	@Column(name="Phone")
	private String phone;

	//private List<IAbonement> abonements;
	//private List<Client> clients;
}
