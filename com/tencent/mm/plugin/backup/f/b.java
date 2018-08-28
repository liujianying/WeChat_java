package com.tencent.mm.plugin.backup.f;

import android.os.Looper;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.backup.e.j;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import junit.framework.Assert;

public abstract class b extends l {
    private static final Map<Integer, Set<e>> diQ = new HashMap();
    static int gRy = -1;
    static final LinkedHashMap<Integer, b> gXA = new LinkedHashMap();
    private static d gXB;
    static a gXC;
    private static f gXD = null;
    private static i gXE = null;
    private static g gXF = null;
    private static int gXG = new Random(bi.VF()).nextInt(1147483648);
    private static c gXH = null;
    private static final ag handler = new ag(Looper.getMainLooper());
    PByteArray gXz = new PByteArray();

    public interface a {
        void j(int i, byte[] bArr);

        int k(int i, byte[] bArr);
    }

    public interface c {
        void arI();
    }

    public abstract com.tencent.mm.bk.a asj();

    public abstract com.tencent.mm.bk.a ask();

    public abstract int getType();

    public abstract void mI(int i);

    public static void a(d dVar) {
        gXB = dVar;
    }

    public static void a(a aVar) {
        gXC = aVar;
    }

    public static void mx(int i) {
        gRy = i;
    }

    public static int aqS() {
        return gRy;
    }

    public static void a(com.tencent.mm.plugin.backup.f.f.a aVar) {
        gXD = new f(aVar);
    }

    public static void asl() {
        boolean z = true;
        if (gXD != null) {
            boolean z2;
            f fVar = gXD;
            String str = "HeartBeatTimeoutCallback is null";
            if (fVar.gUp != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(str, z2);
            String str2 = "New BackupHeartBeatHandler EveryTime !";
            if (fVar.gYb != null) {
                z = false;
            }
            Assert.assertTrue(str2, z);
            x.i("MicroMsg.BackupHeartBeatHandler", "start backup heart beat handler.");
            fVar.asB();
            fVar.gYb = Boolean.valueOf(false);
            com.tencent.mm.sdk.f.e.b(new f$1(fVar), "BackupSendBackupHeartBeat").start();
            fVar.asC();
            return;
        }
        x.e("MicroMsg.BackupBaseScene", "startHeartBeatHandler backupHeartBeatHandler is null!");
    }

    public static void asm() {
        if (gXD != null) {
            f fVar = gXD;
            if (fVar.gYb != null) {
                fVar.gYb = Boolean.valueOf(true);
            }
        }
    }

    public static void a(com.tencent.mm.plugin.backup.f.i.a aVar) {
        gXE = new i(aVar);
    }

    public static void asn() {
        int i = 0;
        if (gXE != null) {
            i iVar = gXE;
            x.i("MicroMsg.BackupSpeedCalculator", "start backupGetSpeedTimeHandler.");
            iVar.gYo = bi.VF();
            iVar.gYn = 0;
            iVar.gYl = 0;
            iVar.gYr.clear();
            iVar.gYq = 0;
            iVar.gYp = 0;
            while (i < 10) {
                iVar.gYr.offer(Long.valueOf(0));
                i++;
            }
            iVar.gYs.J(1000, 1000);
            return;
        }
        x.e("MicroMsg.BackupBaseScene", "startSpeedCalculator backupSpeedCalculator is null!");
    }

    public static void aso() {
        if (gXE != null) {
            i iVar = gXE;
            x.i("MicroMsg.BackupSpeedCalculator", "stop backupGetSpeedTimeHandler.");
            iVar.gYs.SO();
            iVar.gYq = 0;
        }
    }

    public static String asp() {
        if (gXE == null) {
            return "0B";
        }
        x.i("MicroMsg.BackupSpeedCalculator", "getBackupPcSpeed[%s]", new Object[]{i.bW(gXE.gYm)});
        return i.bW(gXE.gYm);
    }

    public static void a(com.tencent.mm.plugin.backup.f.g.a aVar) {
        if (gXF == null) {
            x.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, no old backupReconnectHandler is stopped, new one.");
        } else if (gXF.gYf) {
            x.i("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, old backupReconnectHandler is stopped, new one.");
        } else {
            x.e("MicroMsg.BackupBaseScene", "startBackupReconnectHandler, backupReconnectHandler already running, ignore it.");
            return;
        }
        g gVar = new g(aVar);
        gXF = gVar;
        x.i("MicroMsg.BackupReconnectHandler", "start backupReconnectTimeHandler.");
        g.index = 0;
        gVar.gYf = false;
        gVar.gYe = 1;
        if (gVar.gYd != null) {
            gVar.gYg.J(0, 0);
        }
    }

    public static void asq() {
        if (gXF != null) {
            gXF.gYe = 0;
            g gVar = gXF;
            if (!gVar.gYf) {
                x.i("MicroMsg.BackupReconnectHandler", "stop backupReconnectTimeHandler.");
                gVar.gYg.SO();
                gVar.gYf = true;
            }
        }
    }

    public static int asr() {
        if (gXF == null) {
            return 0;
        }
        return gXF.gYe;
    }

    public static void mJ(int i) {
        if (gXF != null) {
            gXF.gYe = i;
        }
    }

    public static void clear() {
        x.i("MicroMsg.BackupBaseScene", "BackupBaseScene clear.");
        synchronized (gXA) {
            gXA.clear();
        }
        synchronized (diQ) {
            diQ.clear();
        }
    }

    public static void a(c cVar) {
        gXH = cVar;
    }

    public static void arI() {
        if (gXH != null) {
            gXH.arI();
        }
    }

    public boolean ass() {
        try {
            byte[] toByteArray = ask().toByteArray();
            synchronized (gXA) {
                int asu = asu();
                j.a(toByteArray, asu, (short) getType(), this.gXz, gRy);
                if (gXC != null) {
                    gXC.j(asu, this.gXz.value);
                }
                x.i("MicroMsg.BackupBaseScene", "doScene sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(asu), Integer.valueOf(getType()), Integer.valueOf(this.gXz.value.length)});
                gXA.put(Integer.valueOf(asu), this);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public final boolean ast() {
        try {
            byte[] toByteArray = ask().toByteArray();
            synchronized (gXA) {
                int asu = asu();
                j.a(toByteArray, asu, (short) getType(), this.gXz, gRy);
                if (gXC != null) {
                    gXC.k(asu, this.gXz.value);
                }
                x.i("MicroMsg.BackupBaseScene", "doSceneSameThread sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(asu), Integer.valueOf(getType()), Integer.valueOf(this.gXz.value.length)});
                gXA.put(Integer.valueOf(asu), this);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BackupBaseScene", e, "req to buf fail: " + e.toString(), new Object[0]);
            return false;
        }
    }

    public static boolean J(byte[] bArr, int i) {
        PByteArray pByteArray = new PByteArray();
        synchronized (gXA) {
            int asu = asu();
            j.a(bArr, asu, (short) i, pByteArray, gRy);
            if (gXC != null) {
                gXC.j(asu, pByteArray.value);
            }
            x.i("MicroMsg.BackupBaseScene", "sendBuf sendSeq[%d], type[%d], buflen[%d]", new Object[]{Integer.valueOf(asu), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length)});
        }
        return true;
    }

    public static boolean o(byte[] bArr, int i, int i2) {
        PByteArray pByteArray = new PByteArray();
        j.a(bArr, i2, (short) i, pByteArray, gRy);
        if (gXC != null) {
            gXC.j(i2, pByteArray.value);
        }
        x.i("MicroMsg.BackupBaseScene", "sendResp sendSeq[%d], type[%d], len[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(pByteArray.value.length)});
        return true;
    }

    public static void b(boolean z, int i, int i2, byte[] bArr) {
        String str = "MicroMsg.BackupBaseScene";
        String str2 = "callback receive isLocal[%b], receiveSeq[%d], type[%d], bufLen[%d]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str, str2, objArr);
        if (z) {
            try {
                x.w("MicroMsg.BackupBaseScene", "callback error buf content : " + (bArr == null ? "null" : new String(bArr)));
            } catch (Exception e) {
            }
            b(z, i2, bArr, i);
            return;
        }
        b bVar;
        if (gXD != null) {
            gXD.asB();
            x.d("MicroMsg.BackupBaseScene", "updateHeartBeatTimeStamp type:%d, current time stamp:%d", new Object[]{Integer.valueOf(i2), Long.valueOf(bi.VF())});
        }
        synchronized (gXA) {
            bVar = (b) gXA.remove(Integer.valueOf(i));
        }
        if (bVar == null) {
            x.i("MicroMsg.BackupBaseScene", "notify scene null type:%d", new Object[]{Integer.valueOf(i2)});
            if (bVar == null && i2 == 16) {
                synchronized (gXA) {
                    Iterator it = new HashSet(gXA.keySet()).iterator();
                    while (it.hasNext()) {
                        Integer num = (Integer) it.next();
                        bVar = (b) gXA.get(num);
                        String str3 = "MicroMsg.BackupBaseScene";
                        String str4 = "callback sceneMap seq:%d scene:%s type:%s";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = num;
                        objArr2[1] = bVar;
                        if (bVar == null) {
                            str = "null";
                        } else {
                            str = Integer.valueOf(bVar.getType());
                        }
                        objArr2[2] = str;
                        x.d(str3, str4, objArr2);
                        if (bVar != null && bVar.getType() == 15) {
                            gXA.remove(num);
                            try {
                                bVar.asj().aG(bArr);
                                bVar.mI(i);
                            } catch (Throwable e2) {
                                bVar.g(3, -1, "buf to tagResp fail");
                                x.printErrStackTrace("MicroMsg.BackupBaseScene", e2, "buf to tagResp error, type[%d], errMsg:%s ", new Object[]{Integer.valueOf(bVar.getType()), e2.toString()});
                            }
                        }
                    }
                }
                return;
            }
            x.i("MicroMsg.BackupBaseScene", "notify seq:%d, type:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            b(z, i2, bArr, i);
        } else if (bArr == null) {
            try {
                throw new Exception("buf is null");
            } catch (Throwable e3) {
                bVar.g(3, -1, "buf to resq fail");
                x.printErrStackTrace("MicroMsg.BackupBaseScene", e3, "%s ", new Object[]{e3.toString()});
            }
        } else {
            bVar.asj().aG(bArr);
            bVar.mI(i);
        }
    }

    public static int asu() {
        int i = gXG;
        gXG++;
        return i;
    }

    public static void mK(int i) {
        if (gXE != null) {
            i iVar = gXE;
            iVar.gYn = ((long) i) + iVar.gYn;
        }
    }

    private static void b(final boolean z, final int i, final byte[] bArr, final int i2) {
        handler.post(new Runnable() {
            public final void run() {
                if (b.gXB != null) {
                    b.gXB.a(z, i, bArr, i2);
                } else {
                    x.w("MicroMsg.BackupBaseScene", "callbackToNotify, onNotify is null");
                }
            }
        });
    }

    public final void g(int i, int i2, String str) {
        handler.post(new 2(this, i, i2, str));
    }

    public static void a(int i, e eVar) {
        synchronized (diQ) {
            if (!diQ.containsKey(Integer.valueOf(i))) {
                diQ.put(Integer.valueOf(i), new HashSet());
            }
            if (!((Set) diQ.get(Integer.valueOf(i))).contains(eVar)) {
                ((Set) diQ.get(Integer.valueOf(i))).add(eVar);
            }
        }
    }

    public static void b(int i, e eVar) {
        synchronized (diQ) {
            try {
                if (diQ.get(Integer.valueOf(i)) != null) {
                    ((Set) diQ.get(Integer.valueOf(i))).remove(eVar);
                }
            } catch (Exception e) {
                x.e("MicroMsg.BackupBaseScene", "removeSceneEndListener failed:%s", new Object[]{e});
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        return 0;
    }

    public static void a(b bVar) {
        handler.postAtFrontOfQueueV2(new 3(bVar));
    }
}
