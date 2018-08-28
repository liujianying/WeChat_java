package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.b.b$b;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static a a(Context context, int i, Object[] objArr) {
        boolean z = false;
        String obj;
        String obj2;
        switch (1.urQ[i - 1]) {
            case 1:
                if (objArr == null || objArr.length != 2) {
                    return null;
                }
                obj = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj2 = objArr[1].toString();
                } else {
                    obj2 = null;
                }
                if (au.HU().Gt() == null) {
                    x.w("MicroMsg.BannerFactory", "recommend banner stg is null. this may be caused by account async init.");
                }
                if (au.HU().Gt() == null) {
                    return null;
                }
                if (au.HU().Gt().iV(obj) || au.HU().Gt().iV(obj2)) {
                    return new f(context, obj, obj2);
                }
                return null;
            case 2:
                if (objArr == null || objArr.length != 3) {
                    return null;
                }
                String obj3;
                boolean z2;
                obj2 = objArr[0] != null ? objArr[0].toString() : null;
                if (objArr[1] != null) {
                    obj3 = objArr[1].toString();
                } else {
                    obj3 = null;
                }
                if (objArr[2] == null || !(objArr[2] instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) objArr[2]).booleanValue();
                }
                if ((au.HX() && au.HU().Gu() != null && au.HU().Gu().iV(obj2)) || au.HU().Gu().iV(obj3)) {
                    return new g(context, obj2, obj3, z2);
                }
                return null;
            case 3:
                return new n(context);
            case 4:
                return new h(context);
            case 5:
                return new a(context);
            case 6:
                bc.Ig();
                bb Ih = bc.Ih();
                if (Ih != null) {
                    return new k(context, Ih);
                }
                return null;
            case 7:
                com.tencent.mm.model.a.e iP = g.IW().iP("4");
                if (iP == null) {
                    return null;
                }
                obj = iP.value;
                if (bi.oW(obj) || obj.equals("0")) {
                    return null;
                }
                Object obj4;
                a kVar;
                if (obj.equals("1")) {
                    au.HU();
                    obj4 = c.DT().get(328195, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        x.i("MicroMsg.BannerFactory", "[cpan] banner type bind mobile has clicked.");
                        return null;
                    }
                    bc.Ig();
                    int Ii = bc.Ii();
                    if (Ii == bc.a.dCc || Ii == bc.a.dCd) {
                        x.i("MicroMsg.BannerFactory", "already Bind the Mobile");
                        return null;
                    }
                    kVar = new k(context, new bb(1, 1, ""));
                    f.iT("4");
                    return kVar;
                } else if (!obj.equals("2")) {
                    return null;
                } else {
                    au.HU();
                    obj4 = c.DT().get(328196, Boolean.valueOf(false));
                    if (obj4 instanceof Boolean) {
                        z = ((Boolean) obj4).booleanValue();
                    }
                    if (z) {
                        x.i("MicroMsg.BannerFactory", "[cpan] banner type upload contact has clicked.");
                        return null;
                    }
                    bc.Ig();
                    if (bc.Ii() == bc.a.dCc) {
                        x.i("MicroMsg.BannerFactory", "already upload the Mobile");
                        return null;
                    }
                    kVar = new k(context, new bb(2, 1, ""));
                    f.iT("4");
                    return kVar;
                }
            case 8:
                return new l(context);
            case 9:
                return new o(context);
            case 10:
                return new j(context);
            case 11:
                b$b b_b;
                if (objArr == null || objArr.length <= 0) {
                    b_b = b$b.Main;
                } else {
                    b_b = (b$b) objArr[0];
                }
                return new com.tencent.mm.ui.d.a(context, b_b);
            default:
                return null;
        }
    }
}
