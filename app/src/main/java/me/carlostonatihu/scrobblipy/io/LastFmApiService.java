package me.carlostonatihu.scrobblipy.io;

import me.carlostonatihu.scrobblipy.io.model.HypedArtistsResponse;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 26/08/2015.
 */
// No olvidar que esto debe ser una interface o perderas mucho tiempo
public interface LastFmApiService {

    @GET(ApiConstans.URL_HYPED_ARTISTS)
    void getHypedArtists(Callback<HypedArtistsResponse> serverResponse);
}
