package com.tencent.mm.plugin.location.ui.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.j;

class h$11 implements OnClickListener {
    final /* synthetic */ h kKh;
    final /* synthetic */ String kKj;

    h$11(h hVar, String str) {
        this.kKh = hVar;
        this.kKj = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(this.kKh.activity, j.class);
        x.d("MicroMsg.TrackMapUI", "click url %s", new Object[]{this.kKj});
        intent.putExtra("rawUrl", this.kKj);
        intent.putExtra("showShare", false);
        d.e(this.kKh.activity, "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
