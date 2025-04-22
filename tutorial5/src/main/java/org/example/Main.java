package org.example;
import java.util.ArrayList;

public class Main {
    private String libraryName;
    private String ownerName;
    private ArrayList<String> tracks;
    private ArrayList<Playlist> playlists;

    public Main(String libraryName, String ownerName) {
        this.libraryName = libraryName;
        this.ownerName = ownerName;
        this.tracks = new ArrayList<>();
        this.playlists = new ArrayList<>();
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(String track) {
        tracks.remove(track);
        for (Playlist playlist : playlists) {
            playlist.removeTrack(track);
        }
    }

    public void displayTracks() {
        for (String track : tracks) {
            System.out.println(track);
        }
    }

    public void searchTracks(String phrase) {
        for (String track : tracks) {
            if (track.contains(phrase)) {
                System.out.println(track);
            }
        }
    }

    public void createPlaylist(String name) {
        if (findPlaylist(name) == null) {
            playlists.add(new Playlist(name));
        }
    }

    public Playlist findPlaylist(String name) {
        for (Playlist playlist : playlists) {
            if (playlist.getName().equals(name)) {
                return playlist;
            }
        }
        return null;
    }

    public void addTrackToPlaylist(String track, String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null) {
            playlist.addTrack(track);
        }
    }

    public void displayPlaylist(String playlistName) {
        Playlist playlist = findPlaylist(playlistName);
        if (playlist != null) {
            playlist.displayTracks();
        }
    }

    public void displayAllPlaylists() {
        for (Playlist playlist : playlists) {
            System.out.println(playlist.getName());
        }
    }

    public int getTrackCount() {
        return tracks.size();
    }

    public int getPlaylistCount() {
        return playlists.size();
    }

    public static void main(String[] args) {
        Main myLibrary = new Main("Rock Collection", "John Smith");

        myLibrary.addTrack("Led Zeppelin - Stairway to Heaven");
        myLibrary.addTrack("Queen - Bohemian Rhapsody");
        myLibrary.addTrack("Pink Floyd - Comfortably Numb");
        myLibrary.addTrack("AC/DC - Back in Black");
        myLibrary.addTrack("Metallica - Nothing Else Matters");

        myLibrary.displayTracks();

        myLibrary.createPlaylist("Favorites");
        myLibrary.createPlaylist("Party");

        myLibrary.addTrackToPlaylist("Queen - Bohemian Rhapsody", "Favorites");
        myLibrary.addTrackToPlaylist("Pink Floyd - Comfortably Numb", "Favorites");
        myLibrary.addTrackToPlaylist("AC/DC - Back in Black", "Party");
        myLibrary.addTrackToPlaylist("Metallica - Nothing Else Matters", "Party");

        myLibrary.displayAllPlaylists();

        myLibrary.displayPlaylist("Favorites");

        myLibrary.searchTracks("Queen");

        myLibrary.removeTrack("AC/DC - Back in Black");

        myLibrary.displayPlaylist("Party");

        System.out.println("Total number of tracks in the library: " + myLibrary.getTrackCount());
        System.out.println("Total number of playlists: " + myLibrary.getPlaylistCount());
    }
}

class Playlist {
    private String name;
    private ArrayList<String> tracks;

    public Playlist(String name) {
        this.name = name;
        this.tracks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addTrack(String track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        }
    }

    public void removeTrack(String track) {
        tracks.remove(track);
    }

    public void displayTracks() {
        System.out.println("Playlist: " + name);
        for (String track : tracks) {
            System.out.println(track);
        }
    }
}
