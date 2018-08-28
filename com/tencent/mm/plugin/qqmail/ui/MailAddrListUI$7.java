package com.tencent.mm.plugin.qqmail.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.qqmail.ui.MailAddrListUI.a;
import java.util.ArrayList;
import java.util.List;

class MailAddrListUI$7 implements OnMenuItemClickListener {
    final /* synthetic */ MailAddrListUI mgK;

    MailAddrListUI$7(MailAddrListUI mailAddrListUI) {
        this.mgK = mailAddrListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        a e = MailAddrListUI.e(this.mgK);
        List arrayList = new ArrayList();
        for (String str : e.mgN.keySet()) {
            arrayList.add(e.mgN.get(str));
        }
        ComposeUI.bM(arrayList);
        this.mgK.setResult(-1);
        this.mgK.finish();
        return true;
    }
}
