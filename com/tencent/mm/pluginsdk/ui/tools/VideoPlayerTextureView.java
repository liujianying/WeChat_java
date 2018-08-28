package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.u.b;
import com.tencent.mm.plugin.u.c;
import com.tencent.mm.plugin.u.i;
import com.tencent.mm.plugin.u.k;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMTextureView;

public class VideoPlayerTextureView extends MMTextureView implements f {
    public boolean Fd;
    private boolean hEj;
    public boolean ldb;
    public boolean ldc;
    public b ldj;
    public Surface mSurface;
    private int mVideoHeight;
    private int mVideoWidth;
    public f$a ndD;
    public String path;
    private boolean qTA;
    private long qTB;
    private boolean qTC;
    public boolean qTD;
    private f$e qTE;
    private f$c qTF;
    private f$d qTG;
    public boolean qTH;
    protected boolean qTI;
    protected boolean qTJ;
    public c qTK;
    private SurfaceTextureListener qTL;
    private p qTM;
    public i qTy;
    private int qTz;

    static /* synthetic */ void f(VideoPlayerTextureView videoPlayerTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoPlayerTextureView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(13);
            videoPlayerTextureView.setLayoutParams(layoutParams);
        }
    }

    public VideoPlayerTextureView(Context context) {
        this(context, null);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.qTz = 0;
        this.Fd = false;
        this.qTA = true;
        this.qTB = 0;
        this.qTC = false;
        this.qTD = false;
        this.ldb = false;
        this.ldc = false;
        this.qTH = false;
        this.qTI = false;
        this.qTJ = false;
        this.qTK = new c() {
            public final void iy() {
                VideoPlayerTextureView.this.Fd = true;
                VideoPlayerTextureView.this.setMute(VideoPlayerTextureView.this.hEj);
                if (VideoPlayerTextureView.this.ndD != null) {
                    VideoPlayerTextureView.this.ndD.iy();
                }
                VideoPlayerTextureView.this.requestLayout();
            }

            public final void wd() {
                if (VideoPlayerTextureView.this.ndD != null) {
                    VideoPlayerTextureView.this.ndD.wd();
                }
            }

            public final void onError(int i, int i2) {
                if (VideoPlayerTextureView.this.ndD != null) {
                    VideoPlayerTextureView.this.ndD.onError(i, i2);
                }
            }

            public final void bdq() {
                if (VideoPlayerTextureView.this.qTF != null) {
                    VideoPlayerTextureView.this.qTF.bR(VideoPlayerTextureView.this.qTA);
                }
                if (!VideoPlayerTextureView.this.qTA) {
                    x.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
                    VideoPlayerTextureView.this.qTA = true;
                } else if (VideoPlayerTextureView.this.qTy != null) {
                    x.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", new Object[]{VideoPlayerTextureView.this.qTy.avA()});
                    VideoPlayerTextureView.this.qTy.start();
                }
            }

            public final void N(int i, int i2, int i3) {
                x.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                VideoPlayerTextureView.this.qTM.reset();
                VideoPlayerTextureView.this.qTz = i3;
                VideoPlayerTextureView.this.mVideoWidth = i;
                VideoPlayerTextureView.this.mVideoHeight = i2;
                VideoPlayerTextureView.f(VideoPlayerTextureView.this);
                if (VideoPlayerTextureView.this.ndD != null) {
                    VideoPlayerTextureView.this.ndD.cl(VideoPlayerTextureView.this.mVideoWidth, VideoPlayerTextureView.this.mVideoHeight);
                }
            }
        };
        this.qTL = new SurfaceTextureListener() {
            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                x.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", new Object[]{Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoPlayerTextureView.this.qTI)});
                try {
                    VideoPlayerTextureView.this.crS();
                    VideoPlayerTextureView.this.mSurface = new Surface(surfaceTexture);
                    if (VideoPlayerTextureView.this.qTy == null || !VideoPlayerTextureView.this.Fd) {
                        VideoPlayerTextureView.this.aMN();
                    } else {
                        i iVar = VideoPlayerTextureView.this.qTy;
                        Surface surface = VideoPlayerTextureView.this.mSurface;
                        if (surface != null) {
                            x.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", new Object[]{iVar.ldy.ldg.avA(), Integer.valueOf(surface.hashCode())});
                            k kVar = r0.ldH;
                            x.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", new Object[]{kVar.avA()});
                            kVar.aeJ = surface;
                            if (d.fR(23)) {
                                kVar.bdD();
                            } else {
                                kVar.bdE();
                            }
                        }
                        if (VideoPlayerTextureView.this.qTI) {
                            VideoPlayerTextureView.this.qTy.start();
                        } else {
                            VideoPlayerTextureView.this.qTJ = true;
                            VideoPlayerTextureView.this.qTB = 0;
                            VideoPlayerTextureView.this.qTy.setMute(true);
                            VideoPlayerTextureView.this.qTy.start();
                        }
                        VideoPlayerTextureView.this.qTI = false;
                    }
                    VideoPlayerTextureView.f(VideoPlayerTextureView.this);
                    if (VideoPlayerTextureView.this.qTG != null) {
                        VideoPlayerTextureView.this.qTG.SP();
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "onSurfaceTextureAvailable failed", new Object[0]);
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                x.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", new Object[]{Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
                VideoPlayerTextureView.f(VideoPlayerTextureView.this);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                x.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", new Object[]{Integer.valueOf(VideoPlayerTextureView.this.hashCode()), Integer.valueOf(surfaceTexture.hashCode())});
                VideoPlayerTextureView.this.mSurface = null;
                VideoPlayerTextureView.this.qTI = false;
                VideoPlayerTextureView.this.qTJ = false;
                if (VideoPlayerTextureView.this.qTy == null) {
                    VideoPlayerTextureView.this.qTI = false;
                } else if (VideoPlayerTextureView.this.isPlaying()) {
                    VideoPlayerTextureView.this.qTI = true;
                    VideoPlayerTextureView.this.qTy.pause();
                }
                return false;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (VideoPlayerTextureView.this.qTJ && VideoPlayerTextureView.this.qTB > 0) {
                    VideoPlayerTextureView.this.qTy.pause();
                    VideoPlayerTextureView.this.qTy.setMute(VideoPlayerTextureView.this.hEj);
                    VideoPlayerTextureView.this.qTJ = false;
                }
                if (VideoPlayerTextureView.this.qTB > 0 && VideoPlayerTextureView.this.qTE != null) {
                    x.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", new Object[]{Integer.valueOf(VideoPlayerTextureView.this.hashCode())});
                    VideoPlayerTextureView.this.qTE.bfs();
                    VideoPlayerTextureView.this.qTE = null;
                }
                VideoPlayerTextureView.this.qTB = System.currentTimeMillis();
            }
        };
        this.qTM = new p();
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
    }

    public void setOnSurfaceCallback(f$d f_d) {
        this.qTG = f_d;
    }

    public void setIOnlineCache(b bVar) {
        this.ldj = bVar;
    }

    public void setNeedResetExtractor(boolean z) {
        this.ldb = z;
        if (this.qTy != null) {
            this.qTy.setNeedResetExtractor(z);
        }
    }

    public void setIsOnlineVideoType(boolean z) {
        this.ldc = z;
        if (this.qTy != null) {
            this.qTy.setIsOnlineVideoType(z);
        }
    }

    public void setUseMp4Extrator(boolean z) {
        if (this.qTy != null) {
            this.qTH = z;
        }
    }

    public final boolean isPlaying() {
        if (this.qTy != null) {
            return this.qTy.isPlaying();
        }
        return false;
    }

    public final boolean cfx() {
        if (this.mSurface == null || this.qTJ) {
            return false;
        }
        return true;
    }

    public void setVideoPath(String str) {
        x.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", new Object[]{Integer.valueOf(hashCode()), str});
        this.path = str;
        aMN();
        requestLayout();
    }

    public String getVideoPath() {
        return this.path;
    }

    public void setOpenWithNoneSurface(boolean z) {
        this.qTD = z;
    }

    public boolean start() {
        String str;
        String str2;
        Object[] objArr;
        if (this.qTy == null || !this.Fd) {
            boolean z;
            str = "MicroMsg.VideoPlayerTextureView";
            str2 = "%d player is null[%b] or it prepared [%b]";
            objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.qTy == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.Fd);
            x.w(str, str2, objArr);
            return false;
        }
        str = "MicroMsg.VideoPlayerTextureView";
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.qTJ);
        objArr[2] = Boolean.valueOf(this.qTI);
        objArr[3] = Boolean.valueOf(this.mSurface != null);
        x.i(str, str2, objArr);
        if (this.mSurface == null) {
            this.qTI = true;
            return true;
        } else if (this.qTJ) {
            this.qTI = true;
            this.qTJ = false;
            setMute(this.hEj);
            return true;
        } else {
            this.qTy.start();
            return true;
        }
    }

    public final boolean q(Context context, boolean z) {
        return start();
    }

    public void stop() {
        x.i("MicroMsg.VideoPlayerTextureView", "%d player stop [%s]", new Object[]{Integer.valueOf(hashCode()), bi.cjd()});
        if (this.qTy != null) {
            this.qTy.ldz = null;
            this.qTy.ldy.stop();
            this.qTy.release();
            this.qTy = null;
        }
        this.qTz = 0;
        this.mVideoHeight = 0;
        this.mVideoWidth = 0;
        this.qTM.reset();
        this.Fd = false;
        this.path = null;
        this.qTB = 0;
    }

    public void pause() {
        if (this.qTy != null && this.qTy.isPlaying()) {
            this.qTy.pause();
        }
        this.qTI = false;
    }

    public final void onDetach() {
    }

    public void setLoop(boolean z) {
    }

    public void setVideoCallback(f$a f_a) {
        this.ndD = f_a;
    }

    public int getCurrentPosition() {
        if (this.qTy != null) {
            return this.qTy.bdA();
        }
        return 0;
    }

    public int getDuration() {
        if (this.qTy != null) {
            return (int) this.qTy.ldy.aqC;
        }
        return 0;
    }

    public void setThumb(Bitmap bitmap) {
    }

    public double getLastProgresstime() {
        return 0.0d;
    }

    public void x(double d) {
        if (this.qTy != null) {
            this.qTy.sG((int) d);
        }
    }

    public final void d(double d, boolean z) {
        this.qTA = z;
        x(d);
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
        this.hEj = z;
        if (this.qTy != null) {
            x.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(z)});
            this.qTy.setMute(z);
        }
    }

    public void aMN() {
        x.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s]", new Object[]{Integer.valueOf(hashCode()), this.path});
        if (this.qTy != null) {
            this.qTy.ldz = null;
            this.qTy.ldy.stop();
            this.qTy.release();
            this.qTy = null;
        }
        if (bi.oW(this.path) || this.mSurface == null) {
            x.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        try {
            this.Fd = false;
            this.qTy = new i(Looper.getMainLooper());
            this.qTy.setPath(this.path);
            this.qTy.setIOnlineCache(this.ldj);
            this.qTy.setNeedResetExtractor(this.ldb);
            this.qTy.setIsOnlineVideoType(this.ldc);
            this.qTy.ldz = this.qTK;
            this.qTy.setSurface(this.mSurface);
            this.qTy.gr(this.qTH);
            if (this.mSurface != null) {
                this.qTy.bdz();
            } else if (this.qTD) {
                this.qTy.bdz();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "prepare async error %s", new Object[]{e.getMessage()});
            if (this.ndD != null) {
                this.ndD.onError(-1, -1);
            }
        }
    }

    public final void bdC() {
        if (this.qTy != null && this.Fd && this.mSurface != null) {
            x.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", new Object[]{Integer.valueOf(hashCode())});
            i iVar = this.qTy;
            if (iVar.ldy != null) {
                iVar.ldy.bdC();
            }
        }
    }

    public void setScaleType(h.d dVar) {
        this.qTM.setScaleType(dVar);
        requestLayout();
    }

    protected void onMeasure(int i, int i2) {
        if (this.mVideoWidth == 0 || this.mVideoHeight == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.qTM.x(getDefaultSize(1, i), getDefaultSize(1, i2), this.mVideoWidth, this.mVideoHeight);
        int i3 = this.qTM.qUm;
        int i4 = this.qTM.qUn;
        if (this.qTz == 90 || this.qTz == 270) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            float f = ((float) i3) / 2.0f;
            float f2 = ((float) i4) / 2.0f;
            float f3 = ((float) i4) / ((float) i3);
            if (!(getScaleX() == 1.0f && getScaleY() == 1.0f)) {
                matrix.setScale(getScaleX(), getScaleY(), f, f2);
            }
            matrix.postRotate((float) this.qTz, f, f2);
            matrix.postScale(1.0f / f3, f3, f, f2);
            setTransform(matrix);
        }
        setMeasuredDimension(i3, i4);
    }
}
