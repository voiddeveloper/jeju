package com.voiddevloper.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataClass {
    @SerializedName("perPage")
    @Expose
    private String perPage;

    @SerializedName("data")
    @Expose
    private DataModel[] dataModel;

    @SerializedName("currentCount")
    @Expose
    private String currentCount;

    @SerializedName("page")
    @Expose
    private String page;

    @SerializedName("totalCount")
    @Expose
    private String totalCount;


    public String getCurrentCount() {
        return currentCount;
    }

    public String getPage() {
        return page;
    }

    public String getPerPage() {
        return perPage;
    }

    public String getTotalCount() {
        return totalCount;
    }

    public void setCurrentCount(String currentCount) {
        this.currentCount = currentCount;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "perPage='" + perPage + '\'' +
                ", data='" + dataModel + '\'' +
                ", currentCount='" + currentCount + '\'' +
                ", page='" + page + '\'' +
                ", totalCount='" + totalCount + '\'' +
                '}';
    }

    public void setDataModel(DataModel[] dataModel) {
        this.dataModel = dataModel;
    }

    public DataModel[] getDataModel() {
        return dataModel;
    }
}
