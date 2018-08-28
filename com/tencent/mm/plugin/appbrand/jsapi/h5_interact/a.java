package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class a extends h {
    private static final int CTRL_INDEX = 460;
    private static final String NAME = "onH5Data";
    private static final AtomicBoolean fQp = new AtomicBoolean(false);

    public static void j(String str, String str2, int i) {
        if (!bi.oW(str)) {
            g pY = com.tencent.mm.plugin.appbrand.a.pY(str);
            if (pY != null && pY.dti) {
                try {
                    JSONObject put = new JSONObject().put("data", str2).put("webviewId", String.valueOf(i));
                    a aVar = new a();
                    aVar.a(pY.fcy).mData = put.toString();
                    aVar.ahM();
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrand.EventOnH5Data", "dispatch ex = %s", new Object[]{e});
                }
            }
        }
    }

    public static void aiR() {
        boolean z = true;
        if (fQp.getAndSet(true)) {
            z = false;
        }
        if (z) {
            MMToClientEvent.a(new 1());
        }
    }
}
