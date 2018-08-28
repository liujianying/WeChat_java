package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bi;

class SnsTimeLineUI$37 implements OnClickListener {
    final /* synthetic */ SnsTimeLineUI odw;

    SnsTimeLineUI$37(SnsTimeLineUI snsTimeLineUI) {
        this.odw = snsTimeLineUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.odw, SnsUserUI.class);
        Intent e = af.bye().e(intent, SnsTimeLineUI.H(this.odw));
        if (e == null) {
            this.odw.finish();
            return;
        }
        g.Ek();
        int a = bi.a((Integer) g.Ei().DT().get(68388, null), 0);
        g.Ek();
        g.Ei().DT().set(68388, Integer.valueOf(a + 1));
        this.odw.startActivity(e);
        if ((e.getFlags() & 67108864) != 0) {
            this.odw.finish();
        }
    }
}
