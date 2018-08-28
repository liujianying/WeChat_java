package com.tencent.xweb.extension.video;

import com.tencent.xweb.extension.video.b.a;

class c$12 implements a {
    final /* synthetic */ c vCb;

    c$12(c cVar) {
        this.vCb = cVar;
    }

    public final void ajO() {
        this.vCb.cIA();
        this.vCb.cIB();
    }

    public final void aJ(float f) {
        this.vCb.e((c.a(this.vCb) * ((double) f)) / 100.0d, false);
        c.b(this.vCb).evaluateJavascript(String.format("xwebVideoBridge.xwebToJS_Video_Seek(%f);", new Object[]{Double.valueOf(r0)}), new 1(this));
        this.vCb.cIz();
    }
}
