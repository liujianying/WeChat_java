package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

class s$4 implements OnClickListener {
    final /* synthetic */ String qiU;
    final /* synthetic */ s ucn;
    final /* synthetic */ String val$url;

    s$4(s sVar, String str, String str2) {
        this.ucn = sVar;
        this.val$url = str;
        this.qiU = str2;
    }

    public final void onClick(View view) {
        if (!bi.oW(this.val$url)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.val$url);
            d.b(s.b(this.ucn).tTq.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            h.mEJ.h(11608, new Object[]{s.d(this.ucn), this.qiU, Integer.valueOf(1)});
        }
    }
}
