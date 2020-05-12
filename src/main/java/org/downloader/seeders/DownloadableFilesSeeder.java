package org.downloader.seeders;

import org.downloader.config.ApplicationConfig;
import org.downloader.enums.DocType;
import org.downloader.models.DownloadableFile;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

public final class DownloadableFilesSeeder {
    private static List<DownloadableFile> downloadableFiles = new ArrayList<>();


    public static List<DownloadableFile> getDownloadableFiles() {

        // path could be enhanced using sys separator. but this is only for demonstrating
        final DownloadableFile downloadableFile1 = new DownloadableFile(1, "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf", ApplicationConfig.BASE_DIR + File.separator+ System.currentTimeMillis() + "."+DocType.pdf.name());
        final DownloadableFile downloadableFile2 = new DownloadableFile(2, "http://qurango.com/download/qurancolor.pdf", ApplicationConfig.BASE_DIR + File.separator+ System.currentTimeMillis() + "."+DocType.pdf.name());
        // add more...


        downloadableFiles.add(downloadableFile1);
        downloadableFiles.add(downloadableFile2);
        return downloadableFiles;
    }
}
