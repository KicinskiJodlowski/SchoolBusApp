package com.example.SchoolBussApp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventJSONModel {

    @SerializedName("eventId")
    @Expose
    private Integer eventId;
    @SerializedName("eventName")
    @Expose
    private String eventName;
    @SerializedName("dateOfEvent")
    @Expose
    private String dateOfEvent;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imgURL")
    @Expose
    private Object imgURL;
    @SerializedName("eventQRCode")
    @Expose
    private String eventQRCode;
    @SerializedName("jobIDscheduler")
    @Expose
    private Object jobIDscheduler;
    @SerializedName("ownerID")
    @Expose
    private Object ownerID;
    @SerializedName("invitedGuests")
    @Expose
    private Object invitedGuests;

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getImgURL() {
        return imgURL;
    }

    public void setImgURL(Object imgURL) {
        this.imgURL = imgURL;
    }

    public String getEventQRCode() {
        return eventQRCode;
    }

    public void setEventQRCode(String eventQRCode) {
        this.eventQRCode = eventQRCode;
    }

    public Object getJobIDscheduler() {
        return jobIDscheduler;
    }

    public void setJobIDscheduler(Object jobIDscheduler) {
        this.jobIDscheduler = jobIDscheduler;
    }

    public Object getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Object ownerID) {
        this.ownerID = ownerID;
    }

    public Object getInvitedGuests() {
        return invitedGuests;
    }

    public void setInvitedGuests(Object invitedGuests) {
        this.invitedGuests = invitedGuests;
    }

    public EventJSONModel(String eventName, String dateOfEvent, String description) {
        this.eventName = eventName;
        this.dateOfEvent = dateOfEvent;
        this.description = description;
    }
}
