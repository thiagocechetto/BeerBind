package com.arctouch.beerbind.beer;


public class BeerModel {

    private static final String URL_BEER_1 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage1.imageset/beerImage1.jpg";
    private static final String URL_BEER_2 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage2.imageset/beerImage2.jpg";
    private static final String URL_BEER_4 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage4.imageset/beerImage4.jpg";
    private static final String URL_BEER_6 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage6.imageset/beerImage6.jpg";
    private static final String URL_BEER_8 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage8.imageset/beerImage8.jpg";
    private static final String URL_BEER_12 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage12.imageset/beerImage10.png";
    private static final String URL_BEER_16 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage16.imageset/beerImage13.jpg";
    private static final String URL_BEER_20 = "https://raw.githubusercontent.com/gfendres/ractdc2016/master/RACTDC2016/Assets.xcassets/BeerImages/beerImage20.imageset/beerImage17.jpg";

    private int beerCount;

    public int getBeerCount() {
        return beerCount;
    }

    public void setBeerCount(int beerCount) {
        this.beerCount = beerCount;
    }

    public String getBeerContImageUrl() {
        if (beerCount < 2) {
            return URL_BEER_1;
        } else if (beerCount < 4) {
            return URL_BEER_2;
        } else if (beerCount < 6) {
            return URL_BEER_4;
        } else if (beerCount < 8) {
            return URL_BEER_6;
        } else if (beerCount < 12) {
            return URL_BEER_8;
        } else if (beerCount < 16) {
            return URL_BEER_12;
        } else if (beerCount < 20) {
            return URL_BEER_16;
        }
        return URL_BEER_20;
    }
}
