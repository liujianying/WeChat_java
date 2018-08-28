package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.ad;

public final class m extends n {
    private a pxb;

    public m(a aVar) {
        this(aVar, (byte) 0);
    }

    private m(a aVar, byte b) {
        super(2, null);
        this.pxb = aVar;
    }

    public final void onClick(View view) {
        if (this.pxb != null) {
            this.pxb.aCb();
        }
    }

    protected final void zu(int i) {
        Context context = ad.getContext();
        super.zu(i);
        if (i == 5) {
            ez(context.getResources().getColor(c.white), context.getResources().getColor(c.sns_link_bg_color));
        }
    }
}
