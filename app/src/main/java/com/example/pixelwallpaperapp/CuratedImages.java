package com.example.pixelwallpaperapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CuratedImages {

    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("per_page")
    @Expose
    public Integer perPage;
    @SerializedName("photos")
    @Expose
    public List<Photo> photos = null;
    @SerializedName("next_page")
    @Expose
    public String nextPage;

    public class Photo {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("width")
        @Expose
        public Integer width;
        @SerializedName("height")
        @Expose
        public Integer height;
        @SerializedName("url")
        @Expose
        public String url;
        @SerializedName("photographer")
        @Expose
        public String photographer;
        @SerializedName("photographer_url")
        @Expose
        public String photographerUrl;
        @SerializedName("photographer_id")
        @Expose
        public Integer photographerId;
        @SerializedName("src")
        @Expose
        public Src src;
        @SerializedName("liked")
        @Expose
        public Boolean liked;

    }

    public class Src {

        @SerializedName("original")
        @Expose
        public String original;
        @SerializedName("large2x")
        @Expose
        public String large2x;
        @SerializedName("large")
        @Expose
        public String large;
        @SerializedName("medium")
        @Expose
        public String medium;
        @SerializedName("small")
        @Expose
        public String small;
        @SerializedName("portrait")
        @Expose
        public String portrait;
        @SerializedName("landscape")
        @Expose
        public String landscape;
        @SerializedName("tiny")
        @Expose
        public String tiny;

    }

}
