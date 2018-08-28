package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.c.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1 implements a {
    final /* synthetic */ JsApiUploadEncryptedMediaFileTask fVt;

    JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$1(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
        this.fVt = jsApiUploadEncryptedMediaFileTask;
    }

    public final void B(int i, String str) {
        x.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "progress, percent:%d, localId:%s", new Object[]{Integer.valueOf(i), str});
        this.fVt.fVn = i;
        this.fVt.fVp = 3;
        JsApiUploadEncryptedMediaFileTask.a(this.fVt);
    }
}
