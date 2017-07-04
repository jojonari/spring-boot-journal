package com.fast87.journal.domain;

import com.fast87.journal.utils.JsonDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jojonari on 2017. 6. 14..
 */
@Entity
@Table(name = "entry")
public class JournalEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date created;
    private String summary;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");


    public JournalEntry(String title, String summary, String date) throws ParseException{
        this.title = title;
        this.created = format.parse(date);
        this.summary = summary;
    }

    public JournalEntry() {}

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

    @JsonSerialize(using=JsonDateSerializer.class)
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

    @JsonIgnore
    public String getCreatedAsShort(){
        return format.format(created);
    }

    @Override
    public String toString(){
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append("ID : ");
        value.append(id);
        value.append(", 제목 : ");
        value.append(title);
        value.append(", 요약 : ");
        value.append(summary);
        value.append(", 일자 : ");
        value.append(getCreatedAsShort());
        value.append(")");

        return value.toString();
    }

}
