package com.tencent.mm.plugin.aa.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

class AASelectContactUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ AASelectContactUI eCw;

    AASelectContactUI$3(AASelectContactUI aASelectContactUI) {
        this.eCw = aASelectContactUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (((long) AASelectContactUI.b(this.eCw).size()) > AASelectContactUI.d(this.eCw)) {
            h.b(this.eCw.mController.tml, this.eCw.getString(i.launch_aa_by_person_number_exceed_limit_alert, new Object[]{Long.valueOf(AASelectContactUI.d(this.eCw))}), "", true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
            com.tencent.mm.plugin.report.service.h.mEJ.h(13722, new Object[]{Integer.valueOf(3)});
        } else if (AASelectContactUI.b(this.eCw).size() <= 0) {
            h.b(this.eCw.mController.tml, this.eCw.getString(i.aa_select_min_usernumber_hint, new Object[]{Integer.valueOf(1)}), "", true);
            com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(9)});
        } else {
            List linkedList = new LinkedList();
            linkedList.addAll(AASelectContactUI.b(this.eCw));
            this.eCw.setResult(-1, this.eCw.getIntent().putExtra("Select_Contact", bi.c(linkedList, ",")));
            this.eCw.finish();
            this.eCw.YC();
            com.tencent.mm.plugin.report.service.h.mEJ.h(13721, new Object[]{Integer.valueOf(2), Integer.valueOf(8)});
        }
        return true;
    }
}
