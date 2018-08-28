package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.protocal.c.apc;
import com.tencent.mm.protocal.c.chf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class JsApiRefreshSession$RefreshSessionTask extends MainProcessTask {
    public static final Creator<JsApiRefreshSession$RefreshSessionTask> CREATOR = new 2();
    String appId;
    l fFa;
    int fFd;
    e fFe;
    private int fGG;
    private int fGH;
    private int fGI;
    int fGJ;
    private int fmv;

    public JsApiRefreshSession$RefreshSessionTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        ahA();
        a aVar = new a();
        aVar.dIG = new apb();
        aVar.dIH = new apc();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-refreshsession";
        aVar.dIF = 1196;
        aVar.dII = 0;
        aVar.dIJ = 0;
        apb apb = new apb();
        apb.jQb = this.appId;
        apb.rRb = this.fmv;
        aVar.dIG = apb;
        if (this.fGJ > 0) {
            apb.rRc = new chf();
            apb.rRc.scene = this.fGJ;
        }
        x.i("MicroMsg.JsApiRefreshSession", "refreshSession appId %s, versionType, statScene %d", new Object[]{this.appId, Integer.valueOf(this.fmv), Integer.valueOf(this.fGJ)});
        v.a(aVar.KT(), new 1(this), true);
    }

    public final void aaj() {
        Map hashMap = new HashMap();
        switch (this.fGI) {
            case 1:
                hashMap.put("expireIn", this.fGG);
                hashMap.put("errCode", this.fGH);
                this.fFa.E(this.fFd, this.fFe.f("ok", hashMap));
                break;
            case 2:
                hashMap.put("errCode", this.fGH);
                this.fFa.E(this.fFd, this.fFe.f("fail", hashMap));
                break;
            default:
                hashMap.put("errCode", "-1");
                this.fFa.E(this.fFd, this.fFe.f("fail", hashMap));
                break;
        }
        ahB();
    }

    public final void g(Parcel parcel) {
        this.fGG = parcel.readInt();
        this.fGH = parcel.readInt();
        this.fGI = parcel.readInt();
        this.fFd = parcel.readInt();
        this.appId = parcel.readString();
        this.fmv = parcel.readInt();
        this.fGJ = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fGG);
        parcel.writeInt(this.fGH);
        parcel.writeInt(this.fGI);
        parcel.writeInt(this.fFd);
        parcel.writeString(this.appId);
        parcel.writeInt(this.fmv);
        parcel.writeInt(this.fGJ);
    }
}
