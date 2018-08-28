package com.tencent.tencentmap.mapsdk.a;

import java.util.ArrayList;

public abstract class gi implements Cloneable {
    ArrayList<Object> a = null;

    /* renamed from: a */
    public gi clone() {
        try {
            gi giVar = (gi) super.clone();
            if (this.a != null) {
                ArrayList arrayList = this.a;
                giVar.a = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    giVar.a.add(arrayList.get(i));
                }
            }
            return giVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
