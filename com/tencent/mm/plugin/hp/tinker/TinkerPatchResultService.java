package com.tencent.mm.plugin.hp.tinker;

import android.os.Looper;
import com.tencent.mm.app.b;
import com.tencent.mm.modelmulti.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public class TinkerPatchResultService extends DefaultTinkerResultService {
    public final void a(a aVar) {
        int i = 1;
        if (aVar == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerPatchResultService", "TinkerPatchResultService received null result!!!!", new Object[0]);
            return;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "TinkerPatchResultService receive result: %s", new Object[]{aVar.toString()});
        new ag(Looper.getMainLooper()).postDelayed(new 1(this), 10000);
        if (aVar.bLW) {
            ApplicationLike applicationLike = b.applicationLike;
            if (com.tencent.tinker.lib.e.b.d(applicationLike)) {
                String e = com.tencent.tinker.lib.e.b.e(applicationLike);
                if (!(ShareTinkerInternals.oW(e) || aVar.vsp == null || !aVar.vsp.equals(e))) {
                    i = 0;
                }
            }
            if (i != 0) {
                m mVar = new m(ad.getContext(), new 2(this));
            } else {
                com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }
}
