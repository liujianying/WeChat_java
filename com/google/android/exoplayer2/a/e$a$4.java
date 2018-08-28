package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;

class e$a$4 implements Runnable {
    final /* synthetic */ a afE;
    final /* synthetic */ int afJ;
    final /* synthetic */ long afK;
    final /* synthetic */ long afL;

    e$a$4(a aVar, int i, long j, long j2) {
        this.afE = aVar;
        this.afJ = i;
        this.afK = j;
        this.afL = j2;
    }

    public final void run() {
        this.afE.afC.c(this.afJ, this.afK, this.afL);
    }
}
