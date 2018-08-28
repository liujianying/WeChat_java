package com.tencent.mm.plugin.clean.c;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class f extends Thread {
    private int hQQ = 0;
    private int hQR = 0;
    private h hRg;
    private HashSet<String> hRl;
    private boolean isStop = false;

    public f(HashSet<String> hashSet, h hVar) {
        this.hRl = hashSet;
        this.hRg = hVar;
    }

    public final void run() {
        if (this.hRl == null || this.hRl.isEmpty()) {
            x.w("MicroMsg.DeleteOtherAccController", "delete paths is null.");
            cj(0);
            return;
        }
        String str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder("mm");
        g.Ek();
        g.Eg();
        String u = com.tencent.mm.a.g.u(stringBuilder.append(a.Df()).toString().getBytes());
        Iterator it = this.hRl.iterator();
        while (it.hasNext()) {
            str = (String) it.next();
            x.i("MicroMsg.DeleteOtherAccController", "uinPath[%s] path[%s]", new Object[]{u, str});
            if (!bi.fS(u, str)) {
                c(g.Ei().dqo + str, arrayList);
                c(aa.duN + str, arrayList2);
            }
        }
        this.hQQ = arrayList.size() + arrayList2.size();
        this.hQR = 0;
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        int size = arrayList.size();
        PInt pInt = new PInt();
        int i = 0;
        while (!this.isStop && i < size) {
            pInt.value = 0;
            str = (String) arrayList.get(i);
            i++;
            x.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", new Object[]{Integer.valueOf(i), str, Integer.valueOf(pInt.value)});
            if (a(new File(str), pInt, pLong) == -1) {
                break;
            }
            this.hQR++;
            aBs();
        }
        int size2 = arrayList2.size();
        PInt pInt2 = new PInt();
        i = 0;
        while (!this.isStop && i < size2) {
            pInt2.value = 0;
            str = (String) arrayList2.get(i);
            i++;
            x.i("MicroMsg.DeleteOtherAccController", "ready to delete index[%d] path[%s] pDelete[%d]", new Object[]{Integer.valueOf(i), str, Integer.valueOf(pInt2.value)});
            if (a(new File(str), pInt2, pLong2) == -1) {
                break;
            }
            this.hQR++;
            aBs();
        }
        x.i("MicroMsg.DeleteOtherAccController", "delete finish sd[%d] data[%d]", new Object[]{Long.valueOf(pLong.value), Long.valueOf(pLong2.value)});
        cj(pLong.value);
    }

    private static void c(String str, ArrayList<String> arrayList) {
        if (!bi.oW(str)) {
            x.i("MicroMsg.DeleteOtherAccController", "check paths [%s]", new Object[]{str});
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                String[] list = file.list();
                if (list != null && list.length > 0) {
                    for (String str2 : list) {
                        x.d("MicroMsg.DeleteOtherAccController", "check add path[%s]", new Object[]{str + File.separator + str2});
                        arrayList.add(str2);
                    }
                }
            }
        }
    }

    private void aBs() {
        if (!this.isStop) {
            ah.A(new 1(this));
        }
    }

    private void cj(long j) {
        if (!this.isStop) {
            ah.A(new 2(this, j));
        }
    }

    private int a(File file, PInt pInt, PLong pLong) {
        String str = "MicroMsg.DeleteOtherAccController";
        String str2 = "delete [%d] [%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = file != null ? file.getAbsolutePath() : "null";
        x.d(str, str2, objArr);
        if (pInt.value >= 10) {
            if (this.isStop) {
                return -1;
            }
            pInt.value = 0;
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File a : listFiles) {
                    if (a(a, pInt, pLong) == -1) {
                        return -1;
                    }
                }
            }
            FileOp.deleteFile(file.getAbsolutePath());
        } else {
            pLong.value += file.length();
            FileOp.deleteFile(file.getAbsolutePath());
            pInt.value++;
        }
        return 1;
    }
}
