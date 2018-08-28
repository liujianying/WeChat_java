package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.mm.g.a.nc;
import com.tencent.mm.plugin.extaccessories.SubCoreExtAccessories.RegistSpenBuddyEventListener.1;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public class b$a extends c<nc> {
    public b$a() {
        this.sFo = nc.class.getName().hashCode();
    }

    private boolean a(nc ncVar) {
        if (ncVar instanceof nc) {
            x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
            if (!(ncVar.bYc == null || ncVar.bYc.bYe == null || ncVar.bYc.bYd == null)) {
                try {
                    new SlookWritingBuddy(ncVar.bYc.bYe).setImageWritingListener(new 1(this, ncVar));
                } catch (Exception e) {
                    x.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[]{e.getMessage()});
                }
            }
            return true;
        }
        x.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        return false;
    }
}
