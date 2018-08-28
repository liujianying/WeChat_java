package com.tencent.mm.plugin.shake.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.e.c.a;

class TVInfoUI$2 implements OnClickListener {
    final /* synthetic */ a nbC;
    final /* synthetic */ TVInfoUI nbD;

    TVInfoUI$2(TVInfoUI tVInfoUI, a aVar) {
        this.nbD = tVInfoUI;
        this.nbC = aVar;
    }

    public final void onClick(View view) {
        h.mEJ.h(10987, new Object[]{Integer.valueOf(2), this.nbC.field_playstatid, "", ""});
        TVInfoUI.a(this.nbD, this.nbC.field_playurl);
    }
}
