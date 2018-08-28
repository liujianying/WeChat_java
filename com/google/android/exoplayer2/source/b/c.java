package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.l;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

final class c {
    byte[] aiS;
    byte[] asU;
    final f asX;
    final f asY;
    final k asZ;
    final a[] ata;
    final e atb;
    final l atc;
    final List<Format> atd;
    boolean ate;
    byte[] atf;
    IOException atg;
    a ath;
    boolean ati;
    Uri atj;
    String atk;
    com.google.android.exoplayer2.g.e atl;

    public c(e eVar, a[] aVarArr, d dVar, k kVar, List<Format> list) {
        this.atb = eVar;
        this.ata = aVarArr;
        this.asZ = kVar;
        this.atd = list;
        Format[] formatArr = new Format[aVarArr.length];
        int[] iArr = new int[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            formatArr[i] = aVarArr[i].aep;
            iArr[i] = i;
        }
        this.asX = dVar.kT();
        this.asY = dVar.kT();
        this.atc = new l(formatArr);
        this.atl = new c(this.atc, iArr);
    }

    final void a(Uri uri, String str, byte[] bArr) {
        String substring;
        if (t.aC(str).startsWith("0x")) {
            substring = str.substring(2);
        } else {
            substring = str;
        }
        Object toByteArray = new BigInteger(substring, 16).toByteArray();
        Object obj = new byte[16];
        int length = toByteArray.length > 16 ? toByteArray.length - 16 : 0;
        System.arraycopy(toByteArray, length, obj, (16 - toByteArray.length) + length, toByteArray.length - length);
        this.atj = uri;
        this.aiS = bArr;
        this.atk = str;
        this.asU = obj;
    }
}
