package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GameSettingParams implements Parcelable {
    public static final Creator<GameSettingParams> CREATOR = new 1();
    public String bQE;
    public String bQF;

    /* synthetic */ GameSettingParams(Parcel parcel, byte b) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.bQE);
        parcel.writeString(this.bQF);
    }

    private GameSettingParams(Parcel parcel) {
        this.bQE = parcel.readString();
        this.bQF = parcel.readString();
    }
}
