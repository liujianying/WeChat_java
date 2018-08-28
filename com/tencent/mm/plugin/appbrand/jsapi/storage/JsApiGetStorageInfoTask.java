package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import java.util.ArrayList;

public class JsApiGetStorageInfoTask extends MainProcessTask {
    public static final Creator<JsApiGetStorageInfoTask> CREATOR = new 1();
    public String appId;
    public Runnable fFC;
    public ArrayList<String> fZr;
    public int limit;
    public int size;

    public final void aai() {
        c aaZ = e.aaZ();
        if (aaZ == null) {
            ahH();
            return;
        }
        Object[] rc = aaZ.rc(this.appId);
        this.fZr = (ArrayList) rc[0];
        this.size = (int) Math.ceil(((Integer) rc[1]).doubleValue() / 1000.0d);
        this.limit = (int) Math.ceil(((Integer) rc[2]).doubleValue() / 1000.0d);
        ahH();
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        this.appId = parcel.readString();
        this.fZr = parcel.createStringArrayList();
        this.size = parcel.readInt();
        this.limit = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeStringList(this.fZr);
        parcel.writeInt(this.size);
        parcel.writeInt(this.limit);
    }
}
