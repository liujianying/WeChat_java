package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.r.b;
import com.tencent.mm.plugin.appbrand.jsapi.version.a;
import com.tencent.mm.sdk.platformtools.x;

class f$2 implements b<WxaAttributes> {
    final /* synthetic */ String dhF;
    final /* synthetic */ f gfF;

    f$2(f fVar, String str) {
        this.gfF = fVar;
        this.dhF = str;
    }

    public final /* synthetic */ void e(int i, Object obj) {
        WxaAttributes wxaAttributes = (WxaAttributes) obj;
        x.i("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "[appversion] onGetContact(%s), result %d, maybeNew.ver %d", new Object[]{this.dhF, Integer.valueOf(i), Integer.valueOf(wxaAttributes.ael().cbu)});
        WxaAttributes wxaAttributes2 = this.gfF.gfD;
        if (wxaAttributes.ael().fsi != 0) {
            this.gfF.gfE.b(a.fZM);
        } else if (wxaAttributes2.ael().cbu >= wxaAttributes.ael().cbu) {
            this.gfF.gfE.b(a.fZM);
        } else {
            WxaPkgWrappingInfo afp;
            this.gfF.gfE.b(a.fZL);
            try {
                afp = new z(wxaAttributes.field_appId, 0, "", this.gfF.fqE, wxaAttributes.ael()).afp();
            } catch (Exception e) {
                x.e("MicroMsg.AppBrand.Launching.ContactSilentSyncProcess", "%s, prepare pkg exp = %s", new Object[]{wxaAttributes.field_appId, e});
                afp = null;
            }
            this.gfF.gfE.b(afp == null ? a.fZO : a.fZN);
        }
    }
}
