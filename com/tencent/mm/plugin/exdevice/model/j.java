package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import java.util.LinkedList;
import java.util.List;

public final class j {
    private static j ivv;
    private SparseArray<List<a>> ivw = new SparseArray();

    private j() {
    }

    public static j aGV() {
        if (ivv == null) {
            ivv = new j();
        }
        return ivv;
    }

    public final boolean a(int i, a aVar) {
        if (aVar == null) {
            return false;
        }
        List list = (List) this.ivw.get(i);
        if (list == null) {
            list = new LinkedList();
            this.ivw.put(i, list);
        } else if (list.contains(aVar)) {
            return false;
        }
        return list.add(aVar);
    }

    public final boolean b(int i, a aVar) {
        List list = (List) this.ivw.get(i);
        if (list != null) {
            list.remove(aVar);
            if (list.size() == 0) {
                this.ivw.remove(i);
            }
        }
        return false;
    }

    public final void f(int i, Object... objArr) {
        List list = (List) this.ivw.get(i);
        if (list != null && list.size() != 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < list.size()) {
                    ((a) list.get(i3)).e(i, objArr);
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
