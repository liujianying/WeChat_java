package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.g.a.go;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.b.a;

class GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask extends GWMainProcessTask {
    public static Creator<GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask> CREATOR = new 1();
    public String bPE;
    public Runnable fFC;
    public int nc;
    public String result;

    /* synthetic */ GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        go goVar = new go();
        goVar.bPJ.nc = this.nc;
        goVar.bPJ.bPE = this.bPE;
        a.sFg.m(goVar);
        this.result = goVar.bPK.bPL;
        ahH();
    }

    public final void aaj() {
        if (this.fFC != null) {
            this.fFC.run();
        }
    }

    public final void g(Parcel parcel) {
        this.nc = parcel.readInt();
        this.bPE = parcel.readString();
        this.result = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.nc);
        parcel.writeString(this.bPE);
        parcel.writeString(this.result);
    }

    private GameJsApiOperateGameCenterMsg$OperateGameCenterMsgTask(Parcel parcel) {
        g(parcel);
    }
}
