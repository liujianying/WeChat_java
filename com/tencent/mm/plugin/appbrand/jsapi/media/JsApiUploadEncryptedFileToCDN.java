package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class JsApiUploadEncryptedFileToCDN extends a {
    public static final int CTRL_INDEX = 194;
    public static final String NAME = "uploadEncryptedFileToCDN";

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        MMActivity c = c(lVar);
        if (c == null) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  pageContext is null");
            lVar.E(i, f("fail", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  data is null");
            lVar.E(i, f("fail:data is null", null));
        } else {
            String str = lVar.mAppId;
            String optString = jSONObject.optString("tempFilePath");
            boolean optBoolean = jSONObject.optBoolean("isShowProgressTips", false);
            x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "JsApiUploadEncryptedFileToCDN appId:%s, data:%s", new Object[]{str, jSONObject.toString()});
            if (bi.oW(optString)) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath is null");
                lVar.E(i, f("fail:tempFilePath is null", null));
                return;
            }
            AppBrandLocalMediaObject itemByLocalId = AppBrandLocalMediaObjectManager.getItemByLocalId(str, optString);
            if (itemByLocalId == null) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail,  tempFilePath file is not exist");
                lVar.E(i, f("fail:file doesn't exist", null));
            } else if (TextUtils.isEmpty(itemByLocalId.dDG)) {
                x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "uploadEncryptedFileToCDN fail, fileFullPath is null");
                lVar.E(i, f("fail:fileFullPath is null", null));
            } else {
                final MainProcessTask jsApiUploadEncryptedMediaFileTask = new JsApiUploadEncryptedMediaFileTask();
                jsApiUploadEncryptedMediaFileTask.appId = str;
                jsApiUploadEncryptedMediaFileTask.bNH = optString;
                jsApiUploadEncryptedMediaFileTask.fVm = optBoolean;
                jsApiUploadEncryptedMediaFileTask.fVq = c;
                jsApiUploadEncryptedMediaFileTask.fFa = lVar;
                jsApiUploadEncryptedMediaFileTask.mimeType = itemByLocalId.mimeType;
                jsApiUploadEncryptedMediaFileTask.fFC = new 1(this, jsApiUploadEncryptedMediaFileTask, lVar, i);
                if (ab.bU(c)) {
                    x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "wifi network available, do not show the gprs confirm dialog");
                    jsApiUploadEncryptedMediaFileTask.ahA();
                    AppBrandMainProcessService.a(jsApiUploadEncryptedMediaFileTask);
                    return;
                }
                x.i("MicroMsg.JsApiUploadEncryptedFileToCDN", "2G/3G/4G network available, do upload in mobile network and show the gprs confirm tips dialog");
                if (TextUtils.isEmpty(itemByLocalId.mimeType) || !itemByLocalId.mimeType.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                    str = c.getString(j.appbrand_jssdk_image);
                } else {
                    str = c.getString(j.appbrand_jssdk_video);
                }
                optString = bi.gc((long) e.cm(itemByLocalId.dDG));
                h.a(c, c.getString(j.appbrand_jssdk_upload_media_file_gprs_confirm, new Object[]{str, optString}), c.getString(j.app_tip), new 2(this, jsApiUploadEncryptedMediaFileTask), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        x.e("MicroMsg.JsApiUploadEncryptedFileToCDN", "do cancel upload in 2G/3G/4G network");
                        lVar.E(i, JsApiUploadEncryptedFileToCDN.this.f("cancel", null));
                        jsApiUploadEncryptedMediaFileTask.ahB();
                    }
                });
            }
        }
    }
}
