package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class s extends a {
    public static final int CTRL_BYTE = 16;
    public static final String NAME = "getNetworkType";

    public final void a(d dVar, JSONObject jSONObject, int i) {
        x.i("MicroMsg.GameJsApiGetNetworkType", "invoke");
        Context context = dVar.getContext();
        if (context == null) {
            x.e("MicroMsg.GameJsApiGetNetworkType", "context is null");
        } else if (ao.isConnected(context)) {
            x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, type = " + ao.getNetType(context));
            Map hashMap = new HashMap();
            if (ao.isWifi(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, wifi");
                dVar.E(i, a.f("network_type:wifi", null));
                return;
            }
            if (ao.is2G(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 2g");
                hashMap.put("subtype", "2g");
            } else if (ao.is3G(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 3g");
                hashMap.put("subtype", "3g");
            } else if (ao.is4G(context)) {
                x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, 4g");
                hashMap.put("subtype", "4g");
            }
            dVar.E(i, f("network_type:wwan", hashMap));
        } else {
            x.i("MicroMsg.GameJsApiGetNetworkType", "getNetworkType, not connected");
            dVar.E(i, a.f("network_type:fail", null));
        }
    }
}
