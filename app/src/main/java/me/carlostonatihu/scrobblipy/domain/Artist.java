package me.carlostonatihu.scrobblipy.domain;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 25/08/2015.
 */
public class Artist {
    String name;

    public Artist (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
