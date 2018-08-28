package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class h<T> extends a<T> {
    private ArrayList<Integer> aMA;
    private boolean aMz = false;

    public h(DataHolder dataHolder) {
        super(dataHolder);
    }

    private int ds(int i) {
        if (i >= 0 && i < this.aMA.size()) {
            return ((Integer) this.aMA.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    private void oY() {
        synchronized (this) {
            if (!this.aMz) {
                int i = this.aMb.aMm;
                this.aMA = new ArrayList();
                if (i > 0) {
                    this.aMA.add(Integer.valueOf(0));
                    String oX = oX();
                    String d = this.aMb.d(oX, 0, this.aMb.dq(0));
                    int i2 = 1;
                    while (i2 < i) {
                        int dq = this.aMb.dq(i2);
                        String d2 = this.aMb.d(oX, i2, dq);
                        if (d2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + oX + ", at row: " + i2 + ", for window: " + dq);
                        }
                        if (d2.equals(d)) {
                            d2 = d;
                        } else {
                            this.aMA.add(Integer.valueOf(i2));
                        }
                        i2++;
                        d = d2;
                    }
                }
                this.aMz = true;
            }
        }
    }

    public abstract T ay(int i, int i2);

    public final T get(int i) {
        int i2;
        oY();
        int ds = ds(i);
        if (i < 0 || i == this.aMA.size()) {
            i2 = 0;
        } else {
            i2 = i == this.aMA.size() + -1 ? this.aMb.aMm - ((Integer) this.aMA.get(i)).intValue() : ((Integer) this.aMA.get(i + 1)).intValue() - ((Integer) this.aMA.get(i)).intValue();
            if (i2 == 1) {
                this.aMb.dq(ds(i));
            }
        }
        return ay(ds, i2);
    }

    public final int getCount() {
        oY();
        return this.aMA.size();
    }

    public abstract String oX();
}
