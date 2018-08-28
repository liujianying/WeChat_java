package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class VideoSightCenterView extends VideoSightView {
    private boolean bTv = false;
    private int nEn = 0;
    private volatile boolean qTO = false;
    private MediaMetadataRetriever qTP;

    public VideoSightCenterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VideoSightCenterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setDrawableWidth(int i) {
        super.setDrawableWidth(i);
        cfy();
    }

    public final void dt(int i, int i2) {
        super.dt(i, i2);
        cfy();
    }

    private void cfy() {
        if (getLayoutParams() instanceof LayoutParams) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.addRule(13);
            setLayoutParams(layoutParams);
        }
    }

    protected final void init() {
        if (bi.aG(q.deW.den, "").equals("other")) {
            x.i("MicroMsg.VideoSightCenterView", "init::use other player");
        } else {
            hK(true);
        }
        setOnCompletionListener(new e() {
            public final void d(b bVar, int i) {
                if (-1 == i) {
                    x.i("MicroMsg.VideoSightCenterView", "error stop, isCompletion: %s", new Object[]{Boolean.valueOf(VideoSightCenterView.this.qTO)});
                    if (VideoSightCenterView.this.ndD != null && !VideoSightCenterView.this.qTO) {
                        VideoSightCenterView.this.ndD.onError(0, 0);
                    }
                } else if (i == 0) {
                    x.i("MicroMsg.VideoSightCenterView", "normal stop");
                    VideoSightCenterView.this.qTO = true;
                    if (VideoSightCenterView.this.ndD != null) {
                        VideoSightCenterView.this.ndD.wd();
                    }
                }
            }
        });
    }

    public void setPlayProgressCallback(boolean z) {
        if (z) {
            setOnDecodeDurationListener(new 2(this));
        } else {
            setOnDecodeDurationListener(null);
        }
    }

    public int getDuration() {
        x.i("MicroMsg.VideoSightCenterView", "getDuration");
        if (!bi.oW(this.nck)) {
            try {
                if (this.qTP == null) {
                    this.qTP = new MediaMetadataRetriever();
                    this.qTP.setDataSource(this.nck);
                }
                x.i("MicroMsg.VideoSightCenterView", "getDuration: %s", new Object[]{Integer.valueOf(Integer.valueOf(this.qTP.extractMetadata(9)).intValue())});
                return Integer.valueOf(this.qTP.extractMetadata(9)).intValue();
            } catch (Exception e) {
                x.e("MicroMsg.VideoSightCenterView", "getDuration error: %s", new Object[]{e.getMessage()});
            }
        }
        return super.getDuration();
    }

    public int getCurrentPosition() {
        x.v("MicroMsg.VideoSightCenterView", "getCurrentPosition: %s", new Object[]{Integer.valueOf(this.nEn)});
        return this.nEn;
    }

    public final boolean start() {
        x.v("MicroMsg.VideoSightCenterView", "start");
        this.bTv = true;
        return super.start();
    }

    public final void stop() {
        x.v("MicroMsg.VideoSightCenterView", "stop");
        super.stop();
        this.nEn = 0;
        this.bTv = false;
    }

    public final void pause() {
        x.v("MicroMsg.VideoSightCenterView", "pause");
        super.pause();
    }

    public double getLastProgresstime() {
        return super.getLastProgresstime();
    }

    public final void x(double d) {
        x.v("MicroMsg.VideoSightCenterView", "seekTo, time: %s, isStart: %s, currentPosition: %s, getLastProgresstime: %s", new Object[]{Double.valueOf(d), Boolean.valueOf(this.bTv), Integer.valueOf(this.nEn), Double.valueOf(getLastProgresstime())});
        if (this.bTv && getLastProgresstime() > 0.0d) {
            super.x(d / 1000.0d);
        }
    }

    public final boolean isPlaying() {
        x.v("MicroMsg.VideoSightCenterView", "isPlaying, isStart: %s, currentPosition: %s", new Object[]{Boolean.valueOf(this.bTv), Integer.valueOf(this.nEn)});
        return this.bTv;
    }
}
