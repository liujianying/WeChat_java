package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public final class a extends h {
    private static final int CTRL_INDEX = 355;
    private static final String NAME = "onHCEMessage";
    private static final a fWn = new a();

    static synchronized void a(String str, int i, Bundle bundle) {
        synchronized (a.class) {
            x.i("MicroMsg.EventOnHCEMessageReceived", "alvinluo EventOnHCEMessageReceived dispatch appId: %s, eventType: %d", new Object[]{str, Integer.valueOf(i)});
            if (i == 31) {
                if (bundle != null) {
                    String string = bundle.getString("key_apdu_command");
                    Map hashMap = new HashMap();
                    hashMap.put("messageType", Integer.valueOf(1));
                    hashMap.put(SlookAirButtonFrequentContactAdapter.DATA, string);
                    fWn.aC(str, 0).x(hashMap).ahM();
                }
            } else if (i == 41 && bundle != null) {
                Map hashMap2 = new HashMap();
                hashMap2.put("messageType", Integer.valueOf(2));
                hashMap2.put("reason", Integer.valueOf(bundle.getInt("key_on_deactivated_reason")));
                fWn.aC(str, 0).x(hashMap2).ahM();
            }
        }
    }
}
