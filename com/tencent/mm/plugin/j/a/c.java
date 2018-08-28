package com.tencent.mm.plugin.j.a;

import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.List;

public final class c extends a {
    protected final List<a> M(bd bdVar) {
        long j = 0;
        String str = null;
        if (bdVar == null) {
            return null;
        }
        g.a gp;
        String WT = bi.WT(bdVar.field_content);
        if (WT != null) {
            gp = g.a.gp(WT);
        } else {
            gp = null;
        }
        if (gp == null) {
            x.e("MicroMsg.AppMsgMsgHandler", "content is null");
            return null;
        }
        int i;
        a N = N(bdVar);
        b SR;
        switch (gp.type) {
            case 2:
                SR = ao.asF().SR(gp.bGP);
                if (SR != null) {
                    str = SR.field_fileFullPath;
                    j = (long) e.cm(str);
                }
                N.field_msgSubType = 30;
                N.field_path = wZ(str);
                N.field_size = j;
                i = 31;
                break;
            case 6:
                SR = ao.asF().SR(gp.bGP);
                if (SR != null) {
                    str = SR.field_fileFullPath;
                    j = (long) e.cm(str);
                }
                N.field_msgSubType = 34;
                N.field_path = wZ(str);
                N.field_size = j;
                i = 35;
                break;
            case 7:
                SR = ao.asF().SR(gp.bGP);
                if (SR != null) {
                    str = SR.field_fileFullPath;
                    j = (long) e.cm(str);
                }
                N.field_msgSubType = 32;
                N.field_path = wZ(str);
                N.field_size = j;
                i = 33;
                break;
            default:
                return null;
        }
        String E = o.Pf().E(bdVar.field_imgPath, true);
        long cm = (long) e.cm(E);
        a N2 = N(bdVar);
        N2.field_msgSubType = i;
        N2.field_path = wZ(E);
        N2.field_size = cm;
        x.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[]{avA(), N, N2});
        List<a> arrayList = new ArrayList();
        arrayList.add(N);
        arrayList.add(N2);
        return arrayList;
    }

    protected final String avA() {
        return "AppMsg_" + hashCode();
    }
}
