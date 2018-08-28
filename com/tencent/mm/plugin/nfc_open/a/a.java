package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<j> {
    public a() {
        this.sFo = j.class.getName().hashCode();
    }

    private static boolean a(j jVar) {
        if ((jVar instanceof j) && jVar.bGo != null) {
            int i = jVar.bGo.actionCode;
            Context context = jVar.bGo.context;
            Bundle bundle = new Bundle();
            String str;
            switch (i) {
                case 4001:
                    bundle.putInt("status", com.tencent.mm.plugin.nfc.c.a.a.bjr().dW(context));
                    break;
                case 4002:
                    bundle.putInt("status", com.tencent.mm.plugin.nfc.c.a.a.bjr().dX(context));
                    break;
                case 4003:
                    str = jVar.bGo.bGq;
                    if (!bi.oW(str)) {
                        try {
                            bundle.putString("result", com.tencent.mm.plugin.nfc.c.a.a.bjr().a(new com.tencent.mm.plugin.nfc.a.a(str)).toString());
                            break;
                        } catch (Throwable e) {
                            x.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                            x.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e, "", new Object[0]);
                            bundle.putString("result", null);
                            break;
                        }
                    }
                    x.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                    break;
                case 4004:
                    try {
                        str = jVar.bGo.bGq;
                        boolean z = jVar.bGo.bGr;
                        boolean z2 = jVar.bGo.bGs;
                        if (bi.oW(str)) {
                            x.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                            break;
                        }
                        String[] split = str.split("\\|");
                        List<com.tencent.mm.plugin.nfc.c.a> arrayList = new ArrayList();
                        for (String str2 : split) {
                            if (bi.oW(str2)) {
                                x.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
                            } else {
                                String[] split2 = str2.split(":");
                                if (split2 == null || split2.length < 2) {
                                    x.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
                                } else {
                                    int i2 = bi.getInt(split2[0], 0);
                                    arrayList.add(new com.tencent.mm.plugin.nfc.c.a(i2, String.valueOf(i2), new com.tencent.mm.plugin.nfc.a.a(split2[1])));
                                }
                            }
                        }
                        com.tencent.mm.plugin.nfc.c.a.a.bjr().a(arrayList, z, z2);
                        StringBuilder stringBuilder = new StringBuilder();
                        for (com.tencent.mm.plugin.nfc.c.a aVar : arrayList) {
                            if (aVar.lFf == null) {
                                bundle.putString("result", stringBuilder.toString());
                                break;
                            }
                            stringBuilder.append(aVar.id);
                            stringBuilder.append(":");
                            stringBuilder.append(aVar.lFf.toString());
                            stringBuilder.append("|");
                        }
                        bundle.putString("result", stringBuilder.toString());
                    } catch (Throwable e2) {
                        x.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                        x.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e2, "", new Object[0]);
                        bundle.putString("result", null);
                        break;
                    }
                    break;
                case 4005:
                    bundle.putString("id", com.tencent.mm.plugin.nfc.d.a.byteArrayToHexString(com.tencent.mm.plugin.nfc.c.a.a.bjr().lFh));
                    break;
                case 4008:
                    bundle.putString("info", com.tencent.mm.plugin.nfc.c.a.a.bjr().getInfo());
                    break;
            }
            jVar.bGp.bGt = bundle;
        }
        return false;
    }
}
