package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.friend.a.v;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

final class FacebookAuthUI$a implements a {
    final /* synthetic */ FacebookAuthUI eQg;

    private FacebookAuthUI$a(FacebookAuthUI facebookAuthUI) {
        this.eQg = facebookAuthUI;
    }

    /* synthetic */ FacebookAuthUI$a(FacebookAuthUI facebookAuthUI, byte b) {
        this(facebookAuthUI);
    }

    public final void m(Bundle bundle) {
        x.d("MicroMsg.FacebookAuthUI", "token:" + FacebookAuthUI.e(this.eQg).eFo);
        g.Ei().DT().set(65830, FacebookAuthUI.e(this.eQg).eFo);
        if (FacebookAuthUI.e(this.eQg).utp != 0) {
            g.Ei().DT().set(65832, Long.valueOf(FacebookAuthUI.e(this.eQg).utp));
        }
        FacebookAuthUI.a(this.eQg, ProgressDialog.show(this.eQg, this.eQg.getString(a$j.app_tip), this.eQg.getString(a$j.facebook_auth_binding), true));
        FacebookAuthUI.d(this.eQg).setOnCancelListener(FacebookAuthUI.c(this.eQg));
        FacebookAuthUI.a(this.eQg, new v(1, FacebookAuthUI.e(this.eQg).eFo));
        g.DF().a(FacebookAuthUI.a(this.eQg), 0);
        FacebookAuthUI.cm(true);
        h.mEJ.a(582, 1, 1, false);
    }

    public final void a(d dVar) {
        x.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + dVar.utw);
        com.tencent.mm.ui.base.h.b(this.eQg, dVar.getMessage(), this.eQg.getString(a$j.contact_info_facebookapp_bind_fail), true);
        FacebookAuthUI.cm(false);
        h.mEJ.a(582, 2, 1, false);
    }

    public final void a(b bVar) {
        x.d("MicroMsg.FacebookAuthUI", "onError:" + bVar.getMessage());
        com.tencent.mm.ui.base.h.b(this.eQg, bVar.getMessage(), this.eQg.getString(a$j.contact_info_facebookapp_bind_fail), true);
        FacebookAuthUI.cm(false);
        h.mEJ.a(582, 3, 1, false);
    }

    public final void onCancel() {
        x.d("MicroMsg.FacebookAuthUI", "onCancel");
        FacebookAuthUI.cm(false);
        h.mEJ.a(582, 4, 1, false);
    }
}
