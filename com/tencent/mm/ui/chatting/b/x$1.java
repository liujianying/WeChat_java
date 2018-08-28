package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h.c;

class x$1 implements c {
    final /* synthetic */ x tQP;

    x$1(x xVar) {
        this.tQP = xVar;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                x.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(a.a(this.tQP.bAG.tTq.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null))});
                if (a.a(this.tQP.bAG.tTq.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 67, null, null)) {
                    this.tQP.cvG();
                    return;
                }
                return;
            case 1:
                x.d("MicroMsg.ChattingUI.LocationComponent", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(a.a(this.tQP.bAG.tTq.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null))});
                if (a.a(this.tQP.bAG.tTq.getContext(), "android.permission.ACCESS_COARSE_LOCATION", 68, null, null)) {
                    this.tQP.cvH();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
