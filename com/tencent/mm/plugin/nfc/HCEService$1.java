package com.tencent.mm.plugin.nfc;

import android.support.design.a$i;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class HCEService$1 extends c<ib> {
    final /* synthetic */ HCEService lES;

    HCEService$1(HCEService hCEService) {
        this.lES = hCEService;
        this.sFo = ib.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ib ibVar = (ib) bVar;
        x.i("MicroMsg.HCEService", "alvinluo HCELifeCycle listener callback, type: %d", new Object[]{Integer.valueOf(ibVar.bRC.type)});
        switch (ibVar.bRC.type) {
            case 13:
                HCEService.c(this.lES);
                this.lES.stopSelf();
                break;
            case 21:
                if (HCEService.b(this.lES) != null) {
                    HCEService.b(this.lES).onCreate();
                    break;
                }
                break;
            case 22:
                if (HCEService.b(this.lES) != null) {
                    HCEService.b(this.lES).onResume();
                    break;
                }
                break;
            case 23:
                if (HCEService.b(this.lES) != null) {
                    HCEService.b(this.lES).onPause();
                    break;
                }
                break;
            case 24:
                if (HCEService.b(this.lES) != null) {
                    HCEService.b(this.lES).onDestroy();
                    break;
                }
                break;
            case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
                if (HCEService.a(this.lES) != null) {
                    HCEService.a(this.lES).dY(ibVar.bRC.appId, ibVar.bRC.extras.getString("key_apdu_command"));
                    break;
                }
                break;
        }
        return false;
    }
}
