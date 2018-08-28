package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class AppBrandCameraView$1 implements c {
    final /* synthetic */ AppBrandCameraView fOz;

    AppBrandCameraView$1(AppBrandCameraView appBrandCameraView) {
        this.fOz = appBrandCameraView;
    }

    public final void aiL() {
        x.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
        Map hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.a(this.fOz)));
        String jSONObject = new JSONObject(hashMap).toString();
        h a = new d().a(AppBrandCameraView.b(this.fOz));
        a.mData = jSONObject;
        a.ahM();
    }
}
