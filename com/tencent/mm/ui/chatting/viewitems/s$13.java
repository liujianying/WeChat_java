package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.g.a.kz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class s$13 extends c<kz> {
    final /* synthetic */ s ucn;

    s$13(s sVar) {
        this.ucn = sVar;
        this.sFo = kz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (s.b(this.ucn) != null) {
            s.b(this.ucn).tTq.getContext().runOnUiThread(new 1(this));
        }
        return true;
    }
}
