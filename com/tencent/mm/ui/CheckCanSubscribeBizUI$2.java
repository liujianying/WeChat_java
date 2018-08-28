package com.tencent.mm.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.bi;

class CheckCanSubscribeBizUI$2 implements a {
    final /* synthetic */ CheckCanSubscribeBizUI thi;

    CheckCanSubscribeBizUI$2(CheckCanSubscribeBizUI checkCanSubscribeBizUI) {
        this.thi = checkCanSubscribeBizUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        nn nnVar = (nn) bVar.dIE.dIL;
        CheckCanSubscribeBizUI.a(this.thi, nnVar.rrB);
        if (i == 0 && i2 == 0 && !bi.oW(nnVar.rrB) && !bi.oW(nnVar.jTu)) {
            CheckCanSubscribeBizUI.b(this.thi, nnVar.jTu);
            CheckCanSubscribeBizUI.c(this.thi, nnVar.rrC);
            CheckCanSubscribeBizUI.b(this.thi);
        } else if (w.a.a(this.thi, i, i2, str, 7)) {
            this.thi.setResult(5);
            this.thi.finish();
        } else {
            CheckCanSubscribeBizUI.c(this.thi);
            this.thi.setResult(3);
            this.thi.finish();
        }
        return 0;
    }
}
