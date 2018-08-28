package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLivePushConfig;

class d$2 implements e {
    final /* synthetic */ int eeg;
    final /* synthetic */ Bundle qdq;
    final /* synthetic */ a qyc;
    final /* synthetic */ String qyd;
    final /* synthetic */ Context val$context;

    d$2(Bundle bundle, Context context, int i, String str, a aVar) {
        this.qdq = bundle;
        this.val$context = context;
        this.eeg = i;
        this.qyd = str;
        this.qyc = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(TXLivePushConfig.DEFAULT_MAX_VIDEO_BITRATE, this);
        x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: errType = %s; errCode = %s; errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        boolean z = false;
        if (lVar != null && (lVar instanceof aa)) {
            String Rv = ((aa) lVar).Rv();
            if (d.SA(Rv)) {
                try {
                    x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: deepLinkUri = %s", new Object[]{Rv});
                    x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink gotoUri extraData: %s", new Object[]{this.qdq});
                    z = d.a(this.val$context, Rv, this.eeg, this.qdq, this.qyd);
                    h.mEJ.h(11405, new Object[]{this.qyd, Integer.valueOf(this.eeg), Integer.valueOf(1), Rv});
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", new Object[]{""});
                    h.mEJ.h(11405, new Object[]{this.qyd, Integer.valueOf(this.eeg), Integer.valueOf(0), Rv});
                }
            } else {
                x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink: translate failed");
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                intent.putExtra("showShare", false);
                x.i("MicroMsg.DeepLinkHelper", "doTicketsDeepLink goto WebViewUI extraData: %s", new Object[]{this.qdq});
                if (this.qdq != null) {
                    intent.putExtras(this.qdq);
                }
                ad.getContext().startActivity(intent);
                h.mEJ.h(11405, new Object[]{this.qyd, Integer.valueOf(this.eeg), Integer.valueOf(0), Rv});
                z = true;
            }
        }
        if (this.qyc != null) {
            this.qyc.a(i, i2, str, lVar, z);
        }
    }
}
