package com.tencent.mm.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b$b;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements OnClickListener {
    final /* synthetic */ a tsi;

    a$2(a aVar) {
        this.tsi = aVar;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.ChattingMonitoredBanner", "hy: user required close the banner");
        this.tsi.Ed(2);
        au.HU().Gv().c(b$b.Main);
        au.HU().Gv().c(b$b.Chatting);
        this.tsi.setVisibility(8);
    }
}
