package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.dd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;

public final class ag {
    public static int a(Context context, av avVar) {
        if (avVar == null) {
            return 0;
        }
        if (avVar.hcE != 6) {
            return avVar.otY;
        }
        if (avVar.raU == null) {
            return 0;
        }
        if (a.ezo.r(context, avVar.raS.jQb)) {
            return avVar.raU.rcR;
        }
        return avVar.raU.rcS;
    }

    public static void a(Context context, ay ayVar, av avVar) {
        if (!(avVar == null || avVar.raS == null)) {
            boolean z;
            String str = avVar.raS.jQb;
            if (bi.oW(str)) {
                z = false;
            } else {
                f bl = g.bl(str, true);
                if (bl == null || bi.oW(bl.field_appId)) {
                    z = false;
                } else {
                    z = (bl.field_appInfoFlag & 32) > 0;
                    x.v("MicroMsg.AppInfoLogic", "canShowSNSTail, appid = %s, ret = %b", new Object[]{bl.field_appId, Boolean.valueOf(z)});
                }
            }
            if (z) {
                ayVar.ofl = false;
                String str2 = "";
                if (avVar.raW == null || avVar.raX == null) {
                    str = avVar == null ? "" : avVar.hcE == 6 ? avVar.raV == null ? "" : a.ezo.r(context, avVar.raS.jQb) ? avVar.raV.rdl : avVar.raV.rdm : avVar.raT;
                    try {
                        if (!bi.oW(str)) {
                            int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                            if (identifier > 0) {
                                str = context.getString(identifier);
                            }
                        }
                    } catch (Exception e) {
                    }
                    str = str2;
                } else {
                    dd ddVar;
                    if (a.ezo.r(context, avVar.raS.jQb)) {
                        ddVar = avVar.raW;
                    } else {
                        ddVar = avVar.raX;
                    }
                    str2 = w.chP();
                    if (str2.equals("zh_CN")) {
                        str = ddVar.rdj;
                    } else if (str2.equals("zh_TW") || str2.equals("zh_HK")) {
                        str = ddVar.rdk;
                    } else {
                        str = ddVar.rdi;
                    }
                }
                switch (avVar.hcE) {
                    case 4:
                        ayVar.ofm = str;
                        ayVar.ofl = true;
                        break;
                    case 5:
                        if (avVar.otY == 1) {
                            ayVar.ofm = str;
                            ayVar.ofl = true;
                            break;
                        }
                        break;
                    case 6:
                        ayVar.ofm = str;
                        ayVar.ofl = true;
                        break;
                    default:
                        ayVar.ofl = false;
                        break;
                }
                if (bi.oW(str)) {
                    x.e("MicroMsg.OpenActionContent", "text can not load ?");
                    ayVar.ofl = false;
                    return;
                }
                return;
            }
        }
        ayVar.ofl = false;
    }
}
