package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.plugin.biz.b$a;
import com.tencent.mm.sdk.platformtools.bi;

public final class d implements p {
    public final boolean TE(String str) {
        return f.eZ(str);
    }

    public final Object TF(String str) {
        Object cz = z.Nc().cz(str);
        if (cz != null && !bi.oW(cz.field_userId) && cz.field_userId.equals(str)) {
            return cz;
        }
        j jVar = new j();
        jVar.field_userId = str;
        return jVar;
    }

    public final c TG(String str) {
        a aVar = new a();
        aVar.dXB = e.lj(str);
        aVar.dXy = true;
        aVar.dXV = true;
        aVar.dXN = b$a.default_avatar;
        return aVar.Pt();
    }

    public final String bW(Object obj) {
        return ((j) obj).field_userName;
    }

    public final String bX(Object obj) {
        return ((j) obj).field_headImageUrl;
    }

    public final String bY(Object obj) {
        return ((j) obj).field_userId;
    }
}
