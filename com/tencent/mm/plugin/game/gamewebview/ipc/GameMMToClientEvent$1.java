package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class GameMMToClientEvent$1 implements Creator<GameMMToClientEvent> {
    GameMMToClientEvent$1() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new GameMMToClientEvent(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new GameMMToClientEvent[i];
    }
}
