package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.friend.ui.f.b;

class f$b$1 implements OnClickListener {
    final /* synthetic */ f eMP;
    final /* synthetic */ b eMQ;

    f$b$1(b bVar, f fVar) {
        this.eMQ = bVar;
        this.eMP = fVar;
    }

    public final void onClick(View view) {
        if (f.b(this.eMQ.eMN) != null) {
            f.b(this.eMQ.eMN).d(this.eMQ.eIy, this.eMQ.account, this.eMQ.status);
        }
    }
}
