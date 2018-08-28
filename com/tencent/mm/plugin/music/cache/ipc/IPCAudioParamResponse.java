package com.tencent.mm.plugin.music.cache.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.an.f;

public class IPCAudioParamResponse implements Parcelable {
    public static final Creator<IPCAudioParamResponse> CREATOR = new Creator<IPCAudioParamResponse>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IPCAudioParamResponse(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCAudioParamResponse[i];
        }
    };
    public String fileName;
    public byte[] lxI;
    public String lxJ;
    public int lxK;
    public String lxx;
    public String musicUrl;

    public IPCAudioParamResponse(f fVar) {
        this.lxx = fVar.field_musicId;
        this.musicUrl = fVar.field_musicUrl;
        this.fileName = fVar.field_fileName;
        this.lxK = fVar.field_fileCacheComplete;
        this.lxJ = fVar.field_pieceFileMIMEType;
        this.lxI = fVar.field_indexBitData;
    }

    public IPCAudioParamResponse(Parcel parcel) {
        this.lxx = parcel.readString();
        this.musicUrl = parcel.readString();
        this.fileName = parcel.readString();
        this.lxJ = parcel.readString();
        this.lxK = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.lxI = new byte[readInt];
            parcel.readByteArray(this.lxI);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.lxx);
        parcel.writeString(this.musicUrl);
        parcel.writeString(this.fileName);
        parcel.writeString(this.lxJ);
        parcel.writeInt(this.lxK);
        if (this.lxI != null) {
            parcel.writeInt(this.lxI.length);
            parcel.writeByteArray(this.lxI);
            return;
        }
        parcel.writeInt(0);
    }
}
