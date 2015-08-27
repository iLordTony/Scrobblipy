package me.carlostonatihu.scrobblipy.io;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 25/08/2015.
 */
public class ApiConstans {
    public static final String BASE_URL = "http://ws.audioscrobbler.com";

    public static final String PATH_VERSION = "/2.0";

    public static final String PARAM_API_KEY = "api_key";
    public static final String PARAM_METHOD = "method";
    public static final String PARAM_FORMAT = "format";

    // Remplazar el API_KEY por una nueva
    public static final String VALUE_API_KEY = "c7d3b90bd4782bc434ddd647b698179a";

    // Metodos
    public static final String VALUE_HYPED_ARTISTS_METHOD = "chart.getHypedArtists";
    public static final String VALUE_JSON = "json";

    // Peticionea
    public static final String URL_HYPED_ARTISTS = PATH_VERSION + "/?" + PARAM_API_KEY + "=" +
            VALUE_API_KEY + "&" + PARAM_METHOD + "=" + VALUE_HYPED_ARTISTS_METHOD + "&" +
            PARAM_FORMAT + "=" + VALUE_JSON;
}
