package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class JsApiChooseMedia extends a {
    public static final int CTRL_INDEX = 193;
    public static final String NAME = "chooseMedia";
    private static volatile boolean fUx = false;

    public final void a(final l lVar, JSONObject jSONObject, final int i) {
        if (fUx) {
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia sChoosingMedia is true, do not again");
            lVar.E(i, f("cancel", null));
            return;
        }
        MMActivity c = c(lVar);
        if (c == null) {
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  pageContext is null");
            lVar.E(i, f("fail:page context is null", null));
        } else if (jSONObject == null) {
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail,  data is null");
            lVar.E(i, f("fail:data is null", null));
        } else {
            boolean z;
            x.i("MicroMsg.JsApiChooseMedia", "chooseMedia data:" + jSONObject.toString());
            String str = "";
            if (jSONObject.optJSONArray("sourceType") == null || jSONObject.optJSONArray("sourceType").length() <= 0) {
                x.e("MicroMsg.JsApiChooseMedia", "sourceType is invalid param");
            } else {
                str = jSONObject.optJSONArray("sourceType").toString();
            }
            if (bi.oW(str)) {
                str = "camera|album";
            }
            String str2 = "";
            if (jSONObject.optJSONArray("mediaType") == null || jSONObject.optJSONArray("mediaType").length() <= 0) {
                x.e("MicroMsg.JsApiChooseMedia", "mediaType is invalid param");
            } else {
                str2 = jSONObject.optJSONArray("mediaType").toString();
            }
            if (bi.oW(str2)) {
                str2 = "video|image";
            }
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            if (min < 3 || min > 10) {
                x.e("MicroMsg.JsApiChooseMedia", "maxDuration is invalid");
                min = 10;
            }
            String optString = jSONObject.optString("camera");
            if (bi.oW(optString)) {
                optString = "back";
            }
            int min2 = Math.min(jSONObject.optInt("count", 9), 9);
            String str3 = "";
            if (jSONObject.optJSONArray("sizeType") == null || jSONObject.optJSONArray("sizeType").length() <= 0) {
                x.e("MicroMsg.JsApiChooseMedia", "sizeType is invalid param");
            } else {
                str3 = jSONObject.optJSONArray("sizeType").toString();
            }
            if (bi.oW(str3)) {
                str3 = "original|compressed";
            }
            x.i("MicroMsg.JsApiChooseMedia", "chooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{str, str2, Integer.valueOf(min), optString, Integer.valueOf(min2), str3});
            com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new 3(this, lVar, jSONObject, i));
            MMActivity c2 = c(lVar);
            if (c2 == null) {
                x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestAudioPermission pageContext is null");
                lVar.E(i, f("fail", null));
                z = false;
            } else {
                z = com.tencent.mm.pluginsdk.permission.a.a(c2, "android.permission.RECORD_AUDIO", 120, "", "");
                if (z) {
                    com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
                }
            }
            if (z) {
                com.tencent.mm.plugin.appbrand.a.a(lVar.mAppId, new 4(this, lVar, jSONObject, i));
                c2 = c(lVar);
                if (c2 == null) {
                    x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, requestCameraPermission pageContext is null");
                    lVar.E(i, f("fail", null));
                    z = false;
                } else {
                    z = com.tencent.mm.pluginsdk.permission.a.a(c2, "android.permission.CAMERA", 119, "", "");
                    if (z) {
                        com.tencent.mm.plugin.appbrand.a.pZ(lVar.mAppId);
                    }
                }
                if (z) {
                    x.i("MicroMsg.JsApiChooseMedia", "do chooseMedia");
                    fUx = true;
                    e.a(lVar.mAppId, new 1(this, lVar));
                    ChooseRequest chooseRequest = new ChooseRequest();
                    chooseRequest.appId = lVar.mAppId;
                    chooseRequest.fUz = str.contains("album");
                    chooseRequest.fUA = str.contains("camera");
                    chooseRequest.fUB = str2.contains("image");
                    chooseRequest.fUC = str2.contains("video");
                    if (optString.contains("back") || !optString.contains("front")) {
                        chooseRequest.isFront = false;
                    } else {
                        chooseRequest.isFront = true;
                    }
                    chooseRequest.maxDuration = min;
                    chooseRequest.count = min2;
                    chooseRequest.fUi = str3.contains("compressed");
                    chooseRequest.fUj = str3.contains("original");
                    com.tencent.mm.plugin.appbrand.ipc.a.a(c, chooseRequest, new b<ChooseResult>() {
                        public final /* synthetic */ void c(ProcessResult processResult) {
                            ChooseResult chooseResult = (ChooseResult) processResult;
                            JsApiChooseMedia.fUx = false;
                            if (chooseResult == null) {
                                x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult result is null");
                                lVar.E(i, JsApiChooseMedia.this.f("fail", null));
                                return;
                            }
                            switch (chooseResult.bjW) {
                                case -1:
                                    String str = chooseResult.type;
                                    String str2 = chooseResult.fUD;
                                    if (bi.oW(str2)) {
                                        x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult localIds is null");
                                        lVar.E(i, JsApiChooseMedia.this.f("fail", null));
                                        return;
                                    }
                                    Map hashMap = new HashMap();
                                    hashMap.put("type", str);
                                    hashMap.put("tempFiles", str2);
                                    x.i("MicroMsg.JsApiChooseMedia", "chooseMedia ok, type:%s, localIds:%s", new Object[]{str, str2});
                                    lVar.E(i, JsApiChooseMedia.this.f("ok", hashMap));
                                    return;
                                case 0:
                                    x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult user cancel");
                                    lVar.E(i, JsApiChooseMedia.this.f("fail:cancel", null));
                                    return;
                                default:
                                    x.e("MicroMsg.JsApiChooseMedia", "chooseMedia fail, onReceiveResult");
                                    lVar.E(i, JsApiChooseMedia.this.f("fail", null));
                                    return;
                            }
                        }
                    });
                    return;
                }
                x.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestCameraPermission is fail");
                return;
            }
            x.e("MicroMsg.JsApiChooseMedia", "chooseMedia requestAudioPermission is fail");
        }
    }
}
