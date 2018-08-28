package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.i$d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.smtt.utils.TbsLog;
import org.json.JSONObject;

public final class x extends a {
    public static int nFJ = 999;
    private Context context;
    private boolean djm;
    private ag dvh;
    private String fOr;
    private View gFD;
    int iGo = 0;
    private long lxh = 0;
    VideoPlayerSeekBar nEG;
    ImageView nEH;
    private ImageView nEI;
    private TextView nEJ;
    private boolean nEL = false;
    boolean nEO = true;
    private boolean nEP = true;
    private boolean nEQ = false;
    private boolean nER = true;
    private boolean nES = false;
    private boolean nET = false;
    boolean nEU = true;
    boolean nEV = true;
    private int nEW = 0;
    private int nEX = 0;
    private int nEY = 0;
    private int nEZ = 0;
    private OfflineVideoView nFA;
    private ProgressBar nFB;
    private int nFC;
    private boolean nFD = true;
    private int nFE = 0;
    int nFF = 0;
    int nFG = 0;
    private boolean nFH = false;
    private boolean nFI;
    private boolean nFK = false;
    private int nFa = 0;
    int nFb = 0;
    ac nFc = null;
    public int njo = 0;
    public int njp = 0;
    public int njq = 0;

    static /* synthetic */ void o(x xVar) {
        xVar.nEG.seek(0);
        xVar.bAk();
    }

    public x(Context context, q qVar, ViewGroup viewGroup) {
        super(context, qVar, viewGroup);
        this.context = context;
        this.dvh = new ag(Looper.getMainLooper());
        this.nFc = new 1(this, context);
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_sight;
    }

    public final View bzM() {
        LayoutParams layoutParams;
        ViewParent parent;
        boolean z = true;
        if (!e.cn(d.eH("adId", ((q) this.nDt).nAO))) {
            this.nEU = false;
        }
        if (!e.cn(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ac.ce(((q) this.nDt).nAN))) {
            this.nEV = false;
        }
        View findViewById = this.contentView.findViewById(f.sns_ad_native_landing_pages_item_video_container);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.sns_ad_native_landing_pages_item_sight_container);
        this.nFA = new OfflineVideoView(this.context);
        viewGroup.addView(this.nFA, 0, new LinearLayout.LayoutParams(-1, -1));
        LayoutParams layoutParams2;
        if (((q) this.nDt).nAT != 1) {
            int i = (int) ((q) this.nDt).width;
            int i2 = (int) ((q) this.nDt).height;
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            layoutParams2 = new RelativeLayout.LayoutParams(i, i2);
            layoutParams2.leftMargin = (int) ((q) this.nDt).nBa;
            layoutParams2.rightMargin = (int) ((q) this.nDt).nBb;
            layoutParams2.topMargin = (int) ((q) this.nDt).nAY;
            layoutParams2.bottomMargin = (int) ((q) this.nDt).nAZ;
            findViewById.setLayoutParams(layoutParams2);
        } else if (((int) ((q) this.nDt).width) > 0) {
            layoutParams2 = new RelativeLayout.LayoutParams(this.hmV, (this.hmV * ((int) ((q) this.nDt).height)) / ((int) ((q) this.nDt).width));
            findViewById.setPadding((int) ((q) this.nDt).nBa, (int) ((q) this.nDt).nAY, (int) ((q) this.nDt).nBb, (int) ((q) this.nDt).nAZ);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
        } else {
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.hmV, this.hmW));
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.hmV, this.hmW));
            findViewById.setMinimumHeight(this.hmW);
        }
        String eH = d.eH("adId", ((q) this.nDt).nAO);
        if (FileOp.cn(eH)) {
            this.nFA.NR(eH);
        } else {
            d.b("adId", ((q) this.nDt).nAO, false, 1000000001, new d.a() {
                public final void bzS() {
                }

                public final void bxo() {
                }

                public final void MX(String str) {
                    x.this.nFA.NR(str);
                }
            });
        }
        this.nEJ = (TextView) findViewById.findViewById(f.errorTv);
        this.nEJ.setText(this.context.getString(j.download_fail));
        this.gFD = findViewById.findViewById(f.sns_ad_native_landing_pages_sight_background);
        if (this.gFD != null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            parent = this.gFD.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.gFD);
            }
            ((ViewGroup) findViewById).addView(this.gFD, layoutParams);
        }
        layoutParams = new RelativeLayout.LayoutParams(this.hmV - com.tencent.mm.bp.a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.context.getResources().getDimensionPixelSize(i$d.NoPadding);
        this.nEG = new VideoPlayerSeekBar(this.context);
        this.nEG.setVisibility(4);
        if (this.nFc != null) {
            this.nFc.il(this.nEG.getVisibility() == 0);
        }
        this.nEG.setIplaySeekCallback(new 6(this));
        this.nEG.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "btn onclick view [%b] bar[%b]", new Object[]{Boolean.valueOf(x.this.nFA.isPlaying()), Boolean.valueOf(x.this.nEG.bPb)});
                x.this.nFD = true;
                if (x.this.nEG.bPb) {
                    x.this.bAf();
                    x.this.nEW = 4;
                } else {
                    if (x.this.nEO) {
                        x.this.bzy();
                    } else {
                        x.this.bzC();
                        x.this.nFK = true;
                    }
                    x.this.aBJ();
                    x.this.nEW = 3;
                    if (x.this.nzP) {
                        x.this.bzD();
                    }
                }
                x.this.nFa = x.this.nFa + 1;
            }
        });
        this.nEG.setIsPlay(this.nFA.isPlaying());
        this.nEG.seek(0);
        ((ViewGroup) findViewById).addView(this.nEG, layoutParams);
        this.nEH = (ImageView) findViewById.findViewById(f.sns_ad_native_landing_pages_sight_voice_btn);
        this.nEH.setVisibility(0);
        this.nEH.setOnClickListener(new 8(this));
        this.nEH.setPadding(0, 0, com.tencent.mm.bp.a.fromDPToPix(this.context, 8), com.tencent.mm.bp.a.fromDPToPix(this.context, 13));
        parent = this.nEH.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.nEH);
        }
        ((ViewGroup) findViewById).addView(this.nEH);
        this.nEI = (ImageView) findViewById.findViewById(f.status_btn);
        this.nEI.setImageDrawable(com.tencent.mm.bp.a.f(this.context, i.shortvideo_play_btn));
        this.nEI.setVisibility(8);
        this.nEI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.this.nFD = true;
                x.this.aBJ();
                x.this.nEP = false;
                if (!x.this.nEL) {
                    x.this.bzC();
                    x.this.nFK = true;
                    x.this.nEL = true;
                } else if (x.this.nEO) {
                    x.this.bzy();
                } else {
                    x.this.bzC();
                    x.this.nFK = true;
                }
                x.this.nEW = 3;
                x.this.nEG.setVisibility(4);
                x.this.nEH.setVisibility(0);
                x.this.gFD.setVisibility(0);
                if (x.this.nFc != null) {
                    x.this.nFc.il(true);
                }
                ah.i(new 1(this), 10000);
            }
        });
        this.nFA.setVideoCallback(new 10(this));
        this.nEG.setVisibility(4);
        this.nEH.setVisibility(8);
        this.gFD.setVisibility(4);
        if (this.nFc != null) {
            this.nFc.il(this.nEG.getVisibility() == 0);
        }
        this.nFA.setOnClickListener(new 11(this));
        this.nFB = (ProgressBar) findViewById.findViewById(f.progressbar);
        this.nFB.setVisibility(8);
        q qVar = (q) this.nDt;
        if (qVar.bID != 1 || qVar.nAQ.length() <= 0 || qVar.nAP.length() <= 0) {
            z = false;
        }
        if (z) {
            findViewById = this.contentView.findViewById(f.sns_ad_native_landing_pages_item_stream_video_click_area);
            findViewById.setVisibility(0);
            Button button = (Button) findViewById.findViewById(f.sns_ad_native_landing_pages_item_stream_video_click_area_button);
            button.setTextColor(((q) this.nDt).nAR);
            button.setText(((q) this.nDt).nAQ);
            button.setOnClickListener(new 12(this));
            findViewById.findViewById(f.sns_ad_native_landing_pages_item_stream_video_click_area_separator).setBackgroundColor(((q) this.nDt).nAS);
        }
        return this.contentView;
    }

    public final void bAi() {
        q qVar = (q) this.nDt;
        if (bi.oW(qVar.nAP)) {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click without streamVideoUrl!");
        } else if (this.context instanceof Activity) {
            com.tencent.mm.sdk.platformtools.x.v("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click, jumpto [%s]", new Object[]{qVar.nAP});
            Intent intent = new Intent();
            intent.setClass(this.context, VideoAdPlayerUI.class);
            intent.putExtra("IsAd", true);
            intent.putExtra("KMediaId", ac.ce(qVar.nAP));
            intent.putExtra("KThumUrl", qVar.nAO);
            intent.putExtra("KStremVideoUrl", qVar.nAP);
            intent.putExtra("ForceLandscape", true);
            intent.putExtra("ShareBtnHidden", 1);
            intent.putExtra("KComponentCid", bzU());
            ((Activity) this.context).startActivityForResult(intent, nFJ);
            this.nFE++;
        } else {
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.Sns.AdLandingPageSightVideoComponent", "on long video button click but context not activity!");
        }
    }

    private boolean bAj() {
        if (bi.oW(((q) this.nDt).nAm)) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", ((q) this.nDt).nBk);
        intent.putExtra("sns_landing_pages_ux_info", ((q) this.nDt).ntU);
        intent.putExtra("sns_landing_pages_xml", "");
        intent.putExtra("sns_landing_pages_canvasid", ((q) this.nDt).nAm);
        intent.putExtra("sns_landing_pages_canvas_ext", ((q) this.nDt).nAn);
        intent.putExtra("sns_landing_pages_no_store", ((q) this.nDt).nAo);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
        if ((this.context instanceof Activity) && ((q) this.nDt).nBm == 2) {
            String stringExtra = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_sessionId");
            String stringExtra2 = ((Activity) this.context).getIntent().getStringExtra("sns_landing_pages_ad_buffer");
            if (!bi.oW(stringExtra)) {
                String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("sessionId", valueOf);
                    jSONObject.put("cid", ((q) this.nDt).nAW);
                    jSONObject.put("adBuffer", !bi.oW(stringExtra2) ? stringExtra2 : "");
                    jSONObject.put("preSessionId", stringExtra);
                } catch (Exception e) {
                }
                intent.putExtra("sns_landing_pages_search_extra", jSONObject.toString());
                intent.putExtra("sns_landing_pages_sessionId", valueOf);
                intent.putExtra("sns_landing_pages_ad_buffer", stringExtra2);
            }
        }
        int[] iArr = new int[2];
        this.nFA.getLocationOnScreen(iArr);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_width", this.nFA.getWidth());
        intent.putExtra("img_gallery_height", this.nFA.getHeight());
        com.tencent.mm.bg.d.b(this.context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        return true;
    }

    private void aBJ() {
        if (this.nET) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", "last download fail ,try again");
            this.nFA.bCl();
            return;
        }
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "starting play");
        if (!(this.nFI || TextUtils.isEmpty(this.fOr))) {
            this.nFA.BK(this.fOr);
            this.nFI = true;
        }
        this.nEI.setVisibility(8);
        this.dvh.post(new 2(this));
        this.lxh = System.currentTimeMillis();
        this.nEY++;
    }

    public final void bAk() {
        if (this.nFA != null && this.nEG != null && Math.abs(this.nFA.getCurrentPosition() - this.nEG.getmPosition()) > 1) {
            this.nFA.R(this.nEG.getmPosition(), true);
        }
    }

    private void bAf() {
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "pause play");
        if (!this.nFD) {
            this.nEI.setVisibility(0);
        }
        this.dvh.post(new Runnable() {
            public final void run() {
                x.this.nFA.bCm();
                x.this.nEG.setIsPlay(false);
            }
        });
        if (this.lxh != 0) {
            this.nEX = (int) (((long) this.nEX) + (System.currentTimeMillis() - this.lxh));
            this.lxh = 0;
        }
    }

    public final void bzy() {
        super.bzy();
        this.nEH.setImageDrawable(com.tencent.mm.bp.a.f(this.context, com.tencent.mm.plugin.sns.i.e.landing_page_video_sound_off));
        this.nFA.setMute(true);
        this.nEO = true;
    }

    public final void bzC() {
        super.bzC();
        this.nEH.setImageDrawable(com.tencent.mm.bp.a.f(this.context, com.tencent.mm.plugin.sns.i.e.landing_page_video_sound_on));
        this.nFA.setMute(false);
        this.nEO = false;
    }

    public final void bzA() {
        super.bzA();
    }

    public final void bzB() {
        super.bzB();
        bAf();
        this.nFK = false;
        if (this.nEQ || this.nER) {
            this.nER = false;
            this.nEQ = false;
            if (this.nEW == 1) {
                this.nEW = 2;
            }
        }
    }

    public final void bzz() {
        super.bzz();
        this.nFA.onDestroy();
    }

    public final void W(int i, int i2, int i3) {
        super.W(i, i2, i3);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "height " + i2);
        if (i != 0 && i2 != 0) {
            this.nFG = i;
            this.iGo = i2;
            if (i < 0) {
                return;
            }
            if (((float) i) < 0.5f * ((float) i2)) {
                this.nFK = false;
                this.nER = false;
                this.nEQ = false;
                bAf();
                if (this.nEW == 1) {
                    this.nEW = 2;
                }
            } else if (!this.nEQ || this.nER) {
                this.nFK = false;
                this.nER = false;
                this.nEQ = true;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (!this.nEP || (this.nEP && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                    if (this.nFc != null) {
                        this.nFc.il(true);
                    }
                    if (this.nEG.getVideoTotalTime() > 0) {
                        this.nEG.setVisibility(4);
                        this.nEH.setVisibility(0);
                        this.gFD.setVisibility(0);
                    }
                    ah.i(new Runnable() {
                        public final void run() {
                            if (!x.this.nFH) {
                                if (x.this.nFc != null) {
                                    x.this.nFc.il(false);
                                }
                                x.this.nEG.setVisibility(4);
                                x.this.nEH.setVisibility(8);
                                x.this.gFD.setVisibility(4);
                            }
                        }
                    }, 3000);
                }
                if (this.nEP) {
                    if (activeNetworkInfo == null) {
                        this.nEI.setVisibility(0);
                        this.nFD = false;
                        this.nES = false;
                    } else {
                        this.nES = true;
                        this.nEP = false;
                    }
                }
                if (this.nEW == 0) {
                    if (activeNetworkInfo != null) {
                        if (this.nEO) {
                            bzy();
                        } else {
                            bzC();
                            this.nFK = true;
                        }
                        this.nEW = 1;
                    } else {
                        return;
                    }
                } else if (this.nEW == 2) {
                    if (this.nEO) {
                        bzy();
                    } else {
                        bzC();
                        this.nFK = true;
                    }
                    aBJ();
                    this.nEW = 1;
                    return;
                } else if (this.nEW != 3) {
                    return;
                } else {
                    if (this.nEO) {
                        bzy();
                    } else {
                        bzC();
                        this.nFK = true;
                    }
                }
                aBJ();
            }
        }
    }

    public final boolean aa(JSONObject jSONObject) {
        if (!super.aa(jSONObject)) {
            return false;
        }
        try {
            String ce;
            JSONObject jSONObject2;
            jSONObject.put("sightDuration", this.nFC * TbsLog.TBSLOG_CODE_SDK_BASE);
            jSONObject.put("playTimeInterval", this.nEX);
            jSONObject.put("playCount", this.nEY);
            jSONObject.put("playCompletedCount", this.nEZ);
            jSONObject.put("clickVoiceControlCount", this.nFb);
            jSONObject.put("isAutoPlay", this.nES ? "1" : "0");
            if (((q) this.nDt).type == 61) {
                jSONObject.put("clickSightCount", this.nFF);
            }
            if (!this.nEV) {
                ce = ac.ce(((q) this.nDt).nAN);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", ce);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("sightUrlInfo", jSONObject2);
            }
            if (!this.nEU) {
                ce = ac.ce(((q) this.nDt).nAO);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", ce);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            jSONObject.put("streamVideoEnterCount", this.nFE);
            jSONObject.put("streamVideoPlayCount", this.njo);
            jSONObject.put("streamVideoPlayCompleteCount", this.njp);
            jSONObject.put("streamVideoTotalPlayTimeInMs", this.njq);
            return true;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.Sns.AdLandingPageSightVideoComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected final void bzQ() {
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.Sns.AdLandingPageSightVideoComponent", getClass().getName() + "not support update now");
    }
}
