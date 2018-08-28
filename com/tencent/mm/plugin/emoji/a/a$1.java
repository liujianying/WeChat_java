package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.emoji.model.h$a;

class a$1 implements OnClickListener {
    final /* synthetic */ h$a idp;
    final /* synthetic */ a idq;

    a$1(a aVar, h$a h_a) {
        this.idq = aVar;
        this.idp = h_a;
    }

    public final void onClick(View view) {
        if (this.idq.a(this.idp, view)) {
            this.idq.b(this.idp, view);
        }
    }
}
