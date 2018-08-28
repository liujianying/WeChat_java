package com.tencent.mm.plugin.sport;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.b.b;
import com.tencent.mm.plugin.sport.b.e;
import com.tencent.mm.plugin.sport.c.a;
import com.tencent.mm.plugin.sport.c.d;
import com.tencent.mm.plugin.sport.c.f;
import com.tencent.mm.plugin.sport.c.i;
import com.tencent.mm.plugin.sport.c.l;
import com.tencent.mm.plugin.sport.c.m;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Date;
import java.util.List;

public final class c implements b {
    public final void bFu() {
        a deviceStepManager = ((PluginSport) g.n(PluginSport.class)).getDeviceStepManager();
        x.i("MicroMsg.Sport.DeviceStepManager", "uploadDeviceStep");
        deviceStepManager.bFE();
        deviceStepManager.fs(deviceStepManager.bFD());
    }

    public final void a(String str, String str2, int i, int i2, int i3, String str3) {
        g.DF().a(new f(str, str2, i, i2, i3, str3, 1), 0);
    }

    public final boolean ei(Context context) {
        return n.ei(context);
    }

    public final boolean bFv() {
        return n.bFv();
    }

    public final void J(int i, long j) {
        i.N(i, j);
    }

    public final void bFw() {
        if (ad.cic()) {
            ((PluginSport) g.n(PluginSport.class)).getSportFileStorage().reset();
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.n(PluginSport.class)).getDeviceStepManager().ooN;
            if (aVar != null) {
                try {
                    aVar.bFB();
                } catch (RemoteException e) {
                }
            }
            new File(com.tencent.mm.plugin.sport.b.a.ooH).delete();
        }
    }

    public final void d(Activity activity, String str) {
        ah.A(new 1(this, activity, str));
    }

    public final void bFx() {
        if (n.opq != null) {
            n.opq.dismiss();
            n.opq = null;
        }
    }

    public final List<e> B(long j, long j2) {
        l sportStepManager = ((PluginSport) g.n(PluginSport.class)).getSportStepManager();
        x.i("MicroMsg.Sport.SportStepManager", "getSportItemListByPeriod: begin=%s end=%s", new Object[]{sportStepManager.opl.format(new Date(j)), sportStepManager.opl.format(new Date(j2))});
        ((PluginSport) g.n(PluginSport.class)).getSportStepStorage();
        return m.C(j, j2);
    }

    public final e bFy() {
        ((PluginSport) g.n(PluginSport.class)).getSportStepManager();
        ((PluginSport) g.n(PluginSport.class)).getSportStepStorage();
        return m.bFy();
    }

    public final void a(long j, long j2, com.tencent.mm.plugin.sport.b.c cVar) {
        x.i("MicroMsg.Sport.SportStepManager", "updateSportStepFromServer: begin=%s end=%s", new Object[]{r0.opl.format(new Date(j)), ((PluginSport) g.n(PluginSport.class)).getSportStepManager().opl.format(new Date(j2))});
        d dVar = new d(j, j2, cVar);
        g.DF().a(1734, r0.dKj);
        g.DF().a(dVar, 0);
    }
}
