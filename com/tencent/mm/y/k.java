package com.tencent.mm.y;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.g.a;
import java.util.Map;

public final class k {
    public int dzu;
    public int dzv;

    public static final k gv(String str) {
        k kVar = new k();
        a J = a.J(str, null);
        if (J != null) {
            Map map = J.dzf;
            if (map != null) {
                kVar.dzu = bi.getInt((String) map.get(".msg.appmsg.xmlfulllen"), 0);
                kVar.dzv = bi.getInt((String) map.get(".msg.appmsg.realinnertype"), 0);
            }
        }
        return kVar;
    }
}
