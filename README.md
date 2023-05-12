
# Song Tracker

This is an in-memory store for recently played songs that can accommodate N songs per user, with a fixed initial capacity. The store has the capability to store a list of song-user pairs, with each song linked to a user. It can also fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.




## Usage

```javascript
RecentlyPlayedStore store = new RecentlyPlayedStore(3);
```
You can then add songs to the store using the addSong method, which takes the song, user, and date as parameters:

```javascript
Song song = new Song("S1");
User user = new User("U1");
Date date = new Date();

store.addSong(song, user, date);
```
To fetch the recently played songs for a user, you can use the getRecentSongs method, which takes the user as a parameter and returns a list of SongUserPair objects:

```javascript
List<SongUserPair> recentSongs = store.getRecentSongs(user);
```
## Example
Let's assume that the initial capacity of the store is 3 and a user has played 3 songs - S1, S2, and S3. The playlist would look like this: S1, S2, S3.

When the user plays S4, the playlist would look like this: S2, S3, S4.

When the user plays S2 again, the playlist would look like this: S3, S4, S2.

When the user plays S1 again, the playlist would look like this: S4, S2, S1.





## License

This project is licensed under the [MIT](https://choosealicense.com/licenses/mit/) License - see the LICENSE file for details.



## Authors
- [@Raj Kamal](https://www.github.com/rajkamal11126)






