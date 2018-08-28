package com.tencent.smtt.sdk;

public interface TbsListener {
    public static final String tag_load_error = "loaderror";

    void onDownloadFinish(int i);

    void onDownloadProgress(int i);

    void onInstallFinish(int i);
}
