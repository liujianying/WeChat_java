package com.tencent.mm.plugin.api.recordView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera.Parameters;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.api.recordView.g.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$c;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView$e;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.d;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.mmsight.model.e.3;
import com.tencent.mm.plugin.mmsight.model.j;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public final class f extends d implements a, com.tencent.mm.plugin.mmsight.model.a.d.a, com.tencent.mm.plugin.mmsight.model.f {
    private int audioSampleRate;
    private Context context;
    private int dQF;
    MMSightRecordView$c fbA;
    private boolean fbB = false;
    private float fbC = 1.0f;
    private byte[] fbD = null;
    private com.tencent.mm.plugin.mmsight.model.a.d fbi;
    e fbj;
    int fbk;
    float fbl;
    private int fbm;
    private boolean fbn = true;
    private ObservableTextureView fbo;
    private MMSightCameraGLSurfaceView fbp;
    boolean fbq = false;
    private MMSightRecordView.a fbr;
    boolean fbs = false;
    boolean fbt = false;
    int fbu = -1;
    Point fbv;
    private Point fbw;
    private boolean fbx = true;
    private boolean fby = true;
    private g fbz;
    private int fps;
    private int videoBitrate;
    private String videoPath;

    public final void b(Context context, ViewGroup viewGroup) {
        this.context = context;
        this.fbo = new ObservableTextureView(context);
        this.fbp = new MMSightCameraGLSurfaceView(context);
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(context, 1);
        viewGroup.addView(this.fbo, new LayoutParams(fromDPToPix, fromDPToPix));
        viewGroup.addView(this.fbp, new MarginLayoutParams(-1, -1));
        this.fbz = new g();
        this.fbz.fbL = this;
        this.fbp.setOnTouchListener(this.fbz);
        j.bdS();
        x.i("MicroMsg.MMSightRecordViewImpl", "init view, context: %s", new Object[]{context});
    }

    public final void setInitErrorCallback(MMSightRecordView$c mMSightRecordView$c) {
        this.fbA = mMSightRecordView$c;
    }

    public final void setDisplayRatio(float f) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setDisplayRatio: %s", new Object[]{Float.valueOf(f)});
        this.fbl = f;
    }

    public final void setPreviewSizeLimit(int i) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setPreviewSizeLimit: %s", new Object[]{Integer.valueOf(i)});
        this.fbk = i;
    }

    public final void startPreview() {
        x.i("MicroMsg.MMSightRecordViewImpl", "startPreview, displayRatio: %s, previewSizeLimit: %s", new Object[]{Float.valueOf(this.fbl), Integer.valueOf(this.fbk)});
        if (this.fbl > 0.0f && this.fbk > 0) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.fbk;
            videoTransPara.height = (int) (((float) this.fbk) / this.fbl);
            x.i("MicroMsg.MMSightRecordViewImpl", "para width: %s, height: %s", new Object[]{Integer.valueOf(videoTransPara.width), Integer.valueOf(videoTransPara.height)});
            this.fbj = new e(videoTransPara, -1);
            this.fbj.a(this);
            if (this.fbj.o(this.context, this.fbn)) {
                x.i("MicroMsg.MMSightRecordViewImpl", "open camera finish");
                if (this.fbo.isAvailable()) {
                    if (this.fbj.a(this.fbo.getSurfaceTexture(), this.fbk, this.fbl, this.fbs) < 0) {
                        x.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                        if (this.fbA != null) {
                            this.fbA.aiL();
                        }
                    }
                    if (this.fbu != -1) {
                        ZW();
                    }
                    this.fbj.bdM();
                    x.i("MicroMsg.MMSightRecordViewImpl", "do start preview directly");
                    ZT();
                    return;
                }
                this.fbo.setTextureChangeCallback(new b() {
                    public final void d(SurfaceTexture surfaceTexture) {
                        if (f.this.fbj.a(surfaceTexture, f.this.fbk, f.this.fbl, f.this.fbs) < 0) {
                            x.e("MicroMsg.MMSightRecordViewImpl", "start preview failed!");
                            if (f.this.fbA != null) {
                                f.this.fbA.aiL();
                            }
                        }
                        if (f.this.fbu != -1) {
                            f.this.ZW();
                        }
                        f.this.fbj.bdM();
                        f.this.ZT();
                        x.i("MicroMsg.MMSightRecordViewImpl", "do start preview after texture available");
                    }
                });
                return;
            }
            x.i("MicroMsg.MMSightRecordViewImpl", "open camera failed!");
            if (this.fbA != null) {
                this.fbA.aiL();
            }
        }
    }

    public final void setVideoPara$2e715812(int i) {
        this.fbm = i;
        this.videoBitrate = 4800000;
        this.fps = 30;
        this.dQF = 64000;
        this.audioSampleRate = 44100;
        x.i("MicroMsg.MMSightRecordViewImpl", "setVideoPara, maxDuration: %s, videoBitrate: %s, fps: %s, audioBitrate: %s, audioSampleRate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(4800000), Integer.valueOf(30), Integer.valueOf(64000), Integer.valueOf(44100)});
    }

    public final void setVideoFilePath(String str) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setVideoFilePath: %s", new Object[]{str});
        this.videoPath = str;
    }

    public final String getVideoFilePath() {
        if (this.fbi == null || !this.fbq) {
            return this.videoPath;
        }
        return this.fbi.getFilePath();
    }

    public final void ZS() {
        ZT();
    }

    final void ZT() {
        if (this.fbq) {
            x.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, already init");
            return;
        }
        if (this.fbi != null) {
            x.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder not null, stop first");
            this.fbi.cancel();
            if (this.fbj != null) {
                this.fbj.b(this.fbi.bem());
            }
            this.fbi = null;
        }
        if (this.fbk > 0 && this.fbm > 0 && this.videoBitrate > 0 && this.fps > 0 && this.dQF > 0 && this.audioSampleRate > 0 && this.fbj != null && this.fbj.lfD != null) {
            VideoTransPara videoTransPara = new VideoTransPara();
            videoTransPara.width = this.fbk;
            videoTransPara.height = (int) (((float) this.fbk) / this.fbl);
            videoTransPara.duration = this.fbm;
            videoTransPara.videoBitrate = this.videoBitrate;
            videoTransPara.fps = this.fps;
            videoTransPara.dQF = this.dQF;
            videoTransPara.audioSampleRate = this.audioSampleRate;
            videoTransPara.dQH = 2;
            videoTransPara.dQI = 1;
            videoTransPara.dQG = 1;
            j.lgz.lem = videoTransPara;
            j.lgz.videoBitrate = this.videoBitrate;
            j.lgz.lfa = this.fbk;
            k.bey();
            this.fbi = k.d(videoTransPara);
            if (this.fbi == null) {
                x.e("MicroMsg.MMSightRecordViewImpl", "can not get media recorder!");
                if (this.fbA != null) {
                    this.fbA.aiL();
                    return;
                }
                return;
            }
            this.fbi.setFilePath(this.videoPath);
            if (this.fbs && this.fbj != null && this.fbj.lfu) {
                ZU();
            }
            int i = this.fbj.lfD.x;
            int i2 = this.fbj.lfD.y;
            if (this.fbw != null && this.fbs) {
                i = this.fbw.x;
                i2 = this.fbw.y;
            }
            i2 = (int) (((float) i2) * this.fbC);
            i = com.tencent.mm.plugin.mmsight.d.sM((int) (((float) i) * this.fbC));
            i2 = com.tencent.mm.plugin.mmsight.d.sM(i2);
            x.i("MicroMsg.MMSightRecordViewImpl", "initRecorder, videoWidth: %s, videoHeight: %s, videoSizeRatio: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(this.fbC)});
            if (this.fbw == null || !this.fbs) {
                this.fbi.p(this.fbj.getPreviewWidth(), this.fbj.getPreviewHeight(), i, i2);
            } else {
                this.fbi.p(this.fbw.y, this.fbw.x, i, i2);
            }
            this.fbi.beu();
            this.fbi.a(this);
            if (this.fbi.sQ(this.fbj.getOrientation())) {
                this.fbq = true;
                return;
            }
            x.e("MicroMsg.MMSightRecordViewImpl", "init recorder error");
            if (this.fbA != null) {
                this.fbA.aiL();
            }
        }
    }

    public final boolean wn() {
        x.i("MicroMsg.MMSightRecordViewImpl", "startRecord, recorder: %s", new Object[]{this.fbi});
        ZT();
        if (this.fbi == null) {
            x.e("MicroMsg.MMSightRecordViewImpl", "startRecord error, recorder is null!");
            return false;
        }
        x.i("MicroMsg.MMSightRecordViewImpl", "startRecord now, ret: %s", new Object[]{Integer.valueOf(this.fbi.d(this.fbj.getOrientation(), false, 0))});
        if (this.fbi.d(this.fbj.getOrientation(), false, 0) >= 0) {
            return true;
        }
        return false;
    }

    public final void a(final com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f fVar) {
        if (this.fbi != null) {
            x.i("MicroMsg.MMSightRecordViewImpl", "stopRecord, stopCallback: %s", new Object[]{fVar});
            this.fbi.a(new 2(this, fVar));
            this.fbi.E(new Runnable() {
                public final void run() {
                    f.this.fbq = false;
                    if (fVar != null) {
                        fVar.cN(false);
                    }
                }
            });
            this.fbi = null;
        }
    }

    public final void a(MMSightRecordView$e mMSightRecordView$e, boolean z) {
        if (mMSightRecordView$e != null && this.fbj != null && this.fbj.lfu) {
            if (z) {
                this.fbj.bdQ();
            }
            if (z) {
                ah.i(new 4(this, mMSightRecordView$e, z), 100);
            } else {
                b(mMSightRecordView$e, z);
            }
        }
    }

    final void b(MMSightRecordView$e mMSightRecordView$e, boolean z) {
        this.fbj.a(new 5(this, z, mMSightRecordView$e), false, 0);
    }

    public final void setUseBackCamera(boolean z) {
        x.i("MicroMsg.MMSightRecordViewImpl", "setUseBackCamera: %s", new Object[]{Boolean.valueOf(z)});
        this.fbn = z;
    }

    public final Point getPictureSize() {
        if (this.fbj == null || !this.fbj.lfu) {
            return null;
        }
        if (!this.fbt) {
            return new Point(this.fbj.getPreviewWidth(), this.fbj.getPreviewHeight());
        }
        ZV();
        return this.fbv;
    }

    public final Point getVideoSize() {
        if (this.fbj == null || !this.fbj.lfu) {
            return null;
        }
        int i = this.fbj.lfD.x;
        int i2 = this.fbj.lfD.y;
        if (this.fbw != null && this.fbs) {
            i = this.fbw.x;
            i2 = this.fbw.y;
        }
        return new Point(com.tencent.mm.plugin.mmsight.d.sM((int) (((float) i) * this.fbC)), com.tencent.mm.plugin.mmsight.d.sM((int) (((float) i2) * this.fbC)));
    }

    public final void setFrameDataCallback(MMSightRecordView.a aVar) {
        this.fbr = aVar;
    }

    public final int getCameraRotation() {
        if (this.fbj != null) {
            return this.fbj.getOrientation();
        }
        return 0;
    }

    public final void switchCamera() {
        if (this.fbj != null && this.fbj.lfu) {
            if (this.fbi == null || this.fbi.ben() != c.lhC) {
                this.fbj.a(this.context, this.fbo.getSurfaceTexture(), this.fbk, this.fbl, this.fbs);
            }
        }
    }

    public final void setClipVideoSize(boolean z) {
        this.fbs = z;
        if (this.fbs && this.fbj != null && this.fbj.lfu) {
            ZU();
        }
    }

    private void ZU() {
        if (this.fbj != null && this.fbj.lfu) {
            if (this.fbj.lfW) {
                this.fbw = new Point(com.tencent.mm.plugin.mmsight.d.cP((int) (((float) this.fbj.getPreviewWidth()) / this.fbl), this.fbj.getPreviewHeight()), this.fbj.getPreviewWidth());
                return;
            }
            this.fbw = new Point(this.fbj.getPreviewHeight(), com.tencent.mm.plugin.mmsight.d.cP((int) (((float) this.fbj.getPreviewHeight()) * this.fbl), this.fbj.getPreviewWidth()));
        }
    }

    public final void setClipPictureSize(boolean z) {
        this.fbt = z;
        if (this.fbt && this.fbj != null && this.fbj.lfu) {
            ZV();
        }
    }

    final void ZV() {
        if (this.fbj != null && this.fbj.lfu) {
            if (this.fbj.lfW) {
                this.fbv = new Point(this.fbj.getPreviewWidth(), (int) (((float) this.fbj.getPreviewWidth()) / this.fbl));
                return;
            }
            this.fbv = new Point((int) (((float) this.fbj.getPreviewHeight()) * this.fbl), this.fbj.getPreviewHeight());
        }
    }

    public final void setFlashMode(int i) {
        boolean z = true;
        this.fbu = i;
        String str = "MicroMsg.MMSightRecordViewImpl";
        String str2 = "setFlashMode: %s, camera: %s, previewing: %s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = this.fbj;
        if (this.fbj == null || !this.fbj.lfu) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.fbj != null && this.fbj.lfu) {
            ZW();
        }
    }

    final void ZW() {
        x.i("MicroMsg.MMSightRecordViewImpl", "setFlashModeImpl, mode: %s", new Object[]{Integer.valueOf(this.fbu)});
        switch (this.fbu) {
            case 1:
                this.fbj.bdQ();
                return;
            case 2:
                this.fbj.bdR();
                return;
            case 3:
                e eVar = this.fbj;
                x.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", new Object[]{eVar.ddt, Boolean.valueOf(eVar.lfu)});
                if (eVar.ddt != null && eVar.lfu) {
                    try {
                        eVar.lfJ = true;
                        Parameters parameters = eVar.ddt.getParameters();
                        if (bi.cX(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("auto")) {
                            x.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
                            return;
                        }
                        parameters.setFlashMode("auto");
                        eVar.ddt.setParameters(parameters);
                        x.i("MicroMsg.MMSightCamera", "auto flash");
                        return;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.MMSightCamera", e, "autoFlash error: %s", new Object[]{e.getMessage()});
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    public final int getFlashMode() {
        return this.fbu;
    }

    public final void setEnableDragZoom(boolean z) {
        this.fbx = z;
    }

    public final void setEnableTouchFocus(boolean z) {
        this.fby = z;
    }

    public final void ZX() {
        x.i("MicroMsg.MMSightRecordViewImpl", "setHalfPreviewVideoSize");
        this.fbC = 0.5f;
    }

    public final void ZY() {
        x.i("MicroMsg.MMSightRecordViewImpl", "set34PreviewVideoSize");
        this.fbC = 0.75f;
    }

    public final Bitmap getCurrentFramePicture() {
        if (this.fbj == null || !this.fbj.lfu) {
            return null;
        }
        byte[] bArr;
        e eVar = this.fbj;
        if (eVar.lfU != null) {
            eVar.lfV = true;
            bArr = new byte[eVar.lfU.length];
            System.arraycopy(eVar.lfU, 0, bArr, 0, eVar.lfU.length);
            eVar.lfV = false;
        } else {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        byte[] i;
        byte[] bArr2;
        int previewWidth = this.fbj.getPreviewWidth();
        int previewHeight = this.fbj.getPreviewHeight();
        if (this.fbj.lfW) {
            int previewWidth2 = (int) (((float) this.fbj.getPreviewWidth()) / this.fbl);
            if (previewWidth2 < previewHeight) {
                if (this.fbs || this.fbD != null) {
                    i = com.tencent.mm.plugin.mmsight.model.a.j.lin.i(Integer.valueOf(((this.fbw.x * this.fbw.y) * 3) >> 1));
                } else {
                    this.fbD = new byte[(((previewWidth * previewWidth2) * 3) >> 1)];
                    i = this.fbD;
                }
                SightVideoJNI.cropCameraDataLongEdge(bArr, i, previewHeight, this.fbw.x, previewWidth);
                if (this.fbs) {
                    previewWidth2 = this.fbw.x;
                }
                this.fbB = true;
                previewHeight = previewWidth2;
            } else {
                i = bArr;
            }
            bArr2 = i;
        } else {
            int i2 = (int) (((float) previewHeight) * this.fbl);
            if (i2 < previewWidth) {
                if (this.fbs || this.fbD != null) {
                    i = com.tencent.mm.plugin.mmsight.model.a.j.lin.i(Integer.valueOf(((this.fbw.x * this.fbw.y) * 3) >> 1));
                } else {
                    this.fbD = new byte[(((i2 * previewHeight) * 3) >> 1)];
                    i = this.fbD;
                }
                SightVideoJNI.cropCameraData(bArr, i, previewHeight, previewWidth, this.fbw.y);
                previewWidth = this.fbw.y;
                this.fbB = true;
                bArr2 = i;
            } else {
                bArr2 = bArr;
            }
        }
        YuvImage yuvImage = new YuvImage(bArr2, 17, previewHeight, previewWidth, null);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, previewHeight, previewWidth), 100, byteArrayOutputStream);
        i = byteArrayOutputStream.toByteArray();
        Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(i, 0, i.length);
        Bitmap b = com.tencent.mm.sdk.platformtools.c.b(decodeByteArray, (float) this.fbj.getOrientation());
        decodeByteArray.recycle();
        return b;
    }

    public final void release() {
        x.i("MicroMsg.MMSightRecordViewImpl", "release, camera: %s, recorder: %s", new Object[]{this.fbj, this.fbi});
        if (this.fbj != null) {
            this.fbj.bdL();
        }
        if (this.fbi != null) {
            this.fbi.E(null);
            this.fbi = null;
        }
        this.fbq = false;
        this.fbs = false;
        this.fbt = false;
        this.fbv = null;
        this.fbw = null;
        this.fbu = -1;
        this.fbx = true;
        this.fby = true;
        com.tencent.mm.plugin.mmsight.model.a.j.lin.Fm();
    }

    public final boolean T(byte[] bArr) {
        int i = 0;
        if (bArr == null) {
            return false;
        }
        byte[] bArr2;
        int previewHeight;
        int previewWidth;
        boolean z;
        if (this.fbl <= 0.0f || this.fbk <= 0 || this.fbj == null) {
            bArr2 = bArr;
        } else {
            int previewWidth2 = this.fbj.getPreviewWidth();
            previewHeight = this.fbj.getPreviewHeight();
            if (this.fbj.lfW) {
                previewWidth = (int) (((float) this.fbj.getPreviewWidth()) / this.fbl);
                if (previewWidth < previewHeight) {
                    if (this.fbs || this.fbD != null) {
                        bArr2 = com.tencent.mm.plugin.mmsight.model.a.j.lin.i(Integer.valueOf(((this.fbw.x * this.fbw.y) * 3) >> 1));
                    } else {
                        this.fbD = new byte[(((previewWidth2 * previewWidth) * 3) >> 1)];
                        bArr2 = this.fbD;
                    }
                    bi.VG();
                    SightVideoJNI.cropCameraDataLongEdge(bArr, bArr2, previewHeight, this.fbw.x, previewWidth2);
                    if (this.fbs) {
                        previewWidth = this.fbw.x;
                    }
                    this.fbB = true;
                } else {
                    previewWidth = previewHeight;
                    bArr2 = bArr;
                }
                previewHeight = previewWidth;
            } else {
                int i2 = (int) (((float) previewHeight) * this.fbl);
                if (i2 < previewWidth2) {
                    if (this.fbs || this.fbD != null) {
                        bArr2 = com.tencent.mm.plugin.mmsight.model.a.j.lin.i(Integer.valueOf(((this.fbw.x * this.fbw.y) * 3) >> 1));
                    } else {
                        this.fbD = new byte[(((i2 * previewHeight) * 3) >> 1)];
                        bArr2 = this.fbD;
                    }
                    bi.VG();
                    SightVideoJNI.cropCameraData(bArr, bArr2, previewHeight, previewWidth2, this.fbw.y);
                    previewWidth = this.fbw.y;
                    this.fbB = true;
                    previewWidth2 = previewWidth;
                } else {
                    bArr2 = bArr;
                }
            }
            if (this.fbp != null) {
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView = this.fbp;
                int orientation = this.fbj.getOrientation();
                if (!(previewHeight == mMSightCameraGLSurfaceView.fau && previewWidth2 == mMSightCameraGLSurfaceView.fav && orientation == mMSightCameraGLSurfaceView.faO)) {
                    x.i("MicroMsg.MMSightCameraGLSurfaceView", "setFrameInfo, width: %s, height: %s, rotate: %s this: %s", new Object[]{Integer.valueOf(previewHeight), Integer.valueOf(previewWidth2), Integer.valueOf(orientation), mMSightCameraGLSurfaceView});
                    mMSightCameraGLSurfaceView.fau = previewHeight;
                    mMSightCameraGLSurfaceView.fav = previewWidth2;
                    mMSightCameraGLSurfaceView.faO = orientation;
                }
                MMSightCameraGLSurfaceView mMSightCameraGLSurfaceView2 = this.fbp;
                if (bArr2 == null || mMSightCameraGLSurfaceView2.faM == null || mMSightCameraGLSurfaceView2.faM.bum) {
                    x.v("MicroMsg.MMSightCameraGLSurfaceView", "passing draw");
                } else {
                    a aVar = mMSightCameraGLSurfaceView2.faM;
                    orientation = mMSightCameraGLSurfaceView2.fau;
                    int i3 = mMSightCameraGLSurfaceView2.fav;
                    int i4 = mMSightCameraGLSurfaceView2.faO;
                    try {
                        if (aVar.fav == i3 && aVar.fau == orientation && aVar.bYE == i4 && !aVar.faL) {
                            previewWidth = 0;
                        } else {
                            previewWidth = true;
                        }
                        if (previewWidth != 0) {
                            x.d("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame, frameData: %s, frameWidth: %s, frameHeight: %s, rotate: %s, isLandScape, frameSizeChange: %s, this %s", new Object[]{bArr2, Integer.valueOf(orientation), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(false), Boolean.valueOf(true), aVar});
                        }
                        aVar.fat = bArr2;
                        aVar.fau = orientation;
                        aVar.fav = i3;
                        aVar.bYE = i4;
                        aVar.faL = false;
                        if (previewWidth != 0) {
                            aVar.faw = ByteBuffer.allocateDirect(i3 * orientation);
                            aVar.fax = ByteBuffer.allocateDirect((orientation * i3) / 2);
                            aVar.faw.order(ByteOrder.nativeOrder());
                            aVar.fax.order(ByteOrder.nativeOrder());
                            aVar.faK = a.fao;
                            if (aVar.faK != null) {
                                aVar.faG.put(aVar.faK);
                                aVar.faG.position(0);
                            }
                        }
                        if (!(aVar.faw == null || aVar.fax == null)) {
                            aVar.faw.put(bArr2, 0, orientation * i3);
                            aVar.faw.position(0);
                            aVar.fax.put(bArr2, orientation * i3, (orientation * i3) / 2);
                            aVar.fax.position(0);
                        }
                    } catch (Exception e) {
                        x.e("MicroMsg.MMSightCameraGLRenderer", "setDrawFrame error: %s", new Object[]{e.getMessage()});
                    }
                    mMSightCameraGLSurfaceView2.requestRender();
                }
            }
        }
        if (this.fbr != null) {
            MMSightRecordView.a aVar2 = this.fbr;
            previewWidth = (this.fbj.getOrientation() == 0 || this.fbj.getOrientation() == 180) ? this.fbj.getPreviewWidth() : this.fbj.getPreviewHeight();
            previewHeight = (this.fbj.getOrientation() == 0 || this.fbj.getOrientation() == 180) ? this.fbj.getPreviewHeight() : this.fbj.getPreviewWidth();
            aVar2.n(bArr, previewWidth, previewHeight);
        }
        if (this.fbi == null || this.fbi.bem() == null) {
            z = true;
        } else if (this.fbs && this.fbB) {
            z = this.fbi.bem().T(bArr2);
            i = 1;
        } else {
            z = this.fbi.bem().T(bArr);
        }
        if (i != 0 && (this.fbi == null || this.fbi.ben() != c.lhC)) {
            com.tencent.mm.plugin.mmsight.model.a.j.lin.F(bArr2);
        }
        return z;
    }

    public final void ZZ() {
        x.i("MicroMsg.MMSightRecordViewImpl", "onError: %s", new Object[]{Integer.valueOf(1)});
        this.fbi.reset();
    }

    public final void aaa() {
        if (this.fbj != null && this.fbj.lfu && this.fby) {
            e eVar = this.fbj;
            if (eVar.ddt != null && eVar.lfu) {
                Parameters parameters = eVar.ddt.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                    x.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                    parameters.setFocusMode("auto");
                    eVar.ddt.setParameters(parameters);
                }
                eVar.ddt.cancelAutoFocus();
                eVar.ddt.autoFocus(new 3(eVar));
            }
        }
    }

    public final void aab() {
        if (this.fbj != null && this.fbj.lfu && this.fbx) {
            this.fbj.b(true, false, 1);
        }
    }

    public final void aac() {
        if (this.fbj != null && this.fbj.lfu && this.fbx) {
            this.fbj.b(false, false, 1);
        }
    }
}
