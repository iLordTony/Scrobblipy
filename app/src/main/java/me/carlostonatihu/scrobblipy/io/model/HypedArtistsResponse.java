package me.carlostonatihu.scrobblipy.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import me.carlostonatihu.scrobblipy.domain.Artist;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 26/08/2015.
 */
public class HypedArtistsResponse {

    @SerializedName(JsonKeys.ARTISTS_RESULTS)
    HypedArtistsResults results;

    public ArrayList<Artist> getArtists() {
        return results.artists;
    }

    private class HypedArtistsResults {
        @SerializedName(JsonKeys.ARTISTS_ARRAY)
        ArrayList<Artist> artists;
    }
}
