package com.tencent.mm.plugin.facedetect.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ Bundle iNb;
    final /* synthetic */ d iNd;
    final /* synthetic */ Context val$context;

    d$4(d dVar, Bundle bundle, int i, Context context) {
        this.iNd = dVar;
        this.iNb = bundle;
        this.bFr = i;
        this.val$context = context;
    }

    public final void onClick(View view) {
        if (bi.oW(this.iNd.iNc)) {
            x.e("MicroMsg.FaceDetectMpController", "alvinluo feedback url is null");
            return;
        }
        if (!(this.iNd.iMN == null || this.iNd.iMN.get() == null)) {
            ((e) this.iNd.iMN.get()).aJA();
        }
        String str = null;
        if (this.iNb != null) {
            str = this.iNb.getString("verify_result");
        }
        try {
            String str2 = "appid=%s;errcode=%d;identifyid=%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.iNd.appId != null ? this.iNd.appId : "";
            objArr[1] = Integer.valueOf(this.bFr);
            if (str == null) {
                str = "";
            }
            objArr[2] = str;
            x.i("MicroMsg.FaceDetectMpController", "alvinluo feedback url: %s", new Object[]{this.iNd.iNc + "?customInfo=" + p.encode(String.format(str2, objArr), "UTF-8")});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(this.val$context, "webview", ".ui.tools.WebViewUI", intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectMpController", e, "alvinluo start feedback webview exception", new Object[0]);
        }
    }
}
