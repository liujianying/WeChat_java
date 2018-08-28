package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.d.a;
import com.tencent.mm.plugin.appbrand.appcache.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.v.g;
import java.util.List;
import org.json.JSONObject;

public class z extends w<WxaPkgWrappingInfo> implements i {
    public static volatile boolean ggw = false;
    private final i ggx;

    z(String str, int i, String str2, int i2, d dVar) {
        List list;
        String str3;
        int i3;
        Object obj;
        if (a.jC(i)) {
            Object obj2 = (dVar.fsm || (ggw && !bi.cX(dVar.fsl))) ? 1 : null;
            list = dVar.fsl;
            str3 = dVar.fsn;
            i3 = dVar.fsk;
            obj = obj2;
        } else {
            JSONObject fU;
            String str4;
            List list2;
            try {
                fU = g.fU(((h) e.x(h.class)).aH(str, i));
            } catch (Exception e) {
                fU = null;
            }
            if (fU == null) {
                str4 = null;
                list2 = null;
                obj = null;
            } else {
                List sj = WxaAttributes.e.sj(fU.optString("module_list"));
                if (bi.cX(sj)) {
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    str4 = fU.optString("entrance_module");
                    list2 = sj;
                } else {
                    str4 = "";
                    list2 = sj;
                }
            }
            list = list2;
            str3 = str4;
            i3 = 0;
        }
        if (obj == null || bi.cX(list) || !k.abG()) {
            this.ggx = new l(str, i, dVar.cbu, i2, dVar) {
                public final void akC() {
                    z.this.akC();
                }

                public final void akE() {
                    z.this.akE();
                }

                public final void onDownloadProgress(int i) {
                    z.this.onDownloadProgress(i);
                }
            };
        } else {
            this.ggx = new 1(this, str, i, str2, i2, dVar.cbu, i3, str3, list);
        }
    }

    final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppPkgWrapper";
    }

    public void akC() {
    }

    public void akE() {
    }

    public void onDownloadProgress(int i) {
    }

    /* renamed from: afp */
    public final WxaPkgWrappingInfo call() {
        return (WxaPkgWrappingInfo) this.ggx.call();
    }
}
