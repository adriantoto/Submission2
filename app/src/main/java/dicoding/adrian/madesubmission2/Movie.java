package dicoding.adrian.madesubmission2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

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

    String getPoster() {
        return poster;
    }

    void setPoster(String poster) {
        this.poster = poster;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getReleasedYear() {
        return releasedYear;
    }

    void setReleasedYear(String releasedYear) {
        this.releasedYear = releasedYear;
    }

    String getOverview() {
        return overview;
    }

    void setOverview(String overview) {
        this.overview = overview;
    }

    String getRating() {
        return rating;
    }

    void setRating(String rating) {
        this.rating = rating;
    }

    String getGenre() {
        return genre;
    }

    void setGenre(String genre) {
        this.genre = genre;
    }

    int getScore() {
        return score;
    }

    void setScore(int score) {
        this.score = score;
    }

    String getTrailer() {
        return trailer;
    }

    void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    String getRuntime() {
        return runtime;
    }

    void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    String getDirector() {
        return director;
    }

    void setDirector(String director) {
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

    Movie() {
    }

    private Movie(Parcel in) {
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

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
