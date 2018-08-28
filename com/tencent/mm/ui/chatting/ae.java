package com.tencent.mm.ui.chatting;

import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

public final class ae {
    public static String gu(long j) {
        String g = g(o.Pf().br(j));
        return g != null ? g : null;
    }

    public static String gv(long j) {
        String g = g(o.Pf().bq(j));
        return g != null ? g : null;
    }

    private static String g(e eVar) {
        if (eVar != null) {
            String str;
            if (eVar.ON()) {
                str = eVar.dTL;
                if (str != null && com.tencent.mm.a.e.cn(str)) {
                    return str;
                }
            }
            str = o.Pf().o(eVar.dTL, null, null);
            if (str != null && com.tencent.mm.a.e.cn(str)) {
                return str;
            }
            str = o.Pf().o(eVar.dTN, null, null);
            if (str != null && com.tencent.mm.a.e.cn(str)) {
                return str;
            }
        }
        return null;
    }

    public static String a(bd bdVar, a aVar) {
        String str = "";
        if (!(aVar == null || bi.oW(aVar.bGP))) {
            b SR = ao.asF().SR(aVar.bGP);
            if (SR != null && SR.aSc() && com.tencent.mm.a.e.cn(SR.field_fileFullPath)) {
                str = SR.field_fileFullPath;
            }
        }
        if (bi.oW(str)) {
            if (bdVar != null) {
                str = o.Pf().E(bdVar.field_imgPath, true);
            }
            x.d("MicroMsg.HistoryExportUtil", "try get thumb appmsg image path finish, %s", new Object[]{str});
        } else {
            x.d("MicroMsg.HistoryExportUtil", "get hd appmsg image path ok, %s", new Object[]{str});
        }
        return str;
    }
}
