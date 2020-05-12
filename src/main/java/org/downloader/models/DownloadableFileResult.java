package org.downloader.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DownloadableFileResult {

    private String url;
    private String filePath;
    private boolean isDownloaded;


}
