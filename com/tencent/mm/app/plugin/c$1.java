package com.tencent.mm.app.plugin;

import com.tencent.mm.pluginsdk.ui.applet.m;
import java.util.Comparator;

class c$1 implements Comparator<m> {
    final /* synthetic */ c bAn;

    c$1(c cVar) {
        this.bAn = cVar;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        m mVar = (m) obj2;
        int i = ((m) obj).start;
        int i2 = mVar.start;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}
