package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class d$1 implements e {
    final /* synthetic */ String dhF;
    final /* synthetic */ int eeg;
    final /* synthetic */ a qyc;
    final /* synthetic */ Context val$context;
    final /* synthetic */ String val$url;

    d$1(Context context, int i, String str, String str2, a aVar) {
        this.val$context = context;
        this.eeg = i;
        this.dhF = str;
        this.val$url = str2;
        this.qyc = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        au.DF().b(233, this);
        x.i("MicroMsg.DeepLinkHelper", "[oneliang][doDeepLink][onSceneEnd]:errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        boolean z = false;
        if (lVar != null && (lVar instanceof h)) {
            h hVar = (h) lVar;
            x.d("MicroMsg.DeepLinkHelper", "bitset:" + hVar.QQ());
            long QQ = hVar.QQ();
            String QL = hVar.QL();
            if (d.al(QL, QQ)) {
                try {
                    x.i("MicroMsg.DeepLinkHelper", "[oneliang] uri: %s", new Object[]{QL});
                    z = d.a(this.val$context, hVar.QS(), hVar.QT(), QL);
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11405, new Object[]{QL, Integer.valueOf(1), Integer.valueOf(this.eeg), this.dhF, bi.oV(this.val$url)});
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DeepLinkHelper", e, "", new Object[]{""});
                    com.tencent.mm.plugin.report.service.h.mEJ.h(11405, new Object[]{QL, Integer.valueOf(0), Integer.valueOf(this.eeg), this.dhF, bi.oV(this.val$url)});
                }
            } else {
                x.i("MicroMsg.DeepLinkHelper", "[oneliang] no permission");
                Intent intent = new Intent();
                intent.setFlags(268435456);
                intent.setClassName(ad.getContext(), "com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", "https://support.weixin.qq.com/deeplink/noaccess#wechat_redirect");
                intent.putExtra("geta8key_session_id", hVar.QS());
                intent.putExtra("geta8key_cookie", hVar.QT());
                ad.getContext().startActivity(intent);
                com.tencent.mm.plugin.report.service.h.mEJ.h(11405, new Object[]{QL, Integer.valueOf(0), Integer.valueOf(this.eeg), this.dhF, bi.oV(this.val$url)});
                z = true;
            }
        }
        if (this.qyc != null) {
            this.qyc.a(i, i2, str, lVar, z);
        }
    }
}
