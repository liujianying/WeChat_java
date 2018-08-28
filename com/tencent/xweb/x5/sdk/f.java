package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.xweb.r;
import org.xwalk.core.Log;

public final class f {
    static b vEc;

    static {
        r.initInterface();
    }

    public static void a(b bVar) {
        vEc = bVar;
    }

    public static boolean il(Context context) {
        if (vEc != null) {
            return vEc.il(context);
        }
        Log.e("TbsDownloader", "needSendRequest: sImp is null");
        return false;
    }

    public static boolean needDownload(Context context, boolean z) {
        return a(context, z, false, null);
    }

    public static boolean a(Context context, boolean z, boolean z2, a aVar) {
        if (vEc != null) {
            return vEc.a(context, z, z2, aVar);
        }
        Log.e("TbsDownloader", "needDownload: sImp is null");
        return false;
    }

    public static void startDownload(Context context) {
        startDownload(context, false);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        synchronized (f.class) {
            if (vEc != null) {
                vEc.startDownload(context, z);
            } else {
                Log.e("TbsDownloader", "startDownload: sImp is null");
            }
        }
    }

    public static void stopDownload() {
        if (vEc != null) {
            vEc.stopDownload();
        } else {
            Log.e("TbsDownloader", "stopDownload: sImp is null");
        }
    }

    public static synchronized boolean isDownloading() {
        boolean isDownloading;
        synchronized (f.class) {
            if (vEc != null) {
                isDownloading = vEc.isDownloading();
            } else {
                Log.e("TbsDownloader", "isDownloading: sImp is null");
                isDownloading = false;
            }
        }
        return isDownloading;
    }

    public static boolean isDownloadForeground() {
        if (vEc != null) {
            return vEc.isDownloadForeground();
        }
        Log.e("TbsDownloader", "isDownloadForeground: sImp is null");
        return false;
    }
}
