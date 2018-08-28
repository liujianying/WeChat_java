package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.plugin.sns.model.af;

public final class h {
    public static n Nk(String str) {
        if (v.Lr(str)) {
            return af.byo().fi(v.NE(str));
        }
        e eZ = af.byr().eZ(v.NE(str));
        if (eZ != null) {
            return eZ.bAL();
        }
        return null;
    }

    public static boolean a(String str, n nVar) {
        if (v.Lr(str)) {
            return af.byo().b(v.NE(str), nVar);
        }
        return af.byr().b(v.NE(str), nVar.bBp());
    }

    public static n Nl(String str) {
        if (v.Lr(str)) {
            return af.byo().xd(v.NF(str));
        }
        e xa = af.byr().xa(v.NF(str));
        if (xa != null) {
            return xa.bAL();
        }
        return null;
    }
}
