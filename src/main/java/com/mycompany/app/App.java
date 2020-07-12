package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 * test case
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 0
 * 0 0 0 0 0 1
 */
public class App {
    public static void main(String[] args) throws IOException {

        BufferedReader reader =

                new BufferedReader(new InputStreamReader(System.in));

        // Reading data using readLine

        //

        Scanner scanner = new Scanner(System.in);
        String matrixSize = scanner.nextLine();
        int col = Integer.parseInt(matrixSize.split("\\s+")[0]);
        int row = Integer.parseInt(matrixSize.split("\\s+")[1]);
        System.out.println("rowsCount=" + row + "  "+ " Col count = "+ col);
        List<List<Integer>> matrix = new ArrayList<>();

        while (row > 0) {
            String nextLine = scanner.nextLine().trim();
            String[] nums = nextLine.split("\\s+");
            nextLine = "";
            List<Integer> numsList = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                numsList.add(Integer.parseInt(nums[i]));
            }
            matrix.add(numsList);
            // stream way to do same logic as above
            //            matrix.add(Arrays.asList(scanner.nextLine()
            //                    .split("\\s+")).
            //                    stream().map(n -> Integer.parseInt(n))
            //                    .collect(Collectors.toList()));

            row--;

        }
        for( int i =0; i<matrix.size(); i++){
            System.out.println(matrix.get(i));
        }


        System.out.println("Steps required to completely fill matrix is = " + bfs(matrix));
        scanner.close();
        // System.out.println("scanner closed");

    }

    public static int bfs(List<List<Integer>> matrix) {
        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<Coordinate> queue = new LinkedList<>();
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(0).size(); j++) {
                if (matrix.get(i).get(j) == 1) {
                    queue.add(new Coordinate(i, j));
                    visited.add(i + "," + j);

                }
                if (matrix.get(i).get(j) == -1) {
                    visited.add(i + "," + j);
                }

            }
        }

        Queue<Coordinate> queue2 = new LinkedList<>();
        int count = 0;
        while (!queue.isEmpty()) {
            Coordinate currentNode = queue.poll();
            int x = currentNode.x;
            int y = currentNode.y;
            visited.add(x + "," + y);

            if (x > 0 && (matrix.get(x - 1).get(y) != -1) && !visited.contains((x - 1) + "," + y)) {
                matrix.get(x - 1).set(y, 1);
                queue2.add(new Coordinate(x - 1, y));
            }
            if (x < matrix.size() - 1 && (matrix.get(x + 1).get(y) != -1) &&
                    !visited.contains((x + 1) + "," + y))//revisite it might be wrong
            {
                matrix.get(x + 1).set(y, 1);
                queue2.add(new Coordinate(x + 1, y));
            }
            if (y > 0 && (matrix.get(x).get(y - 1) != -1) && !visited.contains((x) + "," + (y - 1))) {
                matrix.get(x).set(y - 1, 1);
                queue2.add(new Coordinate(x, y - 1));
            }
            if (y < matrix.get(0).size() - 1 && (matrix.get(x).get(y + 1) != -1) &&
                    !visited.contains((x) + "," + (y + 1)))//revisite it might be wrong
            {
                matrix.get(x).set(y + 1, 1);
                queue2.add(new Coordinate(x, y + 1));
            }

            if (queue.isEmpty()) {
                queue = queue2;
                count++;
                queue2 = new LinkedList<>();
            }

        }
        if (visited.size() == matrix.size() * matrix.get(0).size()) {
            return count - 1;
        } else {
            //default value
            return -1;
        }

    }

    static class Coordinate {

        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}



