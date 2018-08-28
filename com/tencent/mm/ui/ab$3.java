package com.tencent.mm.ui;

import com.tencent.mm.ao.b;
import com.tencent.mm.ao.c;
import com.tencent.mm.ao.d$a;
import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.storage.bh;
import com.tencent.mm.ui.base.preference.IconPreference;

class ab$3 implements d$a {
    final /* synthetic */ ab toE;
    final /* synthetic */ IconPreference toH;

    ab$3(ab abVar, IconPreference iconPreference) {
        this.toE = abVar;
        this.toH = iconPreference;
    }

    public final void e(bh bhVar) {
        if (bhVar.field_tipId == b.ebm) {
            a.bjk();
            if (c.ig(b.ebm)) {
                this.toH.Et(0);
                this.toH.Er(8);
                this.toH.dk("", -1);
            }
        }
    }
}
