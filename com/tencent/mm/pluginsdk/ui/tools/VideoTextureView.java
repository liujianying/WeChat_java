package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView extends MMTextureView implements f {
    private float aex;
    private boolean hEj;
    private int hmV;
    private int hmW;
    private boolean kpl;
    private int mDuration;
    private Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    private f$a ndD;
    private MediaPlayer ngO;
    private long qTB;
    private boolean qTC;
    private f$e qTE;
    private f$c qTF;
    private f$d qTG;
    private boolean qTI;
    private boolean qTJ;
    SurfaceTextureListener qTL;
    private p qTM;
    private String qTV;
    private boolean qTW;
    private boolean qTX;
    OnVideoSizeChangedListener qTY;
    OnPreparedListener qTZ;
    private OnCompletionListener qUa;
    private OnErrorListener qUb;
    private f$b qUe;
    private long qUf;
    private int qUg;
    private OnSeekCompleteListener qUh;
    private OnBufferingUpdateListener qUi;
    private OnInfoListener qUj;
    private boolean qUk;
    private long startTime;

    static /* synthetic */ void e(VideoTextureView videoTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSurface = null;
        this.ngO = null;
        this.startTime = 0;
        this.qUf = 0;
        this.hmV = 0;
        this.hmW = 0;
        this.qUg = 0;
        this.kpl = false;
        this.qTC = false;
        this.qTY = new 2(this);
        this.qTZ = new 3(this);
        this.qUh = new 4(this);
        this.qUi = new 5(this);
        this.qUj = new 6(this);
        this.qUa = new 7(this);
        this.qUb = new 8(this);
        this.qTB = 0;
        this.qTI = false;
        this.qTJ = false;
        this.qUk = false;
        this.qTL = new 9(this);
        this.hEj = false;
        this.qTM = new p();
        this.aex = -1.0f;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        setSurfaceTextureListener(this.qTL);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void setOneTimeVideoTextureUpdateCallback(f$e f_e) {
        this.qTE = f_e;
    }

    public void setOnSeekCompleteCallback(f$c f_c) {
        this.qTF = f_c;
    }

    public void setOnInfoCallback(f$b f_b) {
        this.qUe = f_b;
    }

    public void setOnSurfaceCallback(f$d f_d) {
        this.qTG = f_d;
    }

    public void setVideoPath(String str) {
        this.qTV = str;
        this.qTX = false;
        aMN();
        requestLayout();
    }

    public String getVideoPath() {
        return this.qTV;
    }

    public int getDownloadPercent() {
        return this.qUg;
    }

    public final void stop() {
        long j;
        long j2 = this.qUf > 0 ? this.qUf - this.startTime : 2147483647L;
        long VE = bi.VE() - this.startTime;
        if (j2 > VE) {
            j = VE;
        } else {
            j = j2;
        }
        int i = ((int) j) * BaseReportManager.MAX_READ_COUNT;
        if (i > getDuration()) {
            i = getDuration();
        }
        x.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", new Object[]{Integer.valueOf(getDuration()), Long.valueOf(VE), Long.valueOf(j2)});
        if (this.ndD != null) {
            this.ndD.ck(i, getDuration());
        }
        cfz();
        this.qTM.reset();
        try {
            if (this.mSurface != null && this.qTW) {
                SurfaceTexture surfaceTexture = getSurfaceTexture();
                if (surfaceTexture != null) {
                    x.i("MicroMsg.VideoTextureView", "%d releaseSurface", new Object[]{Integer.valueOf(hashCode())});
                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                    egl10.eglInitialize(eglGetDisplay, null);
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                    egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16384);
                    egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglMakeCurrent(eglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                    egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    egl10.eglTerminate(eglGetDisplay);
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoTextureView", e, "release surface", new Object[0]);
        }
        this.qTV = "";
        this.qUg = 0;
        this.qTW = false;
        this.qTX = false;
        this.qTB = 0;
    }

    private void cfz() {
        boolean z = true;
        String str = "MicroMsg.VideoTextureView";
        String str2 = "%d release media player isPrepared[%b] player is null[%b] ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.qTW);
        if (this.ngO != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (this.ngO != null) {
            this.ngO.setOnErrorListener(null);
            this.ngO.setOnVideoSizeChangedListener(null);
            try {
                this.ngO.stop();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "stop media player error", new Object[0]);
            }
            try {
                this.ngO.reset();
                this.ngO.release();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e2, "reset media player error", new Object[0]);
            }
        }
        this.ngO = null;
    }

    private void aMN() {
        if (!bi.oW(this.qTV) && this.mSurface != null) {
            cfz();
            x.i("MicroMsg.VideoTextureView", "%d open video %s", new Object[]{Integer.valueOf(hashCode()), this.qTV});
            try {
                this.ngO = new j();
                this.ngO.setOnPreparedListener(this.qTZ);
                this.ngO.setOnVideoSizeChangedListener(this.qTY);
                this.qTW = false;
                x.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.qUg = 0;
                this.ngO.setOnCompletionListener(this.qUa);
                this.ngO.setOnErrorListener(this.qUb);
                this.ngO.setOnSeekCompleteListener(this.qUh);
                this.ngO.setOnBufferingUpdateListener(this.qUi);
                this.ngO.setOnInfoListener(this.qUj);
                this.ngO.setDataSource(this.qTV);
                this.ngO.setSurface(this.mSurface);
                this.ngO.setAudioStreamType(3);
                this.ngO.setScreenOnWhilePlaying(true);
                this.ngO.prepareAsync();
                this.mVideoHeight = this.ngO.getVideoHeight();
                this.mVideoWidth = this.ngO.getVideoWidth();
                setMute(this.hEj);
                ac(this.aex);
                x.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.ngO.hashCode())});
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "prepare async error path", new Object[0]);
                if (this.ndD != null) {
                    this.ndD.onError(-1, -1);
                }
            }
        }
    }

    public final void bdC() {
        if (this.ngO != null && this.qTW && this.mSurface != null && this.mSurface.isValid()) {
            x.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition())});
            this.qUk = true;
            this.ngO.setVolume(0.0f, 0.0f);
            this.ngO.start();
        }
    }

    public final void pause() {
        if (this.ngO != null && this.qTW && this.ngO.isPlaying()) {
            x.d("MicroMsg.VideoTextureView", "pause video.");
            this.ngO.pause();
        }
        this.qTX = false;
    }

    public int getDuration() {
        if (this.ngO == null || !this.qTW) {
            this.mDuration = -1;
            return this.mDuration;
        } else if (this.mDuration > 0) {
            return this.mDuration;
        } else {
            this.mDuration = this.ngO.getDuration();
            return this.mDuration;
        }
    }

    public int getCurrentPosition() {
        if (this.ngO != null && this.qTW) {
            return this.ngO.getCurrentPosition();
        }
        if (this.ngO == null) {
            return -1;
        }
        return 0;
    }

    public final boolean isPlaying() {
        boolean z;
        if (this.ngO == null || !this.qTW || this.qTJ) {
            z = false;
        } else {
            z = this.ngO.isPlaying();
        }
        x.d("MicroMsg.VideoTextureView", "%d is playing result [%b] pauseWhenUpdated[%b] mIsPrepared[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z), Boolean.valueOf(this.qTJ), Boolean.valueOf(this.qTW)});
        return z;
    }

    public void setLoop(boolean z) {
        if (this.ngO != null) {
            this.ngO.setLooping(z);
        }
        this.kpl = true;
    }

    public void setVideoCallback(f$a f_a) {
        this.ndD = f_a;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.mSurface == null) {
            x.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", new Object[]{Integer.valueOf(hashCode())});
            this.qTI = true;
            this.qTX = true;
            return false;
        }
        this.startTime = this.startTime == 0 ? bi.VE() : this.startTime;
        x.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", new Object[]{Long.valueOf(this.startTime), Boolean.valueOf(this.qTW), Boolean.valueOf(this.qTJ)});
        if (this.ngO != null && this.qTW) {
            if (this.qTJ) {
                this.qTJ = false;
                setMute(this.hEj);
            }
            this.ngO.start();
            this.qTX = true;
            return true;
        } else if (this.ngO == null && this.qTW) {
            this.qTX = true;
            aMN();
            requestLayout();
            return true;
        } else {
            this.qTX = true;
            return false;
        }
    }

    public final boolean q(Context context, boolean z) {
        return start();
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    public final void x(double d) {
        if (this.ngO != null) {
            this.ngO.seekTo((int) d);
            this.qTX = true;
            x.d("MicroMsg.VideoTextureView", "seek to time: " + d + " curr pos : " + this.ngO.getCurrentPosition());
        }
    }

    public final void d(double d, boolean z) {
        x(d);
        this.qTX = z;
    }

    public void setPlayProgressCallback(boolean z) {
    }

    public long getLastSurfaceUpdateTime() {
        return this.qTB;
    }

    public void setForceScaleFullScreen(boolean z) {
        this.qTC = z;
        this.qTM.qTC = this.qTC;
    }

    public void setMute(boolean z) {
        x.i("MicroMsg.VideoTextureView", "%d set mute %b", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z)});
        this.hEj = z;
        if (this.ngO == null) {
            return;
        }
        if (this.hEj) {
            this.ngO.setVolume(0.0f, 0.0f);
        } else {
            this.ngO.setVolume(1.0f, 1.0f);
        }
    }

    public void setScaleType(d dVar) {
        this.qTM.setScaleType(dVar);
        requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.qTM.x(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        setMeasuredDimension(this.qTM.qUm, this.qTM.qUn);
    }

    public final boolean ac(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.aex = f;
        if (com.tencent.mm.compatible.util.d.fR(23)) {
            return az(this.aex);
        }
        return false;
    }

    private boolean az(float f) {
        if (VERSION.SDK_INT >= 23) {
            try {
                if (this.ngO != null && com.tencent.mm.compatible.util.d.fR(23)) {
                    PlaybackParams playbackParams = this.ngO.getPlaybackParams();
                    if (playbackParams == null) {
                        playbackParams = new PlaybackParams();
                    }
                    this.ngO.setPlaybackParams(playbackParams.setSpeed(f));
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoTextureView", e, "%s handle play rate error", new Object[]{Integer.valueOf(hashCode())});
                return false;
            }
        }
        return true;
    }
}
