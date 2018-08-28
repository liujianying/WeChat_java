package com.tencent.mm.plugin.appbrand.game.page;

import com.tencent.mm.plugin.appbrand.page.aa;

class c$1 implements Runnable {
    final /* synthetic */ c fCE;
    final /* synthetic */ String val$url;

    c$1(c cVar, String str) {
        this.fCE = cVar;
        this.val$url = str;
    }

    public final void run() {
        c.a(this.fCE, new b(this.fCE.getContext(), this.fCE));
        this.fCE.addView(c.a(this.fCE), 0);
        c.a(this.fCE).getCurrentPageView().a(new 1(this));
        c.a(this.fCE).loadUrl(this.val$url);
        c.a(this.fCE).a(aa.gpf);
        c.a(this.fCE).agE();
        c.a(this.fCE).alJ();
    }
}
