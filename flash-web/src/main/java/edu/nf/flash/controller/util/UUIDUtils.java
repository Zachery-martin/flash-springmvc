package edu.nf.flash.controller.util;

import java.util.UUID;

/**
 * @ClassName: UUIDUtils
 * @Author: Zachery
 * @Data: 15:39
 **/
public class UUIDUtils {

    public static String createUUID(String fileName) {
        String uuid= UUID.randomUUID().toString();
        uuid = uuid.replace("-", "").toUpperCase();
        return uuid.substring(0,20);
    }

    public static String createUUID() {
        String uuid= UUID.randomUUID().toString();
        uuid = uuid.replace("-", "").toUpperCase();
        return uuid.substring(0,20);
    }

    public static String createExtractionCode() {
        String uuid=UUID.randomUUID().toString();

        uuid = uuid.replace("-", "").toLowerCase();
        return uuid.substring(0,3);
    }
}
