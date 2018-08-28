package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.common.images.a.a;
import com.google.android.gms.common.images.a.b;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class ImageManager$d implements Runnable {
    private final CountDownLatch aKx;
    private final Uri aMJ;
    final /* synthetic */ ImageManager aML;
    private boolean aMN;
    private final Bitmap mBitmap;

    public ImageManager$d(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
        this.aML = imageManager;
        this.aMJ = uri;
        this.mBitmap = bitmap;
        this.aMN = z;
        this.aKx = countDownLatch;
    }

    private void a(ImageManager$ImageReceiver imageManager$ImageReceiver, boolean z) {
        ArrayList a = imageManager$ImageReceiver.aMK;
        int size = a.size();
        for (int i = 0; i < size; i++) {
            a aVar = (a) a.get(i);
            if (z) {
                aVar.a(ImageManager.b(this.aML), this.mBitmap);
            } else {
                ImageManager.d(this.aML).put(this.aMJ, Long.valueOf(SystemClock.elapsedRealtime()));
                aVar.a(ImageManager.b(this.aML), ImageManager.c(this.aML));
            }
            if (!(aVar instanceof b)) {
                ImageManager.a(this.aML).remove(aVar);
            }
        }
    }

    public final void run() {
        String str = "OnBitmapLoadedRunnable must be executed in the main thread";
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            new StringBuilder("checkMainThread: current thread ").append(Thread.currentThread()).append(" IS NOT the main thread ").append(Looper.getMainLooper().getThread()).append("!");
            throw new IllegalStateException(str);
        }
        boolean z = this.mBitmap != null;
        if (ImageManager.h(this.aML) != null) {
            if (this.aMN) {
                ImageManager.h(this.aML).trimToSize(-1);
                System.gc();
                this.aMN = false;
                ImageManager.g(this.aML).post(this);
                return;
            } else if (z) {
                ImageManager.h(this.aML).put(new a(this.aMJ), this.mBitmap);
            }
        }
        ImageManager$ImageReceiver imageManager$ImageReceiver = (ImageManager$ImageReceiver) ImageManager.e(this.aML).remove(this.aMJ);
        if (imageManager$ImageReceiver != null) {
            a(imageManager$ImageReceiver, z);
        }
        this.aKx.countDown();
        synchronized (ImageManager.oZ()) {
            ImageManager.pa().remove(this.aMJ);
        }
    }
}
