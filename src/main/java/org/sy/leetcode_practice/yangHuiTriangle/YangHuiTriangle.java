package org.sy.leetcode_practice.yangHuiTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 */
public class YangHuiTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        for(int i=0;i<numRows;i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<i+1;j++) {
                if(i-1>=0 && j-1>=0 && result.size()>=i-1 && result.get(i-1).size()>j) {
                    int col = result.get(i-1).get(j) + result.get(i-1).get(j-1);
                    row.add(col);
                } else {
                    row.add(1);
                }
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new YangHuiTriangle().generate(5);
        for(List<Integer> r : result) {
            for(Integer c : r) {
                System.out.print(c+",");
            }
            System.out.println();
        }
    }

}
