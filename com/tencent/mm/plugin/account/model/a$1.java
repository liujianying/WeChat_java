package com.tencent.mm.plugin.account.model;

import com.tencent.mm.g.a.jn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<jn> {
    final /* synthetic */ a eNP;

    a$1(a aVar) {
        this.eNP = aVar;
        this.sFo = jn.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.ContactsAutoSyncLogic ", "sync username=%s isUploading=%b", new Object[]{((jn) bVar).bTh.username, Boolean.valueOf(this.eNP.egv)});
        this.eNP.eNM.add(r7.bTh.username);
        if (!this.eNP.egv) {
            this.eNP.eNO.removeMessages(0);
            this.eNP.eNO.sendEmptyMessageDelayed(0, 10000);
        }
        return false;
    }
}
