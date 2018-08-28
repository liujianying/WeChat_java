package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a.a;

class a$a$1 implements Runnable {
    final /* synthetic */ int arA;
    final /* synthetic */ Object arB;
    final /* synthetic */ long arC;
    final /* synthetic */ long arD;
    final /* synthetic */ long arE;
    final /* synthetic */ a arF;
    final /* synthetic */ i arw;
    final /* synthetic */ int arx;
    final /* synthetic */ int ary;
    final /* synthetic */ Format arz;

    public a$a$1(a aVar, i iVar, int i, int i2, Format format, int i3, Object obj, long j, long j2, long j3) {
        this.arF = aVar;
        this.arw = iVar;
        this.arx = i;
        this.ary = i2;
        this.arz = format;
        this.arA = i3;
        this.arB = obj;
        this.arC = j;
        this.arD = j2;
        this.arE = j3;
    }

    public final void run() {
        a.a(this.arF, this.arC);
        a.a(this.arF, this.arD);
    }
}
