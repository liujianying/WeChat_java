package com.tencent.mm.plugin.profile;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.ui.newbizinfo.d.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class b implements ar {
    private static HashMap<Integer, d> cVM = new HashMap();
    private volatile a lUd;

    static {
        com.tencent.mm.pluginsdk.cmd.b.a(new com.tencent.mm.plugin.profile.ui.newbizinfo.a.a(), new String[]{"//usenewprofile"});
        cVM.put(Integer.valueOf("NEW_BIZINFO_PROFILE_INFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Ci() {
        return cVM;
    }

    public static a bni() {
        g.Eg().Ds();
        if (bnj().lUd == null) {
            b bnj = bnj();
            au.HU();
            bnj.lUd = new a(c.FO());
        }
        return bnj().lUd;
    }

    private static b bnj() {
        au.HN();
        b bVar = (b) bs.iK("plugin.profile");
        if (bVar != null) {
            return bVar;
        }
        x.w("MicroMsg.SubCoreProfile", "not found in MMCore, new one");
        bVar = new b();
        au.HN().a("plugin.freewifi", bVar);
        return bVar;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
