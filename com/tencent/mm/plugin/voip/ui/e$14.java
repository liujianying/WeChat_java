package com.tencent.mm.plugin.voip.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.report.service.h;

class e$14 implements OnClickListener {
    final /* synthetic */ e oSe;

    e$14(e eVar) {
        this.oSe = eVar;
    }

    public final void onClick(View view) {
        int i;
        boolean z = false;
        h.mEJ.h(11079, new Object[]{Integer.valueOf(4)});
        if (!(e.k(this.oSe) || this.oSe.oQd.get() == null)) {
            e.p(this.oSe).getVisibility();
        }
        if (e.p(this.oSe).getVisibility() == 0) {
            i = 4;
        } else {
            boolean i2 = false;
        }
        int i3 = i2 == 0 ? 0 : 8;
        e.p(this.oSe).setVisibility(i3);
        e.t(this.oSe).setVisibility(i3);
        e.u(this.oSe).setVisibility(i3);
        e.b(this.oSe).setVisibility(i3);
        e.a(this.oSe).setVisibility(i3);
        e eVar = this.oSe;
        if (i3 == 0) {
            z = true;
        }
        e.e(eVar, z);
        if (af.exX) {
            e.w(this.oSe).setVisibility(i3);
            e.x(this.oSe).setVisibility(i3);
            e.y(this.oSe).setVisibility(i3);
            e.z(this.oSe).setVisibility(i3);
            e.A(this.oSe).setVisibility(i3);
            e.B(this.oSe).setVisibility(i3);
        }
        if (i2 == 0) {
            e.q(this.oSe);
        }
    }
}
