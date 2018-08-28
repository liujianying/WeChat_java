package com.tencent.sqlitelint.a;

import com.tencent.sqlitelint.e;
import com.tencent.sqlitelint.e.b;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public final List<a> vnW = new ArrayList();

    public static final class a {
        static final /* synthetic */ boolean $assertionsDisabled = (!a.class.desiredAssertionStatus());
        public final com.tencent.sqlitelint.e.a vnX;
        public final b vnY;
        public int vnZ;
        public final List<String> voa = new ArrayList();

        public a(com.tencent.sqlitelint.e.a aVar, b bVar) {
            this.vnX = aVar;
            this.vnY = bVar;
        }

        public final a acL(String str) {
            this.voa.add(str);
            return this;
        }
    }

    public a(int i) {
        e.Hs(i);
    }
}
