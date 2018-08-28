package com.tencent.mm.graphics.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.tencent.mm.a.e;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.graphics.a.c;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Timer;

public class WxBaseImageView extends FrameLayout {
    public long YH;
    private Rect cO;
    public ViewStub djA;
    private ViewStub djB;
    private ImageView djC;
    public SubsamplingScaleImageView djD;
    private b djE;
    private int djF;
    public c djG;
    private boolean djH;
    public a djI;
    public a djJ;
    public boolean djK;
    public boolean djL;
    private boolean djM;
    private boolean djN;
    private boolean djO;
    private boolean djP;
    private boolean djQ;
    private ah djR;
    public int imageHeight;
    public int imageWidth;
    private Context mContext;

    static /* synthetic */ void a(WxBaseImageView wxBaseImageView) {
        if (com.tencent.mm.graphics.b.c.djh.djm) {
            com.tencent.mm.graphics.b.c cVar = com.tencent.mm.graphics.b.c.djh;
            cVar.dji = 0;
            cVar.djj = 0;
            cVar.djm = false;
            cVar.aDX.removeFrameCallback(cVar);
        }
        if (!wxBaseImageView.djH) {
            x.i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance can't report");
        } else if (wxBaseImageView.djP) {
            x.i("MicroMsg.WxBaseImageView", "alvinluo hasReportPerformance and return");
        } else {
            if (wxBaseImageView.djR == null) {
                wxBaseImageView.djR = new ah("WxBaseImageViewReport");
            }
            wxBaseImageView.djR.H(new 2(wxBaseImageView));
        }
    }

    static /* synthetic */ void a(WxBaseImageView wxBaseImageView, com.davemorrissey.labs.subscaleview.a.c cVar) {
        if (wxBaseImageView.djI != null) {
            wxBaseImageView.gj(cVar.errCode);
            wxBaseImageView.djM = true;
            wxBaseImageView.Cm();
        }
    }

    static /* synthetic */ void b(WxBaseImageView wxBaseImageView, com.davemorrissey.labs.subscaleview.a.c cVar) {
        if (wxBaseImageView.djJ != null) {
            wxBaseImageView.gk(cVar.errCode);
            wxBaseImageView.djN = true;
            wxBaseImageView.Cm();
        }
    }

    static /* synthetic */ void c(WxBaseImageView wxBaseImageView) {
        try {
            if (wxBaseImageView.djR != null) {
                wxBaseImageView.djR.lnJ.quit();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo quitReportThread exception", new Object[0]);
        }
    }

    static /* synthetic */ void d(WxBaseImageView wxBaseImageView) {
        if (wxBaseImageView.djD != null && wxBaseImageView.djI != null && wxBaseImageView.djK) {
            wxBaseImageView.gj(0);
            wxBaseImageView.djI.djx = 0;
            wxBaseImageView.djM = true;
            wxBaseImageView.Cm();
        }
    }

    static /* synthetic */ void e(WxBaseImageView wxBaseImageView) {
        if (wxBaseImageView.djD != null && wxBaseImageView.djJ != null && wxBaseImageView.djL) {
            wxBaseImageView.gk(0);
            wxBaseImageView.djN = true;
            wxBaseImageView.Cm();
        }
    }

    public WxBaseImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public WxBaseImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.djA = null;
        this.djB = null;
        this.djC = null;
        this.djD = null;
        this.djE = null;
        this.djF = 0;
        this.djG = c.diW;
        this.djH = false;
        this.cO = new Rect();
        this.djP = false;
        this.djQ = false;
        this.djR = null;
        this.mContext = context;
        LayoutInflater.from(getContext()).inflate(com.tencent.mm.graphics.a.b.view_mm_image_view, this, true);
        this.djA = (ViewStub) findViewById(com.tencent.mm.graphics.a.a.stub_tile);
        View inflate = this.djA.inflate();
        if (inflate != null) {
            this.djD = (SubsamplingScaleImageView) inflate;
            this.djD.setVisibility(0);
        }
        com.tencent.mm.graphics.b.c cVar = com.tencent.mm.graphics.b.c.djh;
        if (!cVar.djm) {
            cVar.djm = true;
            cVar.aDX.postFrameCallback(cVar);
        }
        d.djo.djp = new WeakReference(this.mContext);
        this.djD.setOnAttachStateChangeListener(new 1(this));
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.cO.left = getLeft();
        this.cO.right = getRight();
        this.cO.top = getTop();
        this.cO.bottom = getBottom();
        if (getGlobalVisibleRect(this.cO)) {
            x.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
            this.djH = true;
            if (!this.djQ) {
                this.djQ = true;
                d dVar = d.djo;
                synchronized (dVar.djr) {
                    if (dVar.bgH) {
                        x.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
                        dVar.bgH = false;
                    }
                    if (dVar.bno != null) {
                        dVar.bno.cancel();
                    }
                    System.gc();
                    dVar.bno = new Timer("Handle_Monitor_mem_cpu", true);
                    dVar.djq.clear();
                    if (!(dVar.djp == null || dVar.djp.get() == null)) {
                        dVar.djq.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context) dVar.djp.get()));
                    }
                    dVar.bno.scheduleAtFixedRate(new 1(dVar), 0, 5);
                    dVar.bgH = true;
                }
            }
        } else {
            this.djH = false;
        }
        Cm();
    }

    public void setForceTileFlag(c cVar) {
        x.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[]{cVar});
        this.djG = cVar;
    }

    public void setScaleRate(float f) {
        if (this.djD != null) {
            this.djD.setScaleRate(f);
        }
    }

    public void setEdgeSwipeListener(SubsamplingScaleImageView.c cVar) {
        this.djD.setEdgeSwipeListener(cVar);
    }

    public void setAnimateMode(com.tencent.mm.graphics.a.a aVar) {
        x.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[]{aVar});
    }

    public void setFitType(ScaleType scaleType) {
        x.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[]{scaleType});
    }

    public Bitmap getFullImageBitmap() {
        if (this.djD != null) {
            return this.djD.getFullImageBitmap();
        }
        return null;
    }

    public void setImageMatrix(Matrix matrix) {
    }

    public void setGestureDetectorListener(SimpleOnGestureListener simpleOnGestureListener) {
        if (this.djD != null) {
            this.djD.setGestureDetectorListener(simpleOnGestureListener);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        if (this.djD != null) {
            this.djD.setOnLongClickListener(onLongClickListener);
        }
    }

    public void setOnImageLoadEventListener(b bVar) {
        if (this.djD != null) {
            this.djE = new 3(this, bVar);
            this.djD.setOnImageEventListener(this.djE);
        }
    }

    public float getScale() {
        if (this.djD != null) {
            return this.djD.getScale();
        }
        return 1.0f;
    }

    public String getActivityName() {
        if (this.mContext == null || !(this.mContext instanceof Activity)) {
            return "Default";
        }
        return ((Activity) this.mContext).getClass().getSimpleName();
    }

    private void gj(int i) {
        try {
            if (this.djD != null && this.djI != null) {
                this.djI.djy = (int) (System.currentTimeMillis() - this.YH);
                com.davemorrissey.labs.subscaleview.d.a imageDecodeRecord = this.djD.getImageDecodeRecord();
                if (imageDecodeRecord != null) {
                    this.djI.djz = imageDecodeRecord.YQ;
                } else {
                    this.djI.djz = 0;
                }
                this.djI.djx = i;
                this.djI.orientation = this.djD.getPreviewOrientation();
                this.djI.width = this.djD.getPreviewWidth();
                this.djI.height = this.djD.getPreviewHeight();
                this.djI.Zk = 1;
                this.djI.fileSize = e.cm(this.djI.imagePath);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo fillPreviewInfo exception", new Object[0]);
        }
    }

    private void gk(int i) {
        try {
            if (this.djD != null && this.djJ != null) {
                this.djJ.djy = (int) (System.currentTimeMillis() - this.YH);
                com.davemorrissey.labs.subscaleview.d.a imageDecodeRecord = this.djD.getImageDecodeRecord();
                if (imageDecodeRecord != null) {
                    this.djJ.djz = imageDecodeRecord.YS + imageDecodeRecord.YR;
                } else {
                    this.djI.djz = 0;
                }
                this.djJ.djx = i;
                this.djJ.orientation = this.djD.getRequiredRotation();
                this.djJ.width = this.djD.getSWidth();
                this.djJ.height = this.djD.getSHeight();
                this.djJ.Zk = this.djD.getFullImageSampleSize();
                this.djJ.fileSize = e.cm(this.djJ.imagePath);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.WxBaseImageView", e, "alvinluo fillMainInfo exception", new Object[0]);
        }
    }

    private void Cm() {
        if (!this.djH || this.djO) {
            return;
        }
        if (this.djK && !this.djM) {
            return;
        }
        if (!this.djL || this.djN) {
            x.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
            int i = com.tencent.mm.graphics.c.a.dju;
            a aVar = this.djJ;
            a aVar2 = this.djI;
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar != null) {
                com.tencent.mm.graphics.c.a.a(currentTimeMillis, aVar);
            }
            if (aVar2 != null) {
                com.tencent.mm.graphics.c.a.a(currentTimeMillis, aVar2);
            }
            this.djO = true;
        }
    }
}
