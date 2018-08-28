package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.b.a.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class a$a extends a {
    public final long ald;
    public final List<b> ale = new ArrayList();
    public final List<a$a> alf = new ArrayList();

    public a$a(int i, long j) {
        super(i);
        this.ald = j;
    }

    public final b cv(int i) {
        int size = this.ale.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.ale.get(i2);
            if (bVar.type == i) {
                return bVar;
            }
        }
        return null;
    }

    public final a$a cw(int i) {
        int size = this.alf.size();
        for (int i2 = 0; i2 < size; i2++) {
            a$a a_a = (a$a) this.alf.get(i2);
            if (a_a.type == i) {
                return a_a;
            }
        }
        return null;
    }

    public final String toString() {
        return cu(this.type) + " leaves: " + Arrays.toString(this.ale.toArray()) + " containers: " + Arrays.toString(this.alf.toArray());
    }
}
