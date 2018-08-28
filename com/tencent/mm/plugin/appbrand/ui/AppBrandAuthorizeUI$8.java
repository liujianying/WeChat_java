package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.protocal.c.cgt;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class AppBrandAuthorizeUI$8 implements a {
    final /* synthetic */ AppBrandAuthorizeUI guf;
    final /* synthetic */ List guj;

    AppBrandAuthorizeUI$8(AppBrandAuthorizeUI appBrandAuthorizeUI, List list) {
        this.guf = appBrandAuthorizeUI;
        this.guj = list;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            cgt cgt = (cgt) bVar.dIE.dIL;
            if (cgt == null) {
                x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
            } else {
                int i3 = cgt.sAE.errCode;
                String str2 = cgt.sAE.Yy;
                if (i3 == 0) {
                    x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
                    try {
                        q.rW(AppBrandAuthorizeUI.d(this.guf));
                    } catch (Exception e) {
                    }
                    AppBrandAuthorizeUI.b(this.guf, this.guj);
                } else {
                    x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq error %s", new Object[]{str2});
                }
            }
        }
        return 0;
    }
}
