package com.tencent.mm.plugin.welab.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.welab.a.d;
import com.tencent.mm.sdk.platformtools.w;

class WelabMainUI$1 implements OnClickListener {
    final /* synthetic */ WelabMainUI qnr;

    WelabMainUI$1(WelabMainUI welabMainUI) {
        this.qnr = welabMainUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("title", view.getResources().getString(d.welab_privacy_tip));
        intent.putExtra("rawUrl", this.qnr.mController.tml.getString(d.welab_agreement_url, new Object[]{w.chP(), Integer.valueOf(com.tencent.mm.protocal.d.qVN)}));
        intent.putExtra("showShare", false);
        com.tencent.mm.bg.d.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }
}
