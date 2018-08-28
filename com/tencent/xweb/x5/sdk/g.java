package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.xweb.x5.sdk.f.a;

public final class g implements b {
    public final boolean il(Context context) {
        return TbsDownloader.needSendRequest(context, false);
    }

    public final boolean a(Context context, boolean z, boolean z2, a aVar) {
        if (aVar == null) {
            return TbsDownloader.needDownload(context, z, z2, null);
        }
        return TbsDownloader.needDownload(context, z, z2, new a(aVar));
    }

    public final void startDownload(Context context, boolean z) {
        TbsDownloader.startDownload(context, z);
    }

    public final void stopDownload() {
        TbsDownloader.stopDownload();
    }

    public final boolean isDownloading() {
        return TbsDownloader.isDownloading();
    }

    public final boolean isDownloadForeground() {
        return TbsDownloader.isDownloadForeground();
    }
}
