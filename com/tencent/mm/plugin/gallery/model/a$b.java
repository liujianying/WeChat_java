package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.protocal.c.anq;
import com.tencent.mm.sdk.platformtools.at.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.RandomAccessFile;

class a$b implements a {
    private int bMT;
    private Bitmap bitmap;
    final /* synthetic */ a jAj;
    private String jAm;
    private long jAn;
    private int jAo;
    String mFilePath;

    public a$b(a aVar, String str, int i, String str2, long j) {
        this(aVar, str, i, str2, j, (byte) 0);
    }

    private a$b(a aVar, String str, int i, String str2, long j, byte b) {
        this.jAj = aVar;
        this.mFilePath = str;
        this.jAn = j;
        this.jAm = str2;
        this.jAo = 12288;
        this.bMT = i;
    }

    public final boolean Kr() {
        b a = a.a(this.jAj);
        String str = this.mFilePath;
        String str2 = this.jAm;
        long j = this.jAn;
        this.bitmap = a.jAq == null ? null : a.jAq.qq(String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)}).hashCode());
        if (this.bitmap != null) {
            x.d("MircoMsg.CacheService", "get bmp from disk cache ok, filePath[%s]", new Object[]{this.mFilePath});
            return true;
        }
        this.bitmap = j.a(this.jAn, this.bMT, this.mFilePath, this.jAm);
        if (this.bitmap == null) {
            return false;
        }
        a = a.a(this.jAj);
        str = this.mFilePath;
        str2 = this.jAm;
        j = this.jAn;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            str = String.format("%s-%s-%d", new Object[]{str, str2, Long.valueOf(j)});
            if (a.jAq != null) {
                d dVar = a.jAq;
                int hashCode = str.hashCode();
                if (dVar.jAH == null || dVar.jAH.size() <= 0) {
                    x.e("MicroMsg.DiskCache", "want to put bitmap, but data file is null");
                } else if (bitmap == null) {
                    x.e("MicroMsg.DiskCache", "put bmp, value error: null");
                } else {
                    int i;
                    x.d("MicroMsg.DiskCache", "put bmp key[%d] size[%d, %d]", new Object[]{Integer.valueOf(hashCode), Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
                    if (dVar.jAH == null || dVar.jAH.size() <= 0) {
                        i = -1;
                    } else {
                        int aRq = dVar.aRq();
                        if (aRq < 0) {
                            x.d("MicroMsg.DiskCache", "jacks check Data Size currentSuffix: %d", new Object[]{Integer.valueOf(dVar.jAJ)});
                            aRq = dVar.jAJ + 1 >= 25 ? 0 : dVar.jAJ + 1;
                            x.d("MicroMsg.DiskCache", "jacks reset Index and Data: %d", new Object[]{Integer.valueOf(aRq)});
                            dVar.qp(aRq);
                            dVar.qo(aRq);
                        }
                        i = aRq;
                    }
                    if (i < 0) {
                        x.e("MicroMsg.DiskCache", "put bmp, file suffix < 0");
                    } else {
                        Object obj;
                        anq anq = (anq) dVar.jAI.get(hashCode);
                        if (anq == null) {
                            anq = new anq();
                            anq.key = hashCode;
                            obj = anq;
                        } else {
                            anq obj2 = anq;
                        }
                        Closeable byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                            try {
                                long currentTimeMillis = System.currentTimeMillis();
                                RandomAccessFile randomAccessFile = (RandomAccessFile) dVar.jAH.get(i);
                                obj2.rQr = randomAccessFile.length();
                                obj2.rQs = i;
                                obj2.length = byteArrayOutputStream.size();
                                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                                randomAccessFile.seek(obj2.rQr);
                                randomAccessFile.write(toByteArray);
                                dVar.jAJ = i;
                                x.d("MicroMsg.DiskCache", "jacks [time: %d]save data ok, key[%d] beg pos %d, length %d, file_suffix %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(obj2.key), Long.valueOf(obj2.rQr), Integer.valueOf(obj2.length), Integer.valueOf(obj2.rQs)});
                                dVar.iWf = true;
                                dVar.jAI.put(hashCode, obj2);
                            } catch (Exception e) {
                                obj2 = "write data error:%s";
                                x.e("MicroMsg.DiskCache", obj2, new Object[]{e.getMessage()});
                            } finally {
                                d.f(byteArrayOutputStream);
                            }
                        } catch (Throwable e2) {
                            x.e("MicroMsg.DiskCache", "compress bmp error:%s", new Object[]{e2.getMessage()});
                            x.printErrStackTrace("MicroMsg.DiskCache", e2, "", new Object[0]);
                            d.f(byteArrayOutputStream);
                        }
                    }
                }
            }
        }
        return true;
    }

    public final boolean Ks() {
        x.d("MircoMsg.CacheService", "do on post execute, filePath[%s]", new Object[]{this.mFilePath});
        a.b(this.jAj).bB(this.mFilePath);
        x.v("MircoMsg.CacheService", "remove filePathInService at position 0 : now position:[%d]", new Object[]{Integer.valueOf(a.b(this.jAj).size())});
        if (this.bitmap == null) {
            x.e("MircoMsg.CacheService", "decode file failed, %s ", new Object[]{this.mFilePath});
            return false;
        }
        b a = a.a(this.jAj);
        String str = this.mFilePath;
        Bitmap bitmap = this.bitmap;
        int i = this.jAo;
        if (a.jAp == null) {
            x.e("MicroMsg.GalleryCache", "cache is null");
        } else {
            a.jAp.m(str, new b.a(a, bitmap, i));
            a.dHn.ci(str);
            a.dHn.doNotify();
        }
        this.bitmap = null;
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a$b)) {
            return false;
        }
        return bi.aG(this.mFilePath, "").equals(((a$b) obj).mFilePath);
    }

    public final int hashCode() {
        return bi.aG(this.mFilePath, "").hashCode();
    }
}
