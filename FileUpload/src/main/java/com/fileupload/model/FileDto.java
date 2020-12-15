package com.fileupload.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import lombok.Data;

@Data
@Table(name = "files")
@Entity
@GenericGenerator(name = "uuid", strategy = "uuid2")
public class FileDto {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String name;
	private String type;
	@Lob
	private byte[] data;

	public FileDto() {

	}

	public FileDto( String name, String type, byte[] data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}



}
