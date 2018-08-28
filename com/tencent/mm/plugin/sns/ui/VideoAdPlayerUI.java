package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.d;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i$j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.y.n$a;

@a(19)
public class VideoAdPlayerUI extends MMActivity implements b.a, b.b {
    private String bOX = "";
    private String bZN;
    private String bssid;
    private String dXA = "";
    private String dyM = "";
    private String dyN = "";
    private String fvT = "";
    private d gbl;
    private boolean hTT = false;
    private String mediaId = "";
    private String nAW = "";
    private n nSE;
    private boolean nkG = false;
    private h oaT = new h("VideoAdPlayerUI");
    private VideoPlayView oid;
    private com.tencent.mm.modelsns.b oie = null;
    private String oif = "";
    private int oig = 0;
    private String oih = "";
    public String oii = "";
    public String oij = "";
    private int oik = 0;
    private int oil = 0;
    private String oim = "";
    private String oin;
    private String oio = "";
    private long oip = 0;
    private int oiq = 0;
    private int oir = 0;
    private boolean ois = false;
    private boolean oit = false;
    private ate oiu = null;
    private String oiv;
    private int oiw;
    private String[] oix = null;
    private String[] oiy = null;
    private String ssid;
    private String thumbUrl = "";
    private String url = "";

    static /* synthetic */ void o(VideoAdPlayerUI videoAdPlayerUI) {
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", videoAdPlayerUI.oif);
        intent.putExtra("Ksnsupload_type", 11);
        intent.putExtra("Ksnsupload_title", videoAdPlayerUI.oih);
        intent.putExtra("Ksnsupload_imgurl", videoAdPlayerUI.thumbUrl);
        intent.putExtra("KSnsStreamVideoTotalTime", videoAdPlayerUI.oiu.oig);
        intent.putExtra("KSnsStreamVideoWroding", videoAdPlayerUI.dyM);
        intent.putExtra("KSnsStreamVideoWebUrl", videoAdPlayerUI.dyN);
        intent.putExtra("KSnsStreamVideoAduxInfo", videoAdPlayerUI.oii);
        intent.putExtra("KSnsStreamVideoPublishId", videoAdPlayerUI.oij);
        intent.putExtra("need_result", true);
        intent.putExtra("key_snsad_statextstr", videoAdPlayerUI.bZN);
        String str = "sns_";
        if (videoAdPlayerUI.oil == j.b.njT.value || videoAdPlayerUI.oil == j.b.njU.value) {
            str = "sns_" + videoAdPlayerUI.oio;
        } else if (videoAdPlayerUI.oil == j.b.njV.value || videoAdPlayerUI.oil == j.b.njW.value) {
            str = "msg_" + videoAdPlayerUI.oip;
        } else if (videoAdPlayerUI.oil == j.b.njX.value) {
            str = "fav_" + q.GF() + "_" + videoAdPlayerUI.oiq;
        }
        String ic = u.ic(str);
        u.Hx().v(ic, true).p("prePublishId", str);
        intent.putExtra("reportSessionId", ic);
        com.tencent.mm.bg.d.b(videoAdPlayerUI, "sns", ".ui.SnsUploadUI", intent, 4098);
        if (videoAdPlayerUI.oiw != 0) {
            int i = videoAdPlayerUI.oaT.njs.nkq;
            if (videoAdPlayerUI.hTT && videoAdPlayerUI.oaT.njs.nku != 0) {
                i += (int) (bi.bI(videoAdPlayerUI.oaT.njs.nku) / 1000);
            }
            i iVar = new i(13228, "1,4," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bi.VE() + "," + videoAdPlayerUI.oiv + "," + videoAdPlayerUI.oig, (int) bi.VE());
            g.Ek();
            g.Eh().dpP.a(iVar, 0);
        }
    }

    static /* synthetic */ void p(VideoAdPlayerUI videoAdPlayerUI) {
        ch chVar = new ch();
        ((ad) g.l(ad.class)).a(chVar, videoAdPlayerUI.oiu.oig, videoAdPlayerUI.oih, "", videoAdPlayerUI.oiu.rVL, videoAdPlayerUI.dyM, videoAdPlayerUI.dyN, videoAdPlayerUI.thumbUrl, videoAdPlayerUI.bOX, videoAdPlayerUI.oim, videoAdPlayerUI.oii, videoAdPlayerUI.oij, videoAdPlayerUI.bZN);
        chVar.bJF.activity = videoAdPlayerUI;
        chVar.bJF.bJM = 24;
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        if (chVar.bJG.ret == 0 && videoAdPlayerUI.oil != 0) {
            j.a(c.njZ, videoAdPlayerUI.oij, videoAdPlayerUI.oii, videoAdPlayerUI.oik, videoAdPlayerUI.oil, videoAdPlayerUI.oim, videoAdPlayerUI.oin, videoAdPlayerUI.oio, videoAdPlayerUI.oip, videoAdPlayerUI.oiq, videoAdPlayerUI.oir, 0);
        }
        if (videoAdPlayerUI.nkG) {
            com.tencent.mm.plugin.sns.a.b.c cVar = new com.tencent.mm.plugin.sns.a.b.c(videoAdPlayerUI.fvT, 11, 6, "", 2, videoAdPlayerUI.nSE.bAK());
            g.Ek();
            g.Eh().dpP.a(cVar, 0);
        }
        if (videoAdPlayerUI.oiw != 0) {
            int i = videoAdPlayerUI.oaT.njs.nkq;
            if (videoAdPlayerUI.hTT && videoAdPlayerUI.oaT.njs.nku != 0) {
                i += (int) (bi.bI(videoAdPlayerUI.oaT.njs.nku) / 1000);
            }
            i iVar = new i(13228, "1,5," + i + "," + videoAdPlayerUI.ssid + "," + videoAdPlayerUI.bssid + "," + bi.VE() + "," + videoAdPlayerUI.oiv + "," + videoAdPlayerUI.oig, (int) bi.VE());
            g.Ek();
            g.Eh().dpP.a(iVar, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        String s;
        super.onCreate(bundle);
        this.mController.hideTitleView();
        getWindow().setFlags(1024, 1024);
        this.oix = new String[]{getString(i$j.sns_ad_video_right_menu_send_friend), getString(i$j.sns_ad_video_right_menu_share_sns), getString(i$j.sns_ad_video_right_menu_fav)};
        this.oiy = new String[]{getString(i$j.sns_ad_video_right_menu_send_friend), getString(i$j.sns_ad_video_right_menu_share_sns)};
        this.nSE = af.byo().Nk(com.tencent.mm.plugin.sns.data.i.LP(getIntent().getStringExtra("KSta_SnSId")));
        this.gbl = new d();
        this.oie = com.tencent.mm.modelsns.b.p(getIntent());
        this.dXA = getIntent().getStringExtra("KFullVideoPath");
        this.oif = getIntent().getStringExtra("KStremVideoUrl");
        this.thumbUrl = getIntent().getStringExtra("KThumUrl");
        this.mediaId = getIntent().getStringExtra("KMediaId");
        this.nkG = getIntent().getBooleanExtra("IsAd", false);
        this.url = getIntent().getStringExtra("KUrl");
        this.oih = bi.aG(getIntent().getStringExtra("KMediaTitle"), "");
        this.oig = getIntent().getIntExtra("KMediaVideoTime", 0);
        this.ois = getIntent().getBooleanExtra("KBlockFav", false);
        this.oit = getIntent().getBooleanExtra("ForceLandscape", false);
        this.dyM = getIntent().getStringExtra("StreamWording");
        this.dyN = getIntent().getStringExtra("StremWebUrl");
        this.nAW = getIntent().getStringExtra("KComponentCid");
        this.oii = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
        this.oij = getIntent().getStringExtra("KSta_StremVideoPublishId");
        this.oik = getIntent().getIntExtra("KSta_SourceType", 0);
        this.oil = getIntent().getIntExtra("KSta_Scene", 0);
        this.oim = getIntent().getStringExtra("KSta_FromUserName");
        this.oin = getIntent().getStringExtra("KSta_ChatName");
        this.oio = getIntent().getStringExtra("KSta_SnSId");
        this.oip = getIntent().getLongExtra("KSta_MsgId", 0);
        this.oiq = getIntent().getIntExtra("KSta_FavID", 0);
        this.oir = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
        this.bZN = getIntent().getStringExtra("KSta_SnsStatExtStr");
        this.fvT = bi.aG(getIntent().getStringExtra("KViewId"), "");
        this.oiv = bi.aG(getIntent().getStringExtra("ReportArgs"), "");
        this.oiw = getIntent().getIntExtra("NeedReportData", 0);
        if (this.oiw != 0) {
            WifiInfo connectionInfo = ((WifiManager) getSystemService("wifi")).getConnectionInfo();
            this.ssid = connectionInfo.getSSID();
            this.bssid = connectionInfo.getBSSID();
        }
        this.oiu = new ate();
        this.oiu.rVE = this.thumbUrl;
        this.oiu.rVL = this.oif;
        this.oiu.ksA = this.mediaId;
        this.oiu.jPK = this.url;
        this.oiu.rVD = 1;
        this.oiu.oig = this.oig;
        this.oaT.njm = bi.VG();
        x.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.oiu.ksA + " attachurl:" + this.oiu.rVL + " videoattachTotalTime:" + this.oiu.oig + " streamvideowording: " + this.dyM + " streamvideoweburl: " + this.dyN + " mediaTitle: " + this.oih + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.oii + " streamvideopublishid " + this.oij);
        if (bi.oW(this.dXA)) {
            s = an.s(af.getAccSnsPath(), this.oiu.ksA);
            this.dXA = s + com.tencent.mm.plugin.sns.data.i.k(this.oiu);
        }
        if (bi.oW(this.bOX) || !e.cn(this.bOX)) {
            s = "attach" + this.oiu.ksA;
            this.bOX = an.s(af.getAccSnsPath(), s) + com.tencent.mm.plugin.sns.data.i.LA(s);
        }
        if (!e.cn(this.bOX)) {
            try {
                ate ate = new ate();
                ate.aG(this.oiu.toByteArray());
                ate.ksA = "attach" + ate.ksA;
                com.tencent.mm.plugin.sns.data.e eVar = new com.tencent.mm.plugin.sns.data.e(this.oiu);
                eVar.nkQ = 1;
                eVar.kJG = this.oiu.ksA;
                af.byj().a(ate, 7, eVar, av.tbu);
            } catch (Exception e) {
                x.e("MicroMsg.VideoPlayerUI", "error for download thumb");
            }
            getWindow().addFlags(128);
        }
        this.oid = (VideoPlayView) findViewById(i$f.video_play_view);
        VideoPlayView videoPlayView = this.oid;
        AdVideoPlayerLoadingBar adVideoPlayerLoadingBar = new AdVideoPlayerLoadingBar(this.mController.tml);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = videoPlayView.getContext().getResources().getDimensionPixelSize(com.tencent.mm.plugin.ak.a.c.NoPadding);
        videoPlayView.nea = adVideoPlayerLoadingBar;
        videoPlayView.hEl.setPlayProgressCallback(true);
        videoPlayView.addView((View) videoPlayView.nea, layoutParams);
        videoPlayView.nea.setIplaySeekCallback(new 5(videoPlayView));
        videoPlayView.nea.setOnPlayButtonClickListener(new 6(videoPlayView));
        videoPlayView.nea.setIsPlay(videoPlayView.hEl.isPlaying());
        if (videoPlayView.nea != null) {
            ((View) videoPlayView.nea).setVisibility(8);
        }
        adVideoPlayerLoadingBar.seek(0);
        this.oid.setVideoPlayViewEvent(new 1(this));
        this.oid.setVideoTotalTime(this.oiu.oig);
        if (e.cn(this.dXA)) {
            this.oaT.njk = 1;
            this.oid.setVideoPath(this.dXA);
        } else {
            this.oid.bvW();
            this.oid.setIsDownloading(true);
            af.byj().a(this.oiu, 6, null, av.tbu);
        }
        this.oid.setLeftButtonOnClickListener(new 2(this));
        this.oid.setRightButtonOnCliclListener(new 3(this));
        VideoPlayView videoPlayView2 = this.oid;
        CharSequence charSequence = this.dyM;
        4 4 = new 4(this);
        videoPlayView2.ned = charSequence;
        videoPlayView2.nec.setText(charSequence);
        videoPlayView2.nec.setOnClickListener(4);
        this.oid.bvY();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0) {
            videoPlayView2 = this.oid;
            if (videoPlayView2.tnq != null) {
                videoPlayView2.neg = false;
                videoPlayView2.tnq.setVisibility(8);
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.plugin.sns.a.b.c cVar;
        x.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[]{Integer.valueOf(i)});
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bi.F(stringExtra.split(","))) {
                    int i3;
                    x.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[]{str});
                    com.tencent.mm.y.g.a aVar = new com.tencent.mm.y.g.a();
                    aVar.title = this.oih;
                    aVar.type = 4;
                    if (bi.oW(this.oiu.jPK)) {
                        aVar.url = this.oiu.rVL;
                    } else {
                        aVar.url = this.oiu.jPK;
                    }
                    if (bi.oW(this.oiu.rVO)) {
                        stringExtra = this.oiu.rVE;
                    } else {
                        stringExtra = this.oiu.rVO;
                    }
                    aVar.thumburl = stringExtra;
                    aVar.dyJ = this.oiu.rVL;
                    aVar.dyK = this.oiu.oig;
                    aVar.dyL = this.oih;
                    aVar.dyN = this.dyN;
                    aVar.dyM = this.dyM;
                    aVar.dyO = this.thumbUrl;
                    aVar.dyP = this.oii;
                    aVar.dyQ = this.oij;
                    aVar.bZN = this.bZN;
                    byte[] e = FileOp.e(this.bOX, 0, -1);
                    String str2 = "MicroMsg.VideoPlayerUI";
                    String str3 = "read buf size %d";
                    Object[] objArr = new Object[1];
                    if (e == null) {
                        i3 = 0;
                    } else {
                        i3 = e.length;
                    }
                    objArr[0] = Integer.valueOf(i3);
                    x.i(str2, str3, objArr);
                    if (n$a.FH() != null) {
                        n$a.FH().a(aVar, "", "", str, "", e);
                    }
                    if (this.oiw != 0) {
                        i3 = this.oaT.njs.nkq;
                        if (this.hTT && this.oaT.njs.nku != 0) {
                            i3 += (int) (bi.bI(this.oaT.njs.nku) / 1000);
                        }
                        i iVar = new i(13228, "1,3," + i3 + "," + this.ssid + "," + this.bssid + "," + bi.VE() + "," + this.oiv + "," + this.oig, (int) bi.VE());
                        g.Ek();
                        g.Eh().dpP.a(iVar, 0);
                    }
                    com.tencent.mm.plugin.messenger.a.g.bcT().dF(stringExtra2, str);
                    if (this.nkG) {
                        com.tencent.mm.plugin.sns.a.b.c cVar2 = new com.tencent.mm.plugin.sns.a.b.c(this.fvT, 12, 6, "", 2, this.nSE.bAK());
                        g.Ek();
                        g.Eh().dpP.a(cVar2, 0);
                    }
                    if (this.oil != 0) {
                        c cVar3;
                        int gK;
                        boolean fq = s.fq(str);
                        if (fq) {
                            cVar3 = c.nkb;
                        } else {
                            cVar3 = c.nka;
                        }
                        String str4 = this.oij;
                        str2 = this.oii;
                        int i4 = this.oik;
                        int i5 = this.oil;
                        String str5 = this.oim;
                        String str6 = this.oin;
                        String str7 = this.oio;
                        long j = this.oip;
                        int i6 = this.oiq;
                        int i7 = this.oir;
                        if (fq) {
                            gK = m.gK(str);
                        } else {
                            gK = 0;
                        }
                        j.a(cVar3, str4, str2, i4, i5, str5, str6, str7, j, i6, i7, gK);
                    }
                }
                com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i$j.has_send));
            } else if (this.nkG) {
                cVar = new com.tencent.mm.plugin.sns.a.b.c(this.fvT, 13, 6, "", 2, this.nSE.bAK());
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
            }
        }
        if (4098 == i) {
            if (this.oil != 0) {
                j.a(c.nkc, this.oij, this.oii, this.oik, this.oil, this.oim, this.oin, this.oio, this.oip, this.oiq, this.oir, 0);
            }
            if (-1 == i2) {
                if (this.nkG) {
                    cVar = new com.tencent.mm.plugin.sns.a.b.c(this.fvT, 15, 6, "", 2, this.nSE.bAK());
                    g.Ek();
                    g.Eh().dpP.a(cVar, 0);
                }
            } else if (this.nkG) {
                cVar = new com.tencent.mm.plugin.sns.a.b.c(this.fvT, 16, 6, "", 2, this.nSE.bAK());
                g.Ek();
                g.Eh().dpP.a(cVar, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onDestroy() {
        super.onDestroy();
        getWindow().clearFlags(128);
        if (this.oil != 0) {
            j.a(j.a.njP, this.oij, this.oii, this.oik, this.oil, this.oim, this.oin, this.oio, this.oip, this.oiq, this.oir);
        }
        if (this.nkG) {
            int bBq = this.nSE == null ? 0 : this.nSE.bBq();
            String bwN = this.oaT.bwN();
            long j = ((long) this.oaT.njl) - this.oaT.egP;
            if (j < 0) {
                x.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[]{Integer.valueOf(this.oaT.njl), Long.valueOf(this.oaT.egP)});
                j = (long) this.oaT.njl;
            }
            int i = (int) j;
            g.Ek();
            g.Eh().dpP.a(new com.tencent.mm.plugin.sns.a.b.d(this.fvT, 6, 2, this.oaT.njl, null, null, 2, bwN, -1, bBq, i, i, 0), 0);
        }
        if (this.oiw != 0) {
            int i2 = this.oaT.njs.nkq;
            if (this.hTT && this.oaT.njs.nku != 0) {
                i2 += (int) (bi.bI(this.oaT.njs.nku) / 1000);
            }
            i iVar = new i(13228, "1,2," + i2 + "," + this.ssid + "," + this.bssid + "," + bi.VE() + "," + this.oiv + "," + this.oig, (int) bi.VE());
            g.Ek();
            g.Eh().dpP.a(iVar, 0);
        }
        setResult(-1, getIntent().putExtra("key_activity_browse_time", cql()));
    }

    public void finish() {
        if (this.hTT) {
            this.oid.pause();
        }
        if (!(this.oaT == null || this.nAW == null || this.nAW.length() <= 0)) {
            this.oaT.bwO();
            Intent intent = new Intent();
            intent.putExtra("KComponentCid", this.nAW);
            intent.putExtra("KStreamVideoPlayCount", this.oaT.njo);
            intent.putExtra("KStreamVideoPlayCompleteCount", this.oaT.njp);
            intent.putExtra("KStreamVideoTotalPlayTimeInMs", this.oaT.njq);
            setResult(-1, intent);
        }
        super.finish();
    }

    protected void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        x.i("MicroMsg.VideoPlayerUI", "onpause  " + i);
        xy(i);
        if (this.oid != null && this.oid.isPlaying()) {
            this.oid.pause();
        }
        if (this.oid != null) {
            x.i("MicroMsg.VideoPlayerUI", "onDetach");
            this.oid.onDetach();
        }
        af.byj().nmH.remove(this);
        af.byj().b(this);
        if (this.oaT != null) {
            this.oaT.egO = bi.VG();
        }
    }

    protected void onResume() {
        super.onResume();
        af.byj().nmH.add(this);
        af.byj().a(this);
        if (this.oaT != null) {
            this.oaT.onResume();
        }
    }

    protected final int getLayoutId() {
        return i$g.video_player_ui;
    }

    public final void ew(String str, String str2) {
        x.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.oid.isPlaying());
        if (!this.oid.isPlaying()) {
            this.oid.setLoop(false);
            if (str2.equals(this.oid.getVideoPath())) {
                this.oid.x(this.oid.getLastProgresstime());
                this.oid.start();
                x.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + str + " path: " + str2);
                return;
            }
            this.oid.setVideoPath(str2);
            this.oid.x(this.oid.getLastProgresstime());
            x.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + str + " path: " + str2);
        }
    }

    public final void LR(String str) {
    }

    public final void aS(String str, boolean z) {
    }

    public final void bxb() {
    }

    public final void aT(String str, boolean z) {
        x.i("MicroMsg.VideoPlayerUI", "onSightFinish " + str);
        this.oid.setIsDownloading(false);
        this.oid.setVideoPath(this.dXA);
        this.oid.x(this.oid.getLastProgresstime());
        this.oid.setLoop(false);
        if (this.nkG && !bi.oW(str) && this.oiu != null && str.equals(this.oiu.ksA) && FileOp.cn(this.dXA)) {
            this.oaT.njk = 1;
        }
    }

    protected final int getForceOrientation() {
        if (this.oit) {
            return 0;
        }
        return 4;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        VideoPlayView videoPlayView = this.oid;
        x.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + configuration.orientation + " " + videoPlayView.nep);
        if (videoPlayView.nep != configuration.orientation) {
            if (configuration.orientation == 1) {
                videoPlayView.update(1);
            } else {
                videoPlayView.update(2);
            }
            videoPlayView.nep = configuration.orientation;
            if (videoPlayView.nep == 2) {
                videoPlayView.gFD.setVisibility(8);
            }
        }
        xy(configuration.orientation);
    }

    private void xy(int i) {
        if (this.nkG) {
            this.oaT.wh(this.oid.getDuration());
            this.oaT.njs.nku = bi.VG();
            this.oaT.njs.nkt = i == 2 ? 2 : 1;
            this.oaT.njs.nks = 2;
            x.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.oaT.njs.nkt);
        }
    }
}
