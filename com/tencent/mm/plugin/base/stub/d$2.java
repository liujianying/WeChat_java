package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.a.a$a;

class d$2 implements OnClickListener {
    final /* synthetic */ d hdF;

    d$2(d dVar) {
        this.hdF = dVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a aSm = a$a.aSm();
        if (aSm != null) {
            aSm.P(this.hdF.openId, q.GI(), this.hdF.appId);
        }
        this.hdF.hdE.dG(false);
    }
}
