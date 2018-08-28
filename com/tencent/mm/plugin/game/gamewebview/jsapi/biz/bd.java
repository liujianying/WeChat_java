package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.1;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.2;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewUI;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import org.json.JSONObject;

public final class bd extends a {
    public static final int CTRL_BYTE = 237;
    public static final String NAME = "uploadMediaFile";
    private GameWebViewUI jGT;
    UploadMediaFileHelp jHA = new UploadMediaFileHelp();

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiUploadMediaFile", "invoke");
        if (jSONObject == null) {
            dVar.E(i, a.f("chooseVideo:fail_invalid_data", null));
            return;
        }
        boolean z;
        this.jGT = dVar.getPageActivity();
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("localId");
        if (jSONObject.optInt("isShowProgressTips", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        x.i("MicroMsg.GameJsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", new Object[]{optString, optString2, Boolean.valueOf(z)});
        if (bi.oW(optString) || bi.oW(optString2)) {
            x.e("MicroMsg.GameJsApiUploadMediaFile", "appId or localid is null or nil.");
            dVar.E(i, a.f("uploadMediaFile:fail_missing arguments", null));
            return;
        }
        UploadMediaFileHelp uploadMediaFileHelp = this.jHA;
        GameWebViewUI gameWebViewUI = this.jGT;
        1 1 = new 1(this, dVar, i);
        uploadMediaFileHelp.fcq = gameWebViewUI;
        uploadMediaFileHelp.jGU = dVar;
        uploadMediaFileHelp.mAppId = optString;
        uploadMediaFileHelp.jHD = optString2;
        uploadMediaFileHelp.jHE = z;
        uploadMediaFileHelp.jHF = 1;
        UploadMediaFileHelp uploadMediaFileHelp2 = this.jHA;
        WebViewJSSDKFileItem Db = com.tencent.mm.plugin.game.gamewebview.a.d.Db(uploadMediaFileHelp2.jHD);
        if (Db == null) {
            x.e("MicroMsg.UploadMediaFileHelp", "item is null");
            uploadMediaFileHelp2.jHF.a(false, null);
        } else if (Db.bMT == 1) {
            uploadMediaFileHelp2.aSz();
        } else if (bi.oW(Db.fnM) || !e.cn(Db.fnM)) {
            x.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
            uploadMediaFileHelp2.jHF.a(false, null);
        } else if (ab.bU(uploadMediaFileHelp2.fcq)) {
            uploadMediaFileHelp2.aSy();
        } else {
            optString = bi.gc((long) e.cm(Db.fnM));
            h.a(uploadMediaFileHelp2.fcq, uploadMediaFileHelp2.fcq.getString(R.l.webview_jssdk_upload_video_gprs_confirm, new Object[]{optString}), uploadMediaFileHelp2.fcq.getString(R.l.app_tip), false, new 1(uploadMediaFileHelp2), new 2(uploadMediaFileHelp2));
        }
    }
}
