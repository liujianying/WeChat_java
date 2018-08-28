package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements OnClickListener {
    final /* synthetic */ a tsi;

    a$1(a aVar) {
        this.tsi = aVar;
    }

    public final void onClick(View view) {
        this.tsi.Ed(1);
        a aVar = this.tsi;
        String str = this.tsi.mUrl;
        if (bi.oW(str)) {
            x.e("MicroMsg.ChattingMonitoredBanner", "hy: not provide url");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("show_bottom", false);
        d.b((Context) aVar.qJS.get(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
