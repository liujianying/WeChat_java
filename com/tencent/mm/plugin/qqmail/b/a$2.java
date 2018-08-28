package com.tencent.mm.plugin.qqmail.b;

import java.util.Comparator;

class a$2 implements Comparator<i> {
    final /* synthetic */ a mcc;

    a$2(a aVar) {
        this.mcc = aVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        i iVar = (i) obj;
        i iVar2 = (i) obj2;
        int compareTo = a.b(iVar).compareTo(a.b(iVar2));
        return compareTo == 0 ? iVar.kCs.compareTo(iVar2.kCs) : compareTo;
    }
}
