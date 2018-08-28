package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends c {
    private static final int CTRL_INDEX = 331;
    public static final String NAME = "updateCamera";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }

    protected final boolean c(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiUpdateCamera", "onUpdateView : cameraId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            AppBrandCameraView appBrandCameraView = (AppBrandCameraView) ((CoverViewContainer) view).A(AppBrandCameraView.class);
            if (appBrandCameraView == null) {
                x.w("MicroMsg.JsApiUpdateCamera", "the camera view(%s) is null", new Object[]{Integer.valueOf(i)});
                return false;
            }
            int optInt = jSONObject.optInt("cameraId");
            String optString = jSONObject.optString("devicePosition", "back");
            String optString2 = jSONObject.optString("flash", "auto");
            boolean optBoolean = jSONObject.optBoolean("needOutput", false);
            appBrandCameraView.setAppId(pVar.mAppId);
            appBrandCameraView.Y(optString, false);
            appBrandCameraView.setFlash(optString2);
            appBrandCameraView.setNeedOutput(optBoolean);
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            int a = f.a(optJSONObject, "width", 0);
            int a2 = f.a(optJSONObject, "height", 0);
            x.d("MicroMsg.JsApiUpdateCamera", "onUpdateView cameraId: %d, devicePosition: %s,flash: %s,width： %d,height： %d", new Object[]{Integer.valueOf(optInt), optString, optString2, Integer.valueOf(a), Integer.valueOf(a2)});
            boolean z = false;
            if (!(a == 0 || a2 == 0)) {
                z = appBrandCameraView.bL(a, a2);
            }
            optString = jSONObject.optString("mode");
            if (!bi.oW(optString)) {
                appBrandCameraView.setMode(optString);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                x.i("MicroMsg.JsApiUpdateCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[]{optJSONArray, Integer.valueOf(optJSONArray.length())});
                appBrandCameraView.l(f.lP(optJSONArray.optInt(0)), f.lP(optJSONArray.optInt(1)), f.lP(optJSONArray.optInt(2)), f.lP(optJSONArray.optInt(3)));
            }
            appBrandCameraView.setScanFreq(jSONObject.optInt("scanFreq"));
            if (z) {
                appBrandCameraView.release();
                appBrandCameraView.initView();
            } else {
                appBrandCameraView.aiF();
            }
            return true;
        }
        x.w("MicroMsg.JsApiUpdateCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
