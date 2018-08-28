package com.tencent.mm.plugin.product.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class d {
    public List<String> lRd = new ArrayList();

    public d() {
        Wj();
    }

    private void Wj() {
        this.lRd.clear();
        g.Ek();
        String str = (String) g.Ei().DT().get(270340, "");
        x.d("MicroMsg.MallNewsManager", "data : " + str);
        for (String str2 : bi.F(str2.split(";"))) {
            if (!bi.oW(str2)) {
                this.lRd.add(str2);
            }
        }
    }

    public final boolean bna() {
        x.d("MicroMsg.MallNewsManager", "notifyNewsMap.size : " + this.lRd.size());
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : this.lRd) {
            if (!(bi.oW(str) || str.contains(";"))) {
                stringBuffer.append(str);
            }
        }
        x.d("MicroMsg.MallNewsManager", "save data  : " + stringBuffer.toString());
        g.Ek();
        g.Ei().DT().set(270340, stringBuffer.toString());
        return true;
    }
}
