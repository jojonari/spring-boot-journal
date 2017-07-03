package com.fast87.journal.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jojonari on 2017. 6. 14..
 */
//@Entity
public class Journal {
    private long id;
    private String title;
    private Date created;
    private String summary;

    public Journal() {}

    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

    public Journal(String title, String summary, String date) throws ParseException {
        this.title = title;
        this.created = format.parse(date);
        this.summary = summary;
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

    public void setCreated(String date) throws ParseException{
        Long _date = null;
        try {
            _date = Long.parseLong(date);
            this.created = new Date(_date);
            return;
        }catch (Exception ex){
            this.created = format.parse(date);
        }
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString(){
        StringBuilder value = new StringBuilder("JournalEntry(");
        value.append(", 제목 : ");
        value.append(title);
        value.append(", 요약 : ");
        value.append(summary);
        value.append(", 일자 : ");
        value.append(format.format(created));
        value.append(")");

        return value.toString();
    }

    public Journal(long id, String title,  String summary, Date created) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.summary = summary;
    }
/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private Date created;
    private String summary;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");


    public Journal(String title, String summary, String date) throws ParseException{
        this.title = title;
        this.created = format.parse(date);
        this.summary = summary;
    }

    public Journal() {}

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
    }*/

}
