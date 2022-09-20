package com.example.roomsimpleexample

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class PlaylistWithSongs(
    @Embedded
    val playlist: Playlist,

    @Relation(
        parentColumn = "id",    //id from playlist
        entityColumn = "id",    //is from song
        associateBy = Junction(
            PlaylistSong::class,
            parentColumn = "playlist_id",
            entityColumn = "song_id"
        )
    )
    val songs: List<Song>
)
