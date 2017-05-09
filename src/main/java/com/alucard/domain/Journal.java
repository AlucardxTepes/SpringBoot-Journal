package com.alucard.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created by Alucard on 5/9/2017.
 */
@Entity
public class Journal {

  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Date created;
  private String summary;

  @Transient // Property will not be persisted
  private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

  Journal(){}

  public Journal(String title, String date, String summary) throws ParseException {
    this.title = title;
    this.summary = summary;
    this.created = format.parse(date);
  }

  @Override
  public String toString() {
    return "Journal{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", created=" + created +
            ", summary='" + summary + '\'' +
            ", format=" + format +
            '}';
  }

  public String getCreatedAsShort() {
    return format.format(created);
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public SimpleDateFormat getFormat() {
    return format;
  }

  public void setFormat(SimpleDateFormat format) {
    this.format = format;
  }
}
