package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.protocal.c.cgj;
import com.tencent.mm.sdk.platformtools.x;

class AppBrandAuthorizeUI$7 implements a {
    final /* synthetic */ AppBrandAuthorizeUI guf;

    AppBrandAuthorizeUI$7(AppBrandAuthorizeUI appBrandAuthorizeUI) {
        this.guf = appBrandAuthorizeUI;
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        x.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            cgj cgj = (cgj) bVar.dIE.dIL;
            if (cgj == null) {
                AppBrandAuthorizeUI.c(this.guf);
                x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
            } else {
                int i3 = cgj.sAE.errCode;
                String str2 = cgj.sAE.Yy;
                if (i3 == 0) {
                    this.guf.gtY = cgj.sAF;
                    AppBrandAuthorizeUI.a(this.guf, this.guf.gtY);
                } else {
                    AppBrandAuthorizeUI.c(this.guf);
                    x.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", new Object[]{str2});
                }
            }
        } else {
            AppBrandAuthorizeUI.c(this.guf);
        }
        return 0;
    }
}
