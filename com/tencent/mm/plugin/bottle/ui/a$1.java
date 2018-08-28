package com.tencent.mm.plugin.bottle.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a hkR;

    a$1(a aVar) {
        this.hkR = aVar;
    }

    public final void onClick(View view) {
        x.v("MicroMsg.BottleConversationAdapter", "on delView clicked");
        this.hkR.hkQ.aYm();
        if (this.hkR.hkP != null) {
            this.hkR.hkP.bv(view.getTag());
        }
    }
}
