package com.tencent.mm.svg;

import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;

final class a<T> {
    private HashMap<Looper, LinkedList<T>> teC = new HashMap();
    private LinkedList<T> teD = new LinkedList();

    a() {
    }

    protected final synchronized T cof() {
        T t;
        t = null;
        if (this.teD.size() != 0) {
            t = this.teD.poll();
        }
        return t;
    }

    protected final synchronized void a(Looper looper, T t) {
        LinkedList linkedList;
        if (this.teC.containsKey(looper)) {
            linkedList = (LinkedList) this.teC.get(looper);
        } else {
            linkedList = new LinkedList();
            this.teC.put(looper, linkedList);
        }
        linkedList.add(t);
    }

    protected final synchronized void c(Looper looper) {
        if (this.teC.containsKey(looper)) {
            this.teD.addAll((LinkedList) this.teC.remove(looper));
        }
    }
}
