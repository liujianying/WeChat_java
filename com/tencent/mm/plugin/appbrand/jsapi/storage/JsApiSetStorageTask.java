package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiSetStorageTask extends MainProcessTask {
    public static final Creator<JsApiSetStorageTask> CREATOR = new 1();
    private String aAL;
    public String appId;
    public Runnable fFC;
    private boolean fZs;
    private int fZt;
    private int fZu;
    private int fZv;
    public String result;
    private String type;
    private String value;

    JsApiSetStorageTask() {
    }

    public final void E(String str, String str2, String str3) {
        if (k.j(new String[]{str, str2, str3}) > 102400) {
            this.fZt = k.j(new String[]{str});
            this.fZu = k.j(new String[]{str2});
            this.fZv = k.j(new String[]{str3});
            try {
                k.g(this.fEl, new String[]{str, str2, str3});
            } catch (Exception e) {
                x.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
            }
            this.fZs = true;
            return;
        }
        this.fZs = false;
        this.aAL = str;
        this.value = str2;
        this.type = str3;
    }

    private void ajD() {
        this.aAL = null;
        this.value = null;
        this.type = null;
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void aai() {
        if (this.fZs) {
            try {
                String ua = k.ua(this.fEl);
                if (ua.length() == (this.fZt + this.fZu) + this.fZv) {
                    this.aAL = ua.substring(0, this.fZt);
                    this.value = ua.substring(this.fZt, this.fZt + this.fZu);
                    this.type = ua.substring(this.fZt + this.fZu, (this.fZt + this.fZu) + this.fZv);
                }
                k.ub(this.fEl);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiSetStorageTask", e.getMessage());
                k.ub(this.fEl);
            } catch (Throwable th) {
                k.ub(this.fEl);
                throw th;
            }
        }
        c aaZ = e.aaZ();
        if (aaZ == null) {
            this.result = "fail";
            ajD();
            ahH();
            return;
        }
        a f = aaZ.f(this.appId, this.aAL, this.value, this.type);
        if (f == a.fjM) {
            this.result = "ok";
        } else if (f == a.fjQ) {
            this.result = "fail:quota reached";
        } else {
            this.result = "fail";
        }
        ajD();
        ahH();
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.fZs = parcel.readByte() != (byte) 0;
        this.fZt = parcel.readInt();
        this.fZu = parcel.readInt();
        this.fZv = parcel.readInt();
        this.aAL = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
        this.result = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByte(this.fZs ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.fZt);
        parcel.writeInt(this.fZu);
        parcel.writeInt(this.fZv);
        parcel.writeString(this.aAL);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
        parcel.writeString(this.result);
    }
}
