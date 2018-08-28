package com.tencent.mm.plugin.extaccessories;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;

public final class b implements ar {
    String dqp;
    private a iLx;

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bo(boolean z) {
        au.HU();
        this.dqp = c.Gq();
        File file = new File(this.dqp);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(this.dqp + "image/spen/");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void bn(boolean z) {
        x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
        if (this.iLx == null) {
            this.iLx = new a();
        }
        a.sFg.b(this.iLx);
        au.Em().h(new 1(this), 5000);
    }

    public final void onAccountRelease() {
        x.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
        if (this.iLx != null) {
            a.sFg.c(this.iLx);
        }
    }
}
