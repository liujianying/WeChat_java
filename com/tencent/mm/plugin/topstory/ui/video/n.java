package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.b.e;
import com.tencent.mm.plugin.topstory.ui.b.g;
import com.tencent.mm.plugin.websearch.ui.WebSearchDotPercentIndicator;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.UUID;

public final class n extends RelativeLayout {
    private static com.tencent.mm.ak.a.a.c oBI;
    private boolean acT;
    private String bJK = "";
    private boolean hEj;
    private a oAb;
    private ImageView oBA;
    private ImageView oBB;
    private int oBC = c.oBT;
    private View oBD;
    private TextView oBE;
    private al oBF;
    private int oBG = -1;
    private boolean oBH;
    private b oBJ = new 13(this);
    private OnClickListener oBK = new 7(this);
    private OnClickListener oBL = new 8(this);
    private p oBb;
    private a oBc = a.oBO;
    FrameLayout oBd;
    TextView oBe;
    TopStoryVideoViewControlBar oBf;
    View oBg;
    View oBh;
    View oBi;
    private View oBj;
    View oBk;
    LinearLayout oBl;
    private WebSearchDotPercentIndicator oBm;
    private TextView oBn;
    private ImageView oBo;
    ImageView oBp;
    ImageView oBq;
    ImageView oBr;
    private Button oBs;
    private TextView oBt;
    TextView oBu;
    private TextView oBv;
    private c oBw;
    private c oBx;
    private View oBy;
    FrameLayout oBz;
    public bti ozj;
    public int position;

    private enum c {
        ;

        static {
            oBT = 1;
            oBU = 2;
            oBV = 3;
            oBW = new int[]{oBT, oBU, oBV};
        }
    }

    static /* synthetic */ boolean r(n nVar) {
        return !nVar.bIv();
    }

    public n(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(e.top_story_video_container, this);
        this.oBd = (FrameLayout) findViewById(d.video_view_parent);
        this.oBe = (TextView) findViewById(d.progress_tv);
        this.oBg = findViewById(d.video_action_and_info_layout);
        this.oBh = findViewById(d.video_tip_and_loading_layout);
        this.oBi = findViewById(d.video_action_layout);
        this.oBl = (LinearLayout) findViewById(d.adjust_info_layout);
        this.oBj = findViewById(d.video_info_layout);
        this.oBm = (WebSearchDotPercentIndicator) findViewById(d.adjust_percent_indicator);
        this.oBn = (TextView) findViewById(d.adjust_content);
        this.oBo = (ImageView) findViewById(d.adjust_icon);
        this.oBy = findViewById(d.video_loading_progress_bar);
        this.oBp = (ImageView) findViewById(d.cover_iv);
        this.oBv = (TextView) findViewById(d.video_size_tv);
        this.oBm.setDotsNum(8);
        this.oBq = (ImageView) findViewById(d.cover_area_play_btn);
        this.oBr = (ImageView) findViewById(d.cover_area_replay_btn);
        this.oBu = (TextView) findViewById(d.replay_hint_tv);
        this.oBs = (Button) findViewById(d.tip_cover_play);
        this.oBt = (TextView) findViewById(d.tip_cover_warning);
        this.oBk = findViewById(d.full_screen_play_next_area);
        this.oBD = findViewById(d.play_next_btn);
        this.oBE = (TextView) findViewById(d.play_next_countdown_tv);
        this.oBk.setVisibility(8);
        this.oBA = (ImageView) findViewById(d.player_bottom_progress_bar_front);
        this.oBB = (ImageView) findViewById(d.player_bottom_progress_bar_background);
        this.oBz = (FrameLayout) findViewById(d.player_bottom_progress_root);
        this.oBs.setOnClickListener(new 1(this));
        this.oBD.setOnClickListener(new 9(this));
        this.oBq.setOnClickListener(new 10(this));
        this.oBr.setOnClickListener(new 11(this));
        this.oBg.setOnClickListener(new 12(this));
        this.oBx = new c(getContext(), this, new b(this));
        this.oBw = new c(getContext(), this, new b(this));
        this.oBw.ozO = true;
        this.oBw.ozN = true;
        this.oBf = new TopStoryVideoViewControlBar(getContext());
        this.oBf.setVisibility(8);
        this.oBf.setEnterFullScreenBtnClickListener(this.oBL);
        this.oBf.setExitFullScreenBtnClickListener(this.oBK);
        this.oBf.setOnUpdateProgressLenListener(new 16(this));
        this.oBf.setMuteBtnOnClickListener(new 2(this));
        this.oBf.setIplaySeekCallback(new 3(this));
        this.oBf.setOnPlayButtonClickListener(new 4(this));
        this.oBf.setStatePorter(new 5(this));
        this.oBf.setShareBtnClickListener(new 6(this));
    }

    public final void setStreamUIComponent(a aVar) {
        this.oAb = aVar;
    }

    public final void setVideoItemUIComponent(p pVar) {
        this.oBb = pVar;
    }

    public final void bIl() {
        this.bJK = UUID.randomUUID().toString();
    }

    public final String getSessionId() {
        return this.bJK;
    }

    public final void bIm() {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "setPlayingContainerStatus");
        this.oBg.setVisibility(8);
        this.oBp.setVisibility(8);
        this.oBl.setVisibility(8);
        this.oBe.setVisibility(8);
        this.oBd.setVisibility(0);
        this.oBd.setAlpha(1.0f);
    }

    public final void bIn() {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "setStopContainerStatus");
        this.oBp.setVisibility(0);
        this.oBg.setVisibility(0);
        this.oBz.setVisibility(8);
        this.oBh.setVisibility(8);
        this.oBi.setVisibility(0);
        this.oBk.setVisibility(8);
        this.oBq.setVisibility(0);
        this.oBr.setVisibility(8);
        this.oBu.setVisibility(8);
        if (this.oAb.bHR().bHZ()) {
            this.oBv.setText(bi.a(this.ozj.srb, 100.0d));
            this.oBv.setVisibility(0);
            return;
        }
        this.oBv.setVisibility(8);
    }

    public final void bIo() {
        eS(getNoNetTip(), this.oAb.baA().getString(g.video_retry_play));
    }

    public final void eS(String str, String str2) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "setWarningTipContainerStatus %s %s", new Object[]{str, str2});
        this.oBp.setVisibility(0);
        this.oBg.setVisibility(0);
        this.oBh.setVisibility(0);
        this.oBi.setVisibility(8);
        this.oBk.setVisibility(8);
        this.oBj.setVisibility(0);
        this.oBy.setVisibility(8);
        if (TextUtils.isEmpty(str)) {
            this.oBt.setVisibility(8);
        } else {
            this.oBt.setText(str);
            this.oBt.setVisibility(0);
        }
        if (TextUtils.isEmpty(str2)) {
            this.oBs.setVisibility(8);
            return;
        }
        this.oBs.setText(str2);
        this.oBs.setVisibility(0);
    }

    public final void bIp() {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "setReplayContainerStatus");
        this.oBp.setVisibility(0);
        this.oBg.setVisibility(0);
        this.oBe.setVisibility(8);
        this.oBl.setVisibility(8);
        this.oBh.setVisibility(8);
        this.oBi.setVisibility(0);
        this.oBq.setVisibility(8);
        this.oBv.setVisibility(8);
        this.oBr.setVisibility(0);
        this.oBu.setVisibility(0);
        if (this.oBH && this.oAb.bHR().aEY()) {
            this.oBk.setVisibility(0);
        } else {
            this.oBk.setVisibility(8);
        }
    }

    static {
        a aVar = new a();
        aVar.dXy = true;
        aVar.dXx = true;
        oBI = aVar.Pt();
    }

    private String getMobileNetTip() {
        if (this.ozj.srb == 0) {
            return getContext().getString(g.video_net_warnning_no_size);
        }
        return getContext().getString(g.video_net_warnning, new Object[]{bi.a(this.ozj.srb, 100.0d)});
    }

    public final String getNoNetTip() {
        return getContext().getString(g.video_net_disable_warnning);
    }

    public final boolean iB(boolean z) {
        if (!this.oAb.bHR().isConnected()) {
            this.oBC = c.oBV;
            this.oBf.setVisibility(8);
            eS(getNoNetTip(), getContext().getString(g.video_retry_play));
            return false;
        } else if (z && this.oAb.bHR().bHZ() && !this.oAb.bHR().ozV) {
            this.oBC = c.oBU;
            this.oBf.setVisibility(8);
            eS(getMobileNetTip(), getContext().getString(g.video_continue_play));
            return false;
        } else {
            bIl();
            this.oBC = c.oBT;
            x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "setStartPlayContainerStatus");
            this.oBg.setVisibility(0);
            this.oBi.setVisibility(8);
            this.oBk.setVisibility(8);
            this.oBz.setVisibility(8);
            this.oBh.setVisibility(0);
            this.oBj.setVisibility(8);
            this.oBy.setVisibility(0);
            this.oBy.setVisibility(0);
            this.oBy.setAlpha(0.0f);
            this.oBy.animate().setDuration(2000).setInterpolator(new AccelerateInterpolator()).alpha(1.0f).start();
            this.oBp.setVisibility(0);
            this.oBl.setVisibility(8);
            this.oBe.setVisibility(8);
            this.oBd.setVisibility(0);
            this.oBd.setAlpha(0.0f);
            this.oBf.bTx();
            o bHS = this.oAb.bHS();
            if (bHS.oCd == null) {
                m mVar = new m(bHS.oAb.baA(), bHS.oAb);
                mVar.setRootPath(bHS.oAb.bHW());
                mVar.setIOnlineVideoProxy(new o.b(bHS, (byte) 0));
                mVar.setReporter(new com.tencent.mm.plugin.topstory.ui.video.o.c(bHS, (byte) 0));
                bHS.oCd = mVar;
            }
            if (bHS.oCd.getParent() != null) {
                ((ViewGroup) bHS.oCd.getParent()).removeView(bHS.oCd);
            }
            getVideoViewParent().addView(bHS.oCd);
            bHS.oCd.setVideoFooterView(getControlBar());
            bHS.oCd.setIMMVideoViewCallback(getVideoViewCallback());
            bHS.oCc.a(bHS.oCi);
            bHS.oCe = this;
            o bHS2 = this.oAb.bHS();
            a aVar = this.oAb;
            bti bti = this.ozj;
            String str = this.bJK;
            int i = this.position;
            if (bHS2.oCf != null) {
                if (!bHS2.oCf.sqZ.equals(bti.sqZ)) {
                    bHS2.oCd.stop();
                    aVar.bHU().b(aVar.bHT());
                    aVar.bHU().bIe();
                }
                return true;
            }
            if (bi.oW(bti.videoUrl)) {
                x.e("MicroMsg.TopStory.TopStoryVideoViewMgr", "start play video url is null %s %s %s", new Object[]{str, bti.sqS, bti.title});
            } else {
                aVar.bHU().a(bti, i, str);
                bHS2.oAb.bHU().a(bti);
                bHS2.oCd.setVideoInfo(bti);
                bHS2.oCd.setMute(false);
                bHS2.oCd.setKeepScreenOn(true);
                bHS2.oCd.Ov(str);
                bHS2.oCd.bIk();
                bHS2.oCf = bti;
                bHS2.oCg = true;
                bHS2.oCh = false;
            }
            return true;
        }
    }

    public final void aL() {
        this.oBp.setImageDrawable(null);
        o.Pj().a(this.ozj.sqQ, this.oBp, oBI);
        this.oBc = a.oBP;
        this.oBf.setVideoTotalTime(this.ozj.sqR);
        this.oBf.setFullScreenTitle(this.ozj.title);
        if (this.oBb != null && this.oBb.bIE() != this.oAb.bHP()) {
            if (this.oAb.bHR().isConnected()) {
                bIn();
            } else {
                eS(getNoNetTip(), getContext().getString(g.video_retry_play));
            }
        }
    }

    public final void seekTo(int i) {
        int currPosSec = this.oAb.bHS().getCurrPosSec();
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "seek to position=%d current=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(currPosSec)});
        o bHS = this.oAb.bHS();
        if (bHS.oCd != null) {
            bHS.oCd.x(i, true);
        }
        com.tencent.mm.plugin.topstory.a.b.a aVar = this.oAb.bHU().oAm;
        if (aVar != null) {
            aVar.oyV = 1;
        }
    }

    public final void bIq() {
        if (this.oBf != null) {
            this.oBf.setVisibility(8);
        }
    }

    public final void bIr() {
        if (this.oBf != null) {
            this.oBf.iD(false);
        }
    }

    public final void setMute(boolean z) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "setMute isMute=%b", new Object[]{Boolean.valueOf(z)});
        this.hEj = z;
        this.oAb.bHS().setMute(z);
        if (z) {
            this.oBf.Bo();
        } else {
            this.oBf.bTu();
        }
    }

    public final void bIs() {
        bIp();
        if (this.oAb.bHR().aEY()) {
            if (this.oBF == null) {
                this.oBF = new al(Looper.getMainLooper(), new 14(this), true);
            }
            this.oBG = 2;
            this.oBE.setVisibility(0);
            this.oBE.setText(getContext().getString(g.recommend_video_play_next_hint, new Object[]{Integer.valueOf(this.oBG)}));
            this.oBF.J(1000, 1000);
            x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "%s startPlayNextCountDown, position: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.position)});
            return;
        }
        bIt();
    }

    public final b getVideoViewCallback() {
        return this.oBJ;
    }

    public final void setShowFullScreenPlayNext(boolean z) {
        this.oBH = z;
    }

    public final void bIt() {
        if (this.oBF != null) {
            this.oBF.SO();
        }
        this.oBE.setVisibility(8);
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "%s stopPlayNextCountDown, position: %s", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.position)});
    }

    public final void iC(boolean z) {
        x.i("MicroMsg.TopStory.TopStoryVideoViewContainer", "playNextVideo %b", new Object[]{Boolean.valueOf(z)});
        if (this.position + 1 < this.oAb.bHO().size() - 1) {
            boolean z2;
            this.position++;
            if (!z) {
                this.oAb.bHU().oAl = 2;
            }
            this.ozj = (bti) this.oAb.bHO().get(this.position);
            aL();
            if (this.oAb.bHR().ozV) {
                z2 = false;
            } else {
                z2 = true;
            }
            iB(z2);
            return;
        }
        this.oAb.a(new 15(this, z));
        bIq();
        setShowFullScreenPlayNext(false);
        bIp();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.oAb.bHQ().jMc) {
            if (this.oBw != null) {
                this.oBw.E(motionEvent);
            }
        } else if (this.oBx != null) {
            this.oBx.E(motionEvent);
        }
        return true;
    }

    private int getSystemVolume() {
        return ((AudioManager) getContext().getSystemService("audio")).getStreamVolume(3);
    }

    public final void bIu() {
        if (getSystemVolume() <= 1) {
            setMute(true);
        } else {
            setMute(false);
        }
    }

    private boolean bIv() {
        return this.oBg.getVisibility() == 0;
    }

    public final FrameLayout getVideoViewParent() {
        return this.oBd;
    }

    public final TopStoryVideoViewControlBar getControlBar() {
        return this.oBf;
    }

    public final int getPosition() {
        return this.position;
    }

    public final bti getVideoInfo() {
        return this.ozj;
    }

    public final void dN(int i, int i2) {
        if (i == 0) {
            if (this.oAb.bHS().oCg) {
                bIm();
            } else {
                bIn();
            }
        } else if (i2 == 0) {
            bIo();
        }
    }
}
