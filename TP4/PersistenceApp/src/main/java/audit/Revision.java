package audit;


import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionTimestamp;

import config.CustomRevisionListener;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Table(name = "REVISION_INFO")
@RevisionEntity(CustomRevisionListener.class)
@Data

public class Revision implements Serializable {
	

private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="revision_seq")
@SequenceGenerator(name = "revision_seq", sequenceName="rbac.seq_revision_id")
private int id;
@Column(name="REVISION_DATE")
@Temporal(TemporalType.TIMESTAMP)
@RevisionTimestamp
private Date date;


}
