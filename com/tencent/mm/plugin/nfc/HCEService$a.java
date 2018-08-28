package com.tencent.mm.plugin.nfc;

import android.os.Bundle;
import android.util.Base64;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.nfc.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class HCEService$a implements a {
    final /* synthetic */ HCEService lES;

    private HCEService$a(HCEService hCEService) {
        this.lES = hCEService;
    }

    /* synthetic */ HCEService$a(HCEService hCEService, byte b) {
        this(hCEService);
    }

    public final void dX(String str, String str2) {
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND send to AppBrand, appId: %s, command: %s", new Object[]{str, str2});
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.HCEService", "alvinluo HCECOMMAND invalid appId or command when send request command to AppBrand");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_apdu_command", str2);
        HCEService.f(str, bundle);
        HCEService.d(this.lES);
        if (!HCEService.e(this.lES)) {
            HCEService.f(this.lES);
            HCEService.a(this.lES, false);
            HCEService.ef(System.currentTimeMillis());
            g.Em().h(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.HCEService", "alvinluo HCEService timer check, timeLimit: %d, hasCommandNotResponded: %b", new Object[]{Integer.valueOf(HCEService.g(HCEService$a.this.lES)), Boolean.valueOf(HCEService.h(HCEService$a.this.lES))});
                    HCEService.a(HCEService$a.this.lES, true);
                    HCEService.a(HCEService$a.this.lES, HCEService.bjn(), true);
                }
            }, (long) HCEService.g(this.lES));
        } else if (HCEService.i(this.lES)) {
            x.w("MicroMsg.HCEService", "alvinluo HCECOMMAND TimeExceeded, just return default command");
            HCEService.a(this.lES, HCEService.bjn(), true);
            HCEService.a(this.lES, false);
        }
    }

    public final void dY(String str, String str2) {
        if (HCEService.j(this.lES) == null || !HCEService.j(this.lES).equals(str) || bi.oW(str2)) {
            x.e("MicroMsg.HCEService", "alvinluo HCECOMMAND not the same appId, or invalid response command, mAppId: %s, appId: %s, responseCommand: %s", new Object[]{HCEService.j(this.lES), str, str2});
            return;
        }
        x.i("MicroMsg.HCEService", "alvinluo HCECOMMAND response from AppBrand, appId: %s, command in base64: %s, send to system: %s, hasCommandNotResponded: %b", new Object[]{str, str2, b.aE(Base64.decode(str2, 2)), Boolean.valueOf(HCEService.h(this.lES))});
        HCEService.a(this.lES, r0, false);
    }
}
