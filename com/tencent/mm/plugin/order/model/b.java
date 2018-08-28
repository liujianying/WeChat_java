package com.tencent.mm.plugin.order.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;

public final class b {
    public HashSet<String> lNE = new HashSet();

    public b() {
        aMk();
    }

    private void aMk() {
        this.lNE.clear();
        g.Ek();
        for (String str : bi.F(((String) g.Ei().DT().get(204803, "")).split(";"))) {
            if (!(bi.oW(str) || this.lNE.contains(str))) {
                this.lNE.add(str);
            }
        }
        g.Ek();
        g.Ei().DT().set(204817, Integer.valueOf(this.lNE.size()));
        x.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + this.lNE.size());
    }

    public final void bmr() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.lNE.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!bi.oW(str)) {
                stringBuffer.append(str + ";");
            }
        }
        g.Ek();
        g.Ei().DT().set(204803, stringBuffer.toString());
    }
}
