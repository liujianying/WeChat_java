package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class FlipView$5 extends c<mu> {
    final /* synthetic */ FlipView nNe;

    FlipView$5(FlipView flipView) {
        this.nNe = flipView;
        this.sFo = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mu muVar = (mu) bVar;
        if (!FlipView.i(this.nNe)) {
            x.i("MicroMsg.FlipView", "no need to scan image");
        } else if (FlipView.j(this.nNe) == null || FlipView.a(this.nNe) == null) {
            x.e("MicroMsg.FlipView", "not in recoging");
        } else if (muVar == null || !(muVar instanceof mu)) {
            x.e("MicroMsg.FlipView", "receive invalid callbak");
        } else if (muVar.bXK.filePath.equals(FlipView.a(this.nNe))) {
            x.i("MicroMsg.FlipView", "recog result: " + muVar.bXK.result);
            if (!bi.oW(muVar.bXK.result)) {
                FlipView.b(this.nNe, muVar.bXK.result);
                FlipView.a(this.nNe, muVar.bXK.bJr);
                FlipView.b(this.nNe, muVar.bXK.bJs);
                if (!(FlipView.f(this.nNe) == null || FlipView.j(this.nNe) == null)) {
                    FlipView.k(this.nNe);
                }
                this.nNe.f(FlipView.a(this.nNe), FlipView.l(this.nNe), FlipView.m(this.nNe), false);
            }
            FlipView.c(this.nNe);
        } else {
            x.e("MicroMsg.FlipView", "not same filepath");
        }
        return false;
    }
}
