package io.kay.graal.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "meetups")
public class Meetup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    String description;

    @ManyToOne
    @JoinColumn(name = "group", nullable = false)
    Group group;

    @ManyToMany
    @JoinTable(name = "meetup_attendees",
               joinColumns = @JoinColumn(name = "meetup"),
               inverseJoinColumns = @JoinColumn(name = "user"))
    List<User> attendees;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
}
