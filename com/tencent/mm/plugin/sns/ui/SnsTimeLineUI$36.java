package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.j.c.b;

class SnsTimeLineUI$36 implements OnClickListener {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$36(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void onClick(View view) {
        if (!(SnsTimeLineUI.g(this.odw) == null || SnsTimeLineUI.g(this.odw).nLK == null)) {
            SnsTimeLineUI.g(this.odw).nLK.nrb.hV(true);
        }
        b bVar = (b) this.odw.EW().P(b.class);
        com.tencent.mm.modelsns.b io = com.tencent.mm.modelsns.b.io(725);
        io.ir(bVar.onp);
        io.RD();
        Intent intent = new Intent();
        intent.setClass(this.odw, SnsMsgUI.class);
        this.odw.startActivityForResult(intent, 13);
    }
}
