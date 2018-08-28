package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class CommonVideoView extends AbstractVideoView {
    protected boolean avH;
    protected int gbj;
    public String url;

    public CommonVideoView(Context context) {
        super(context);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void initView() {
        super.initView();
        this.TAG = "MicroMsg.CommonVideoView";
    }

    public void c(boolean z, String str, int i) {
        x.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[]{avy(), Boolean.valueOf(z), str, Integer.valueOf(i)});
        this.avH = z;
        this.url = str;
        this.gbj = i;
        Tv(str);
    }

    public f bT(Context context) {
        this.qEq = 0;
        return new VideoTextureView(context);
    }

    public void start() {
        if (this.hEl != null) {
            x.i(this.TAG, "%s start path [%s] [%s]", new Object[]{avy(), this.hEl.getVideoPath(), bi.cjd()});
            if (bi.oW(this.hEl.getVideoPath())) {
                this.hEl.setVideoPath(this.url);
                aoi();
                bCy();
            } else {
                play();
            }
            bQ((long) (getReportIdkey() + 1));
        }
    }

    public void setScaleType(d dVar) {
        if (this.hEl instanceof VideoTextureView) {
            ((VideoTextureView) this.hEl).setScaleType(dVar);
            bQ((long) (getReportIdkey() + 14));
        }
    }

    public final boolean ac(float f) {
        x.i(this.TAG, "%s set play rate [%f]", new Object[]{avy(), Float.valueOf(f)});
        if (!(this.hEl instanceof VideoTextureView)) {
            return false;
        }
        bQ((long) (getReportIdkey() + 13));
        return ((VideoTextureView) this.hEl).ac(f);
    }

    public int getVideoDurationSec() {
        if (this.gbj <= 0) {
            return super.getVideoDurationSec();
        }
        return this.gbj;
    }

    public int getCacheTimeSec() {
        try {
            if (this.hEl instanceof VideoTextureView) {
                return (int) (((((float) ((VideoTextureView) this.hEl).getDownloadPercent()) * 1.0f) / 100.0f) * ((float) super.getVideoDurationSec()));
            }
        } catch (Throwable e) {
            x.printErrStackTrace(this.TAG, e, "%s get cache time sec error", new Object[]{avy()});
        }
        return 0;
    }

    public boolean x(int i, boolean z) {
        if (!ajG()) {
            return super.x(i, z);
        }
        x.w(this.TAG, "%s it is live, don't seek ", new Object[]{avy()});
        return false;
    }

    public void SM() {
        super.SM();
        if (this.hEl != null && (this.hEl instanceof VideoTextureView)) {
            if (this.qEp) {
                play();
            } else {
                ((VideoTextureView) this.hEl).bdC();
            }
        }
    }

    public void SL() {
        super.SL();
    }

    public final void ey(int i, int i2) {
        x.d(this.TAG, "%s onInfo [%d %d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 701) {
            aoi();
            ccX();
            ccV();
            bQ((long) (getReportIdkey() + 40));
        } else if (i == 702) {
            aYM();
            ccW();
            ccY();
        }
    }

    public void wd() {
        if (ajG()) {
            x.i(this.TAG, "%s it is live video, do not completion", new Object[]{avy()});
            stop();
            start();
            return;
        }
        super.wd();
    }

    public final boolean ajG() {
        boolean isPrepared = isPrepared();
        int duration = this.hEl != null ? this.hEl.getDuration() : 0;
        if (this.avH) {
            isPrepared = true;
        } else if (!isPrepared || duration > 0) {
            isPrepared = false;
        } else {
            isPrepared = true;
        }
        x.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[]{avy(), Boolean.valueOf(isPrepared), Boolean.valueOf(isPrepared()), Integer.valueOf(duration), Boolean.valueOf(this.avH)});
        return isPrepared;
    }

    public int getReportIdkey() {
        return 0;
    }
}
