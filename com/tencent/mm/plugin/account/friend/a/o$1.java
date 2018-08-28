package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.x;

class o$1 extends m {
    final /* synthetic */ o eKx;

    o$1(o oVar) {
        this.eKx = oVar;
    }

    protected final boolean Xu() {
        if (o.a(this.eKx) != null && !o.a(this.eKx).cjr()) {
            return true;
        }
        String str = "MicroMsg.GoogleContact.GoogleFriendUI";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = o.a(this.eKx) == null ? "null" : Boolean.valueOf(o.a(this.eKx).cjr());
        x.w(str, str2, objArr);
        return false;
    }
}
