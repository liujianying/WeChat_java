package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.topstory.ui.d;
import com.tencent.mm.plugin.websearch.api.a.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;

public final class m extends MMVideoView {
    private String bJK = "";
    private a oAb;
    private bti ozj;

    public m(Context context, a aVar) {
        super(context);
        this.mContext = context;
        this.oAb = aVar;
    }

    protected final void SJ() {
        this.elO.elS = 4;
        this.elO.elT = 2;
    }

    protected final f bT(Context context) {
        TopStoryVideoPlayTextureView topStoryVideoPlayTextureView = new TopStoryVideoPlayTextureView(context);
        topStoryVideoPlayTextureView.setOpenWithNoneSurface(true);
        topStoryVideoPlayTextureView.setNeedResetExtractor(bIi());
        topStoryVideoPlayTextureView.setIsOnlineVideoType(true);
        return topStoryVideoPlayTextureView;
    }

    private static boolean bIi() {
        boolean z = false;
        try {
            g.Ek();
            return g.Ei().DT().getBoolean(a.sVF, false);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e, "check need reset error", new Object[z]);
            return z;
        }
    }

    public final void setVideoInfo(bti bti) {
        super.c(false, bti.videoUrl, bti.sqR);
        this.ozj = bti;
        this.elz = d.ak(bti.sqS, bti.sqT);
        this.elA = this.oAb.bHW() + this.elz + ".mp4";
    }

    protected final void initView() {
        super.initView();
    }

    public final boolean iD(int i) {
        Exception e;
        if (this.elC == 3) {
            return true;
        }
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        boolean isVideoDataAvailable;
        try {
            boolean b;
            int i2;
            PInt pInt3 = new PInt();
            PInt pInt4 = new PInt();
            if (i == 0 && this.elE != null && bIi()) {
                pInt4.value = 0;
                pInt3.value = 0;
                b = this.elE.b(i + 1, pInt3, pInt4);
            } else {
                b = false;
            }
            int i3 = i + 1;
            if (b) {
                i2 = pInt4.value;
            } else {
                i2 = i3;
            }
            if (this.ely == null || this.elE == null || !this.elE.a(i, i2, pInt, pInt2)) {
                return false;
            }
            isVideoDataAvailable = this.ely.isVideoDataAvailable(this.elz, pInt.value, pInt2.value);
            if (!isVideoDataAvailable) {
                return isVideoDataAvailable;
            }
            try {
                this.elJ = i2;
                return isVideoDataAvailable;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            isVideoDataAvailable = false;
            x.e("MicroMsg.TopStory.TopStoryVideoView", "%s check video data error %s ", new Object[]{avy(), e.toString()});
            return isVideoDataAvailable;
        }
    }

    public final void h(String str, int i, int i2) {
        if (bi.fS(this.elz, str)) {
            x.d("MicroMsg.TopStory.TopStoryVideoView", "%s download  onProgress [%d, %d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.elI && this.elD == 3) {
                iC(getCurrPosSec());
            }
        }
    }

    public final boolean x(int i, boolean z) {
        if (this.elE != null) {
            int VM = this.elE.VM();
            if (i > VM && VM > 0) {
                x.i("MicroMsg.TopStory.TopStoryVideoView", "%s seek to reset time ori[%d] last key frame[%d]", new Object[]{avy(), Integer.valueOf(i), Integer.valueOf(VM)});
                i = VM;
            }
        }
        return super.x(i, z);
    }

    protected final boolean a(int i, PInt pInt, PInt pInt2) {
        boolean z;
        pInt.value = Math.max(i, this.elJ);
        if (this.elD == 1 || this.elD == 0) {
            if (this.elE == null || !bIi()) {
                z = false;
            } else {
                pInt2.value = 0;
                pInt.value = 0;
                z = this.elE.b(i + 1, pInt, pInt2);
            }
            if (!z) {
                pInt.value = i;
                pInt2.value = pInt.value + 4;
            }
        } else {
            z = false;
        }
        if (this.elD == 2) {
            if (this.elE != null) {
                z = this.elE.b(i, pInt, pInt2);
                pInt2.value += 4;
            }
            if (!z) {
                pInt.value = i - 8;
                if (pInt.value < 0) {
                    pInt.value = 0;
                }
                pInt2.value = (pInt.value + this.elK) + 8;
            }
        }
        if (this.elD == 3 || this.elD == 4) {
            pInt.value = this.elJ;
            pInt2.value = this.elF + 1;
        }
        if (pInt2.value >= this.elF + 1) {
            pInt2.value = this.elF + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + 2;
            return false;
        }
        x.d("MicroMsg.TopStory.TopStoryVideoView", "%s calcDownloadRange2 range[%d, %d, %b] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[]{avy(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(this.elD), Integer.valueOf(this.elJ), Integer.valueOf(this.elK), this.elz});
        return true;
    }

    public final void Ov(String str) {
        this.bJK = str;
        start();
    }

    public final void ajZ() {
        super.ajZ();
        this.oAb = null;
    }

    public final void start() {
        super.start();
        com.tencent.mm.plugin.websearch.api.a.a.kB(5);
    }

    public final boolean isPlaying() {
        boolean z;
        boolean isPlaying = super.isPlaying();
        if (isPlaying && this.elD == 3) {
            z = true;
        } else {
            z = false;
        }
        x.d("MicroMsg.TopStory.TopStoryVideoView", "%s result [%b] is playing[%b] playStatus[%d]", new Object[]{avy(), Boolean.valueOf(z), Boolean.valueOf(isPlaying), Integer.valueOf(this.elD)});
        return isPlaying;
    }

    public final int getCurrPosMs() {
        int i = 0;
        if (this.hEl != null) {
            i = this.hEl.getCurrentPosition();
        }
        if (this.elG > 0) {
            return this.elG * 1000;
        }
        return i;
    }

    public final int getCurrPosSec() {
        int i = 0;
        if (this.hEl != null) {
            i = Math.round((((float) this.hEl.getCurrentPosition()) * 1.0f) / 1000.0f);
        }
        if (this.elG > 0) {
            return this.elG;
        }
        return i;
    }

    public final void L(String str, int i) {
        super.L(str, i);
        if (i != 0 && this.gbe != null) {
            this.gbe.d(getSessionId(), getMediaId(), "download error", i, 0);
        }
    }

    public final void onError(int i, int i2) {
        super.onError(i, i2);
        switch (i2) {
            case IX5WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                b.kB(b.pMH);
                return;
            case IX5WebViewClient.ERROR_HOST_LOOKUP /*-2*/:
                try {
                    g.Ek();
                    g.Ei().DT().a(a.sVF, Boolean.valueOf(true));
                    if (this.hEl instanceof TopStoryVideoPlayTextureView) {
                        ((TopStoryVideoPlayTextureView) this.hEl).setNeedResetExtractor(true);
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoView", e, "%s onError [%s]", new Object[]{avy(), e.toString()});
                }
                b.kB(b.pMG);
                return;
            case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                b.kB(b.pMF);
                return;
            default:
                return;
        }
    }

    protected final boolean bIj() {
        return false;
    }

    public final void SM() {
        x.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIResume", new Object[]{avy()});
        if (!this.qEh) {
            this.qEh = true;
            if (this.hEl != null) {
                if (this.qEp) {
                    play();
                } else {
                    ((VideoPlayerTextureView) this.hEl).bdC();
                }
            }
            bQ((long) (getReportIdkey() + 10));
        }
    }

    public final void SL() {
        x.i("MicroMsg.TopStory.TopStoryVideoView", "%s onUIPause", new Object[]{avy()});
        if (this.qEh) {
            this.qEo = getCurrPosSec();
            this.qEp = isPlaying();
            this.qEv = 0;
            this.qEu = 0;
            pause();
            SO();
            this.qEh = false;
            bQ((long) (getReportIdkey() + 11));
        }
    }

    public final String getSessionId() {
        return this.bJK;
    }

    public final void bIk() {
        ((TopStoryVideoPlayTextureView) this.hEl).setAlpha(1.0f);
    }

    public final void stop() {
        super.stop();
        this.ozj = null;
    }
}
