package com.tencent.mm.plugin.wear.model.e;

import android.database.Cursor;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.cdr;
import com.tencent.mm.protocal.c.cdx;
import com.tencent.mm.protocal.c.cdy;
import com.tencent.mm.protocal.c.ceu;
import com.tencent.mm.protocal.c.cev;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.contact.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START));
        arrayList.add(Integer.valueOf(11009));
        return arrayList;
    }

    protected final byte[] p(int i, byte[] bArr) {
        int i2 = 5;
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START) {
            a.zC(6);
            ceu ceu = new ceu();
            try {
                ceu.aG(bArr);
                List linkedList = new LinkedList();
                linkedList.addAll(s.cyz());
                linkedList.addAll(s.cyA());
                au.HU();
                Cursor k = com.tencent.mm.model.c.FW().k(linkedList, ceu.rjC);
                if (ceu.rjC != 0) {
                    i2 = 20;
                }
                cev cev = new cev();
                cev.rjC = ceu.rjC;
                while (k != null && k.moveToNext()) {
                    String string = k.getString(k.getColumnIndex("username"));
                    au.HU();
                    ab Yg = com.tencent.mm.model.c.FR().Yg(string);
                    cev.rjC++;
                    if (!(Yg.ckW() || Yg.BA())) {
                        cdr cdr = new cdr();
                        cdr.hcS = r.c(Yg);
                        cdr.hbL = Yg.field_username;
                        cev.rHc.add(cdr);
                        if (cev.rHc.size() >= i2) {
                            cev.szb = k.moveToNext();
                            break;
                        }
                    }
                }
                x.d("MicroMsg.Wear.HttpContactServer", "request offset: %d | return offset: %d | return size: %d", new Object[]{Integer.valueOf(ceu.rjC), Integer.valueOf(cev.rjC), Integer.valueOf(cev.rHc.size())});
                if (k != null) {
                    k.close();
                }
                try {
                    return cev.toByteArray();
                } catch (IOException e) {
                    return null;
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e2, "", new Object[0]);
                return null;
            }
        } else if (i != 11009) {
            return null;
        } else {
            a.zC(7);
            cdx cdx = new cdx();
            try {
                cdx.aG(bArr);
                cdy cdy = new cdy();
                au.HU();
                Cursor dn = com.tencent.mm.model.c.FR().dn(null);
                int i3 = cdx.rjC;
                while (dn != null && dn.moveToNext()) {
                    if (i3 > 0) {
                        i3--;
                    } else {
                        String string2 = dn.getString(0);
                        au.HU();
                        ab Yg2 = com.tencent.mm.model.c.FR().Yg(string2);
                        cdr cdr2 = new cdr();
                        cdr2.hcS = r.c(Yg2);
                        cdr2.hbL = Yg2.field_username;
                        cdy.rHc.add(cdr2);
                        if (cdy.rHc.size() >= 5) {
                            cdy.szb = dn.moveToNext();
                            break;
                        }
                    }
                }
                if (dn != null) {
                    dn.close();
                }
                cdy.rjC = cdx.rjC + cdy.rHc.size();
                try {
                    return cdy.toByteArray();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e22, "", new Object[0]);
                    return null;
                }
            } catch (Throwable e222) {
                x.printErrStackTrace("MicroMsg.Wear.HttpContactServer", e222, "", new Object[0]);
                return null;
            }
        }
    }

    protected final boolean zE(int i) {
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START || i == 11009) {
            return true;
        }
        return super.zE(i);
    }

    protected final boolean zD(int i) {
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUBLISH_START || i == 11009) {
            return true;
        }
        return super.zD(i);
    }
}
