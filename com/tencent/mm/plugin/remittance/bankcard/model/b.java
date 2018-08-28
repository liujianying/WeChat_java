package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Comparator;

public final class b implements Comparator<fg> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        fg fgVar = (fg) obj;
        fg fgVar2 = (fg) obj2;
        if (bi.oW(fgVar.knE) || bi.oW(fgVar2.knE)) {
            if (!(bi.oW(fgVar.knE) && bi.oW(fgVar2.knE))) {
                if (bi.oW(fgVar.knE)) {
                    return 1;
                }
                if (bi.oW(fgVar2.knE)) {
                    return -1;
                }
            }
            return 0;
        }
        char charAt = !bi.oW(fgVar.rgg) ? fgVar.rgg.toUpperCase().charAt(0) : a.Kv(fgVar.knE);
        char charAt2 = !bi.oW(fgVar2.rgg) ? fgVar2.rgg.toUpperCase().charAt(0) : a.Kv(fgVar2.knE);
        if (charAt < charAt2) {
            return -1;
        }
        return charAt > charAt2 ? 1 : 0;
    }
}
