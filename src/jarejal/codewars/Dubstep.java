package jarejal.codewars;

public class Dubstep {
    public static String songDecoder(String song) {
        return song.replaceAll("WUB", " ").replaceAll("\\s+", " ").trim();
    }
}
