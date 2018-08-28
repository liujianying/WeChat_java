package com.tencent.mm.plugin.websearch.api;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class ac {
    private static ac pMl = new ac();
    public a pMk = new a();

    public static ac bTg() {
        return pMl;
    }

    private ac() {
        String str = (String) g.Ei().DT().get(a.sYb, "");
        a aVar = this.pMk;
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                aVar.id = bi.q(split[0], new Object[0]);
                aVar.pMm = bi.WU(split[1]);
                aVar.pMn = bi.WU(split[2]);
                aVar.kSz = bi.WV(split[3]);
                aVar.pLn = bi.WU(split[4]);
                aVar.type = bi.WU(split[5]);
                aVar.text = split[6];
                aVar.bWP = split[7];
                aVar.timestamp = bi.WV(split[8]);
                aVar.pMo = bi.WU(split[9]);
                aVar.eaP = bi.WV(split[10]);
                aVar.pMp = bi.WU(split[11]);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WebSearch.WebSearchRedPointMgr", e, "", new Object[0]);
        }
    }

    public final void save() {
        Object obj;
        if (this.pMk == null) {
            obj = "";
        } else {
            a aVar = this.pMk;
            obj = aVar.id + "&" + aVar.pMm + "&" + aVar.pMn + "&" + aVar.kSz + "&" + aVar.pLn + "&" + aVar.type + "&" + aVar.text + "&" + aVar.bWP + "&" + aVar.timestamp + "&" + aVar.pMo + "&" + aVar.eaP + "&" + aVar.pMp;
        }
        g.Ei().DT().a(a.sYb, obj);
    }

    public static boolean bTh() {
        return false;
    }

    public static long bTi() {
        Object obj = g.Ei().DT().get(a.sZQ, null);
        return obj == null ? 0 : ((Long) obj).longValue();
    }
}
