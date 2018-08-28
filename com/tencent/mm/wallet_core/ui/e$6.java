package com.tencent.mm.wallet_core.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.bg.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.x;

class e$6 implements OnClickListener {
    final /* synthetic */ TextView uZc;
    final /* synthetic */ String uZd;
    final /* synthetic */ String val$url;

    e$6(String str, TextView textView, String str2) {
        this.val$url = str;
        this.uZc = textView;
        this.uZd = str2;
    }

    public final void onClick(View view) {
        x.i("MicroMsg.WalletBaseUtil ", "hy: on click banner");
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.val$url);
        intent.putExtra("showShare", false);
        d.b(this.uZc.getContext(), "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        f.eA(e.aaF(this.uZd), 1);
    }
}
