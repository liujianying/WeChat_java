package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class b$a extends AsyncTask<Void, Void, int[]> implements b {
    private final WeakReference<SubsamplingScaleImageView> YB;
    private final WeakReference<Context> YC;
    private final WeakReference<com.davemorrissey.labs.subscaleview.a.b<? extends d>> YD;
    private final Uri YE;
    private c YG;
    private long YH;
    private d YI;
    private Exception exception;

    protected final /* synthetic */ void onPostExecute(Object obj) {
        int[] iArr = (int[]) obj;
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.YB.get();
        if (subsamplingScaleImageView == null) {
            x.e("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask onPostExecute view is null");
        } else if (this.YI != null && iArr != null && iArr.length == 3) {
            long currentTimeMillis = System.currentTimeMillis();
            subsamplingScaleImageView.a(this.YI, iArr[0], iArr[1], iArr[2]);
            subsamplingScaleImageView.bU((int) (System.currentTimeMillis() - currentTimeMillis));
        } else if (this.exception != null && subsamplingScaleImageView.getOnImageEventListener() != null) {
            subsamplingScaleImageView.getOnImageEventListener().b(this.YG);
        }
    }

    b$a(SubsamplingScaleImageView subsamplingScaleImageView, Context context, com.davemorrissey.labs.subscaleview.a.b<? extends d> bVar, Uri uri) {
        this.YB = new WeakReference(subsamplingScaleImageView);
        this.YC = new WeakReference(context);
        this.YD = new WeakReference(bVar);
        this.YE = uri;
    }

    @SuppressLint({"LongLogTag"})
    private int[] hz() {
        x.d("MicroMsg.LegacyTileInitLoaderFactory", "alvinluo TileInitTask doInBackground");
        this.YH = System.currentTimeMillis();
        try {
            String uri = this.YE.toString();
            Context context = (Context) this.YC.get();
            com.davemorrissey.labs.subscaleview.a.b bVar = (com.davemorrissey.labs.subscaleview.a.b) this.YD.get();
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.YB.get();
            if (!(context == null || bVar == null || subsamplingScaleImageView == null)) {
                this.YI = (d) bVar.hu();
                Point b = this.YI.b(context, this.YE);
                int i = b.x;
                int i2 = b.y;
                int h = SubsamplingScaleImageView.h(context, uri);
                if (subsamplingScaleImageView.getsRegion() != null) {
                    Rect rect = subsamplingScaleImageView.getsRegion();
                    rect.left = Math.max(0, rect.left);
                    rect.top = Math.max(0, rect.top);
                    rect.right = Math.min(i, rect.right);
                    rect.bottom = Math.min(i2, rect.bottom);
                    int width = rect.width();
                    i2 = rect.height();
                    subsamplingScaleImageView.setsRegion(rect);
                    i = width;
                }
                a(subsamplingScaleImageView);
                return new int[]{i, i2, h};
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
            this.exception = e;
            this.YG = new c(1, "tile init file not found");
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.LegacyTileInitLoaderFactory", e2, "alvinluo Failed to initialise bitmap decoder", new Object[0]);
            this.exception = e2;
            this.YG = new c(4, "tile init failed");
        }
        a((SubsamplingScaleImageView) this.YB.get());
        return null;
    }

    private void a(SubsamplingScaleImageView subsamplingScaleImageView) {
        if (subsamplingScaleImageView != null && this.YH != -1) {
            subsamplingScaleImageView.bU((int) (System.currentTimeMillis() - this.YH));
        }
    }

    public final void hy() {
        executeOnExecutor(((SubsamplingScaleImageView) this.YB.get()).aaF, new Void[0]);
    }
}
