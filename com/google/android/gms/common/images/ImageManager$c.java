package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.images.ImageManager.d;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class ImageManager$c implements Runnable {
    private final Uri aMJ;
    final /* synthetic */ ImageManager aML;
    private final ParcelFileDescriptor aMM;

    public ImageManager$c(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.aML = imageManager;
        this.aMJ = uri;
        this.aMM = parcelFileDescriptor;
    }

    public final void run() {
        String str = "LoadBitmapFromDiskRunnable can't be executed in the main thread";
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            new StringBuilder("checkNotMainThread: current thread ").append(Thread.currentThread()).append(" IS the main thread ").append(Looper.getMainLooper().getThread()).append("!");
            throw new IllegalStateException(str);
        }
        boolean z = false;
        Bitmap bitmap = null;
        if (this.aMM != null) {
            try {
                bitmap = BitmapFactory.decodeFileDescriptor(this.aMM.getFileDescriptor());
            } catch (OutOfMemoryError e) {
                new StringBuilder("OOM while loading bitmap for uri: ").append(this.aMJ);
                z = true;
            }
            try {
                this.aMM.close();
            } catch (IOException e2) {
            }
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager.g(this.aML).post(new d(this.aML, this.aMJ, bitmap, z, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e3) {
            new StringBuilder("Latch interrupted while posting ").append(this.aMJ);
        }
    }
}
