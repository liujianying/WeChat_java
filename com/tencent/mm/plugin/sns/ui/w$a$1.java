package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.w.a;

class w$a$1 implements OnClickListener {
    final /* synthetic */ a nNS;

    w$a$1(a aVar) {
        this.nNS = aVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null) {
            this.nNS.xh(((Integer) view.getTag()).intValue());
        }
    }
}
