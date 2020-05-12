package org.downloader.downloaders;

import org.downloader.models.DownloadableFile;
import org.downloader.models.DownloadableFileResult;

public interface FileDownloader {

    DownloadableFileResult download(DownloadableFile downloadableFile) throws Exception;

}
