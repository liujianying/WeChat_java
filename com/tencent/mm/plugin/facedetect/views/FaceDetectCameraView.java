package com.tencent.mm.plugin.facedetect.views;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class FaceDetectCameraView extends MMTextureView implements SurfaceTextureListener {
    private static a iTl = null;
    private boolean heV;
    private int height;
    private long iNs;
    b iSU;
    private SurfaceTexture iSV;
    private ActivityManager iSW;
    private long iSX;
    private long iSY;
    private int iSZ;
    private boolean iTa;
    private boolean iTb;
    private boolean iTc;
    private final Object iTd;
    private boolean iTe;
    private boolean iTf;
    private final Object iTg;
    private final Object iTh;
    private Rect iTi;
    private c iTj;
    private boolean iTk;
    public b iTm;
    private byte[] iTn;
    private boolean iTo;
    private long iTp;
    private int width;

    static /* synthetic */ void f(FaceDetectCameraView faceDetectCameraView) {
        if (faceDetectCameraView.iTe && faceDetectCameraView.iSX > 0) {
            x.i("MicroMsg.FaceDetectCameraView", "hy: already request scanning face and now automatically capture");
            ah.A(new 1(faceDetectCameraView));
        }
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iSU = null;
        this.iSV = null;
        this.iSX = FaceDetectView.iTW;
        this.iSY = -1;
        this.iNs = -1;
        this.iSZ = 1;
        this.iTa = false;
        this.iTb = false;
        this.iTc = false;
        this.iTd = new Object();
        this.iTe = false;
        this.iTf = false;
        this.heV = false;
        this.iTg = new Object();
        this.iTh = new Object();
        this.iTi = null;
        this.width = r.CTRL_INDEX;
        this.height = 576;
        this.iTj = null;
        this.iTk = false;
        this.iTm = null;
        this.iTn = null;
        this.iTo = false;
        this.iTp = -1;
        this.iSW = (ActivityManager) getContext().getSystemService("activity");
        x.i("MicroMsg.FaceDetectCameraView", "hy: face vedio debug: %b", new Object[]{Boolean.valueOf(this.iTk)});
        this.iTm = new c(this, (byte) 0);
        iTl = new a(this, (byte) 0);
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    public final Point getEncodeVideoBestSize() {
        return this.iTm.aKK();
    }

    final void setCallback(b bVar) {
        this.iSU = bVar;
    }

    public final void a(c cVar) {
        this.iTm.a(cVar);
        this.iNs = -1;
    }

    public final synchronized void a(Rect rect, long j) {
        aKE();
        this.iTi = rect;
        aKG();
        this.iTm.dg(j);
    }

    private static void aKE() {
        x.i("MicroMsg.FaceDetectCameraView", "hy: request clear queue");
        f.aJK();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureAvailable");
        crS();
        this.iTa = true;
        this.iSV = surfaceTexture;
        if (this.iTf) {
            a(this.iTj);
        }
    }

    public final void aKF() {
        this.heV = false;
        this.iTm.aKJ();
        aKE();
        int aJP = f.iNu.aJP();
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo pause motion time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        FaceDetectReporter.aJU().s(aJP, r2);
    }

    private synchronized void aKG() {
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo capture face");
        f.iNu.aJO();
        g gVar = f.iNu.iNv.iPA;
        if (gVar.iNy == null) {
            x.e("MicroMsg.FaceDetectNativeManager", "hy: init motion no instance");
        } else {
            x.i("MicroMsg.FaceDetectNativeManager", "hy: start init motion");
            gVar.iNy.engineGetCurrMotion();
        }
        int aJP = f.iNu.aJP();
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo start motion time: %d", new Object[]{Long.valueOf(System.currentTimeMillis())});
        FaceDetectReporter.aJU().r(aJP, r2);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureSizeChanged");
        this.iSV = surfaceTexture;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.FaceDetectCameraView", "hy: onSurfaceTextureDestroyed");
        this.iTa = false;
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        x.i("MicroMsg.FaceDetectCameraView", "hy: attached");
    }

    final synchronized FaceResult aKH() {
        FaceResult aJR;
        f.aJK();
        int aJO = f.iNu.aJO();
        aJR = f.iNu.iNv.iPA.aJR();
        String str = "MicroMsg.FaceDetectCameraView";
        String str2 = "hy: motionResult: %d, finalResult: %d";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(aJO);
        objArr[1] = Integer.valueOf(aJR != null ? aJR.result : -10000);
        x.i(str, str2, objArr);
        return aJR;
    }

    public final Bitmap getPreviewBm() {
        return getBitmap();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.width = getMeasuredWidth();
        this.height = getMeasuredHeight();
        x.i("MicroMsg.FaceDetectCameraView", "hy: camera view on measure to %d, %d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
    }

    public final int getCameraRotation() {
        return this.iTm.getRotation();
    }

    public final int getPreviewWidth() {
        return this.iTm.getPreviewWidth();
    }

    public final int getPreviewHeight() {
        return this.iTm.getPreviewHeight();
    }
}
