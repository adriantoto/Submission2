package dicoding.adrian.madesubmission2;

import java.util.ArrayList;

public class MoviesData {

    public static String[][] string_data = new String[][]{

            {"A Star Is Born",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/3/39/A_Star_is_Born.png",
                    "Bradley Cooper",
                    "2 hours 14 minutes",
                    "https://www.youtube.com/watch?v=nSbzyEJ8X9E",
                    "R",
                    "Drama, Romance, Music",
                    "75",
                    "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."},

            {"Aquaman",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/3/3a/Aquaman_poster.jpg",
                    "James Wan",
                    "2 hours 22 minutes",
                    "https://www.youtube.com/watch?v=WDkg3h8PCVU",
                    "PG-13",
                    "Action, Adventure, Fantasy",
                    "68",
                    "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm\'s half-human, half-Atlantean brother and true heir to the throne."},

            {"Avengers: Infinity War",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/4/4d/Avengers_Infinity_War_poster.jpg",
                    "Russo\'s Brothers",
                    "2 hours 40 minutes",
                    "https://www.youtube.com/watch?v=6ZfuNTqbHE8",
                    "PG-13",
                    "Action, Adventure, Fantasy",
                    "83",
                    "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."},

            {"Bird Box",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/b/bd/Bird_Box_%28film%29.png",
                    "Sussane Bier",
                    "2 hours 4 minutes",
                    "https://www.youtube.com/watch?v=INJ2bPFy108",
                    "R",
                    "Thriler, Drama",
                    "70",
                    "Five years after an ominous unseen presence drives most of society to suicide, a survivor and her two children make a desperate bid to reach safety."},

            {"Bohemian Rhapsody",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/2/2e/Bohemian_Rhapsody_poster.png",
                    "Bryan Singer",
                    "2 hours 13 minutes",
                    "https://www.youtube.com/watch?v=mP0VHJYFOAU",
                    "PG-13",
                    "Drama, Music",
                    "81",
                    "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock n roll band Queen in 1970. Hit songs become instant classics. When Mercury\\'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet finding a way to keep the band together amid the success and excess."},

            {"Bumblebee",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/7/77/Bumblebee_%28film%29_poster.png",
                    "Travis Knight",
                    "1 hour 54 minutes",
                    "https://www.youtube.com/watch?v=lcwmDAYt22k",
                    "PG-13",
                    "Action, Adventure, Sci-Fi",
                    "65",
                    "On the run in the year 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. When Charlie revives him, she quickly learns this is no ordinary yellow VW bug."},

            {"Creed II",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/9/90/Creed_II_poster.png",
                    "Steven Caple Jr.",
                    "2 hours 10 minutes",
                    "https://www.youtube.com/watch?v=u22BXhMu4tI",
                    "PG-13",
                    "Drama",
                    "67",
                    "Between personal obligations and training for his next big fight against an opponent with ties to his family\'s past, Adonis Creed is up against the challenge of his life."},

            {"Dragon Ball Super: Broly",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/1/13/DB_THE_MOVIE_NO._20.jpg",
                    "Tatsuya Nagamine",
                    "1 hour 41 minutes",
                    "https://www.youtube.com/watch?v=wuIbeQv3v7c",
                    "PG",
                    "Action, Animation, Fantasy",
                    "74",
                    "As Goku investigates the destruction of the Southern Galaxy, Vegeta is taken to be King of the New Planet Vegeta, and to destroy the Legendary Super Saiyan, Broly."},

            {"Glass",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/0/01/Glass_%282019_poster%29.png",
                    "M. Night Shyamalan",
                    "2 hours 9 minutes",
                    "https://www.youtube.com/watch?v=95ghQs5AmNk",
                    "PG-13",
                    "Thriller, Drama, Sci-Fi",
                    "65",
                    "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."},

            {"How To Train Your Dragon: The Hidden World",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/f/fd/How_to_Train_Your_Dragon_3_poster.png",
                    "Dean DeBois",
                    "1 hour 44 minutes",
                    "https://www.youtube.com/watch?v=SkcucKDrbOI",
                    "PG",
                    "Animation, Family",
                    "77",
                    "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."},

            {"Hunter Killer",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/6/63/Hunter_Killer_film_poster.jpg",
                    "Donovan Marsh",
                    "2 hours 1 minutes",
                    "https://www.youtube.com/watch?v=mnP_z3qXDCQ",
                    "R",
                    "Action, Thriller",
                    "63",
                    "Captain Glass of the USS Arkansas discovers that a coup d\'état is taking place in Russia, so he and his crew join an elite group working on the ground to prevent a war."},

            {"Mary Poppins Returns",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/4/48/Mary_Poppins_Returns_%282018_film_poster%29.png",
                    "Rob Marshall",
                    "2 hours 10 minutes",
                    "https://www.youtube.com/watch?v=-3jsfXDZLIY",
                    "PG",
                    "Fantasy, Family, Comedy",
                    "66",
                    "In Depression-era London, a now-grown Jane and Michael Banks, along with Michael\'s three children, are visited by the enigmatic Mary Poppins following a personal loss. Through her unique magical skills, and with the aid of her friend Jack, she helps the family rediscover the joy and wonder missing in their lives."},

            {"Mortal Engines",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/c/ce/Mortal_Engines_teaser_poster.jpg",
                    "Christian Rivers",
                    "2 hours 9 minutes",
                    "https://www.youtube.com/watch?v=IRsFc2gguEg",
                    "PG-13",
                    "Adventure, Fantasy",
                    "60",
                    "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever."},

            {"Once Upon A Deadpool",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/c/cf/Deadpool_2_poster.jpg",
                    "David Leitch",
                    "2 hours 14 minutes",
                    "https://www.youtube.com/watch?v=PCf03KXyzIg",
                    "PG-13",
                    "Comedy, Action",
                    "63",
                    "A kidnapped Fred Savage is forced to endure Deadpool\'s PG-13 rendition of Deadpool 2 as a Princess Bride-esque story that\'s full of magic, wonder and zero F\'s."},

            {"Robin Hood",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/3/3a/Robin_Hood_%282018_film_poster%29.png",
                    "Otto Bathurst",
                    "1 hour 56 minutes",
                    "https://www.youtube.com/watch?v=zwPn9ZnbCo0",
                    "PG-13",
                    "Adventure, Action, Thriller",
                    "58",
                    "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."},

            {"Spider-Man: Into The Spider-Verse",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/b/b8/Spider-Man_Into_the_Spider-Verse_%282018_poster%29.png",
                    "Peter Ramsey",
                    "1 hour 56 minutes",
                    "https://www.youtube.com/watch?v=g4Hbz2jLxvQ",
                    "PG",
                    "Animation, Action",
                    "84",
                    "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension."},

            {"Steve Jobs",
                    "2015",
                    "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ahUiUaeOE2lvnOy7srxaUJbbvYv.jpg",
                    "Danny Boyle",
                    "2 hour 2 minutes",
                    "https://www.youtube.com/watch?v=aEr6K1bwIVs",
                    "R",
                    "Drama",
                    "68",
                    "Set backstage at three iconic product launches and ending in 1998 with the unveiling of the iMac, Steve Jobs takes us behind the scenes of the digital revolution to paint an intimate portrait of the brilliant man at its epicenter."},

            {"The Girl in The Spider\'s Web",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/1/14/The_Girl_in_the_Spider%27s_Web_poster.png",
                    "Fede Alvarez",
                    "1 hour 57 minutes",
                    "https://www.youtube.com/watch?v=XKMSP9OKspQ",
                    "R",
                    "Action, Crime, Thriller",
                    "60",
                    "In Stockholm, Sweden, hacker Lisbeth Salander is hired by Frans Balder, a computer engineer, to retrieve a program that he believes it is too dangerous to exist."},

            {"The Mule",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/0/0c/The_mule_poster.png",
                    "Clint Eastwood",
                    "1 hour 55 minutes",
                    "https://www.youtube.com/watch?v=N_QksSzK7sI",
                    "R",
                    "Crime, Drama, Thriller",
                    "65",
                    "Earl Stone, a man in his 80s, is broke, alone, and facing foreclosure of his business when he is offered a job that simply requires him to drive. Easy enough, but, unbeknownst to Earl, he’s just signed on as a drug courier for a Mexican cartel. He does so well that his cargo increases exponentially, and Earl hit the radar of hard-charging DEA agent Colin Bates."},

            {"Venom",
                    "2018",
                    "https://upload.wikimedia.org/wikipedia/en/1/18/Venom_%282018_film_poster%29.png",
                    "Ruben Fleischer",
                    "2 hours 20 minutes",
                    "https://www.youtube.com/watch?v=xLCn88bfW1o",
                    "PG-13",
                    "Sci-Fi, Action",
                    "66",
                    "Investigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote. Soon, he must rely on his newfound powers to protect the world from a shadowy organization looking for a symbiote of their own."}
    };

    public static ArrayList<Movie> getListData() {
        ArrayList<Movie> list = new ArrayList<>();
        for (String[] aData : string_data) {
            Movie movie = new Movie();
            movie.setTitle(aData[0]);
            movie.setReleasedYear(aData[1]);
            movie.setPoster(aData[2]);
            movie.setDirector(aData[3]);
            movie.setRuntime(aData[4]);
            movie.setTrailer(aData[5]);
            movie.setRating(aData[6]);
            movie.setGenre(aData[7]);
            movie.setScore(Integer.parseInt(aData[8]));
            movie.setOverview(aData[9]);
            list.add(movie);
        }
        return list;
    }

}
