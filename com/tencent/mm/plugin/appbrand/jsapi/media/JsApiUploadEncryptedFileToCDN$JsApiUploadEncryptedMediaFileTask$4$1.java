package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask.4;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$1 implements OnClickListener {
    final /* synthetic */ 4 fVv;

    JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$4$1(4 4) {
        this.fVv = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel upload the media file");
        JsApiUploadEncryptedMediaFileTask.c(this.fVv.fVt).cancel();
        this.fVv.fVt.fVo = 1;
        this.fVv.fVt.fVp = 1;
        AppBrandMainProcessService.a(this.fVv.fVt);
    }
}
