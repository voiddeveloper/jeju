package com.voiddevloper.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModel {
    @SerializedName("제목")
    @Expose
    private String title;

    @SerializedName("지번주소")
    @Expose
    private String  lotNumberAddress;

    @SerializedName("도로명주소")
    @Expose
    private String roadNameAddress;

    @SerializedName("위도")
    @Expose
    private String latitude;

    @SerializedName("경도")
    @Expose
    private String longitude;

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLotNumberAddress(String lotNumberAddress) {
        this.lotNumberAddress = lotNumberAddress;
    }

    public void setRoadNameAddress(String roadNameAddress) {
        this.roadNameAddress = roadNameAddress;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLotNumberAddress() {
        return lotNumberAddress;
    }

    public String getRoadNameAddress() {
        return roadNameAddress;
    }

    public String getTitle() {
        return title;
    }

}
