package com.tencent.mm.plugin.webview.ui.tools.media;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class WebVideoWrapper extends RelativeLayout implements a, h, b, c {
    private boolean avH;
    private h gbd;
    private b gbe;
    private int gbj;
    private d gbl;
    private Context mContext;
    private String url;

    public WebVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        this.gbl = new d();
        if (this.gbd == null) {
            CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
            commonVideoView.setReporter(this);
            commonVideoView.setIMMVideoViewCallback(this);
            bQ(200);
            this.gbd = commonVideoView;
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        addView((View) this.gbd, layoutParams);
    }

    public final void c(boolean z, String str, int i) {
        this.gbj = i;
        this.avH = z;
        this.url = str;
        if (this.gbd != null) {
            this.gbd.c(this.avH, this.url, this.gbj);
        }
    }

    public void setIMMVideoViewCallback(b bVar) {
        this.gbe = bVar;
    }

    public void setVideoFooterView(g gVar) {
        if (this.gbd != null) {
            this.gbd.setVideoFooterView(gVar);
        }
    }

    public final void ajY() {
        if (this.gbd != null) {
            this.gbd.ajY();
        }
    }

    public int getPlayerType() {
        if (this.gbd != null) {
            return this.gbd.getPlayerType();
        }
        return 0;
    }

    public final boolean kW(int i) {
        if (this.gbd != null) {
            return this.gbd.kW(i);
        }
        return false;
    }

    public final boolean x(int i, boolean z) {
        if (this.gbd != null) {
            return this.gbd.x(i, z);
        }
        return false;
    }

    public void setIsShowBasicControls(boolean z) {
        if (this.gbd != null) {
            this.gbd.setIsShowBasicControls(z);
        }
    }

    public void setFullDirection(int i) {
        if (this.gbd != null) {
            this.gbd.setFullDirection(i);
        }
    }

    public int getVideoDurationSec() {
        if (this.gbd != null) {
            return this.gbd.getVideoDurationSec();
        }
        return this.gbj;
    }

    public int getCurrPosMs() {
        if (this.gbd != null) {
            return this.gbd.getCurrPosMs();
        }
        return 0;
    }

    public int getCurrPosSec() {
        if (this.gbd != null) {
            return this.gbd.getCurrPosSec();
        }
        return 0;
    }

    public int getCacheTimeSec() {
        if (this.gbd != null) {
            return this.gbd.getCacheTimeSec();
        }
        return 0;
    }

    public final boolean isPlaying() {
        if (this.gbd != null) {
            return this.gbd.isPlaying();
        }
        return false;
    }

    public final boolean ajG() {
        if (this.gbd != null) {
            return this.gbd.ajG();
        }
        return false;
    }

    public void setCover(Bitmap bitmap) {
        if (this.gbd != null) {
            this.gbd.setCover(bitmap);
        }
    }

    public final void start() {
        if (this.gbd != null) {
            this.gbd.start();
            setKeepScreenOn(true);
            this.gbl.a(this);
        }
    }

    public final void stop() {
        if (this.gbd != null) {
            this.gbd.stop();
            this.gbl.bv(false);
            setKeepScreenOn(false);
        }
    }

    public final boolean pause() {
        if (this.gbd == null) {
            return false;
        }
        setKeepScreenOn(false);
        this.gbl.bv(false);
        return this.gbd.pause();
    }

    public void setMute(boolean z) {
        if (this.gbd != null) {
            this.gbd.setMute(z);
        }
    }

    public final void SM() {
        if (this.gbd != null) {
            this.gbd.SM();
        }
    }

    public final void SL() {
        if (this.gbd != null) {
            this.gbd.SL();
        }
        this.gbl.bv(false);
        setKeepScreenOn(false);
    }

    public final void ajZ() {
        if (this.gbd != null) {
            this.gbd.ajZ();
        }
        this.gbl.bv(false);
        setKeepScreenOn(false);
    }

    public void setScaleType(h.d dVar) {
        if (this.gbd != null) {
            this.gbd.setScaleType(dVar);
        }
    }

    public final boolean ac(float f) {
        if (f > 0.0f && this.gbd != null) {
            return this.gbd.ac(f);
        }
        return false;
    }

    public final void d(String str, String str2, String str3, int i, int i2) {
        x.w("MicroMsg.WebVideoWrapper", "%d onError[%s %d, %d]", new Object[]{Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.gbe != null) {
            this.gbe.d(str, str2, str3, i, i2);
        }
    }

    public final void bu(String str, String str2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onPrepared", new Object[]{Integer.valueOf(hashCode())});
        if (this.gbe != null) {
            this.gbe.bu(str, str2);
        }
    }

    public final void bv(String str, String str2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onVideoEnded", new Object[]{Integer.valueOf(hashCode())});
        if (this.gbe != null) {
            this.gbe.bv(str, str2);
        }
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.WebVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.gbe != null) {
            this.gbe.d(str, str2, i, i2);
        }
    }

    public final void bw(String str, String str2) {
        x.d("MicroMsg.WebVideoWrapper", "%d onVideoPause", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(false);
        this.gbl.bv(false);
        if (this.gbe != null) {
            this.gbe.bw(str, str2);
        }
    }

    public final void bx(String str, String str2) {
        x.d("MicroMsg.WebVideoWrapper", "%d onVideoPlay", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(true);
        this.gbl.a(this);
        if (this.gbe != null) {
            this.gbe.bx(str, str2);
        }
    }

    public final void by(String str, String str2) {
        if (this.gbe != null) {
            this.gbe.by(str, str2);
        }
    }

    public final void bz(String str, String str2) {
        if (this.gbe != null) {
            this.gbe.bz(str, str2);
        }
    }

    public void setKeepScreenOn(boolean z) {
        x.d("MicroMsg.WebVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[]{Boolean.valueOf(z), bi.cjd()});
        super.setKeepScreenOn(z);
    }

    public final void bQ(long j) {
        com.tencent.mm.plugin.report.service.h.mEJ.a(600, j, 1, false);
    }

    public final void pV(String str) {
        com.tencent.mm.plugin.report.service.h.mEJ.k(14349, str);
    }
}
