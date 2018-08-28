package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.support.v4.app.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.p;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class g$3 implements a {
    final /* synthetic */ p fIY;
    final /* synthetic */ AppBrandCameraView fOG;
    final /* synthetic */ g fOH;

    g$3(g gVar, p pVar, AppBrandCameraView appBrandCameraView) {
        this.fOH = gVar;
        this.fIY = pVar;
        this.fOG = appBrandCameraView;
    }

    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Map hashMap;
        String jSONObject;
        h a;
        if (i == 16) {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                hashMap = new HashMap();
                hashMap.put("cameraId", Integer.valueOf(this.fOG.getCameraId()));
                jSONObject = new JSONObject(hashMap).toString();
                a = new d().a(this.fIY);
                a.mData = jSONObject;
                a.ahM();
                a$a.fNY.fNV = false;
                return;
            }
            a$a.fNY.fNV = true;
            this.fOH.a(this.fIY, this.fOG);
        } else if (i != 18) {
        } else {
            if (iArr == null || iArr.length <= 0 || iArr[0] != 0) {
                hashMap = new HashMap();
                hashMap.put("cameraId", Integer.valueOf(this.fOG.getCameraId()));
                jSONObject = new JSONObject(hashMap).toString();
                a = new d().a(this.fIY);
                a.mData = jSONObject;
                a.ahM();
                a$a.fNY.fNW = false;
                return;
            }
            a$a.fNY.fNW = true;
            this.fOH.a(this.fIY, this.fOG);
        }
    }
}
