package com.google.android.gms.c;

import com.google.android.gms.c.b.a;

public final class at {
    public static a a(a aVar) {
        a aVar2 = new a();
        aVar2.type = aVar.type;
        aVar2.aWj = (int[]) aVar.aWj.clone();
        if (aVar.aWk) {
            aVar2.aWk = aVar.aWk;
        }
        return aVar2;
    }
}
