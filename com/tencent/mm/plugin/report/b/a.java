package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.e;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.protocal.c.avj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.util.Iterator;

public final class a {
    private static String filename = "heavy_user_id_mapping.dat";
    private static Object lock = new Object();
    private a mDG;
    private int mDH;
    private int mDI;
    private int mDJ;
    private int mDK;

    public interface a {
    }

    public a() {
        this.mDG = null;
        this.mDH = 0;
        this.mDI = 1;
        this.mDJ = 2;
        this.mDK = 3;
        this.mDG = null;
    }

    private static void a(amj amj, boolean z) {
        Iterator it;
        avj avj;
        if (z) {
            x.i("MicroMsg.HeavyUserIDMappingStg", "################################# svr heavy user strategy #############################");
            x.i("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + amj.rOY + ", ret:" + amj.rPa);
            it = amj.rOZ.iterator();
            while (it.hasNext()) {
                avj = (avj) it.next();
                x.i("MicroMsg.HeavyUserIDMappingStg", "origin:" + avj.rYf + ", userid:" + avj.rYg);
            }
            x.i("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
            return;
        }
        x.d("MicroMsg.HeavyUserIDMappingStg", "################################# Local heavy user strategy #############################");
        x.d("MicroMsg.HeavyUserIDMappingStg", "svr_version:" + amj.rOY + ", ret:" + amj.rPa);
        it = amj.rOZ.iterator();
        while (it.hasNext()) {
            avj = (avj) it.next();
            x.d("MicroMsg.HeavyUserIDMappingStg", "origin:" + avj.rYf + ", userid:" + avj.rYg);
        }
        x.d("MicroMsg.HeavyUserIDMappingStg", "#################################  End ################################################");
    }

    public final void a(amj amj, int i) {
        x.i("MicroMsg.HeavyUserIDMappingStg", "saveIDMapping, channel:" + i);
        int i2;
        if (amj == null) {
            x.w("MicroMsg.HeavyUserIDMappingStg", "HeavyUserRespInfo is null");
        } else if (this.mDH != amj.rPa) {
            String str = "MicroMsg.HeavyUserIDMappingStg";
            StringBuilder stringBuilder = new StringBuilder("heavyUserRespInfo.RespType Unnormal, type:");
            i2 = amj.rPa;
            String str2 = this.mDI == i2 ? "服务器过载" : this.mDJ == i2 ? "服务器没有配置表" : this.mDK == i2 ? "服务器配置表错误" : "非法的错误类型";
            x.e(str, stringBuilder.append(str2).append(",version:").append(amj.rOY).toString());
        } else {
            i2 = vs(i);
            int i3 = amj.rOY;
            if (i2 == i3) {
                x.d("MicroMsg.HeavyUserIDMappingStg", "client has same version with Srv, version:" + i3);
                return;
            }
            x.i("MicroMsg.HeavyUserIDMappingStg", "version changed, client:" + vs(i) + ", svr:" + i3);
            a(amj, true);
            try {
                byte[] toByteArray = amj.toByteArray();
                synchronized (lock) {
                    x.i("MicroMsg.HeavyUserIDMappingStg", "new version:" + amj.rOY);
                    e.b(aa.duN, filename, toByteArray);
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            }
        }
    }

    public static amj brI() {
        byte[] f;
        x.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingObj");
        synchronized (lock) {
            f = e.f(aa.duN + filename, 0, -1);
        }
        if (f == null) {
            x.w("MicroMsg.HeavyUserIDMappingStg", "get file content fail, filename" + filename);
            return null;
        }
        amj amj = new amj();
        try {
            amj.aG(f);
            a(amj, false);
            return amj;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.HeavyUserIDMappingStg", e, "", new Object[0]);
            return null;
        }
    }

    public static int vs(int i) {
        x.d("MicroMsg.HeavyUserIDMappingStg", "getIDMappingVersion,chanel:" + i);
        amj brI = brI();
        if (brI == null) {
            return 0;
        }
        int i2 = brI.rOY;
        x.i("MicroMsg.HeavyUserIDMappingStg", "version:" + i2);
        return i2;
    }
}
