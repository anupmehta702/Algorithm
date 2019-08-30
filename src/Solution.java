import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }



    public static Node insert(Node root, int key)
    {
        if (root == null) {
            Node rootNode = new Node(key);
            return rootNode;
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        }

        else {
            root.right = insert(root.right, key);
        }

        return root;
    }
    public static boolean isBST(Node node, int minKey, int maxKey)
    {

        if (node == null) {
            return true;
        }

        if (node.data < minKey || node.data > maxKey) {
            return false;
        }

        return isBST(node.left, minKey, node.data) &&
                isBST(node.right, node.data, maxKey);
    }

    public static String isBST(Node root)
    {
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return "YES";
        } else {
            return "NO";
        }
    }



    public static String isValid(List<Integer> a) {
        Node root = null;
        for(int key : a){
            root = insert(root,key);
        }
        return isBST(root);
        // Write your code here
        // int root = a.get(0);
        // boolean firstRightChildFound=false;
        // for(int index=1;index<a.size();index++){
        //     if(a.get(index)<root){
        //         if(firstRightChildFound){
        //             return "NO";
        //         }
        //     }else if(a.get(index)>root){
        //          firstRightChildFound=true;
        //     }
        // }
        // return "YES";

    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int aCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.isValid(a);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
