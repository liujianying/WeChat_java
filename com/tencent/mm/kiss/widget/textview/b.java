package com.tencent.mm.kiss.widget.textview;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public ConcurrentHashMap<String, LinkedList<f>> dtB = new ConcurrentHashMap();

    public final synchronized void a(f fVar) {
        if (fVar != null) {
            if (fVar.duf != null) {
                LinkedList linkedList = (LinkedList) this.dtB.get(fVar.duf.toString());
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(fVar);
                this.dtB.put(fVar.duf.toString(), linkedList);
            }
        }
    }

    public final synchronized f m(CharSequence charSequence) {
        f fVar;
        LinkedList linkedList = (LinkedList) this.dtB.get(charSequence.toString());
        if (linkedList == null || linkedList.size() == 0) {
            fVar = null;
        } else {
            fVar = (f) linkedList.removeFirst();
        }
        return fVar;
    }
}
