package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class JsApiOperateWXData$OperateWXDataTask extends MainProcessTask {
    public static final Creator<JsApiOperateWXData$OperateWXDataTask> CREATOR = new 3();
    public String appId;
    public int fFd;
    int fGJ;
    public String fJG;
    public String fJH;
    public String fJI;
    c fJr;
    c fJs;
    b fJt;
    public String fJv;
    public String fJw;
    public int fJx;
    public int fJy;
    public Bundle fJz;
    public int fmv;
    public String fyq;
    public String mAppName;

    public JsApiOperateWXData$OperateWXDataTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        1 1 = new 1(this);
        if (this.fJv.equals("operateWXData")) {
            a(this.appId, this.fJG, "", this.fmv, this.fJx, 1);
        } else if (this.fJv.equals("operateWXDataConfirm")) {
            a(this.appId, this.fJG, this.fJI, this.fmv, this.fJx, 1);
        }
    }

    public final void aaj() {
        ahB();
        if (!this.fJs.isRunning()) {
            this.fJt.aia();
        } else if (this.fJw.equals("ok")) {
            Map hashMap = new HashMap();
            hashMap.put("data", this.fJH);
            this.fJs.E(this.fFd, this.fJr.f("ok", hashMap));
            this.fJt.aia();
        } else if (this.fJw.contains("fail")) {
            this.fJr.a(this.fJs, this.fFd, this.fJw);
            this.fJt.aia();
        } else if (this.fJw.equals("needConfirm")) {
            LinkedList linkedList = new LinkedList();
            int i = 0;
            while (i < this.fJy) {
                byte[] byteArray = this.fJz.getByteArray(String.valueOf(i));
                bio bio = new bio();
                try {
                    bio.aG(byteArray);
                    linkedList.add(bio);
                    i++;
                } catch (Throwable e) {
                    x.e("MicroMsg.JsApiOperateWXData", "IOException %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.JsApiOperateWXData", e, "", new Object[0]);
                    this.fJr.a(this.fJs, this.fFd, "fail");
                    this.fJt.aia();
                    return;
                }
            }
            if (linkedList.size() > 0) {
                ah.A(new 2(this, linkedList));
                return;
            }
            this.fJr.a(this.fJs, this.fFd, "fail");
            this.fJt.aia();
        }
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.fJw = parcel.readString();
        this.mAppName = parcel.readString();
        this.fyq = parcel.readString();
        this.fJG = parcel.readString();
        this.fJH = parcel.readString();
        this.fFd = parcel.readInt();
        this.fJv = parcel.readString();
        this.fJI = parcel.readString();
        this.fJy = parcel.readInt();
        this.fJz = parcel.readBundle(JsApiOperateWXData.class.getClassLoader());
        this.fmv = parcel.readInt();
        this.fJx = parcel.readInt();
        this.fGJ = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fJw);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.fyq);
        parcel.writeString(this.fJG);
        parcel.writeString(this.fJH);
        parcel.writeInt(this.fFd);
        parcel.writeString(this.fJv);
        parcel.writeString(this.fJI);
        parcel.writeInt(this.fJy);
        parcel.writeBundle(this.fJz);
        parcel.writeInt(this.fmv);
        parcel.writeInt(this.fJx);
        parcel.writeInt(this.fGJ);
    }

    private void a(String str, String str2, String str3, int i, int i2, a aVar) {
        g.Eh().dpP.a(new com.tencent.mm.plugin.appbrand.j.c(str, str2, str3, i, i2, this.fGJ, new 4(this, aVar, i2)), 0);
    }
}
