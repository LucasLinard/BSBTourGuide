package tech.linard.android.bsbtourguide;

/**
 * Created by lucas on 05/12/16.
 */

public class Location {
    private String title;
    private String location;
    private String opens;
    private String closes;

    public Location(String title, String location, String opens, String closes) {
        this.setTitle(title);
        this.setLocation(location);
        this.setOpens(opens);
        this.setCloses(closes);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOpens() {
        return opens;
    }

    public void setOpens(String opens) {
        this.opens = opens;
    }

    public String getCloses() {
        return closes;
    }

    public void setCloses(String closes) {
        this.closes = closes;
    }
}
