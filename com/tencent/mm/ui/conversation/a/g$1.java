package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.bi;

class g$1 implements OnClickListener {
    final /* synthetic */ String usg;
    final /* synthetic */ g ush;

    g$1(g gVar, String str) {
        this.ush = gVar;
        this.usg = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("k_username", this.ush.usd);
        int i = 39;
        if (this.ush.tGg) {
            i = 36;
        }
        intent.putExtra("showShare", false);
        if (bi.oW(this.usg)) {
            intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(i)}));
        } else {
            intent.putExtra("rawUrl", this.usg);
        }
        if (this.ush.qJS.get() != null) {
            d.b((Context) this.ush.qJS.get(), "webview", ".ui.tools.WebViewUI", intent);
        }
        au.HU().Gu().iW(this.ush.usd);
        au.HU().Gu().iW(this.ush.use);
    }
}
