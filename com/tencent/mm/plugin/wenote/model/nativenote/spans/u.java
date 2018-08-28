package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u {
    public static final ArrayList<t> qtA;
    public static final b qtv = new b();
    public static final j qtw = new j();
    public static final c qtx = new c();
    public static final l qty = new l();
    public static final h qtz = new h();

    static {
        ArrayList arrayList = new ArrayList();
        qtA = arrayList;
        arrayList.add(qtv);
        qtA.add(qtx);
        qtA.add(qty);
        qtA.add(qtw);
    }

    public static void a(WXRTEditText wXRTEditText, t... tVarArr) {
        a(wXRTEditText, qtz, tVarArr);
        a(wXRTEditText, qtx, tVarArr);
        a(wXRTEditText, qty, tVarArr);
        a(wXRTEditText, qtw, tVarArr);
    }

    private static void a(WXRTEditText wXRTEditText, o oVar, t... tVarArr) {
        int length = tVarArr.length;
        int i = 0;
        while (i < length) {
            if (oVar != tVarArr[i]) {
                i++;
            } else {
                return;
            }
        }
        oVar.a(wXRTEditText, null, null);
    }
}
