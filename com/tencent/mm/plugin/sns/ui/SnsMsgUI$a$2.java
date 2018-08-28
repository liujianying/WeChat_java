package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.SnsMsgUI.a;
import com.tencent.mm.sdk.platformtools.x;

class SnsMsgUI$a$2 implements OnClickListener {
    final /* synthetic */ a nYq;

    SnsMsgUI$a$2(a aVar) {
        this.nYq = aVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.SnsMsgUI", "on delView clicked");
        this.nYq.hkQ.aYm();
        if (this.nYq.nYp != null) {
            this.nYq.nYp.bv(view.getTag());
        }
    }
}
