package com.tencent.mm.plugin.game.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.v;
import com.tencent.mm.ab.v.a;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessTask;

final class WepkgRunCgi$RemoteCgiTask extends WepkgMainProcessTask implements a {
    public static final Creator<WepkgRunCgi$RemoteCgiTask> CREATOR = new 1();
    private String fGO;
    private int isA;
    private int isM;
    public int kgu = 0;
    private b kgv;
    public b kgw;
    public WepkgRunCgi.a kgx;

    public final void aai() {
        v.a(this.kgw, this, true);
    }

    public final int a(int i, int i2, String str, b bVar, l lVar) {
        this.isM = i;
        this.isA = i2;
        this.fGO = str;
        this.kgv = bVar;
        this.kgu = 2;
        En();
        return 0;
    }

    public final void aaj() {
        d.az(this);
        if (this.kgx != null) {
            this.kgx.a(this.isM, this.isA, this.fGO, this.kgv);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.kgu);
        switch (this.kgu) {
            case 1:
                WepkgRunCgi.a(this.kgw, parcel);
                return;
            case 2:
                parcel.writeInt(this.isM);
                parcel.writeInt(this.isA);
                parcel.writeString(this.fGO);
                WepkgRunCgi.a(this.kgv, parcel);
                return;
            default:
                return;
        }
    }

    public final void g(Parcel parcel) {
        super.g(parcel);
        this.kgu = parcel.readInt();
        switch (this.kgu) {
            case 1:
                this.kgw = WepkgRunCgi.l(parcel);
                return;
            case 2:
                this.isM = parcel.readInt();
                this.isA = parcel.readInt();
                this.fGO = parcel.readString();
                this.kgv = WepkgRunCgi.l(parcel);
                return;
            default:
                return;
        }
    }

    WepkgRunCgi$RemoteCgiTask(Parcel parcel) {
        g(parcel);
    }
}
