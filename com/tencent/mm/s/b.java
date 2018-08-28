package com.tencent.mm.s;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

public final class b {
    SparseArray<a> dlB = new SparseArray();
    HashMap<com.tencent.mm.storage.aa.a, a> dlC = new HashMap();
    SparseArray<b> dlD = new SparseArray();
    HashMap<com.tencent.mm.storage.aa.a, b> dlE = new HashMap();
    private Random dlF = new Random();
    x dlG = null;

    public class a {
        String bLe;
        int dlx;
        com.tencent.mm.storage.aa.a dly;
        int type;
        public String value;
    }

    public class b {
        com.tencent.mm.storage.aa.a dlA;
        int dlI;
        SparseArray<String> dlJ = new SparseArray();
        HashMap<String, String> dlK = new HashMap();
    }

    private static String fz(String str) {
        return str.replaceAll("\\|", "%7C");
    }

    private static String unescape(String str) {
        return str.replaceAll("%7C", "|");
    }

    final void a(a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(aVar.type);
        stringBuffer.append("|");
        stringBuffer.append(fz(aVar.value));
        stringBuffer.append("|");
        stringBuffer.append(fz(aVar.bLe));
        if (aVar.dly != null) {
            this.dlG.a(aVar.dly, stringBuffer.toString());
        } else {
            this.dlG.set(aVar.dlx, stringBuffer.toString());
        }
    }

    final void a(b bVar) {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int i2;
        String str;
        if (bVar.dlA != null) {
            Iterator it = bVar.dlK.entrySet().iterator();
            while (true) {
                i2 = i;
                if (it.hasNext()) {
                    Entry entry = (Entry) it.next();
                    String str2 = (String) entry.getKey();
                    str = (String) entry.getValue();
                    if (i2 != 0) {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(str2);
                    stringBuffer.append("|");
                    stringBuffer.append(fz(str));
                    i = i2 + 1;
                } else {
                    this.dlG.a(bVar.dlA, stringBuffer.toString());
                    return;
                }
            }
        }
        while (true) {
            int i3 = i;
            if (i3 < bVar.dlJ.size()) {
                i2 = bVar.dlJ.keyAt(i3);
                str = (String) bVar.dlJ.get(i2);
                if (i3 != 0) {
                    stringBuffer.append("|");
                }
                stringBuffer.append(i2);
                stringBuffer.append("|");
                stringBuffer.append(fz(str));
                i = i3 + 1;
            } else {
                this.dlG.set(bVar.dlI, stringBuffer.toString());
                return;
            }
        }
    }

    private a gn(int i) {
        String str = (String) this.dlG.get(i, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[]{str});
            return null;
        }
        try {
            return a(i, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[]{bi.i(e)});
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[]{str});
            return null;
        }
    }

    private a c(com.tencent.mm.storage.aa.a aVar) {
        String str = (String) this.dlG.get(aVar, null);
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        if (split.length != 3) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadDataSource array.length != 3 content %s", new Object[]{str});
            return null;
        }
        try {
            return a(aVar, Integer.valueOf(split[0]).intValue(), unescape(split[1]), unescape(split[2]));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[]{bi.i(e)});
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadDataSource exception content %s", new Object[]{str});
            return null;
        }
    }

    private b go(int i) {
        String str = (String) this.dlG.get(i, null);
        if (str == null) {
            return gp(i);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[]{str});
            return null;
        }
        try {
            b gp = gp(i);
            for (int i2 = 0; i2 < split.length; i2 += 2) {
                gp.dlJ.put(Integer.valueOf(split[i2]).intValue(), unescape(split[i2 + 1]));
            }
            return gp;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[]{bi.i(e)});
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[]{str});
            return null;
        }
    }

    private b d(com.tencent.mm.storage.aa.a aVar) {
        String str = (String) this.dlG.get(aVar, null);
        if (str == null) {
            return e(aVar);
        }
        String[] split = str.split("\\|");
        if (split.length % 2 != 0) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadWatcher array.length %% 2 != 0 content %s", new Object[]{str});
            return null;
        }
        try {
            b e = e(aVar);
            for (int i = 0; i < split.length; i += 2) {
                e.dlK.put(split[i], unescape(split[i + 1]));
            }
            return e;
        } catch (Throwable e2) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "exception:%s", new Object[]{bi.i(e2)});
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "loadWatcher exception content %s", new Object[]{str});
            return null;
        }
    }

    final String Co() {
        long currentTimeMillis = System.currentTimeMillis();
        int nextInt = this.dlF.nextInt(Math.abs(this.dlF.nextInt(Integer.MAX_VALUE))) % 10000;
        return String.format("%d%04d", new Object[]{Long.valueOf(currentTimeMillis), Integer.valueOf(nextInt)});
    }

    final b gp(int i) {
        b bVar = new b();
        bVar.dlI = i;
        return bVar;
    }

    final b e(com.tencent.mm.storage.aa.a aVar) {
        b bVar = new b();
        bVar.dlA = aVar;
        return bVar;
    }

    final a a(int i, int i2, String str, String str2) {
        a aVar = new a();
        aVar.dlx = i;
        aVar.type = i2;
        aVar.value = str;
        aVar.bLe = str2;
        return aVar;
    }

    final a a(com.tencent.mm.storage.aa.a aVar, int i, String str, String str2) {
        a aVar2 = new a();
        aVar2.dly = aVar;
        aVar2.type = i;
        aVar2.value = str;
        aVar2.bLe = str2;
        return aVar2;
    }

    public final a gq(int i) {
        a aVar = (a) this.dlB.get(i);
        if (aVar == null) {
            aVar = gn(i);
            if (aVar != null) {
                this.dlB.put(i, aVar);
            }
        }
        return aVar;
    }

    public final a f(com.tencent.mm.storage.aa.a aVar) {
        a aVar2 = (a) this.dlC.get(aVar);
        if (aVar2 == null) {
            aVar2 = c(aVar);
            if (aVar2 != null) {
                this.dlC.put(aVar, aVar2);
            }
        }
        return aVar2;
    }

    final b gr(int i) {
        b bVar = (b) this.dlD.get(i);
        if (bVar != null) {
            return bVar;
        }
        bVar = go(i);
        if (bVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.dlD.put(i, bVar);
        return bVar;
    }

    final b g(com.tencent.mm.storage.aa.a aVar) {
        b bVar = (b) this.dlE.get(aVar);
        if (bVar != null) {
            return bVar;
        }
        bVar = d(aVar);
        if (bVar == null) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "[carl] loadWatcher watcher == null");
            return null;
        }
        this.dlE.put(aVar, bVar);
        return bVar;
    }

    public final a x(int i, int i2, int i3) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceId %d, watcherId %d, type %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        a gq = gq(i);
        if (gq == null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((gq.type & i3) == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b gr = gr(i2);
            if (gr != null) {
                String str = (String) gr.dlJ.get(i);
                if (str != null && str.equals(gq.bLe)) {
                    return null;
                }
                if (str == null) {
                    gr.dlJ.put(i, Co());
                    a(gr);
                }
                return gq;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }

    public final a a(com.tencent.mm.storage.aa.a aVar, com.tencent.mm.storage.aa.a aVar2, int i) {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", new Object[]{aVar, aVar2, Integer.valueOf(i)});
        a f = f(aVar);
        if (f == null) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NewBadgeDecoder", "[carl] peek, dataSource == null");
            return null;
        } else if ((f.type & i) == 0) {
            com.tencent.mm.sdk.platformtools.x.d("MicroMsg.NewBadgeDecoder", "[alex] peek, dataSource.type is wrong");
            return null;
        } else {
            b g = g(aVar2);
            if (g != null) {
                String str = (String) g.dlK.get(aVar.name());
                if (str != null && str.equals(f.bLe)) {
                    return null;
                }
                if (str == null) {
                    g.dlK.put(aVar.name(), Co());
                    a(g);
                }
                return f;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.NewBadgeDecoder", "[carl] peek, watcher == null");
            return null;
        }
    }
}
