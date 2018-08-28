package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.sdk.b.a;

class SightUploadUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SightUploadUI nRw;

    SightUploadUI$3(SightUploadUI sightUploadUI) {
        this.nRw = sightUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        pn pnVar = new pn();
        pnVar.cap.type = 0;
        pnVar.cap.car = false;
        a.sFg.m(pnVar);
        this.nRw.YC();
        this.nRw.finish();
        return true;
    }
}
