package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.b;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.r;

final class q$a implements Runnable {
    final /* synthetic */ q mLI;
    String url;

    private q$a(q qVar) {
        this.mLI = qVar;
    }

    /* synthetic */ q$a(q qVar, byte b) {
        this(qVar);
    }

    public final void run() {
        if (this.mLI.mKp != null && !q.e(this.mLI)) {
            r.a(new e());
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("jsapi_args_appid", "wx751a1acca5688ba3");
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", this.url);
            intent.putExtra("show_bottom", false);
            intent.putExtra(SlookSmartClipMetaTag.TAG_TYPE_TITLE, R.l.scan_entry_street);
            intent.putExtra("webview_bg_color_rsID", R.e.black);
            intent.putExtra("geta8key_scene", 13);
            intent.setFlags(65536);
            b.ezn.j(intent, this.mLI.mKp.getContext());
            this.mLI.mKp.getContext().finish();
            this.mLI.mKp.getContext().overridePendingTransition(0, 0);
        }
    }
}
