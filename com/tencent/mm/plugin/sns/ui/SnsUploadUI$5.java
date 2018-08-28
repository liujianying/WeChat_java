package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.tools.a.c;

class SnsUploadUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$5(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!this.ogU.isFinishing() && System.currentTimeMillis() - SnsUploadUI.m(this.ogU) >= 500) {
            if (SnsUploadUI.h(this.ogU) == 9) {
                g.Ek();
                g.Ei().DT().a(a.sQM, "");
            } else {
                g.Ek();
                g.Ei().DT().a(a.sQL, "");
            }
            SnsUploadUI.a(this.ogU, System.currentTimeMillis());
            com.tencent.mm.plugin.report.service.g.vu(22);
            c Gi = c.d(SnsUploadUI.a(this.ogU)).Gi(b.Av());
            Gi.uCR = true;
            Gi.a(new 1(this));
        }
        return false;
    }
}
