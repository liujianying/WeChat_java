package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

public class d {
    protected String appId;
    protected Context context;
    protected a hdE;
    protected String openId;

    public d(Context context, String str, String str2, a aVar) {
        this.context = context;
        this.appId = str;
        this.openId = str2;
        this.hdE = aVar;
    }

    public final void atx() {
        if (this.openId == null || this.openId.length() == 0) {
            x.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.hdE.dG(true);
            return;
        }
        f bl = g.bl(this.appId, false);
        if (bl == null) {
            x.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.hdE.dG(true);
        } else if (ai.oW(bl.field_openId)) {
            x.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            x.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            ao.bmh().pS(this.appId);
            this.hdE.dG(true);
        } else if (this.openId.equalsIgnoreCase(bl.field_openId)) {
            x.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.hdE.dG(true);
        } else {
            x.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + bl.field_openId);
            Vl();
        }
    }

    protected void Vl() {
        h.b(this.context, R.l.openid_checker_fail_msg, R.l.app_tip, new 1(this), new 2(this));
    }
}
