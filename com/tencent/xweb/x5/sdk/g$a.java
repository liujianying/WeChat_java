package com.tencent.xweb.x5.sdk;

import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import com.tencent.xweb.x5.sdk.f.a;

class g$a implements TbsDownloaderCallback {
    a vEd;

    public g$a(a aVar) {
        this.vEd = aVar;
    }

    public final void onNeedDownloadFinish(boolean z, int i) {
        if (this.vEd != null) {
            this.vEd.onNeedDownloadFinish(z, i);
        }
    }
}
