package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.facedetect.ui.b.c;
import com.tencent.mm.sdk.platformtools.x;

class b$c$1 implements OnClickListener {
    final /* synthetic */ c iSa;

    b$c$1(c cVar) {
        this.iSa = cVar;
    }

    public final void onClick(View view) {
        if (c.a(this.iSa).get() != null) {
            b bVar = (b) c.a(this.iSa).get();
            if (bVar.iRV != null) {
                bVar.iRV.aKu();
            }
            bVar.dismiss();
            return;
        }
        x.e("MicroMsg.FaceTutorialUI.TutorialTwo", "hy: lost tutorial instance");
    }
}
