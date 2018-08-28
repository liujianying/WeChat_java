package com.tencent.mm.plugin.collect.b;

import android.app.Dialog;
import android.content.Context;
import com.tencent.mm.g.a.op;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.g;

public final class u extends c<op> {
    Dialog eBX;

    public u() {
        this.sFo = op.class.getName().hashCode();
    }

    private boolean a(op opVar) {
        x.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[]{Integer.valueOf(opVar.bZx.type)});
        if (opVar.bZx.YC == null || opVar.bZx.YC.get() == null) {
            x.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
            opVar.bZx.bJX.run();
        } else {
            Context context = (Context) opVar.bZx.YC.get();
            if (opVar.bZx.type == 0) {
                this.eBX = g.a(context, false, null);
                k kVar = new k(opVar.bZx.bZz, opVar.bZx.scene);
                com.tencent.mm.kernel.g.DF().a(1800, new 1(this, opVar));
                com.tencent.mm.kernel.g.DF().a(kVar, 0);
            } else if (opVar.bZx.type == 1) {
                this.eBX = g.a(context, false, null);
                com.tencent.mm.plugin.collect.reward.a.c cVar = new com.tencent.mm.plugin.collect.reward.a.c(opVar.bZx.bZz, opVar.bZx.scene);
                com.tencent.mm.kernel.g.DF().a(2811, new 2(this, opVar));
                com.tencent.mm.kernel.g.DF().a(cVar, 0);
            } else {
                x.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[]{Integer.valueOf(opVar.bZx.type)});
            }
        }
        return false;
    }
}
