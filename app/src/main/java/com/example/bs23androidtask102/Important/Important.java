package com.example.bs23androidtask102.Important;

public class Important {
    static String BaseUrl;
    static String getDesiredList;
    static String HeaderKey;
    static String Header;

    public static String getHeaderKey() {
        return HeaderKey;
    }

    public static void setHeaderKey(String headerKey) {
        HeaderKey = headerKey;
    }

    public static String getHeader() {
        return Header;
    }

    public static void setHeader(String header) {
        Header = header;
    }

    public static String getBaseUrl() {
        return BaseUrl;
    }

    public static void setBaseUrl(String url) {
        BaseUrl = url;
    }

    public static String getGetDesiredList() {
        return getDesiredList;
    }

    public static void setGetDesiredList(String getDesiredList) {
        Important.getDesiredList = getDesiredList;
    }

}