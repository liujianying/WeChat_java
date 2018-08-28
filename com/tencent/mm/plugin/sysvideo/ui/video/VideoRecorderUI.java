package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.media.ThumbnailUtils;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bp.a;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.io.InputStream;

public class VideoRecorderUI extends MMActivity {
    private static VideoRecorderUI ovi;
    private ProgressDialog eHw = null;
    private SurfaceView fAd = null;
    private long hng = -1;
    private al hnz = new al(new 1(this), true);
    private boolean mNn;
    private String ouP = null;
    private SurfaceHolder ouT = null;
    private b ouU;
    private ImageButton ouV;
    private boolean ouW = false;
    private boolean ouX = false;
    private TextView ouY;
    private LinearLayout ouZ;
    private ImageView ova;
    private ImageButton ovb = null;
    private ImageView ovc;
    private TextView ovd;
    private TextView ove;
    private TextView ovf;
    private int ovg = 0;
    private ImageButton ovh;
    private boolean ovj = false;
    private boolean ovk = true;
    private String ovl = null;
    private String ovm = null;
    private View ovn;
    private View ovo;
    private ag ovp = new ag() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            VideoRecorderUI.this.ovh.setEnabled(true);
        }
    };
    Callback ovq = new 3(this);
    private String talker = null;
    private String videoPath = null;

    static /* synthetic */ void d(VideoRecorderUI videoRecorderUI) {
        Bitmap createVideoThumbnail;
        Throwable e;
        String str;
        TextView textView;
        CharSequence charSequence;
        videoRecorderUI.ouX = false;
        videoRecorderUI.releaseWakeLock();
        videoRecorderUI.ouV.setImageResource(R.g.video_recorder_start_btn);
        videoRecorderUI.ouV.setEnabled(false);
        videoRecorderUI.getString(R.l.app_tip);
        videoRecorderUI.eHw = h.a(videoRecorderUI, videoRecorderUI.getString(R.l.video_compressing, new Object[]{Integer.valueOf(0)}), true, new 2(videoRecorderUI));
        long elapsedRealtime = SystemClock.elapsedRealtime() - videoRecorderUI.hng;
        videoRecorderUI.hnz.SO();
        videoRecorderUI.ouY.setVisibility(8);
        videoRecorderUI.ouW = true;
        b bVar = videoRecorderUI.ouU;
        if (bVar.lik != null) {
            try {
                bVar.lik.stop();
                bVar.lik.release();
            } catch (Exception e2) {
                x.e("MicroMsg.SceneVideo", "video[tiger] video stop failed");
            }
            bVar.lik = null;
            bVar.ngs.enM = (int) (elapsedRealtime / 1000);
            bVar.ngs.enM = bVar.ngs.enM > 0 ? bVar.ngs.enM : 1;
            bVar.ngs.lha = bVar.ngs.enM * bVar.ngs.fps;
            if (!(!e.cn(bVar.ngs.lgZ) || e.cn(bVar.ngs.lgX) || bVar.context == null)) {
                createVideoThumbnail = d.fR(8) ? ThumbnailUtils.createVideoThumbnail(bVar.ngs.lgZ, 1) : null;
                if (createVideoThumbnail != null) {
                    try {
                        x.d("MicroMsg.SceneVideo", "saveBitmapToImage " + bVar.ngs.lgX);
                        com.tencent.mm.pluginsdk.i.e.a(createVideoThumbnail, CompressFormat.JPEG, bVar.ngs.lgX);
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                    }
                } else {
                    InputStream openRawResource;
                    try {
                        openRawResource = bVar.context.getResources().openRawResource(R.g.copyright);
                        try {
                            com.tencent.mm.pluginsdk.i.e.a(BitmapFactory.decodeStream(openRawResource), CompressFormat.JPEG, bVar.ngs.lgX);
                            if (openRawResource != null) {
                                try {
                                    openRawResource.close();
                                } catch (Throwable e32) {
                                    x.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                }
                            }
                        } catch (Exception e4) {
                            e32 = e4;
                            try {
                                x.printErrStackTrace("MicroMsg.SceneVideo", e32, "", new Object[0]);
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Throwable e322) {
                                        x.printErrStackTrace("MicroMsg.SceneVideo", e322, "", new Object[0]);
                                    }
                                }
                                if (e.cn(bVar.ngs.lgZ)) {
                                    bVar.fileSize = e.cm(bVar.ngs.lgZ);
                                }
                                str = videoRecorderUI.ouU.ngs.lgX;
                                if (str != null) {
                                }
                                createVideoThumbnail = null;
                                if (createVideoThumbnail != null) {
                                    videoRecorderUI.fAd.setVisibility(8);
                                    videoRecorderUI.ova.setVisibility(0);
                                    videoRecorderUI.ova.setImageBitmap(createVideoThumbnail);
                                }
                                if (videoRecorderUI.eHw != null) {
                                    videoRecorderUI.eHw.dismiss();
                                    videoRecorderUI.eHw = null;
                                }
                                videoRecorderUI.ouY.setVisibility(8);
                                videoRecorderUI.ovo.setVisibility(0);
                                textView = videoRecorderUI.ove;
                                elapsedRealtime = (long) videoRecorderUI.ouU.fileSize;
                                charSequence = (elapsedRealtime >> 20) <= 0 ? (elapsedRealtime >> 9) > 0 ? (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1024.0f)) / 10.0f) + "KB" : elapsedRealtime + "B" : (((float) Math.round((((float) elapsedRealtime) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
                                textView.setText(charSequence);
                                videoRecorderUI.ovf.setText(com.tencent.mm.pluginsdk.i.e.iR(videoRecorderUI.ouU.ngs.enM));
                                videoRecorderUI.ouZ.setVisibility(8);
                                videoRecorderUI.ovb.setVisibility(0);
                                videoRecorderUI.ovn.setVisibility(8);
                                videoRecorderUI.ovh.setVisibility(8);
                                videoRecorderUI.ouV.setVisibility(8);
                                videoRecorderUI.ouV.setEnabled(true);
                                videoRecorderUI.getWindow().clearFlags(1024);
                                videoRecorderUI.getSupportActionBar().show();
                            } catch (Throwable th) {
                                e322 = th;
                                if (openRawResource != null) {
                                    try {
                                        openRawResource.close();
                                    } catch (Throwable e5) {
                                        x.printErrStackTrace("MicroMsg.SceneVideo", e5, "", new Object[0]);
                                    }
                                }
                                throw e322;
                            }
                        }
                    } catch (Exception e6) {
                        e322 = e6;
                        openRawResource = null;
                    } catch (Throwable th2) {
                        e322 = th2;
                        openRawResource = null;
                        if (openRawResource != null) {
                            try {
                                openRawResource.close();
                            } catch (Throwable e52) {
                                x.printErrStackTrace("MicroMsg.SceneVideo", e52, "", new Object[0]);
                            }
                        }
                        throw e322;
                    }
                }
            }
            if (e.cn(bVar.ngs.lgZ)) {
                bVar.fileSize = e.cm(bVar.ngs.lgZ);
            }
        }
        str = videoRecorderUI.ouU.ngs.lgX;
        if (str != null || str.length() <= 0) {
            createVideoThumbnail = null;
        } else {
            Bitmap e7 = BackwardSupportUtil.b.e(str.trim(), a.getDensity(videoRecorderUI));
            if (e7 != null) {
                int width = e7.getWidth();
                int height = e7.getHeight();
                int b = BackwardSupportUtil.b.b(videoRecorderUI, 224.0f);
                createVideoThumbnail = Bitmap.createScaledBitmap(e7, b, (int) (((float) height) / (((float) width) / ((float) b))), true);
                if (e7 != createVideoThumbnail) {
                    x.i("MicroMsg.SceneVideo", "recycle bitmap:%s", new Object[]{e7.toString()});
                    e7.recycle();
                }
            } else {
                createVideoThumbnail = e7;
            }
        }
        if (createVideoThumbnail != null) {
            videoRecorderUI.fAd.setVisibility(8);
            videoRecorderUI.ova.setVisibility(0);
            videoRecorderUI.ova.setImageBitmap(createVideoThumbnail);
        }
        if (videoRecorderUI.eHw != null) {
            videoRecorderUI.eHw.dismiss();
            videoRecorderUI.eHw = null;
        }
        videoRecorderUI.ouY.setVisibility(8);
        videoRecorderUI.ovo.setVisibility(0);
        textView = videoRecorderUI.ove;
        elapsedRealtime = (long) videoRecorderUI.ouU.fileSize;
        if ((elapsedRealtime >> 20) <= 0) {
        }
        textView.setText(charSequence);
        videoRecorderUI.ovf.setText(com.tencent.mm.pluginsdk.i.e.iR(videoRecorderUI.ouU.ngs.enM));
        videoRecorderUI.ouZ.setVisibility(8);
        videoRecorderUI.ovb.setVisibility(0);
        videoRecorderUI.ovn.setVisibility(8);
        videoRecorderUI.ovh.setVisibility(8);
        videoRecorderUI.ouV.setVisibility(8);
        videoRecorderUI.ouV.setEnabled(true);
        videoRecorderUI.getWindow().clearFlags(1024);
        videoRecorderUI.getSupportActionBar().show();
    }

    static /* synthetic */ void n(VideoRecorderUI videoRecorderUI) {
        videoRecorderUI.mController.hideTitleView();
        videoRecorderUI.ouZ.setVisibility(0);
        videoRecorderUI.fAd.setVisibility(0);
        videoRecorderUI.ovh.setVisibility(8);
        videoRecorderUI.ovo.setVisibility(8);
        videoRecorderUI.ouX = true;
        videoRecorderUI.ova.setVisibility(8);
        videoRecorderUI.ovb.setVisibility(8);
        videoRecorderUI.ovn.setVisibility(0);
        videoRecorderUI.ouY.setVisibility(0);
        videoRecorderUI.hng = -1;
        videoRecorderUI.hnz.J(300, 300);
        videoRecorderUI.fAd.setKeepScreenOn(true);
        b bVar = videoRecorderUI.ouU;
        SurfaceHolder surfaceHolder = videoRecorderUI.ouT;
        if (surfaceHolder == null) {
            x.e("MicroMsg.SceneVideo", "start fail, holder is null");
            return;
        }
        Surface surface = surfaceHolder.getSurface();
        bVar.qDS = 0;
        int i = bVar.ngs.fps;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (bVar.qDR == null) {
                x.e("MicroMsg.SceneVideo", "yuvRecoder is null");
                return;
            }
            Camera camera = bVar.qDR.ddt;
            if (surface == null || camera == null) {
                x.e("MicroMsg.SceneVideo", "holder or cam is null ");
            } else {
                i = q.deW.ddS == -1 ? i3 : q.deW.ddS;
                int cameraId = f.getCameraId();
                try {
                    camera.unlock();
                } catch (Exception e) {
                    x.w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", new Object[]{e.getMessage()});
                }
                bVar.lik = new MediaRecorder();
                bVar.lik.setCamera(camera);
                bVar.lik.setAudioSource(5);
                bVar.lik.setVideoSource(1);
                bVar.lik.setOutputFormat(2);
                bVar.lik.setVideoSize(bVar.ngs.iSp, bVar.ngs.iSq);
                bVar.lik.setVideoEncoder(2);
                bVar.lik.setAudioEncoder(3);
                if (VERSION.SDK_INT > 7) {
                    bVar.lik.setVideoEncodingBitRate(bVar.ngs.lgQ);
                }
                try {
                    if (q.deO.dfq) {
                        bVar.lik.setVideoFrameRate(q.deO.dfr);
                    } else {
                        bVar.lik.setVideoFrameRate(i);
                    }
                } catch (Exception e2) {
                    x.d("MicroMsg.SceneVideo", "try set fps failed: " + i);
                }
                bVar.lik.setOutputFile(bVar.ngs.lgZ);
                bVar.lik.setPreviewDisplay(surface);
                x.d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", new Object[]{Integer.valueOf(cameraId), bVar.ngs.toString()});
                if (cameraId == 0) {
                    bVar.setOrientationHint(q.deW.ddM == -1 ? 90 : q.deW.ddM);
                } else {
                    bVar.setOrientationHint(q.deW.ddN == -1 ? 270 : q.deW.ddN);
                }
                try {
                    bVar.lik.prepare();
                    bVar.lik.start();
                    return;
                } catch (Throwable e3) {
                    x.w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", new Object[]{e3.getMessage(), Integer.valueOf(bVar.qDS)});
                    x.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                    bVar.qDS++;
                    if (bVar.qDS < 5) {
                        f fVar = bVar.qDR;
                        if (i2 < 0 || i2 >= fVar.qEc.size()) {
                            x.d("MicroMsg.YuvReocrder", "ret fr " + i3);
                        } else {
                            x.d("MicroMsg.YuvReocrder", "ret fr " + fVar.qEc.get(i2));
                            i3 = ((Integer) fVar.qEc.get(i2)).intValue();
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
        x.e("MicroMsg.SceneVideo", "holder or cam is null ");
    }

    static /* synthetic */ void x(VideoRecorderUI videoRecorderUI) {
        int previewWidth;
        int previewHeight;
        LayoutParams layoutParams = (LayoutParams) videoRecorderUI.fAd.getLayoutParams();
        DisplayMetrics displayMetrics = videoRecorderUI.getResources().getDisplayMetrics();
        if (videoRecorderUI.mNn) {
            previewWidth = videoRecorderUI.ouU.getPreviewWidth();
            previewHeight = videoRecorderUI.ouU.getPreviewHeight();
        } else {
            previewWidth = videoRecorderUI.ouU.getPreviewHeight();
            previewHeight = videoRecorderUI.ouU.getPreviewWidth();
        }
        x.i("MicroMsg.VideoRecorderUI", "resizeLayout priveview[%d, %d], dm[%d, %d]", new Object[]{Integer.valueOf(previewWidth), Integer.valueOf(previewHeight), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        if (((float) previewWidth) / ((float) previewHeight) > ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels)) {
            x.i("MicroMsg.VideoRecorderUI", "resizeLayout wider");
            previewHeight = (int) (((float) previewHeight) * (((float) displayMetrics.widthPixels) / ((float) previewWidth)));
            previewWidth = displayMetrics.widthPixels;
        } else {
            x.i("MicroMsg.VideoRecorderUI", "resizeLayout higher");
            previewWidth = (int) ((((float) displayMetrics.heightPixels) / ((float) previewHeight)) * ((float) previewWidth));
            previewHeight = displayMetrics.heightPixels;
        }
        x.i("MicroMsg.VideoRecorderUI", "resizeLayout width:%d, height:%d", new Object[]{Integer.valueOf(previewWidth), Integer.valueOf(previewHeight)});
        layoutParams.width = previewWidth;
        layoutParams.height = previewHeight;
        videoRecorderUI.fAd.setLayoutParams(layoutParams);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        s.initLanguage(this);
        ovi = this;
        getWindow().setFlags(1024, 1024);
        getSupportActionBar().hide();
        setMMTitle(R.l.video_recorder_title);
        a(0, getString(R.l.app_send), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("VideoRecorder_FileName", VideoRecorderUI.this.ouU.filename);
                intent.putExtra("VideoRecorder_VideoLength", VideoRecorderUI.this.ouU.ngs.enM);
                intent.putExtra("VideoRecorder_ToUser", VideoRecorderUI.this.talker);
                VideoRecorderUI.this.setResult(-1, intent);
                VideoRecorderUI.this.finish();
                return true;
            }
        }, s.b.tmX);
        setBackBtn(new 6(this));
        this.talker = getIntent().getStringExtra("VideoRecorder_ToUser");
        this.videoPath = getIntent().getStringExtra("VideoRecorder_VideoPath");
        this.ouP = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
        this.ovl = getIntent().getStringExtra("VideoRecorder_VideoThumbPath");
        this.ovm = getIntent().getStringExtra("VideoRecorder_FileName");
        x.d("MicroMsg.VideoRecorderUI", "talker :" + this.talker);
        x.d("MicroMsg.VideoRecorderUI", "videoPath :" + this.videoPath + " videoFullPath " + this.ouP + " videoThumbPath " + this.ovl + " KFileName " + this.ovm);
        initView();
        aXL();
        au.vv().xv();
    }

    public void onStart() {
        super.onStart();
        if (this.mNn) {
            setRequestedOrientation(0);
        } else {
            setRequestedOrientation(1);
        }
    }

    protected void onDestroy() {
        ovi = null;
        x.v("MicroMsg.VideoRecorderUI", "on destroy");
        au.vv().xu();
        super.onDestroy();
    }

    protected final void initView() {
        int i = 1;
        this.fAd = (SurfaceView) findViewById(R.h.surface_camera);
        this.ouZ = (LinearLayout) findViewById(R.h.video_recorder_preview_area);
        this.ouT = this.fAd.getHolder();
        this.ouT.addCallback(this.ovq);
        this.ouT.setType(3);
        this.ovc = (ImageView) findViewById(R.h.video_recorder_recording_icon);
        this.ovh = (ImageButton) findViewById(R.h.videorecord_camera_switch);
        this.ovd = (TextView) findViewById(R.h.video_recorder_recorded_time);
        this.ovn = findViewById(R.h.video_recorder_recorded_time_area);
        this.ovo = findViewById(R.h.video_recorder_data_area);
        this.ovd.setText(com.tencent.mm.pluginsdk.i.e.iR(0));
        this.ouU = new b();
        this.ouY = (TextView) findViewById(R.h.videorecord_time_limit_tv);
        this.ove = (TextView) findViewById(R.h.video_recorder_size);
        this.ovf = (TextView) findViewById(R.h.video_recorder_length);
        this.ouV = (ImageButton) findViewById(R.h.videorecord_control_btn);
        this.ouV.setOnClickListener(new 7(this));
        if (com.tencent.mm.compatible.e.d.getNumberOfCameras() > 1) {
            this.ovh.setVisibility(0);
        } else {
            this.ovh.setVisibility(4);
        }
        this.ovh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VideoRecorderUI.this.ovh.setEnabled(false);
                VideoRecorderUI.this.ovp.sendEmptyMessageDelayed(0, 3000);
                VideoRecorderUI.this.ovj = true;
                VideoRecorderUI.this.ouU.ccP();
                if (VideoRecorderUI.this.ouU.a(VideoRecorderUI.this, VideoRecorderUI.this.ovj) != 0 || VideoRecorderUI.this.ouU.b(VideoRecorderUI.this.ouT) != 0) {
                    VideoRecorderUI.this.bGM();
                }
            }
        });
        this.ovb = (ImageButton) findViewById(R.h.video_play_btn);
        this.ova = (ImageView) findViewById(R.h.video_recorder_play_view);
        this.ovb.setOnClickListener(new 10(this));
        b bVar = this.ouU;
        int i2 = !this.mNn ? 1 : 0;
        String str = this.videoPath;
        String str2 = this.ouP;
        String str3 = this.ovl;
        String str4 = this.ovm;
        bVar.elY = 0;
        if (1 == bVar.elY) {
            bVar.ngs = com.tencent.mm.pluginsdk.i.a.ccO();
        } else {
            bVar.ngs = com.tencent.mm.pluginsdk.i.a.ccN();
        }
        if (q.deO.dfq) {
            bVar.ngs.lgR = q.deO.mVideoHeight;
            bVar.ngs.lgS = q.deO.mVideoWidth;
            bVar.ngs.lgQ = q.deO.dfs;
        }
        bVar.filename = str4;
        bVar.ngs.lgZ = str2;
        bVar.ngs.lgX = str3;
        bVar.ngs.lgW = str + "temp.pcm";
        bVar.ngs.lgV = str + "temp.yuv";
        bVar.ngs.lgY = str + "temp.vid";
        bVar.ngs.lhb = com.tencent.mm.compatible.e.d.getNumberOfCameras();
        com.tencent.mm.pluginsdk.i.a aVar = bVar.ngs;
        if (i2 == 0) {
            i = 0;
        }
        aVar.bYE = i;
        bVar.ngs.enM = 0;
        bVar.qDR = new f();
    }

    protected final void dealContentView(View view) {
        ak.d(ak.a(getWindow(), null), this.mController.tlX);
        ((ViewGroup) this.mController.tlX.getParent()).removeView(this.mController.tlX);
        ((ViewGroup) getWindow().getDecorView()).addView(this.mController.tlX, 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        x.d("MicroMsg.VideoRecorderUI", "KEYCODE_BACK");
        if (this.ouX) {
            return true;
        }
        bGL();
        return true;
    }

    private void bGL() {
        if (this.ouW) {
            h.a(this, getString(R.l.video_recorder_cancel), getString(R.l.app_tip), new 11(this), new 12(this));
        } else {
            finish();
        }
    }

    private void aXL() {
        getSupportActionBar().hide();
        this.ovd.setText(com.tencent.mm.pluginsdk.i.e.iR(0));
        this.ovn.setVisibility(8);
        this.ovo.setVisibility(8);
        this.ovc.setVisibility(0);
        this.ouW = false;
        this.ouZ.setVisibility(0);
        this.fAd.setVisibility(0);
        this.ouY.setVisibility(8);
        this.ovb.setVisibility(8);
        this.ovd.setText(com.tencent.mm.pluginsdk.i.e.iR(0));
        this.ova.setVisibility(8);
        this.ouV.setEnabled(true);
        this.ovh.setVisibility(0);
    }

    protected void onResume() {
        if (!(this.ovk || (this.ouU.a(this, false) == 0 && this.ouU.b(this.ouT) == 0))) {
            bGM();
        }
        this.ovk = false;
        x.v("MicroMsg.VideoRecorderUI", "onResume");
        super.onResume();
    }

    protected void onPause() {
        if (this.ouX) {
            b bVar = this.ouU;
            if (bVar.lik != null) {
                bVar.lik.stop();
                bVar.lik.release();
                bVar.lik = null;
            }
            aXL();
            this.ouX = false;
            releaseWakeLock();
            this.ouV.setImageResource(R.g.video_recorder_start_btn);
            this.hnz.SO();
            this.ouY.setVisibility(8);
            this.ouZ.setVisibility(0);
            this.fAd.setVisibility(0);
        }
        this.ouU.ccP();
        x.v("MicroMsg.VideoRecorderUI", "onPause");
        super.onPause();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == 0) {
                setResult(-1, intent);
                finish();
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void bGM() {
        h.a(this, R.l.video_dev_create_failed, R.l.app_tip, new 4(this));
    }

    private void releaseWakeLock() {
        this.fAd.setKeepScreenOn(false);
    }

    protected final int getLayoutId() {
        this.mNn = com.tencent.mm.compatible.e.d.zf();
        if (!this.mNn) {
            return R.i.video_recorder;
        }
        getWindow().setFlags(1024, 1024);
        setRequestedOrientation(0);
        return R.i.video_recorder_land;
    }
}
