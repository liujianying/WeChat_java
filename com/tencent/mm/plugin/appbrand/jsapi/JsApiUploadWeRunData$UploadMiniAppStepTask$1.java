package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData.UploadMiniAppStepTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadWeRunData$UploadMiniAppStepTask$1 implements a {
    final /* synthetic */ UploadMiniAppStepTask fHq;

    JsApiUploadWeRunData$UploadMiniAppStepTask$1(UploadMiniAppStepTask uploadMiniAppStepTask) {
        this.fHq = uploadMiniAppStepTask;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        if (lVar.getType() == 1949) {
            if (i == 0 && i2 == 0) {
                UploadMiniAppStepTask.a(this.fHq, true);
                x.d("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask ok.");
            } else {
                UploadMiniAppStepTask.a(this.fHq, false);
                x.i("MicroMsg.JsApiUploadWeRunData", "UploadMiniAppStepTask fail: errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            }
            UploadMiniAppStepTask.a(this.fHq);
        }
        return 0;
    }
}
