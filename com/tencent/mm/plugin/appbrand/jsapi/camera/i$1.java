package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.camera.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import org.json.JSONObject;

class i$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ JSONObject fHi;
    final /* synthetic */ i fOI;

    i$1(i iVar, JSONObject jSONObject, l lVar, int i) {
        this.fOI = iVar;
        this.fHi = jSONObject;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void run() {
        int optInt = this.fHi.optInt("cameraId");
        String optString = this.fHi.optString(DownloadSettingTable$Columns.TYPE);
        x.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[]{Integer.valueOf(optInt), optString});
        a aiD = a.aiD();
        Integer valueOf = Integer.valueOf(optInt);
        AppBrandCameraView appBrandCameraView = aiD.fNX.containsKey(valueOf) ? (AppBrandCameraView) aiD.fNX.get(valueOf) : null;
        if (appBrandCameraView == null) {
            this.fCl.E(this.doP, this.fOI.f("fail:no such camera", null));
            return;
        }
        appBrandCameraView.setOperateCallBack(new 1(this));
        optInt = -1;
        switch (optString.hashCode()) {
            case -1909077165:
                if (optString.equals("startRecord")) {
                    optInt = 1;
                    break;
                }
                break;
            case -1391995149:
                if (optString.equals("stopRecord")) {
                    optInt = 2;
                    break;
                }
                break;
            case 1484838379:
                if (optString.equals("takePhoto")) {
                    optInt = 0;
                    break;
                }
                break;
        }
        switch (optInt) {
            case 0:
                appBrandCameraView.setQuality(this.fHi.optString("quality", "high"));
                if (appBrandCameraView.fOb != null) {
                    appBrandCameraView.fOb.aiM();
                    return;
                }
                return;
            case 1:
                if (appBrandCameraView.fOb != null) {
                    appBrandCameraView.fOb.aiN();
                    return;
                }
                return;
            case 2:
                if (appBrandCameraView.fOb != null) {
                    appBrandCameraView.fOb.aiO();
                    return;
                }
                return;
            default:
                x.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[]{optString});
                this.fCl.E(this.doP, this.fOI.f("fail:operateType not supported", null));
                return;
        }
    }
}
