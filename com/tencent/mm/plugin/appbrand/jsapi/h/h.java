package com.tencent.mm.plugin.appbrand.jsapi.h;

import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.k.j;
import com.tencent.mm.plugin.appbrand.k.k;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class h extends a {
    public static final int CTRL_INDEX = 347;
    public static final String NAME = "operateSocketTask";

    public final void a(l lVar, JSONObject jSONObject, int i) {
        x.d("MicroMsg.JsApiOperateSocketTask", "JsApiOperateSocketTask");
        if (jSONObject == null) {
            lVar.E(i, f("fail:data is null", null));
            x.e("MicroMsg.JsApiOperateSocketTask", "data is null");
            return;
        }
        String optString = jSONObject.optString("socketTaskId");
        if (bi.oW(optString)) {
            x.e("MicroMsg.JsApiOperateSocketTask", "taskId is null");
            lVar.E(i, f("fail:taskId is null or nil", null));
            return;
        }
        String optString2 = jSONObject.optString("operationType");
        if (bi.oW(optString2)) {
            x.e("MicroMsg.JsApiOperateSocketTask", "operationType is null");
            lVar.E(i, f("fail:operationType is null or nil", null));
            return;
        }
        j uT = k.aly().uT(lVar.mAppId);
        if (uT == null) {
            lVar.E(i, f("fail:no task", null));
            x.w("MicroMsg.JsApiOperateSocketTask", "client is null");
            return;
        }
        com.tencent.mm.plugin.appbrand.s.a.a uS = uT.uS(optString);
        if (uS == null) {
            lVar.E(i, f("fail:taskID not exist", null));
            x.w("MicroMsg.JsApiOperateSocketTask", "webSocketClient is null");
        } else if (optString2.equals("close")) {
            int optInt = jSONObject.optInt("code", TbsLog.TBSLOG_CODE_SDK_BASE);
            if (optInt == TbsLog.TBSLOG_CODE_SDK_BASE || (optInt >= 3000 && optInt < Downloads.MIN_RETYR_AFTER)) {
                String optString3 = jSONObject.optString("reason", "");
                if (uS != null) {
                    try {
                        x.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                        if (uS.gDi != null) {
                            uS.S(optInt, optString3);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + e.toString());
                    }
                    uT.b(uS);
                }
                lVar.E(i, f("ok", null));
                x.d("MicroMsg.JsApiOperateSocketTask", "closeSocket code %d, reason %s", new Object[]{Integer.valueOf(optInt), optString3});
                return;
            }
            lVar.E(i, f("fail:The code must be either 1000, or between 3000 and 4999", null));
        } else if (optString2.equals("send")) {
            boolean isOpen;
            if (uS != null) {
                isOpen = uS.gDd.isOpen();
            } else {
                isOpen = false;
            }
            if (isOpen) {
                Object opt = jSONObject.opt("data");
                if (opt != null) {
                    try {
                        if (opt instanceof ByteBuffer) {
                            x.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message:%s", new Object[]{opt});
                            uS.q((ByteBuffer) opt);
                        } else if (opt instanceof String) {
                            x.i("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage ok message");
                            optString2 = (String) opt;
                            if (uS != null) {
                                uS.vW(optString2);
                            }
                        } else {
                            x.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage error message type wrong");
                            lVar.E(i, f("fail:unknown data", null));
                            return;
                        }
                        lVar.E(i, f("ok", null));
                        return;
                    } catch (Exception e2) {
                        lVar.E(i, f("fail:" + e2.getMessage(), null));
                        return;
                    }
                }
                lVar.E(i, f("fail:message is null or nil", null));
                x.w("MicroMsg.JsApiOperateSocketTask", "sendSocketMessage fail:%s", new Object[]{opt});
                return;
            }
            lVar.E(i, f("fail", null));
            x.w("MicroMsg.JsApiOperateSocketTask", "send fail taskId: %s", new Object[]{optString});
        } else {
            lVar.E(i, f("fail:unknown operationType", null));
        }
    }
}
