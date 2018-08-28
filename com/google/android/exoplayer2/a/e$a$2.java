package com.google.android.exoplayer2.a;

import com.google.android.exoplayer2.a.e.a;

class e$a$2 implements Runnable {
    final /* synthetic */ a afE;
    final /* synthetic */ String afF;
    final /* synthetic */ long afG;
    final /* synthetic */ long afH;

    e$a$2(a aVar, String str, long j, long j2) {
        this.afE = aVar;
        this.afF = str;
        this.afG = j;
        this.afH = j2;
    }

    public final void run() {
        this.afE.afC.b(this.afF, this.afG, this.afH);
    }
}
