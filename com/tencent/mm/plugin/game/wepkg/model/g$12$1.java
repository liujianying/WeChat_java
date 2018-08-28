package com.tencent.mm.plugin.game.wepkg.model;

import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader$IWepkgUpdateCallback$RetCode;
import com.tencent.mm.plugin.game.wepkg.downloader.WePkgDownloader.IWepkgUpdateCallback;
import com.tencent.mm.plugin.game.wepkg.model.g.12;
import com.tencent.mm.sdk.platformtools.x;

class g$12$1 implements IWepkgUpdateCallback {
    final /* synthetic */ 12 kfL;

    g$12$1(12 12) {
        this.kfL = 12;
    }

    public final void a(String str, String str2, WePkgDownloader$IWepkgUpdateCallback$RetCode wePkgDownloader$IWepkgUpdateCallback$RetCode) {
        x.i("MicroMsg.Wepkg.WepkgProcessTaskPerformer", "onPkgUpdatingCallback errCode:%s", new Object[]{wePkgDownloader$IWepkgUpdateCallback$RetCode});
        this.kfL.kfD.cfX = str;
        this.kfL.kfD.ffK = str2;
        this.kfL.kfD.kfn = wePkgDownloader$IWepkgUpdateCallback$RetCode;
        if (this.kfL.kfC != null) {
            this.kfL.kfC.a(this.kfL.kfD);
        }
    }
}
