package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.util.SparseArray;
import com.tencent.mm.protocal.c.anp;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d {
    boolean iWf = true;
    private File jAG;
    List<RandomAccessFile> jAH;
    SparseArray<anq> jAI;
    int jAJ;

    d(File file) {
        if (!file.isDirectory()) {
            boolean mkdirs = file.mkdirs();
            x.d("MicroMsg.DiskCache", "dir[%s] not exist, try to create it, result[%B]", new Object[]{file.getAbsolutePath(), Boolean.valueOf(mkdirs)});
        }
        this.jAG = file;
        this.jAI = new SparseArray();
    }

    final void aRn() {
        File file = new File(this.jAG, "cache.idx");
        anp anp = new anp();
        String absolutePath = file.getAbsolutePath();
        if (!bi.oW(absolutePath)) {
            try {
                anp.aG(bi.readFromFile(absolutePath));
            } catch (Throwable e) {
                x.e("MicroMsg.DiskCache", "load index file error");
                x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                qp(-1);
                anp = new anp();
            } catch (Throwable e2) {
                x.e("MicroMsg.DiskCache", "load index file error, OOM, index length %s", new Object[]{Long.valueOf(file.length())});
                x.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                qp(-1);
                anp = new anp();
            }
        }
        this.jAI.clear();
        Iterator it = anp.rQq.iterator();
        while (it.hasNext()) {
            anq anq = (anq) it.next();
            this.jAI.put(anq.key, anq);
        }
    }

    final synchronized void qo(int i) {
        synchronized (this) {
            if (i >= 0) {
                try {
                    if (this.jAH != null) {
                        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.jAG, qr(i)), "rw");
                        this.jAH.remove(i);
                        this.jAH.add(i, randomAccessFile);
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.DiskCache", "create data file error: %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    this.jAH = null;
                }
            }
            this.jAH = new ArrayList();
            for (int i2 = 0; i2 < 25; i2++) {
                this.jAH.add(new RandomAccessFile(new File(this.jAG, qr(i2)), "rw"));
            }
        }
        return;
    }

    final void qp(int i) {
        int i2 = 0;
        if (this.jAH != null && this.jAH.size() > 0) {
            if (i < 0) {
                new File(this.jAG, "cache.idx").delete();
                this.jAI.clear();
            } else {
                SparseArray sparseArray = new SparseArray();
                for (int i3 = 0; i3 < this.jAI.size(); i3++) {
                    anq anq = (anq) this.jAI.valueAt(i3);
                    if (anq.rQs != i) {
                        sparseArray.put(this.jAI.keyAt(i3), anq);
                    }
                    x.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d]}", new Object[]{Integer.valueOf(anq.key), Long.valueOf(anq.rQr), Integer.valueOf(anq.length)});
                }
                this.jAI = sparseArray;
                aRo();
            }
            if (i < 0) {
                aRp();
                while (i2 < 25) {
                    new File(this.jAG, qr(25)).delete();
                    i2++;
                }
                return;
            }
            f((Closeable) this.jAH.get(i));
            new File(this.jAG, qr(i)).delete();
        }
    }

    static void f(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable e) {
                x.e("MicroMsg.DiskCache", "want close %s fail: %s", new Object[]{closeable.getClass().getName(), e.getMessage()});
                x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            }
        }
    }

    final void aRo() {
        anp anp = new anp();
        for (int i = 0; i < this.jAI.size(); i++) {
            anp.rQq.add(0, (anq) this.jAI.valueAt(i));
            x.v("MicroMsg.DiskCache", "index info{key[%s] beg[%d] length[%d] file_suffix[%d]}", new Object[]{Integer.valueOf(r0.key), Long.valueOf(r0.rQr), Integer.valueOf(r0.length), Integer.valueOf(r0.rQs)});
        }
        try {
            bi.r(new File(this.jAG, "cache.idx").getAbsolutePath(), anp.toByteArray());
        } catch (Throwable e) {
            x.e("MicroMsg.DiskCache", "save index data error: %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
        }
    }

    final synchronized void aRp() {
        if (this.jAH != null && this.jAH.size() > 0) {
            for (RandomAccessFile f : this.jAH) {
                f(f);
            }
        }
    }

    public final Bitmap qq(int i) {
        if (this.jAH == null || this.jAH.size() <= 0) {
            x.e("MicroMsg.DiskCache", "want to get bitmap, but data file is null");
            return null;
        }
        anq anq = (anq) this.jAI.get(i);
        if (anq == null) {
            return null;
        }
        byte[] bArr = new byte[anq.length];
        try {
            x.d("MicroMsg.DiskCache", "read data, beg pos %d, length %d", new Object[]{Long.valueOf(anq.rQr), Integer.valueOf(anq.length)});
            RandomAccessFile randomAccessFile = (RandomAccessFile) this.jAH.get(anq.rQs);
            randomAccessFile.seek(anq.rQr);
            randomAccessFile.read(bArr, 0, anq.length);
            Bitmap bs = c.bs(bArr);
            if (bs != null) {
                x.d("MicroMsg.DiskCache", "get bitmap from disk cache ok, wh[%d, %d]", new Object[]{Integer.valueOf(bs.getWidth()), Integer.valueOf(bs.getHeight())});
                return bs;
            }
            this.jAI.remove(i);
            return bs;
        } catch (Throwable e) {
            x.w("MicroMsg.DiskCache", "read data fail, key[%d]: %s", new Object[]{Integer.valueOf(i), e.getMessage()});
            x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
            this.jAI.remove(i);
            return null;
        }
    }

    private static String qr(int i) {
        return "cache.data" + (i == 0 ? "" : "." + i);
    }

    public final synchronized int aRq() {
        int i = 0;
        synchronized (this) {
            if (this.jAH != null && this.jAH.size() > 0) {
                try {
                    int i2 = -1;
                    for (RandomAccessFile length : this.jAH) {
                        i2++;
                        if (length.length() < 2097152) {
                            i = i2;
                            break;
                        }
                    }
                    i = -1;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.DiskCache", e, "", new Object[0]);
                    i = -1;
                }
            }
        }
        return i;
    }

    public final void aRr() {
        ad.getContext().getSharedPreferences(ad.chY(), 0).edit().putInt("com.tencent.mm.gallery.cache.suffix", this.jAJ).commit();
    }
}
