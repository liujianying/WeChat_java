package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public final class e {
    private final SparseArray<b<a>> pSU = new SparseArray();

    private static final class b<T> {
        final byte[] dsN = new byte[0];
        final SparseArray<T> pSY = new SparseArray();

        public final T valueAt(int i) {
            return this.pSY.valueAt(i);
        }

        public final void remove(int i) {
            this.pSY.remove(i);
        }
    }

    public final boolean Ao(int i) {
        b bVar;
        synchronized (this.pSU) {
            bVar = (b) this.pSU.get(i);
            this.pSU.remove(i);
        }
        if (bVar != null) {
            synchronized (bVar.dsN) {
                bVar.pSY.clear();
            }
        }
        return true;
    }

    public final boolean b(int i, String str, String str2, String str3, int i2) {
        int i3 = 0;
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        b bVar;
        synchronized (this.pSU) {
            bVar = (b) this.pSU.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.dsN) {
            if (bVar.pSY.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            while (true) {
                int i4 = i3;
                if (i4 >= bVar.pSY.size()) {
                    break;
                }
                a aVar = (a) bVar.valueAt(i4);
                if (bi.oV(aVar.appId).equals(str) && bi.oV(aVar.cfx).equals(str2) && bi.oV(aVar.cfy).equals(str3) && aVar.cfz == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
                i3 = i4 + 1;
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final boolean a(int i, String str, String str2, String str3, int i2, String str4) {
        int i3 = 0;
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3) || bi.oW(str4) || (i2 != 2 && i2 != 1 && i2 != 3)) {
            return false;
        }
        b bVar;
        synchronized (this.pSU) {
            bVar = (b) this.pSU.get(i);
        }
        if (bVar == null) {
            return true;
        }
        synchronized (bVar.dsN) {
            if (bVar.pSY.size() == 0) {
                return true;
            }
            List<Integer> linkedList = new LinkedList();
            while (true) {
                int i4 = i3;
                if (i4 >= bVar.pSY.size()) {
                    break;
                }
                a aVar = (a) bVar.valueAt(i4);
                if (bi.oV(aVar.appId).equals(str) && bi.oV(aVar.cfx).equals(str2) && bi.oV(aVar.cfy).equals(str3) && bi.oV(aVar.pSX).equals(str4) && aVar.cfz == i2) {
                    linkedList.add(Integer.valueOf(aVar.key));
                }
                i3 = i4 + 1;
            }
            for (Integer intValue : linkedList) {
                bVar.remove(intValue.intValue());
            }
            return true;
        }
    }

    public final List<c> q(String str, String str2, String str3, String str4) {
        if (bi.oW(str) || bi.oW(str2) || bi.oW(str3) || bi.oW(str4)) {
            return null;
        }
        String QE = p.QE(str);
        if (bi.oW(QE)) {
            return null;
        }
        List<c> linkedList = new LinkedList();
        synchronized (this.pSU) {
            for (int i = 0; i < this.pSU.size(); i++) {
                b bVar = (b) this.pSU.valueAt(i);
                if (bVar != null) {
                    synchronized (bVar.dsN) {
                        for (int i2 = 0; i2 < bVar.pSY.size(); i2++) {
                            a aVar = (a) bVar.valueAt(i2);
                            if (bi.oV(aVar.pSX).equals(QE) && bi.oV(aVar.appId).equals(str2) && bi.oV(aVar.cfx).equals(str3) && bi.oV(aVar.cfy).equals(str4)) {
                                linkedList.add(new c(aVar.pSW, aVar.pSV));
                            }
                        }
                    }
                }
            }
        }
        return linkedList;
    }
}
