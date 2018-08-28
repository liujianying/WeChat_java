package com.tencent.mm.plugin.backup.i;

import android.content.Context;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends c<aa> {
    final /* synthetic */ a hdj;

    a$1(a aVar) {
        this.hdj = aVar;
        this.sFo = aa.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        aa aaVar = (aa) bVar;
        if (aaVar != null && (aaVar instanceof aa)) {
            Context context = (Context) aaVar.bHi.bHj;
            c.mV(-1).l(new Object[]{context});
            x.i("MicroMsg.BackupCore", "receive BackupUSBStopActionEvent.");
        }
        return false;
    }
}
