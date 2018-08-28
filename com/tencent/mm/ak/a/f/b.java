package com.tencent.mm.ak.a.f;

import android.graphics.Bitmap;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.c.a;
import com.tencent.mm.ak.a.c.d;
import com.tencent.mm.ak.a.c.e;
import com.tencent.mm.ak.a.c.f;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.ak.a.c.j;
import com.tencent.mm.ak.a.c.k;
import com.tencent.mm.ak.a.c.l;
import com.tencent.mm.ak.a.c.m;
import com.tencent.mm.ak.a.c.n;
import com.tencent.mm.ak.a.c.o;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b implements Runnable {
    private final com.tencent.mm.ak.a.a.b dWS = this.dYi.dWS;
    public final c dXk;
    private final m dXl;
    private final a dXm;
    private final com.tencent.mm.ak.a.c.b dXn;
    private final j dXp;
    private final e dXr;
    private final n dXu;
    private final o dYb;
    private final com.tencent.mm.ak.a.b dYi;
    public final com.tencent.mm.ak.a.c dYk;
    private final ag dYl;
    private final i dYm;
    private final g dYn;
    private final f dYo;
    private final k dYp;
    private final d dYq;
    private final l dYr;
    public final String url;

    public b(String str, com.tencent.mm.ak.a.c cVar, ag agVar, c cVar2, i iVar, j jVar, com.tencent.mm.ak.a.b bVar, g gVar, e eVar, d dVar, l lVar) {
        this.url = str;
        this.dYk = cVar;
        this.dYl = agVar;
        this.dYi = bVar;
        this.dYn = gVar;
        if (cVar2 == null) {
            this.dXk = this.dWS.dXk;
        } else {
            this.dXk = cVar2;
        }
        this.dYm = iVar;
        if (jVar == null) {
            this.dXp = this.dWS.dXp;
        } else {
            this.dXp = jVar;
        }
        if (this.dXk.dXn != null) {
            this.dXn = this.dXk.dXn;
        } else {
            this.dXn = this.dWS.dXn;
        }
        this.dYb = this.dXk.dYb;
        this.dXl = this.dWS.dXl;
        this.dXm = this.dWS.dXm;
        this.dYo = this.dWS.dXo;
        this.dYp = this.dWS.dXq;
        if (eVar == null) {
            this.dXr = this.dWS.dXr;
        } else {
            this.dXr = eVar;
        }
        this.dYq = dVar;
        this.dYr = lVar;
        this.dXu = this.dWS.dXu;
    }

    public final void run() {
        Bitmap bitmap = null;
        com.tencent.mm.ak.a.d.b bVar = new com.tencent.mm.ak.a.d.b();
        bVar.bJu = 1;
        Bitmap b;
        InputStream inputStream;
        Exception e;
        com.tencent.mm.ak.a.d.b bVar2;
        try {
            o oVar;
            long currentTimeMillis;
            String mg = mg(this.url);
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk. key:%s", new Object[]{this.url});
            long currentTimeMillis2 = System.currentTimeMillis();
            int i = this.dXk.dXD;
            boolean z = this.dXk.dXG;
            String str = this.dXk.bKg;
            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: should check md5:" + z);
            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: fileType: %d", new Object[]{Integer.valueOf(i)});
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] test view width:%d height:%d", new Object[]{Integer.valueOf(this.dYk.width), Integer.valueOf(this.dYk.height)});
            switch (i) {
                case 1:
                    String str2 = this.dXk.bOX;
                    if (!this.dXk.dXK || bi.oW(str2) || !com.tencent.mm.vfs.d.cn(str2)) {
                        if (!bi.oW(this.url)) {
                            if (!com.tencent.mm.vfs.d.cn(this.url)) {
                                if (this.dXk.dXL) {
                                    this.dXr.g(this.dXk.dYc);
                                }
                                x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] file does not exist.");
                                break;
                            }
                            if (z) {
                                if (!this.dYp.ap(str, this.url)) {
                                    x.w("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check failed");
                                    bitmap = null;
                                    break;
                                }
                            }
                            if (this.dXk.dXY) {
                                b = com.tencent.mm.ak.a.g.a.b(this.dYk, this.url, this.dXk.dXE, this.dXk.dXF);
                            } else if (this.dYb != null) {
                                inputStream = null;
                                oVar = this.dYb;
                                com.tencent.mm.vfs.c cVar = new com.tencent.mm.vfs.c(this.url);
                                inputStream = oVar.Pv();
                                b = com.tencent.mm.ak.a.g.a.a(this.dYk, inputStream, this.dXk.dXE, this.dXk.dXF, this.dXk.dXM, this.dXk.alpha, this.dXk.dXH);
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e2) {
                                    }
                                }
                            } else {
                                b = this.dYq != null ? com.tencent.mm.ak.a.g.a.a(this.dYk, this.dYq.h(this.dXk.dYc), this.dXk.dXE, this.dXk.dXF, this.dXk.dXM, this.dXk.alpha, this.dXk.dXH) : com.tencent.mm.ak.a.g.a.a(this.dYk, this.url, this.dXk.dXE, this.dXk.dXF);
                            }
                            if (this.dXk.dYa && r4 == null && this.dYr != null) {
                                if (this.dYq != null) {
                                    b = this.dYr.K(this.dYq.h(this.dXk.dYc));
                                } else {
                                    b = this.dYr.mf(this.url);
                                }
                            }
                            if (b != null && this.dXk.density > 0) {
                                b.setDensity(this.dXk.density);
                            }
                            x.d("MicroMsg.imageloader.ImageLoadTask", "hy: file md5 check success or do not need md5 check");
                            bitmap = b;
                            break;
                        }
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] url is null.");
                        break;
                    }
                    if (this.dXk.dXY) {
                        b = com.tencent.mm.ak.a.g.a.b(this.dYk, str2, this.dXk.dXE, this.dXk.dXF);
                    } else {
                        b = com.tencent.mm.ak.a.g.a.a(this.dYk, str2, this.dXk.dXE, this.dXk.dXF);
                    }
                    try {
                        if (this.dXk.density > 0) {
                            b.setDensity(this.dXk.density);
                            bitmap = b;
                            break;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bVar2 = bVar;
                        break;
                    }
                    break;
                case 2:
                    bitmap = com.tencent.mm.ak.a.g.a.c(this.dYk, this.url, this.dXk.dXE, this.dXk.dXF);
                    break;
                case 3:
                    bitmap = com.tencent.mm.ak.a.g.a.a(this.dYk, this.dWS.dXh.getIdentifier(this.url, "drawable", this.dWS.packageName), this.dXk.dXE, this.dXk.dXF);
                    break;
                case 4:
                    bitmap = com.tencent.mm.ak.a.g.a.a(this.dYk, Integer.valueOf(this.url).intValue(), this.dXk.dXE, this.dXk.dXF);
                    break;
                case 5:
                    inputStream = null;
                    Object obj = null;
                    inputStream = this.dXm.d(this.url, this.dXk);
                    if (inputStream == null) {
                        b = null;
                    } else if (!z || this.dYp.b(str, inputStream)) {
                        if (this.dYb != null) {
                            inputStream = this.dYb.Pv();
                        }
                        b = com.tencent.mm.ak.a.g.a.a(this.dYk, inputStream, this.dXk.dXE, this.dXk.dXF, this.dXk.dXM, this.dXk.alpha, this.dXk.dXH);
                        obj = 1;
                    } else {
                        obj = 1;
                        b = null;
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e4) {
                        }
                    }
                    if (obj != null && b == null) {
                        this.dXm.c(this.url, this.dXk);
                        bitmap = b;
                        break;
                    }
                    break;
                default:
                    x.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] unknow file type :%d", new Object[]{Integer.valueOf(i)});
                    break;
            }
            bitmap = b;
            try {
                currentTimeMillis = System.currentTimeMillis();
            } catch (Exception e5) {
                e = e5;
                bVar2 = bVar;
                b = bitmap;
            }
            Bitmap bitmap2;
            String str3;
            int min;
            i iVar;
            com.tencent.mm.ak.a.b bVar3;
            if (bitmap == null || bitmap.isRecycled()) {
                switch (i) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run get bitmap failed");
                        bitmap2 = bitmap;
                        break;
                    case 5:
                        currentTimeMillis2 = System.currentTimeMillis();
                        x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from memory failed.now try to get from network.");
                        if (this.dYn != null) {
                            g gVar = this.dYn;
                            str3 = this.url;
                            this.dYk.getImageView();
                            gVar.me(str3);
                        }
                        if (this.dXu.md(this.url)) {
                            bVar2 = this.dXn.mb(this.url);
                        } else {
                            x.i("MicroMsg.imageloader.ImageLoadTask", "can not download image, over limit");
                            bVar2 = bVar;
                        }
                        if (bVar2 == null) {
                            try {
                                bVar = new com.tencent.mm.ak.a.d.b(null, null);
                            } catch (Exception e6) {
                                e = e6;
                                b = bitmap;
                                break;
                            }
                        }
                        bVar = bVar2;
                        try {
                            bVar.bJu = 2;
                            if (bVar.data != null) {
                                if (z) {
                                    if (!this.dYp.j(str, bVar.data)) {
                                        bVar.status = 2;
                                        x.w("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check failed");
                                        bitmap2 = null;
                                        break;
                                    }
                                }
                                x.d("MicroMsg.imageloader.ImageLoadTask", "hy: image data md5 check success or do not need md5 check");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                byte[] bArr = bVar.data;
                                if (this.dYb != null) {
                                    oVar = this.dYb;
                                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                                    InputStream Pv = oVar.Pv();
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                                    bArr = new byte[1024];
                                    while (true) {
                                        int read = Pv.read(bArr);
                                        if (read >= 0) {
                                            byteArrayOutputStream.write(bArr, 0, read);
                                        } else {
                                            bArr = byteArrayOutputStream.toByteArray();
                                        }
                                    }
                                }
                                b = com.tencent.mm.ak.a.g.a.a(this.dYk, bArr, this.dXk.dXE, this.dXk.dXF, this.dXk.dXM, this.dXk.alpha, this.dXk.dXH);
                                if (b != null) {
                                    byte[] bArr2 = bVar.data;
                                    if (this.dXk.dXy) {
                                        this.dXm.a(this.url, bArr2, this.dXk);
                                    }
                                    if (this.dXk.dXx) {
                                        this.dXm.a(this.url, bArr2, this.dXk);
                                    }
                                    if (this.dXk.dXW) {
                                        if (this.dXk.dXX != 0.0f) {
                                            b = com.tencent.mm.sdk.platformtools.c.a(b, false, this.dXk.dXX);
                                        } else if (b.getWidth() == b.getHeight()) {
                                            b = com.tencent.mm.sdk.platformtools.c.a(b, false, (float) (b.getWidth() / 2));
                                        } else {
                                            min = Math.min(b.getWidth(), b.getHeight());
                                            if (min <= 0) {
                                                min = Math.max(b.getWidth(), b.getHeight());
                                            }
                                            b = com.tencent.mm.sdk.platformtools.c.a(b, min, min, true);
                                            b = com.tencent.mm.sdk.platformtools.c.a(b, false, (float) (b.getWidth() / 2));
                                        }
                                    }
                                    b = a(bVar, b);
                                    k(mg, b);
                                    bv(currentTimeMillis3 - currentTimeMillis2);
                                    bitmap2 = b;
                                    break;
                                }
                                try {
                                    bVar.status = 3;
                                    bitmap2 = b;
                                    break;
                                } catch (Exception e7) {
                                    e = e7;
                                    bVar2 = bVar;
                                    break;
                                }
                            }
                            bVar.status = 1;
                            bitmap2 = bitmap;
                            break;
                        } catch (Exception e8) {
                            e = e8;
                            bVar2 = bVar;
                            b = bitmap;
                            break;
                        }
                    default:
                        x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run unknow file type");
                        bitmap2 = bitmap;
                        break;
                }
                x.e("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. exception. %s", new Object[]{e.toString()});
                bVar = bVar2;
                bitmap2 = b;
                if (bitmap2 != null || bitmap2.isRecycled()) {
                    x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
                } else {
                    x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap successs.");
                    if (this.dXk.dXI) {
                        bitmap2 = com.tencent.mm.sdk.platformtools.c.e(bitmap2, this.dXk.dXJ);
                    }
                    c cVar2 = new c(this.url, this.dYk, bitmap2, this.dYi, mg(this.url));
                    if (this.dYl != null) {
                        this.dYl.post(cVar2);
                    }
                    bVar.bitmap = bitmap2;
                }
                if (!(this.dYn == null || bVar == null)) {
                    bVar.bitmap = bitmap2;
                    this.dYn.a(this.url, this.dYk.getImageView(), bVar);
                }
                iVar = this.dYm;
                str3 = this.url;
                this.dYk.getImageView();
                iVar.a(str3, bitmap2, this.dXk.dYc);
                bVar3 = this.dYi;
                if (bVar3.dWW != null && this != null && this.dYk != null) {
                    bVar3.dWW.remove(Integer.valueOf(this.dYk.Pr()));
                    return;
                }
                return;
            }
            if (!this.dXk.dXW) {
                b = bitmap;
            } else if (this.dXk.dXX != 0.0f) {
                b = com.tencent.mm.sdk.platformtools.c.a(bitmap, false, this.dXk.dXX);
            } else if (bitmap.getWidth() == bitmap.getHeight()) {
                b = com.tencent.mm.sdk.platformtools.c.a(bitmap, false, (float) (bitmap.getWidth() / 2));
            } else {
                min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                if (min <= 0) {
                    min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                }
                b = com.tencent.mm.sdk.platformtools.c.a(bitmap, min, min, true);
                b = com.tencent.mm.sdk.platformtools.c.a(b, false, (float) (b.getWidth() / 2));
            }
            b = a(bVar, b);
            k(mg, b);
            bv(currentTimeMillis - currentTimeMillis2);
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap from disk success.");
            bitmap2 = b;
            if (bitmap2 != null) {
            }
            x.w("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. get bitmap failed");
            bVar.bitmap = bitmap2;
            this.dYn.a(this.url, this.dYk.getImageView(), bVar);
            iVar = this.dYm;
            str3 = this.url;
            this.dYk.getImageView();
            iVar.a(str3, bitmap2, this.dXk.dYc);
            bVar3 = this.dYi;
            if (bVar3.dWW != null) {
            }
        } catch (Exception e9) {
            e = e9;
            bVar2 = bVar;
            b = null;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                }
            }
        }
    }

    private void k(String str, Bitmap bitmap) {
        if (this.dXk.dXw) {
            x.d("MicroMsg.imageloader.ImageLoadTask", "[cpan] run. put key %s to memory cache.", new Object[]{this.url});
            this.dXl.d(str, bitmap);
        }
    }

    private Bitmap a(com.tencent.mm.ak.a.d.b bVar, Bitmap bitmap) {
        if (this.dYn == null || bVar == null) {
            return bitmap;
        }
        bVar.bitmap = bitmap;
        g gVar = this.dYn;
        String str = this.url;
        this.dYk.getImageView();
        Bitmap a = gVar.a(str, bVar);
        if (a == null || a.isRecycled()) {
            return bitmap;
        }
        return a;
    }

    public final String mg(String str) {
        if (bi.oW(str) || this.dXk == null) {
            return null;
        }
        if (this.dXk.dXW) {
            str = str + "round" + this.dXk.dXX;
        }
        if (!bi.oW(this.dXk.dXT)) {
            str = str + this.dXk.dXT;
        }
        return str + "size" + this.dXk.dXE + this.dXk.dXF;
    }

    public final void bv(long j) {
        if (this.dXp != null) {
            this.dXp.bv(j);
        }
    }
}
