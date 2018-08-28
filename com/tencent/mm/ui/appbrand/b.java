package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.protocal.c.bsa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;

public final class b {
    public static void i(final Context context, final String str, final boolean z) {
        int i = 1;
        sl slVar = new sl();
        slVar.cdl.bGy = str;
        slVar.cdl.action = z ? 2 : 1;
        slVar.cdl.cdn = 2;
        a.sFg.m(slVar);
        LinkedList linkedList = new LinkedList();
        bsa bsa = new bsa();
        bsa.spI = str;
        if (!z) {
            i = 0;
        }
        bsa.spH = i;
        bsa.hcE = 3;
        linkedList.add(bsa);
        au.DF().a(1176, new e() {
            public final void a(int i, int i2, String str, l lVar) {
                int i3 = 1;
                au.DF().b(1176, this);
                x.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true)});
                if (i != 0 || i2 != 0) {
                    s.makeText(context, R.l.notify_message_settings_operation_failed, 0).show();
                    sl slVar = new sl();
                    slVar.cdl.bGy = str;
                    sl.a aVar = slVar.cdl;
                    if (!z) {
                        i3 = 2;
                    }
                    aVar.action = i3;
                    slVar.cdl.cdn = 2;
                    a.sFg.m(slVar);
                }
            }
        });
        au.DF().a(new m(linkedList), 0);
    }

    public static String ZV(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes rR = ((c) g.l(c.class)).rR(str);
        if (rR != null && rR.aej() != null) {
            return rR.aej().frY;
        }
        x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }

    public static String rW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes rR = ((c) g.l(c.class)).rR(str);
        if (rR != null && rR.aej() != null) {
            return rR.field_appId;
        }
        x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }

    public static String ZW(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes rR = ((c) g.l(c.class)).rR(str);
        if (rR != null) {
            return rR.field_nickname;
        }
        x.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }
}
