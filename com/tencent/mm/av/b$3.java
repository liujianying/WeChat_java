package com.tencent.mm.av;

import com.tencent.mm.g.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$3 extends c<d> {
    final /* synthetic */ b eel;

    b$3(b bVar) {
        this.eel = bVar;
        this.sFo = d.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (!((d) bVar).bGd.bGe) {
            x.i("MicroMsg.SenseWhereHelper", "it is [deactivated mode], stop sense where sdk after %d", new Object[]{Integer.valueOf(Math.max(this.eel.edS, this.eel.edR))});
            b.QC();
            b.a(this.eel, r0);
        }
        return false;
    }
}
