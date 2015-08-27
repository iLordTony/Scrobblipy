package me.carlostonatihu.scrobblipy.io;

import retrofit.RestAdapter;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 26/08/2015.
 */
public class LastFmApiAdapter {
    private static LastFmApiService API_SERVICE;

    public static LastFmApiService getApiService() {
        if (API_SERVICE == null) {
            RestAdapter adapter = new RestAdapter.Builder()
                    .setEndpoint(ApiConstans.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();

            API_SERVICE = adapter.create(LastFmApiService.class);
        }
        return API_SERVICE;
    }
}
