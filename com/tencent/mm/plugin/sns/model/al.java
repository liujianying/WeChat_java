package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class al<K, O> {
    private int maxSize;
    Map<K, b<O>> nrg = null;
    private a nrh = null;

    public al(int i, a aVar) {
        this.maxSize = i;
        this.nrg = new HashMap();
        this.nrh = aVar;
    }

    public final void byK() {
        if (this.nrg.size() > this.maxSize) {
            Object arrayList = new ArrayList(this.nrg.entrySet());
            Collections.sort(arrayList, new 1(this));
            int size = this.nrg.size() - this.maxSize;
            if (size > 0) {
                Iterator it = arrayList.iterator();
                while (true) {
                    int i = size;
                    if (it.hasNext()) {
                        Entry entry = (Entry) it.next();
                        if (this.nrh.bP(entry.getKey())) {
                            x.d("MicroMsg.SnsLRUMap", " remove targetKey: " + entry.getKey());
                            size = i - 1;
                        } else {
                            size = i;
                        }
                        if (size <= 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }
}
