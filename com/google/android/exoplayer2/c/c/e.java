package com.google.android.exoplayer2.c.c;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.b;
import com.google.android.exoplayer2.c.c.u.c;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.plugin.wxpay.a$k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e implements c {
    private final List<Format> anf;
    private final int flags;

    public e() {
        this((byte) 0);
    }

    public e(byte b) {
        this(0, Collections.emptyList());
    }

    public e(int i, List<Format> list) {
        List list2;
        this.flags = i;
        if (!isSet(32) && list2.isEmpty()) {
            list2 = Collections.singletonList(Format.af("application/cea-608"));
        }
        this.anf = list2;
    }

    public final SparseArray<u> ka() {
        return new SparseArray();
    }

    public final u a(int i, b bVar) {
        switch (i) {
            case 2:
                return new o(new i());
            case 3:
            case 4:
                return new o(new m(bVar.aem));
            case 15:
                if (isSet(2)) {
                    return null;
                }
                return new o(new d(false, bVar.aem));
            case 21:
                return new o(new l());
            case 27:
                if (isSet(4)) {
                    return null;
                }
                return new o(new j(a(bVar), isSet(1), isSet(8)));
            case a$k.AppCompatTheme_actionModeShareDrawable /*36*/:
                return new o(new k(a(bVar)));
            case a$k.AppCompatTheme_colorSwitchThumbNormal /*89*/:
                return new o(new g(bVar.api));
            case 129:
            case 135:
                return new o(new b(bVar.aem));
            case 130:
            case 138:
                return new o(new f(bVar.aem));
            case com.tencent.mm.plugin.appbrand.jsapi.f.c.CTRL_INDEX /*134*/:
                if (isSet(16)) {
                    return null;
                }
                return new q(new s());
            default:
                return null;
        }
    }

    private r a(b bVar) {
        if (isSet(32)) {
            return new r(this.anf);
        }
        j jVar = new j(bVar.apj);
        List list = this.anf;
        while (jVar.me() > 0) {
            int readUnsignedByte = jVar.position + jVar.readUnsignedByte();
            if (jVar.readUnsignedByte() == com.tencent.mm.plugin.appbrand.jsapi.f.c.CTRL_INDEX) {
                List arrayList = new ArrayList();
                int readUnsignedByte2 = jVar.readUnsignedByte() & 31;
                for (int i = 0; i < readUnsignedByte2; i++) {
                    int i2;
                    String str;
                    String readString = jVar.readString(3);
                    int readUnsignedByte3 = jVar.readUnsignedByte();
                    if ((readUnsignedByte3 & 128) != 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        str = "application/cea-708";
                        readUnsignedByte3 &= 63;
                    } else {
                        str = "application/cea-608";
                        readUnsignedByte3 = 1;
                    }
                    arrayList.add(Format.a(null, str, 0, readString, readUnsignedByte3));
                    jVar.da(2);
                }
                list = arrayList;
            }
            jVar.setPosition(readUnsignedByte);
        }
        return new r(list);
    }

    private boolean isSet(int i) {
        return (this.flags & i) != 0;
    }
}
