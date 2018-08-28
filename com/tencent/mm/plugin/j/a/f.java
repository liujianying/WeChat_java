package com.tencent.mm.plugin.j.a;

import com.tencent.mm.a.e;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.j.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    protected final List<a> M(bd bdVar) {
        if (bdVar == null) {
            return null;
        }
        a N = N(bdVar);
        String fullPath = q.getFullPath(bdVar.field_imgPath);
        long cm = (long) e.cm(fullPath);
        N.field_msgSubType = 10;
        N.field_path = wZ(fullPath);
        N.field_size = cm;
        x.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[]{avA(), N});
        List<a> arrayList = new ArrayList();
        arrayList.add(N);
        return arrayList;
    }

    protected final String avA() {
        return "voice_" + hashCode();
    }
}
