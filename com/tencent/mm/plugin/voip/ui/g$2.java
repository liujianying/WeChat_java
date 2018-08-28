package com.tencent.mm.plugin.voip.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;

class g$2 implements OnClickListener {
    final /* synthetic */ g oSR;
    final /* synthetic */ Intent val$intent;

    g$2(g gVar, Intent intent) {
        this.oSR = gVar;
        this.val$intent = intent;
    }

    public final void onClick(View view) {
        this.val$intent.addFlags(268435456);
        ad.getContext().startActivity(this.val$intent);
        view.setOnClickListener(null);
        g.a(this.oSR, new al(new 1(this), false));
        g.a(this.oSR).J(2000, 2000);
    }
}
