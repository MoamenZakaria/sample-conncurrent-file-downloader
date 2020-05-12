package org.downloader.config;

public final class ApplicationConfig {

    private ApplicationConfig() {
    }

    public static int THREAD_NUM = 5;
    public static final int CONNECT_TIMEOUT = 1000;
    public static final int READ_TIMEOUT = 10000;
    public static  String BASE_DIR = "/Users/moamen/personalData/Work/projects/POCs/ConncurrentFileDownloader/files";

}
