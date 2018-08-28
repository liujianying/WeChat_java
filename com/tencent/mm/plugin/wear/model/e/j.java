package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.bk.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.cek;
import com.tencent.mm.protocal.c.cel;
import com.tencent.mm.protocal.c.cep;
import com.tencent.mm.protocal.c.ceq;
import com.tencent.mm.protocal.c.ces;
import com.tencent.mm.protocal.c.cet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class j extends a {
    public String pJU = "";

    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11019));
        arrayList.add(Integer.valueOf(11020));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN));
        arrayList.add(Integer.valueOf(11031));
        return arrayList;
    }

    protected final byte[] p(int i, byte[] bArr) {
        boolean z = true;
        switch (i) {
            case 11019:
                List M;
                boolean z2;
                cek cek = new cek();
                try {
                    cek.aG(bArr);
                } catch (IOException e) {
                }
                cel cel = new cel();
                cel.szt = cek.szt;
                if (cel.szt) {
                    au.HU();
                    M = c.FT().M(cek.rdS, cek.see);
                } else {
                    au.HU();
                    M = c.FT().L(cek.rdS, cek.see);
                }
                int i2 = 0;
                while (i2 < 10 && i2 < M.size()) {
                    cel.rLq.add(h.aa((bd) M.get(i2)));
                    i2++;
                }
                if (M.size() > 10) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                cel.szb = z2;
                try {
                    return cel.toByteArray();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e2, "", new Object[0]);
                    break;
                }
            case 11020:
                a.ee(9, 0);
                a.zC(8);
                cep cep = new cep();
                try {
                    cep.aG(bArr);
                    this.pJU = cep.rdS;
                    ceq ceq = new ceq();
                    au.HU();
                    List L = c.FT().L(cep.rdS, cep.see);
                    int i3 = 0;
                    while (i3 < 10 && i3 < L.size()) {
                        ceq.rLq.add(h.aa((bd) L.get(i3)));
                        i3++;
                    }
                    if (L.size() <= 10) {
                        z = false;
                    }
                    ceq.szb = z;
                    try {
                        return ceq.toByteArray();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.Wear.HttpMessageServer", e22, "", new Object[0]);
                        break;
                    }
                } catch (IOException e3) {
                    return null;
                }
                break;
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
                this.pJU = "";
                break;
            case 11031:
                a.ee(12, 0);
                a.zC(14);
                ces ces = new ces();
                try {
                    ces.aG(bArr);
                } catch (IOException e4) {
                }
                au.HU();
                bd dW = c.FT().dW(ces.szl);
                cet cet = new cet();
                String fullPath = q.getFullPath(dW.field_imgPath);
                cet.szE = o.d(fullPath, 0, true);
                cet.szl = ces.szl;
                cet.rdU = new b(FileOp.e(fullPath, 0, -1));
                q.H(dW);
                try {
                    return cet.toByteArray();
                } catch (IOException e5) {
                    return null;
                }
        }
        return null;
    }

    protected final boolean zE(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
            case 11031:
                return false;
            default:
                return true;
        }
    }

    protected final boolean zD(int i) {
        switch (i) {
            case TXCStreamUploader.TXE_UPLOAD_INFO_ROOM_IN /*11021*/:
            case 11031:
                return false;
            default:
                return true;
        }
    }
}
