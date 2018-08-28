package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.pluginsdk.o.f.a;
import com.tencent.mm.protocal.c.cec;
import com.tencent.mm.sdk.platformtools.bi;

public final class c implements a {
    public final String bSn() {
        cec cec = a.bSl().pIM.pJd.pJT;
        if (cec != null) {
            return cec.szg + "\n" + cec.szh + "\n" + cec.szi;
        }
        return "Not Connect";
    }

    public final void bSo() {
        a.bSl().pIS.a(new com.tencent.mm.plugin.wear.model.f.a());
    }

    public final boolean bSp() {
        String str = null;
        cec cec = a.bSl().pIM.pJd.pJT;
        return (bi.oW(str) && bi.oW(str)) ? cec != null : bi.oW(str) ? cec != null && str.equals("gh_43f2581f6fd6") : bi.oW(str) ? cec != null && str.equals(cec.szd) : cec != null && str.equals("gh_43f2581f6fd6") && str.equals(cec.szd);
    }
}
