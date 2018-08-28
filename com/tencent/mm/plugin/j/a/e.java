package com.tencent.mm.plugin.j.a;

import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class e extends a {
    protected final List<a> M(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        o.Ta();
        String nK = s.nK(bdVar.field_imgPath);
        long cm = (long) com.tencent.mm.a.e.cm(nK);
        a N = a.N(bdVar);
        N.field_msgSubType = 1;
        N.field_path = wZ(nK);
        N.field_size = cm;
        o.Ta();
        nK = s.nL(bdVar.field_imgPath);
        cm = (long) com.tencent.mm.a.e.cm(nK);
        a N2 = a.N(bdVar);
        N2.field_msgSubType = 2;
        N2.field_path = wZ(nK);
        N2.field_size = cm;
        x.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[]{avA(), N, N2});
        List<a> arrayList = new ArrayList();
        arrayList.add(N);
        arrayList.add(N2);
        return arrayList;
    }

    protected final String avA() {
        return "video_" + hashCode();
    }
}
