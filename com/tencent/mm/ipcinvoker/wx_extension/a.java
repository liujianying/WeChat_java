package com.tencent.mm.ipcinvoker.wx_extension;

import android.os.Parcel;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.ipcinvoker.extension.a {
    public final boolean aw(Object obj) {
        return obj instanceof b;
    }

    public final void a(Object obj, Parcel parcel) {
        b bVar = (b) obj;
        c.a(bVar.dID.dIL, parcel);
        if (ad.cic()) {
            c.a(bVar.dIE.dIL, parcel);
        } else {
            parcel.writeString(bVar.dIE.dIL.getClass().getName());
        }
        parcel.writeString(bVar.uri);
        parcel.writeInt(bVar.dIF);
        parcel.writeInt(bVar.dID.cmdId);
        parcel.writeInt(bVar.dIE.cmdId);
    }

    public final Object e(Parcel parcel) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = (com.tencent.mm.bk.a) c.a(c.class.getName(), parcel);
        if (ad.cic()) {
            try {
                aVar.dIH = (com.tencent.mm.bk.a) Class.forName(parcel.readString()).newInstance();
            } catch (Exception e) {
                x.e("MicroMsg.XIPC.CommReqRespTransfer", "readFromParcel, mm process initiate resp e = %s", new Object[]{e});
                aVar.dIH = new com.tencent.mm.bk.a();
            }
        } else {
            com.tencent.mm.bk.a aVar2 = (com.tencent.mm.bk.a) c.a(c.class.getName(), parcel);
            if (aVar2 == null) {
                aVar2 = new com.tencent.mm.bk.a();
            }
            aVar.dIH = aVar2;
        }
        aVar.uri = parcel.readString();
        aVar.dIF = parcel.readInt();
        aVar.dII = parcel.readInt();
        aVar.dIJ = parcel.readInt();
        return aVar.KT();
    }
}
