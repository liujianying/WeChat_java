package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.a.a;

class a$a$5 implements Runnable {
    final /* synthetic */ int arA;
    final /* synthetic */ Object arB;
    final /* synthetic */ a arF;
    final /* synthetic */ long arK;
    final /* synthetic */ int ary;
    final /* synthetic */ Format arz;

    public a$a$5(a aVar, int i, Format format, int i2, Object obj, long j) {
        this.arF = aVar;
        this.ary = i;
        this.arz = format;
        this.arA = i2;
        this.arB = obj;
        this.arK = j;
    }

    public final void run() {
        a.a(this.arF, this.arK);
    }
}
