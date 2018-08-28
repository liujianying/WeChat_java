package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.contact.OpenIMAddressUI.a;

class OpenIMAddressUI$a$14 implements f {
    final /* synthetic */ a ulb;

    OpenIMAddressUI$a$14(a aVar) {
        this.ulb = aVar;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.OpenIMAddressUI", "onItemDel object null");
        } else {
            a.a(this.ulb, obj.toString());
        }
    }
}
