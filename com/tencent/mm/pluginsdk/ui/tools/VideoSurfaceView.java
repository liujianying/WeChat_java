package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.sdk.platformtools.x;

public class VideoSurfaceView extends SurfaceView implements f {
    private boolean hEj;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    private f$a ndD;
    private MediaPlayer ngO;
    private SurfaceHolder ouT;
    private String qTV;
    private boolean qTW;
    private boolean qTX;
    OnVideoSizeChangedListener qTY;
    OnPreparedListener qTZ;
    private OnCompletionListener qUa;
    private OnErrorListener qUb;
    Callback qUc;

    static /* synthetic */ void c(VideoSurfaceView videoSurfaceView) {
        if (videoSurfaceView.mVideoHeight != 0 && videoSurfaceView.mVideoWidth != 0) {
            int i = videoSurfaceView.mVideoWidth;
            int i2 = videoSurfaceView.mVideoHeight;
            x.v("MicroMsg.VideoSurfaceView", "video size before:" + i + "   " + i2);
            x.v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
            int width = videoSurfaceView.getWidth();
            int height = videoSurfaceView.getHeight();
            int i3 = width <= 0 ? i : width;
            width = height <= 0 ? i2 : height;
            float f = (((float) i3) * 1.0f) / ((float) i);
            float f2 = (((float) width) * 1.0f) / ((float) i2);
            LayoutParams layoutParams = (LayoutParams) videoSurfaceView.getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i3;
                layoutParams.height = (int) (((float) i2) * f);
            }
            layoutParams.addRule(13);
            videoSurfaceView.setLayoutParams(layoutParams);
            x.v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.ngO.getVideoWidth() + "   " + videoSurfaceView.ngO.getVideoHeight());
            x.v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ouT = null;
        this.ngO = null;
        this.qTY = new 1(this);
        this.qTZ = new 2(this);
        this.qUa = new 3(this);
        this.qUb = new OnErrorListener() {
            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                x.d("MicroMsg.VideoSurfaceView", "Error: " + i + "," + i2);
                if (VideoSurfaceView.this.ndD != null) {
                    VideoSurfaceView.this.ndD.onError(i, i2);
                }
                return true;
            }
        };
        this.qUc = new 5(this);
        this.hEj = false;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.qUc);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
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

    public final void stop() {
        if (this.ngO != null) {
            this.ngO.stop();
            this.ngO.release();
            this.ngO = null;
        }
    }

    private void aMN() {
        if (this.qTV != null && this.ouT != null) {
            if (this.ngO != null) {
                this.ngO.stop();
                this.ngO.release();
                this.ngO = null;
            }
            try {
                this.ngO = new j();
                this.ngO.setOnPreparedListener(this.qTZ);
                this.ngO.setOnVideoSizeChangedListener(this.qTY);
                this.qTW = false;
                x.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.ngO.setOnCompletionListener(this.qUa);
                this.ngO.setOnErrorListener(this.qUb);
                this.ngO.setDataSource(this.qTV);
                this.ngO.setDisplay(this.ouT);
                this.ngO.setAudioStreamType(3);
                this.ngO.setScreenOnWhilePlaying(true);
                this.ngO.prepareAsync();
                this.mVideoHeight = this.ngO.getVideoHeight();
                this.mVideoWidth = this.ngO.getVideoWidth();
                setMute(this.hEj);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VideoSurfaceView", e, "prepare async error %s", new Object[]{e.getMessage()});
                if (this.ndD != null) {
                    this.ndD.onError(-1, -1);
                }
            }
        }
    }

    public final void pause() {
        if (this.ngO != null && this.qTW && this.ngO.isPlaying()) {
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
        if (this.ngO == null || !this.qTW) {
            return 0;
        }
        return this.ngO.getCurrentPosition();
    }

    public final boolean isPlaying() {
        if (this.ngO == null || !this.qTW) {
            return false;
        }
        return this.ngO.isPlaying();
    }

    public void setLoop(boolean z) {
        if (this.ngO != null) {
            this.ngO.setLooping(z);
        }
    }

    public void setVideoCallback(f$a f_a) {
        this.ndD = f_a;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.ngO == null || !this.qTW) {
            this.qTX = true;
        } else {
            this.ngO.start();
            this.qTX = false;
        }
        return true;
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
            x.d("MicroMsg.VideoSurfaceView", "seek to time: " + d);
            this.ngO.seekTo((int) d);
            start();
        }
    }

    public void setPlayProgressCallback(boolean z) {
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        this.hEj = z;
        if (this.ngO == null) {
            return;
        }
        if (this.hEj) {
            this.ngO.setVolume(0.0f, 0.0f);
        } else {
            this.ngO.setVolume(0.5f, 0.5f);
        }
    }

    public final void d(double d, boolean z) {
        x(d);
    }

    public void setOneTimeVideoTextureUpdateCallback(f$e f_e) {
    }

    public void setOnSeekCompleteCallback(f$c f_c) {
    }

    public void setOnInfoCallback(f$b f_b) {
    }

    public void setOnSurfaceCallback(f$d f_d) {
    }
}
