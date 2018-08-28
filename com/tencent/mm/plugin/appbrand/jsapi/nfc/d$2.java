package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.content.Intent;
import com.tencent.mm.plugin.nfc.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class d$2 implements a {
    final /* synthetic */ d fWC;

    d$2(d dVar) {
        this.fWC = dVar;
    }

    public final void b(int i, int i2, Intent intent) {
        x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo mmOnActivityResult requestCode: %d, resultCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (intent != null) {
            int intExtra = intent.getIntExtra("errCode", -1);
            String stringExtra = intent.getStringExtra("errMsg");
            if (i == 1) {
                d dVar = this.fWC;
                x.i("MicroMsg.JsApiNFCStartHCE", "alvinluo startHCEUI onResult errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(intExtra), stringExtra});
                Map hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(intExtra));
                if (intExtra == 0) {
                    dVar.onSuccess();
                    return;
                }
                c.aa(dVar.fcy.mAppId, intExtra, -1);
                dVar.tp(dVar.f("fail: " + stringExtra, hashMap));
            }
        }
    }
}
