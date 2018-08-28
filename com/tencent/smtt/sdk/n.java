package com.tencent.smtt.sdk;

import com.tencent.smtt.utils.TbsLog;

final class n implements TbsListener {
    n() {
    }

    public final void onDownloadFinish(int i) {
        if (TbsDownloader.needDownloadDecoupleCore()) {
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
            TbsDownloader.a = true;
            return;
        }
        TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
        TbsDownloader.a = false;
        if (QbSdk.c() != null) {
            QbSdk.c().onDownloadFinish(i);
        }
        if (QbSdk.d() != null) {
            QbSdk.d().onDownloadFinish(i);
        }
    }

    public final void onDownloadProgress(int i) {
        if (QbSdk.d() != null) {
            QbSdk.d().onDownloadProgress(i);
        }
        if (QbSdk.c() != null) {
            QbSdk.c().onDownloadProgress(i);
        }
    }

    public final void onInstallFinish(int i) {
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.a = false;
        if (TbsDownloader.startDecoupleCoreIfNeeded()) {
            TbsDownloader.a = true;
        } else {
            TbsDownloader.a = false;
        }
        if (QbSdk.c() != null) {
            QbSdk.c().onInstallFinish(i);
        }
        if (QbSdk.d() != null) {
            QbSdk.d().onInstallFinish(i);
        }
    }
}
