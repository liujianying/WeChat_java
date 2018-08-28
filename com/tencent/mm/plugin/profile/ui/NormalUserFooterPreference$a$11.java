package com.tencent.mm.plugin.profile.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;
import com.tencent.mm.ui.widget.a.d;

class NormalUserFooterPreference$a$11 implements OnMenuItemClickListener {
    final /* synthetic */ boolean lXD;
    final /* synthetic */ boolean lXE;
    final /* synthetic */ a lXy;

    NormalUserFooterPreference$a$11(a aVar, boolean z, boolean z2) {
        this.lXy = aVar;
        this.lXD = z;
        this.lXE = z2;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        d dVar = new d(NormalUserFooterPreference.b(this.lXy.lXw), 1, false);
        dVar.ofq = new 1(this);
        dVar.ofp = new 2(this);
        dVar.bXO();
        return true;
    }
}
