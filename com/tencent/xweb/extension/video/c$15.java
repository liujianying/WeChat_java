package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;

class c$15 implements OnClickListener {
    final /* synthetic */ c vCb;

    c$15(c cVar) {
        this.vCb = cVar;
    }

    public final void onClick(View view) {
        c.b(this.vCb).evaluateJavascript("xwebVideoBridge.xwebToJS_Video_Play();", new 1(this));
        this.vCb.cIz();
    }
}
