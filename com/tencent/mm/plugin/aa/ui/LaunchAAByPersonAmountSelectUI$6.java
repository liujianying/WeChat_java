package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.a.c.a;

class LaunchAAByPersonAmountSelectUI$6 implements OnClickListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI eDf;

    LaunchAAByPersonAmountSelectUI$6(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        this.eDf = launchAAByPersonAmountSelectUI;
    }

    public final void onClick(View view) {
        if (LaunchAAByPersonAmountSelectUI.c(this.eDf) != null && LaunchAAByPersonAmountSelectUI.c(this.eDf).size() > 0) {
            try {
                a aVar = new a(this.eDf);
                aVar.Gr(i.aa_amount_select_clear_confirm);
                aVar.Gt(i.app_ok).a(new 1(this));
                aVar.Gu(i.app_cancel).b(new 2(this));
                aVar.anj().show();
            } catch (Exception e) {
                x.e("MicroMsg.LaunchAAByPersonAmountSelectUI", "clear amount error");
            }
        }
        h.mEJ.h(13721, new Object[]{Integer.valueOf(3), Integer.valueOf(8)});
    }
}
