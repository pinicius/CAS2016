package com.pinicius.android.cas2016.speaker.domain.model;

import com.karumi.rosie.repository.datasource.Identifiable;
import com.pinicius.android.cas2016.link.domain.model.Link;
import com.pinicius.android.cas2016.session.domain.model.SessionSummary;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class Speaker implements Identifiable<Integer> {

    private final int id;
    private final String name;
    private final String biography;
    private final String twitterProfile;
    private final String linkedinProfile;
    private final String website;
    private final String country;
    private final String city;
    private final String image;
    private final List<Link> links;
    private final List<SessionSummary> sessions;

    public Speaker(int id, String name,
                   String biography, String twitterProfile,
                   String linkedinProfile, String website,
                   String country, String city, String image,
                   List<Link> links, List<SessionSummary> sessions) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.twitterProfile = twitterProfile;
        this.linkedinProfile = linkedinProfile;
        this.website = website;
        this.country = country;
        this.city = city;
        this.image = image;
        this.links = links;
        this.sessions = sessions;
    }

    @Override
    public Integer getKey() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }

    public String getTwitterProfile() {
        return twitterProfile;
    }

    public String getLinkedinProfile() {
        return linkedinProfile;
    }

    public String getWebsite() {
        return website;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getImage() {
        return image;
    }

    public List<Link> getLinks() {
        return links;
    }

    public List<SessionSummary> getSessions() {
        return sessions;
    }
}

