package com.pinicius.android.cas2016.speaker.view.viewmodel;

import com.pinicius.android.cas2016.link.domain.model.Link;
import com.pinicius.android.cas2016.session.view.viewmodel.SessionSummaryViewModel;

import java.util.List;

/**
 * Created by pinicius on 28/11/16.
 */

public class SpeakerViewModel {

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
    private final List<SessionSummaryViewModel> sessions;

    public SpeakerViewModel(int id, String name,
                            String biography, String twitterProfile,
                            String linkedinProfile, String website,
                            String country, String city, String image,
                            List<Link> links, List<SessionSummaryViewModel> sessions) {
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

    public int getId() {
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

    public List<SessionSummaryViewModel> getSessions() {
        return sessions;
    }
}
