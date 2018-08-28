package com.tencent.mm.pluginsdk.ui.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.l.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;

class l$a$1 implements OnClickListener {
    final /* synthetic */ a qQl;

    l$a$1(a aVar) {
        this.qQl = aVar;
    }

    public final void onClick(View view) {
        if (C2Java.isNetworkConnected()) {
            q.f(a.a(this.qQl), a.c(this.qQl));
            if (a.b(this.qQl) != null) {
                a.b(this.qQl).ga(true);
                return;
            }
            return;
        }
        x.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
        s.makeText(a.a(this.qQl), a.a(this.qQl).getString(R.l.fmt_iap_err), 0).show();
        if (a.b(this.qQl) != null) {
            a.b(this.qQl).ga(false);
        }
    }
}
