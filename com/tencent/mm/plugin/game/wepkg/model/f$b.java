package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.game.wepkg.utils.b;
import com.tencent.mm.sdk.platformtools.x;

class f$b implements a<Bundle, Bundle> {
    private f$b() {
    }

    public final /* synthetic */ void a(Object obj, c cVar) {
        String string = ((Bundle) obj).getString("call_pkg_id");
        String str = "";
        if (!(b.kgk.Er(string) == null || b.kgk.Er(string).kff == null)) {
            str = b.kgk.Er(string).kff.version;
        }
        x.i("MicroMsg.Wepkg.WepkgManager", "pkgid:%s used_version:%s", new Object[]{string, str});
        Bundle bundle = new Bundle();
        bundle.putString("used_wepkg_version", str);
        if (cVar != null) {
            cVar.at(bundle);
        }
    }
}
