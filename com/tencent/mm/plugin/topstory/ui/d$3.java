package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.protocal.c.btg;
import java.util.Comparator;

class d$3 implements Comparator<btg> {
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return (int) (((btg) obj).timestamp - ((btg) obj2).timestamp);
    }
}
