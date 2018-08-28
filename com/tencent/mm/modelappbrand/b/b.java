package com.tencent.mm.modelappbrand.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelappbrand.b.d.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final String dFS;
    private final Map<h, String> dFM;
    private final Map<String, h> dFN;
    private final Map<Integer, String> dFO;
    private final d dFP;
    private final i dFQ;
    private final g dFR;

    public static class b implements h {
        public final void Kc() {
        }

        public void n(Bitmap bitmap) {
        }

        public final void Kd() {
        }

        public final String Ke() {
            return "DefaultLoadTarget";
        }
    }

    public interface i {
        void d(String str, Bitmap bitmap);

        Bitmap jz(String str);

        void k(Bitmap bitmap);
    }

    private static final class k implements a {
        final g dFR;
        final b dGe;
        final String dGg;
        private final f dGh;
        private final i dGi;
        private final e dGj;
        private final String dGk;
        boolean dGl;

        private k(String str, f fVar, b bVar, i iVar, g gVar, e eVar, String str2) {
            this.dGl = true;
            this.dGg = str;
            this.dGh = fVar;
            this.dGe = bVar;
            this.dGi = iVar;
            this.dFR = gVar;
            this.dGj = eVar;
            this.dGk = str2;
        }

        final String Ki() {
            return b.aa(this.dGk, Kj());
        }

        final String Kj() {
            return b.a(this.dGg, this.dGh, this.dGj);
        }

        final void Kk() {
            try {
                Bitmap Kl = Kl();
                if (Kl != null && !Kl.isRecycled()) {
                    this.dGe.dFP.jB(b.jw(this.dGg));
                    this.dGe.dFP.a(b.jw(this.dGg), this);
                    p(Kl);
                    this.dGe.dFP.jA(b.jw(this.dGg));
                }
            } catch (d e) {
                x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", new Object[]{e});
                this.dGe.dFP.jB(b.jw(this.dGg));
                this.dGe.dFP.jC(b.jw(this.dGg));
                p(null);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " doIOJobImpl, io exp ", new Object[0]);
                this.dGe.dFP.jB(b.jw(this.dGg));
                this.dGe.dFP.a(b.jw(this.dGg), this);
                this.dGe.dFP.jA(b.jw(this.dGg));
            }
        }

        public final void Kf() {
            final Bitmap jz = this.dGi.jz(Kj());
            if (jz == null || jz.isRecycled()) {
                d d = this.dGe.dFP;
                String access$1500 = b.jw(this.dGg);
                if (bi.oW(access$1500) ? false : d.dGd.containsKey(access$1500)) {
                    d d2 = this.dGe.dFP;
                    String access$15002 = b.jw(this.dGg);
                    if (!(bi.oW(access$15002) || this == null)) {
                        List list = (List) d2.dGc.get(access$15002);
                        if (list == null) {
                            list = new LinkedList();
                            d2.dGc.put(access$15002, list);
                        }
                        list.add(this);
                    }
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", new Object[]{b.jw(this.dGg)});
                    return;
                }
                d = this.dGe.dFP;
                String access$15003 = b.jw(this.dGg);
                if (!bi.oW(access$15003)) {
                    d.dGd.put(access$15003, Boolean.valueOf(true));
                }
                Kk();
                return;
            }
            x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", new Object[]{Kj()});
            ah.A(new Runnable() {
                public final void run() {
                    k.this.n(jz);
                }
            });
        }

        public final void Kg() {
            h hVar = (h) this.dGe.dFN.remove(Ki());
            if (hVar != null) {
                this.dGe.dFM.remove(hVar);
            }
        }

        final void n(Bitmap bitmap) {
            h hVar = (h) this.dGe.dFN.remove(Ki());
            if (hVar != null) {
                hVar.n(bitmap);
                this.dGe.dFM.remove(hVar);
            }
        }

        private void p(Bitmap bitmap) {
            boolean z = false;
            String str = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            String str2 = "postLoadInWorkerThread bitmap ok %b";
            Object[] objArr = new Object[1];
            boolean z2 = (bitmap == null || bitmap.isRecycled()) ? false : true;
            objArr[0] = Boolean.valueOf(z2);
            x.d(str, str2, objArr);
            if (!(this.dGh == null || bitmap == null || bitmap.isRecycled())) {
                Bitmap o = this.dGh.o(bitmap);
                x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", new Object[]{bitmap, o});
                if (o != bitmap) {
                    this.dGi.k(bitmap);
                }
                bitmap = o;
            }
            this.dGi.d(Kj(), bitmap);
            String str3 = "MicroMsg.AppBrandSimpleImageLoader.LoadTask";
            str = "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b";
            Object[] objArr2 = new Object[2];
            objArr2[0] = bitmap;
            if (!(bitmap == null || bitmap.isRecycled())) {
                z = true;
            }
            objArr2[1] = Boolean.valueOf(z);
            x.d(str3, str, objArr2);
            ah.A(new Runnable() {
                public final void run() {
                    k kVar = k.this;
                    Bitmap bitmap = bitmap;
                    if (bitmap == null || bitmap.isRecycled()) {
                        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", new Object[]{bitmap});
                        h hVar = (h) kVar.dGe.dFN.remove(kVar.Ki());
                        if (hVar != null) {
                            hVar.Kd();
                            kVar.dGe.dFM.remove(hVar);
                            return;
                        }
                        return;
                    }
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", new Object[]{bitmap});
                    kVar.n(bitmap);
                }
            });
        }

        private Bitmap Kl() {
            Bitmap bitmap = null;
            if (f.zZ()) {
                InputStream openRead;
                if (this.dGg == null || !this.dGg.startsWith("file://")) {
                    openRead = this.dFR.openRead(b.jw(this.dGg));
                    if (openRead == null) {
                        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", new Object[]{Boolean.valueOf(this.dGl)});
                        if (this.dGl) {
                            e.post(new 4(this), "AppBrandSimpleImageLoaderDownloadThread");
                        } else {
                            this.dGe.dFP.jC(b.jw(this.dGg));
                            this.dGe.dFP.jB(b.jw(this.dGg));
                        }
                    }
                } else {
                    try {
                        openRead = new FileInputStream(this.dGg.replaceFirst("file://", ""));
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e, "load from local file ", new Object[0]);
                    }
                }
                if (openRead != null) {
                    try {
                        bitmap = k(openRead);
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.LoadTask", e2, " decode ", new Object[0]);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", new Object[]{bitmap});
                        throw new a();
                    }
                    x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", new Object[]{bitmap, Integer.valueOf(android.support.v4.b.a.e(bitmap) / 1024), this.dGg});
                }
                return bitmap;
            }
            x.d("MicroMsg.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
            throw new b();
        }

        private Bitmap k(InputStream inputStream) {
            try {
                Bitmap j;
                if (this.dGj != null) {
                    j = this.dGj.j(inputStream);
                } else {
                    j = c.decodeStream(inputStream);
                    bi.d(inputStream);
                }
                return j;
            } finally {
                bi.d(inputStream);
            }
        }
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static b Ka() {
        return l.dGq;
    }

    private b() {
        this.dFM = new ConcurrentHashMap();
        this.dFN = new ConcurrentHashMap();
        this.dFO = new ConcurrentHashMap();
        this.dFQ = new c();
        this.dFR = new a((byte) 0);
        this.dFP = new d(new ag(new ah("AppBrandSimpleImageLoaderDiskIOHandlerThread").lnJ.getLooper()), (byte) 0);
    }

    public final Bitmap jv(String str) {
        Bitmap jz = this.dFQ.jz(str);
        if (jz == null || jz.isRecycled()) {
            return null;
        }
        return jz;
    }

    public final Bitmap a(String str, e eVar) {
        Closeable fileInputStream;
        Throwable e;
        if (bi.oW(str)) {
            return null;
        }
        String a = a(str, null, eVar);
        Bitmap jz = this.dFQ.jz(a);
        if (jz != null) {
            return jz;
        }
        try {
            if (str.startsWith("file://")) {
                try {
                    fileInputStream = new FileInputStream(str.replaceFirst("file://", ""));
                } catch (FileNotFoundException e2) {
                    x.e("MicroMsg.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    bi.d(null);
                    return null;
                }
            }
            fileInputStream = this.dFR.openRead(jw(str));
            if (eVar != null) {
                try {
                    jz = eVar.j(fileInputStream);
                } catch (Exception e3) {
                    e = e3;
                }
            } else {
                jz = c.decodeStream(fileInputStream);
            }
            if (jz != null) {
                this.dFQ.d(a, jz);
            }
            bi.d(fileInputStream);
            return jz;
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
        } catch (Throwable th) {
            e = th;
            fileInputStream = null;
            bi.d(fileInputStream);
            throw e;
        }
        try {
            x.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader", e, "findCachedLocal", new Object[0]);
            bi.d(fileInputStream);
            return null;
        } catch (Throwable th2) {
            e = th2;
            bi.d(fileInputStream);
            throw e;
        }
    }

    public final String a(h hVar, String str, f fVar, e eVar) {
        String str2 = null;
        if (hVar != null) {
            if (bi.oW(str)) {
                hVar.Kd();
            } else {
                x.d("MicroMsg.AppBrandSimpleImageLoader", "load before start LoadTask url %s", new Object[]{str});
                k kVar = new k(str, fVar, this, this.dFQ, this.dFR, eVar, hVar.Ke());
                str2 = kVar.Kj();
                final h hVar2 = hVar;
                final String str3 = str;
                final k kVar2 = kVar;
                Runnable anonymousClass1 = new Runnable() {
                    public final void run() {
                        Bitmap jv = b.this.jv(str2);
                        if (jv != null) {
                            hVar2.n(jv);
                            x.d("MicroMsg.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", new Object[]{str3, jv});
                            return;
                        }
                        String Ki = kVar2.Ki();
                        b.this.dFM.put(hVar2, Ki);
                        b.this.dFN.put(Ki, hVar2);
                        hVar2.Kc();
                        k kVar = kVar2;
                        kVar.dGe.dFP.j(new 2(kVar));
                    }
                };
                if (ah.isMainThread()) {
                    anonymousClass1.run();
                } else {
                    ah.A(anonymousClass1);
                }
            }
        }
        return str2;
    }

    public final String a(h hVar, String str, f fVar) {
        return a(hVar, str, fVar, null);
    }

    public final String a(ImageView imageView, String str, Drawable drawable, f fVar) {
        return a(imageView, str, drawable, fVar, null);
    }

    public final String a(ImageView imageView, String str, final Drawable drawable, f fVar, e eVar) {
        if (imageView == null) {
            return null;
        }
        String str2;
        if (imageView != null) {
            str2 = (String) this.dFO.get(Integer.valueOf(imageView.hashCode()));
            if (str2 != null) {
                h hVar = (h) this.dFN.get(str2);
                if (hVar != null) {
                    str2 = (String) this.dFM.get(hVar);
                    if (!bi.oW(str2)) {
                        this.dFN.remove(str2);
                    }
                }
            }
        }
        if (bi.oW(str)) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            return null;
        }
        h anonymousClass2 = new j(imageView, this) {
            public final void Kc() {
                if (getImageView() != null && drawable != null) {
                    getImageView().setImageDrawable(drawable);
                }
            }
        };
        str2 = a(anonymousClass2, str, fVar, eVar);
        if (anonymousClass2.dGf) {
            return str2;
        }
        this.dFO.put(Integer.valueOf(imageView.hashCode()), aa(anonymousClass2.aAL, str2));
        return str2;
    }

    private static String aa(String str, String str2) {
        return str + str2;
    }

    private static String a(String str, f fVar, e eVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        if (fVar != null) {
            stringBuilder.append("|transformation:");
            stringBuilder.append(fVar.Ke());
        }
        if (eVar != null) {
            stringBuilder.append("|decoder:");
            stringBuilder.append(eVar.Ke());
        }
        return stringBuilder.toString();
    }

    static {
        String str = com.tencent.mm.compatible.util.e.bnE;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        str = str + "wxacache/";
        dFS = str;
        h.Ey(str);
    }

    private static String jw(String str) {
        if (bi.oW(str)) {
            return null;
        }
        return g.u(str.getBytes());
    }
}
