package UI;

public class Album {
    String genre;
    String date;
    String title;
    String performer;
    String singer;

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
}
