package com.google.android.exoplayer2;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.source.i;

public interface r extends b {
    void a(t tVar, Format[] formatArr, i iVar, long j, boolean z, long j2);

    void a(Format[] formatArr, i iVar, long j);

    void c(long j, long j2);

    void disable();

    int getState();

    int getTrackType();

    boolean hv();

    boolean iT();

    s ip();

    f iq();

    i ir();

    boolean is();

    void it();

    boolean iu();

    void iv();

    void m(long j);

    void setIndex(int i);

    void start();

    void stop();
}
