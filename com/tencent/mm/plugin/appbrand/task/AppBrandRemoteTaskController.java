package com.tencent.mm.plugin.appbrand.task;

import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Process;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.task.e.a;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public class AppBrandRemoteTaskController extends MainProcessTask {
    public static final Creator<AppBrandRemoteTaskController> CREATOR = new 2();
    private static long gtv;
    public b fda = null;
    public c fdp = null;
    public String fex;
    public int gfg;
    public long gtr;
    public int gts = a.gty;
    public int gtt;
    public long gtu;
    public String mAppId;

    public interface c {
        void b(AppBrandRemoteTaskController appBrandRemoteTaskController);

        void finish();
    }

    public final void aM(String str, int i) {
        this.gts = a.gtz;
        this.mAppId = str;
        this.gfg = i;
        AppBrandMainProcessService.a(this);
    }

    final void vy(String str) {
        this.gts = a.gtB;
        this.mAppId = str;
        ane();
        ahH();
    }

    public final void aai() {
        switch (3.gtx[this.gts - 1]) {
            case 1:
                and();
                synchronized (AppBrandRemoteTaskController.class) {
                    if (gtv == 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        gtv = currentTimeMillis;
                        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "pref_appbrand_process", 4).edit();
                        edit.putLong("on_wxa_process_connected_time", currentTimeMillis);
                        edit.commit();
                        x.v("MicroMsg.AppBrandReporter", "update timestamp(%s)", new Object[]{Long.valueOf(currentTimeMillis)});
                    }
                    this.gtu = gtv;
                }
                ahH();
                return;
            case 2:
                and();
                return;
            case 3:
                ane();
                return;
            case 4:
                e.lE(this.gtt);
                return;
            case 5:
                e.vz(this.mAppId);
                return;
            case 6:
                e.ang();
                return;
            default:
                return;
        }
    }

    private void and() {
        f a;
        if (this.fex.endsWith(".AppBrandEmbedUI")) {
            a = e.a(new a() {
                public final boolean a(f fVar) {
                    return (fVar instanceof a) && ((a) fVar).gtc == AppBrandRemoteTaskController.this.gtr;
                }
            });
            if (a == null) {
                a = new a(this.gtr);
            }
        } else {
            a = e.vC(this.fex);
            if (a == null) {
                return;
            }
        }
        a.a(this.mAppId, this.gfg, this);
        e.b(a);
    }

    private void ane() {
        if (e.bK(this.mAppId, this.fex) != null) {
            e.vu(this.mAppId);
        }
    }

    public final void aaj() {
        switch (3.gtx[this.gts - 1]) {
            case 3:
                this.fda.finish();
                return;
            case 7:
                switch (this.gtt) {
                    case 0:
                        b.ji(ad.getProcessName());
                        this.fdp.finish();
                        Process.killProcess(Process.myPid());
                        return;
                    case 1:
                        this.fdp.b(this);
                        return;
                    default:
                        return;
                }
            case 8:
                Assert.assertTrue("AppBrand Test Assert", false);
                return;
            case 9:
                l.onNetworkChange();
                return;
            default:
                return;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppId);
        parcel.writeInt(this.gfg);
        parcel.writeString(this.fex);
        parcel.writeLong(this.gtr);
        parcel.writeInt(this.gts == 0 ? -1 : this.gts - 1);
        parcel.writeInt(this.gtt);
        parcel.writeLong(this.gtu);
    }

    public final void g(Parcel parcel) {
        this.mAppId = parcel.readString();
        this.gfg = parcel.readInt();
        this.fex = parcel.readString();
        this.gtr = parcel.readLong();
        int readInt = parcel.readInt();
        this.gts = readInt == -1 ? 0 : a.anf()[readInt];
        this.gtt = parcel.readInt();
        this.gtu = parcel.readLong();
    }
}
