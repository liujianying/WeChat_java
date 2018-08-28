package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class l$3 implements l {
    final /* synthetic */ long cXh;
    final /* synthetic */ l mPc;
    final /* synthetic */ HashSet mPe;
    final /* synthetic */ long mPf;

    l$3(l lVar, HashSet hashSet, long j, long j2) {
        this.mPc = lVar;
        this.mPe = hashSet;
        this.mPf = j;
        this.cXh = j2;
    }

    public final void b(j jVar) {
        List<com.tencent.mm.plugin.fts.a.a.l> list = jVar.jsx;
        if (list != null) {
            for (com.tencent.mm.plugin.fts.a.a.l lVar : list) {
                this.mPe.remove(lVar.jrv);
                this.mPc.mOX.add(lVar.jrv);
            }
        }
        Iterator it = this.mPe.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (((i) g.l(i.class)).bcY().o(str, this.mPf, System.currentTimeMillis()) > 0) {
                x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] talker:%s voipCount:%s", new Object[]{str, Integer.valueOf(((i) g.l(i.class)).bcY().o(str, this.mPf, System.currentTimeMillis()))});
            } else {
                Cursor a = ((i) g.l(i.class)).bcY().a(str, this.mPf, System.currentTimeMillis(), true);
                if (a.getCount() > 0) {
                    Cursor a2 = ((i) g.l(i.class)).bcY().a(str, this.mPf, System.currentTimeMillis(), false);
                    if (a2.getCount() <= 0) {
                        this.mPc.mOX.add(str);
                    }
                    a2.close();
                } else {
                    this.mPc.mOX.add(str);
                }
                a.close();
            }
        }
        x.i("MicroMsg.UnfamiliarContactEngine", "[getHalfYearNotChatInfo] query:%s cost:%sms", new Object[]{Long.valueOf(this.mPf), Long.valueOf(System.currentTimeMillis() - this.cXh)});
        this.mPc.mOV.countDown();
    }
}
