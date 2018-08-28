package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class h$3 extends a {
    final /* synthetic */ String keN;
    final /* synthetic */ boolean kfN;
    final /* synthetic */ h kfO;
    final /* synthetic */ List kfQ;

    h$3(h hVar, String str, List list, boolean z) {
        this.kfO = hVar;
        this.keN = str;
        this.kfQ = list;
        this.kfN = z;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        if ((this.object instanceof WepkgPreloadFile) && (baseWepkgProcessTask instanceof WepkgDownloadProcessTask)) {
            WepkgDownloadProcessTask wepkgDownloadProcessTask = (WepkgDownloadProcessTask) baseWepkgProcessTask;
            WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) this.object;
            if (wepkgDownloadProcessTask.kfn != RetCode.ken || bi.oW(wepkgDownloadProcessTask.ffK)) {
                x.i("MicroMsg.Wepkg.WepkgUpdater", "download, errCode:%s,  to loop", new Object[]{wepkgDownloadProcessTask.kfn});
                h.a(this.kfO, this.keN, this.kfQ, this.kfN);
                return;
            }
            String str = wepkgPreloadFile.kfA;
            String str2 = wepkgPreloadFile.kfk;
            String str3 = wepkgDownloadProcessTask.ffK;
            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
            wepkgCrossProcessTask.nc = 4002;
            wepkgCrossProcessTask.kfh.kfA = str;
            wepkgCrossProcessTask.kfh.kfk = str2;
            wepkgCrossProcessTask.kfh.filePath = str3;
            wepkgCrossProcessTask.kfh.kfB = true;
            if (ad.cic()) {
                wepkgCrossProcessTask.aai();
            } else {
                WepkgMainProcessService.b(wepkgCrossProcessTask);
            }
            boolean z = wepkgCrossProcessTask.bGZ;
            h.a(this.kfO, this.keN, this.kfQ, this.kfN);
            return;
        }
        x.i("MicroMsg.Wepkg.WepkgUpdater", "object instanceof  WepkgPreloadFile is false");
        h.a(this.kfO, this.keN, this.kfQ, this.kfN);
    }
}
