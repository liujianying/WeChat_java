package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$2 implements OnClickListener {
    final /* synthetic */ JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask fVk;
    final /* synthetic */ JsApiUploadEncryptedFileToCDN fVl;

    JsApiUploadEncryptedFileToCDN$2(JsApiUploadEncryptedFileToCDN jsApiUploadEncryptedFileToCDN, JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask) {
        this.fVl = jsApiUploadEncryptedFileToCDN;
        this.fVk = jsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "do confirm upload in 2G/3G/4G network");
        this.fVk.ahA();
        AppBrandMainProcessService.a(this.fVk);
    }
}
