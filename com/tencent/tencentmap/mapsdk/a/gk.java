package com.tencent.tencentmap.mapsdk.a;

import com.tencent.tencentmap.mapsdk.a.go.a;
import java.util.ArrayList;

class gk extends gp {
    private boolean g = true;

    public gk(a... aVarArr) {
        super(aVarArr);
    }

    /* renamed from: a */
    public gk clone() {
        ArrayList arrayList = this.e;
        int size = this.e.size();
        a[] aVarArr = new a[size];
        for (int i = 0; i < size; i++) {
            aVarArr[i] = (a) ((go) arrayList.get(i)).clone();
        }
        return new gk(aVarArr);
    }
}
