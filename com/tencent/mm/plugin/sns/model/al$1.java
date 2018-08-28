package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.model.al.b;
import java.util.Comparator;
import java.util.Map.Entry;

class al$1 implements Comparator<Entry<K, b<O>>> {
    final /* synthetic */ al nri;

    al$1(al alVar) {
        this.nri = alVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((b) ((Entry) obj).getValue()).nrj.compareTo(((b) ((Entry) obj2).getValue()).nrj);
    }
}
