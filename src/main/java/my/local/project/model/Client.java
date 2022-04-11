/**
 * Copyright (C) 2022, 1C
 */
package my.local.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Hermezzis
 *
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name="user")
public class Client {
	/**
	 * @param name
	 * @param email
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long ID;
	@Column(name="Name")
	private String name;
	@Column(name="Email")
	private String email;
//	@OneToMany(mappedBy = "abonement")
//	@Column(name="Abonements")
//	private List<Abonement> abonements;
	@Column(name="Phone")
	private String phone;
	@Column(name="Role")
	@Enumerated(EnumType.STRING)
	private Roles role;

}

