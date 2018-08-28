package com.tencent.mm.ui.contact;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$1 implements OnMenuItemClickListener {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$1(a aVar) {
        this.ulb = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.ulb.finish();
        return true;
    }
}
