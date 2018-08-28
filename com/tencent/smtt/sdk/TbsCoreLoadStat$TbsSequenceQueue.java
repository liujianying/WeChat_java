package com.tencent.smtt.sdk;

import java.util.Arrays;

public class TbsCoreLoadStat$TbsSequenceQueue {
    final /* synthetic */ TbsCoreLoadStat a;
    private int b;
    private int c;
    private int[] d;
    private int e;
    private int f;

    public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat tbsCoreLoadStat) {
        this.a = tbsCoreLoadStat;
        this.b = 10;
        this.e = 0;
        this.f = 0;
        this.c = this.b;
        this.d = new int[this.c];
    }

    public TbsCoreLoadStat$TbsSequenceQueue(TbsCoreLoadStat tbsCoreLoadStat, int i, int i2) {
        this.a = tbsCoreLoadStat;
        this.b = 10;
        this.e = 0;
        this.f = 0;
        this.c = i2;
        this.d = new int[this.c];
        this.d[0] = i;
        this.f++;
    }

    public void add(int i) {
        if (this.f > this.c - 1) {
            throw new IndexOutOfBoundsException("sequeue is full");
        }
        int[] iArr = this.d;
        int i2 = this.f;
        this.f = i2 + 1;
        iArr[i2] = i;
    }

    public void clear() {
        Arrays.fill(this.d, 0);
        this.e = 0;
        this.f = 0;
    }

    public int element() {
        if (!empty()) {
            return this.d[this.e];
        }
        throw new IndexOutOfBoundsException("sequeue is null");
    }

    public boolean empty() {
        return this.f == this.e;
    }

    public int length() {
        return this.f - this.e;
    }

    public int remove() {
        if (empty()) {
            throw new IndexOutOfBoundsException("sequeue is null");
        }
        int i = this.d[this.e];
        int[] iArr = this.d;
        int i2 = this.e;
        this.e = i2 + 1;
        iArr[i2] = 0;
        return i;
    }

    public String toString() {
        if (empty()) {
            return "";
        }
        int i;
        StringBuilder stringBuilder = new StringBuilder("[");
        for (i = this.e; i < this.f; i++) {
            stringBuilder.append(String.valueOf(this.d[i]) + ",");
        }
        i = stringBuilder.length();
        return stringBuilder.delete(i - 1, i).append("]").toString();
    }
}
