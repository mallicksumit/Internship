
package com.example.kon_boot.internship;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Autocomplete {

    @SerializedName("photos")
    @Expose
    private Photos photos;
    @SerializedName("stat")
    @Expose
    private String stat;
    @SerializedName("photosum")
    @Expose
    private  photosum photosum;

    public Photos getPhotos() {
        return photos;
    }

    public photosum getphot(){
        return photosum;
    }

    public void setPhotosum(photosum photosum) {
        this.photosum = photosum;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
