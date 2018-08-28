package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.sdk.platformtools.bi;

class SnsCommentDetailUI$25 implements f {
    final /* synthetic */ n nMf;
    final /* synthetic */ SnsCommentDetailUI nUO;
    final /* synthetic */ ak nUY;

    SnsCommentDetailUI$25(SnsCommentDetailUI snsCommentDetailUI, n nVar, ak akVar) {
        this.nUO = snsCommentDetailUI;
        this.nMf = nVar;
        this.nUY = akVar;
    }

    public final void b(b bVar, long j) {
        if (SnsCommentDetailUI.A(this.nUO) != null) {
            int bvL = (int) bVar.bvL();
            SnsCommentDetailUI.A(this.nUO).b(this.nMf.field_snsId, bi.VG(), false);
            SnsCommentDetailUI.A(this.nUO).d(this.nMf.field_snsId, bvL, false);
            if (j >= 3) {
                SnsCommentDetailUI.A(this.nUO).z(this.nMf.field_snsId, this.nMf.field_snsId);
                this.nUY.neL.setOnDecodeDurationListener(null);
            }
        }
    }
}
