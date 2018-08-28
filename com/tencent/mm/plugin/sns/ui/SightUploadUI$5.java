package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.k.b;
import com.tencent.mm.ui.tools.a.c;

class SightUploadUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SightUploadUI nRw;

    SightUploadUI$5(SightUploadUI sightUploadUI) {
        this.nRw = sightUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!this.nRw.isFinishing()) {
            SightUploadUI.a(this.nRw, SightUploadUI.a(this.nRw).getText().toString());
            int pasterLen = SightUploadUI.a(this.nRw).getPasterLen();
            c Gi = c.d(SightUploadUI.a(this.nRw)).Gi(b.Av());
            Gi.uCR = true;
            Gi.a(new 1(this, pasterLen));
        }
        return false;
    }
}
