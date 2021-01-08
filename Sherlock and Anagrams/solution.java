import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int answer = 0;
        Hashtable<String, Integer> map = new Hashtable<String, Integer>();

        for(int i = 0; i < s.length(); i++){
            for(int j = i + 1; j <=s.length(); j++){
                String currentSub = s.substring(i, j);

                char[] chars = currentSub.toCharArray();
                Arrays.sort(chars);
                currentSub = String.valueOf(chars);

                int value = map.getOrDefault(currentSub, 0);

                if(value > 0){
                    answer += value;
                }
                map.put(currentSub, ++value);
            }
        }
        return answer;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
