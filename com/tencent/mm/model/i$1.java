package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.ac.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bd;

class i$1 implements Runnable {
    final /* synthetic */ long dAC;
    final /* synthetic */ a dAD;
    final /* synthetic */ String dhh;

    i$1(String str, long j, a aVar) {
        this.dhh = str;
        this.dAC = j;
        this.dAD = aVar;
    }

    public final void run() {
        Cursor at = ((o) g.l(o.class)).FU().at(this.dhh, this.dAC);
        if (at.moveToFirst()) {
            while (!at.isAfterLast() && (this.dAD == null || !this.dAD.Ip())) {
                bd bdVar = new bd();
                bdVar.d(at);
                bd.j(bdVar);
                at.moveToNext();
            }
        }
        at.close();
        ((o) g.l(o.class)).FU().as(this.dhh, this.dAC);
        ah.A(new 1(this));
    }

    public final String toString() {
        return super.toString() + "|deleteMsgByTalker";
    }
}
