package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.a.q;
import com.tencent.mm.bk.a;
import com.tencent.mm.bk.b;
import com.tencent.mm.plugin.appbrand.debugger.q.8;
import com.tencent.mm.protocal.c.caz;
import com.tencent.mm.protocal.c.cbd;
import com.tencent.mm.protocal.c.cbe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.v.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class p {
    private static String deviceID = null;
    public static h ftI = null;

    public static i sr(String str) {
        x.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", new Object[]{str});
        i iVar = new i();
        if (!bi.oW(str)) {
            try {
                JSONObject fU = g.fU(str);
                iVar.fsU = fU.optBoolean("open_remote", false);
                iVar.fsV = fU.optString("room_id");
                iVar.fsW = fU.optString("wxpkg_info");
                iVar.fsX = fU.optString("qrcode_id");
                iVar.fsY = fU.optInt("remote_network_type", 1);
                iVar.fqO = fU.optBoolean("disable_url_check", true);
                iVar.fsZ = fU.optInt("remote_proxy_port", 9976);
                iVar.fta = fU.optInt("remote_support_compress_algo");
            } catch (Exception e) {
                x.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", new Object[]{e});
            }
        }
        return iVar;
    }

    public static ByteBuffer c(a aVar) {
        try {
            return ByteBuffer.wrap(aVar.toByteArray());
        } catch (IOException e) {
            x.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            return ByteBuffer.allocate(0);
        }
    }

    private static b d(a aVar) {
        try {
            return b.bi(aVar.toByteArray());
        } catch (IOException e) {
            x.w("MicroMsg.RemoteDebugUtil", e.getMessage());
            return b.bi(new byte[0]);
        }
    }

    public static k a(a aVar, h hVar, String str) {
        cbe cbe = new cbe();
        try {
            byte[] toByteArray = aVar.toByteArray();
            k kVar;
            if (toByteArray.length <= GLIcon.TOP || !jZ(hVar.fsC.fta)) {
                cbe.rwb = b.bi(toByteArray);
                cbe.egS = hVar.fsD.incrementAndGet();
                if (hVar.fsF != 0) {
                    cbe.sxo = 0;
                } else {
                    cbe.sxo = (int) (System.currentTimeMillis() - hVar.fsF);
                }
                hVar.fsF = System.currentTimeMillis();
                cbe.category = str;
                x.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[]{Integer.valueOf(cbe.egS)});
                kVar = new k();
                kVar.fsv = System.currentTimeMillis();
                kVar.ftl = cbe.rwb.lR.length;
                kVar.ftk = cbe;
                return kVar;
            }
            cbe.rwb = b.bi(q.r(toByteArray));
            cbe.sjO = 1;
            x.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", new Object[]{Integer.valueOf(toByteArray.length), Integer.valueOf(r2.length)});
            cbe.egS = hVar.fsD.incrementAndGet();
            if (hVar.fsF != 0) {
                cbe.sxo = (int) (System.currentTimeMillis() - hVar.fsF);
            } else {
                cbe.sxo = 0;
            }
            hVar.fsF = System.currentTimeMillis();
            cbe.category = str;
            x.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", new Object[]{Integer.valueOf(cbe.egS)});
            kVar = new k();
            kVar.fsv = System.currentTimeMillis();
            kVar.ftl = cbe.rwb.lR.length;
            kVar.ftk = cbe;
            return kVar;
        } catch (IOException e) {
            x.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", new Object[]{e});
        }
    }

    public static cbd a(int i, a aVar) {
        cbd cbd = new cbd();
        cbd.nc = i;
        if (bi.oW(deviceID)) {
            deviceID = com.tencent.mm.compatible.e.q.getDeviceID(ad.getContext());
        }
        cbd.fMk = deviceID + "-" + System.currentTimeMillis();
        cbd.rwb = d(aVar);
        return cbd;
    }

    public static boolean a(h hVar, cbd cbd, caz caz, q qVar, l lVar) {
        if (cbd == null) {
            x.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
            return false;
        }
        int i = cbd.nc;
        if (caz == null) {
            x.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", new Object[]{Integer.valueOf(i)});
            return false;
        }
        if (i == 1006) {
            if (-50011 == caz.bMH) {
                hVar.cz(true);
            } else {
                boolean isBusy = hVar.isBusy();
                hVar.cz(false);
                if (isBusy) {
                    lVar.aeC();
                }
            }
        }
        if (caz.bMH == 0) {
            return true;
        }
        x.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), cbd.fMk, Integer.valueOf(caz.bMH), caz.bMI});
        ah.A(new 8(qVar, i, caz));
        return false;
    }

    public static boolean jZ(int i) {
        return (i & 1) != 0;
    }
}
