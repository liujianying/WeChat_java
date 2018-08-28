package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.aq.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.ceo;
import com.tencent.mm.storage.ab;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED));
        arrayList.add(Integer.valueOf(11010));
        return arrayList;
    }

    protected final byte[] p(int i, byte[] bArr) {
        switch (i) {
            case 11010:
                ceo ceo = new ceo();
                try {
                    ceo.aG(bArr);
                } catch (IOException e) {
                }
                a.bSl().pIO.ct(ceo.szk, ceo.szw);
                break;
            case TXCStreamUploader.TXE_UPLOAD_ERROR_ALLADDRESS_FAILED /*11011*/:
                String str;
                String str2 = "";
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e2) {
                    str = str2;
                }
                au.HU();
                ab Yg = c.FR().Yg(str);
                if (s.fq(str)) {
                    au.HU();
                    Yg = c.FR().Yg(str);
                    Yg.eN(0);
                    au.HU();
                    c.FR().a(str, Yg);
                    au.HU();
                    c.FQ().b(new j(str, 0));
                } else {
                    s.n(Yg);
                }
                com.tencent.mm.plugin.wear.model.c.a.ee(4, 0);
                break;
        }
        return null;
    }
}
