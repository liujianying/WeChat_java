package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public abstract class f {
    public final DataHolder aMb;
    public int aMx;
    private int aMy;

    public f(DataHolder dataHolder, int i) {
        this.aMb = (DataHolder) w.ah(dataHolder);
        boolean z = i >= 0 && i < this.aMb.aMm;
        w.at(z);
        this.aMx = i;
        this.aMy = this.aMb.dq(this.aMx);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return v.c(Integer.valueOf(fVar.aMx), Integer.valueOf(this.aMx)) && v.c(Integer.valueOf(fVar.aMy), Integer.valueOf(this.aMy)) && fVar.aMb == this.aMb;
    }

    public final byte[] getByteArray(String str) {
        DataHolder dataHolder = this.aMb;
        int i = this.aMx;
        int i2 = this.aMy;
        dataHolder.m(str, i);
        return dataHolder.aMj[i2].getBlob(i, dataHolder.aMi.getInt(str));
    }

    public final int getInteger(String str) {
        DataHolder dataHolder = this.aMb;
        int i = this.aMx;
        int i2 = this.aMy;
        dataHolder.m(str, i);
        return dataHolder.aMj[i2].getInt(i, dataHolder.aMi.getInt(str));
    }

    public final String getString(String str) {
        return this.aMb.d(str, this.aMx, this.aMy);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.aMx), Integer.valueOf(this.aMy), this.aMb});
    }
}
