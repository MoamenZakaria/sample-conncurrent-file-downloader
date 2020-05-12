package org.downloader;

import org.downloader.config.ApplicationConfig;
import org.downloader.models.DownloadableFileResult;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppManager {

    private static ExecutorService executorService;
    private static CompletionService<DownloadableFileResult> completionService;


    public static void init() {
        executorService = Executors.newFixedThreadPool(ApplicationConfig.THREAD_NUM);
        completionService = new ExecutorCompletionService<>(executorService);
    }

    public static ExecutorService getExecutorService() {
        if (executorService == null)
            executorService = Executors.newFixedThreadPool(ApplicationConfig.THREAD_NUM);

        return executorService;
    }


    public static CompletionService<DownloadableFileResult> getCompletionService() {
        if (completionService == null)
            completionService = new ExecutorCompletionService<>(getExecutorService());

        return completionService;
    }


}
