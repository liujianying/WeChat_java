package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class JsApiUploadEncryptedFileToCDN$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JsApiUploadEncryptedMediaFileTask fVk;
    final /* synthetic */ JsApiUploadEncryptedFileToCDN fVl;

    JsApiUploadEncryptedFileToCDN$1(JsApiUploadEncryptedFileToCDN jsApiUploadEncryptedFileToCDN, JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask, l lVar, int i) {
        this.fVl = jsApiUploadEncryptedFileToCDN;
        this.fVk = jsApiUploadEncryptedMediaFileTask;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void run() {
        Map hashMap = new HashMap();
        hashMap.put("fileId", this.fVk.fileId);
        hashMap.put("aesKey", this.fVk.dwK);
        hashMap.put("fileUrl", this.fVk.fileUrl);
        hashMap.put("fileLength", this.fVk.fhf);
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fileId:%s", new Object[]{this.fVk.fileId});
        if (bi.oW(this.fVk.fileId)) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail , return serverId is empty");
            this.fCl.E(this.doP, this.fVl.f("fail", null));
        } else {
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN ok");
            this.fCl.E(this.doP, this.fVl.f("ok", hashMap));
        }
        this.fVk.ahB();
    }
}
