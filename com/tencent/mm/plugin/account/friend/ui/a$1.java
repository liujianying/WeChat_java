package com.tencent.mm.plugin.account.friend.ui;

import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.storage.ab;

class a$1 implements a {
    final /* synthetic */ String dhF;
    final /* synthetic */ ab eLI;
    final /* synthetic */ a eLJ;
    final /* synthetic */ int hW;

    a$1(a aVar, ab abVar, int i, String str) {
        this.eLJ = aVar;
        this.eLI = abVar;
        this.hW = i;
        this.dhF = str;
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (z) {
            a.y(this.eLI);
            a.a(this.eLJ).pB(this.dhF);
            return;
        }
        a.a(this.eLJ).Q(this.dhF, z2);
    }
}
