package com.tencent.mm.plugin.game.wepkg.utils;

import android.os.Parcel;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class WepkgRunCgi {
    static /* synthetic */ void a(b bVar, Parcel parcel) {
        parcel.writeString(bVar.dID.dIL.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = bVar.dID.dIL.toByteArray();
        } catch (Exception e) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.dIE.dIL.getClass().getName());
        bArr = new byte[0];
        try {
            bArr = bVar.dIE.dIL.toByteArray();
        } catch (Exception e2) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.dIF);
        parcel.writeInt(bVar.dID.cmdId);
        parcel.writeInt(bVar.dIE.cmdId);
    }

    static b l(Parcel parcel) {
        a aVar = new a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.dIG = ((com.tencent.mm.bk.a) Class.forName(readString).newInstance()).aG(bArr);
        } catch (Exception e) {
        }
        String readString2 = parcel.readString();
        byte[] bArr2 = new byte[parcel.readInt()];
        parcel.readByteArray(bArr2);
        try {
            aVar.dIH = ((com.tencent.mm.bk.a) Class.forName(readString2).newInstance()).aG(bArr2);
        } catch (Exception e2) {
            if (e2 instanceof f.a.a.b) {
                try {
                    aVar.dIH = (com.tencent.mm.bk.a) Class.forName(readString2).newInstance();
                } catch (Throwable e3) {
                    x.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", new Object[]{bi.i(e3)});
                }
            }
        }
        aVar.uri = parcel.readString();
        aVar.dIF = parcel.readInt();
        aVar.dII = parcel.readInt();
        aVar.dIJ = parcel.readInt();
        return aVar.KT();
    }
}
