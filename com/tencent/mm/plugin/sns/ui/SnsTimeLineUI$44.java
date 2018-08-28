package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.ui.base.n.d;

class SnsTimeLineUI$44 implements d {
    final /* synthetic */ b odG;
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$44(SnsTimeLineUI snsTimeLineUI, b bVar) {
        this.odw = snsTimeLineUI;
        this.odG = bVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                h.mEJ.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                e.nxO.b(this.odG);
                this.odG.RD();
                SnsTimeLineUI.h(this.odw).ogk = this.odG;
                SnsTimeLineUI.h(this.odw).xE(1);
                return;
            case 3:
                SnsTimeLineUI.J(this.odw);
                return;
            default:
                return;
        }
    }
}
