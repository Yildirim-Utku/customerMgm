package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="files")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fileId;
	
	private String fileName;
	
	 @ManyToOne
	    @JoinColumn(name = "custId")
	    private Customer customer;
}
