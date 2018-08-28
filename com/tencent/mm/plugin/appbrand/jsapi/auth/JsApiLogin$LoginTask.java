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
import com.tencent.mm.u.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class JsApiLogin$LoginTask extends MainProcessTask {
    public static final Creator<JsApiLogin$LoginTask> CREATOR = new Creator<JsApiLogin$LoginTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new JsApiLogin$LoginTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new JsApiLogin$LoginTask[i];
        }
    };
    public String appId;
    public String code;
    public String data;
    public int eLS;
    public int fFd;
    public int fGJ;
    public String fHN;
    c fJr;
    c fJs;
    b fJt;
    public Bundle fJu;
    public String fJv;
    public String fJw;
    public int fJx;
    public int fJy;
    public Bundle fJz;
    public int fmv;
    public String fyq;
    public String mAppName;

    public JsApiLogin$LoginTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        1 1 = new 1(this);
        if (this.fJv.equals("login")) {
            x.i("MicroMsg.JsApiLogin", "start login");
            LinkedList linkedList = new LinkedList();
            this.eLS = 1;
            this.fHN = "";
            g.Eh().dpP.a(new com.tencent.mm.u.a.c(this.appId, linkedList, this.eLS, "", this.fHN, this.fmv, this.fGJ, new 4(this, 1)), 0);
        } else if (this.fJv.equals("loginConfirm")) {
            x.i("MicroMsg.JsApiLogin", "start loginConfirm");
            a(this.appId, this.fJu, this.eLS, this.fHN, this.fmv, this.fJx, 1);
        }
    }

    public final void aaj() {
        ahB();
        if (!this.fJs.isRunning()) {
            this.fJt.aia();
        } else if (this.fJw.equals("ok")) {
            Map hashMap = new HashMap();
            hashMap.put("code", this.code);
            this.fJs.E(this.fFd, this.fJr.f("ok", hashMap));
            this.fJt.aia();
        } else if (this.fJw.equals("fail")) {
            this.fJr.a(this.fJs, this.fFd, "fail");
            this.fJt.aia();
        } else if (this.fJw.equals("needConfirm")) {
            final LinkedList linkedList = new LinkedList();
            int i = 0;
            while (i < this.fJy) {
                byte[] byteArray = this.fJz.getByteArray(String.valueOf(i));
                bio bio = new bio();
                try {
                    bio.aG(byteArray);
                    linkedList.add(bio);
                    i++;
                } catch (Throwable e) {
                    x.e("MicroMsg.JsApiLogin", "parse scope info error %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.JsApiLogin", e, "", new Object[0]);
                    this.fJr.a(this.fJs, this.fFd, "fail");
                    this.fJt.aia();
                    return;
                }
            }
            if (linkedList.size() > 0) {
                ah.A(new Runnable() {
                    public final void run() {
                        1 1 = new 1(this);
                        com.tencent.mm.plugin.appbrand.g runtime = JsApiLogin$LoginTask.this.fJs.getRuntime();
                        c cVar = JsApiLogin$LoginTask.this.fJr;
                        runtime.a(new com.tencent.mm.plugin.appbrand.widget.c.c(JsApiLogin$LoginTask.this.fJs.getRuntime().fcq, linkedList, JsApiLogin$LoginTask.this.mAppName, JsApiLogin$LoginTask.this.fyq, 1));
                    }
                });
                return;
            }
            this.fJr.a(this.fJs, this.fFd, "fail");
            this.fJt.aia();
        }
    }

    public final void g(Parcel parcel) {
        this.data = parcel.readString();
        this.fFd = parcel.readInt();
        this.fJv = parcel.readString();
        this.appId = parcel.readString();
        this.code = parcel.readString();
        this.fJw = parcel.readString();
        this.fHN = parcel.readString();
        this.eLS = parcel.readInt();
        this.mAppName = parcel.readString();
        this.fyq = parcel.readString();
        this.fJy = parcel.readInt();
        this.fJz = parcel.readBundle(JsApiLogin.class.getClassLoader());
        this.fJu = parcel.readBundle(JsApiLogin.class.getClassLoader());
        this.fmv = parcel.readInt();
        this.fJx = parcel.readInt();
        this.fGJ = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.data);
        parcel.writeInt(this.fFd);
        parcel.writeString(this.fJv);
        parcel.writeString(this.appId);
        parcel.writeString(this.code);
        parcel.writeString(this.fJw);
        parcel.writeString(this.fHN);
        parcel.writeInt(this.eLS);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.fyq);
        parcel.writeInt(this.fJy);
        parcel.writeBundle(this.fJz);
        parcel.writeBundle(this.fJu);
        parcel.writeInt(this.fmv);
        parcel.writeInt(this.fJx);
        parcel.writeInt(this.fGJ);
    }

    private void a(String str, Bundle bundle, int i, String str2, int i2, int i3, a aVar) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
        LinkedList linkedList = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            linkedList.add((String) it.next());
        }
        g.Eh().dpP.a(new d(str, linkedList, i, str2, i2, i3, this.fGJ, new 5(this, aVar, i3)), 0);
    }
}
