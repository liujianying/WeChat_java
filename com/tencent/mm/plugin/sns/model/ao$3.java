package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.ar;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ao$3 extends c<ar> {
    final /* synthetic */ ao nrB;

    ao$3(ao aoVar) {
        this.nrB = aoVar;
        this.sFo = ar.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ar arVar = (ar) bVar;
        this.nrB.emK = arVar.bIf.bIg;
        x.i("MicroMsg.SnsPreTimelineService", "set isInChatting:%b", new Object[]{Boolean.valueOf(this.nrB.emK)});
        return false;
    }
}
