package com.madproject.musicstream

import android.content.Context
import android.media.browse.MediaBrowser
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.madproject.musicstream.models.SongModel

object MyExoPlayer {

    private  var exoPlayer : ExoPlayer? = null
    private var  currentSong: SongModel? = null


    //method to call into player activity
    fun getCurrentSong() :SongModel?{
        return currentSong
    }




    fun getInstance() : ExoPlayer?{
        return exoPlayer
    }
//method to start playing
    fun startPlaying(context : Context, song : SongModel){
        //iff it is null it will start playing
        if(exoPlayer == null)
         //initialize exoplayer
        exoPlayer = ExoPlayer.Builder(context).build()

    //cond.so it doesnt start same song again and again
   if(currentSong!=song){
       currentSong= song
       currentSong?.url?.apply {
           val mediaItem = MediaItem.fromUri(this)
           //assign media item preparing and play
           exoPlayer?.setMediaItem(mediaItem)
           exoPlayer?.prepare()
           exoPlayer?.play()

       }
   }


    }

}
