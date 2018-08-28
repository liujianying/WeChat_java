package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.i.n.a;
import java.util.Comparator;

class n$2 implements Comparator<a> {
    n$2() {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar.value < aVar2.value) {
            return -1;
        }
        return aVar2.value < aVar.value ? 1 : 0;
    }
}
