package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.applet.b.b;

class d$2 implements b {
    final /* synthetic */ d uiq;

    d$2(d dVar) {
        this.uiq = dVar;
    }

    public final String jd(int i) {
        if (i < 0 || i >= this.uiq.getCount()) {
            x.e("MicroMsg.ChatroomContactAdapter", "pos is invalid");
            return null;
        }
        ab abVar = (ab) this.uiq.getItem(i);
        return abVar == null ? null : abVar.field_username;
    }

    public final int Xy() {
        return this.uiq.getCount();
    }
}
