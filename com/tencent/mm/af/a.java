package com.tencent.mm.af;

import android.os.Process;
import com.tencent.mm.af.c.b;
import com.tencent.mm.af.c.c;
import com.tencent.mm.af.c.d;
import com.tencent.mm.model.bx;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class a {
    private static boolean ahg = false;
    private static final c dQT = new c();
    private static boolean dQU = true;
    private static long dQV = 0;
    private static long dQW = 0;
    private static Thread thread = null;

    public static final void bI(boolean z) {
        boolean z2 = !ad.getContext().getSharedPreferences("system_config_prefs", 4).getBoolean("msg_delay_close_detect", false);
        dQU = z2;
        if (z2) {
            ahg = z;
            if (z) {
                x.i("MicroMsg.ActiveDetector", "[oneliang]active, time%s, pid:%s", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())});
                if (thread != null) {
                    thread.interrupt();
                }
                thread = null;
                dQT.clear();
                dQV = bx.IR();
                return;
            }
            x.i("MicroMsg.ActiveDetector", "[oneliang]unactive, time%s, pid:%s", new Object[]{Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())});
            if (thread == null) {
                Thread b = e.b(dQT, "ProcessDetector_" + Process.myPid());
                thread = b;
                b.start();
                dQT.dRn = true;
            }
            dQW = bx.IR();
        }
    }

    public static boolean bm(long j) {
        if (dQV <= 0 || dQW <= 0 || j <= 0) {
            return false;
        }
        if (dQV >= dQW) {
            if (j < dQV) {
                return false;
            }
            return true;
        } else if (j >= dQW) {
            return false;
        } else {
            return true;
        }
    }

    public static void hD(int i) {
        if (dQU && !ahg) {
            c cVar = dQT;
            cVar.dRh.dRp.add(new com.tencent.mm.af.c.a(bx.IR(), System.currentTimeMillis(), i));
        }
    }

    public static void hE(int i) {
        if (dQU && !ahg) {
            c cVar = dQT;
            cVar.dRh.dRq.add(new com.tencent.mm.af.c.a(bx.IR(), System.currentTimeMillis(), i));
        }
    }

    public static void a(long j, long j2, long j3, long j4, long j5) {
        if (dQU) {
            c cVar = dQT;
            x.i("MicroMsg.ActiveDetector.ProcessDetector", "[oneliang]delayed msg[%s]", new Object[]{new c(Process.myPid(), j, j2, j3, j4, j5).toString()});
            cVar.dRh.dRr.add(r0);
        }
    }

    public static void hF(int i) {
        dQT.dRf = i;
    }

    public static List<a> Oa() {
        if (!ad.cic()) {
            return null;
        }
        b bVar;
        b bVar2;
        a a;
        String str = dQT.dRl;
        String str2 = str + "/mm";
        String str3 = str + "/push";
        try {
            bVar = (b) b.l(new FileInputStream(str2));
        } catch (Exception e) {
            x.e("MicroMsg.ActiveDetector", "%s,read exception:" + e.getMessage(), new Object[]{str2});
            bVar = null;
        }
        try {
            bVar2 = (b) b.l(new FileInputStream(str3));
        } catch (Exception e2) {
            x.e("MicroMsg.ActiveDetector", "%s,read exception:" + e2.getMessage(), new Object[]{str3});
            bVar2 = null;
        }
        List<a> arrayList = new ArrayList();
        if (bVar != null) {
            for (d a2 : bVar.dRo) {
                a = a(a2, 0);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (com.tencent.mm.af.c.a a3 : bVar.dRq) {
                a = a(a3, 3);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (c cVar : bVar.dRr) {
                Object obj;
                if (cVar == null) {
                    obj = null;
                } else {
                    a aVar = new a();
                    aVar.pid = cVar.pid;
                    aVar.dQX = cVar.dQX;
                    aVar.startTime = cVar.dRs;
                    aVar.endTime = cVar.dRs;
                    aVar.type = 4;
                    aVar.dRc = cVar.dRc;
                    aVar.dRd = cVar.dRd;
                    aVar.dRe = cVar.dRe;
                    a = aVar;
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        }
        if (bVar2 != null) {
            for (d a22 : bVar2.dRo) {
                a = a(a22, 1);
                if (a != null) {
                    arrayList.add(a);
                }
            }
            for (com.tencent.mm.af.c.a a32 : bVar2.dRp) {
                a = a(a32, 2);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    static String bn(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(j));
    }

    private static a a(d dVar, int i) {
        if (dVar == null) {
            return null;
        }
        a aVar = new a();
        aVar.dQX = dVar.dRt;
        aVar.startTime = dVar.startTime;
        aVar.endTime = dVar.endTime;
        aVar.type = i;
        aVar.pid = dVar.pid;
        aVar.dQZ = dVar.dQZ;
        if (i != 1) {
            return aVar;
        }
        aVar.dQY = dVar.dQY;
        aVar.dRa = dVar.dRa;
        return aVar;
    }

    private static a a(com.tencent.mm.af.c.a aVar, int i) {
        if (aVar == null) {
            return null;
        }
        a aVar2 = new a();
        aVar2.dQX = aVar.dQX;
        aVar2.startTime = aVar.time;
        aVar2.endTime = aVar.time;
        aVar2.type = i;
        aVar2.dRb = aVar.type;
        return aVar2;
    }
}
