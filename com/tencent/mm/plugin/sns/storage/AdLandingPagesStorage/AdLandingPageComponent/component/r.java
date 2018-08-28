package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.AdLandingVideoWrapper;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class r extends y implements b, h.b {
    private Context context;
    private ag dvh;
    private ProgressBar eIB;
    private View gFD;
    ImageView jBN;
    private long lxh = 0;
    AdLandingVideoWrapper nEF;
    VideoPlayerSeekBar nEG;
    private ImageView nEH;
    private ImageView nEI;
    private TextView nEJ;
    private Runnable nEK;
    boolean nEL = false;
    boolean nEM = false;
    boolean nEN = false;
    boolean nEO = true;
    boolean nEP = true;
    private boolean nEQ = false;
    private boolean nER = true;
    private boolean nES = false;
    private boolean nET = false;
    private boolean nEU = false;
    private boolean nEV = false;
    int nEW = 0;
    private int nEX = 0;
    private int nEY = 0;
    private int nEZ = 0;
    int nFa = 0;
    int nFb = 0;
    private ac nFc = null;
    private OnClickListener nFd = new 5(this);
    private OnClickListener nFe = new 6(this);
    private OnClickListener nFf = new 7(this);
    private OnClickListener nFg = new 8(this);

    public r(Context context, w wVar, ViewGroup viewGroup) {
        super(context, wVar, viewGroup);
        this.context = context;
        this.dvh = new ag(Looper.getMainLooper());
        this.nEK = new 1(this);
        this.nFc = new 3(this, context);
    }

    protected final int getLayout() {
        return g.sns_ad_native_landing_pages_item_new_stream;
    }

    public final View bzM() {
        String eH;
        LayoutParams layoutParams;
        View findViewById = this.contentView.findViewById(f.content_root);
        findViewById.setBackgroundColor(-16777216);
        int i = this.hmV;
        int i2 = this.hmW;
        if (((w) this.nDt).nBA == 1) {
            if (((int) ((w) this.nDt).width) > 0) {
                i2 = (i * ((int) ((w) this.nDt).height)) / ((int) ((w) this.nDt).width);
            }
            findViewById.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
            findViewById.setMinimumHeight(i2);
            this.nEF = (AdLandingVideoWrapper) findViewById.findViewById(f.video_view);
            this.nEF.setIMMVideoViewCallback(this);
            this.nEF.setOnClickListener(this.nFg);
            this.nEF.c(false, ((w) this.nDt).nAP, 0);
            this.nEF.setIsShowBasicControls(true);
            this.eIB = (ProgressBar) findViewById.findViewById(f.progressbar);
            this.jBN = (ImageView) findViewById.findViewById(f.thumb_iv);
            eH = d.eH("adId", ((w) this.nDt).nBz);
            if (!e.cn(eH)) {
                this.nEU = false;
            }
            if (this.nEU) {
                d.b("adId", ((w) this.nDt).nBz, false, 1000000001, new 4(this));
            } else {
                this.jBN.setImageBitmap(MMBitmapFactory.decodeFile(eH));
            }
            this.nEJ = (TextView) findViewById.findViewById(f.errorTv);
            this.nEJ.setText(this.context.getString(j.download_fail));
            this.gFD = findViewById.findViewById(f.sns_ad_native_landing_pages_sight_background);
            this.gFD.setVisibility(4);
            this.nEG = new VideoPlayerSeekBar(this.context);
            this.nEG.setVisibility(4);
            if (this.nFc != null) {
                this.nFc.il(this.nEG.getVisibility() == 0);
            }
            this.nEG.setIplaySeekCallback(this);
            this.nEG.setOnPlayButtonClickListener(this.nFd);
            layoutParams = new RelativeLayout.LayoutParams(i - a.fromDPToPix(this.context, 30), -2);
            layoutParams.addRule(12);
            this.nEG.setLayoutParams(layoutParams);
            this.nEF.setVideoFooterView(this.nEG);
            this.nEH = (ImageView) findViewById.findViewById(f.sns_ad_native_landing_pages_sight_voice_btn);
            this.nEH.setVisibility(4);
            this.nEH.setOnClickListener(this.nFe);
            this.nEH.setPadding(0, 0, a.fromDPToPix(this.context, 8), 0);
            this.nEI = (ImageView) findViewById.findViewById(f.status_btn);
            this.nEI.setImageDrawable(a.f(this.context, i.shortvideo_play_btn));
            this.nEI.setVisibility(8);
            this.nEI.setOnClickListener(this.nFf);
            ((ViewGroup) this.nEG.getParent()).removeView(this.nEG);
            layoutParams.bottomMargin = 0;
            ((ViewGroup) findViewById).addView(this.nEG, layoutParams);
            return this.contentView;
        }
        findViewById.setPadding((int) ((w) this.nDt).nBa, (int) ((w) this.nDt).nAY, (int) ((w) this.nDt).nBb, (int) ((w) this.nDt).nAZ);
        findViewById.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
        findViewById.setMinimumHeight(i2);
        this.nEF = (AdLandingVideoWrapper) findViewById.findViewById(f.video_view);
        this.nEF.setIMMVideoViewCallback(this);
        this.nEF.setOnClickListener(this.nFg);
        this.nEF.c(false, ((w) this.nDt).nAP, 0);
        this.nEF.setIsShowBasicControls(true);
        this.eIB = (ProgressBar) findViewById.findViewById(f.progressbar);
        this.jBN = (ImageView) findViewById.findViewById(f.thumb_iv);
        eH = d.eH("adId", ((w) this.nDt).nBz);
        if (e.cn(eH)) {
            this.nEU = false;
        }
        if (this.nEU) {
            d.b("adId", ((w) this.nDt).nBz, false, 1000000001, new 4(this));
        } else {
            this.jBN.setImageBitmap(MMBitmapFactory.decodeFile(eH));
        }
        this.nEJ = (TextView) findViewById.findViewById(f.errorTv);
        this.nEJ.setText(this.context.getString(j.download_fail));
        this.gFD = findViewById.findViewById(f.sns_ad_native_landing_pages_sight_background);
        this.gFD.setVisibility(4);
        this.nEG = new VideoPlayerSeekBar(this.context);
        this.nEG.setVisibility(4);
        if (this.nFc != null) {
            this.nFc.il(this.nEG.getVisibility() == 0);
        }
        this.nEG.setIplaySeekCallback(this);
        this.nEG.setOnPlayButtonClickListener(this.nFd);
        layoutParams = new RelativeLayout.LayoutParams(i - a.fromDPToPix(this.context, 30), -2);
        layoutParams.addRule(12);
        this.nEG.setLayoutParams(layoutParams);
        this.nEF.setVideoFooterView(this.nEG);
        this.nEH = (ImageView) findViewById.findViewById(f.sns_ad_native_landing_pages_sight_voice_btn);
        this.nEH.setVisibility(4);
        this.nEH.setOnClickListener(this.nFe);
        this.nEH.setPadding(0, 0, a.fromDPToPix(this.context, 8), 0);
        this.nEI = (ImageView) findViewById.findViewById(f.status_btn);
        this.nEI.setImageDrawable(a.f(this.context, i.shortvideo_play_btn));
        this.nEI.setVisibility(8);
        this.nEI.setOnClickListener(this.nFf);
        ((ViewGroup) this.nEG.getParent()).removeView(this.nEG);
        layoutParams.bottomMargin = 0;
        ((ViewGroup) findViewById).addView(this.nEG, layoutParams);
        return this.contentView;
    }

    protected final void bzQ() {
    }

    private void aBJ() {
        x.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "starting play");
        if (this.nET) {
            x.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "last download fail ,try again");
            this.nEF.c(false, ((w) this.nDt).nAP, 0);
            wP(0);
            return;
        }
        this.dvh.post(new 9(this));
        this.lxh = System.currentTimeMillis();
        this.nEY++;
    }

    final void bAf() {
        x.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "pause play");
        this.dvh.post(new 10(this));
        if (this.lxh != 0) {
            this.nEX = (int) (((long) this.nEX) + (System.currentTimeMillis() - this.lxh));
            this.lxh = 0;
        }
    }

    final void ik(boolean z) {
        if (z) {
            this.nEG.setVisibility(0);
            this.nEH.setVisibility(0);
            this.gFD.setVisibility(0);
            if (this.nFc != null) {
                this.nFc.il(true);
            }
            this.dvh.postDelayed(this.nEK, 5000);
            return;
        }
        this.nEG.setVisibility(4);
        this.nEH.setVisibility(8);
        this.gFD.setVisibility(4);
        if (this.nFc != null) {
            this.nFc.il(false);
        }
        this.dvh.removeCallbacks(this.nEK);
    }

    final void wP(int i) {
        if (this.nEF != null) {
            this.nEI.setVisibility(8);
            if (this.jBN.getVisibility() == 0) {
                this.eIB.setVisibility(0);
            }
            this.nEF.x(i, true);
        }
    }

    public final void bzy() {
        super.bzy();
        this.nEH.setImageDrawable(a.f(this.context, com.tencent.mm.plugin.sns.i.e.landing_page_video_sound_off));
        this.nEF.setMute(true);
        this.nEO = true;
    }

    public final void bzC() {
        super.bzC();
        this.nEH.setImageDrawable(a.f(this.context, com.tencent.mm.plugin.sns.i.e.landing_page_video_sound_on));
        this.nEF.setMute(false);
        this.nEO = false;
    }

    public final void bzA() {
        super.bzA();
    }

    public final void bzB() {
        super.bzB();
        bAf();
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
        this.nEF.ajZ();
    }

    public final void W(int i, int i2, int i3) {
        super.W(i, i2, i3);
        x.d("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "height " + i2);
        if (i != 0 && i2 != 0 && i >= 0) {
            if (((float) i) < 0.5f * ((float) i2)) {
                this.nER = false;
                this.nEQ = false;
                bAf();
                if (this.nEW == 1) {
                    this.nEW = 2;
                }
            } else if (!this.nEQ || this.nER) {
                this.nER = false;
                this.nEQ = true;
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) ad.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
                if (!this.nEP || (this.nEP && activeNetworkInfo != null && activeNetworkInfo.getType() == 1)) {
                    ik(true);
                    ah.i(new 2(this), 3000);
                }
                if (this.nEP) {
                    if (activeNetworkInfo == null || !(activeNetworkInfo == null || activeNetworkInfo.getType() == 1)) {
                        this.nEI.setVisibility(0);
                        this.nES = false;
                        this.nEP = false;
                        return;
                    }
                    this.nES = true;
                    this.nEP = false;
                }
                if (this.nEW == 0) {
                    if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                        if (this.nEO) {
                            bzy();
                        } else {
                            bzC();
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
            jSONObject.put("streamVideoDuraion", this.nEF.getVideoDurationSec() * 1000);
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
            x.printErrStackTrace("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", e, "", new Object[0]);
            return false;
        }
    }

    public final void ajO() {
        if (this.nEF != null) {
            this.nEF.SL();
        }
        this.nEN = true;
    }

    public final void kV(int i) {
        x.i("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "onSeek time " + i);
        if (this.nEO) {
            bzy();
        } else {
            bzD();
            bzC();
        }
        wP(i);
    }

    public final void bu(String str, String str2) {
        this.nET = false;
    }

    public final void bv(String str, String str2) {
        this.nEZ++;
        ik(true);
        if (this.lxh != 0) {
            this.nEX = (int) (((long) this.nEX) + (System.currentTimeMillis() - this.lxh));
            this.lxh = 0;
        }
        this.nEW = 5;
        this.nEF.SL();
    }

    public final void bw(String str, String str2) {
    }

    public final void bx(String str, String str2) {
        if (this.jBN.getVisibility() == 0) {
            this.jBN.setVisibility(8);
            this.eIB.setVisibility(8);
        }
    }

    public final void d(String str, String str2, int i, int i2) {
    }

    public final void d(String str, String str2, String str3, int i, int i2) {
        x.e("MicroMsg.Sns.AdLandingPageNewStreamVideoComponent", "online play error, %s", str3);
        this.nET = true;
    }

    public final void by(String str, String str2) {
    }

    public final void bz(String str, String str2) {
    }
}
