package io.kay.java25.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String email;

    @OneToMany(mappedBy = "owner")
    List<Group> owningGroups;

    @ManyToMany(mappedBy = "members")
    List<Group> subscribedGroups;

    @ManyToMany(mappedBy = "attendees")
    List<Meetup> visitedMeetups;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Group> getOwningGroups() {
        return owningGroups;
    }

    public void setOwningGroups(List<Group> owningGroups) {
        this.owningGroups = owningGroups;
    }

    public List<Group> getSubscribedGroups() {
        return subscribedGroups;
    }

    public void setSubscribedGroups(List<Group> subscribedGroups) {
        this.subscribedGroups = subscribedGroups;
    }

    public List<Meetup> getVisitedMeetups() {
        return visitedMeetups;
    }

    public void setVisitedMeetups(List<Meetup> visitedMeetups) {
        this.visitedMeetups = visitedMeetups;
    }
}
