import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AoC_One {

    static Path getFilePath(String fileName) {
        return Paths.get("src/resources", fileName);
    }

    static int getDistance(List<String> column1, List<String> column2) {
        Collections.sort(column1);
        Collections.sort(column2);

        int sum = 0;
        for (int i = 0 ; i < column1.size() ; i++) {
            int firstVal = Integer.parseInt(column1.get(i));
            int secondVal = Integer.parseInt(column2.get(i));
            sum += Math.abs(firstVal - secondVal);
        }
        return sum;
    }

    static int getSimilarityScore(List<String> column1, List<String> column2) {
        int score = 0;
        for (String left : column1) {
            int count = 0;
            if (!column2.contains(left)) {
                continue;
            } else {
                for (String right : column2) {
                    if (right.equals(left)) {count++;}
                }
            }
            score += Integer.parseInt(left) * count;
        }
        return score;
    }

    public static void main(String[] args) {
        try {
            Path filePath = getFilePath("day1.txt");
            List<String> lines = Files.readAllLines(filePath);

            List<String> leftNumbers= new ArrayList<>();
            List<String> rightNumbers = new ArrayList<>();

            for (String line : lines) {
                String[] numbers = line.split("   ");
                leftNumbers.add(numbers[0]);
                rightNumbers.add(numbers[1]);
            }
            System.out.println(getDistance(leftNumbers, rightNumbers));
            System.out.println(getSimilarityScore(leftNumbers, rightNumbers));

        } catch (IOException e) {e.printStackTrace();}

    }
}
