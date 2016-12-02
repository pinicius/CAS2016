package com.pinicius.android.casapiclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by pinicius on 26/11/16.
 */

public class SpeakerDto {

    @SerializedName("id") private int id;
    @SerializedName("name") private String name;
    @SerializedName("twitterProfile") private String twitterProfile;
    @SerializedName("linkedinProfile") private String linkedinPprofile;
    @SerializedName("web") private String web;
    @SerializedName("biography") private String biography;
    @SerializedName("image") private String image;
    @SerializedName("city") private String city;
    @SerializedName("country") private String country;
    @SerializedName("links") private List<LinkDto> links;
    @SerializedName("sessions") private List<SessionSummaryDto> sessions;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTwitterProfile() {
        return twitterProfile;
    }

    public String getLinkedinPprofile() {
        return linkedinPprofile;
    }

    public String getWeb() {
        return web;
    }

    public String getBiography() {
        return biography;
    }

    public String getImage() {
        return image;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public List<LinkDto> getLinks() {
        return links;
    }

    public List<SessionSummaryDto> getSessions() {
        return sessions;
    }

    @Override
    public String toString() {
        return "SpeakerDto{"
                + "id='"
                + id
                + '\''
                + ", name='"
                + name
                + ", twitterProfile='"
                + twitterProfile
                + '\''
                + ", linkedinProfile="
                + linkedinPprofile
                + '\''
                + ", web='"
                + web
                + '\''
                + ", biography='"
                + biography
                + '\''
                + ", image='"
                + image
                + '\''
                + ", city='"
                + city
                + '\''
                + ", country='"
                + country
                + '\''
                + ", links="
                + links
                + '\''
                + ", sessions="
                + sessions
                +
                '}';
    }
}
