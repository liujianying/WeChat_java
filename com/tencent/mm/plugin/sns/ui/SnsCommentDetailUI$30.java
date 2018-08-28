package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b$f;
import com.tencent.mm.sdk.platformtools.bi;

class SnsCommentDetailUI$30 implements b$f {
    final /* synthetic */ int eaH;
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ ak nUY;
    final /* synthetic */ long nVa;
    final /* synthetic */ boolean nje;

    SnsCommentDetailUI$30(SnsCommentDetailUI snsCommentDetailUI, long j, boolean z, int i, ak akVar) {
        this.nUO = snsCommentDetailUI;
        this.nVa = j;
        this.nje = z;
        this.eaH = i;
        this.nUY = akVar;
    }

    public final void b(b bVar, long j) {
        int bvL = (int) bVar.bvL();
        SnsCommentDetailUI.A(this.nUO).b(this.nVa, bi.VG(), this.nje);
        SnsCommentDetailUI.A(this.nUO).d(this.nVa, bvL, this.nje);
        SnsCommentDetailUI.A(this.nUO).z(this.nVa, this.nVa + ((long) this.eaH));
        this.nUY.neL.setOnDecodeDurationListener(null);
    }
}
