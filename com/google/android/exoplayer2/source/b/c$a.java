package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.source.a.c;
import java.util.Arrays;

final class c$a extends c {
    public final String atm;
    byte[] atn;

    public c$a(f fVar, i iVar, Format format, int i, Object obj, byte[] bArr, String str) {
        super(fVar, iVar, format, i, obj, bArr);
        this.atm = str;
    }

    protected final void e(byte[] bArr, int i) {
        this.atn = Arrays.copyOf(bArr, i);
    }
}
