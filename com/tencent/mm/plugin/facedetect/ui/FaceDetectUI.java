package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.c.b;
import com.tencent.mm.plugin.facedetect.c.e;
import com.tencent.mm.plugin.facedetect.e.a.1;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.plugin.facedetect.model.h$a;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.4;
import com.tencent.mm.plugin.facedetect.views.FaceScanRect;
import com.tencent.mm.plugin.facedetect.views.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceDetectUI extends MMActivity implements e, com.tencent.mm.plugin.facedetect.views.a {
    private String cYO = null;
    private int iLW = -1;
    private com.tencent.mm.plugin.facedetect.c.a iQQ = null;
    private a iQR = null;
    private b iQS = null;
    private boolean iQT = false;
    private FaceDetectProcessService iRA = null;
    private ServiceConnection iRB = null;
    private boolean iRC = false;
    private boolean iRD = false;
    private c iRE = null;
    h iRq = null;
    private b iRr = null;
    private boolean iRs = false;
    private boolean iRt = false;
    private View iRu = null;
    private RelativeLayout iRv;
    FaceDetectView iRw = null;
    FaceScanRect iRx = null;
    private TextView iRy = null;
    private Button iRz = null;
    boolean iuY = false;
    private WakeLock wakeLock = null;

    private interface a {
        void onFinish();
    }

    static /* synthetic */ void e(FaceDetectUI faceDetectUI) {
        x.i("MicroMsg.FaceDetectUI", "alvinluo start");
        faceDetectUI.aJv();
    }

    static /* synthetic */ void f(FaceDetectUI faceDetectUI) {
        x.v("MicroMsg.FaceDetectUI", "alvinluo onPreviewDone");
        if (com.tencent.mm.plugin.facedetect.e.a.aKA().iSn) {
            com.tencent.mm.plugin.facedetect.e.a aKA = com.tencent.mm.plugin.facedetect.e.a.aKA();
            int cameraRotation = faceDetectUI.iRw.getCameraRotation();
            int cameraPreivewWidth = faceDetectUI.iRw.getCameraPreivewWidth();
            int cameraPreviewHeight = faceDetectUI.iRw.getCameraPreviewHeight();
            int cameraBestWidth = faceDetectUI.iRw.getCameraBestWidth();
            int cameraPreviewHeight2 = faceDetectUI.iRw.getCameraPreviewHeight();
            x.i("MicroMsg.FaceVideoRecorder", "hy: init record");
            x.i("MicroMsg.FaceVideoRecorder", "hy: cameraOrientation: %d, previewWidth: %d, previewHeight: %d,isLandscape: %b,  degree: %d", new Object[]{Integer.valueOf(cameraRotation), Integer.valueOf(cameraPreivewWidth), Integer.valueOf(cameraPreviewHeight), Boolean.valueOf(false), Integer.valueOf(0)});
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.isDefault = true;
            videoTransPara.width = aKA.iSp;
            videoTransPara.height = aKA.iSq;
            videoTransPara.fps = 30;
            videoTransPara.videoBitrate = 1200000;
            videoTransPara.dQG = 10;
            videoTransPara.dQF = 64000;
            videoTransPara.dQH = 2;
            videoTransPara.dQI = 1;
            videoTransPara.audioSampleRate = 16000;
            videoTransPara.duration = 15;
            aKA.iSs.a(aKA.iMQ, videoTransPara);
            aKA.iSf.H(new 1(aKA, cameraRotation, cameraPreviewHeight, cameraPreivewWidth, cameraBestWidth, cameraPreviewHeight2));
        }
        faceDetectUI.iRw.i(false, faceDetectUI.cYO);
        ah.i(new 6(faceDetectUI), 500);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(2097280);
        this.cYO = getIntent().getStringExtra("k_user_name");
        this.iQT = getIntent().getBooleanExtra("k_need_signature", false);
        this.iLW = getIntent().getIntExtra("k_server_scene", -1);
        FaceDetectReporter faceDetectReporter = (FaceDetectReporter) getIntent().getBundleExtra("key_reporter_bundle").getParcelable("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.aJU().a(faceDetectReporter);
        }
        int i = b.iMT;
        this.iQQ = b.a(this, this, this.iLW, getIntent().getExtras());
        o.r(this);
        this.iRz = (Button) findViewById(com.tencent.mm.plugin.facedetect.a.e.left_btn);
        this.iRz.setOnClickListener(new 1(this));
        this.iRu = findViewById(com.tencent.mm.plugin.facedetect.a.e.face_detect_cover);
        this.iRu.setVisibility(8);
        this.iRv = (RelativeLayout) findViewById(com.tencent.mm.plugin.facedetect.a.e.face_hold_area);
        this.iRx = (FaceScanRect) findViewById(com.tencent.mm.plugin.facedetect.a.e.face_fixed_rect);
        this.iRw = (FaceDetectView) findViewById(com.tencent.mm.plugin.facedetect.a.e.face_detect_view);
        this.iRy = (TextView) findViewById(com.tencent.mm.plugin.facedetect.a.e.err_msg_tv);
        this.iRw.setCallback(this);
        FaceDetectView faceDetectView = this.iRw;
        ViewGroup viewGroup = this.iRv;
        ViewGroup centerHintHolder = this.iRx.getCenterHintHolder();
        faceDetectView.iTI = viewGroup;
        faceDetectView.iTJ = centerHintHolder;
        this.iRw.setErrTextView(this.iRy);
        this.iRw.i(true, this.cYO);
        this.iRx.setOnRefreshRectListener(new 3(this));
        this.iRx.setVisibility(4);
        this.iRr = new b(this, (byte) 0);
    }

    private void aGN() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo unbindService, mBound: %b", new Object[]{Boolean.valueOf(this.iRC)});
        if (this.iRC) {
            x.i("MicroMsg.FaceDetectUI", "alvinluo unbindService");
            unbindService(this.iRB);
            this.iRC = false;
        }
    }

    public final void aJA() {
    }

    public void onStart() {
        super.onStart();
        x.i("MicroMsg.FaceDetectUI", "alvinluo onStart");
        if (this.wakeLock == null) {
            this.wakeLock = ((PowerManager) getSystemService("power")).newWakeLock(10, "Scan Lock");
        }
        if (!this.wakeLock.isHeld()) {
            x.i("MicroMsg.FaceDetectUI", "alvinluo acquire wakeLock");
            this.wakeLock.acquire();
        }
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("key_face_service_connection_from", 2);
        this.iRB = new 4(this);
        x.i("MicroMsg.FaceDetectUI", "alvinluo bindService");
        bindService(intent, this.iRB, 1);
    }

    protected void onStop() {
        super.onStop();
        x.i("MicroMsg.FaceDetectUI", "hy: onStop, finish");
        aGN();
        if (this.iRD) {
            finish();
        } else {
            a(1, 90006, "cancel with on stop", null);
        }
    }

    protected final int getLayoutId() {
        return g.face_recognize_ui;
    }

    public final void aJv() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo startFaceDetect ");
        LayoutParams attributes = getWindow().getAttributes();
        if (attributes.screenBrightness < 0.9f) {
            attributes.screenBrightness = 0.9f;
            getWindow().setAttributes(attributes);
        }
        this.iRx.iUS = com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.iUV;
        FaceScanRect faceScanRect = this.iRx;
        if (faceScanRect.iUS == com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.iUT) {
            x.w("MicroMsg.FaceScanRect", "hy: already opened");
        } else {
            faceScanRect.iUR.setVisibility(0);
            faceScanRect.iUA.setBackgroundResource(d.face_scan_net);
            faceScanRect.iUR.startAnimation(faceScanRect.iUO);
            for (View view : faceScanRect.iUJ) {
                view.clearAnimation();
                view.setBackgroundColor(faceScanRect.getResources().getColor(com.tencent.mm.plugin.facedetect.a.b.white));
            }
            faceScanRect.iUS = com.tencent.mm.plugin.facedetect.views.FaceScanRect.a.iUT;
        }
        this.iRw.iTH.iTB = false;
        this.iRx.setVisibility(0);
        x.d("MicroMsg.FaceDetectUI", "alvinluo %d, %d, %d, %d", new Object[]{Integer.valueOf(this.iRx.getTop()), Integer.valueOf(this.iRx.getRight()), Integer.valueOf(this.iRx.getLeft()), Integer.valueOf(this.iRx.getBottom())});
        this.iRs = true;
        this.iuY = false;
        this.iRr.reset();
        if (this.iRs) {
            this.iRE = new 5(this);
            x.i("MicroMsg.FaceDetectUI", "hy: start preview");
            c cVar = this.iRE;
            FaceDetectView faceDetectView = this.iRw;
            faceDetectView.iTG.a(new 4(faceDetectView, cVar));
        }
    }

    public final void aJx() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo releaseFaceDetect");
        if (!this.iRt) {
            this.iRE = null;
            this.iRt = true;
            if (this.iRr.iRM) {
                aKw();
                this.iRw.iTG.iTm.aKI();
            }
            if (this.wakeLock != null && this.wakeLock.isHeld()) {
                this.wakeLock.release();
                this.wakeLock = null;
            }
            com.tencent.mm.sdk.f.e.post(new 2(this), "Face_active_gc");
        }
        aGN();
    }

    public final void a(int i, int i2, String str, Bundle bundle) {
        x.i("MicroMsg.FaceDetectUI", "finishWithResult errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 0 && i2 != 0 && com.tencent.mm.plugin.facedetect.e.a.aKA().isStarted() && com.tencent.mm.plugin.facedetect.e.a.aKA().iSn) {
            com.tencent.mm.plugin.facedetect.e.a.aKA().aKC();
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_parcelable_reporter", FaceDetectReporter.aJU());
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Bundle bundle3 = new Bundle();
        bundle3.putInt("err_type", i);
        bundle3.putInt("err_code", i2);
        bundle3.putString("err_msg", str);
        bundle3.putAll(bundle2);
        Intent intent = new Intent();
        intent.putExtras(bundle3);
        setResult(-1, intent);
        finish();
    }

    /* renamed from: aKv */
    final void l() {
        if (this.iuY) {
            x.i("MicroMsg.FaceDetectUI", "hy: start capture face");
            FaceDetectView faceDetectView = this.iRw;
            Rect rect = new Rect(this.iRx.getLeft(), this.iRx.getTop(), this.iRx.getRight(), this.iRx.getBottom());
            h$a aJT = h.aJT();
            if (aJT.type != 100) {
                if (faceDetectView.iTL != null) {
                    faceDetectView.iTL.aKe();
                }
                faceDetectView.hxu = false;
                faceDetectView.isPaused = false;
                faceDetectView.iTR = bi.VG();
                faceDetectView.iTP = aJT.iNE;
                faceDetectView.iTO = aJT.eYF;
                faceDetectView.iNF = aJT.iNF;
                faceDetectView.iTM = true;
                faceDetectView.iTQ = aJT.iNI;
                faceDetectView.iTL = com.tencent.mm.plugin.facedetect.d.b.c.a(aJT);
                if (faceDetectView.iTL != null) {
                    if (faceDetectView.iTI != null) {
                        faceDetectView.iTI.removeAllViews();
                    }
                    if (faceDetectView.iTJ != null) {
                        faceDetectView.iTJ.removeAllViews();
                    }
                    faceDetectView.iTL.a(faceDetectView.getContext(), faceDetectView.iTI, faceDetectView.iTJ);
                }
                if (faceDetectView.iTG != null) {
                    faceDetectView.iTG.a(rect, aJT.iNC);
                }
                faceDetectView.iTN = false;
            }
        }
    }

    private void aKw() {
        this.iuY = false;
        this.iRw.eL(false);
        x.i("MicroMsg.FaceDetectUI", "hy: stopped scan");
        this.iRs = false;
        this.iRw.iTG.iTm.stopPreview();
        x.i("MicroMsg.FaceDetectUI", "hy: stopped preview");
    }

    public final void a(boolean z, boolean z2, a.b bVar) {
        if (z) {
            aKw();
        }
        if (z2) {
            x.i("MicroMsg.FaceDetectUI", "hy: need blur");
            com.tencent.mm.sdk.f.e.post(new 7(this, this.iRw.getPreviewBm()), "FaceDetectUI_BlurBgMap");
        }
        this.iQR.a(bVar);
    }

    private void i(int i, String str, String str2) {
        x.i("MicroMsg.FaceDetectUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(4), Integer.valueOf(i), str});
        Bundle bundle = new Bundle();
        bundle.putString("show_err_msg", str2);
        aKw();
        a(4, i, str, bundle);
    }

    public final void d(int i, int i2, String str, Bundle bundle) {
    }

    public final void M(int i, String str) {
        boolean z = true;
        x.i("MicroMsg.FaceDetectUI", "hy: face detect result: %d", new Object[]{Integer.valueOf(i)});
        if (!FaceCharacteristicsResult.pt(i)) {
            h hVar = this.iRq;
            if (hVar.irJ >= hVar.iNA + -1) {
                x.i("MicroMsg.FaceDetectUI", "hy: collect data ok");
                this.iRw.eL(true);
                final Bitmap previewBm = this.iRw.getPreviewBm();
                String str2 = "MicroMsg.FaceDetectUI";
                String str3 = "alvinluo bitmap == null: %b";
                Object[] objArr = new Object[1];
                if (previewBm != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                x.i(str2, str3, objArr);
                final 9 9 = new 9(this);
                com.tencent.mm.sdk.f.e.post(new Runnable() {
                    public final void run() {
                        o.o(FaceDetectUI.this.cYO, previewBm);
                        ah.A(new 1(this));
                    }
                }, "save_face_bitmap");
                return;
            }
            hVar = this.iRq;
            com.tencent.mm.plugin.facedetect.model.g gVar = f.iNu.iNv.iPA;
            if (gVar.iNy == null) {
                x.e("MicroMsg.FaceDetectNativeManager", "hy: move to next motion no instance");
            } else {
                x.i("MicroMsg.FaceDetectNativeManager", "hy: start move next motion");
                gVar.iNy.engineNextMotion();
            }
            hVar.irJ++;
            int i2 = h.aJT().type;
            x.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[]{Integer.valueOf(i2)});
            if (h.aJT().iNH) {
                this.iRx.b(new 10(this));
                return;
            }
            x.i("MicroMsg.FaceDetectUI", "hy: detect ok. start next: %d", new Object[]{Integer.valueOf(i2)});
            l();
        } else if (i == 3) {
            i(90017, "face detect time out", str);
        } else if (i == 6 || i == 5) {
            i(90023, "face track failed or not stable", str);
        } else if (i == 7) {
            i(90009, "audio permission not granted", ad.getContext().getString(com.tencent.mm.plugin.facedetect.a.h.permission_microphone_request_again_msg));
        } else {
            i(90018, "system error", str);
        }
    }

    public final void pE(int i) {
        if (i == 1) {
            this.iRx.b(null);
        }
    }

    private void aKo() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onUserCancel");
        com.tencent.mm.plugin.facedetect.d.b.b currentMotionCancelInfo = this.iRw.getCurrentMotionCancelInfo();
        a(1, currentMotionCancelInfo.errCode, currentMotionCancelInfo.Yy, null);
    }

    protected void onDestroy() {
        x.i("MicroMsg.FaceDetectUI", "hy: current %d instance not destroyed", new Object[]{Integer.valueOf(hashCode())});
        super.onDestroy();
    }

    public void finish() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo finish");
        if (this.iQR != null && this.iQR.aKp()) {
            this.iQR.dismiss();
        }
        if (this.iQS != null) {
            this.iQS.dismiss();
        }
        x.i("MicroMsg.FaceDetectUI", "alvinluo FaceDetectUI release");
        aJx();
        super.finish();
    }

    public void onBackPressed() {
        x.i("MicroMsg.FaceDetectUI", "alvinluo onBackPressed and cancel");
        aKo();
    }
}
