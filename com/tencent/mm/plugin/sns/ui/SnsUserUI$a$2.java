package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ui.SnsUserUI.a;
import com.tencent.mm.ui.base.n.d;

class SnsUserUI$a$2 implements d {
    final /* synthetic */ a ohe;

    SnsUserUI$a$2(a aVar) {
        this.ohe = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                h.mEJ.h(13822, new Object[]{Integer.valueOf(1), Integer.valueOf(2)});
                SnsUserUI.m(this.ohe.ohd);
                return;
            case 1:
                h.mEJ.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(2)});
                SnsUserUI.n(this.ohe.ohd).xE(1);
                return;
            default:
                return;
        }
    }
}
