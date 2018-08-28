package com.tencent.mm.plugin.walletlock.b;

import com.tencent.mm.g.a.sd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.plugin.walletlock.gesture.a.e;
import com.tencent.mm.protocal.c.ayz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class f$3 extends c<sd> {
    final /* synthetic */ f pIs;

    f$3(f fVar) {
        this.pIs = fVar;
        this.sFo = sd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ayz ayz = ((sd) bVar).ccW.ccX;
        g gVar = g.pIt;
        g.bRv();
        if (e.b(ayz)) {
            x.i("MicroMsg.WalletLockInitTask", "tom update PatternLockInfo, sign_len:%d,valid:%b,status:%d,ver:%d", new Object[]{Integer.valueOf(ayz.sbL.siI), Boolean.valueOf(e.b(ayz)), Integer.valueOf(ayz.sbM), Integer.valueOf(ayz.sbK)});
            d.a(ayz);
        } else {
            x.w("MicroMsg.WalletLockInitTask", "UserInfoExt.PatternLockInfo is null or invalid.");
        }
        x.i("MicroMsg.WalletLockInitTask", "alvinluo after update gesture server info, isUserSetGesturePwd: %b", new Object[]{Boolean.valueOf(e.bRE())});
        g.Ei().DT().a(a.sYC, Boolean.valueOf(r0));
        ((com.tencent.mm.plugin.walletlock.a.b) g.l(com.tencent.mm.plugin.walletlock.a.b.class)).init();
        return false;
    }
}
