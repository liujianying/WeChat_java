package com.davemorrissey.labs.subscaleview.b;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import com.davemorrissey.labs.subscaleview.a.c;
import com.davemorrissey.labs.subscaleview.a.d;
import com.davemorrissey.labs.subscaleview.c.b;
import com.davemorrissey.labs.subscaleview.c.e;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;

class c$a extends AsyncTask<Void, Void, Bitmap> implements b {
    private final WeakReference<SubsamplingScaleImageView> YB;
    private c YG;
    private final WeakReference<d> YJ;
    private final WeakReference<e> YK;
    private Exception exception;
    private long mStartTime = -1;

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        x.i("MicroMsg.LegacyTileLoaderFactory", "alvinluo onPostExecute %d", Long.valueOf(System.currentTimeMillis()));
        SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.YB.get();
        e eVar = (e) this.YK.get();
        if (subsamplingScaleImageView != null && eVar != null) {
            if (bitmap != null) {
                eVar.bitmap = bitmap;
                eVar.YM = false;
                subsamplingScaleImageView.a(eVar);
            } else if (this.exception != null && subsamplingScaleImageView.getOnImageEventListener() != null) {
                subsamplingScaleImageView.getOnImageEventListener().c(this.YG);
            }
        }
    }

    c$a(SubsamplingScaleImageView subsamplingScaleImageView, d dVar, e eVar) {
        this.YB = new WeakReference(subsamplingScaleImageView);
        this.YJ = new WeakReference(dVar);
        this.YK = new WeakReference(eVar);
        eVar.YM = true;
    }

    @SuppressLint({"LongLogTag"})
    private Bitmap hA() {
        if (!(this.YB.get() == null || this.YK.get() == null || ((SubsamplingScaleImageView) this.YB.get()).getFullImageSampleSize() != ((e) this.YK.get()).sampleSize)) {
            this.mStartTime = System.currentTimeMillis();
        }
        SubsamplingScaleImageView subsamplingScaleImageView;
        try {
            subsamplingScaleImageView = (SubsamplingScaleImageView) this.YB.get();
            d dVar = (d) this.YJ.get();
            e eVar = (e) this.YK.get();
            if (dVar == null || eVar == null || subsamplingScaleImageView == null || !dVar.hv() || !eVar.YN) {
                if (eVar != null) {
                    eVar.YM = false;
                }
                a((SubsamplingScaleImageView) this.YB.get(), (e) this.YK.get());
                return null;
            }
            x.d("MicroMsg.LegacyTileLoaderFactory", "alvinluo TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", eVar.YL, Integer.valueOf(eVar.sampleSize));
            subsamplingScaleImageView.getDecoderLock().readLock().lock();
            if (dVar.hv()) {
                Rect rect = eVar.YL;
                Rect rect2 = eVar.YP;
                if (subsamplingScaleImageView.getRequiredRotation() == 0) {
                    rect2.set(rect);
                } else if (subsamplingScaleImageView.getRequiredRotation() == 90) {
                    rect2.set(rect.top, subsamplingScaleImageView.YW - rect.right, rect.bottom, subsamplingScaleImageView.YW - rect.left);
                } else if (subsamplingScaleImageView.getRequiredRotation() == 180) {
                    rect2.set(subsamplingScaleImageView.YV - rect.right, subsamplingScaleImageView.YW - rect.bottom, subsamplingScaleImageView.YV - rect.left, subsamplingScaleImageView.YW - rect.top);
                } else {
                    rect2.set(subsamplingScaleImageView.YV - rect.bottom, rect.left, subsamplingScaleImageView.YV - rect.top, rect.right);
                }
                if (subsamplingScaleImageView.getsRegion() != null) {
                    eVar.YP.offset(subsamplingScaleImageView.getsRegion().left, subsamplingScaleImageView.getsRegion().top);
                }
                x.d("MicroMsg.LegacyTileLoaderFactory", "alvinluo tile sampleSize: %d", Integer.valueOf(eVar.sampleSize));
                Bitmap b = dVar.b(eVar.YP, eVar.sampleSize);
                a(subsamplingScaleImageView, eVar);
                subsamplingScaleImageView.getDecoderLock().readLock().unlock();
                return b;
            }
            eVar.YM = false;
            subsamplingScaleImageView.getDecoderLock().readLock().unlock();
            a((SubsamplingScaleImageView) this.YB.get(), (e) this.YK.get());
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e, "Failed to decode tile", new Object[0]);
            this.exception = e;
            this.YG = new c(5, "decode tile failed");
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.LegacyTileLoaderFactory", e2, "Failed to decode tile - OutOfMemoryError", new Object[0]);
            this.exception = new RuntimeException(e2);
            this.YG = new c(6, "decode tile OutOfMemoryError");
        } catch (Throwable th) {
            subsamplingScaleImageView.getDecoderLock().readLock().unlock();
        }
    }

    private void a(SubsamplingScaleImageView subsamplingScaleImageView, e eVar) {
        if (subsamplingScaleImageView != null && eVar != null && this.mStartTime != -1 && subsamplingScaleImageView.getFullImageSampleSize() == eVar.sampleSize) {
            subsamplingScaleImageView.bW((int) (System.currentTimeMillis() - this.mStartTime));
        }
    }

    public final void hy() {
        executeOnExecutor(((SubsamplingScaleImageView) this.YB.get()).aaF, new Void[0]);
    }
}
