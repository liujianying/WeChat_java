package com.tencent.mm.plugin.report.service;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

class BroadCastData implements Parcelable {
    public static final Creator<BroadCastData> CREATOR = new Creator<BroadCastData>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BroadCastData(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BroadCastData[i];
        }
    };
    ArrayList<KVReportDataInfo> mDV = new ArrayList();
    ArrayList<StIDKeyDataInfo> mDW = new ArrayList();
    ArrayList<GroupIDKeyDataInfo> mDX = new ArrayList();

    public BroadCastData(BroadCastData broadCastData) {
        if (broadCastData != null) {
            this.mDV = new ArrayList(broadCastData.mDV);
            this.mDW = new ArrayList(broadCastData.mDW);
            this.mDX = new ArrayList(broadCastData.mDX);
        }
    }

    protected BroadCastData(Parcel parcel) {
        parcel.readTypedList(this.mDV, KVReportDataInfo.CREATOR);
        parcel.readTypedList(this.mDW, StIDKeyDataInfo.CREATOR);
        parcel.readTypedList(this.mDX, GroupIDKeyDataInfo.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.mDV);
        parcel.writeTypedList(this.mDW);
        parcel.writeTypedList(this.mDX);
    }
}
