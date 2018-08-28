package com.tencent.mm.plugin.wallet_ecard;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.le;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class a implements ar {
    private c<cn> pBm = new c<cn>() {
        {
            this.sFo = cn.class.getName().hashCode();
        }

        private boolean a(cn cnVar) {
            com.tencent.mm.g.a.cn.a aVar = cnVar.bJR;
            HashMap hashMap = new HashMap();
            if (!bi.oW(aVar.packageExt)) {
                String[] split = aVar.packageExt.split("&");
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bi.oW(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !bi.oW(split2[0])) {
                                hashMap.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
            x.i("MicroMsg.SubCoreECard", "start openECard, extraData: %s, packageExt: %s", new Object[]{(String) hashMap.get("extradata"), hashMap});
            com.tencent.mm.plugin.wallet_core.c.a aVar2 = new com.tencent.mm.plugin.wallet_core.c.a(aVar.appId, aVar.bJT, aVar.nonceStr, aVar.packageExt, aVar.signType, aVar.signature, aVar.bJU, 15, "openECard", aVar.bJY);
            g.Ek();
            g.Eh().dpP.a(580, new 1(this, aVar, cnVar, r11));
            g.Ek();
            g.Eh().dpP.a(aVar2, 0);
            return false;
        }
    };
    private c<le> pBn = new 2(this);

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
        this.pBm.cht();
        this.pBn.cht();
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
        this.pBm.dead();
        this.pBn.dead();
    }
}
