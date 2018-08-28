package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.setting.a.i;

class SendFeedBackUI$1 implements OnClickListener {
    final /* synthetic */ SendFeedBackUI mQD;

    SendFeedBackUI$1(SendFeedBackUI sendFeedBackUI) {
        this.mQD = sendFeedBackUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", this.mQD.getString(i.wechat_faq_url));
        d.b(this.mQD.mController.tml, "webview", ".ui.tools.WebViewUI", intent);
    }
}
