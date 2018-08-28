package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.bi;

class h$2 extends a {
    final /* synthetic */ String keN;
    final /* synthetic */ boolean kfN;
    final /* synthetic */ h kfO;
    final /* synthetic */ a kfP;

    h$2(h hVar, a aVar, boolean z, String str) {
        this.kfO = hVar;
        this.kfP = aVar;
        this.kfN = z;
        this.keN = str;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        if (baseWepkgProcessTask instanceof WepkgDownloadProcessTask) {
            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
            if (wepkgDownloadProcessTask.kfn != RetCode.ken || bi.oW(wepkgDownloadProcessTask.cfX) || bi.oW(wepkgDownloadProcessTask.ffK)) {
                h.k(this.kfN, this.keN);
                return;
            } else {
                g.a(wepkgDownloadProcessTask.cfX, wepkgDownloadProcessTask.ffK, true, this.kfP);
                return;
            }
        }
        h.k(this.kfN, this.keN);
    }
}
