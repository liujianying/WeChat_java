package com.tencent.mm.booter;

import com.tencent.mm.model.au;
import com.tencent.mm.model.br;
import com.tencent.mm.protocal.c.aqa;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;

public final class i {
    public static void run() {
        int i;
        aqa aqa;
        LinkedList linkedList = new LinkedList();
        int a = bi.a((Integer) au.HS().get(19), 0);
        for (i = 0; i < a; i++) {
            aqa = new aqa();
            aqa.mEb = 31;
            aqa.mEl = "0";
            linkedList.add(aqa);
        }
        a = bi.a((Integer) au.HS().get(20), 0);
        for (i = 0; i < a; i++) {
            aqa = new aqa();
            aqa.mEb = 31;
            aqa.mEl = "1";
            linkedList.add(aqa);
        }
        if (linkedList.size() > 0) {
            br.b(linkedList);
            au.HS().set(19, Integer.valueOf(0));
            au.HS().set(20, Integer.valueOf(0));
        }
    }
}
