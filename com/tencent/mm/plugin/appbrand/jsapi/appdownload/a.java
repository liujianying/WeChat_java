package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements l {
    public final void onTaskStarted(long j, String str) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            x.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskStarted, appId: " + cs.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_started";
            appbrandDownloadState.bGm = cs.field_downloadId;
            appbrandDownloadState.appId = cs.field_appId;
            if (cs.field_totalSize != 0) {
                appbrandDownloadState.bSP = (long) ((((float) cs.field_downloadedSize) / ((float) cs.field_totalSize)) * 100.0f);
            }
            appbrandDownloadState.fHs = cs.field_totalSize;
            d.c(appbrandDownloadState);
        }
    }

    public final void b(long j, String str, boolean z) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            x.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFinished, appId: " + cs.field_appId);
            if (cs.field_downloadInWifi) {
                cs.field_downloadInWifi = false;
                c.e(cs);
            }
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_succ";
            appbrandDownloadState.bGm = cs.field_downloadId;
            appbrandDownloadState.appId = cs.field_appId;
            appbrandDownloadState.bSP = 100;
            appbrandDownloadState.fHs = cs.field_totalSize;
            d.c(appbrandDownloadState);
        }
    }

    public final void b(long j, int i, boolean z) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            x.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskFailed, appId: %s, downloadInWifi: %b, isWifi: %b", new Object[]{cs.field_appId, Boolean.valueOf(cs.field_downloadInWifi), Boolean.valueOf(ao.isWifi(ad.getContext()))});
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!cs.field_downloadInWifi || ao.isWifi(ad.getContext())) {
                appbrandDownloadState.state = "download_failed";
            } else {
                appbrandDownloadState.state = "download_wait_wifi";
            }
            appbrandDownloadState.bGm = cs.field_downloadId;
            appbrandDownloadState.appId = cs.field_appId;
            appbrandDownloadState.fHs = cs.field_totalSize;
            d.c(appbrandDownloadState);
        }
    }

    public final void onTaskRemoved(long j) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            x.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskRemoved, appId: " + cs.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_removed";
            appbrandDownloadState.bGm = cs.field_downloadId;
            appbrandDownloadState.appId = cs.field_appId;
            appbrandDownloadState.fHs = cs.field_totalSize;
            d.c(appbrandDownloadState);
        }
    }

    public final void onTaskPaused(long j) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            x.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskPaused, appId: " + cs.field_appId);
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            if (!cs.field_downloadInWifi || ao.isWifi(ad.getContext())) {
                appbrandDownloadState.state = "download_paused";
            } else {
                appbrandDownloadState.state = "download_wait_wifi";
            }
            appbrandDownloadState.bGm = cs.field_downloadId;
            appbrandDownloadState.appId = cs.field_appId;
            appbrandDownloadState.fHs = cs.field_totalSize;
            if (cs.field_totalSize != 0) {
                appbrandDownloadState.bSP = (long) ((((float) cs.field_downloadedSize) / ((float) cs.field_totalSize)) * 100.0f);
            }
            d.c(appbrandDownloadState);
        }
    }

    public final void bP(long j) {
        com.tencent.mm.plugin.downloader.c.a cs = c.cs(j);
        if (cs != null) {
            AppbrandDownloadState appbrandDownloadState = new AppbrandDownloadState();
            appbrandDownloadState.state = "download_progress_changed";
            appbrandDownloadState.bGm = cs.field_downloadId;
            appbrandDownloadState.appId = cs.field_appId;
            if (cs.field_totalSize != 0) {
                appbrandDownloadState.bSP = (long) ((((float) cs.field_downloadedSize) / ((float) cs.field_totalSize)) * 100.0f);
            }
            x.i("MicroMsg.AppbrandFileDownloadCallback", "onTaskProgressChanged, appId: %s, progress: %d", new Object[]{cs.field_appId, Long.valueOf(appbrandDownloadState.bSP)});
            appbrandDownloadState.fHs = cs.field_totalSize;
            d.c(appbrandDownloadState);
        }
    }

    public final void h(long j, String str) {
    }
}
