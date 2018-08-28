package com.tencent.mm.plugin.mmsight.ui;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.d$c;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.i;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.1;
import com.tencent.mm.plugin.mmsight.ui.cameraglview.MMSightCameraGLSurfaceView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMNewPhotoEditUI;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.a;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

@a(3)
public class SightCaptureUI extends MMActivity implements d.a, c.a {
    private String cas = "";
    private b epT;
    private int fOu = -1;
    private boolean fOv = false;
    private long fOw = -1;
    private d fam;
    private ObservableTextureView fbo;
    private com.tencent.mm.remoteservice.d iMQ = new com.tencent.mm.remoteservice.d(ad.getContext());
    private View kIx;
    private int lel = 2;
    private VideoTransPara lem;
    private SightParams lip;
    private VideoPlayerTextureView lkZ;
    private VideoSeekBarEditorView lla;
    private f.a llf = new 19(this);
    private ViewGroup lpA;
    private MMSightRecordButton lpB;
    private View lpC;
    private View lpD;
    private ViewGroup lpE;
    private ViewGroup lpF;
    private ImageView lpG;
    private ImageView lpH;
    private SurfaceTexture lpI;
    CameraFrontSightView lpJ;
    private ViewGroup lpK;
    private ImageView lpL;
    private MMSightCameraGLSurfaceView lpM;
    private com.tencent.mm.plugin.mmsight.ui.cameraglview.a lpN;
    private TextView lpO;
    private MMSightCaptureTouchView lpP;
    private View lpQ;
    private a lpR;
    private boolean lpS = true;
    private aso lpT = new aso();
    private byte[] lpU;
    private int lpV;
    private int lpW;
    private int lpX;
    private int lpY;
    private byte[] lpZ;
    private int lpx = 1;
    private boolean lpy = true;
    private e lpz;
    private int lqa;
    private c lqb;
    private boolean lqc = false;
    private boolean lqd = false;
    private boolean lqe = false;
    private int lqf = 0;
    private int lqg = 0;
    private Thread lqh = null;
    private long lqi = -1;
    private boolean lqj = false;
    private boolean lqk = false;
    private Runnable lql = new 17(this);
    private String lqm;
    private String lqn;
    private boolean lqo;
    private Bundle lqp;
    private Runnable lqq = new 18(this);

    static /* synthetic */ void C(SightCaptureUI sightCaptureUI) {
        if (bi.bC(sightCaptureUI.lpU) || sightCaptureUI.lpW <= 0 || sightCaptureUI.lpV <= 0) {
            x.e("MicroMsg.SightCaptureUI", "saveCaptureYuvDataToBitmap error");
        } else {
            try {
                Bitmap b;
                YuvImage yuvImage = new YuvImage(sightCaptureUI.lpU, 17, sightCaptureUI.lpV, sightCaptureUI.lpW, null);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                yuvImage.compressToJpeg(new Rect(0, 0, sightCaptureUI.lpV, sightCaptureUI.lpW), 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                if (!sightCaptureUI.lqe || sightCaptureUI.lpY == 180) {
                    int i = sightCaptureUI.lpX;
                    if (sightCaptureUI.lpY == 180) {
                        i += 180;
                        if (i > 360) {
                            i -= 360;
                        }
                    }
                    b = com.tencent.mm.sdk.platformtools.c.b(decodeByteArray, (float) i);
                    decodeByteArray.recycle();
                } else if (Math.abs(sightCaptureUI.lpX - sightCaptureUI.lpY) == 0) {
                    b = com.tencent.mm.sdk.platformtools.c.b(decodeByteArray, 180.0f);
                    decodeByteArray.recycle();
                } else {
                    b = decodeByteArray;
                }
                try {
                    com.tencent.mm.sdk.platformtools.c.a(b, 90, CompressFormat.JPEG, sightCaptureUI.fam.bej(), false);
                    x.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", new Object[]{Long.valueOf(FileOp.mI(r1))});
                } catch (Exception e) {
                    x.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", new Object[]{e.getMessage()});
                }
                j.lin.F(sightCaptureUI.lpU);
                sightCaptureUI.lpW = 0;
                sightCaptureUI.lpV = 0;
                sightCaptureUI.lpY = 0;
                sightCaptureUI.lpX = 0;
                sightCaptureUI.lpU = null;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e2, "saveCaptureYuvDataToBitmap error: %s", new Object[]{e2.getMessage()});
            }
        }
        sightCaptureUI.fOv = false;
    }

    static /* synthetic */ void F(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.lpC.animate().translationX(0.0f).setDuration(200).setListener(new 15(sightCaptureUI)).start();
        sightCaptureUI.kIx.animate().translationX(0.0f).setDuration(200).setListener(new 16(sightCaptureUI)).start();
    }

    static /* synthetic */ void L(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "start preview");
        if (sightCaptureUI.epT != null) {
            sightCaptureUI.epT.requestFocus();
        }
        sightCaptureUI.lkZ.setVisibility(0);
        sightCaptureUI.lkZ.setAlpha(0.0f);
        sightCaptureUI.lkZ.setVideoPath(sightCaptureUI.fam.getFilePath());
        sightCaptureUI.lkZ.setLoop(true);
        sightCaptureUI.lkZ.setForceScaleFullScreen(true);
        sightCaptureUI.lkZ.setVideoCallback(sightCaptureUI.llf);
    }

    static /* synthetic */ void N(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.fOu == 1 || sightCaptureUI.fOu == 2) {
            String bdP = sightCaptureUI.lpz.bdP();
            if (!bi.oW(bdP)) {
                StringBuilder append = new StringBuilder().append(bdP + "\n" + String.format("CPU: cur %s max:%s", new Object[]{m.zm(), m.zk()})).append("\n");
                Object[] objArr = new Object[1];
                k.bey();
                objArr[0] = k.beB();
                ah.A(new 11(sightCaptureUI, append.append(String.format("RecorderType %s", objArr)).toString() + "\n" + String.format("MemoryClass: %sMB, TotalMem: %sMB", new Object[]{Integer.valueOf(((ActivityManager) ad.getContext().getSystemService("activity")).getLargeMemoryClass()), Integer.valueOf(com.tencent.mm.plugin.mmsight.d.dP(sightCaptureUI))})));
            }
        }
    }

    static /* synthetic */ void U(SightCaptureUI sightCaptureUI) {
        try {
            Bitmap mZ = com.tencent.mm.plugin.mmsight.d.mZ(sightCaptureUI.fam.getFilePath());
            if (mZ != null && sightCaptureUI.lem != null && Math.min(mZ.getWidth(), mZ.getHeight()) > sightCaptureUI.lem.dQS) {
                int width = mZ.getWidth();
                int height = mZ.getHeight();
                int i = sightCaptureUI.lem.dQS > 0 ? sightCaptureUI.lem.dQS : sightCaptureUI.lem.width;
                if (width < height) {
                    width = (int) (((float) height) / ((((float) width) * 1.0f) / ((float) i)));
                    height = i;
                } else {
                    height = (int) (((float) width) / ((((float) height) * 1.0f) / ((float) i)));
                    width = i;
                }
                com.tencent.mm.sdk.platformtools.c.a(Bitmap.createScaledBitmap(mZ, height, width, true), 60, CompressFormat.JPEG, sightCaptureUI.fam.aRw(), true);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "saveNewThumbAfterEdit error: %s", new Object[]{e.getMessage()});
        }
    }

    static /* synthetic */ void b(SightCaptureUI sightCaptureUI) {
        sightCaptureUI.cqj();
        sightCaptureUI.DO(8);
        if (sightCaptureUI.lip == null) {
            x.e("MicroMsg.SightCaptureUI", "sightParams error!");
            return;
        }
        sightCaptureUI.lqf = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        x.i("MicroMsg.SightCaptureUI", "initOnCreate, numCamera: %s", new Object[]{Integer.valueOf(sightCaptureUI.lqf)});
        sightCaptureUI.epT = new b(sightCaptureUI);
        sightCaptureUI.lpy = sightCaptureUI.lip.les;
        sightCaptureUI.lel = sightCaptureUI.lip.lel;
        sightCaptureUI.lpS = sightCaptureUI.lel == 2;
        k.bey().lip = sightCaptureUI.lip;
        sightCaptureUI.lpx = sightCaptureUI.lip.mode;
        x.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, captureMode: %s, showHint: %s, defaultCamera: %s, scene: %s", new Object[]{Integer.valueOf(sightCaptureUI.lpx), Boolean.valueOf(sightCaptureUI.lpy), Integer.valueOf(sightCaptureUI.lel), Integer.valueOf(sightCaptureUI.lip.scene)});
        sightCaptureUI.lem = sightCaptureUI.lip.lem;
        if (sightCaptureUI.lem == null) {
            x.e("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, cannot get videoParams");
            return;
        }
        x.i("MicroMsg.SightCaptureUI", "SightCaptureUI onCreate, videoParams: %s", new Object[]{sightCaptureUI.lem});
        sightCaptureUI.getWindow().addFlags(2097280);
        if (com.tencent.mm.compatible.util.d.fR(19)) {
            sightCaptureUI.getWindow().setFlags(201327616, 201327616);
            com.tencent.mm.plugin.mmsight.d.gs(true);
        } else {
            sightCaptureUI.getWindow().setFlags(1024, 1024);
            com.tencent.mm.plugin.mmsight.d.gs(false);
        }
        sightCaptureUI.lqb = new c(sightCaptureUI);
        sightCaptureUI.lqb.lfp = sightCaptureUI;
        sightCaptureUI.lqb.enable();
        sightCaptureUI.lpA = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.root);
        sightCaptureUI.lpE = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.content_root_view);
        sightCaptureUI.lpF = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.controller_view);
        sightCaptureUI.lpJ = (CameraFrontSightView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.front_sight);
        sightCaptureUI.fbo = (ObservableTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.preview_texture);
        sightCaptureUI.lpB = (MMSightRecordButton) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.record_control_button);
        sightCaptureUI.lpC = sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.sight_btn_revert);
        sightCaptureUI.kIx = sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.sight_btn_send);
        sightCaptureUI.lpD = sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.close_camera);
        sightCaptureUI.lpK = (ViewGroup) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.video_recorder_preview_area);
        sightCaptureUI.lpO = (TextView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.capture_hint);
        if (sightCaptureUI.lpx == 2) {
            sightCaptureUI.lpO.setText(com.tencent.mm.plugin.w.a.f.mmsight_capture_hint_picture);
        } else if (sightCaptureUI.lpx == 1) {
            sightCaptureUI.lpO.setText(com.tencent.mm.plugin.w.a.f.mmsight_capture_hint_sight);
        } else if (sightCaptureUI.lpx == 0) {
            sightCaptureUI.lpO.setText(com.tencent.mm.plugin.w.a.f.mmsight_capture_hint);
        }
        sightCaptureUI.lkZ = (VideoPlayerTextureView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.pre_play_view);
        sightCaptureUI.lpG = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.switch_camera);
        LayoutParams layoutParams = (LayoutParams) sightCaptureUI.lpG.getLayoutParams();
        int i = layoutParams.topMargin;
        if (ak.gw(sightCaptureUI.mController.tml)) {
            i += ak.gv(sightCaptureUI.mController.tml);
        }
        layoutParams.setMargins(layoutParams.leftMargin, i, layoutParams.rightMargin, layoutParams.bottomMargin);
        sightCaptureUI.lpG.setLayoutParams(layoutParams);
        sightCaptureUI.lpH = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.edit_photo_mask);
        sightCaptureUI.lpH.setOnClickListener(new 20(sightCaptureUI));
        sightCaptureUI.lpL = (ImageView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.take_picture_preview);
        sightCaptureUI.lpM = (MMSightCameraGLSurfaceView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.draw_preview_surface);
        sightCaptureUI.lpP = (MMSightCaptureTouchView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.main_touch_area);
        sightCaptureUI.lpQ = sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.recorder_black_mask);
        sightCaptureUI.lpN = new com.tencent.mm.plugin.mmsight.ui.cameraglview.a(sightCaptureUI.lpM);
        if (sightCaptureUI.lpy) {
            sightCaptureUI.lpO.setVisibility(0);
        } else {
            sightCaptureUI.lpO.setVisibility(8);
        }
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(sightCaptureUI.mController.tml, 120);
        CameraFrontSightView cameraFrontSightView = sightCaptureUI.lpJ;
        cameraFrontSightView.loa = cameraFrontSightView.getLayoutParams();
        if (cameraFrontSightView.loa != null) {
            cameraFrontSightView.loa.width = fromDPToPix;
            cameraFrontSightView.loa.height = fromDPToPix;
        }
        cameraFrontSightView.mWidth = fromDPToPix;
        cameraFrontSightView.mHeight = fromDPToPix;
        cameraFrontSightView.lnY = cameraFrontSightView.mWidth / 2;
        cameraFrontSightView.lnZ = cameraFrontSightView.mHeight / 2;
        cameraFrontSightView.gEH = com.tencent.mm.bp.a.fromDPToPix(cameraFrontSightView.getContext(), 1);
        cameraFrontSightView.cN.setColor(-12206054);
        cameraFrontSightView.cN.setStrokeWidth((float) cameraFrontSightView.gEH);
        if (com.tencent.mm.compatible.util.d.fR(19)) {
            i = ak.gs(sightCaptureUI);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.lpB.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.lpB.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.lpD.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.lpD.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.lpC.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.lpC.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.lpH.getLayoutParams();
            marginLayoutParams.bottomMargin += i;
            sightCaptureUI.lpH.setLayoutParams(marginLayoutParams);
            marginLayoutParams = (MarginLayoutParams) sightCaptureUI.kIx.getLayoutParams();
            marginLayoutParams.bottomMargin = i + marginLayoutParams.bottomMargin;
            sightCaptureUI.kIx.setLayoutParams(marginLayoutParams);
        }
        if (sightCaptureUI.lpx == 1 || sightCaptureUI.lpx == 0) {
            sightCaptureUI.lpB.setLongPressCallback(new 21(sightCaptureUI));
            sightCaptureUI.lpB.setErrorPressCallback(new 22(sightCaptureUI));
            sightCaptureUI.lpB.setLongPressScrollCallback(new 23(sightCaptureUI));
        }
        if (sightCaptureUI.lpx == 0 || sightCaptureUI.lpx == 2) {
            sightCaptureUI.lpB.setSimpleTapCallback(new 24(sightCaptureUI));
        }
        if (sightCaptureUI.lqf > 1) {
            sightCaptureUI.lpG.setOnClickListener(new 25(sightCaptureUI));
        } else {
            sightCaptureUI.lpG.setVisibility(8);
        }
        sightCaptureUI.kIx.setOnClickListener(new 26(sightCaptureUI));
        sightCaptureUI.lpC.setOnClickListener(new 2(sightCaptureUI));
        sightCaptureUI.lpD.setOnClickListener(new 3(sightCaptureUI));
        sightCaptureUI.lpP.setTouchCallback(new 4(sightCaptureUI));
        sightCaptureUI.updateState(0);
        sightCaptureUI.bfl();
    }

    static /* synthetic */ void f(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "[gotoPhotoEditUI]");
        if (sightCaptureUI.fam == null) {
            x.e("MicroMsg.SightCaptureUI", "mediaRecorder == NULL");
            return;
        }
        String stringExtra = sightCaptureUI.getIntent().getStringExtra("GalleryUI_FromUser");
        String stringExtra2 = sightCaptureUI.getIntent().getStringExtra("GalleryUI_ToUser");
        Intent intent = new Intent();
        intent.putExtra("GalleryUI_FromUser", stringExtra);
        intent.putExtra("GalleryUI_ToUser", stringExtra2);
        if (sightCaptureUI.lip.scene == 1) {
            intent.putExtra("from_scene", 290);
        } else if (sightCaptureUI.lip.scene == 2) {
            intent.putExtra("from_scene", 289);
        }
        intent.putExtra("before_photo_edit", bi.oW(sightCaptureUI.lqm) ? sightCaptureUI.fam.bej() : sightCaptureUI.lqm);
        intent.putExtra("after_photo_edit", sightCaptureUI.lqn);
        intent.setClass(sightCaptureUI, MMNewPhotoEditUI.class);
        sightCaptureUI.startActivityForResult(intent, 4369);
    }

    static /* synthetic */ void g(SightCaptureUI sightCaptureUI) {
        if (gn(sightCaptureUI)) {
            sightCaptureUI.DO(0);
        }
        sightCaptureUI.lla = (VideoSeekBarEditorView) sightCaptureUI.findViewById(com.tencent.mm.plugin.w.a.d.video_seek_bar_editor);
        if (ak.gt(sightCaptureUI)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) sightCaptureUI.lla.getLayoutParams();
            marginLayoutParams.bottomMargin = ak.gs(sightCaptureUI);
            sightCaptureUI.lla.setLayoutParams(marginLayoutParams);
        }
        sightCaptureUI.lpR = new a();
        sightCaptureUI.lpR.lpi = 2;
        sightCaptureUI.lpR.lpe = true;
        sightCaptureUI.lpR.a(sightCaptureUI, sightCaptureUI.lip.scene, sightCaptureUI.fam.getFilePath(), sightCaptureUI.lla, sightCaptureUI.lkZ, sightCaptureUI.lpE, sightCaptureUI.lem, false);
        sightCaptureUI.lpR.lpc = new 14(sightCaptureUI);
        sightCaptureUI.lpC.setVisibility(8);
        sightCaptureUI.kIx.setVisibility(8);
        sightCaptureUI.lpH.setVisibility(8);
    }

    static /* synthetic */ void l(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.lpO != null && sightCaptureUI.lpy) {
            sightCaptureUI.lpO.animate().alpha(0.0f).setDuration(100).setListener(new 6(sightCaptureUI)).start();
        }
    }

    static /* synthetic */ void m(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.fam != null) {
            x.v("MicroMsg.TestCaptureUiEvent", "startRecord, mediaRecorder.status: %s, %s", new Object[]{sightCaptureUI.fam.ben(), bi.cjd().toString()});
            sightCaptureUI.updateState(6);
            if (sightCaptureUI.fam.ben() == d$c.Stop) {
                sightCaptureUI.lqg = sightCaptureUI.bfm();
                if (sightCaptureUI.lqg < 0) {
                    sightCaptureUI.bfn();
                    return;
                }
            } else if (sightCaptureUI.lqg < 0) {
                sightCaptureUI.bfn();
                return;
            }
            sightCaptureUI.updateState(2);
            if (sightCaptureUI.lpz != null) {
                e eVar = sightCaptureUI.lpz;
                x.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
                if (eVar.ddt != null && eVar.lfu) {
                    try {
                        Parameters parameters = eVar.ddt.getParameters();
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                            x.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                            parameters.setFocusMode("continuous-video");
                        }
                        eVar.ddt.setParameters(parameters);
                    } catch (Exception e) {
                        x.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", new Object[]{e.getMessage()});
                    }
                }
            }
            MMSightRecordButton mMSightRecordButton = sightCaptureUI.lpB;
            int i = (sightCaptureUI.lem.duration * 1000) - 500;
            x.l("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", new Object[]{Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(i), new 8(sightCaptureUI)});
            mMSightRecordButton.loq.setInitProgress(0);
            mMSightRecordButton.loq.setMaxProgress(100);
            mMSightRecordButton.loq.setDuration(i);
            mMSightRecordButton.loq.setVisibility(0);
            mMSightRecordButton.loq.setProgressCallback(new 1(mMSightRecordButton, r2));
            MMSightCircularProgressBar mMSightCircularProgressBar = mMSightRecordButton.loq;
            x.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", new Object[]{Integer.valueOf(mMSightCircularProgressBar.lod), Integer.valueOf(mMSightCircularProgressBar.loe), Integer.valueOf(mMSightCircularProgressBar.duration)});
            mMSightCircularProgressBar.loc = 0.0f;
            mMSightCircularProgressBar.log = new b((float) mMSightCircularProgressBar.lod, (float) mMSightCircularProgressBar.loe, mMSightCircularProgressBar.duration);
            b bVar = mMSightCircularProgressBar.log;
            x.i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new Object[]{new MMSightCircularProgressBar.1(mMSightCircularProgressBar)});
            bVar.lpu = r2;
            b bVar2 = mMSightCircularProgressBar.log;
            x.i("MicroMsg.ProgressHandlerAnimator", "Start");
            bVar2.bTv = true;
            bVar2.lps = bi.VG();
            bVar2.eaF.J(20, 20);
        }
    }

    static /* synthetic */ void o(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.lpz != null && sightCaptureUI.lpz.lfu && sightCaptureUI.lqb != null && !sightCaptureUI.fOv) {
            if (sightCaptureUI.fOw < 0 || bi.bI(sightCaptureUI.fOw) <= 300) {
                sightCaptureUI.fOv = true;
                if (sightCaptureUI.lpO != null && sightCaptureUI.lpy) {
                    sightCaptureUI.lpO.setVisibility(8);
                }
                sightCaptureUI.updateState(7);
                sightCaptureUI.lpB.setTouchEnable(false);
                sightCaptureUI.lqe = sightCaptureUI.lqb.bdK();
                sightCaptureUI.lpZ = null;
                sightCaptureUI.lqa = -1;
                sightCaptureUI.lpz.a(new 5(sightCaptureUI), sightCaptureUI.lqe, sightCaptureUI.lqb.getOrientation());
                sightCaptureUI.fOw = bi.VG();
            }
        }
    }

    static /* synthetic */ void r(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.lqi <= 0 || bi.bI(sightCaptureUI.lqi) > 500) {
            x.v("MicroMsg.TestCaptureUiEvent", "switchCameraClick %s, currentState: %s", new Object[]{bi.cjd().toString(), Integer.valueOf(sightCaptureUI.fOu)});
            sightCaptureUI.bfo();
            sightCaptureUI.lqc = true;
            if (sightCaptureUI.fOu == 2) {
                if (sightCaptureUI.fam == null || !sightCaptureUI.fam.ber()) {
                    x.i("MicroMsg.SightCaptureUI", "switchCameraClick, not write camera data!");
                } else {
                    String str = "MicroMsg.SightCaptureUI";
                    String str2 = "switchCameraOnRecord, currentStatus: %s, mediaRecorder.status: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(sightCaptureUI.fOu);
                    objArr[1] = sightCaptureUI.fam != null ? sightCaptureUI.fam.ben() : "";
                    x.i(str, str2, objArr);
                    if (sightCaptureUI.fOu == 2 && sightCaptureUI.fam != null && sightCaptureUI.fam.ben() == d$c.Start) {
                        sightCaptureUI.fam.pause();
                        sightCaptureUI.lpz.a(sightCaptureUI, sightCaptureUI.lpI, false);
                        sightCaptureUI.lpS = sightCaptureUI.lpz.lgb;
                        if (sightCaptureUI.lpN != null) {
                            sightCaptureUI.lpN.Q(sightCaptureUI.lpz.getPreviewWidth(), sightCaptureUI.lpz.getPreviewHeight(), sightCaptureUI.lpz.getOrientation());
                        }
                        if (sightCaptureUI.fam.ben() != d$c.Pause) {
                            x.e("MicroMsg.SightCaptureUI", "switchCameraOnRecord, recorder status error: %s", new Object[]{sightCaptureUI.fam.ben()});
                        } else {
                            int previewWidth = sightCaptureUI.lpz.getPreviewWidth();
                            int previewHeight = sightCaptureUI.lpz.getPreviewHeight();
                            int orientation = sightCaptureUI.lpz.getOrientation();
                            Point bep = sightCaptureUI.fam.bep();
                            x.i("MicroMsg.SightCaptureUI", "switchCameraOnRecord, newPreviewSize: [%s, %s], oldPreviewSize: [%s], newOrientation: %s, oldOrientation: %s", new Object[]{Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), bep, Integer.valueOf(orientation), Integer.valueOf(sightCaptureUI.fam.beq())});
                            if (!(sightCaptureUI.fam.beq() == orientation && bep.x == previewWidth && bep.y == previewHeight)) {
                                x.e("MicroMsg.SightCaptureUI", "error oldOrientation! after switch, size or orientation not match");
                            }
                            sightCaptureUI.fam.p(sightCaptureUI.lpz.getPreviewWidth(), sightCaptureUI.lpz.getPreviewHeight(), sightCaptureUI.lpz.lfD.x, sightCaptureUI.lpz.lfD.y);
                            sightCaptureUI.fam.O(orientation, sightCaptureUI.lpz.lfD.x, sightCaptureUI.lpz.lfD.y);
                        }
                    }
                    sightCaptureUI.lqd = true;
                }
            } else if (sightCaptureUI.fOu == 1) {
                sightCaptureUI.updateState(6);
                if (sightCaptureUI.gz(true)) {
                    sightCaptureUI.updateState(1);
                }
            }
            sightCaptureUI.bfp();
            sightCaptureUI.lqi = bi.VG();
            return;
        }
        x.i("MicroMsg.SightCaptureUI", "switchCameraClick, switch camera too frequently!!! ignore");
    }

    static /* synthetic */ void s(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.lip.scene == 1 || sightCaptureUI.lip.scene == 2) {
            int i = sightCaptureUI.lqc ? sightCaptureUI.lqd ? 2 : 1 : 0;
            h.mEJ.h(13820, new Object[]{Integer.valueOf(i), Integer.valueOf(sightCaptureUI.lip.scene), sightCaptureUI.lip.leu, Long.valueOf(bi.VE())});
        }
        if (sightCaptureUI.lip != null && sightCaptureUI.lqj) {
            com.tencent.mm.plugin.mmsight.a.a.a(new com.tencent.mm.plugin.mmsight.a.a.a(sightCaptureUI.lip.scene));
        }
        Intent intent = new Intent();
        String filePath = sightCaptureUI.fam.getFilePath();
        String Ll = com.tencent.mm.plugin.sight.base.d.Ll(filePath);
        if (sightCaptureUI.lip.let) {
            sightCaptureUI.aG(filePath, false);
        }
        if (com.tencent.mm.plugin.mmsight.model.a.bdH() != null) {
            sightCaptureUI.lpT.rUS = com.tencent.mm.plugin.mmsight.model.a.bdH().bdI();
        }
        int beo = sightCaptureUI.fam.beo();
        if (sightCaptureUI.lqj) {
            com.tencent.mm.plugin.sight.base.a Lo = com.tencent.mm.plugin.sight.base.d.Lo(sightCaptureUI.fam.getFilePath());
            if (Lo != null) {
                beo = Math.round(((float) Lo.jdD) / 1000.0f);
            }
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.lpz.lgb, filePath, Ll, sightCaptureUI.fam.getFileName(), sightCaptureUI.cas, beo, sightCaptureUI.lpT));
        intent.putExtra("KSessionID", sightCaptureUI.lip.leu);
        sightCaptureUI.setResult(-1, intent);
        sightCaptureUI.finish();
    }

    static /* synthetic */ void t(SightCaptureUI sightCaptureUI) {
        if (sightCaptureUI.lqh != null && sightCaptureUI.lqh.isAlive()) {
            try {
                sightCaptureUI.lqh.join();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "wait saveCaptureImageThread error: %s", new Object[]{e.getMessage()});
            }
        }
        if (sightCaptureUI.lip.scene == 1 || sightCaptureUI.lip.scene == 2) {
            int i = 0;
            if (sightCaptureUI.lqc) {
                i = 1;
            }
            h.mEJ.h(13820, new Object[]{Integer.valueOf(i), Integer.valueOf(sightCaptureUI.lip.scene), sightCaptureUI.lip.leu, Long.valueOf(bi.VE())});
        }
        if (sightCaptureUI.lip.scene == 1) {
            h.mEJ.h(13858, new Object[]{Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
        } else if (sightCaptureUI.lip.scene == 2) {
            h.mEJ.h(13858, new Object[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(0)});
        }
        Intent intent = new Intent();
        Object obj = (bi.oW(sightCaptureUI.lqn) || sightCaptureUI.fam == null || !sightCaptureUI.lqn.equals(sightCaptureUI.fam.bej())) ? null : 1;
        if (obj == null && sightCaptureUI.lip.let) {
            x.i("MicroMsg.SightCaptureUI", "is not Photo editted!");
            sightCaptureUI.aG(sightCaptureUI.fam.bej(), true);
        }
        intent.putExtra("key_req_result", new SightCaptureResult(sightCaptureUI.lpz.lgb, sightCaptureUI.fam.bej()));
        intent.putExtra("KSessionID", sightCaptureUI.lip.leu);
        sightCaptureUI.setResult(-1, intent);
        Bundle bundle = sightCaptureUI.lqp;
        if (bundle == null) {
            x.e("MicroMsg.SightCaptureUI", "[reportPhotoEdit] date == null");
        } else if (sightCaptureUI.lqo) {
            int i2 = bundle.getInt("report_info_emotion_count");
            int i3 = bundle.getInt("report_info_text_count");
            int i4 = bundle.getInt("report_info_mosaic_count");
            int i5 = bundle.getInt("report_info_doodle_count");
            boolean z = bundle.getBoolean("report_info_iscrop");
            int i6 = bundle.getInt("report_info_undo_count");
            boolean z2 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.SightCaptureUI";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i2);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Integer.valueOf(i4);
            objArr[3] = Integer.valueOf(i5);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            objArr[5] = Integer.valueOf(i6);
            objArr[6] = Boolean.valueOf(z2);
            x.i(str, str2, objArr);
            h hVar = h.mEJ;
            objArr = new Object[12];
            objArr[0] = Integer.valueOf(1);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i5);
            objArr[6] = Integer.valueOf(z ? 1 : 0);
            objArr[7] = Integer.valueOf(i6);
            objArr[8] = Integer.valueOf(3);
            objArr[9] = Integer.valueOf(z2 ? 1 : 0);
            objArr[10] = sightCaptureUI.lip.leu;
            objArr[11] = Long.valueOf(bi.VE());
            hVar.h(13857, objArr);
        } else {
            x.i("MicroMsg.SightCaptureUI", "[reportPhotoEdit] reportPhotoEdit == false");
        }
        sightCaptureUI.finish();
    }

    static /* synthetic */ void z(SightCaptureUI sightCaptureUI) {
        x.i("MicroMsg.SightCaptureUI", "setRevertAndSendBtnPos");
        if (sightCaptureUI.lpH.getVisibility() == 8) {
            sightCaptureUI.lpP.setVisibility(8);
        } else {
            sightCaptureUI.lpP.setVisibility(0);
        }
        Point dO = com.tencent.mm.plugin.mmsight.d.dO(sightCaptureUI);
        int dimensionPixelSize = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.w.a.b.mmsight_recorder_button_outer_size_init);
        int dimensionPixelSize2 = sightCaptureUI.getResources().getDimensionPixelSize(com.tencent.mm.plugin.w.a.b.mmsight_recorder_control_button_margin);
        sightCaptureUI.lpB.getX();
        sightCaptureUI.lpC.setTranslationX(((((float) dO.x) / 2.0f) - ((float) dimensionPixelSize2)) - (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.kIx.setTranslationX(((((float) (-dO.x)) / 2.0f) + ((float) dimensionPixelSize2)) + (((float) dimensionPixelSize) / 2.0f));
        sightCaptureUI.lpC.setEnabled(false);
        sightCaptureUI.kIx.setEnabled(false);
    }

    public void onCreate(Bundle bundle) {
        supportRequestWindowFeature(1);
        super.onCreate(bundle);
        this.lip = (SightParams) getIntent().getParcelableExtra("KEY_SIGHT_PARAMS");
        if (this.lip == null) {
            x.e("MicroMsg.SightCaptureUI", "error!!!! sightParams is null!!");
            return;
        }
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.iMQ));
        this.iMQ.K(new 1(this, bi.VG()));
    }

    protected void onPause() {
        super.onPause();
        x.i("MicroMsg.SightCaptureUI", "onPause, currentState: %s", new Object[]{tc(this.fOu)});
        if (this.fOu == 2) {
            stopRecord();
        } else if (this.fOu == 1) {
            bfq();
        } else if (this.fOu == 4 && this.lkZ != null) {
            this.lkZ.pause();
        }
        com.tencent.mm.plugin.webview.ui.tools.widget.m.Bk(2);
    }

    protected void onResume() {
        boolean z = false;
        super.onResume();
        DO(8);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "onResume, currentState: %s, textureview available: %s";
        Object[] objArr = new Object[2];
        objArr[0] = tc(this.fOu);
        if (this.fbo != null && this.fbo.isAvailable()) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.fOu == 2 || this.fOu == 1) {
            bfl();
        } else if (this.fOu == 4) {
            if (this.fbo != null) {
                if (this.fbo.isAvailable()) {
                    this.lpN.bfu();
                } else {
                    this.fbo.setTextureChangeCallback(new 12(this));
                }
            }
            if (this.lkZ != null) {
                this.lkZ.start();
            }
        } else if (this.fOu == 3) {
            if (this.fbo != null) {
                this.fbo.setTextureChangeCallback(null);
            }
            this.lpN.a(this.lpZ, this.lqe, this.lqa);
        }
        com.tencent.mm.plugin.webview.ui.tools.widget.m.Bk(1);
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private void stopRecord() {
        x.l("MicroMsg.SightCaptureUI", "stopRecord, currentStatus: %s", new Object[]{Integer.valueOf(this.fOu)});
        if (this.fOu == 2) {
            updateState(7);
            this.lpB.setTouchEnable(false);
            this.fam.E(new 9(this, this.lpz.getPreviewWidth(), this.lpz.getPreviewHeight()));
        }
    }

    private void bfl() {
        updateState(0);
        this.lqg = 0;
        this.fOv = false;
        this.lqk = false;
        if (this.lkZ != null) {
            this.lkZ.stop();
            this.lkZ.setVideoCallback(null);
            try {
                ViewGroup.LayoutParams layoutParams = this.lkZ.getLayoutParams();
                this.lpE.removeView(this.lkZ);
                this.lpE.addView(this.lkZ, 0, layoutParams);
            } catch (Exception e) {
                x.e("MicroMsg.SightCaptureUI", "clearVideoPlayViewContent, error: %s", new Object[]{e.getMessage()});
            }
        }
        if (this.lpR != null) {
            this.lpR.release();
            this.lpR = null;
        }
        this.lpM.setVisibility(0);
        this.lpL.setImageBitmap(null);
        bfq();
        this.lpz = new e(this.lem, this.lip.scene);
        this.lpz.a(this.lpN.lqP);
        if (this.lpz.o(this, this.lpS)) {
            if (this.fbo.isAvailable()) {
                this.lpI = this.fbo.getSurfaceTexture();
                x.i("MicroMsg.SightCaptureUI", "surface already available, directly set local surface: %s", new Object[]{this.lpI});
                if (gz(false)) {
                    updateState(1);
                } else {
                    updateState(8);
                }
            } else {
                this.fbo.setTextureChangeCallback(new 7(this));
            }
            if (this.lpO != null && this.lpy) {
                this.lpO.setAlpha(1.0f);
                this.lpO.setVisibility(0);
            }
            c cVar = this.lqb;
            x.i("MicroMsg.DeviceOrientationListener", "reset");
            cVar.lfm = -1;
            cVar.orientation = -1;
            cVar.lfl = -1;
            this.lqc = false;
            this.lqd = false;
            return;
        }
        updateState(8);
    }

    private boolean gz(boolean z) {
        x.k("MicroMsg.SightCaptureUI", "createRecorder, surface: %s", new Object[]{this.lpI});
        this.lqk = false;
        if (this.fam != null) {
            if (this.lpz != null) {
                this.lpz.b(this.fam.bem());
            }
            this.fam.cancel();
        }
        if (this.lpz == null) {
            return false;
        }
        boolean a;
        this.lpT = new aso();
        this.lpT.rUP = true;
        this.lpT.rUO = com.tencent.mm.plugin.mmsight.model.j.lgz.lgM;
        if (this.lip != null) {
            this.lpT.rUR = this.lip.scene;
        }
        if (z) {
            a = this.lpz.a(this, this.lpI, true);
            this.lpS = this.lpz.lgb;
            if (!a) {
                return false;
            }
        } else if (this.lpz.a(this.lpI, true) < 0) {
            return false;
        }
        if (this.lpz.lfD == null) {
            return false;
        }
        k.bey();
        this.fam = k.d(this.lem);
        if (this.fam == null) {
            x.e("MicroMsg.SightCaptureUI", "create mediaRecorder error");
            this.lqk = true;
            return false;
        }
        com.tencent.mm.plugin.mmsight.d.a(this.fam, this.lip);
        this.fam.a(this);
        this.lpz.a(this.fam.bem());
        if (this.lpN != null) {
            this.lpN.Q(this.lpz.getPreviewWidth(), this.lpz.getPreviewHeight(), this.lpz.getOrientation());
        }
        this.fam.p(this.lpz.getPreviewWidth(), this.lpz.getPreviewHeight(), this.lpz.lfD.x, this.lpz.lfD.y);
        a = this.fam.sQ(this.lpz.getOrientation());
        x.i("MicroMsg.SightCaptureUI", "preInit result: %s", new Object[]{Boolean.valueOf(a)});
        if (!a) {
            this.lqk = true;
        }
        return a;
    }

    private int bfm() {
        x.i("MicroMsg.SightCaptureUI", "startRecordImpl");
        int d = this.fam.d(this.lpz.getOrientation(), this.lqb.bdK(), this.lqb.getOrientation());
        x.i("MicroMsg.SightCaptureUI", "startRecordImpl ret: %d", new Object[]{Integer.valueOf(d)});
        if (d >= 0) {
            this.lpz.a(e.a.lge);
        }
        return d;
    }

    private void bfn() {
        this.lqk = true;
        updateState(8);
        if (this.fam != null) {
            try {
                this.fam.cancel();
                this.fam = null;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "", new Object[0]);
            }
        }
    }

    private void bfo() {
        k.bey();
        if (k.isDebug()) {
            TextView textView = (TextView) findViewById(com.tencent.mm.plugin.w.a.d.video_debug_info);
            textView.setVisibility(8);
            textView.setText("");
        }
    }

    private void bfp() {
        k.bey();
        if (k.isDebug()) {
            x.i("MicroMsg.SightCaptureUI", "test for debug " + bi.cjd().toString());
            i.D(new 13(this));
        }
    }

    private String aG(String str, boolean z) {
        String oN;
        boolean z2 = CaptureMMProxy.getInstance().getBoolean(aa.a.sVr, true);
        boolean z3 = CaptureMMProxy.getInstance().getBoolean(aa.a.sVs, true);
        if (z) {
            oN = com.tencent.mm.plugin.mmsight.d.oN("jpg");
        } else {
            oN = com.tencent.mm.plugin.mmsight.d.oN("mp4");
        }
        if ((z2 && z) || (z3 && !z)) {
            x.i("MicroMsg.SightCaptureUI", "auto save src %s dest %s state %s %s", new Object[]{str, oN, Boolean.valueOf(z2), Boolean.valueOf(z3)});
            FileOp.y(str, oN);
            r.a(oN, this);
        }
        return oN;
    }

    private void bfq() {
        if (this.fbo != null) {
            this.fbo.setTextureChangeCallback(null);
        }
        if (this.lpz != null) {
            this.lpS = this.lpz.lgb;
            this.lpz.bdL();
            this.lqi = -1;
            this.fOw = -1;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        x.i("MicroMsg.SightCaptureUI", "onDestroy");
        this.iMQ.release();
        if (this.fam != null) {
            this.fam.E(null);
            this.fam.clear();
        }
        if ((this.fOu == -1 ? 1 : null) == null) {
            bfq();
            if (this.lkZ != null) {
                this.lkZ.stop();
                this.lkZ.setVideoCallback(null);
            }
            if (this.epT != null) {
                this.epT.zY();
            }
            if (this.lpR != null) {
                this.lpR.release();
                this.lpR = null;
            }
        }
        if (this.lqb != null) {
            this.lqb.disable();
            this.lqb = null;
        }
        j.lin.Fm();
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.w.a.e.big_sight_capture_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.SightCaptureUI";
        String str2 = "[onActivityResult] requestCode:%s  resultCode:%s data is null?:";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        x.i(str, str2, objArr);
        switch (i) {
            case 4369:
                x.i("MicroMsg.SightCaptureUI", "[handlePhotoEditResult] resultCode:%s", new Object[]{Integer.valueOf(i2)});
                if (i2 == -1 && intent != null && this.fam != null) {
                    this.lqo = true;
                    this.lqp = intent.getBundleExtra("report_info");
                    this.lqm = intent.getStringExtra("before_photo_edit");
                    this.lqn = intent.getStringExtra("after_photo_edit");
                    x.i("MicroMsg.SightCaptureUI", "rawEditPhotoPath:%s lastEditPhotoPath:%s imageState:%s", new Object[]{this.lqm, this.lqn, Boolean.valueOf(CaptureMMProxy.getInstance().getBoolean(aa.a.sVr, true))});
                    if (CaptureMMProxy.getInstance().getBoolean(aa.a.sVr, true)) {
                        this.fam.Hs(this.lqn);
                    } else {
                        String subCoreImageFullPath = CaptureMMProxy.getInstance().getSubCoreImageFullPath("photoEdited_" + System.currentTimeMillis());
                        x.i("MicroMsg.SightCaptureUI", "saveFullPath:%s", new Object[]{subCoreImageFullPath});
                        FileOp.y(this.lqn, subCoreImageFullPath);
                        FileOp.deleteFile(this.lqn);
                        r.a(this.lqn, this);
                        this.fam.Hs(subCoreImageFullPath);
                        this.lqn = subCoreImageFullPath;
                    }
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(this.lqn, options);
                    x.i("MicroMsg.SightCaptureUI", "rawW:%s rawH:%s", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight)});
                    Bitmap j = com.tencent.mm.sdk.platformtools.c.j(this.lqn, options.outHeight, options.outWidth, 0);
                    this.lpL.setVisibility(0);
                    this.lpL.setImageBitmap(j);
                    this.lpM.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private static String tc(int i) {
        if (i == -1) {
            return "CAPTURE_STATE_BINGDING";
        }
        if (i == 0) {
            return "CAPTURE_STATE_INIT";
        }
        if (i == 1) {
            return "CAPTURE_STATE_CAPTURING";
        }
        if (i == 2) {
            return "CAPTURE_STATE_RECORDING";
        }
        if (i == 3) {
            return "CAPTURE_STATE_PREVIEW_PICTURE";
        }
        if (i == 4) {
            return "CAPTURE_STATE_PREVIEW_VIDEO";
        }
        if (i == 6) {
            return "CAPTURE_STATE_SUPERMAN";
        }
        if (i == 7) {
            return "CAPTURE_STATE_WAIT_TO_PREVIEW";
        }
        if (i == 8) {
            return "CAPTURE_STATE_INIT_ERROR";
        }
        if (i == 9) {
            return "CAPTURE_STATE_STOP_ERROR";
        }
        return "UNKNOW";
    }

    private void updateState(int i) {
        x.i("MicroMsg.SightCaptureUI", "pre state %s %s update state %s %s", new Object[]{Integer.valueOf(this.fOu), tc(this.fOu), Integer.valueOf(i), tc(i)});
        x.i("MicroMsg.TestCaptureUiEvent", "pre state %s %s update state %s %s %s", new Object[]{Integer.valueOf(this.fOu), tc(this.fOu), Integer.valueOf(i), tc(i), bi.cjd().toString()});
        if (i != this.fOu) {
            com.tencent.mm.plugin.mmsight.d.Hp("TIME_RECODER_2_PLAY");
            this.fOu = i;
            if (this.fOu != 7) {
                ah.M(this.lql);
            }
            if (this.fOu == 0) {
                this.lpE.setVisibility(8);
                this.lpH.setVisibility(8);
                this.lpF.setVisibility(8);
                this.lpL.setVisibility(8);
                this.lpK.setVisibility(0);
                if (this.lqf > 1) {
                    this.lpG.setVisibility(0);
                }
                if (this.lpz != null) {
                    this.lpz.a(e.a.lgd);
                }
                com.tencent.mm.plugin.mmsight.model.a.reset();
                if (this.lqh != null) {
                    try {
                        this.lqh.interrupt();
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightCaptureUI", e, "update to state init, interrupt failed: %s", new Object[]{e.getMessage()});
                    }
                    this.lqh = null;
                }
            } else if (this.fOu == 1 || this.fOu == 2) {
                this.lpE.setVisibility(0);
                this.lpH.setVisibility(8);
                this.lpF.setVisibility(0);
                this.lpF.setClipChildren(false);
                this.lpC.setVisibility(8);
                this.kIx.setVisibility(8);
                this.lpD.setVisibility(0);
                this.lpB.setVisibility(0);
                this.lkZ.setVisibility(8);
                if (this.fOu == 1) {
                    this.lpB.reset();
                } else {
                    this.lpB.setTouchEnable(true);
                    MMSightRecordButton mMSightRecordButton = this.lpB;
                    x.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
                    mMSightRecordButton.lop.setVisibility(8);
                }
                this.lpQ.setVisibility(8);
                this.lpL.setVisibility(8);
                this.lpP.setVisibility(0);
                if (this.lqf > 1) {
                    this.lpG.setVisibility(0);
                }
                this.lpP.bringToFront();
                this.lpG.bringToFront();
                bfo();
                bfp();
            } else if (this.fOu == 4 || this.fOu == 3) {
                this.lpE.setVisibility(0);
                this.lpF.setVisibility(8);
                this.lpF.setClipChildren(false);
                this.lpC.setVisibility(0);
                this.kIx.setVisibility(0);
                this.lpD.setVisibility(8);
                this.lpB.setVisibility(8);
                if (this.fOu == 3) {
                    this.lpH.setVisibility(0);
                    this.lpL.setVisibility(0);
                    this.lkZ.setVisibility(8);
                } else {
                    this.lpL.setVisibility(8);
                    this.lkZ.setVisibility(0);
                    this.lkZ.setForceScaleFullScreen(true);
                    ViewGroup.LayoutParams layoutParams = this.lkZ.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.lkZ.setLayoutParams(layoutParams);
                    if (this.fam.bdK()) {
                        this.lpN.bfu();
                    }
                    this.lpK.setVisibility(8);
                }
                this.lpP.setVisibility(8);
            } else if (this.fOu == 6) {
                this.lpC.setVisibility(8);
                this.kIx.setVisibility(8);
                this.lpH.setVisibility(8);
                this.lpD.setVisibility(8);
                this.lpB.setVisibility(8);
            } else if (this.fOu == 7) {
                this.lpC.setVisibility(8);
                this.kIx.setVisibility(8);
                this.lpD.setVisibility(8);
                this.lpG.setVisibility(8);
                this.lpH.setVisibility(8);
                this.lpB.setTouchEnable(false);
                ah.i(this.lql, 1500);
                this.lpB.bfe();
            } else if (this.fOu == 8) {
                this.lpE.setVisibility(0);
                this.lpF.setVisibility(0);
                this.lpF.setClipChildren(false);
                this.lpC.setVisibility(8);
                this.kIx.setVisibility(8);
                this.lpH.setVisibility(8);
                this.lpD.setVisibility(0);
                if (this.lqf > 1) {
                    this.lpG.setVisibility(0);
                }
                this.lpB.setVisibility(0);
                this.lpP.setVisibility(0);
                this.lkZ.setVisibility(8);
                this.lpQ.setVisibility(8);
                this.lpL.setVisibility(8);
                if (this.lqk) {
                    Toast.makeText(this, com.tencent.mm.plugin.w.a.f.mmsight_capture_codec_init_error, 1).show();
                } else {
                    Toast.makeText(this, com.tencent.mm.plugin.w.a.f.mmsight_capture_init_error, 1).show();
                }
                this.lpB.setTouchEnable(false);
                this.lpB.setEnabled(false);
            } else if (this.fOu == 9) {
                this.lpC.setVisibility(8);
                this.kIx.setVisibility(8);
                this.lpH.setVisibility(8);
                this.lpD.setVisibility(0);
                this.lpG.setVisibility(8);
                this.lpB.reset();
                this.lpB.setTouchEnable(false);
                this.lpB.setEnabled(false);
                Toast.makeText(this, com.tencent.mm.plugin.w.a.f.mmsight_capture_finish_error, 1).show();
            }
        }
    }

    private void gA(boolean z) {
        x.i("MicroMsg.SightCaptureUI", "[clearPhotoEditCache] isDelete:%s mLastEditPhotoPath:%s mRawEditPhotoPath:%s", new Object[]{Boolean.valueOf(z), this.lqn, this.lqm});
        if (!bi.oW(this.lqn) && z) {
            FileOp.deleteFile(this.lqn);
        }
        if (!bi.oW(this.lqm)) {
            FileOp.deleteFile(this.lqm);
        }
        this.lqn = null;
        this.lqm = null;
        ls lsVar = new ls();
        lsVar.bWh.bIH = 0;
        com.tencent.mm.sdk.b.a.sFg.m(lsVar);
    }

    public void onBackPressed() {
        x.i("MicroMsg.SightCaptureUI", "onBackPressed %d", new Object[]{Integer.valueOf(this.fOu)});
        if (this.lpR != null && this.lpR.agV()) {
            return;
        }
        if (this.lpR != null) {
            this.lpR.release();
            this.lpR = null;
            DO(8);
            this.lpC.setVisibility(0);
            this.kIx.setVisibility(0);
            this.lpH.setVisibility(0);
        } else if (bfr()) {
            super.onBackPressed();
            overridePendingTransition(-1, com.tencent.mm.plugin.w.a.a.sight_slide_bottom_out);
            gA(true);
        }
    }

    private boolean bfr() {
        return this.fOu == 4 || this.fOu == 3 || this.fOu == 1 || this.fOu == 8 || this.fOu == 9;
    }

    public final void sO(int i) {
        if (this.lqf > 1 && this.fOu != 2) {
            x.i("MicroMsg.SightCaptureUI", "onOrientationChange: %s", new Object[]{Integer.valueOf(i)});
            if (i >= 0) {
                float f;
                if (i != 90 && i != 270) {
                    f = (float) i;
                } else if (i == 270) {
                    f = 90.0f;
                } else {
                    f = -90.0f;
                }
                if (this.lpG.getRotation() != f) {
                    this.lpG.animate().rotation(f).setDuration(100).start();
                }
            }
        }
    }

    public final void ZZ() {
        x.i("MicroMsg.SightCaptureUI", "onError: %s", new Object[]{Integer.valueOf(1)});
        try {
            if (this.fam != null) {
                this.fam.reset();
            }
        } catch (Exception e) {
            x.e("MicroMsg.SightCaptureUI", "onError, reset mediaRecorder error: %s", new Object[]{e.getMessage()});
        }
        updateState(9);
    }
}
