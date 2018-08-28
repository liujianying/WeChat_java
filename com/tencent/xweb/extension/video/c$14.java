package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.ValueCallback;

class c$14 implements OnClickListener {
    final /* synthetic */ c vCb;

    c$14(c cVar) {
        this.vCb = cVar;
    }

    public final void onClick(View view) {
        c.b(this.vCb).evaluateJavascript("xwebVideoBridge.xwebToJS_Video_ExitFullscreen();", new ValueCallback<String>() {
            public final /* bridge */ /* synthetic */ void onReceiveValue(Object obj) {
            }
        });
    }
}
