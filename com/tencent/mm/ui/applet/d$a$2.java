package com.tencent.mm.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bv.d;
import com.tencent.mm.ui.applet.d.a;

class d$a$2 implements OnClickListener {
    final /* synthetic */ a tse;

    d$a$2(a aVar) {
        this.tse = aVar;
    }

    public final void onClick(View view) {
        if (this.tse.trZ && this.tse.bRm.getVisibility() != 0) {
            d.cov().b(this.tse.tsb);
        }
        a aVar = this.tse;
        try {
            if (aVar.trG != null) {
                if (aVar.trF != null) {
                    aVar.trG.removeView(aVar.trF);
                }
                aVar.trG = null;
            }
            if (aVar.trF != null) {
                aVar.trF.removeAllViews();
                aVar.trF = null;
            }
            aVar.mView = null;
        } catch (Exception e) {
        }
        d.crc();
    }
}
