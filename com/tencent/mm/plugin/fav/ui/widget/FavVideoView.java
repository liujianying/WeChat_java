package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public class FavVideoView extends RelativeLayout implements a {
    public String dXA;
    public ag hDf;
    public f hEl;
    public String jdM;
    private ImageView jdj;
    private boolean jdm;
    private TextView jfK;
    private boolean jfL;
    private boolean jfM;
    private int jfN;
    private ProgressBar jfO;
    private MMPinProgressBtn jfP;
    private int jfQ;
    public a jfR;

    public FavVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hDf = new ag(Looper.getMainLooper());
        this.jfL = false;
        this.jfM = false;
        this.jfN = 0;
        this.jdm = false;
        this.jdM = "";
        this.jfQ = 0;
        this.jfR = new a(this, (byte) 0);
        x.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(context).inflate(m.f.fav_video_view, this);
        this.jdj = (ImageView) findViewById(e.video_thumb);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(e.video_root);
        ((TextView) findViewById(e.video_duration)).setVisibility(8);
        this.jfP = (MMPinProgressBtn) findViewById(e.video_progress);
        this.jfO = (ProgressBar) findViewById(e.video_loading);
        this.jfK = (TextView) findViewById(e.video_tips);
        if (d.NW()) {
            this.jfM = true;
            this.hEl = new VideoPlayerTextureView(context);
        } else {
            this.jfM = false;
            this.hEl = new VideoTextureView(context);
        }
        this.hEl.setVideoCallback(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        relativeLayout.addView((View) this.hEl, layoutParams);
        ((com.tencent.mm.plugin.record.a.a) g.n(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.jfR);
        ((ae) g.n(ae.class)).getFavCdnStorage().a(this.jfR);
    }

    public void setVideoData(String str) {
        this.dXA = str;
    }

    public final void onResume() {
        x.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
        if (!this.jfL) {
            if (bi.oW(this.dXA) || !com.tencent.mm.vfs.d.cn(this.dXA)) {
                x.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
                eY(false);
                return;
            }
            x.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
            BK(this.dXA);
        }
    }

    private void eY(boolean z) {
        this.hDf.post(new 1(this, z));
    }

    public final void BK(String str) {
        x.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
        if (bi.oW(str)) {
            x.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        if (this.hEl != null) {
            if (this.hEl instanceof VideoPlayerTextureView) {
                ((VideoPlayerTextureView) this.hEl).setNeedResetExtractor(g.Ei().DT().getBoolean(aa.a.sVF, false));
            }
            this.hEl.setVideoPath(str);
        }
        if (((Integer) g.Ei().DT().get(aa.a.sUA, Integer.valueOf(0))).intValue() == 1) {
            this.jfK.setText(com.tencent.mm.plugin.sight.base.d.Ho(str));
            this.jfK.setVisibility(0);
        }
    }

    public final int ck(int i, int i2) {
        return 0;
    }

    public final void cl(int i, int i2) {
    }

    public final void iy() {
        this.jfN = 0;
        eY(true);
        this.jdm = this.hEl.start();
        x.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[]{Integer.valueOf(this.hEl.getDuration() / 1000)});
    }

    public final void wd() {
        x.i("MicroMsg.FavVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        if (com.tencent.mm.compatible.util.d.fT(18) || !this.jfM) {
            x.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[]{Integer.valueOf(0)});
            this.hEl.x(0.0d);
        } else if (this.hEl != null) {
            this.hEl.stop();
        }
    }

    public final void onError(int i, int i2) {
        x.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.jfM)});
        if (this.jdm) {
            wd();
            return;
        }
        this.jfN = i2;
        String videoPath = this.hEl.getVideoPath();
        this.hEl.stop();
        this.jfL = true;
        eY(false);
        if (this.jfN == -1) {
            this.jfQ++;
            if (this.jfQ <= 3) {
                ah.A(new 2(this));
                return;
            }
        }
        if (!bi.oW(videoPath) && com.tencent.mm.vfs.d.cn(videoPath)) {
            x.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
            this.hDf.post(new 3(this, videoPath));
        }
    }
}
