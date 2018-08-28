package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.ui.base.h;

class SightUploadUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SightUploadUI nRw;

    SightUploadUI$4(SightUploadUI sightUploadUI) {
        this.nRw = sightUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        h.a(this.nRw.mController.tml, null, new String[]{this.nRw.getString(j.sight_save_tips)}, null, new 1(this));
        return false;
    }
}
