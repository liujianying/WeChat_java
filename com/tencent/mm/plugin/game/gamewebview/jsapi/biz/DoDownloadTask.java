package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.gn;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class DoDownloadTask extends GWMainProcessTask {
    public static Creator<DoDownloadTask> CREATOR = new 1();
    public String appId;
    public long bGm;
    public boolean bJm;
    public String bKg;
    public String extInfo;
    public long fHs;
    public String jGC;
    public String jGD;
    public String jGE;
    public String packageName;
    public int scene;
    public int type;
    public String url;

    /* synthetic */ DoDownloadTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        boolean z = false;
        boolean z2 = true;
        x.i("MicroMsg.AddDownloadTask", "doDownloadTask, type = " + this.type);
        switch (this.type) {
            case 1:
                x.i("MicroMsg.AddDownloadTask", "addDownloadTask");
                gn gnVar = new gn();
                gnVar.bPI.url = this.url;
                gnVar.bPI.bKg = this.bKg;
                gnVar.bPI.extInfo = this.extInfo;
                gnVar.bPI.appId = this.appId;
                gnVar.bPI.scene = this.scene;
                a.sFg.m(gnVar);
                e.a aVar = new e.a();
                aVar.yQ(this.url);
                aVar.yR(this.jGD);
                aVar.cx(this.fHs);
                aVar.yS(this.jGC);
                aVar.yT(this.bKg);
                aVar.setAppId(this.appId);
                aVar.cQ(this.packageName);
                aVar.ef(true);
                aVar.ox(bi.getInt(this.jGE, 1));
                aVar.setScene(this.scene);
                this.bGm = d.aCU().a(aVar.ick);
                return;
            case 2:
                x.i("MicroMsg.AddDownloadTask", "pauseDownloadTask");
                z = d.aCU().cn(this.bGm);
                break;
            case 3:
                x.i("MicroMsg.AddDownloadTask", aq.NAME);
                com.tencent.mm.plugin.downloader.c.a cs = c.cs(this.bGm);
                if (cs != null) {
                    cs.field_scene = this.scene;
                    c.e(cs);
                }
                z = d.aCU().co(this.bGm);
                break;
            case 4:
                x.i("MicroMsg.AddDownloadTask", f.NAME);
                if (d.aCU().cl(this.bGm) <= 0) {
                    z2 = false;
                }
                this.bJm = z2;
                return;
            case 5:
                x.i("MicroMsg.AddDownloadTask", f.NAME);
                FileDownloadTaskInfo cm = d.aCU().cm(this.bGm);
                if (cm.status != -1) {
                    if (cm.status == 3) {
                        if (com.tencent.mm.a.e.cn(cm.path)) {
                            z = q.g(ad.getContext(), Uri.fromFile(new File(cm.path)));
                            break;
                        }
                    }
                    x.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, invalid status = " + cm.status);
                    break;
                }
                x.e("MicroMsg.AddDownloadTask", "installDownloadTask fail, apilevel not supported");
                break;
                break;
            default:
                return;
        }
        this.bJm = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeString(this.jGC);
        parcel.writeString(this.url);
        parcel.writeString(this.jGD);
        parcel.writeString(this.bKg);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.jGE);
        parcel.writeString(this.appId);
        parcel.writeString(this.packageName);
        parcel.writeLong(this.fHs);
        parcel.writeInt(this.scene);
        parcel.writeLong(this.bGm);
        parcel.writeByte((byte) (this.bJm ? 1 : 0));
    }

    public final void g(Parcel parcel) {
        boolean z = true;
        this.type = parcel.readInt();
        this.jGC = parcel.readString();
        this.url = parcel.readString();
        this.jGD = parcel.readString();
        this.bKg = parcel.readString();
        this.extInfo = parcel.readString();
        this.jGE = parcel.readString();
        this.appId = parcel.readString();
        this.packageName = parcel.readString();
        this.fHs = parcel.readLong();
        this.scene = parcel.readInt();
        this.bGm = parcel.readLong();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.bJm = z;
    }

    private DoDownloadTask(Parcel parcel) {
        g(parcel);
    }
}
