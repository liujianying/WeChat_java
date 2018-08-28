package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class QueryDownloadInfoTask extends GWMainProcessTask {
    public static Creator<QueryDownloadInfoTask> CREATOR = new Creator<QueryDownloadInfoTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new QueryDownloadInfoTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QueryDownloadInfoTask[i];
        }
    };
    public long bGm;
    public ArrayList<FileDownloadTaskInfo> ixN;
    public ArrayList<String> jHC;
    public int type;

    /* synthetic */ QueryDownloadInfoTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        x.i("MicroMsg.QueryDownloadInfoTask", "QueryDownloadInfoTask");
        switch (this.type) {
            case 1:
                FileDownloadTaskInfo cm = d.aCU().cm(this.bGm);
                this.ixN = new ArrayList();
                this.ixN.add(cm);
                return;
            case 2:
                if (this.jHC == null || this.jHC.size() == 0) {
                    x.i("MicroMsg.QueryDownloadInfoTask", "appIdList is null");
                    return;
                }
                d.aCU();
                this.ixN = d.n(this.jHC);
                return;
            default:
                return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.bGm);
        parcel.writeList(this.jHC);
        parcel.writeList(this.ixN);
    }

    public final void g(Parcel parcel) {
        this.type = parcel.readInt();
        this.bGm = parcel.readLong();
        this.jHC = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
        this.ixN = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
    }

    private QueryDownloadInfoTask(Parcel parcel) {
        g(parcel);
    }
}
