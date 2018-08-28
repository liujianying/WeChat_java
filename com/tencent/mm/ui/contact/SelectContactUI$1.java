package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.ah;

class SelectContactUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SelectContactUI ulL;

    SelectContactUI$1(SelectContactUI selectContactUI) {
        this.ulL = selectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ulL.YC();
        this.ulL.finish();
        if (!this.ulL.getIntent().getBooleanExtra("stay_in_wechat", true)) {
            ah.i(new Runnable() {
                public final void run() {
                    SelectContactUI$1.this.ulL.moveTaskToBack(true);
                }
            }, 80);
        }
        return true;
    }
}
