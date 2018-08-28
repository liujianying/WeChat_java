package com.tencent.mm.plugin.gwallet.a;

import android.content.Intent;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ ag hlG;
    final /* synthetic */ b kiV;
    final /* synthetic */ String kja;
    final /* synthetic */ b kjb;

    public b$3(b bVar, String str, ag agVar, b bVar2) {
        this.kiV = bVar;
        this.kja = str;
        this.hlG = agVar;
        this.kjb = bVar2;
    }

    public final void run() {
        c cVar = new c(0, "Inventory refresh successful.");
        Intent intent = new Intent();
        try {
            int a = b.a(this.kiV, intent, this.kja);
            if (a != 0) {
                cVar = new c(a, "Error refreshing inventory (querying owned items).");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
            cVar = new c(-1001, "Remote exception while refreshing inventory.");
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
            cVar = new c(-1002, "Error parsing JSON response while refreshing inventory.");
        }
        intent.putExtra("RESPONSE_CODE", cVar.aVR());
        this.hlG.post(new 1(this, cVar, intent));
    }
}
