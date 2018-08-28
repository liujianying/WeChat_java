package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

class JsApiOperateMusicPlayer$OperateMusicPlayer extends MainProcessTask {
    public static final Creator<JsApiOperateMusicPlayer$OperateMusicPlayer> CREATOR = new 7();
    public int action;
    public String bPS;
    public String bVc;
    public String errorMsg;
    private e fFF;
    private l fFa;
    private int fFd;
    public boolean fHX = false;
    f fIr;
    e$b fIs;
    public String fIt;
    private final c fIu = new 6(this);
    b fvX;

    public JsApiOperateMusicPlayer$OperateMusicPlayer(e eVar, l lVar, int i) {
        this.fFF = eVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiOperateMusicPlayer$OperateMusicPlayer(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        try {
            JSONObject jSONObject = new JSONObject(this.bVc);
            String optString = jSONObject.optString("operationType");
            final String optString2 = jSONObject.optString("dataUrl");
            if (bi.oW(optString)) {
                this.action = -1;
                this.fHX = true;
                this.errorMsg = "operationType is null or nil";
                ahH();
            } else if (a.ala().bE(this.bPS, optString)) {
                if (com.tencent.mm.an.b.PZ() && !com.tencent.mm.an.b.PY() && optString.equalsIgnoreCase("play")) {
                    avq Qa = com.tencent.mm.an.b.Qa();
                    if (Qa == null || !(bi.oW(optString2) || optString2.equals(Qa.rYp))) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "data url has changed ,restart play");
                    } else if (a.ala().bE(this.bPS, "resume")) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "same appid %s, change play to resume", new Object[]{this.bPS});
                        optString = "resume";
                    } else {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "not same not same appid ,restart play");
                    }
                }
                if (optString.equalsIgnoreCase("play")) {
                    final String optString3 = jSONObject.optString(FFmpegMetadataRetriever.METADATA_KEY_TITLE);
                    final String optString4 = jSONObject.optString("singer");
                    final String optString5 = jSONObject.optString("epname");
                    final String optString6 = jSONObject.optString("coverImgUrl");
                    if (bi.oW(optString2)) {
                        this.action = -1;
                        this.fHX = true;
                        this.errorMsg = "dataUrl is null or nil";
                        ahH();
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "title : %s, singer : %s, epName : %s, coverImgUrl : %s, dataUrl : %s, lowbandUrl : %s, webUrl : %s", new Object[]{optString3, optString4, optString5, optString6, optString2, optString2, optString2});
                    com.tencent.mm.an.b.PW();
                    optString = a.ala().ghU;
                    if (!bi.oW(optString)) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.bPS});
                        a.ala().tl(optString);
                    }
                    final String str = optString2;
                    final String str2 = optString2;
                    ah.i(new Runnable() {
                        public final void run() {
                            avq a = ((com.tencent.mm.an.a.b) g.l(com.tencent.mm.an.a.b.class)).a(optString6, optString6, optString3, optString4, str, str2, optString2, (JsApiOperateMusicPlayer$OperateMusicPlayer.this.bPS + optString2 + optString6).hashCode(), com.tencent.mm.compatible.util.e.bnE, com.tencent.mm.plugin.p.c.Gb() + optString6.hashCode(), optString5, "");
                            a.rYC = true;
                            com.tencent.mm.an.b.b(a);
                            a.ala().a(JsApiOperateMusicPlayer$OperateMusicPlayer.this.fIu, JsApiOperateMusicPlayer$OperateMusicPlayer.this.bPS);
                            a.ala().ghU = JsApiOperateMusicPlayer$OperateMusicPlayer.this.bPS;
                            a.ala().ghV = a.rsp;
                            x.i("MicroMsg.JsApiOperateMusicPlayer", "startPlayMusic");
                            JsApiOperateMusicPlayer$OperateMusicPlayer.this.action = -1;
                            JsApiOperateMusicPlayer$OperateMusicPlayer.this.errorMsg = "";
                            JsApiOperateMusicPlayer$OperateMusicPlayer.this.fHX = false;
                            JsApiOperateMusicPlayer$OperateMusicPlayer.this.ahH();
                        }
                    }, 500);
                } else if (optString.equalsIgnoreCase("resume")) {
                    optString = a.ala().ghU;
                    if (!bi.oW(optString)) {
                        x.i("MicroMsg.JsApiOperateMusicPlayer", "remove listener preAppid is %s, appid is %s", new Object[]{optString, this.bPS});
                        a.ala().tl(optString);
                    }
                    a.ala().a(this.fIu, this.bPS);
                    a.ala().ghU = this.bPS;
                    avq Qa2 = com.tencent.mm.an.b.Qa();
                    if (Qa2 != null) {
                        a.ala().ghV = Qa2.rsp;
                    }
                    if (com.tencent.mm.an.c.Qc()) {
                        ah.i(new 2(this), 500);
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "resume fail");
                    this.action = -1;
                    this.fHX = true;
                    this.errorMsg = "resume play fail";
                    ahH();
                } else if (optString.equalsIgnoreCase("pause")) {
                    if (com.tencent.mm.an.c.Qd()) {
                        ah.i(new 3(this), 500);
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "pause fail");
                    this.action = -1;
                    this.fHX = true;
                    this.errorMsg = "pause play fail";
                    ahH();
                } else if (optString.equalsIgnoreCase("seek")) {
                    if (com.tencent.mm.an.b.if(bi.getInt(bi.cg(jSONObject.optString("position")), -1) * 1000)) {
                        ah.i(new 4(this), 500);
                        return;
                    }
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "seek fail");
                    this.action = -1;
                    this.fHX = true;
                    this.errorMsg = "seek fail";
                    ahH();
                } else if (!optString.equalsIgnoreCase("stop")) {
                    this.action = -1;
                    this.fHX = true;
                    ahH();
                } else if (com.tencent.mm.an.c.Qe()) {
                    ah.i(new 5(this), 500);
                } else {
                    x.i("MicroMsg.JsApiOperateMusicPlayer", "stop fail");
                    this.action = -1;
                    this.fHX = false;
                    this.errorMsg = "stop play fail";
                    ahH();
                }
            } else {
                x.i("MicroMsg.JsApiOperateMusicPlayer", "appid not match cannot operate");
                this.action = -1;
                this.fHX = true;
                this.errorMsg = "appid not match cannot operate";
                ahH();
            }
        } catch (Exception e) {
            x.e("MicroMsg.JsApiOperateMusicPlayer", e.toString());
            this.action = -1;
            this.fHX = true;
            this.errorMsg = "data is null";
            ahH();
        }
    }

    public final void aaj() {
        String str;
        x.i("MicroMsg.JsApiOperateMusicPlayer", "runInClientProcess(action : %s)", new Object[]{Integer.valueOf(this.action)});
        l lVar = this.fFa;
        int i = this.fFd;
        e eVar = this.fFF;
        if (this.fHX) {
            str = "fail" + (TextUtils.isEmpty(this.errorMsg) ? "" : ":" + this.errorMsg);
        } else {
            str = "ok";
        }
        lVar.E(i, eVar.f(str, null));
        h a;
        switch (this.action) {
            case 0:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPlay in");
                a = new JsApiOperateMusicPlayer.c((byte) 0).a(this.fFa);
                a.mData = this.fIt;
                a.ahM();
                this.fvX.p("Music#isPlaying", Boolean.valueOf(true));
                AppBrandStickyBannerLogic.a.d(this.fIr);
                com.tencent.mm.plugin.appbrand.e.a(this.fFa.mAppId, this.fIs);
                return;
            case 1:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicResume in");
                this.fvX.p("Music#isPlaying", Boolean.valueOf(true));
                AppBrandStickyBannerLogic.a.d(this.fIr);
                com.tencent.mm.plugin.appbrand.e.a(this.fFa.mAppId, this.fIs);
                return;
            case 2:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicStop in");
                a = new JsApiOperateMusicPlayer.a((byte) 0).a(this.fFa);
                a.mData = this.fIt;
                a.ahM();
                break;
            case 3:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicPause in");
                a = new JsApiOperateMusicPlayer.b((byte) 0).a(this.fFa);
                a.mData = this.fIt;
                a.ahM();
                this.fvX.p("Music#isPlaying", Boolean.valueOf(false));
                AppBrandStickyBannerLogic.a.c(this.fIr);
                com.tencent.mm.plugin.appbrand.e.b(this.fFa.mAppId, this.fIs);
                return;
            case 4:
                x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicError in");
                this.fFa.j("onMusicError", this.fIt, 0);
                this.fvX.p("Music#isPlaying", Boolean.valueOf(false));
                AppBrandStickyBannerLogic.a.c(this.fIr);
                com.tencent.mm.plugin.appbrand.e.b(this.fFa.mAppId, this.fIs);
                return;
            case 7:
                break;
            default:
                return;
        }
        x.i("MicroMsg.JsApiOperateMusicPlayer", "onMusicEnd in");
        this.fvX.p("Music#isPlaying", Boolean.valueOf(false));
        AppBrandStickyBannerLogic.a.c(this.fIr);
        com.tencent.mm.plugin.appbrand.e.b(this.fFa.mAppId, this.fIs);
    }

    public final void g(Parcel parcel) {
        this.bVc = parcel.readString();
        this.bPS = parcel.readString();
        this.fHX = parcel.readByte() != (byte) 0;
        this.fIt = parcel.readString();
        this.action = parcel.readInt();
        this.errorMsg = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bVc);
        parcel.writeString(this.bPS);
        parcel.writeByte(this.fHX ? (byte) 1 : (byte) 0);
        parcel.writeString(this.fIt);
        parcel.writeInt(this.action);
        parcel.writeString(this.errorMsg);
    }
}
