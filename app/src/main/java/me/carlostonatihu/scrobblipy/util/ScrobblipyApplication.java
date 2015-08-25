package me.carlostonatihu.scrobblipy.util;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 25/08/2015.
 */
public class ScrobblipyApplication {
    private static boolean activityVisible = false;
    public static boolean getActivityVisible() {
        return activityVisible;
    }

    public static void setActivityVisible(boolean valor) {
        activityVisible = valor;
    }
}
