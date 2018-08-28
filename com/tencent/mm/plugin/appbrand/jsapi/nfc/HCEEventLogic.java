package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.d;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.sdk.platformtools.x;

public class HCEEventLogic {
    private static String fWo = null;
    private static b fWp = null;
    private static b fWq = new 1();

    public static final class HCEMMToAppBrandMessageEvent implements Parcelable {
        public static final Creator<HCEMMToAppBrandMessageEvent> CREATOR = new 1();
        private String appId;
        private int fWs;
        private Bundle fWt;

        /* synthetic */ HCEMMToAppBrandMessageEvent(int i, String str, Bundle bundle, byte b) {
            this(i, str, bundle);
        }

        private HCEMMToAppBrandMessageEvent(int i, String str, Bundle bundle) {
            this.fWs = i;
            this.appId = str;
            this.fWt = bundle;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.fWs);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.fWt);
        }

        HCEMMToAppBrandMessageEvent(Parcel parcel) {
            this.fWs = parcel.readInt();
            this.appId = parcel.readString();
            this.fWt = parcel.readBundle();
        }
    }

    private static class SendHCEEventToMMTask extends MainProcessTask {
        public static final Creator<SendHCEEventToMMTask> CREATOR = new Creator<SendHCEEventToMMTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendHCEEventToMMTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendHCEEventToMMTask[i];
            }
        };
        private String appId;
        private int fWs;
        private Bundle fWt;

        /* synthetic */ SendHCEEventToMMTask(String str, int i, Bundle bundle, byte b) {
            this(str, i, bundle);
        }

        private SendHCEEventToMMTask(String str, int i, Bundle bundle) {
            this.fWs = i;
            this.appId = str;
            this.fWt = bundle;
        }

        protected SendHCEEventToMMTask(Parcel parcel) {
            g(parcel);
        }

        public final void aai() {
            ib ibVar = new ib();
            ibVar.bRC.type = this.fWs;
            ibVar.bRC.appId = this.appId;
            ibVar.bRC.extras = this.fWt;
            com.tencent.mm.sdk.b.a.sFg.m(ibVar);
            ahH();
        }

        public final void aaj() {
            super.aaj();
            c.az(this);
        }

        public int describeContents() {
            return 0;
        }

        public final void g(Parcel parcel) {
            super.g(parcel);
            this.fWs = parcel.readInt();
            this.appId = parcel.readString();
            this.fWt = parcel.readBundle();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fWs);
            parcel.writeString(this.appId);
            parcel.writeBundle(this.fWt);
        }
    }

    public static final class a {
        private static boolean fWr = false;

        public static synchronized void ajt() {
            synchronized (a.class) {
                if (!fWr) {
                    MMToClientEvent.a(new 1());
                    fWr = true;
                }
            }
        }
    }

    static /* synthetic */ void l(String str, int i, String str2) {
        b bVar;
        synchronized (HCEEventLogic.class) {
            bVar = fWp;
        }
        if (bVar != null) {
            bVar.m(str, i, str2);
        }
    }

    public static void tT(String str) {
        if (!(fWo == null || fWq == null)) {
            x.i("MicroMsg.HCEEventLogic", "alvinluo remove HCELifeCycleListener before add, appId: %s", new Object[]{fWo});
            e.b(fWo, fWq);
        }
        fWo = str;
        e.a(str, fWq);
    }

    public static void tU(String str) {
        if (str != null) {
            e.b(str, fWq);
        }
    }

    public static void a(b bVar) {
        synchronized (HCEEventLogic.class) {
            fWp = bVar;
        }
    }

    public static void b(String str, int i, Bundle bundle) {
        x.i("MicroMsg.HCEEventLogic", "alvinluo HCE EVENT mm to AppBrand, type: %d, appId: %s", new Object[]{Integer.valueOf(i), str});
        d.c(new HCEMMToAppBrandMessageEvent(i, str, bundle, (byte) 0));
    }

    public static void c(String str, int i, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        x.i("MicroMsg.HCEEventLogic", "alvinluo HCEEventLogic sendHCEEventToMM appId: %s, eventType: %d", new Object[]{str, Integer.valueOf(i)});
        SendHCEEventToMMTask sendHCEEventToMMTask = new SendHCEEventToMMTask(str, i, bundle, (byte) 0);
        c.br(sendHCEEventToMMTask);
        AppBrandMainProcessService.a(sendHCEEventToMMTask);
    }
}
