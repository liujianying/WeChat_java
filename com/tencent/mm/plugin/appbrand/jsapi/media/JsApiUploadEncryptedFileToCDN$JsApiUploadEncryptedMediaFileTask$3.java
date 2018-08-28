package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$3 implements OnCancelListener {
    final /* synthetic */ JsApiUploadEncryptedMediaFileTask fVt;

    JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$3(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask) {
        this.fVt = jsApiUploadEncryptedMediaFileTask;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "user cancel uploading the media file");
        dialogInterface.dismiss();
        this.fVt.fVo = 1;
        this.fVt.fVp = 1;
        AppBrandMainProcessService.a(this.fVt);
    }
}
