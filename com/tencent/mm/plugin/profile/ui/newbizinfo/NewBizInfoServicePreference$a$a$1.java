package com.tencent.mm.plugin.profile.ui.newbizinfo;

import com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoServicePreference.a.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.b.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class NewBizInfoServicePreference$a$a$1 implements c {
    final /* synthetic */ d lZa;
    final /* synthetic */ a lZb;

    NewBizInfoServicePreference$a$a$1(a aVar, d dVar) {
        this.lZb = aVar;
        this.lZa = dVar;
    }

    public final void a(l lVar) {
        for (d dVar : this.lZa.lZm) {
            lVar.e(dVar.name.hashCode(), dVar.name);
        }
    }
}
