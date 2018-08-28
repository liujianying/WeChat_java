package com.tencent.mm.plugin.ipcall;

import com.tencent.mm.g.a.st;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$2 extends c<st> {
    final /* synthetic */ c kob;

    c$2(c cVar) {
        this.kob = cVar;
        this.sFo = st.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        st stVar = (st) bVar;
        if (stVar instanceof st) {
            stVar.cdA.cdB = false;
            stVar.cdA.cdC = false;
            stVar.cdA.cdD = true;
            stVar.cdA.talker = "";
        }
        return false;
    }
}
