package my.local.project.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@Table(name = "event")
public
class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(name="client_id")
	private Long clientId;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date start;
	@Column
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date finish;
	@Column
	@Enumerated(EnumType.STRING)
	private Status status;

	@Override
	public String toString() {
		return "Event [id=" + id + ", client =" + clientId + ", title=" + title + ", description=" + description + ", start=" + start
				+ ", finish=" + finish + ", status = " + status + "]";
	}
}