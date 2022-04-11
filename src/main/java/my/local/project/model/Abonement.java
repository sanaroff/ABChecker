/**
 * Copyright (C) 2022, 1C
 */
package my.local.project.model;

import jdk.jfr.Name;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * @author Hermezzis
 *
 */
@Data
@Entity
@Table(name = "abonements")
public class Abonement{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="client")
	private String client;
	@Column(name="price")
	private BigDecimal price;
	@Column(name="date_start")
	private String startDate;
	@Column(name="date_end")
	private String endDate;
	public Abonement(){}

	private static LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
		return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
