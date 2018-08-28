package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.plugin.appbrand.c.c;
import com.tencent.mm.plugin.appbrand.c.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiUploadEncryptedFileToCDN.JsApiUploadEncryptedMediaFileTask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$2 implements b {
    final /* synthetic */ JsApiUploadEncryptedMediaFileTask fVt;
    final /* synthetic */ AppBrandLocalMediaObject fVu;

    JsApiUploadEncryptedFileToCDN$JsApiUploadEncryptedMediaFileTask$2(JsApiUploadEncryptedMediaFileTask jsApiUploadEncryptedMediaFileTask, AppBrandLocalMediaObject appBrandLocalMediaObject) {
        this.fVt = jsApiUploadEncryptedMediaFileTask;
        this.fVu = appBrandLocalMediaObject;
    }

    public final void a(boolean z, String str, String str2, String str3) {
        x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", " on cdn finish,  is success : %s, mediaId : %s, localId : %s, mediaUrl : %s", new Object[]{Boolean.valueOf(z), str2, str, str3});
        if (!bi.oW(str) && str.equals(this.fVu.bNH)) {
            e.abl().a(this.fVt.fVr);
            e.abl().a(this.fVt.fVs);
            e.abl();
            com.tencent.mm.plugin.appbrand.c.b.rq(this.fVu.bNH);
            if (z) {
                this.fVt.fileId = str2;
                x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file success");
            } else {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "upload encrypt file false");
            }
            c abk = e.abk();
            String str4 = this.fVt.fileId;
            if (!bi.oW(str4)) {
                for (a aVar : abk.fnX.values()) {
                    if (bi.oV(aVar.fnN).equals(str4)) {
                        break;
                    }
                }
            }
            x.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByServerId error, media id is null or nil");
            a aVar2 = null;
            if (aVar2 == null || aVar2.fnO == null) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is null");
            } else {
                x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "cdn info is valid");
                this.fVt.dwK = aVar2.fnO.field_aesKey;
                this.fVt.fileId = aVar2.fnO.field_fileId;
                this.fVt.fileUrl = aVar2.fnO.field_fileUrl;
                this.fVt.fhf = aVar2.fnO.field_fileLength;
                x.d("MicroMsg.JsApiUploadEncryptedFileToCDN", "aesKey:%s, fileLength:%d", new Object[]{this.fVt.dwK, Integer.valueOf(this.fVt.fhf)});
            }
            this.fVt.fVp = 1;
            JsApiUploadEncryptedMediaFileTask.b(this.fVt);
        }
    }
}
