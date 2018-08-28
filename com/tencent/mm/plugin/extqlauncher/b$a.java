package com.tencent.mm.plugin.extqlauncher;

import com.tencent.mm.g.a.ev;
import com.tencent.mm.plugin.extqlauncher.provider.ExtControlProviderQLauncher;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class b$a extends c<ev> {
    public b$a() {
        this.sFo = ev.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ev evVar = (ev) bVar;
        if (evVar instanceof ev) {
            ExtControlProviderQLauncher extControlProviderQLauncher = new ExtControlProviderQLauncher(evVar.bMz.bGj, evVar.bMz.bMB, evVar.bMz.context);
            evVar.bMA.bMC = extControlProviderQLauncher.query(evVar.bMz.uri, null, null, evVar.bMz.selectionArgs, null);
            return true;
        }
        x.f("MicroMsg.SubCoreExtQLauncher", "mismatched event");
        return false;
    }
}
