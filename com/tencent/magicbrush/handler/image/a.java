package com.tencent.magicbrush.handler.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Base64;
import com.tencent.magicbrush.a.c$f;
import com.tencent.magicbrush.a.d$a;
import com.tencent.magicbrush.handler.b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class a implements b {
    com.tencent.magicbrush.handler.a boD;
    private b boE;
    private List<a> boF;
    private a boG;
    private int boH = (Runtime.getRuntime().availableProcessors() + 1);
    private ExecutorService boI = null;
    public d$a boJ;

    public a(com.tencent.magicbrush.handler.a aVar, b bVar) {
        if (aVar == null || bVar == null) {
            throw new IllegalArgumentException("DefaultImageHandlerImpl accept null parameter");
        }
        this.boD = aVar;
        this.boE = bVar;
        this.boF = new LinkedList();
    }

    public final void init() {
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1048576);
        c$f.i("DefaultImageHandlerImpl", "alvinluo maxMemory: %d, max_worker_runnable_size: %d", Integer.valueOf(maxMemory), Integer.valueOf(Math.min(this.boH, maxMemory <= 64 ? 1 : maxMemory / 32)));
        if (this.boJ != null) {
            this.boJ.c(Integer.valueOf(r0));
        }
        this.boI = Executors.newFixedThreadPool(r0);
    }

    public final void release() {
        synchronized (this) {
            List<Runnable> shutdownNow = this.boI.shutdownNow();
            if (!shutdownNow.isEmpty()) {
                for (Runnable runnable : shutdownNow) {
                    if (runnable != null && (runnable instanceof c)) {
                        c.a((c) runnable);
                    }
                }
            }
        }
    }

    public Bitmap getBitmap(int i, int i2) {
        return com.tencent.magicbrush.b.a.tf().boQ.aL(i, i2);
    }

    public final String toDataURL(Bitmap bitmap, String str, float f) {
        c$f.i("DefaultImageHandlerImpl", "toDataURL() called with: bitmap = [" + bitmap + "], type = [" + str + "], encoderOptions = [" + f + "]", new Object[0]);
        if (bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return "data:,";
        }
        CompressFormat compressFormat = "image/webp".equals(str) ? CompressFormat.WEBP : ("image/jpeg".equals(str) || "image/jpg".equals(str)) ? CompressFormat.JPEG : CompressFormat.PNG;
        if (f < 0.0f || f > 1.0f) {
            f = 0.92f;
        }
        int i = (int) (100.0f * f);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean compress = bitmap.compress(compressFormat, i, byteArrayOutputStream);
        try {
            byteArrayOutputStream.close();
        } catch (IOException e) {
            c$f.e("DefaultImageHandlerImpl", "dataurl_encode IOException e %s", e.toString());
            compress = false;
        }
        if (!compress || byteArrayOutputStream.size() <= 0) {
            c$f.e("DefaultImageHandlerImpl", "dataurl_encode Bitmap compress error.", new Object[0]);
            return "data:,";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("data:image/");
        if (compressFormat == CompressFormat.PNG) {
            stringBuilder.append("png");
        } else if (compressFormat == CompressFormat.JPEG) {
            stringBuilder.append("jpeg");
        } else {
            stringBuilder.append("webp");
        }
        stringBuilder.append(";base64,");
        stringBuilder.append(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
        return stringBuilder.toString();
    }

    public void releaseBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    public final Bitmap loadBitmapSync(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        a aVar;
        for (a aVar2 : this.boF) {
            if (aVar2.bV(str)) {
                break;
            }
        }
        a aVar22 = null;
        if (aVar22 == null) {
            aVar = this.boG;
        } else {
            aVar = aVar22;
        }
        if (aVar == null) {
            c$f.e("DefaultImageHandlerImpl", "No fit decoder found for %s", str);
            return null;
        }
        Bitmap a;
        try {
            a = com.tencent.magicbrush.a.a.ta().a(str, aVar.bW(str));
        } catch (Exception e) {
            c$f.e("DefaultImageHandlerImpl", "ImageDecoder(%s) decode path[%s] error %s", aVar, str, e.toString());
            a = null;
        }
        return a;
    }

    public final void loadBitmapAsync(String str) {
        if (str == null || str.length() == 0) {
            this.boD.e(new b(str, null, (byte) 0));
            return;
        }
        this.boI.execute(new c(this, str, (byte) 0));
    }

    public final void a(a aVar, boolean z) {
        if (z) {
            this.boG = aVar;
        } else {
            this.boF.add(aVar);
        }
    }
}
