package com.tencent.mm.plugin.sns.ui.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.v;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.rtmp.TXLiveConstants;

class b$12 implements OnClickListener {
    final /* synthetic */ b olf;

    b$12(b bVar) {
        this.olf = bVar;
    }

    public final void onClick(View view) {
        boolean z = false;
        if (view.getTag() != null) {
            n cN = b.cN(view);
            if (cN != null && cN.xb(32)) {
                boolean z2;
                if (cN.bBp().bAF().bzt()) {
                    int eN = v.eN(cN.bBp().bAF().bzp(), cN.bBo());
                    Object obj = eN > 0 ? 1 : null;
                    String bzp = cN.bBp().bAF().bzp();
                    String bBo = cN.bBo();
                    g.Eg();
                    v.g(bzp, bBo, a.Dg(), obj != null ? eN : 2, obj != null ? 0 : 1);
                    if (obj == null) {
                        z = true;
                    }
                    z2 = z;
                } else {
                    z2 = false;
                }
                bsu bAJ = cN.bAJ();
                if (bAJ.sqc.ruz == 15 && bAJ.sqj != 1) {
                    b.a(this.olf, view, cN, TXLiveConstants.PUSH_EVT_PUSH_BEGIN, cN.bBp().bAF().bzv(), z2);
                } else if ((bAJ.sqc.ruz == 1 && bAJ.sqc.ruA.size() == 1) || bAJ.sqc.ruz == 7) {
                    b.b(this.olf, view, cN, TXLiveConstants.PUSH_EVT_PUSH_BEGIN, cN.bBp().bAF().bzv(), z2);
                }
            }
        }
    }
}
