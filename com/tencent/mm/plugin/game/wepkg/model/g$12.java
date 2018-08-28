package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader;
import com.tencent.mm.sdk.platformtools.bi;

class g$12 implements Runnable {
    final /* synthetic */ String fRy;
    final /* synthetic */ String keN;
    final /* synthetic */ a kfC;
    final /* synthetic */ WepkgDownloadProcessTask kfD;
    final /* synthetic */ int kfG;
    final /* synthetic */ String kfH;
    final /* synthetic */ long kfI;
    final /* synthetic */ String kfJ;
    final /* synthetic */ int kfK;
    final /* synthetic */ String val$downloadUrl;

    g$12(int i, String str, String str2, String str3, long j, String str4, String str5, int i2, WepkgDownloadProcessTask wepkgDownloadProcessTask, a aVar) {
        this.kfG = i;
        this.keN = str;
        this.kfH = str2;
        this.val$downloadUrl = str3;
        this.kfI = j;
        this.kfJ = str4;
        this.fRy = str5;
        this.kfK = i2;
        this.kfD = wepkgDownloadProcessTask;
        this.kfC = aVar;
    }

    public final void run() {
        WePkgDownloader.aVu().a(this.kfG, bi.oV(this.keN), bi.oV(this.kfH), bi.oV(this.val$downloadUrl), this.kfI, bi.oV(this.kfJ), bi.oV(this.fRy), this.kfK, new 1(this));
    }
}
