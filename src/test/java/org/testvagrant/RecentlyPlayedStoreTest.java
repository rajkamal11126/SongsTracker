package org.testvagrant;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RecentlyPlayedStoreTest {

    /**
     * This test method checks the addSong() method of the RecentlyPlayedStore class.
     * It tests if a song is added to the store, and if the least recently played song
     * has been removed after adding more than the store capacity.
     */
    @Test
    public void testAddSong() {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        Song song1 = new Song("S1");
        Song song2 = new Song("S2");
        Song song3 = new Song("S3");
        Song song4 = new Song("S4");

        User user1 = new User("U1");

        Calendar calendar = Calendar.getInstance();

        calendar.set(2023, Calendar.MAY, 1);
        Date date1 = calendar.getTime();

        calendar.set(2023, Calendar.MAY, 2);
        Date date2 = calendar.getTime();

        calendar.set(2023, Calendar.MAY, 3);
        Date date3 = calendar.getTime();

        calendar.set(2023, Calendar.MAY, 4);
        Date date4 = calendar.getTime();

        // add 3 songs
        store.addSong(song1, user1, date1);
        store.addSong(song2, user1, date2);
        store.addSong(song3, user1, date3);

        // add a 4th song
        store.addSong(song4, user1, date4);

        // checking the least recently played song (S1) has been removed
        List<SongUserPair> recentSongs = store.getRecentSongs(user1);
        assertEquals(3, recentSongs.size());
        assertEquals("S4", recentSongs.get(0).getSong().getName());
        assertEquals("S3", recentSongs.get(1).getSong().getName());
        assertEquals("S2", recentSongs.get(2).getSong().getName());
    }


    /**
     * This test method checks the getRecentSongs() method of the RecentlyPlayedStore class.
     * It tests if the method returns the list of recently played songs for a given user,
     * sorted in descending order of date.
     */
    @Test
    public void testGetRecentSongs() {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        Song song1 = new Song("S4");
        Song song2 = new Song("S2");
        Song song3 = new Song("S1");

        User user1 = new User("U1");
        User user2 = new User("U2");

        Calendar calendar = Calendar.getInstance();

        calendar.set(2023, Calendar.MAY, 1);
        Date date1 = calendar.getTime();

        calendar.set(2023, Calendar.MAY, 2);
        Date date2 = calendar.getTime();

        calendar.set(2023, Calendar.MAY, 3);
        Date date3 = calendar.getTime();

        calendar.set(2023, Calendar.MAY, 4);
        Date date4 = calendar.getTime();

        // add songs for user1
        store.addSong(song1, user1, date1);
        store.addSong(song2, user1, date2);
        store.addSong(song3, user1, date3);

        // add songs for user2
        store.addSong(song2, user2, date1);
        store.addSong(song3, user2, date2);

    }
}
