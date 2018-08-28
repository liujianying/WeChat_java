package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.storage.bd;
import java.util.Comparator;

class j$7 implements Comparator<bd> {
    final /* synthetic */ j tOS;

    j$7(j jVar) {
        this.tOS = jVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) (((bd) obj).field_createTime - ((bd) obj2).field_createTime);
    }
}
