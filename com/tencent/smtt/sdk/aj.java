package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class aj extends Handler {
    aj(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case 100:
                boolean z2 = message.arg1 == 1;
                z = TbsDownloader.a(true, false);
                if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                    TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + z);
                    if (!z || z2) {
                        ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(z, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
                    }
                }
                if (TbsShareManager.isThirdPartyApp(TbsDownloader.a()) && z) {
                    TbsDownloader.startDownload(TbsDownloader.a());
                    return;
                }
                return;
            case 101:
            case 108:
                FileLock fileLock = null;
                FileOutputStream b = j.b(TbsDownloader.a(), false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt");
                if (b != null) {
                    fileLock = j.a(TbsDownloader.a(), b);
                    if (fileLock == null) {
                        TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
                        TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
                        TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                        return;
                    }
                } else if (j.a(TbsDownloader.a())) {
                    TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
                    TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                    return;
                }
                boolean z3 = message.arg1 == 1;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(TbsDownloader.a());
                if (!TbsDownloader.a(false, z3, 108 == message.what)) {
                    QbSdk.m.onDownloadFinish(110);
                } else if (z3 && an.a().a(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0))) {
                    QbSdk.m.onDownloadFinish(122);
                    instance.setDownloadInterruptCode(-213);
                } else if (instance.mPreferences.getBoolean("tbs_needdownload", false)) {
                    TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
                    ag b2 = TbsDownloader.b();
                    if (108 != message.what) {
                        z = false;
                    }
                    b2.b(z3, z);
                } else {
                    QbSdk.m.onDownloadFinish(110);
                }
                TbsLog.i("TbsDownload", "------freeFileLock called :");
                j.a(fileLock, b);
                return;
            case 102:
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                int a = TbsShareManager.isThirdPartyApp(TbsDownloader.a()) ? TbsShareManager.a(TbsDownloader.a(), false) : an.a().m(TbsDownloader.a());
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + a);
                TbsDownloader.b().a(a);
                TbsLogReport.a(TbsDownloader.a()).b();
                return;
            case 103:
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                if (message.arg1 == 0) {
                    an.a().a((Context) message.obj, true);
                    return;
                } else {
                    an.a().a((Context) message.obj, false);
                    return;
                }
            case 104:
                TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                TbsLogReport.a(TbsDownloader.a()).c();
                return;
            default:
                return;
        }
    }
}
