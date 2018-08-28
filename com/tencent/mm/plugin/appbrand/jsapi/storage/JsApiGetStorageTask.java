package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.appstorage.c.a;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

class JsApiGetStorageTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageTask> CREATOR = new 1();
    public String aAL;
    public String appId;
    public Runnable fFC;
    private boolean fZs;
    private int fZt;
    private int fZu;
    private int fZv;
    public String type;
    public String value;

    public final void aai() {
        c aaZ = e.aaZ();
        if (aaZ == null) {
            ahH();
            return;
        }
        Object[] aT = aaZ.aT(this.appId, this.aAL);
        if (((a) aT[0]) == a.fjM) {
            if (k.j(new String[]{(String) aT[1], (String) aT[2]}) > 102400) {
                this.fZu = k.j(new String[]{(String) aT[1]});
                this.fZv = k.j(new String[]{r1});
                try {
                    k.g(this.fEl, new String[]{r0, r1});
                } catch (Exception e) {
                    x.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                }
                this.fZs = true;
            } else {
                this.fZs = false;
                this.value = r0;
                this.type = r1;
            }
        }
        ahH();
    }

    public final void aaj() {
        if (this.fZs) {
            try {
                String ua = k.ua(this.fEl);
                if (ua.length() == this.fZu + this.fZv) {
                    this.value = ua.substring(0, this.fZu);
                    this.type = ua.substring(this.fZu, this.fZu + this.fZv);
                }
                k.ub(this.fEl);
            } catch (Exception e) {
                x.e("MicroMsg.JsApiGetStorageTask", e.getMessage());
                k.ub(this.fEl);
            } catch (Throwable th) {
                k.ub(this.fEl);
                throw th;
            }
        }
        if (this.fFC != null) {
            this.fFC.run();
        }
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
    }
}
