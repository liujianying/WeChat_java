package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.f.a.b;
import com.tencent.mm.ui.f.a.c.a;
import com.tencent.mm.ui.f.a.d;

final class FacebookLoginUI$a implements a {
    final /* synthetic */ FacebookLoginUI eQv;

    private FacebookLoginUI$a(FacebookLoginUI facebookLoginUI) {
        this.eQv = facebookLoginUI;
    }

    /* synthetic */ FacebookLoginUI$a(FacebookLoginUI facebookLoginUI, byte b) {
        this(facebookLoginUI);
    }

    public final void m(Bundle bundle) {
        FacebookLoginUI.a(this.eQv, ProgressDialog.show(this.eQv, this.eQv.getString(j.app_tip), this.eQv.getString(j.facebook_auth_binding), true));
        FacebookLoginUI.e(this.eQv).setOnCancelListener(FacebookLoginUI.d(this.eQv));
        FacebookLoginUI.a(this.eQv, FacebookLoginUI.f(this.eQv).eFo);
        x.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", new Object[]{"facebook@wechat_auth", Integer.valueOf(FacebookLoginUI.a(this.eQv).length()), FacebookLoginUI.a(this.eQv).substring(0, 4)});
        FacebookLoginUI.a(this.eQv, new q("facebook@wechat_auth", FacebookLoginUI.a(this.eQv), 0, "", "", "", 0, "", true, false));
        g.DF().a(FacebookLoginUI.b(this.eQv), 0);
        FacebookLoginUI.cn(true);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eQv.getClass().getName()).append(",L14,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("L14")).append(",2").toString());
        h.mEJ.a(582, 6, 1, false);
    }

    public final void a(d dVar) {
        x.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + dVar.utw);
        com.tencent.mm.ui.base.h.b(this.eQv, dVar.getMessage(), this.eQv.getString(j.contact_info_facebookapp_bind_fail), true);
        FacebookLoginUI.cn(false);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eQv.getClass().getName()).append(",L14,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("L14")).append(",2").toString());
        h.mEJ.a(582, 7, 1, false);
    }

    public final void a(b bVar) {
        x.d("MicroMsg.FacebookLoginUI", "onError:" + bVar.getMessage());
        com.tencent.mm.ui.base.h.b(this.eQv, bVar.getMessage(), this.eQv.getString(j.contact_info_facebookapp_bind_fail), true);
        FacebookLoginUI.cn(false);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eQv.getClass().getName()).append(",L14,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("L14")).append(",2").toString());
        h.mEJ.a(582, 8, 1, false);
    }

    public final void onCancel() {
        x.d("MicroMsg.FacebookLoginUI", "onCancel");
        FacebookLoginUI.cn(false);
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eQv.getClass().getName()).append(",L14,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(com.tencent.mm.kernel.a.gd("L14")).append(",2").toString());
        h.mEJ.a(582, 9, 1, false);
    }
}
