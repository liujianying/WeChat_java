package com.tencent.mm.plugin.record.b;

import com.tencent.mm.g.a.fz;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.sdk.b.a;

public final class b {
    public static String a(com.tencent.mm.plugin.record.ui.a.b bVar) {
        fz fzVar = new fz();
        fzVar.bOL.type = 2;
        fzVar.bOL.bON = bVar.bOz;
        a.sFg.m(fzVar);
        return fzVar.bOM.path;
    }

    public static String b(com.tencent.mm.plugin.record.ui.a.b bVar) {
        fz fzVar = new fz();
        fzVar.bOL.type = 2;
        fzVar.bOL.bON = bVar.bOz;
        a.sFg.m(fzVar);
        return fzVar.bOM.bOX;
    }

    public static boolean c(com.tencent.mm.plugin.record.ui.a.b bVar) {
        fz fzVar = new fz();
        fzVar.bOL.type = 14;
        fzVar.bOL.bON = bVar.bOz;
        a.sFg.m(fzVar);
        if (fzVar.bOM.ret == 1) {
            return true;
        }
        return false;
    }

    public static g eo(long j) {
        return ((ae) com.tencent.mm.kernel.g.n(ae.class)).getFavItemInfoStorage().dy(j);
    }
}
