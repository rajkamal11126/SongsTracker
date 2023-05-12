package org.testvagrant;

import java.util.*;

/**
 * The RecentlyPlayedStore class represents a data structure that stores the most recent songs played by each user.
 * It has a fixed capacity for each user, and older songs are automatically removed when the capacity is reached.
 */
public class RecentlyPlayedStore {

    /**
     * The capacity of the store for each user.
     */
    private int capacity;

    /**
     * A map that stores the recently played songs for each user.
     * The keys are User objects, and the values are lists of SongUserPair objects.
     */
    private Map<User, List<SongUserPair>> store;

    /**
     * Constructs a new RecentlyPlayedStore object with the specified capacity.
     * @param capacity The capacity of the store for each user.
     */
    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

    /**
     * Adds a new SongUserPair object to the list of recently played songs for the specified user.
     * If the number of songs for the user exceeds the capacity, the oldest song is removed.
     * @param song The Song object representing the song that was played.
     * @param user The User object representing the user who played the song.
     * @param date The Date object representing the date and time when the song was played.
     */
    public void addSong(Song song, User user, Date date) {
        SongUserPair pair = new SongUserPair(song, user, date);
        List<SongUserPair> userSongs = store.getOrDefault(user, new LinkedList<>());
        userSongs.add(pair);
        store.put(user, userSongs);

        if (userSongs.size() > capacity) {
            userSongs.remove(0);
        }
    }

    /**
     * Returns a list of the most recent SongUserPair objects for the specified user.
     * The list is sorted in descending order by date and time.
     * @param user The User object representing the user whose recent songs should be returned.
     * @return A list of the most recent SongUserPair objects for the specified user.
     */
    public List<SongUserPair> getRecentSongs(User user) {
        List<SongUserPair> userSongs = store.get(user);
        if (userSongs == null || userSongs.isEmpty()) {
            return new LinkedList<>();
        }

        // sort songs by date in descending order
        Collections.sort(userSongs, new Comparator<SongUserPair>() {
            @Override
            public int compare(SongUserPair o1, SongUserPair o2) {
                return o2.getDate().compareTo(o1.getDate());
            }
        });

        return userSongs;
    }
}