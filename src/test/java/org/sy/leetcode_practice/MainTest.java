package org.sy.leetcode_practice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MainTest {

    private static final Log logger = LogFactory.getLog(MainTest.class);

    public static void main(String[] args) {
        int head = 2;
        int tail = 1;
        int length = 5;
        int index = (head - tail + length) % length;
        logger.debug(index);
    }

}
