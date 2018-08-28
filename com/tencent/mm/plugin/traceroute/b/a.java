package com.tencent.mm.plugin.traceroute.b;

import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    public static String oDd;
    public static c oDe;
    private final String TAG = "MicroMsg.MMTraceRoute";
    private final int oDf = 64;
    private boolean oDg = false;
    f oDh = new f(this, (byte) 0);
    public Map<String, Set<Integer>> oDi = new HashMap();
    public e oDj;
    public d oDk;
    public c oDl;
    public b oDm;
    String userName;

    public interface b {
        void bIN();
    }

    static /* synthetic */ void a(a aVar) {
        if (aVar.oDm != null) {
            aVar.oDm.bIN();
        }
    }

    final synchronized boolean bIL() {
        return this.oDg;
    }

    final synchronized void iF(boolean z) {
        this.oDg = z;
    }

    public a(String str) {
        this.userName = str;
        oDd = h.getExternalStorageDirectory().getAbsolutePath() + "/tencent/traceroute_log_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString() + ".log";
    }

    public final void stop() {
        iF(true);
        if (oDe != null) {
            try {
                oDe.shutdownNow();
            } catch (Exception e) {
                x.e("MicroMsg.MMTraceRoute", "failed to shutdown threadpool: " + e.getMessage());
            }
        }
    }

    public final void b(String[] strArr, boolean z) {
        if (strArr == null || strArr.length == 0) {
            x.e("MicroMsg.MMTraceRoute", "no ip contains");
            return;
        }
        String str = "";
        if (z) {
            str = str + "long: ";
        } else {
            str = str + "short: ";
        }
        int length = strArr.length;
        int i = 0;
        String str2 = str;
        while (i < length) {
            str = strArr[i];
            String[] split = str.split(":");
            if (split == null || split.length != 3) {
                x.e("MicroMsg.MMTraceRoute", "err ip " + str);
                str = str2;
            } else if (this.oDi.containsKey(split[0])) {
                ((Set) this.oDi.get(split[0])).add(Integer.valueOf(bi.getInt(split[1], 0)));
                str = str2;
            } else {
                Set hashSet = new HashSet();
                hashSet.add(Integer.valueOf(bi.getInt(split[1], 0)));
                this.oDi.put(split[0], hashSet);
                str = str2 + split[0] + " ";
            }
            i++;
            str2 = str;
        }
        e.e(oDd, (str2 + "\n").getBytes());
    }

    final synchronized void a(String str, String str2, Integer num) {
        if (!(str == null || str2 == null)) {
            if (num.intValue() >= 0) {
                if (!this.oDh.containsKey(str)) {
                    Map concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap.put(num, new StringBuilder(str2));
                    this.oDh.put(str, (ConcurrentHashMap) concurrentHashMap);
                } else if (((ConcurrentHashMap) this.oDh.get(str)).containsKey(num)) {
                    ((StringBuilder) ((ConcurrentHashMap) this.oDh.get(str)).get(num)).append(str2);
                } else {
                    new ConcurrentHashMap().put(num, new StringBuilder(str2));
                    ((ConcurrentHashMap) this.oDh.get(str)).put(num, new StringBuilder(str2));
                }
            }
        }
    }

    public final synchronized void bIM() {
        if (this.oDh != null) {
            String str;
            f fVar = this.oDh;
            File file = new File(oDd);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    e.e(oDd, (fVar.oDo.userName + "\n").getBytes());
                } catch (Throwable e) {
                    x.e("MicroMsg.MMTraceRoute", "create log file err " + e.getMessage());
                    x.printErrStackTrace("MicroMsg.MMTraceRoute", e, "", new Object[0]);
                    a(fVar.oDo);
                }
            }
            for (Entry key : fVar.oDo.oDh.entrySet()) {
                String str2 = (String) key.getKey();
                if (!bi.oW(str2) && fVar.oDo.oDh.containsKey(str2)) {
                    Map map = (Map) fVar.oDo.oDh.get(str2);
                    if (map != null) {
                        String str3 = "";
                        if (map.size() != 1 || map.get(Integer.valueOf(1)) == null) {
                            int i = 0;
                            Object obj = null;
                            while (i < map.size() && obj == null) {
                                if (map.get(Integer.valueOf(i)) != null) {
                                    String stringBuilder = ((StringBuilder) map.get(Integer.valueOf(i))).toString();
                                    if (!bi.oW(stringBuilder)) {
                                        str = str3 + stringBuilder;
                                        if (stringBuilder.contains("FIN")) {
                                            obj = 1;
                                        }
                                        i++;
                                        str3 = str;
                                    }
                                }
                                str = str3;
                                i++;
                                str3 = str;
                            }
                        } else {
                            str3 = str3 + ((StringBuilder) map.get(Integer.valueOf(1))).toString();
                        }
                        if (str3.length() > 0) {
                            x.i("MicroMsg.MMTraceRoute", str2 + str3);
                            e.e(oDd, str3.getBytes());
                        }
                    } else {
                        continue;
                    }
                }
            }
            byte[] e2 = e.e(oDd, 0, -1);
            if (bi.bC(e2)) {
                x.e("MicroMsg.MMTraceRoute", "read log failed");
                a(fVar.oDo);
            } else {
                str = g.u(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.qVN), Integer.valueOf(e2.length)}).getBytes()).toLowerCase();
                e2 = q.r(e2);
                PByteArray pByteArray = new PByteArray();
                c.a(pByteArray, e2, str.getBytes());
                com.tencent.mm.sdk.f.e.post(new 1(fVar, r1, str, pByteArray), "MMTraceRoute_uploadLog");
            }
        }
        return;
    }
}
