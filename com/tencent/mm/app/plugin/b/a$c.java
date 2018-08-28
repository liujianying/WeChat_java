package com.tencent.mm.app.plugin.b;

import com.tencent.mm.g.a.fa;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

public class a$c extends c<fa> {
    public a$c() {
        this.sFo = fa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        fa faVar = (fa) bVar;
        i iVar = new i(faVar.bNd.toUserName, faVar.bNd.content, faVar.bNd.type);
        faVar.bNe.bNf = iVar;
        faVar.bNe.bJC = iVar.bJC;
        return true;
    }
}
