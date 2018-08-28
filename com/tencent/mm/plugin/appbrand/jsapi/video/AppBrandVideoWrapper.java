package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class AppBrandVideoWrapper extends RelativeLayout implements a, h, h.a, b, c {
    private boolean avH;
    private h gbd;
    private b gbe;
    private g gbf;
    private d gbg;
    private boolean gbh;
    private float gbi;
    private int gbj;
    private boolean gbk;
    private com.tencent.mm.model.d gbl;
    private Context mContext;
    private String url;

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gbg = d.qFA;
        this.gbh = false;
        this.gbi = -1.0f;
        this.mContext = context;
        this.gbl = new com.tencent.mm.model.d();
    }

    public final void c(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        this.gbj = i;
        this.avH = z;
        PString pString = new PString();
        pString.value = str;
        if (bi.oW(pString.value) || pString.value.indexOf(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX) != 0) {
            z2 = false;
        } else {
            pString.value = pString.value.substring(9);
            z2 = true;
        }
        this.gbk = z2;
        this.url = pString.value;
        if (this.gbd == null) {
            if (a(this.avH, this.url, "")) {
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[]{Integer.valueOf(hashCode())});
                this.gbd = ajW();
            } else {
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[]{Integer.valueOf(hashCode())});
                this.gbd = ajX();
            }
        } else if (a(this.avH, this.url, "")) {
            if (this.gbd instanceof MMVideoView) {
                this.gbd.stop();
                this.gbd.ajY();
                removeView((View) this.gbd);
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[]{Integer.valueOf(hashCode())});
                this.gbd = ajW();
            } else {
                x.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[]{Integer.valueOf(hashCode())});
                this.gbd.stop();
                i2 = 0;
            }
        } else if (this.gbd instanceof CommonVideoView) {
            this.gbd.stop();
            this.gbd.ajY();
            removeView((View) this.gbd);
            x.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[]{Integer.valueOf(hashCode())});
            this.gbd = ajX();
        } else {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", new Object[]{Integer.valueOf(hashCode())});
            this.gbd.stop();
            i2 = 0;
        }
        setScaleType(this.gbg);
        ac(this.gbi);
        setMute(this.gbh);
        if (i2 != 0) {
            setVideoFooterView(this.gbf);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.gbd, layoutParams);
        }
        this.gbd.c(this.avH, this.url, this.gbj);
    }

    private h ajW() {
        CommonVideoView commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.setReporter(this);
        commonVideoView.setIMMVideoViewCallback(this);
        bQ(200);
        return commonVideoView;
    }

    private h ajX() {
        MMVideoView mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.setReporter(this);
        mMVideoView.setIMMVideoViewCallback(this);
        mMVideoView.setIOnlineVideoProxy(new AppBrandOnlineVideoProxy());
        mMVideoView.setIMMDownloadFinish(this);
        String str = e.bnE + "appbrandvideo/";
        com.tencent.mm.sdk.platformtools.h.Ey(str);
        mMVideoView.setRootPath(str);
        bQ(201);
        return mMVideoView;
    }

    private boolean a(boolean z, String str, String str2) {
        if (z || this.gbk || com.tencent.mm.compatible.util.d.fS(18)) {
            return true;
        }
        x.d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", new Object[]{Integer.valueOf(ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("appbrand_video_player", -1))});
        if (ad.getContext().getSharedPreferences("system_config_prefs", 4).getInt("appbrand_video_player", -1) <= 0) {
            x.i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
            return true;
        } else if (!bi.oW(str) && str.contains(".m3u8")) {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[]{Integer.valueOf(hashCode())});
            bQ(204);
            return true;
        } else if (!q.nG(str2)) {
            return false;
        } else {
            x.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[]{Integer.valueOf(hashCode())});
            bQ(204);
            return true;
        }
    }

    public void setIMMVideoViewCallback(b bVar) {
        this.gbe = bVar;
    }

    public void setVideoFooterView(g gVar) {
        this.gbf = gVar;
        if (this.gbd != null) {
            this.gbd.setVideoFooterView(this.gbf);
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
        this.gbh = z;
        if (this.gbd != null) {
            this.gbd.setMute(this.gbh);
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

    public void setScaleType(d dVar) {
        this.gbg = dVar;
        if (this.gbd != null) {
            this.gbd.setScaleType(this.gbg);
        }
    }

    public final boolean ac(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.gbi = f;
        if (this.gbd != null) {
            return this.gbd.ac(this.gbi);
        }
        return false;
    }

    public final void aa(String str, boolean z) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[]{Integer.valueOf(hashCode()), str, Boolean.valueOf(z)});
        if (!z) {
            int i;
            boolean i2;
            if (a(false, "", str)) {
                if (this.gbd instanceof MMVideoView) {
                    this.gbd.stop();
                    this.gbd.ajY();
                    removeView((View) this.gbd);
                    x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[]{Integer.valueOf(hashCode())});
                    this.gbd = ajW();
                    i2 = 1;
                }
                i2 = false;
            } else {
                if (this.gbd instanceof CommonVideoView) {
                    this.gbd.stop();
                    this.gbd.ajY();
                    removeView((View) this.gbd);
                    x.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", new Object[]{Integer.valueOf(hashCode())});
                    this.gbd = ajX();
                    i2 = 1;
                }
                i2 = false;
            }
            setScaleType(this.gbg);
            ac(this.gbi);
            setMute(this.gbh);
            if (i2 != 0) {
                setVideoFooterView(this.gbf);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                addView((View) this.gbd, layoutParams);
                this.gbd.c(this.avH, this.url, this.gbj);
                this.gbd.start();
            }
        }
    }

    public final void d(String str, String str2, String str3, int i, int i2) {
        x.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[]{Integer.valueOf(hashCode()), str3, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.gbe != null) {
            this.gbe.d(str, str2, str3, i, i2);
        }
    }

    public final void bu(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[]{Integer.valueOf(hashCode())});
        if (this.gbe != null) {
            this.gbe.bu(str, str2);
        }
        if (ajG()) {
            bQ(203);
        } else {
            bQ(202);
        }
    }

    public final void bv(String str, String str2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[]{Integer.valueOf(hashCode())});
        if (this.gbe != null) {
            this.gbe.bv(str, str2);
        }
    }

    public final void d(String str, String str2, int i, int i2) {
        x.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.gbe != null) {
            this.gbe.d(str, str2, i, i2);
        }
    }

    public final void bw(String str, String str2) {
        x.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(false);
        this.gbl.bv(false);
        if (this.gbe != null) {
            this.gbe.bw(str, str2);
        }
    }

    public final void bx(String str, String str2) {
        x.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[]{Integer.valueOf(hashCode())});
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
        x.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[]{Boolean.valueOf(z), bi.cjd()});
        super.setKeepScreenOn(z);
    }

    public final void bQ(long j) {
        com.tencent.mm.plugin.report.service.h.mEJ.a(600, j, 1, false);
    }

    public final void pV(String str) {
        com.tencent.mm.plugin.report.service.h.mEJ.k(14349, str);
    }
}
