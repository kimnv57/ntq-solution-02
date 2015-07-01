package kim.hibernate.entities_mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	private int id;
	private String name;
	private String classs;

	public Student(int id,String name,String classs) {
		this.id=id;
		this.name=name;
		this.classs=classs;
	}

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	@Column(name = "class")
	public String getClasss() {
		return classs;
	}

}
