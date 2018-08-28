package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class a$2 implements a {
    final /* synthetic */ b.a fWJ;
    final /* synthetic */ a fWK;

    a$2(a aVar, b.a aVar2) {
        this.fWK = aVar;
        this.fWJ = aVar2;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fWK.hashCode() & 65535)) {
            if (i2 == -1) {
                Map hashMap = new HashMap();
                String aG = bi.aG(intent.getStringExtra("token"), "");
                String aG2 = bi.aG(intent.getStringExtra("bind_serial"), "");
                hashMap.put("token", aG);
                hashMap.put("bindSerial", aG2);
                if (this.fWJ != null) {
                    this.fWJ.a(1, null, hashMap);
                }
            } else if (this.fWJ != null) {
                this.fWJ.a(2, null, null);
            }
        }
    }
}
