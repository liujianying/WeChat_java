package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback.RetCode;
import com.tencent.mm.sdk.platformtools.x;

class WepkgDownloadProcessTask$1 implements IWepkgUpdateCallback {
    final /* synthetic */ WepkgDownloadProcessTask kfo;

    WepkgDownloadProcessTask$1(WepkgDownloadProcessTask wepkgDownloadProcessTask) {
        this.kfo = wepkgDownloadProcessTask;
    }

    public final void a(String str, String str2, RetCode retCode) {
        x.i("MicroMsg.Wepkg.WepkgDownloadProcessTask", "onPkgUpdatingCallback errCode:%s", retCode);
        this.kfo.cfX = str;
        this.kfo.ffK = str2;
        this.kfo.kfn = retCode;
        this.kfo.ahB();
        WepkgDownloadProcessTask.a(this.kfo);
    }
}
