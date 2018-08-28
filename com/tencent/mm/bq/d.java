package com.tencent.mm.bq;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class d {
    public byte[] hfA;
    public SparseArray<a> sCJ;

    static class a {
        public final int jxE;
        public final int[] sCK;

        public a(int i, int[] iArr) {
            this.jxE = i;
            this.sCK = iArr;
        }
    }

    private d(SparseArray<a> sparseArray, byte[] bArr) {
        this.sCJ = sparseArray;
        this.hfA = bArr;
    }

    public static d b(SparseArray<a> sparseArray, InputStream inputStream, int i) {
        try {
            byte[] bArr = new byte[i];
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                x.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed. data length no equal.");
            }
            return new d(sparseArray, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringArraysCollection", "[cpan] newPluralsConllection failed:%s", bi.i(e));
            return null;
        }
    }
}
