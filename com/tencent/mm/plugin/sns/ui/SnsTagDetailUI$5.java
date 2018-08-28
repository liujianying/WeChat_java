package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class SnsTagDetailUI$5 implements OnMenuItemClickListener {
    final /* synthetic */ SnsTagDetailUI obJ;

    SnsTagDetailUI$5(SnsTagDetailUI snsTagDetailUI) {
        this.obJ = snsTagDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!(this.obJ.obG + " " + bi.c(this.obJ.jzp, ",")).equals(this.obJ.bKg) || this.obJ.noJ == 0) {
            h.a(this.obJ, j.sns_tag_cancel, j.app_tip, new 1(this), null);
        } else {
            this.obJ.finish();
        }
        return true;
    }
}
