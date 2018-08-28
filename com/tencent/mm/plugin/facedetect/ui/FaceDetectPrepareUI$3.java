package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.compatible.util.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectPrepareUI$3 implements OnClickListener {
    final /* synthetic */ int bFr;
    final /* synthetic */ FaceDetectPrepareUI iRf;

    FaceDetectPrepareUI$3(FaceDetectPrepareUI faceDetectPrepareUI, int i) {
        this.iRf = faceDetectPrepareUI;
        this.bFr = i;
    }

    public final void onClick(View view) {
        if (bi.oW(FaceDetectPrepareUI.g(this.iRf))) {
            x.e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
            return;
        }
        FaceDetectPrepareUI.h(this.iRf);
        try {
            String str = "appid=%s;errcode=%d;identifyid=%s";
            Object[] objArr = new Object[3];
            objArr[0] = FaceDetectPrepareUI.i(this.iRf) != null ? FaceDetectPrepareUI.i(this.iRf) : "";
            objArr[1] = Integer.valueOf(this.bFr);
            objArr[2] = "";
            x.i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", new Object[]{FaceDetectPrepareUI.g(this.iRf) + "?customInfo=" + p.encode(String.format(str, objArr), "UTF-8")});
            Intent intent = new Intent();
            intent.putExtra("rawUrl", r0);
            d.b(this.iRf, "webview", ".ui.tools.WebViewUI", intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "alvinluo start feedback webview exception", new Object[0]);
        }
    }
}
