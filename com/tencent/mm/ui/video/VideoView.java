package com.tencent.mm.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
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
import java.io.IOException;

public class VideoView extends SurfaceView {
    private OnCompletionListener epg;
    private OnErrorListener eph;
    private Context mContext;
    private int mDuration;
    private int mVideoHeight;
    private int mVideoWidth;
    public MediaPlayer ngO;
    private SurfaceHolder ouT;
    private String qTV;
    public boolean qTW;
    public boolean qTX;
    OnVideoSizeChangedListener qTY;
    OnPreparedListener qTZ;
    private OnCompletionListener qUa;
    private OnErrorListener qUb;
    Callback qUc;
    private int uFs;
    private int uFt;
    private OnPreparedListener uFu;
    private int uFv;
    private int uFw;
    private a uFx;
    private OnBufferingUpdateListener uFy;

    public interface a {
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public final void cAq() {
        if (this.mVideoHeight != 0 && this.mVideoWidth != 0) {
            int i;
            int i2 = this.mVideoWidth;
            int i3 = this.mVideoHeight;
            x.v("MicroMsg.VideoView", "video size before:" + i2 + "   " + i3);
            x.v("MicroMsg.VideoView", "layout size before:" + getWidth() + "   " + getHeight());
            int width = getWidth();
            int height = getHeight();
            if (width <= 0) {
                i = i2;
            } else {
                i = width;
            }
            if (height <= 0) {
                width = i3;
            } else {
                width = height;
            }
            float f = (((float) i) * 1.0f) / ((float) i2);
            float f2 = (((float) width) * 1.0f) / ((float) i3);
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i2) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i;
                layoutParams.height = (int) (((float) i3) * f);
            }
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
            invalidate();
            x.v("MicroMsg.VideoView", "video size after:" + this.ngO.getVideoWidth() + "   " + this.ngO.getVideoHeight());
            x.v("MicroMsg.VideoView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.mContext = context;
        cAr();
    }

    public VideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ouT = null;
        this.ngO = null;
        this.qTY = new 1(this);
        this.qTZ = new 2(this);
        this.qUa = new 3(this);
        this.qUb = new 4(this);
        this.uFy = new OnBufferingUpdateListener() {
            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                VideoView.this.uFv = i;
            }
        };
        this.qUc = new Callback() {
            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                VideoView.this.uFs = i2;
                VideoView.this.uFt = i3;
                if (VideoView.this.ngO != null && VideoView.this.qTW && VideoView.this.mVideoWidth == i2 && VideoView.this.mVideoHeight == i3) {
                    if (VideoView.this.uFw != 0) {
                        VideoView.this.ngO.seekTo(VideoView.this.uFw);
                        VideoView.this.uFw = 0;
                    }
                    VideoView.this.ngO.start();
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                VideoView.this.ouT = surfaceHolder;
                VideoView.this.aMN();
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                VideoView.this.ouT = null;
                if (VideoView.this.ngO != null) {
                    VideoView.this.ngO.reset();
                    VideoView.this.ngO.release();
                    VideoView.this.ngO = null;
                }
            }
        };
        this.mContext = context;
        cAr();
    }

    private void cAr() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        getHolder().addCallback(this.qUc);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public void setVideoURI(String str) {
        this.qTV = str;
        this.qTX = false;
        this.uFw = 0;
        aMN();
        requestLayout();
        invalidate();
    }

    public String getVideoURI() {
        return this.qTV;
    }

    public void setLooping(boolean z) {
        if (this.ngO != null) {
            this.ngO.setLooping(z);
        }
    }

    public final void stopPlayback() {
        if (this.ngO != null) {
            this.ngO.stop();
            this.ngO.release();
            this.ngO = null;
        }
    }

    public int getVideoTimeLeft() {
        if (this.ngO == null) {
            return 0;
        }
        return this.ngO.getDuration() - this.ngO.getCurrentPosition();
    }

    private void aMN() {
        if (this.qTV != null && this.ouT != null) {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            this.mContext.sendBroadcast(intent);
            if (this.ngO != null) {
                this.ngO.reset();
                this.ngO.release();
                this.ngO = null;
            }
            try {
                this.ngO = new j();
                this.ngO.setOnPreparedListener(this.qTZ);
                this.ngO.setOnVideoSizeChangedListener(this.qTY);
                this.qTW = false;
                x.v("MicroMsg.VideoView", "reset duration to -1 in openVideo");
                this.mDuration = -1;
                this.ngO.setOnCompletionListener(this.qUa);
                this.ngO.setOnErrorListener(this.qUb);
                this.ngO.setOnBufferingUpdateListener(this.uFy);
                this.uFv = 0;
                this.ngO.setDataSource(this.qTV);
                this.ngO.setDisplay(this.ouT);
                this.ngO.setAudioStreamType(3);
                this.ngO.setScreenOnWhilePlaying(true);
                this.ngO.prepareAsync();
                this.mVideoHeight = this.ngO.getVideoHeight();
                this.mVideoWidth = this.ngO.getVideoWidth();
            } catch (IOException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.uFu = onPreparedListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.epg = onCompletionListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.eph = onErrorListener;
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

    public int getBufferPercentage() {
        if (this.ngO != null) {
            return this.uFv;
        }
        return 0;
    }

    public int getAudioSessionId() {
        return 0;
    }

    public void setVideoViewIm(a aVar) {
        this.uFx = aVar;
    }
}
