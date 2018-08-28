package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PoiHeaderView$1 implements OnClickListener {
    final /* synthetic */ PoiHeaderView kFj;

    PoiHeaderView$1(PoiHeaderView poiHeaderView) {
        this.kFj = poiHeaderView;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        x.d("MicroMsg.PoiHeaderView", "click url %s", new Object[]{bi.oW(PoiHeaderView.a(this.kFj)) ? PoiHeaderView.b(this.kFj) : PoiHeaderView.a(this.kFj)});
        intent.putExtra("rawUrl", r0);
        intent.putExtra("showShare", false);
        d.e(this.kFj.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
