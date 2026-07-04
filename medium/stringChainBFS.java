import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class stringChainBFS {
    public static int bfs (Set<String> strList, String beginStr, String endStr) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int count = 0;

        queue.add(beginStr);
        visited.add(beginStr);
        count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                char[] charStr = str.toCharArray();
                for (int j = 0; j < charStr.length; j++) {
                    char old = charStr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        charStr[j] = k;
                        String newWord = new String(charStr);
                        if (newWord.equals(endStr)) {
                            return count + 1;
                        }
                        if (strList.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    charStr[j] = old;
                    
                }
            }
            count++;
        }

        return count;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        String beginStr = sc.next();
        String endStr = sc.next();
        sc.nextLine();

        Set<String> strList = new HashSet<>();
        for (int i = 0; i < n; i++) {
            strList.add(sc.nextLine());   
        }

        int count = bfs(strList, beginStr, endStr);
        System.out.println(count);

        



    }
    
}
