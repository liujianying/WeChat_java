package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

final class BindFacebookUI$a implements a {
    final /* synthetic */ BindFacebookUI ePD;

    private BindFacebookUI$a(BindFacebookUI bindFacebookUI) {
        this.ePD = bindFacebookUI;
    }

    /* synthetic */ BindFacebookUI$a(BindFacebookUI bindFacebookUI, byte b) {
        this(bindFacebookUI);
    }

    public final void m(Bundle bundle) {
        x.d("MicroMsg.BindFacebookUI", "token:" + BindFacebookUI.c(this.ePD).eFo);
        g.Ei().DT().set(65830, BindFacebookUI.c(this.ePD).eFo);
        if (BindFacebookUI.c(this.ePD).utp != 0) {
            g.Ei().DT().set(65832, Long.valueOf(BindFacebookUI.c(this.ePD).utp));
        }
        BindFacebookUI.a(this.ePD, ProgressDialog.show(this.ePD, this.ePD.getString(j.app_tip), this.ePD.getString(j.facebook_auth_binding), true));
        BindFacebookUI.e(this.ePD).setOnCancelListener(BindFacebookUI.d(this.ePD));
        BindFacebookUI.a(this.ePD, new v(1, BindFacebookUI.c(this.ePD).eFo));
        g.DF().a(BindFacebookUI.a(this.ePD), 0);
        BindFacebookUI.cl(true);
    }

    public final void a(d dVar) {
        x.d("MicroMsg.BindFacebookUI", "onFacebookError:" + dVar.utw);
        h.b(this.ePD, dVar.getMessage(), this.ePD.getString(j.contact_info_facebookapp_bind_fail), true);
        BindFacebookUI.cl(false);
    }

    public final void a(b bVar) {
        x.d("MicroMsg.BindFacebookUI", "onError:" + bVar.getMessage());
        h.b(this.ePD, bVar.getMessage(), this.ePD.getString(j.contact_info_facebookapp_bind_fail), true);
        BindFacebookUI.cl(false);
    }

    public final void onCancel() {
        x.d("MicroMsg.BindFacebookUI", "onCancel");
        BindFacebookUI.cl(false);
    }
}
