package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class j extends b {
    private static final int CTRL_INDEX = 330;
    public static final String NAME = "removeCamera";

    protected final int k(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId", 0);
    }

    protected final boolean b(p pVar, int i, View view, JSONObject jSONObject) {
        super.b(pVar, i, view, jSONObject);
        x.i("MicroMsg.JsApiRemoveCamera", "onRemoveView cameraId=%d", new Object[]{Integer.valueOf(i)});
        if (view instanceof CoverViewContainer) {
            AppBrandCameraView appBrandCameraView = (AppBrandCameraView) ((CoverViewContainer) view).A(AppBrandCameraView.class);
            if (appBrandCameraView == null) {
                x.w("MicroMsg.JsApiRemoveCamera", "the camera view(%s) is null", new Object[]{Integer.valueOf(i)});
                return false;
            }
            pVar.b(appBrandCameraView);
            pVar.b(appBrandCameraView);
            pVar.b(appBrandCameraView);
            appBrandCameraView.release();
            return true;
        }
        x.w("MicroMsg.JsApiRemoveCamera", "the view(%s) is not a instance of CoverViewContainer", new Object[]{Integer.valueOf(i)});
        return false;
    }
}
