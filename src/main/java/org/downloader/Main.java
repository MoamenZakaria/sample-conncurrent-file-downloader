package org.downloader;

import lombok.extern.slf4j.Slf4j;
import org.downloader.models.DownloadableFile;
import org.downloader.models.DownloadableFileResult;
import org.downloader.seeders.DownloadableFilesSeeder;
import org.downloader.threads.FileDownloaderCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
public class Main {

    public static void main(String[] args) {
        init();
        try {
            AppManager.getExecutorService().shutdown();
            while (!AppManager.getExecutorService().isTerminated()) {
                final Future<DownloadableFileResult> future = AppManager.getCompletionService().take();
                final DownloadableFileResult downloadableFileResult = future.get();
                // do whatever u want with the result
                // ...
                // ...
            }

            log.info("All file has been downloaded");
            log.info("Shutting down service executor...");
        } catch (ExecutionException | InterruptedException ex) {
            log.error("Something went wrong while getting result", ex);
        }
    }

    private static void init() {
        final List<FileDownloaderCallable> callableTasks = getCallableTasks();
        submitTasks(callableTasks);
    }

    private static List<FileDownloaderCallable> getCallableTasks() {
        final List<FileDownloaderCallable> downloaderCallable = new ArrayList<>();
        final List<DownloadableFile> downloadableFiles = DownloadableFilesSeeder.getDownloadableFiles();
        downloadableFiles.forEach(file -> downloaderCallable.add(new FileDownloaderCallable(file)));
        return downloaderCallable;
    }

    private static void submitTasks(List<FileDownloaderCallable> downloaderCallable) {
        for (final Callable<DownloadableFileResult> callable : downloaderCallable) {
            AppManager.getCompletionService().submit(callable);
        }
    }
}
