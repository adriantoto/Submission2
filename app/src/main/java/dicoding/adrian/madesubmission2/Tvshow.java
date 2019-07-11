package dicoding.adrian.madesubmission2;

import android.os.Parcel;
import android.os.Parcelable;

public class Tvshow implements Parcelable {

    // POJO Properties
    private String poster;
    private String title;
    private String releasedYear;
    private String overview;
    private String rating;
    private String genre;
    private int score;
    private String trailer;
    private String runtime;
    private String director;

    // Getter and Setter

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.poster);
        dest.writeString(this.title);
        dest.writeString(this.releasedYear);
        dest.writeString(this.overview);
        dest.writeString(this.rating);
        dest.writeString(this.genre);
        dest.writeInt(this.score);
        dest.writeString(this.trailer);
        dest.writeString(this.runtime);
        dest.writeString(this.director);
    }

    public Tvshow() {
    }

    protected Tvshow(Parcel in) {
        this.poster = in.readString();
        this.title = in.readString();
        this.releasedYear = in.readString();
        this.overview = in.readString();
        this.rating = in.readString();
        this.genre = in.readString();
        this.score = in.readInt();
        this.trailer = in.readString();
        this.runtime = in.readString();
        this.director = in.readString();
    }

    public static final Parcelable.Creator<Tvshow> CREATOR = new Parcelable.Creator<Tvshow>() {
        @Override
        public Tvshow createFromParcel(Parcel source) {
            return new Tvshow(source);
        }

        @Override
        public Tvshow[] newArray(int size) {
            return new Tvshow[size];
        }
    };
}
