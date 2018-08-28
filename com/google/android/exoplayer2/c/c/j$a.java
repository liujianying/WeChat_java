package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.h.a;
import com.google.android.exoplayer2.i.h.b;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;

final class j$a {
    final k alX;
    final boolean anA;
    final boolean anB;
    final SparseArray<b> anH = new SparseArray();
    final SparseArray<a> anI = new SparseArray();
    final com.google.android.exoplayer2.i.k anJ = new com.google.android.exoplayer2.i.k(this.buffer, 0, 0);
    int anK;
    int anL;
    long anM;
    long anN;
    a anO = new a((byte) 0);
    a anP = new a((byte) 0);
    boolean anQ;
    long anl;
    long ant;
    boolean anu;
    boolean anx;
    byte[] buffer = new byte[MapRouteSectionWithName.kMaxRoadNameLength];

    public j$a(k kVar, boolean z, boolean z2) {
        this.alX = kVar;
        this.anA = z;
        this.anB = z2;
        reset();
    }

    public final void a(b bVar) {
        this.anH.append(bVar.aCg, bVar);
    }

    public final void a(a aVar) {
        this.anI.append(aVar.anX, aVar);
    }

    public final void reset() {
        this.anx = false;
        this.anQ = false;
        this.anP.clear();
    }
}
