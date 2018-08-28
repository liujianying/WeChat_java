package com.tencent.c.e.a;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.c.e.a.a.b;
import com.tencent.c.e.a.a.c;
import com.tencent.c.e.a.a.h;
import com.tencent.c.e.a.b.a;
import com.tencent.c.f.f;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

class e$3 extends c {
    final /* synthetic */ int bAM;
    final /* synthetic */ int nmN;
    final /* synthetic */ e vjJ;
    final /* synthetic */ int vjK;
    final /* synthetic */ SparseArray vjL;
    final /* synthetic */ List vjM;

    e$3(e eVar, int i, int i2, int i3, SparseArray sparseArray, List list) {
        this.vjJ = eVar;
        this.vjK = i;
        this.bAM = i2;
        this.nmN = i3;
        this.vjL = sparseArray;
        this.vjM = list;
    }

    public final void cFm() {
        Closeable closeable;
        Throwable th;
        try {
            a a;
            synchronized (this.vjJ) {
                a = b.a(this.vjK, this.bAM, e.a(this.vjJ).context, this.nmN, this.vjL, this.vjM);
            }
            h cFs = h.cFs();
            int i = this.vjK;
            int i2 = this.bAM;
            byte[] j = com.tencent.c.f.c.j(com.tencent.c.f.b.r(a.toByteArray()), com.tencent.c.f.c.k());
            if (j != null) {
                File dir = cFs.mContext.getDir("turingmm", 0);
                Object obj = dir == null ? "" : dir.getAbsolutePath() + File.separator + h.fF(i, i2) + "_" + System.currentTimeMillis();
                if (!TextUtils.isEmpty(obj)) {
                    Closeable closeable2 = null;
                    try {
                        Closeable bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(obj));
                        try {
                            bufferedOutputStream.write(j);
                            bufferedOutputStream.flush();
                            f.b(bufferedOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            closeable2 = bufferedOutputStream;
                            f.b(closeable2);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        f.b(closeable2);
                        throw th;
                    }
                    obj = cFs.fE(i, i2);
                    if (TextUtils.isEmpty(obj)) {
                        new File(obj).delete();
                    }
                }
            }
            if (e.h(this.vjJ) == null) {
                e.h(this.vjJ);
            }
        } catch (IllegalArgumentException e) {
        }
    }

    public final void cFn() {
        if (e.f(this.vjJ) != null) {
            e.f(this.vjJ);
        }
    }
}
