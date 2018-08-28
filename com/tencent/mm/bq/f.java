package com.tencent.mm.bq;

import android.util.SparseIntArray;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class f {
    SparseIntArray sCU;
    byte[] sCV;

    private f(SparseIntArray sparseIntArray, byte[] bArr) {
        this.sCU = sparseIntArray;
        this.sCV = bArr;
    }

    public static f a(SparseIntArray sparseIntArray, InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        try {
            if (inputStream.read(bArr, 0, bArr.length) != bArr.length) {
                x.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. data length no equal.");
            }
            return new f(sparseIntArray, bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringsCollection", "[cpan] newStringsCollection failed. %s", bi.i(e));
            return null;
        }
    }

    public final String getString(int i) {
        String str;
        try {
            int indexOfKey = this.sCU.indexOfKey(i);
            if (indexOfKey < 0) {
                return null;
            }
            int valueAt;
            int valueAt2 = this.sCU.valueAt(indexOfKey);
            if (indexOfKey < this.sCU.size() - 1) {
                valueAt = this.sCU.valueAt(indexOfKey + 1) - valueAt2;
            } else {
                valueAt = this.sCV.length - valueAt2;
            }
            str = new String(this.sCV, valueAt2, valueAt, "UTF-8");
            return str;
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bi.i(e));
            str = null;
        } catch (Throwable e2) {
            x.e("MicroMsg.language.StringsCollection", "[cpan] getString failed. %s", bi.i(e2));
            str = null;
        }
    }
}
