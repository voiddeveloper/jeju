package com.voiddevloper.myapplication;

public class CafeItem {
    int cafeImgSrc;
    String cafeName;
    String heartCount;
    String starCount;
    String locationName;
    String locationDescription;

    public CafeItem (int cafeImgSrc, String cafeName, String heartCount, String starCount, String locationName,String locationDescription){
        this.cafeImgSrc = cafeImgSrc;
        this.cafeName = cafeName;
        this.heartCount = heartCount;
        this.starCount = starCount;
        this.locationName = locationName;
        this.locationDescription = locationDescription;
    }

    public int getCafeImgSrc() {
        return cafeImgSrc;
    }

    public String getCafeName() {
        return cafeName;
    }

    public String getHeartCount() {
        return heartCount;
    }

    public String getStarCount() {
        return starCount;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setCafeImgSrc(int cafeImgSrc) {
        this.cafeImgSrc = cafeImgSrc;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    public void setHeartCount(String heartCount) {
        this.heartCount = heartCount;
    }

    public void setStarCount(String starCount) {
        this.starCount = starCount;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }
}
