package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.jsapi.camera.a.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p.d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.plugin.appbrand.s.j;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppBrandCameraView extends RelativeLayout implements d, e, f {
    private ImageView bOA;
    private p fNZ;
    private String fOa = "normal";
    a fOb;
    private int fOc;
    private String fOd = "back";
    private String fOe = "auto";
    private String fOf = "high";
    private boolean fOg;
    private boolean fOh = false;
    private int fOi = 1080;
    private int fOj = 1920;
    private int fOk = 1080;
    private int fOl = 1920;
    private Rect fOm;
    private int fOn;
    private c fOo;
    private b fOp;
    private MMSightRecordView fOq;
    private String fOr;
    private String fOs;
    private String fOt;
    int fOu = -1;
    private boolean fOv = false;
    private long fOw = -1;
    private long fOx = -1;
    MMSightRecordView$a fOy = new 2(this);
    private String mAppId;
    private Context mContext;

    private class b implements a {
        private b() {
        }

        /* synthetic */ b(AppBrandCameraView appBrandCameraView, byte b) {
            this();
        }

        public final void init() {
        }

        public final void n(byte[] bArr, int i, int i2) {
            if (!AppBrandCameraView.this.fOg) {
            }
        }

        public final void aiM() {
            x.i("MicroMsg.AppBrandCameraView", "takePicture.");
            if (AppBrandCameraView.this.fOq == null) {
                x.i("MicroMsg.AppBrandCameraView", "recordView is null");
            } else if (AppBrandCameraView.this.fOu == 2) {
                x.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
            } else if (AppBrandCameraView.this.fOv || bi.bI(AppBrandCameraView.this.fOw) < 300) {
                x.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
            } else {
                AppBrandCameraView.this.fOw = bi.VG();
                AppBrandCameraView.this.fOv = true;
                AppBrandCameraView.this.fOu = 3;
                AppBrandCameraView.this.fOq.a(new 1(this), "on".equals(AppBrandCameraView.this.fOe));
            }
        }

        final boolean a(Bitmap bitmap, String str) {
            if (!(bitmap == null || bitmap.isRecycled())) {
                try {
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    if (!(width == 0 || height == 0)) {
                        if ("normal".equals(AppBrandCameraView.this.fOf)) {
                            bitmap = c.a(bitmap, (height * 2) / 3, (width * 2) / 3, false, true);
                        } else if ("low".equals(AppBrandCameraView.this.fOf)) {
                            bitmap = c.a(bitmap, height / 2, width / 2, false, true);
                        }
                    }
                    AppBrandCameraView.this.fOk = bitmap.getWidth();
                    AppBrandCameraView.this.fOl = bitmap.getHeight();
                    c.a(bitmap, 90, CompressFormat.JPEG, str, true);
                    x.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", new Object[]{Long.valueOf(FileOp.mI(str))});
                    return true;
                } catch (Exception e) {
                    x.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", new Object[]{e.getMessage()});
                }
            }
            return false;
        }

        public final void aiN() {
            x.i("MicroMsg.AppBrandCameraView", "startRecord.");
            a aiD = a.aiD();
            if (!(aiD.fNV && aiD.fNW)) {
                x.i("MicroMsg.AppBrandCameraMrg", "no all permission");
            }
            int i = (aiD.fNV && aiD.fNW) ? 1 : 0;
            if (i == 0) {
                Toast.makeText(AppBrandCameraView.this.mContext, j.mmsight_capture_init_error, 1).show();
                x.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
                I(-1, "permission");
            } else if (AppBrandCameraView.this.fOu == 2) {
                x.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
                I(-1, "is recording");
            } else {
                AppBrandCameraView.this.fOx = bi.VG();
                AppBrandCameraView.this.fOq.leB.wn();
                AppBrandCameraView.this.fOu = 2;
                I(0, "");
                AppBrandCameraView.this.aiI();
            }
        }

        private void I(int i, String str) {
            if (AppBrandCameraView.this.fOo != null) {
                AppBrandCameraView.this.fOo.I(i, str);
            }
        }

        public final void stopRecord() {
            x.i("MicroMsg.AppBrandCameraView", "stopRecord");
            if (AppBrandCameraView.this.fOq == null) {
                x.i("MicroMsg.AppBrandCameraView", "recordView is null");
                c(-1, "camera is null", null, null);
            } else if (AppBrandCameraView.this.fOu != 2) {
                x.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
                c(-1, "is not recording", null, null);
            } else if (AppBrandCameraView.this.fOh) {
                x.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
                c(-1, "is stopping", null, null);
            } else {
                AppBrandCameraView.this.fOh = true;
                AppBrandCameraView.this.fOq.a(new 2(this));
            }
        }

        private void c(int i, String str, String str2, String str3) {
            if (AppBrandCameraView.this.fOo != null) {
                AppBrandCameraView.this.fOo.c(i, str, tw(str2), tw(str3));
            }
            AppBrandCameraView.this.aiI();
        }

        public final void aiO() {
            long bI = bi.bI(AppBrandCameraView.this.fOx);
            if (bI < 1500) {
                x.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", new Object[]{Long.valueOf(1500 - bI)});
                ah.i(new 3(this), 1500 - bI);
                return;
            }
            stopRecord();
        }

        final String tw(String str) {
            if (bi.oW(str)) {
                return str;
            }
            AppBrandLocalMediaObject attach = AppBrandLocalMediaObjectManager.attach(AppBrandCameraView.this.mAppId, str, true);
            if (attach != null) {
                return attach.bNH;
            }
            return null;
        }

        public final void release() {
        }
    }

    static /* synthetic */ void a(AppBrandCameraView appBrandCameraView, int i, String str, String str2) {
        x.i("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", new Object[]{Integer.valueOf(i), str, str2});
        if (appBrandCameraView.fOo != null) {
            appBrandCameraView.fOo.a(i, str, str2, appBrandCameraView.fOk, appBrandCameraView.fOl);
        }
        appBrandCameraView.fOv = false;
        appBrandCameraView.aiG();
        appBrandCameraView.fOu = 1;
    }

    public AppBrandCameraView(Context context) {
        super(context);
        init(context);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void setOperateCallBack(c cVar) {
        this.fOo = cVar;
    }

    public void setOutPutCallBack(b bVar) {
        this.fOp = bVar;
    }

    private void init(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(h.app_brand_camera_container, this);
    }

    public final void initView() {
        x.i("MicroMsg.AppBrandCameraView", "initView");
        if (a.aiD().aiC()) {
            aiH();
            aiG();
            aiE();
            aiF();
        }
    }

    public void setMode(String str) {
        this.fOa = str;
    }

    public void setPage(p pVar) {
        this.fNZ = pVar;
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public final void Y(String str, boolean z) {
        if (!bi.fS(this.fOd, str) && !bi.fS(this.fOa, "scanCode")) {
            this.fOd = str;
            if (!z && this.fOq != null) {
                this.fOq.leB.switchCamera();
            }
        }
    }

    public void setCameraId(int i) {
        this.fOc = i;
    }

    public int getCameraId() {
        return this.fOc;
    }

    public void setFlash(String str) {
        if (!bi.fS(this.fOe, str)) {
            this.fOe = str;
        }
    }

    public void setQuality(String str) {
        if (!bi.fS(this.fOf, str)) {
            this.fOf = str;
        }
    }

    public final boolean bL(int i, int i2) {
        if (this.fOi == i && this.fOj == i2) {
            return false;
        }
        x.i("MicroMsg.AppBrandCameraView", "setViewSize");
        this.fOi = i;
        this.fOj = i2;
        return true;
    }

    public void setNeedOutput(boolean z) {
        this.fOg = z;
    }

    public final void agK() {
        Map hashMap;
        String jSONObject;
        com.tencent.mm.plugin.appbrand.jsapi.h a;
        x.i("MicroMsg.AppBrandCameraView", "onUIPause");
        if (this.fOu == 2) {
            x.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
            hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(this.fOc));
            hashMap.put("errMsg", "stop on record");
            jSONObject = new JSONObject(hashMap).toString();
            a = new h().a(this.fNZ);
            a.mData = jSONObject;
            a.ahM();
        }
        if (this.fOq != null) {
            Bitmap currentFramePicture = this.fOq.getCurrentFramePicture();
            if (currentFramePicture != null) {
                this.bOA.setImageBitmap(currentFramePicture);
            }
        }
        release();
        aiK();
        hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(getCameraId()));
        jSONObject = new JSONObject(hashMap).toString();
        a = new f().a(this.fNZ);
        a.mData = jSONObject;
        a.ahM();
    }

    public final void agL() {
        x.i("MicroMsg.AppBrandCameraView", "onUIResume");
        synchronized (AppBrandCameraView.class) {
            aiE();
            aiJ();
        }
    }

    public final void onDestroy() {
        release();
    }

    public final void release() {
        x.i("MicroMsg.AppBrandCameraView", "release");
        synchronized (AppBrandCameraView.class) {
            if (this.fOq != null) {
                this.fOq.leB.release();
                removeView(this.fOq);
                this.fOu = -1;
                this.fOq = null;
            }
        }
    }

    private void aiE() {
        x.i("MicroMsg.AppBrandCameraView", "initCamera.");
        if (!a.aiD().aiC()) {
            Toast.makeText(this.mContext, j.mmsight_capture_init_error, 1).show();
            x.w("MicroMsg.AppBrandCameraView", "no permission");
        } else if (this.fOq != null) {
            x.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
        } else {
            if (this.bOA == null) {
                this.bOA = new ImageView(this.mContext);
                this.bOA.setScaleType(ScaleType.FIT_XY);
                addView(this.bOA, new LayoutParams(-1, -1));
            } else {
                this.bOA.setImageBitmap(null);
            }
            this.fOq = new MMSightRecordView(this.mContext);
            addView(this.fOq);
            this.fOq.setPreviewSizeLimit(720);
            this.fOq.leB.ZY();
            this.fOq.setDisplayRatio((((float) this.fOi) * 1.0f) / ((float) this.fOj));
            this.fOq.setVideoPara$2e715812(600000);
            this.fOq.setVideoFilePath(this.fOr);
            this.fOq.setClipPictureSize(true);
            this.fOq.setClipVideoSize(true);
            this.fOq.setUseBackCamera("back".equals(this.fOd));
            this.fOq.setFrameDataCallback(this.fOy);
            this.fOq.leB.startPreview();
            this.fOq.leB.ZS();
            this.fOq.setInitErrorCallback(new 1(this));
            this.fOu = 1;
        }
    }

    public final void aiF() {
        if (this.fOq == null) {
            x.i("MicroMsg.AppBrandCameraView", "recordView is null");
            return;
        }
        aiJ();
        aiI();
    }

    private void aiG() {
        this.fOt = com.tencent.mm.compatible.util.e.dgl + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
    }

    private void aiH() {
        String str = "MicroMsg_" + System.currentTimeMillis();
        this.fOr = com.tencent.mm.compatible.util.e.dgl + str + ".mp4";
        this.fOs = com.tencent.mm.compatible.util.e.dgl + str + ".jpeg";
        if (this.fOq != null) {
            this.fOq.setVideoFilePath(this.fOr);
        }
    }

    public final void aiI() {
        if (this.fOq != null && this.fOe != null) {
            if (this.fOu != 2 && this.fOu != 4) {
                if (this.fOq.getFlashMode() == 1) {
                    this.fOq.setFlashMode(2);
                }
                if (this.fOe.equals("auto")) {
                    this.fOq.setFlashMode(3);
                }
            } else if (this.fOe.equals("on")) {
                this.fOq.setFlashMode(1);
            } else {
                this.fOq.setFlashMode(2);
            }
        }
    }

    private void aiJ() {
        x.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[]{this.fOa});
        aiK();
        if (bi.oW(this.fOa) || !this.fOa.equals("scanCode")) {
            this.fOb = new b(this, (byte) 0);
        } else {
            this.fOb = new c(this, (byte) 0);
        }
        this.fOb.init();
    }

    private void aiK() {
        if (this.fOb != null) {
            this.fOb.release();
            this.fOb = null;
        }
    }

    public void setScanFreq(int i) {
        x.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[]{Integer.valueOf(i)});
        if (i <= 0) {
            x.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
        } else {
            this.fOn = i;
        }
    }

    public final void l(int i, int i2, int i3, int i4) {
        x.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        if (i3 > 0 && i4 > 0) {
            this.fOm = new Rect(i, i2, i + i3, i2 + i4);
        }
    }
}
