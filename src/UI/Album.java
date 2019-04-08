package UI;

public class Album {
    protected String genre;
    protected String date;
    protected String title;
    protected String performer;
    protected String singer;

    private static class SingletonHolder {
        private static final Album INSTANCE =new Album();
    }

    private Album() {
    }

    public static final Album getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getPerformer() {
        return performer;
    }

    public String getSinger() {
        return singer;
    }
}
