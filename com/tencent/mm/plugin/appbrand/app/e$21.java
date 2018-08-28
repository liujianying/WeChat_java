package com.tencent.mm.plugin.appbrand.app;

import com.tencent.mm.g.a.bs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class e$21 extends c<bs> {
    final /* synthetic */ e ffn;

    e$21(e eVar) {
        this.ffn = eVar;
        this.sFo = bs.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        bs bsVar = (bs) bVar;
        if (!bi.oW(bsVar.bJc.username) && g.Eg().dpD) {
            WxaAttributes e = e.aba().e(bsVar.bJc.username, new String[]{"roundedSquareIconURL", "brandIconURL", "bigHeadURL", "appId", "nickname"});
            if (e != null) {
                String[] strArr = new String[]{e.field_roundedSquareIconURL, e.field_brandIconURL, e.field_bigHeadURL};
                bsVar.bJd.bJe = strArr;
                bsVar.bJd.appId = e.field_appId;
                bsVar.bJd.nickname = e.field_nickname;
            }
        }
        return true;
    }
}
