package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import org.json.JSONArray;
import org.json.JSONObject;

final class bu extends a {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";
    private static final SparseArray<Integer> fHm = new SparseArray();

    bu() {
        fHm.put("firstRenderTime".hashCode(), Integer.valueOf(ao.CTRL_BYTE));
        fHm.put("reRenderTime".hashCode(), Integer.valueOf(TbsListener$ErrorCode.ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY));
        fHm.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
        fHm.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR));
        fHm.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(TbsListener$ErrorCode.INFO_DISABLE_X5));
        fHm.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(TbsListener$ErrorCode.INFO_CAN_NOT_LOAD_TBS));
        fHm.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(TbsListener$ErrorCode.INFO_MISS_SDKEXTENSION_JAR_OLD));
        fHm.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(TbsListener$ErrorCode.INFO_CAN_NOT_LOAD_X5));
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (!AppBrandPerformanceManager.vi(cVar.getAppId()) || optJSONArray == null) {
            cVar.E(i, f("fail", null));
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("key");
                    String optString2 = optJSONObject.optString("value");
                    if (!bi.oW(optString)) {
                        Integer num = (Integer) fHm.get(optString.hashCode());
                        if (num != null) {
                            AppBrandPerformanceManager.o(cVar.getAppId(), num.intValue(), optString2);
                        } else {
                            AppBrandPerformanceManager.H(cVar.getAppId(), optString, optString2);
                        }
                    }
                }
                i2 = i3 + 1;
            } else {
                cVar.E(i, f("ok", null));
                return;
            }
        }
    }
}
