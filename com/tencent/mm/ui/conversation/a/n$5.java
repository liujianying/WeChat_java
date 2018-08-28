package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.platformtools.ai;

class n$5 implements OnClickListener {
    final /* synthetic */ n usU;

    n$5(n nVar) {
        this.usU = nVar;
    }

    public final void onClick(View view) {
        if (!ai.L((Context) this.usU.qJS.get(), this.usU.usK)) {
            Intent intent = new Intent();
            intent.putExtra("title", ((Context) this.usU.qJS.get()).getString(R.l.net_warn_server_failed));
            intent.putExtra("rawUrl", ((Context) this.usU.qJS.get()).getString(R.l.net_warn_detail_doc));
            intent.putExtra("showShare", false);
            d.b((Context) this.usU.qJS.get(), "webview", ".ui.tools.WebViewUI", intent);
        }
    }
}
