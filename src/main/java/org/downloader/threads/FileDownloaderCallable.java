package org.downloader.threads;

import org.downloader.downloaders.apache.ApacheFileDownloader;
import org.downloader.downloaders.FileDownloader;
import org.downloader.models.DownloadableFile;
import org.downloader.models.DownloadableFileResult;

import java.util.concurrent.Callable;

public class FileDownloaderCallable implements Callable<DownloadableFileResult> {

    FileDownloader fileDownloader = new ApacheFileDownloader();

    public FileDownloaderCallable(DownloadableFile downloadableFile) {
        this.downloadableFile = downloadableFile;
    }

    DownloadableFile downloadableFile;

    public DownloadableFileResult call() throws Exception {
        //implement extra logic...

        return fileDownloader.download(downloadableFile);
    }


}
