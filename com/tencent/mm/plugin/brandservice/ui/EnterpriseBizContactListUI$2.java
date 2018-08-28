package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.tools.l;

class EnterpriseBizContactListUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ EnterpriseBizContactListUI hpl;

    EnterpriseBizContactListUI$2(EnterpriseBizContactListUI enterpriseBizContactListUI) {
        this.hpl = enterpriseBizContactListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (EnterpriseBizContactListUI.a(this.hpl) != null) {
            EnterpriseBizContactListUI.a(this.hpl).dismiss();
            EnterpriseBizContactListUI.a(this.hpl, null);
        }
        EnterpriseBizContactListUI.a(this.hpl, new l(this.hpl.mController.tml));
        EnterpriseBizContactListUI.a(this.hpl).ofp = new 1(this);
        EnterpriseBizContactListUI.a(this.hpl).ofq = new 2(this);
        EnterpriseBizContactListUI.a(this.hpl).dZ();
        return false;
    }
}
