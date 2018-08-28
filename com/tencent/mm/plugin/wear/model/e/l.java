package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.bk.b;
import com.tencent.mm.g.a.to;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.c.cer;
import com.tencent.mm.protocal.c.cfc;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class l extends a {
    public final List<Integer> bSy() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11032));
        arrayList.add(Integer.valueOf(11034));
        return arrayList;
    }

    protected final boolean zD(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }

    protected final byte[] p(int i, byte[] bArr) {
        switch (i) {
            case 11032:
                cer cer = new cer();
                if (g.AT().getInt("WearPayBlock", 0) == 0) {
                    a.ee(13, 0);
                    a.zC(15);
                    to toVar = new to();
                    toVar.cfd.action = 3;
                    com.tencent.mm.sdk.b.a.sFg.m(toVar);
                    switch (toVar.cfe.cff) {
                        case 1:
                            cer.spd = 0;
                            cer.syk = "";
                            cer.szA = new b(toVar.cfe.cfk);
                            cer.szB = new b(toVar.cfe.cfl);
                            cer.szC = toVar.cfe.cfm;
                            cer.szD = toVar.cfe.cfn;
                            break;
                        case 2:
                            cer.spd = 196611;
                            cer.syk = ad.getContext().getString(R.l.wear_get_pay_code_fail);
                            break;
                        case 3:
                            cer.spd = 196609;
                            cer.syk = ad.getContext().getString(R.l.wear_get_pay_code_bank_fail);
                            break;
                        case 4:
                            cer.spd = 196610;
                            cer.syk = ad.getContext().getString(R.l.wear_get_pay_code_pwd_fail);
                            break;
                        case 5:
                            cer.spd = 196612;
                            cer.syk = ad.getContext().getString(R.l.wear_get_pay_code_gesture_pwd_fail);
                            break;
                    }
                }
                cer.spd = 16777215;
                cer.syk = ad.getContext().getString(R.l.wear_get_pay_code_not_support);
                try {
                    return cer.toByteArray();
                } catch (IOException e) {
                    break;
                }
            case 11034:
                cfc cfc = new cfc();
                try {
                    cfc.aG(bArr);
                } catch (IOException e2) {
                }
                d.A(ad.getContext(), cfc.szH, cfc.szI);
                break;
        }
        return new byte[0];
    }

    public final boolean zF(int i) {
        switch (i) {
            case 11032:
                return true;
            default:
                return false;
        }
    }
}
