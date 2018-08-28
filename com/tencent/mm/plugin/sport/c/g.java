package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.a.a;
import com.tencent.mm.protocal.c.cdn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public final class g {
    private static e dKj = new e() {
        public final void a(int i, int i2, String str, l lVar) {
            if (lVar instanceof e) {
                com.tencent.mm.kernel.g.DF().b(1947, g.dKj);
                if (i == 0 && i2 == 0) {
                    cdn cdn = ((e) lVar).ooX;
                    x.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[]{cdn.rcW});
                    String str2 = cdn.rcW;
                    if (ad.cic()) {
                        ((PluginSport) com.tencent.mm.kernel.g.n(PluginSport.class)).getSportFileStorage().Og(str2);
                        g.Of(cdn.rcW);
                        a aVar = ((PluginSport) com.tencent.mm.kernel.g.n(PluginSport.class)).getDeviceStepManager().ooN;
                        if (aVar != null) {
                            try {
                                aVar.Oe(cdn.rcW);
                            } catch (RemoteException e) {
                            }
                        }
                        if (g.opb != null) {
                            g.opb.bFt();
                            return;
                        }
                        return;
                    }
                    throw new RuntimeException(String.format("not support set value in %s process", new Object[]{ad.getProcessName()}));
                }
            }
        }
    };
    private static long ooZ;
    private static JSONObject opa;
    private static a opb;

    public static boolean bFI() {
        if (ooZ == 0) {
            ooZ = i.L(1, 0);
        }
        if (System.currentTimeMillis() - ooZ > 86400000) {
            ooZ = System.currentTimeMillis();
            i.M(1, ooZ);
            x.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
            com.tencent.mm.kernel.g.DF().a(1947, dKj);
            com.tencent.mm.kernel.g.DF().a(new e(), 0);
            return true;
        }
        x.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[]{n.bx(ooZ)});
        return false;
    }

    public static void Of(String str) {
        if (!bi.oW(str)) {
            try {
                opa = new JSONObject(str);
            } catch (Exception e) {
                opa = null;
            }
        }
    }

    public static JSONObject bFJ() {
        if (opa == null) {
            String str = "";
            String Oh = ad.cic() ? ((PluginSport) com.tencent.mm.kernel.g.n(PluginSport.class)).getSportFileStorage().Oh(str) : new h(com.tencent.mm.plugin.sport.b.a.ooI).Oh(str);
            str = "";
            if (!bi.oW(Oh)) {
                try {
                    opa = new JSONObject(Oh);
                    Oh = "server config";
                } catch (Exception e) {
                }
                if (opa == null) {
                    opa = bFK();
                    Oh = "asset";
                }
                if (opa == null) {
                    opa = new JSONObject();
                    Oh = "new";
                }
                x.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[]{Oh, opa.toString()});
            }
            Oh = str;
            if (opa == null) {
                opa = bFK();
                Oh = "asset";
            }
            if (opa == null) {
                opa = new JSONObject();
                Oh = "new";
            }
            x.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[]{Oh, opa.toString()});
        }
        return opa;
    }

    private static JSONObject bFK() {
        JSONObject jSONObject;
        InputStream inputStream = null;
        try {
            inputStream = ad.getContext().getAssets().open("sport_config.json");
            jSONObject = new JSONObject(new String(com.tencent.mm.a.e.g(inputStream)));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", e2, "get assets sport config json", new Object[0]);
            jSONObject = new JSONObject();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
        return jSONObject;
    }

    public static void a(a aVar) {
        opb = aVar;
    }
}
