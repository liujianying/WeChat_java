package com.tencent.mm.plugin.fts.a.b;

import java.util.List;

final class a {
    public List<a> ayR;
    public int end;
    public a jsN;
    public boolean jsO;
    public int start;

    public a(int i, int i2, a aVar) {
        this.start = i;
        this.end = i2;
        this.jsN = aVar;
    }

    public final String toString() {
        if (this.jsN == null) {
            return String.format("[%d,%d]", new Object[]{Integer.valueOf(this.start), Integer.valueOf(this.end)});
        }
        return String.format("%s [%d,%d]", new Object[]{this.jsN, Integer.valueOf(this.start), Integer.valueOf(this.end)});
    }
}
