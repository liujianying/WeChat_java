package com.tencent.mm.br;

import com.tencent.mm.br.f.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Comparator;

class f$1 implements Comparator<a> {
    f$1() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        a aVar = (a) obj;
        a aVar2 = (a) obj2;
        if (aVar == null && aVar2 == null) {
            return 0;
        }
        if (aVar == null || bi.oW(aVar.text)) {
            return 1;
        }
        return (aVar2 == null || bi.oW(aVar2.text)) ? -1 : aVar.text.compareTo(aVar2.text);
    }
}
