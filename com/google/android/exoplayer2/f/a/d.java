package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.e;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.a;
import java.util.LinkedList;
import java.util.PriorityQueue;

abstract class d implements e {
    private long art;
    private final LinkedList<h> axu = new LinkedList();
    final LinkedList<i> axv;
    private final PriorityQueue<h> axw;
    private h axx;

    protected abstract void a(h hVar);

    protected abstract boolean lo();

    protected abstract com.google.android.exoplayer2.f.d lp();

    public d() {
        int i = 0;
        for (int i2 = 0; i2 < 10; i2++) {
            this.axu.add(new h());
        }
        this.axv = new LinkedList();
        while (i < 2) {
            this.axv.add(new e(this));
            i++;
        }
        this.axw = new PriorityQueue();
    }

    public void O(long j) {
        this.art = j;
    }

    /* renamed from: lt */
    public h jA() {
        a.ap(this.axx == null);
        if (this.axu.isEmpty()) {
            return null;
        }
        this.axx = (h) this.axu.pollFirst();
        return this.axx;
    }

    /* renamed from: b */
    public void W(h hVar) {
        a.ao(hVar == this.axx);
        if (hVar.jx()) {
            c(hVar);
        } else {
            this.axw.add(hVar);
        }
        this.axx = null;
    }

    /* renamed from: ls */
    public i jB() {
        if (this.axv.isEmpty()) {
            return null;
        }
        while (!this.axw.isEmpty() && ((h) this.axw.peek()).aih <= this.art) {
            h hVar = (h) this.axw.poll();
            i iVar;
            if (hVar.jy()) {
                iVar = (i) this.axv.pollFirst();
                iVar.cf(4);
                c(hVar);
                return iVar;
            }
            a(hVar);
            if (lo()) {
                com.google.android.exoplayer2.f.d lp = lp();
                if (!hVar.jx()) {
                    iVar = (i) this.axv.pollFirst();
                    iVar.a(hVar.aih, lp, Long.MAX_VALUE);
                    c(hVar);
                    return iVar;
                }
            }
            c(hVar);
        }
        return null;
    }

    private void c(h hVar) {
        hVar.clear();
        this.axu.add(hVar);
    }

    public void flush() {
        this.art = 0;
        while (!this.axw.isEmpty()) {
            c((h) this.axw.poll());
        }
        if (this.axx != null) {
            c(this.axx);
            this.axx = null;
        }
    }

    public void release() {
    }
}
