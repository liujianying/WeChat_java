package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ab.l;
import com.tencent.mm.modelsimple.q;

class FacebookLoginUI$4 extends b {
    final /* synthetic */ FacebookLoginUI eQv;

    FacebookLoginUI$4(FacebookLoginUI facebookLoginUI) {
        this.eQv = facebookLoginUI;
    }

    public final l a(l lVar, String str) {
        return new q("facebook@wechat_auth", FacebookLoginUI.a(this.eQv), ((q) lVar).getSecCodeType(), str, ((q) lVar).Re(), ((q) lVar).Rg(), 0, "", true, false);
    }
}
