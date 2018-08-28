package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.au;
import com.tencent.mm.model.d;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public abstract class SightCameraView extends FrameLayout implements com.tencent.mm.model.d.a {
    private d gbl;
    private Animation kwe;
    protected int liy;
    private long mYT;
    protected int ngA;
    protected boolean ngB;
    protected boolean ngC;
    protected int ngD;
    protected a ngE;
    private al ngF;
    private int ngG;
    private Runnable ngH;
    private Runnable ngI;
    protected e ngv;
    protected com.tencent.mm.plugin.sight.encode.a.a ngw;
    protected ImageView ngx;
    protected Runnable ngy;
    protected long ngz;

    public interface a {
    }

    protected abstract void aP(String str, boolean z);

    protected abstract void bwy();

    protected abstract Surface getPreviewSurface();

    protected abstract int getSurfaceHeight();

    protected abstract int getSurfaceWidth();

    public abstract boolean isPlaying();

    public abstract void setFixPreviewRate(float f);

    protected abstract void setIsMute(boolean z);

    static /* synthetic */ void b(SightCameraView sightCameraView) {
        x.i("MicroMsg.SightCameraView", "stop record");
        if (sightCameraView.ngw == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        au.Em().H(new Runnable() {
            final /* synthetic */ Runnable dmS = null;

            public final void run() {
            }

            public final String toString() {
                return super.toString() + "|stopRecord";
            }
        });
        sightCameraView.ngF.SO();
        sightCameraView.as(0.0f);
        sightCameraView.bwz();
        sightCameraView.setKeepScreenOn(false);
    }

    public void setPreviewRate(float f) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        x.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height), Float.valueOf(f)});
        postInvalidate();
    }

    public void setTargetWidth(int i) {
        this.liy = i;
    }

    public void setRecordMaxDuring(int i) {
        x.d("MicroMsg.SightCameraView", "setRecordMaxDuring recordMaxDuring : " + i);
        this.ngD = i;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ngz = -1;
        this.ngA = b.ngM;
        this.ngB = false;
        this.ngC = false;
        this.liy = 320;
        this.ngD = 6500;
        this.mYT = 0;
        this.ngF = new al(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.al.a() {
            public final boolean vD() {
                float bwi = ((float) SightCameraView.this.ngw.bwi()) / ((float) SightCameraView.this.ngD);
                if (Float.compare(bwi, 0.0f) > 0 || System.currentTimeMillis() - SightCameraView.this.mYT <= 20000) {
                    if (Float.compare(bwi, 1.0f) <= 0 || SightCameraView.this.ngw.bwj() != com.tencent.mm.plugin.sight.encode.a.a.a.nfd) {
                        SightCameraView.this.as(bwi);
                    } else if (!SightCameraView.this.ngw.bwh()) {
                        SightCameraView.b(SightCameraView.this);
                    }
                    return true;
                }
                x.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[]{Long.valueOf(20000)});
                SightCameraView.this.aKC();
                return false;
            }
        }, true);
        this.ngG = -1;
        this.ngH = new 2(this);
        this.ngI = new 3(this);
        this.gbl = new d();
        if (com.tencent.mm.plugin.sight.base.d.bvC()) {
            inflate(getContext(), R.i.sight_camera_view_merge_v14, this);
        } else {
            inflate(getContext(), R.i.sight_camera_view_merge, this);
        }
        this.ngB = false;
        this.ngC = false;
        this.ngv = new e();
        e eVar = this.ngv;
        x.i("MicroMsg.SightCamera", "init needRotate %s", new Object[]{Boolean.valueOf(false)});
        if (q.deO.dfq) {
            eVar.ngs.lgR = q.deO.mVideoHeight;
            eVar.ngs.lgS = q.deO.mVideoWidth;
            eVar.ngs.lgQ = q.deO.dfs;
        }
        eVar.ngs.lhb = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        eVar.ngs.bYE = 0;
        this.ngx = (ImageView) findViewById(R.h.progress_iv);
        bwz();
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setSightMedia(com.tencent.mm.plugin.sight.encode.a.a aVar) {
        this.ngw = aVar;
        if (this.ngw != null && this.ngv != null) {
            this.ngv.ngt = this.ngw.bwk();
        }
    }

    public void setSightCameraUIIm(a aVar) {
        this.ngE = aVar;
    }

    public final void as(float f) {
        x.d("MicroMsg.SightCameraView", "update progress %f", new Object[]{Float.valueOf(f)});
        if (this.ngG < 0) {
            this.ngG = getResources().getDisplayMetrics().widthPixels;
        }
        int i;
        LayoutParams layoutParams;
        if (f < 0.0f) {
            LayoutParams layoutParams2 = this.ngx.getLayoutParams();
            layoutParams2.width = this.ngG;
            this.ngx.setLayoutParams(layoutParams2);
        } else if (f > 1.0f) {
            i = (this.ngG / 2) - 1;
            layoutParams = this.ngx.getLayoutParams();
            layoutParams.width = this.ngG - (i * 2);
            this.ngx.setLayoutParams(layoutParams);
        } else {
            i = (int) ((((float) getResources().getDisplayMetrics().widthPixels) * f) / 2.0f);
            layoutParams = this.ngx.getLayoutParams();
            layoutParams.width = this.ngG - (i * 2);
            this.ngx.setLayoutParams(layoutParams);
        }
    }

    private void bwz() {
        if (this.ngx.getVisibility() != 4) {
            if (this.kwe != null) {
                this.kwe.cancel();
            }
            this.ngx.setVisibility(4);
        }
    }

    public int getCurMediaStatus$6991144a() {
        return this.ngw.bwj();
    }

    protected final void aKC() {
        x.w("MicroMsg.SightCameraView", "cancel record");
        if (this.ngw == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        au.Em().cil().removeCallbacks(this.ngH);
        au.Em().H(this.ngI);
        this.ngF.SO();
        as(0.0f);
        bwz();
        setKeepScreenOn(false);
    }

    protected void setStopCallback(Runnable runnable) {
        this.ngy = runnable;
    }

    protected final void bwA() {
        this.gbl.a(this);
    }

    protected final void bwB() {
        this.gbl.bv(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.ngB && this.ngC) {
            x.i("MicroMsg.SightCameraView", "check double click %dms", new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - this.ngz)});
            if (SystemClock.elapsedRealtime() - this.ngz < 400) {
                this.ngv.ngu.removeMessages(4354);
                e eVar = this.ngv;
                if (eVar.lfu) {
                    Parameters parameters;
                    try {
                        parameters = eVar.ddt.getParameters();
                    } catch (Throwable e) {
                        x.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[]{e.getMessage()});
                        x.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        x.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[]{Boolean.valueOf(eVar.lft), Boolean.valueOf(parameters.isZoomSupported())});
                        if (parameters.isZoomSupported()) {
                            eVar.ngu.removeMessages(4353);
                            if (eVar.lft) {
                                eVar.ngu.lgi = false;
                                eVar.ngu.lft = false;
                                eVar.ngu.lgh = com.tencent.mm.plugin.sight.encode.ui.e.a.d(parameters) * -1;
                                eVar.ngu.sendMessage(eVar.ngu.obtainMessage(4353, eVar.ddt));
                            } else {
                                eVar.ngu.lgi = false;
                                eVar.ngu.lft = true;
                                eVar.ngu.lgh = com.tencent.mm.plugin.sight.encode.ui.e.a.d(parameters);
                                eVar.ngu.sendMessage(eVar.ngu.obtainMessage(4353, eVar.ddt));
                            }
                            if (!eVar.lft) {
                                z = true;
                            }
                            eVar.lft = z;
                        }
                    }
                } else {
                    x.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                }
            } else {
                e eVar2 = this.ngv;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int surfaceWidth = getSurfaceWidth();
                int surfaceHeight = getSurfaceHeight();
                if (!com.tencent.mm.compatible.util.d.fS(14)) {
                    eVar2.ngu.removeMessages(4354);
                    eVar2.ngu.lgk = x;
                    eVar2.ngu.kuY = y;
                    eVar2.ngu.lgl = surfaceWidth;
                    eVar2.ngu.lgm = surfaceHeight;
                    eVar2.ngu.sendMessageDelayed(eVar2.ngu.obtainMessage(4354, eVar2.ddt), 400);
                }
            }
            this.ngz = SystemClock.elapsedRealtime();
            motionEvent.getX();
            motionEvent.getY();
            com.tencent.mm.compatible.util.d.fS(14);
        }
        return true;
    }

    public String getRecordPath() {
        return this.ngw.getRecordPath();
    }

    public int getDuration() {
        return this.ngw.getDuration();
    }
}
