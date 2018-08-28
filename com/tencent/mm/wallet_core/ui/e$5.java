package com.tencent.mm.wallet_core.ui;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

class e$5 implements a {
    final /* synthetic */ String[] uZa;
    final /* synthetic */ e$a uZb;

    e$5(String[] strArr, e$a e_a) {
        this.uZa = strArr;
        this.uZb = e_a;
    }

    public final void a(e eVar) {
        if (eVar != null && eVar.Lr() != null) {
            if (this.uZa == null || this.uZa.length == 0) {
                x.w("MicroMsg.WalletBaseUtil ", "hy: keys is null");
                return;
            }
            Map hashMap = new HashMap();
            int i = 0;
            while (i < this.uZa.length) {
                try {
                    String str = this.uZa[i];
                    if (bi.oW(str)) {
                        x.e("MicroMsg.WalletBaseUtil ", "hy: key is null");
                    } else {
                        byte[] kf = eVar.Lr().kf(str);
                        if (kf != null) {
                            hashMap.put(str, e.bH(kf));
                        }
                    }
                    i++;
                } catch (Exception e) {
                    x.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[]{e.toString()});
                    if (this.uZb != null) {
                        this.uZb.R(null);
                        return;
                    }
                    return;
                }
            }
            if (this.uZb != null) {
                this.uZb.R(hashMap);
            }
        }
    }
}
