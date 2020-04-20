package org.sy.leetcode_practice.canVisitAllRooms;

import java.util.*;

/**
 * 钥匙和房间
 */
public class CanVisitAllRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        Set<Integer> visitedRoom = new HashSet<>();
        Set<Integer> allKeys = new HashSet<>();
        while(!queue.isEmpty()) {
            int curRoom = queue.remove();
            if(!visitedRoom.contains(curRoom)) {
                visitedRoom.add(curRoom);
                List<Integer> curKeys = rooms.get(curRoom);
                for(int key : curKeys) {
                    allKeys.add(key);
                    queue.add(key);
                }
            }
        }
        if(visitedRoom.size()==rooms.size()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> rooms = new ArrayList<>();
//        List<Integer> room0 = new ArrayList<>();room0.add(1);
//        List<Integer> room1 = new ArrayList<>();room1.add(2);
//        List<Integer> room2 = new ArrayList<>();room2.add(3);
//        List<Integer> room3 = new ArrayList<>();
//        rooms.add(room0);
//        rooms.add(room1);
//        rooms.add(room2);
//        rooms.add(room3);

//        List<List<Integer>> rooms = new ArrayList<>();
//        List<Integer> room0 = new ArrayList<>();room0.add(2);
//        List<Integer> room1 = new ArrayList<>();
//        List<Integer> room2 = new ArrayList<>();room2.add(1);
//        rooms.add(room0);
//        rooms.add(room1);
//        rooms.add(room2);

        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();room0.add(1);room0.add(3);
        List<Integer> room1 = new ArrayList<>();room1.add(3);room1.add(0);room1.add(1);
        List<Integer> room2 = new ArrayList<>();room2.add(2);
        List<Integer> room3 = new ArrayList<>();room3.add(0);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        System.out.println(new CanVisitAllRooms().canVisitAllRooms(rooms));
    }

}
