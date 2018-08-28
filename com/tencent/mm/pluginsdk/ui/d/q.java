package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.mm.ui.base.s;
import java.io.File;

public final class q {
    public static boolean vq() {
        boolean z = true;
        if (g.Eg().Dx()) {
            boolean z2;
            if (bi.fU(ad.getContext()) || e.bxk == 1 || bi.getInt(com.tencent.mm.k.g.AT().getValue("ShowWeixinPBIntro"), 0) != 0 || p.r(ad.getContext(), "com.tencent.pb")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                int a = bi.a((Integer) g.Ei().DT().get(a.sPC, null), 3);
                x.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", new Object[]{Integer.valueOf(a)});
                if (a <= 0) {
                    return false;
                }
                g.Ei().DT().set(352257, Integer.valueOf(a - 1));
                return true;
            }
            String str = "MicroMsg.WxPhoneBookHelper";
            String str2 = "%b, %b, %b, %b";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(bi.fU(ad.getContext()));
            if (e.bxk != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (bi.getInt(com.tencent.mm.k.g.AT().getValue("ShowWeixinPBIntro"), 0) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            if (p.r(ad.getContext(), "com.tencent.pb")) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            x.d(str, str2, objArr);
            return false;
        }
        x.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
        return false;
    }

    public static void f(Context context, Bundle bundle) {
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        h.mEJ.h(11621, new Object[]{Integer.valueOf(i), Integer.valueOf(0)});
        FileDownloadTaskInfo yP = d.aCU().yP("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (yP == null || yP.status != 3) {
            s.makeText(context, context.getString(R.l.chatting_phone_downloading_wxpb), 2000).show();
            com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
            aVar.yQ("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            aVar.yS(context.getString(R.l.chatting_phone_wxpb));
            aVar.ox(1);
            aVar.ef(true);
            d.aCU().a(aVar.ick);
            return;
        }
        x.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (com.tencent.mm.a.e.cn(yP.path)) {
            com.tencent.mm.pluginsdk.model.app.q.g(context, Uri.fromFile(new File(yP.path)));
        }
    }
}
