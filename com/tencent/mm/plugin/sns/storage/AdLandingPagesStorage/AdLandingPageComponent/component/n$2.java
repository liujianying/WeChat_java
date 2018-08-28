package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a;
import com.tencent.mm.protocal.c.mv;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class n$2 implements a {
    final /* synthetic */ n nDS;

    n$2(n nVar) {
        this.nDS = nVar;
    }

    public final void at(Object obj) {
    }

    public final void e(int i, int i2, Object obj) {
        if (i == 0 && i2 == 0) {
            mv mvVar = new mv();
            try {
                mvVar.aG((byte[]) obj);
            } catch (Throwable e) {
                x.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bi.i(e));
            }
            if (!TextUtils.isEmpty(mvVar.rqU)) {
                x.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + mvVar.rqU);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", mvVar.rqU);
                intent.putExtra("showShare", true);
                d.b(this.nDS.context, "webview", ".ui.tools.WebViewUI", intent);
                n.a(this.nDS).Dd(10);
                return;
            } else if (mvVar.rqT != null) {
                n.b(this.nDS).nzT = mvVar.rqT.rqK;
                n.b(this.nDS).bKg = mvVar.rqT.rqI;
                n.b(this.nDS).downloadUrl = mvVar.rqT.rqJ;
                n.b(this.nDS).fileSize = (long) mvVar.rqT.rqN;
                n.a(this.nDS).Dd(6);
                return;
            } else {
                x.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
                n.a(this.nDS).Dd(5);
                return;
            }
        }
        n.a(this.nDS).Dd(5);
    }
}
