package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    private static final int CTRL_INDEX = 329;
    public static final String NAME = "insertCamera";

    protected final View a(p pVar, JSONObject jSONObject) {
        Context context = pVar.mContext;
        AppBrandCameraView appBrandCameraView = new AppBrandCameraView(context);
        int optInt = jSONObject.optInt("cameraId");
        String optString = jSONObject.optString("mode", "normal");
        String optString2 = jSONObject.optString("devicePosition", "back");
        String optString3 = jSONObject.optString("flash", "auto");
        boolean optBoolean = jSONObject.optBoolean("needOutput", false);
        appBrandCameraView.setAppId(pVar.mAppId);
        appBrandCameraView.setMode(optString);
        appBrandCameraView.setPage(pVar);
        appBrandCameraView.setCameraId(optInt);
        appBrandCameraView.Y(optString2, true);
        appBrandCameraView.setFlash(optString3);
        appBrandCameraView.setNeedOutput(optBoolean);
        JSONObject optJSONObject = jSONObject.optJSONObject("position");
        int a = f.a(optJSONObject, "width", 0);
        int a2 = f.a(optJSONObject, "height", 0);
        if (!(a == 0 || a2 == 0)) {
            appBrandCameraView.bL(a, a2);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("scanArea");
        if (optJSONArray == null || optJSONArray.length() != 4) {
            appBrandCameraView.l(0, 0, a, a2);
        } else {
            x.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", optJSONArray, Integer.valueOf(optJSONArray.length()));
            appBrandCameraView.l(f.lP(optJSONArray.optInt(0)), f.lP(optJSONArray.optInt(1)), f.lP(optJSONArray.optInt(2)), f.lP(optJSONArray.optInt(3)));
        }
        appBrandCameraView.setScanFreq(jSONObject.optInt("scanFreq"));
        x.d("MicroMsg.JsApiInsertCamera", "inflateView appId:%s,cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", pVar.mAppId, Integer.valueOf(optInt), optString2, optString3, Integer.valueOf(a), Integer.valueOf(a2));
        a(pVar, appBrandCameraView);
        return new CoverViewContainer(context, appBrandCameraView);
    }

    protected final int k(JSONObject jSONObject) {
        return jSONObject.optInt("cameraId");
    }

    protected final void a(p pVar, int i, View view, JSONObject jSONObject) {
        x.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", Integer.valueOf(i));
        AppBrandCameraView appBrandCameraView = (AppBrandCameraView) ((CoverViewContainer) view).A(AppBrandCameraView.class);
        if (appBrandCameraView == null) {
            x.w("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", Integer.valueOf(i));
            return;
        }
        a aiD = a.a.aiD();
        aiD.fNX.put(Integer.valueOf(appBrandCameraView.getCameraId()), appBrandCameraView);
        pVar.a(appBrandCameraView);
        pVar.a(appBrandCameraView);
        pVar.a(appBrandCameraView);
        e.a(pVar.mAppId, new 1(this, pVar, appBrandCameraView, i));
        appBrandCameraView.setOutPutCallBack(new 2(this));
    }

    final boolean a(p pVar, AppBrandCameraView appBrandCameraView) {
        com.tencent.mm.plugin.appbrand.a.a(pVar.mAppId, new 3(this, pVar, appBrandCameraView));
        Activity activity = (Activity) pVar.mContext;
        if (activity == null) {
            return false;
        }
        boolean a = com.tencent.mm.pluginsdk.permission.a.a(activity, "android.permission.CAMERA", 16, "", "");
        a.a.aiD().fNV = a;
        if (!a) {
            return false;
        }
        boolean a2 = com.tencent.mm.pluginsdk.permission.a.a(activity, "android.permission.RECORD_AUDIO", 18, "", "");
        a.a.aiD().fNW = a2;
        if (!a2) {
            return false;
        }
        com.tencent.mm.plugin.appbrand.a.pZ(pVar.mAppId);
        appBrandCameraView.initView();
        return true;
    }
}
