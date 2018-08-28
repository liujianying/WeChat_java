package com.tencent.mm.wallet_core.ui;

import com.tencent.mm.model.bg.a;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e.b;

class e$3 implements a {
    final /* synthetic */ String dhm;
    final /* synthetic */ b uYZ;

    e$3(String str, b bVar) {
        this.dhm = str;
        this.uYZ = bVar;
    }

    public final void a(e eVar) {
        if (eVar != null && eVar.Lr() != null) {
            if (bi.oW(this.dhm)) {
                x.w("MicroMsg.WalletBaseUtil ", "hy: key is null");
                return;
            }
            try {
                byte[] kf = eVar.Lr().kf(this.dhm);
                if (this.uYZ == null) {
                    return;
                }
                if (kf != null) {
                    this.uYZ.bU(e.bH(kf));
                } else {
                    this.uYZ.bU(null);
                }
            } catch (Exception e) {
                x.e("MicroMsg.WalletBaseUtil ", "hy: deserialize failed: %s", new Object[]{e.toString()});
                if (this.uYZ != null) {
                    this.uYZ.bU(null);
                }
            }
        }
    }
}
