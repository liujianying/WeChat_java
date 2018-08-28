package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MMToClientEvent extends MainProcessTask {
    public static final Creator<MMToClientEvent> CREATOR = new 2();
    private static volatile MMToClientEvent fEs;
    private static final Set<a> fEt = new HashSet();
    public String appId;
    int bGz;
    String bNC;
    public int fEp;
    String fEq;
    Object fEr;
    public int type;

    public interface a {
        void bj(Object obj);
    }

    /* synthetic */ MMToClientEvent(Parcel parcel, byte b) {
        this(parcel);
    }

    private MMToClientEvent() {
    }

    private MMToClientEvent(Parcel parcel) {
        g(parcel);
    }

    private static MMToClientEvent ahG() {
        if (fEs == null) {
            synchronized (MMToClientEvent.class) {
                if (fEs == null) {
                    fEs = new MMToClientEvent();
                }
            }
        }
        return fEs;
    }

    public final void aai() {
        switch (this.fEp) {
            case 1:
                d.a(this);
                return;
            case 2:
                d.b(this);
                return;
            default:
                return;
        }
    }

    public static void tg(String str) {
        ahG().fEp = 1;
        ahG().appId = str;
        AppBrandMainProcessService.a(ahG());
        com.tencent.mm.plugin.appbrand.jsapi.h5_interact.a.aiR();
    }

    public static void th(String str) {
        ahG().fEp = 2;
        ahG().appId = str;
        AppBrandMainProcessService.b(ahG());
    }

    public static void a(a aVar) {
        if (aVar != null) {
            synchronized (fEt) {
                fEt.add(aVar);
            }
        }
    }

    public static void b(a aVar) {
        if (aVar != null) {
            synchronized (fEt) {
                fEt.remove(aVar);
            }
        }
    }

    public final void aaj() {
        Map hashMap;
        switch (this.fEp) {
            case 3:
                com.tencent.mm.plugin.appbrand.jsapi.y.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.y.a();
                hashMap = new HashMap();
                hashMap.put("type", Integer.valueOf(this.type));
                hashMap.put("data", this.bNC);
                aVar.aC(this.appId, 0).x(hashMap).ahM();
                return;
            case 4:
                com.tencent.mm.plugin.appbrand.jsapi.contact.d.a aVar2 = new com.tencent.mm.plugin.appbrand.jsapi.contact.d.a();
                hashMap = new HashMap();
                hashMap.put("count", Integer.valueOf(this.bGz));
                hashMap.put("data", this.bNC);
                aVar2.aC(this.appId, 0).x(hashMap).ahM();
                return;
            case 5:
                Object obj = this.fEr;
                if (obj != null) {
                    List linkedList = new LinkedList();
                    synchronized (fEt) {
                        linkedList.addAll(fEt);
                    }
                    c.Em().H(new 1(this, linkedList, obj));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void g(Parcel parcel) {
        this.fEp = parcel.readInt();
        this.appId = parcel.readString();
        this.type = parcel.readInt();
        this.bNC = parcel.readString();
        this.bGz = parcel.readInt();
        try {
            this.fEq = parcel.readString();
            if (!bi.oW(this.fEq)) {
                Class cls = Class.forName(this.fEq);
                if (cls != null) {
                    this.fEr = parcel.readParcelable(cls.getClassLoader());
                }
            }
        } catch (Exception e) {
            x.v("MicroMsg.MMToClientEvent", "unparcel custom data e %s", new Object[]{e});
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fEp);
        parcel.writeString(this.appId);
        parcel.writeInt(this.type);
        parcel.writeString(this.bNC);
        parcel.writeInt(this.bGz);
        if (!bi.oW(this.fEq) && this.fEr != null) {
            parcel.writeString(this.fEq);
            parcel.writeParcelable((Parcelable) this.fEr, i);
        }
    }
}
