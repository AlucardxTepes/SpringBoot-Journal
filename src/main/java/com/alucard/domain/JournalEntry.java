package com.alucard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Transient;

/**
 * Created by Alucard on 5/9/2017.
 */
public class JournalEntry {

  private String title;
  private Date created;
  private String summary;

  @JsonIgnore
  @Transient
  private final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

  public JournalEntry(String title, String summary, String date) throws ParseException {
    this.title = title;
    this.summary = summary;
    this.created = format.parse(date);
  }

  JournalEntry() {
  }

  @Override
  public String toString() {
    return "JournalEntry{" +
            "title='" + title + '\'' +
            ", created=" + created +
            ", summary='" + summary + '\'' +
            ", format=" + format +
            '}';
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

  public void setCreated(String date) throws ParseException {
    Long _date = null;
    try {
      _date = Long.parseLong(date);
      this.created = new Date(_date);
      return;
    } catch (Exception e) {
    }
    this.created = format.parse(date);
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
}
