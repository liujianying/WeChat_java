package com.tencent.mm.ui.contact;

import com.tencent.mm.R;
import com.tencent.mm.ui.contact.AddressUI.a;
import com.tencent.mm.ui.contact.u.b;

class AddressUI$a$20 implements b {
    final /* synthetic */ a uhE;

    AddressUI$a$20(a aVar) {
        this.uhE = aVar;
    }

    public final void mh(boolean z) {
        if (a.d(this.uhE) != null) {
            BizContactEntranceView d = a.d(this.uhE);
            if (d.uih == null) {
                return;
            }
            if (z) {
                d.uih.setBackgroundResource(R.g.list_item_normal);
            } else {
                d.uih.setBackground(null);
            }
        }
    }
}
