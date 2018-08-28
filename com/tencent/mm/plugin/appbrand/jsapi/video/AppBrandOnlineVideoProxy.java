package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.f;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.b;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.c.d.c;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.x;

public final class AppBrandOnlineVideoProxy implements b {
    private OnlineVideoProxy fZS;
    private a fZT;

    private static class OnlineVideoProxy extends MainProcessTask {
        public static final Creator<OnlineVideoProxy> CREATOR = new 2();
        final int START = 1;
        final int STOP = 4;
        String elz;
        final int fZU = 0;
        final int fZV = 2;
        final int fZW = 3;
        int fZX;
        final int fZY = 10;
        final int fZZ = 11;
        final int gaa = 12;
        final int gab = 13;
        int gac;
        boolean gad = false;
        int gae;
        int gaf;
        a gag;
        c gah = new 1(this);
        int length;
        int offset;
        String path;
        String url;

        public OnlineVideoProxy(Parcel parcel) {
            g(parcel);
        }

        public final void aaj() {
            x.d("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess cdnMediaId[%s] clientState[%d] [%d %d]", new Object[]{this.elz, Integer.valueOf(this.gac), Integer.valueOf(this.gae), Integer.valueOf(this.gaf)});
            if (this.gag != null) {
                switch (this.gac) {
                    case 10:
                        this.gag.iB(this.gae);
                        break;
                    case 11:
                        this.gag.onDataAvailable(this.elz, this.gae, this.gaf);
                        break;
                    case 12:
                        this.gag.h(this.elz, this.gae, this.gaf);
                        break;
                    case 13:
                        this.gag.L(this.elz, this.gae);
                        break;
                }
                this.gac = 0;
                x.i("MicroMsg.AppBrandOnlineVideoProxy", "runInClientProcess reset clientState[%d] ", new Object[]{Integer.valueOf(this.gac)});
            }
        }

        public final void aai() {
            x.d("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess cdnMediaId[%s] state[%d]", new Object[]{this.elz, Integer.valueOf(this.fZX)});
            String str;
            int i;
            int i2;
            switch (this.fZX) {
                case 1:
                    com.tencent.mm.plugin.appbrand.c.b abl = e.abl();
                    abl.fnU.put(this.elz, this.gah);
                    abl = e.abl();
                    x.i("MicroMsg.AppbrandCdnService", "add online video task [%s] url[%s] path[%s]", new Object[]{this.elz, this.url, this.path});
                    j jVar = new j();
                    jVar.field_mediaId = r1;
                    jVar.field_fullpath = r3;
                    jVar.url = r2;
                    jVar.dQt = abl.fnV;
                    jVar.dQm = 1;
                    jVar.dQh = 3;
                    o.Tb().a(jVar, false);
                    break;
                case 2:
                    e.abl();
                    str = this.elz;
                    i = this.offset;
                    i2 = this.length;
                    x.i("MicroMsg.AppbrandCdnService", "request online video task [%s]", new Object[]{str});
                    o.Tb();
                    f.g(str, i, i2);
                    break;
                case 3:
                    e.abl();
                    str = this.elz;
                    i = this.offset;
                    i2 = this.length;
                    x.i("MicroMsg.AppbrandCdnService", "check online video task [%s]", new Object[]{str});
                    this.gad = o.Tb().isVideoDataAvailable(str, i, i2);
                    ahH();
                    return;
                case 4:
                    e.abl().rr(this.elz);
                    e.abl();
                    x.i("MicroMsg.AppbrandCdnService", "cancel online video task [%s]", new Object[]{this.elz});
                    o.Tb().k(str, null);
                    break;
                default:
                    x.w("MicroMsg.AppBrandOnlineVideoProxy", "unknow state ");
                    break;
            }
            this.fZX = 0;
            x.i("MicroMsg.AppBrandOnlineVideoProxy", "runInMainProcess reset mainState[%d] ", new Object[]{Integer.valueOf(this.fZX)});
            ahH();
        }

        public final void g(Parcel parcel) {
            boolean z = true;
            this.elz = parcel.readString();
            this.fZX = parcel.readInt();
            this.path = parcel.readString();
            this.url = parcel.readString();
            this.offset = parcel.readInt();
            this.length = parcel.readInt();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.gad = z;
            this.gac = parcel.readInt();
            this.gae = parcel.readInt();
            this.gaf = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.elz);
            parcel.writeInt(this.fZX);
            parcel.writeString(this.path);
            parcel.writeString(this.url);
            parcel.writeInt(this.offset);
            parcel.writeInt(this.length);
            parcel.writeInt(this.gad ? 1 : 0);
            parcel.writeInt(this.gac);
            parcel.writeInt(this.gae);
            parcel.writeInt(this.gaf);
        }
    }

    public final void q(String str, String str2, String str3) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s start http stream[%s, %s, %s]", new Object[]{Integer.valueOf(hashCode()), str, str2, str3});
        if (this.fZS == null) {
            this.fZS = new OnlineVideoProxy();
            this.fZS.gag = this.fZT;
            this.fZS.ahA();
        }
        MainProcessTask mainProcessTask = this.fZS;
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s OnlineVideoProxy start http stream[%s %s %s] ", new Object[]{Integer.valueOf(mainProcessTask.hashCode()), str, str2, str3});
        mainProcessTask.elz = str;
        mainProcessTask.path = str2;
        mainProcessTask.url = str3;
        mainProcessTask.fZX = 1;
        AppBrandMainProcessService.a(mainProcessTask);
    }

    public final void ny(String str) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s stop http stream[%s]", new Object[]{Integer.valueOf(hashCode()), str});
        if (this.fZS != null) {
            this.fZS.gag = null;
            MainProcessTask mainProcessTask = this.fZS;
            mainProcessTask.fZX = 4;
            AppBrandMainProcessService.a(mainProcessTask);
            this.fZS.ahB();
        }
        this.fZS = null;
    }

    public final void j(String str, int i, int i2) {
        x.i("MicroMsg.AppBrandOnlineVideoProxy", "%s requestVideoData [%s, %d %d]", new Object[]{Integer.valueOf(hashCode()), str, Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.fZS != null) {
            MainProcessTask mainProcessTask = this.fZS;
            mainProcessTask.offset = i;
            mainProcessTask.length = i2;
            mainProcessTask.fZX = 2;
            AppBrandMainProcessService.a(mainProcessTask);
        }
    }

    public final boolean isVideoDataAvailable(String str, int i, int i2) {
        if (this.fZS == null) {
            return false;
        }
        MainProcessTask mainProcessTask = this.fZS;
        mainProcessTask.offset = i;
        mainProcessTask.length = i2;
        mainProcessTask.fZX = 3;
        AppBrandMainProcessService.b(mainProcessTask);
        return mainProcessTask.gad;
    }

    public final void a(a aVar) {
        this.fZT = aVar;
        if (this.fZS != null) {
            this.fZS.gag = aVar;
        }
    }
}
