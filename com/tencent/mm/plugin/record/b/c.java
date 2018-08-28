package com.tencent.mm.plugin.record.b;

import android.util.SparseArray;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.record.a.b;
import java.util.LinkedList;
import java.util.List;

public abstract class c<T extends b> {
    private boolean mrO = false;
    final int mrP = 3;
    private final int mrQ = 300000;
    private SparseArray<a> mrR = new SparseArray();
    private LinkedList<T> mrS = new LinkedList();
    private long mrT = 0;

    protected abstract void a(T t);

    protected abstract List<T> bqs();

    public final void run() {
        au.Em().H(new 1(this));
    }

    protected final void bqt() {
        this.mrO = false;
        run();
    }

    final void finish() {
        this.mrS.clear();
        this.mrR.clear();
        this.mrO = false;
    }
}
