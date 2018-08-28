package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.jt;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask extends MainProcessTask {
    public static final Creator<JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask> CREATOR = new Creator<JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask[i];
        }
    };
    public int action;
    public String appId;
    public String bKC;
    public String bPg;
    public int bPh;
    private e fFF;
    public l fFa;
    public int fFd;
    private boolean fIU = false;
    f fIr;
    b fIs;
    public String fIt;
    private final c fIu = new 2(this);
    u$b fvX;

    public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(a aVar, l lVar, int i) {
        this.fFF = aVar;
        this.fFa = lVar;
        this.fFd = i;
    }

    public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
        if (this.fIU) {
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
            this.fIU = false;
            jt jtVar = new jt();
            jtVar.bTE.action = 10;
            jtVar.bTE.state = "preempted";
            jtVar.bTE.appId = this.appId;
            jtVar.bTE.bTG = true;
            com.tencent.mm.sdk.b.a.sFg.m(jtVar);
        }
        String str = com.tencent.mm.plugin.appbrand.media.music.a.a.ala().ghU;
        if (!bi.oW(str)) {
            x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[]{str, this.appId});
            com.tencent.mm.plugin.appbrand.media.music.a.a.ala().tl(str);
        }
        com.tencent.mm.plugin.appbrand.media.music.a.a.ala().a(this.fIu, this.appId);
        com.tencent.mm.plugin.appbrand.media.music.a ala = com.tencent.mm.plugin.appbrand.media.music.a.a.ala();
        String str2 = this.appId;
        int i = this.bPh;
        String str3 = this.bKC;
        String str4 = this.bPg;
        ala.ghU = str2;
        ala.bPh = i;
        ala.bKC = str3;
        ala.bPg = str4;
    }

    public final void aaj() {
        if (this.fFa == null) {
            x.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
            return;
        }
        switch (this.action) {
            case 0:
            case 1:
                this.fvX.p("setBackgroundAudioState#isPlaying", Boolean.valueOf(true));
                AppBrandStickyBannerLogic.a.d(this.fIr);
                com.tencent.mm.plugin.appbrand.e.a(this.appId, this.fIs);
                AppBrandMusicClientService.ghS.ghT = this.appId;
                if (JsApiSetBackgroundAudioState.fIS > 0) {
                    JsApiSetBackgroundAudioState.fIS--;
                    this.fFa.fdO.aav();
                }
                if (JsApiSetBackgroundAudioState.fIS == 0) {
                    JsApiSetBackgroundAudioState.fIS++;
                    this.fFa.fdO.aau();
                    break;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 7:
                this.fvX.p("setBackgroundAudioState#isPlaying", Boolean.valueOf(false));
                AppBrandStickyBannerLogic.a.c(this.fIr);
                com.tencent.mm.plugin.appbrand.e.b(this.appId, this.fIs);
                if (JsApiSetBackgroundAudioState.fIS > 0) {
                    JsApiSetBackgroundAudioState.fIS--;
                    this.fFa.fdO.aav();
                }
                AppBrandMusicClientService.ghS.lf(this.action);
                break;
            case 10:
                AppBrandMusicClientService.ghS.lf(this.action);
                break;
            case 13:
                JsApiOperateBackgroundAudio.b.c(this.fFa);
                return;
            case 14:
                JsApiOperateBackgroundAudio.a.c(this.fFa);
                return;
        }
        x.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s, lockCount:%d", new Object[]{Integer.valueOf(this.action), this.fIt, Integer.valueOf(JsApiSetBackgroundAudioState.fIS)});
        h a = new JsApiOperateBackgroundAudio.c().a(this.fFa);
        a.mData = this.fIt;
        a.ahM();
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.fIt = parcel.readString();
        this.action = parcel.readInt();
        this.bPh = parcel.readInt();
        this.bKC = parcel.readString();
        this.bPg = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.fIU = z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fIt);
        parcel.writeInt(this.action);
        parcel.writeInt(this.bPh);
        parcel.writeString(this.bKC);
        parcel.writeString(this.bPg);
        parcel.writeInt(this.fIU ? 1 : 0);
    }
}
