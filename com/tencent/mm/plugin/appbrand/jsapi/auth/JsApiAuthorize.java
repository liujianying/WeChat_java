package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.a;
import com.tencent.mm.u.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class JsApiAuthorize extends c {
    private static final int CTRL_INDEX = 54;
    private static final String NAME = "authorize";

    private static class AuthorizeTask extends MainProcessTask {
        public static final Creator<AuthorizeTask> CREATOR = new 3();
        public String appId;
        public String data;
        public int fFd;
        private int fGJ;
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

        public AuthorizeTask(Parcel parcel) {
            g(parcel);
        }

        public final void aai() {
            1 1 = new 1(this);
            if (this.fJv.equals("authorize")) {
                try {
                    JSONArray jSONArray = new JSONArray(new JSONObject(this.data).optString("scope"));
                    LinkedList linkedList = new LinkedList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        linkedList.add(jSONArray.optString(i));
                    }
                    g.Eh().dpP.a(new a(this.appId, linkedList, this.fmv, this.fGJ, new 4(this, 1)), 0);
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiAuthorize", "Exception %s", new Object[]{e.getMessage()});
                    this.fJw = "fail";
                    ahH();
                }
            } else if (this.fJv.equals("authorizeConfirm")) {
                a(this.appId, this.fJu, this.fmv, this.fJx, 1);
            }
        }

        public final void aaj() {
            ahB();
            if (!this.fJs.isRunning()) {
                this.fJt.aia();
            } else if (this.fJw.equals("ok")) {
                this.fJr.a(this.fJs, this.fFd, "ok");
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
                        x.e("MicroMsg.JsApiAuthorize", "IOException %s", new Object[]{e.getMessage()});
                        x.printErrStackTrace("MicroMsg.JsApiAuthorize", e, "", new Object[0]);
                        this.fJr.a(this.fJs, this.fFd, "fail");
                        this.fJt.aia();
                        return;
                    }
                }
                if (linkedList.size() > 0) {
                    ah.A(new Runnable() {
                        public final void run() {
                            1 1 = new 1(this);
                            com.tencent.mm.plugin.appbrand.g runtime = AuthorizeTask.this.fJs.getRuntime();
                            c cVar = AuthorizeTask.this.fJr;
                            runtime.a(new com.tencent.mm.plugin.appbrand.widget.c.c(AuthorizeTask.this.fJs.getRuntime().fcq, linkedList, AuthorizeTask.this.mAppName, AuthorizeTask.this.fyq, 1));
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
            this.appId = parcel.readString();
            this.fJw = parcel.readString();
            this.fJv = parcel.readString();
            this.mAppName = parcel.readString();
            this.fyq = parcel.readString();
            this.fJy = parcel.readInt();
            this.fJz = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.fJu = parcel.readBundle(JsApiAuthorize.class.getClassLoader());
            this.fmv = parcel.readInt();
            this.fJx = parcel.readInt();
            this.fGJ = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.data);
            parcel.writeInt(this.fFd);
            parcel.writeString(this.appId);
            parcel.writeString(this.fJw);
            parcel.writeString(this.fJv);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.fyq);
            parcel.writeInt(this.fJy);
            parcel.writeBundle(this.fJz);
            parcel.writeBundle(this.fJu);
            parcel.writeInt(this.fmv);
            parcel.writeInt(this.fJx);
            parcel.writeInt(this.fGJ);
        }

        private void a(String str, Bundle bundle, int i, int i2, a aVar) {
            ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
            LinkedList linkedList = new LinkedList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedList.add((String) it.next());
            }
            g.Eh().dpP.a(new b(str, linkedList, i, i2, this.fGJ, new 5(this, aVar, i2)), 0);
        }
    }

    public final /* bridge */ /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        super.a(cVar, jSONObject, i);
    }

    public final void a(c cVar, JSONObject jSONObject, int i, b bVar) {
        x.d("MicroMsg.JsApiAuthorize", "stev JsApiAuthorize!");
        AuthorizeTask authorizeTask = new AuthorizeTask();
        authorizeTask.appId = cVar.getAppId();
        authorizeTask.fJv = "authorize";
        AppBrandSysConfig appBrandSysConfig = cVar.getRuntime().fcu;
        if (appBrandSysConfig != null) {
            authorizeTask.fmv = appBrandSysConfig.frm.fih;
        }
        AppBrandStatObject qb = com.tencent.mm.plugin.appbrand.a.qb(cVar.getAppId());
        if (qb != null) {
            authorizeTask.fGJ = qb.scene;
        }
        String jSONObject2 = jSONObject.toString();
        authorizeTask.fJr = this;
        authorizeTask.fJs = cVar;
        authorizeTask.data = jSONObject2;
        authorizeTask.fFd = i;
        authorizeTask.fJt = bVar;
        authorizeTask.fJz = new Bundle();
        authorizeTask.ahA();
        AppBrandMainProcessService.a(authorizeTask);
    }
}
