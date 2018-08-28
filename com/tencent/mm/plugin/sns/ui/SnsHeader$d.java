package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.storage.n;
import java.util.Comparator;

class SnsHeader$d implements Comparator<n> {
    final /* synthetic */ SnsHeader nWo;

    SnsHeader$d(SnsHeader snsHeader) {
        this.nWo = snsHeader;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        if (nVar.field_createTime == nVar2.field_createTime) {
            return 0;
        }
        return nVar.field_createTime > nVar2.field_createTime ? -1 : 1;
    }
}
