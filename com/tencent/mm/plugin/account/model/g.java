package com.tencent.mm.plugin.account.model;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.f.a.a;
import com.tencent.mm.ui.f.a.a.1;
import com.tencent.mm.ui.f.a.c;

public final class g {
    private c eOa;
    a eOb;
    ag handler;

    static /* synthetic */ void a(g gVar, int i, String str) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.arg1 = i;
        obtain.obj = str;
        gVar.handler.sendMessage(obtain);
    }

    public g(c cVar, a aVar) {
        this.eOa = cVar;
        this.eOb = aVar;
    }

    public final void Yl() {
        this.handler = new 1(this);
        Bundle bundle = new Bundle();
        bundle.putString("client_id", "290293790992170");
        bundle.putString("client_secret", "6667e9307e67283c76028fd37189c096");
        bundle.putString("grant_type", "fb_exchange_token");
        bundle.putString("fb_exchange_token", this.eOa.eFo);
        e.post(new 1(new a(this.eOa), "oauth/access_token", bundle, "GET", new 2(this)), "AsyncFacebookRunner_request");
    }
}
