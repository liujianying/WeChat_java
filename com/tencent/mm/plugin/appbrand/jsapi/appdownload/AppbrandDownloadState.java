package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

public class AppbrandDownloadState implements Parcelable {
    public static final Creator<AppbrandDownloadState> CREATOR = new Creator<AppbrandDownloadState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppbrandDownloadState(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppbrandDownloadState[i];
        }
    };
    public String appId;
    public long bGm;
    public long bSP;
    public long fHs;
    public String state;

    /* synthetic */ AppbrandDownloadState(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.state);
        parcel.writeLong(this.bGm);
        parcel.writeString(this.appId);
        parcel.writeLong(this.bSP);
        parcel.writeLong(this.fHs);
    }

    private AppbrandDownloadState(Parcel parcel) {
        this.state = parcel.readString();
        this.bGm = parcel.readLong();
        this.appId = parcel.readString();
        this.bSP = parcel.readLong();
        this.fHs = parcel.readLong();
    }

    public final JSONObject ahS() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadInfoColumns.STATE, this.state);
            jSONObject.put("downloadId", this.bGm);
            jSONObject.put("appId", this.appId);
            jSONObject.put("progress", this.bSP);
            jSONObject.put("taskSize", this.fHs);
        } catch (JSONException e) {
            x.e("MicroMsg.AppbrandDownloadState", "toJsonObject: " + e.getMessage());
        }
        return jSONObject;
    }
}
