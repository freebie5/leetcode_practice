package org.sy.leetcode_practice.floodFill;

/**
 * 图像渲染
 */
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor==newColor) {
            return image;
        }
        fill(image, sr, sc, newColor, oldColor);
        return image;

    }

    private void fill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if(image[sr][sc]!=oldColor) {
            return;
        } else {
            image[sr][sc] = newColor;
            if(sr-1>=0 && image[sr-1][sc]==oldColor) {
                fill(image, sr-1, sc, newColor, oldColor);
            }
            if(sr+1<image.length && image[sr+1][sc]==oldColor) {
                fill(image, sr+1, sc, newColor, oldColor);
            }
            if(sc-1>=0 && image[sr][sc-1]==oldColor) {
                fill(image, sr, sc-1, newColor, oldColor);
            }
            if(sc+1<image[0].length && image[sr][sc+1]==oldColor) {
                fill(image, sr, sc+1, newColor, oldColor);
            }
        }
    }

    public static void main(String[] args) {
        int[][] image = new int[][]{
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int[][] image2 = new int[][]{
                {0, 0, 0},
                {0, 1, 1}
        };
        int[][] result = new FloodFill().floodFill(image2, 1, 1, 1);
        for(int[] r : result) {
            for(int c : r) {
                System.out.print(c + ",");
            }
            System.out.println();
        }
    }

}
