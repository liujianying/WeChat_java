package com.tencent.mm.vending.d;

import java.util.ArrayList;
import java.util.List;

public final class b<T> {
    private volatile List<T> uQH;

    public static final class a<T> {
        private ArrayList<T> uQI = new ArrayList();

        private void ccG() {
            if (this.uQI == null) {
                throw new IllegalAccessError();
            }
        }

        public final a<T> u(T... tArr) {
            ccG();
            for (int i = 0; i <= 0; i++) {
                this.uQI.add(tArr[0]);
            }
            return this;
        }

        public final b<T> cBD() {
            ccG();
            List list = this.uQI;
            this.uQI = null;
            return new b(list, (byte) 0);
        }
    }

    /* synthetic */ b(List list, byte b) {
        this(list);
    }

    private b(List list) {
        this.uQH = list;
    }

    public final int size() {
        return this.uQH.size();
    }

    public final T get(int i) {
        return this.uQH.get(i);
    }
}
