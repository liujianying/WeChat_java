package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.Map;

class ao$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ ao fGn;

    ao$1(ao aoVar, l lVar, int i) {
        this.fGn = aoVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i == (this.fGn.hashCode() & 65535)) {
            if (i2 == -1 && intent != null) {
                String aG = bi.aG(intent.getStringExtra("nationalCode"), "");
                String aG2 = bi.aG(intent.getStringExtra("userName"), "");
                String aG3 = bi.aG(intent.getStringExtra("telNumber"), "");
                String aG4 = bi.aG(intent.getStringExtra("addressPostalCode"), "");
                String aG5 = bi.aG(intent.getStringExtra("proviceFirstStageName"), "");
                String aG6 = bi.aG(intent.getStringExtra("addressCitySecondStageName"), "");
                String aG7 = bi.aG(intent.getStringExtra("addressCountiesThirdStageName"), "");
                String aG8 = bi.aG(intent.getStringExtra("addressDetailInfo"), "");
                x.i("MicroMsg.JsApiOpenAddress", "first =  " + aG5 + " ; detail =" + aG8 + "; second = " + aG6 + " ; tel = " + aG3 + "; third = " + aG7);
                if (!bi.oW(aG2)) {
                    Map hashMap = new HashMap();
                    hashMap.put("nationalCode", aG);
                    hashMap.put("userName", aG2);
                    hashMap.put("telNumber", aG3);
                    hashMap.put("addressPostalCode", aG4);
                    hashMap.put("proviceFirstStageName", aG5);
                    hashMap.put("addressCitySecondStageName", aG6);
                    hashMap.put("addressCountiesThirdStageName", aG7);
                    hashMap.put("addressDetailInfo", aG8);
                    this.fCl.E(this.doP, this.fGn.f("ok", hashMap));
                    return;
                }
            }
            if (i2 == 0) {
                this.fCl.E(this.doP, this.fGn.f("cancel", null));
            } else {
                this.fCl.E(this.doP, this.fGn.f("fail", null));
            }
        }
    }
}
