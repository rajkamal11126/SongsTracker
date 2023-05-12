package org.testvagrant;

import java.util.Date;

public class SongUserPair {
    private Song song;
    private User user;
    private Date date;

    public SongUserPair(Song song, User user, Date date) {
        this.song = song;
        this.user = user;
        this.date = date;

    }
    public Date getDate() {
        return date;
    }
    public Song getSong() {
        return song;
    }
    public User getUser(){
        return user;
    }
}
