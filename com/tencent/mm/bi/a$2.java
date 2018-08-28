package com.tencent.mm.bi;

import com.tencent.mm.d.b;
import java.util.Comparator;

class a$2 implements Comparator<b> {
    final /* synthetic */ a qVu;

    a$2(a aVar) {
        this.qVu = aVar;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((b) obj).vE().value - ((b) obj2).vE().value;
    }
}
