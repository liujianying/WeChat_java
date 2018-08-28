package com.tencent.mm.plugin.webview.modelcache;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.bl;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.e$i;

class n$3 extends c<bl> {
    final /* synthetic */ n pTf;

    n$3(n nVar) {
        this.pTf = nVar;
        this.sFo = bl.class.getName().hashCode();
    }

    private static boolean a(bl blVar) {
        if (blVar != null && (blVar instanceof bl)) {
            if (ad.getContext() != null) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(e$i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                ad.getContext().sendBroadcast(intent);
            }
            FileOp.mC(e.dgx);
            FileOp.I(e.dgx, false);
            WebViewCacheDownloadHelper.bUN();
            n.bUJ();
        }
        return false;
    }
}
