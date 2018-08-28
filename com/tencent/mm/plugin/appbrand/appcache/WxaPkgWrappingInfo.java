package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo extends ModulePkgInfo implements Parcelable {
    public static final Creator<WxaPkgWrappingInfo> CREATOR = new Creator<WxaPkgWrappingInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaPkgWrappingInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgWrappingInfo[i];
        }
    };
    public int fih;
    public int fii;
    public long fij;
    public boolean fik;
    public final LinkedList<ModulePkgInfo> fil;
    public final Map<String, String> fim;

    final void aco() {
        Iterator it = this.fil.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
            String qC = a.qC(modulePkgInfo.name);
            this.fim.put(qC, modulePkgInfo.name);
            modulePkgInfo.name = qC;
        }
    }

    public static WxaPkgWrappingInfo qX(String str) {
        if (bi.oW(str)) {
            return null;
        }
        ag agVar = new ag(new File(str));
        if (!agVar.fgX) {
            x.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[]{str});
            agVar.close();
            return null;
        } else if (agVar.abW()) {
            agVar.close();
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
            wxaPkgWrappingInfo.ffK = str;
            wxaPkgWrappingInfo.fik = false;
            wxaPkgWrappingInfo.bKg = g.cu(str);
            return wxaPkgWrappingInfo;
        } else {
            x.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", new Object[]{str});
            agVar.close();
            return null;
        }
    }

    public WxaPkgWrappingInfo() {
        this.fil = new LinkedList();
        this.fim = new HashMap();
        this.name = "__APP__";
    }

    public WxaPkgWrappingInfo(Parcel parcel) {
        this();
        readFromParcel(parcel);
    }

    public final void a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        wxaPkgWrappingInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        obtain.recycle();
    }

    public final String toString() {
        return "WxaPkgWrappingInfo{pkgDebugType=" + this.fih + ", pkgVersion=" + this.fii + ", pkgCreateTime=" + this.fij + ", localPkg=" + this.fik + ", md5='" + this.bKg + '\'' + ", pkgPath='" + this.ffK + '\'' + '}';
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.fih);
        parcel.writeInt(this.fii);
        parcel.writeLong(this.fij);
        parcel.writeByte(this.fik ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.fil);
    }

    public final void readFromParcel(Parcel parcel) {
        super.readFromParcel(parcel);
        this.fih = parcel.readInt();
        this.fii = parcel.readInt();
        this.fij = parcel.readLong();
        this.fik = parcel.readByte() != (byte) 0;
        parcel.readTypedList(this.fil, ModulePkgInfo.CREATOR);
    }
}
