package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.view.MenuItem;
import com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizInfoServicePreference.a.a;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.b;
import com.tencent.mm.ui.base.n.d;

class NewBizInfoServicePreference$a$a$2 implements d {
    final /* synthetic */ com.tencent.mm.plugin.profile.ui.newbizinfo.b.d lZa;
    final /* synthetic */ a lZb;

    NewBizInfoServicePreference$a$a$2(a aVar, com.tencent.mm.plugin.profile.ui.newbizinfo.b.d dVar) {
        this.lZb = aVar;
        this.lZa = dVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        com.tencent.mm.plugin.profile.ui.newbizinfo.b.d dVar = (com.tencent.mm.plugin.profile.ui.newbizinfo.b.d) this.lZa.lZm.get(i);
        if (dVar.type == 2) {
            a.a(this.lZb, dVar);
            b.a(this.lZb.lYZ.guS.field_username, this.lZa.id, this.lZa.aAL, b.lZq, this.lZa.name, b.dl(this.lZb.lYZ.lYW.indexOf(this.lZa), i), this.lZa.ceR);
        } else if (dVar.type == 5) {
            a.b(this.lZb, dVar);
            b.a(this.lZb.lYZ.guS.field_username, this.lZa.id, this.lZa.aAL, b.lZq, this.lZa.name, b.dl(this.lZb.lYZ.lYW.indexOf(this.lZa), i), this.lZa.value);
        }
    }
}
