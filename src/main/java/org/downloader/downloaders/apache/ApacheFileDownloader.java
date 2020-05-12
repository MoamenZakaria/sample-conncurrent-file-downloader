package org.downloader.downloaders.apache;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.downloader.config.ApplicationConfig;
import org.downloader.downloaders.FileDownloader;
import org.downloader.models.DownloadableFile;
import org.downloader.models.DownloadableFileResult;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Slf4j
public class ApacheFileDownloader implements FileDownloader {
    public DownloadableFileResult download(DownloadableFile downloadableFile) throws Exception {
        final String filePath = downloadableFile.getFilePath();
        final String url = downloadableFile.getUrl();
        if (StringUtils.isBlank(filePath) || StringUtils.isBlank(url))
            throw new Exception("File Path or URL are empty");

        try {
            long startTime = System.nanoTime();

            log.info("File ID #" + downloadableFile.getId() + " started");

            FileUtils.copyURLToFile(
                    new URL(url),
                    new File(filePath),
                    ApplicationConfig.CONNECT_TIMEOUT,
                    ApplicationConfig.READ_TIMEOUT);

            long endTime = System.nanoTime();
            long timeElapsed = (endTime - startTime) / 1000000; // nano seconds

            log.info("File ID #" + downloadableFile.getId() + " has been downloaded in " + timeElapsed + " ns");

        } catch (IOException e) {
            log.error("Something went wrong while download file " + downloadableFile.toString(), e);
        }
        return new DownloadableFileResult(url, filePath, true);
    }
}
