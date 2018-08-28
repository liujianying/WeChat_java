package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class z extends y {
    private Context context;
    boolean djm;
    ag dvh;
    String fOr;
    View gFD;
    int iGo;
    long lxh;
    VideoPlayerSeekBar nEG;
    ImageView nEH;
    private ImageView nEI;
    private TextView nEJ;
    boolean nEL;
    boolean nEO;
    boolean nEP;
    private boolean nEQ;
    private boolean nER;
    private boolean nES;
    boolean nET;
    boolean nEU;
    boolean nEV;
    int nEW;
    int nEX;
    private int nEY;
    int nEZ;
    OfflineVideoView nFA;
    private ProgressBar nFB;
    int nFC;
    boolean nFD;
    int nFG;
    boolean nFH;
    boolean nFI;
    boolean nFK;
    int nFa;
    int nFb;
    ac nFc;

    public final int bAl() {
        if (this.nEG.getVisibility() != 0) {
            return -1;
        }
        int[] iArr = new int[2];
        this.nEG.getLocationOnScreen(iArr);
        return (this.hmW - iArr[1]) - (this.nEG.getHeight() >>> 1);
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_sight;
    }

    public final View bzM() {
        LayoutParams layoutParams;
        ViewParent parent;
        boolean z = true;
        if (!e.cn(d.eH("adId", ((w) this.nDt).nBz))) {
            this.nEU = false;
        }
        if (!e.cn(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/adId_stream_" + ac.ce(((w) this.nDt).nAP))) {
            this.nEV = false;
        }
        View findViewById = this.contentView.findViewById(f.sns_ad_native_landing_pages_item_video_container);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(f.sns_ad_native_landing_pages_item_sight_container);
        this.nFA = new OfflineVideoView(this.context);
        viewGroup.addView(this.nFA, 0, new LinearLayout.LayoutParams(-1, -1));
        int i;
        LayoutParams layoutParams2;
        if (((w) this.nDt).nBA != 1) {
            i = this.hmW;
            layoutParams2 = new RelativeLayout.LayoutParams(this.hmV, i);
            findViewById.setPadding((int) ((w) this.nDt).nBa, (int) ((w) this.nDt).nAY, (int) ((w) this.nDt).nBb, (int) ((w) this.nDt).nAZ);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
            findViewById.setMinimumHeight(i);
        } else if (((int) ((w) this.nDt).width) > 0) {
            i = (this.hmV * ((int) ((w) this.nDt).height)) / ((int) ((w) this.nDt).width);
            layoutParams2 = new RelativeLayout.LayoutParams(this.hmV, i);
            findViewById.setPadding((int) ((w) this.nDt).nBa, (int) ((w) this.nDt).nAY, (int) ((w) this.nDt).nBb, (int) ((w) this.nDt).nAZ);
            viewGroup.setLayoutParams(layoutParams2);
            findViewById.setLayoutParams(layoutParams2);
            findViewById.setMinimumHeight(i);
        } else {
            viewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.hmV, this.hmW));
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(this.hmV, this.hmW));
            findViewById.setMinimumHeight(this.hmW);
        }
        String eH = d.eH("adId", ((w) this.nDt).nBz);
        if (FileOp.cn(eH)) {
            this.nFA.NR(eH);
        } else {
            d.b("adId", ((w) this.nDt).nBz, false, 1000000001, new 3(this));
        }
        this.nEJ = (TextView) findViewById.findViewById(f.errorTv);
        this.nEJ.setText(this.context.getString(j.download_fail));
        this.gFD = findViewById.findViewById(f.sns_ad_native_landing_pages_sight_background);
        if (this.gFD != null) {
            layoutParams = new RelativeLayout.LayoutParams(this.hmV, this.hmW);
            parent = this.gFD.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.gFD);
            }
            ((ViewGroup) findViewById).addView(this.gFD, layoutParams);
        }
        layoutParams = new RelativeLayout.LayoutParams(this.hmV - a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = this.context.getResources().getDimensionPixelSize(i.d.NoPadding);
        this.nEG = new VideoPlayerSeekBar(this.context);
        this.nEG.setVisibility(4);
        if (this.nFc != null) {
            this.nFc.il(this.nEG.getVisibility() == 0);
        }
        this.nEG.setIplaySeekCallback(new b() {
            public final void ajO() {
                if (z.this.nFA != null) {
                    z.this.nFA.bCm();
                }
            }

            public final void kV(int i) {
                x.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "onSeek time " + i);
                if (z.this.nEO) {
                    z.this.bzy();
                } else {
                    z.this.bzC();
                }
                z.this.nFA.S(i, z.this.nEG.bPb);
            }
        });
        this.nEG.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "btn onclick view [%b] bar[%b]", new Object[]{Boolean.valueOf(z.this.nFA.isPlaying()), Boolean.valueOf(z.this.nEG.bPb)});
                z.this.nFD = true;
                if (z.this.nEG.bPb) {
                    z.this.bAf();
                    z.this.nEW = 4;
                } else {
                    if (z.this.nEO) {
                        z.this.bzy();
                    } else {
                        z.this.bzC();
                        z.this.nFK = true;
                    }
                    z.this.aBJ();
                    z.this.nEW = 3;
                    if (z.this.nzP) {
                        z.this.bzD();
                    }
                }
                if (z.this.nzR) {
                    z zVar = z.this;
                    zVar.nFa++;
                }
            }
        });
        this.nEG.setIsPlay(this.nFA.isPlaying());
        this.nEG.seek(0);
        ((ViewGroup) findViewById).addView(this.nEG, layoutParams);
        this.nEH = (ImageView) findViewById.findViewById(f.sns_ad_native_landing_pages_sight_voice_btn);
        this.nEH.setVisibility(0);
        this.nEH.setOnClickListener(new 6(this));
        this.nEH.setPadding(0, 0, a.fromDPToPix(this.context, 8), a.fromDPToPix(this.context, 13));
        parent = this.nEH.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.nEH);
        }
        ((ViewGroup) findViewById).addView(this.nEH);
        this.nEI = (ImageView) findViewById.findViewById(f.status_btn);
        this.nEI.setImageDrawable(a.f(this.context, i.i.shortvideo_play_btn));
        this.nEI.setVisibility(8);
        this.nEI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                z.this.nFD = true;
                z.this.aBJ();
                z.this.nEP = false;
                if (!z.this.nEL) {
                    z.this.bzC();
                    z.this.nFK = true;
                    z.this.nEL = true;
                } else if (z.this.nEO) {
                    z.this.bzy();
                } else {
                    z.this.bzC();
                    z.this.nFK = true;
                }
                z.this.nEW = 3;
                z.this.nEG.setVisibility(0);
                z.this.nEH.setVisibility(0);
                z.this.gFD.setVisibility(0);
                if (z.this.nFc != null) {
                    z.this.nFc.il(true);
                }
                ah.i(new 1(this), 10000);
            }
        });
        this.nFA.setVideoCallback(new 8(this));
        this.nEG.setVisibility(4);
        this.nEH.setVisibility(8);
        this.gFD.setVisibility(4);
        if (this.nFc != null) {
            ac acVar = this.nFc;
            if (this.nEG.getVisibility() != 0) {
                z = false;
            }
            acVar.il(z);
        }
        this.nFA.setOnClickListener(new 9(this));
        this.nFB = (ProgressBar) findViewById.findViewById(f.progressbar);
        this.nFB.setVisibility(8);
        return this.contentView;
    }

    final void aBJ() {
        if (this.nET) {
            x.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "last download fail ,try again");
            this.nFA.bCl();
            return;
        }
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "starting play");
        if (!(this.nFI || TextUtils.isEmpty(this.fOr))) {
            this.nFA.BK(this.fOr);
            this.nFI = true;
        }
        this.nEI.setVisibility(8);
        this.dvh.post(new 10(this));
        this.lxh = System.currentTimeMillis();
        this.nEY++;
    }

    final void bAf() {
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "pause play");
        if (!this.nFD) {
            this.nEI.setVisibility(0);
        }
        this.dvh.post(new 1(this));
        if (this.lxh != 0) {
            this.nEX = (int) (((long) this.nEX) + (System.currentTimeMillis() - this.lxh));
            this.lxh = 0;
        }
    }

    public final void bzy() {
        super.bzy();
        this.nEH.setImageDrawable(a.f(this.context, i.e.landing_page_video_sound_off));
        this.nFA.setMute(true);
        this.nEO = true;
    }

    public final void bzC() {
        super.bzC();
        this.nEH.setImageDrawable(a.f(this.context, i.e.landing_page_video_sound_on));
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
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "height " + i2);
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
                        this.nEG.setVisibility(0);
                        this.nEH.setVisibility(0);
                        this.gFD.setVisibility(0);
                    }
                    ah.i(new Runnable() {
                        public final void run() {
                            if (!z.this.nFH) {
                                if (z.this.nFc != null) {
                                    z.this.nFc.il(false);
                                }
                                z.this.nEG.setVisibility(4);
                                z.this.nEH.setVisibility(8);
                                z.this.gFD.setVisibility(4);
                            }
                        }
                    }, 3000);
                }
                if (this.nEP) {
                    if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                        this.nEI.setVisibility(0);
                        this.nFD = false;
                        this.nES = false;
                    } else {
                        this.nES = true;
                        this.nEP = false;
                    }
                }
                if (this.nEW == 0) {
                    if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
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
            jSONObject.put("streamVideoDuraion", this.nFC * 1000);
            jSONObject.put("playTimeInterval", this.nEX);
            jSONObject.put("playCount", this.nEY);
            jSONObject.put("playCompletedCount", this.nEZ);
            jSONObject.put("clickPlayControlCount", this.nFa);
            jSONObject.put("clickVoiceControlCount", this.nFb);
            jSONObject.put("isAutoPlay", this.nES ? "1" : "0");
            if (!this.nEU) {
                ce = ac.ce(((w) this.nDt).nBz);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", ce);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("thumbUrlInfo", jSONObject2);
            }
            if (!this.nEV) {
                ce = ac.ce(((w) this.nDt).nAP);
                jSONObject2 = new JSONObject();
                jSONObject2.put("urlMd5", ce);
                jSONObject2.put("needDownload", 1);
                jSONObject.put("streamVideoUrlInfo", jSONObject2);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", e, "", new Object[0]);
            return false;
        }
    }

    protected final void bzQ() {
        x.i("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", getClass().getName() + "not support update now");
    }
}
