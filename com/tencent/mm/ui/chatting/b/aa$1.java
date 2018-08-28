package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.g.a.jt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class aa$1 extends c<jt> {
    final /* synthetic */ aa tRb;

    aa$1(aa aaVar) {
        this.tRb = aaVar;
        this.sFo = jt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        switch (((jt) bVar).bTE.action) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 7:
                if (this.tRb.bAG != null) {
                    this.tRb.bAG.avj();
                    break;
                }
                break;
        }
        return false;
    }
}
