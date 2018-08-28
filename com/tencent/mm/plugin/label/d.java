package com.tencent.mm.plugin.label;

import com.tencent.mm.g.a.lw;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends c<lw> {
    public d() {
        this.sFo = lw.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        au.HU();
        if (System.currentTimeMillis() - ((Long) com.tencent.mm.model.c.DT().get(209408, Long.valueOf(0))).longValue() > 86400000) {
            x.i("MicroMsg.Label.PostTaskGetContactLabelListener", "cpan[callback] get contact label list.");
            au.DF().a(new com.tencent.mm.plugin.label.b.c(), 0);
            au.HU();
            com.tencent.mm.model.c.DT().set(209408, Long.valueOf((System.currentTimeMillis() - 86400000) + 1800000));
        }
        return false;
    }
}
