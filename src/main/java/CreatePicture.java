import java.util.Scanner;

public class CreatePicture {
    public static void main(String[] args) {
        CreatePicture createPicture = new CreatePicture();

        Scanner scanner = new Scanner(System.in);
        System.out.println("input a size");
        int n = scanner.nextInt();

        int m = createPicture.size(n);
        int[][] arr = new int[m][m];

        createPicture.initializeArray(arr, n);
        createPicture.subtract(arr, n, m);
        createPicture.view(arr);
    }

    public int[][] subtract(int[][] arr, int n, int m) {
        int o = 2; // 2 na 4
        int p = 3; // 3 na 5
        for (int i = 0; i < n - 2; i++) {
            //upper row
            for (int j = 0; j < m - o; j++) {
                arr[(i + 1)][j + (i + 1)] = n - (i + 1);
            }
            //lower row
            for (int j = 0; j < m - o; j++) {
                arr[m - ((i + 1) + 1)][j + (i + 1)] = n - (i + 1);
            }
            //left column
            for (int j = 0; j < m - p; j++) {
                arr[j + (i + 1)][(i + 1)] = n - (i + 1);
            }
            //right column
            for (int j = 0; j < m - p; j++) {
                arr[j + (i + 1)][m - ((i + 1) + 1)] = n - (i + 1);
            }
            o++;
            o++;
            p++;
            p++;
        }
        return arr;
    }

    public int[][] initializeArray(int[][] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = n;
            }
        }
        arr[n - 1][n - 1] = 1;
        return arr;
    }

    public int size(int n) {
        int counter = 0;
        for (int i = -n; i < n - 1; i++) {
            counter++;
        }
        return counter;
    }

    public void view(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}