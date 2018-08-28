package com.tencent.mm.plugin.clean.c;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.clean.c.a.a$a;
import com.tencent.mm.plugin.clean.c.a.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements a$a, Runnable {
    private static final Long hQA = Long.valueOf(604800000);
    private static final Long hQB = Long.valueOf(7776000000L);
    private static final int hQN = (com.tencent.mm.model.c.Gq().length() - 1);
    private ag dvh = new ag(Looper.getMainLooper());
    private long endTime = 0;
    private long hQD;
    private long hQE;
    private b hQO;
    private g hQP;
    private int hQQ = 0;
    private int hQR = 0;
    private ConcurrentHashMap<String, b> hQS = new ConcurrentHashMap();
    private long hQT;
    private long hQU;
    private HashSet<String> hQV = new HashSet();
    private HashSet<String> hQW = new HashSet();
    private boolean hQX = true;
    private int[] hQY = new int[10];
    public boolean isStop;
    private long startTime = 0;

    public class a extends com.tencent.mm.plugin.clean.c.a.a {
        private String username;

        public a(String str) {
            super(c.this);
            this.username = str;
        }

        public final String SR() {
            return "username[" + this.username + "]" + super.SR();
        }

        public final void execute() {
            au.HU();
            int GW = com.tencent.mm.model.c.FT().GW(this.username);
            if (GW <= 0) {
                x.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", new Object[]{this.username, Integer.valueOf(GW)});
                return;
            }
            b bVar = new b();
            bVar.username = this.username;
            bVar.hQM = new ArrayList();
            bVar.gTK = 0;
            Cursor cursor = null;
            int i = 0;
            while (i < GW) {
                try {
                    au.HU();
                    cursor = com.tencent.mm.model.c.FT().Y(this.username, i, 50);
                    if (cursor == null) {
                        break;
                    }
                    int a = a(cursor, bVar);
                    if (!(cursor == null || cursor.isClosed())) {
                        cursor.close();
                    }
                    if (a <= 0) {
                        break;
                    }
                    i += a;
                    if (c.this.isStop) {
                        break;
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CleanController", e, "execute analyse Task error.", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            if (bVar.hQM.size() > 0) {
                c.this.hQS.put(this.username, bVar);
            }
            x.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", new Object[]{this.username, Integer.valueOf(GW), Integer.valueOf(i), Boolean.valueOf(c.this.isStop)});
        }

        private int a(Cursor cursor, b bVar) {
            int i = 0;
            if (cursor.moveToFirst()) {
                a aVar = null;
                while (!cursor.isAfterLast()) {
                    i++;
                    bd bdVar = new bd();
                    bdVar.d(cursor);
                    switch (l.BJ(bdVar.getType())) {
                        case 3:
                            aVar = c.b(bdVar, this.username);
                            break;
                        case 43:
                        case 44:
                        case 62:
                            aVar = c.c(bdVar, this.username);
                            break;
                        case 49:
                            aVar = c.a(bdVar, this.username);
                            break;
                    }
                    if (aVar != null) {
                        bVar.hQM.add(aVar);
                        bVar.gTK += aVar.size;
                        aVar = null;
                    }
                    if (cursor.moveToNext()) {
                        if (c.this.isStop) {
                        }
                    }
                    cursor.close();
                }
                cursor.close();
            } else {
                x.d("MicroMsg.CleanController", "Message count of user:%s is empty", new Object[]{this.username});
                cursor.close();
            }
            return i;
        }
    }

    static {
        au.HU();
    }

    public c(b bVar, g gVar) {
        this.hQP = gVar;
        this.hQO = bVar;
    }

    public final void run() {
        int i;
        String str;
        x.i("MicroMsg.CleanController", "Start to run clean controller");
        this.startTime = System.currentTimeMillis();
        long VG = bi.VG();
        String str2 = e.bnE;
        x.v("MicroMsg.CleanController", "root path: %s", new Object[]{str2});
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Ek();
        g.Eg();
        String u = com.tencent.mm.a.g.u(stringBuilder.append(com.tencent.mm.kernel.a.Df()).toString().getBytes());
        ArrayList arrayList = new ArrayList();
        File file = new File(str2);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str3 : list) {
                    String str4 = str2 + str3;
                    if (str3.length() >= 32) {
                        x.v("MicroMsg.CleanController", "add subfile list: %s uinPath %s ", new Object[]{str3, u});
                        Collection yx = yx(str4);
                        if (arrayList.size() > 0) {
                            if (!u.equals(str3)) {
                                x.i("MicroMsg.CleanController", "add other acc tmp path %s", new Object[]{str3});
                                this.hQV.add(str3);
                            }
                            arrayList.addAll(0, yx);
                        } else {
                            arrayList.addAll(yx);
                        }
                    } else {
                        x.v("MicroMsg.CleanController", "subfile: %s", new Object[]{str3});
                        if (arrayList.size() > 0) {
                            arrayList.add(0, str4);
                        } else {
                            arrayList.add(str4);
                        }
                    }
                }
            }
        } else {
            ce((long) com.tencent.mm.a.e.cm(str2));
        }
        int i2 = -1;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= arrayList.size()) {
                break;
            }
            str = (String) arrayList.get(i);
            if (str.contains("image2")) {
                i2 = i;
            }
            if (str.contains("voice2")) {
                i3 = i;
            }
            i4 = i + 1;
        }
        if (i3 != -1) {
            arrayList.add(0, (String) arrayList.remove(i3));
        }
        if (i2 != -1) {
            arrayList.add(0, (String) arrayList.remove(i2));
        }
        x.d("MicroMsg.CleanController", "scan is finish [%s]", new Object[]{Long.valueOf(bi.bI(VG))});
        long VG2 = bi.VG();
        ArrayList aBc = aBc();
        x.d("MicroMsg.CleanController", "user is finish [%s]", new Object[]{Long.valueOf(bi.bI(VG2))});
        this.hQQ = arrayList.size() + aBc.size();
        if (this.hQQ == 0) {
            x.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
            aAZ();
            return;
        }
        x.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", new Object[]{Integer.valueOf(this.hQQ)});
        i4 = 0;
        while (true) {
            i = i4;
            if (this.isStop || i >= arrayList.size()) {
                i4 = 0;
            } else {
                x.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), (String) arrayList.get(i)});
                b bVar = new b(this, str);
                while (!this.hQO.b(bVar)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e) {
                    }
                }
                x.d("MicroMsg.CleanController", "Start task： filePath＝%s", new Object[]{str});
                i4 = i + 1;
            }
        }
        i4 = 0;
        while (true) {
            i = i4;
            if (!this.isStop && i < aBc.size()) {
                x.d("MicroMsg.CleanController", "while loop index=%d | username=%s", new Object[]{Integer.valueOf(i), (String) aBc.get(i)});
                a aVar = new a(str);
                while (!this.hQO.b(aVar)) {
                    try {
                        Thread.sleep(2147483647L);
                    } catch (InterruptedException e2) {
                    }
                }
                x.d("MicroMsg.CleanController", "Start task： user＝%s", new Object[]{str});
                i4 = i + 1;
            } else {
                return;
            }
        }
    }

    public final void a(com.tencent.mm.plugin.clean.c.a.a aVar) {
        if (aVar instanceof a) {
            x.d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", new Object[]{Integer.valueOf(aVar.hashCode()), aVar.SR()});
        } else {
            x.d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", new Object[]{Integer.valueOf(aVar.hashCode()), aVar.SR()});
        }
        com.tencent.mm.sdk.f.e.S(this);
        this.hQR++;
        if (!(this.hQP == null || this.isStop)) {
            this.dvh.post(new 2(this));
        }
        if (this.hQR == this.hQQ) {
            aAZ();
        }
    }

    private void aAZ() {
        this.endTime = System.currentTimeMillis();
        x.i("MicroMsg.CleanController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.hQP != null && !this.isStop) {
            Object arrayList = new ArrayList();
            for (b add : this.hQS.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            this.dvh.post(new 1(this, arrayList));
        }
    }

    public static long aBa() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnC);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long aBb() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(e.bnC);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    private static ArrayList<String> aBc() {
        ArrayList<String> arrayList = new ArrayList();
        List linkedList = new LinkedList();
        for (Object add : s.dAV) {
            linkedList.add(add);
        }
        au.HU();
        Cursor b = com.tencent.mm.model.c.FW().b(s.dAN, linkedList, "*");
        if (b.moveToFirst()) {
            do {
                ai aiVar = new ai();
                aiVar.d(b);
                if (!bi.oW(aiVar.field_username)) {
                    au.HU();
                    if (!ab.Dk(com.tencent.mm.model.c.FR().Yg(aiVar.field_username).field_verifyFlag)) {
                        arrayList.add(aiVar.field_username);
                    }
                }
                if (!b.moveToNext()) {
                    break;
                }
            } while (!b.isAfterLast());
        }
        b.close();
        return arrayList;
    }

    private static ArrayList<String> yx(String str) {
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                arrayList.add(str);
            } else {
                for (String str2 : list) {
                    arrayList.add(str + File.separator + str2);
                }
            }
        } else {
            arrayList.add(str);
        }
        return arrayList;
    }

    private synchronized void ce(long j) {
        if (j < 0) {
            x.w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", new Object[]{Long.valueOf(j)});
            this.hQU += 60;
        } else {
            this.hQU += j;
        }
    }
}
