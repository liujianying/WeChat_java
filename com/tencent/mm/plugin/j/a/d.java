package com.tencent.mm.plugin.j.a;

import com.tencent.mm.ak.e;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    protected final List<a> M(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        e q = o.Pf().q(bdVar);
        if (q == null || q.dTK == 0) {
            x.w("MicroMsg.ImageMsgHandler", "%s can not get imgInfo", new Object[]{avA()});
            return null;
        }
        String o = o.Pf().o(q.dTL, "", "");
        long cm = (long) com.tencent.mm.a.e.cm(o);
        String o2 = o.Pf().o(q.dTN, "", "");
        long cm2 = (long) com.tencent.mm.a.e.cm(o2);
        String str = o.Pf().o(q.dTN, "", "") + "hd";
        long cm3 = (long) com.tencent.mm.a.e.cm(str);
        String str2 = null;
        String str3 = null;
        String str4 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        if (q.ON()) {
            q = o.Pf().hQ(q.dTU);
            if (q != null) {
                str2 = o.Pf().o(q.dTL, "", "");
                if (!bi.fS(str2, o)) {
                    j = (long) com.tencent.mm.a.e.cm(str2);
                }
                str3 = o.Pf().o(q.dTN, "", "");
                if (!bi.fS(str3, o2)) {
                    j2 = (long) com.tencent.mm.a.e.cm(str3);
                }
                str4 = o.Pf().o(q.dTN, "", "") + "hd";
                if (!bi.fS(str4, str)) {
                    j3 = (long) com.tencent.mm.a.e.cm(str4);
                }
            }
        }
        a N = N(bdVar);
        N.field_msgSubType = 20;
        N.field_path = wZ(o);
        N.field_size = cm;
        a N2 = N(bdVar);
        N2.field_msgSubType = 21;
        N2.field_path = wZ(o2);
        N2.field_size = cm2;
        a N3 = N(bdVar);
        N3.field_msgSubType = 22;
        N3.field_path = wZ(str);
        N3.field_size = cm3;
        a N4 = N(bdVar);
        N4.field_msgSubType = 23;
        N4.field_path = wZ(str2);
        N4.field_size = j;
        a N5 = N(bdVar);
        N5.field_msgSubType = 24;
        N5.field_path = wZ(str3);
        N5.field_size = j2;
        a N6 = N(bdVar);
        N6.field_msgSubType = 25;
        N6.field_path = wZ(str4);
        N6.field_size = j3;
        x.i("MicroMsg.ImageMsgHandler", "%s create image wx file index bigItem[%s] thumb[%s][%s] hd[%s %s %s]", new Object[]{avA(), N, N2, N3, N4, N5, N6});
        List<a> arrayList = new ArrayList();
        arrayList.add(N);
        arrayList.add(N2);
        arrayList.add(N3);
        arrayList.add(N4);
        arrayList.add(N5);
        arrayList.add(N6);
        return arrayList;
    }

    protected final String avA() {
        return "image_" + hashCode();
    }
}
