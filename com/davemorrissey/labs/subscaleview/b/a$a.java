package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class a$a extends AsyncTask<Void, Void, Integer> implements b {
    private final WeakReference<SubsamplingScaleImageView> YB;
    private final WeakReference<Context> YC;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> YD;
    private final Uri YE;
    private final boolean YF;
    private c YG;
    private long YH = -1;
    private Bitmap bitmap;
    private Rect cO;
    private Exception exception;

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        x.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onPostExecute %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.YB.get();
        if (subsamplingScaleImageView == null) {
            return;
        }
        if (this.bitmap == null || num == null) {
            if (this.exception != null && subsamplingScaleImageView.getOnImageEventListener() != null) {
                if (this.YF) {
                    subsamplingScaleImageView.getOnImageEventListener().a(this.YG);
                } else {
                    subsamplingScaleImageView.getOnImageEventListener().b(this.YG);
                }
            }
        } else if (this.YF) {
            subsamplingScaleImageView.a(this.bitmap, num);
        } else {
            subsamplingScaleImageView.b(this.bitmap, num.intValue(), false);
        }
    }

    a$a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri, boolean z) {
        this.YB = new WeakReference(subsamplingScaleImageView);
        this.YC = new WeakReference(context);
        this.YD = new WeakReference(bVar);
        this.YE = uri;
        this.YF = z;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(uri.getPath(), options);
        this.cO = new Rect(0, 0, options.outWidth, options.outHeight);
    }

    @SuppressLint({"LongLogTag"})
    private Integer hx() {
        x.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode start");
        if (this.YF) {
            this.YH = System.currentTimeMillis();
        }
        try {
            String uri = this.YE.toString();
            Context context = (Context) this.YC.get();
            com.davemorrissey.labs.subscaleview.a.b bVar = (com.davemorrissey.labs.subscaleview.a.b) this.YD.get();
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.YB.get();
            if (!(context == null || bVar == null || subsamplingScaleImageView == null)) {
                SubsamplingScaleImageView.i("BitmapLoadTask.doInBackground", new Object[0]);
                d dVar = (d) bVar.hu();
                dVar.b(context, this.YE);
                this.bitmap = dVar.b(this.cO, 1);
                Integer valueOf = Integer.valueOf(SubsamplingScaleImageView.h(context, uri));
                dVar.recycle();
                a(subsamplingScaleImageView);
                return valueOf;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
            this.exception = e;
            this.YG = new c(1, "tile init file not found");
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e2, "Failed to load bitmap", new Object[0]);
            this.exception = e2;
            this.YG = new c(2, "bitmap decode failed");
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.LegacyBitmapLoaderFactory", e22, "Failed to load bitmap - OutOfMemoryError", new Object[0]);
            this.exception = new RuntimeException(e22);
            this.YG = new c(3, "bitmap decode OutOfMemoryError");
        }
        a((SubsamplingScaleImageView) this.YB.get());
        return null;
    }

    private void a(SubsamplingScaleImageView subsamplingScaleImageView) {
        if (subsamplingScaleImageView != null && this.YF && this.YH != -1) {
            x.i("MicroMsg.LegacyBitmapLoaderFactory", "alvinluo preview decode onEnd %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
            subsamplingScaleImageView.bV((int) (System.currentTimeMillis() - this.YH));
        }
    }

    public final void hy() {
        executeOnExecutor(((SubsamplingScaleImageView) this.YB.get()).aaF, new Void[0]);
    }
}
