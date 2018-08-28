package com.tencent.mm.plugin.fts.a.a;

import java.util.ArrayList;
import java.util.List;

public final class j {
    public int bjW;
    public i joH;
    public g jrx;
    public a jsw;
    public List<l> jsx = new ArrayList();

    public j(i iVar) {
        this.joH = iVar;
    }

    public final String toString() {
        int i = 0;
        String str = "{resultCode: %d, resultSize: %d}";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.bjW);
        if (this.jsx != null) {
            i = this.jsx.size();
        }
        objArr[1] = Integer.valueOf(i);
        return String.format(str, objArr);
    }
}
