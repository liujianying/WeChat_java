package com.tencent.mm.plugin.j.a;

import com.tencent.mm.a.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    protected final List<a> M(bd bdVar) {
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
            x.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
            return null;
        }
        a N = N(bdVar);
        com.tencent.mm.pluginsdk.model.app.b SR = ao.asF().SR(gp.bGP);
        long j = 0;
        if (SR != null) {
            str = SR.field_fileFullPath;
            j = (long) e.cm(str);
        }
        N.field_msgSubType = 30;
        N.field_path = wZ(str);
        N.field_size = j;
        WT = o.Pf().E(bdVar.field_imgPath, true);
        long cm = (long) e.cm(WT);
        a N2 = N(bdVar);
        N2.field_msgSubType = 31;
        N2.field_path = wZ(WT);
        N2.field_size = cm;
        x.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[]{avA(), N, N2});
        List<a> arrayList = new ArrayList();
        arrayList.add(N);
        arrayList.add(N2);
        return arrayList;
    }

    protected final String avA() {
        return "AppMsgImg_" + hashCode();
    }
}
