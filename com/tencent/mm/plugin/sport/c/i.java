package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class i {
    public static h bFN() {
        if (ad.cic()) {
            return new h(a.ooI);
        }
        if (ad.cif()) {
            return new h(a.ooH);
        }
        return null;
    }

    public static long L(int i, long j) {
        if (ad.cic()) {
            return ((PluginSport) g.n(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }
        return new h(a.ooI).getLong(i, j);
    }

    public static void M(int i, long j) {
        if (ad.cic()) {
            ((PluginSport) g.n(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else {
            throw new RuntimeException(String.format("not support set value in %s process", new Object[]{ad.getProcessName()}));
        }
    }

    public static long xS(int i) {
        if (ad.cif()) {
            return ((PluginSport) g.n(PluginSport.class)).getSportFileStorage().getLong(i, 0);
        }
        if (ad.cic()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.n(PluginSport.class)).getDeviceStepManager().ooN;
            if (aVar != null) {
                try {
                    return aVar.getLong(i, 0);
                } catch (RemoteException e) {
                }
            }
        }
        return new h(a.ooH).getLong(i, 0);
    }

    public static void N(int i, long j) {
        if (ad.cif()) {
            ((PluginSport) g.n(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else if (ad.cic()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) g.n(PluginSport.class)).getDeviceStepManager().ooN;
            if (aVar != null) {
                try {
                    aVar.K(i, j);
                } catch (RemoteException e) {
                }
            }
        }
    }
}
