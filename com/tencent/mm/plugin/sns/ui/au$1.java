package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.n;
import java.util.Comparator;

class au$1 implements Comparator<n> {
    final /* synthetic */ au oaz;

    au$1(au auVar) {
        this.oaz = auVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        if (nVar.nJc == -1) {
            return -1;
        }
        if (nVar2.nJc == -1) {
            return 1;
        }
        if (nVar.field_head != nVar2.field_head) {
            return nVar2.field_head - nVar.field_head;
        }
        return nVar.field_createTime != nVar2.field_createTime ? nVar2.field_createTime - nVar.field_createTime : 0;
    }
}
