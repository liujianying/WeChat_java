package com.tencent.mm.plugin.record.ui.b;

import com.tencent.mm.R;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.record.ui.b.a.2;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n$c;

class a$2$1 implements n$c {
    final /* synthetic */ 2 mty;

    a$2$1(2 2) {
        this.mty = 2;
    }

    public final void a(l lVar) {
        if (2.a(this.mty).rAw == 0) {
            if (2.b(this.mty).aLd()) {
                lVar.e(2, 2.c(this.mty).getString(R.l.favorite_share_with_friend));
            }
            if (2.b(this.mty).aLe()) {
                lVar.e(1, 2.c(this.mty).getString(R.l.favorite_post_to_sns));
            }
            lVar.e(3, 2.c(this.mty).getString(R.l.favorite_save_image));
            mu muVar = (mu) this.mty.mtv.iYQ.get(2.d(this.mty));
            if (muVar == null) {
                ms msVar = new ms();
                msVar.bXH.filePath = 2.d(this.mty);
                a.sFg.m(msVar);
            } else if (!bi.oW(muVar.bXK.result)) {
                lVar.e(4, 2.c(this.mty).getString(com.tencent.mm.plugin.scanner.a.aB(muVar.bXK.bJr, muVar.bXK.result) ? R.l.recog_wxcode_of_image_file : R.l.recog_qbar_of_image_file));
            }
        }
    }
}
