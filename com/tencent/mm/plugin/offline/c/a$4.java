package com.tencent.mm.plugin.offline.c;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.x;

class a$4 implements a {
    a$4() {
    }

    public final void a(e eVar) {
        if (eVar == null || eVar.Lr() == null) {
            x.e("MicroMsg.WalletOfflineUtil", "doLocalProxyScene dispatcher == null || dispatcher.getAccInfo() == null");
            return;
        }
        byte[] kf = eVar.Lr().kf("offline_token");
        if (kf != null) {
            a.Jm(new String(kf));
        }
        kf = eVar.Lr().kf("offline_token_V2");
        if (kf != null) {
            a.lMH = new String(kf);
        }
        kf = eVar.Lr().kf("offline_key_list");
        if (kf != null) {
            a.lMK = new String(kf);
        }
    }
}
