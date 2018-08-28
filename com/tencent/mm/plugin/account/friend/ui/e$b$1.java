package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.friend.ui.e.b;

class e$b$1 implements OnClickListener {
    final /* synthetic */ e eMJ;
    final /* synthetic */ b eMK;

    e$b$1(b bVar, e eVar) {
        this.eMK = bVar;
        this.eMJ = eVar;
    }

    public final void onClick(View view) {
        if (e.b(this.eMK.eMG) != null) {
            e.b(this.eMK.eMG).d(this.eMK.eIy, this.eMK.eMI, this.eMK.status);
        }
    }
}
