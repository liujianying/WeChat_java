package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URI;
import java.net.URL;

class m$2 implements OnClickListener {
    final /* synthetic */ m lWI;

    m$2(m mVar) {
        this.lWI = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String str = "http://tools.3g.qq.com/j/wechatandriodpim";
        if (e.bxk == 1) {
            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
            if (bi.k(this.lWI.context, addFlags)) {
                this.lWI.context.startActivity(addFlags);
                return;
            }
            str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
        }
        try {
            URL url = new URL(str);
            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
            a aVar = new a();
            aVar.yS("qqpim.apk");
            aVar.yQ(toURL.toString());
            aVar.ef(true);
            aVar.ox(1);
            d.aCU().a(aVar.ick);
        } catch (Exception e) {
            x.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[]{e.toString()});
        }
    }
}
