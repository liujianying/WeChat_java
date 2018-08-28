package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wallet_core.model.o.7;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class o$7$1 implements Runnable {
    final /* synthetic */ Map pqK;
    final /* synthetic */ 7 pqL;

    o$7$1(7 7, Map map) {
        this.pqL = 7;
        this.pqK = map;
    }

    public final void run() {
        Throwable e;
        Throwable th;
        Cursor cursor = null;
        try {
            String str;
            String str2;
            Cursor cursor2;
            String str3 = (String) this.pqK.get(".sysmsg.paymsg.fromusername");
            String str4 = (String) this.pqK.get(".sysmsg.paymsg.tousername");
            String str5 = (String) this.pqK.get(".sysmsg.paymsg.paymsgid");
            String decode = URLDecoder.decode((String) this.pqK.get(".sysmsg.paymsg.appmsgcontent"), "UTF-8");
            if (bi.oW(str3) || str3.equals(q.GF())) {
                str = str4;
            } else {
                str = str3;
            }
            if (s.fq(str3)) {
                str2 = str3;
            } else if (s.fq(str4)) {
                str2 = str4;
            } else {
                str2 = str;
            }
            x.i("MicroMsg.SubCoreWalletCore", "username: %s, fromUsername: %s, toUsername: %s, talker: %s, payMsgId: %s", q.GF(), str3, str4, str2, str5);
            a gp = a.gp(decode);
            x.i("MicroMsg.SubCoreWalletCore", "appMsgContent: %s, appMsg: %s", decode, gp);
            List<bd> arrayList = new ArrayList();
            if (gp != null) {
                Cursor Hf = ((i) g.l(i.class)).bcY().Hf(str2);
                if (Hf != null) {
                    while (Hf.moveToNext()) {
                        try {
                            cm bdVar = new bd();
                            bdVar.d(Hf);
                            a gp2 = a.gp(bdVar.field_content);
                            if (!(gp2 == null || bi.oW(gp2.dye) || !gp2.dye.equals(gp.dye))) {
                                x.i("MicroMsg.SubCoreWalletCore", "update find msg id: %s, talker: %s, sender: %s", Long.valueOf(bdVar.field_msgId), bdVar.field_talker, Integer.valueOf(bdVar.field_isSend));
                                if (s.fq(bdVar.field_talker)) {
                                    bdVar.setContent(com.tencent.mm.model.bd.U(decode, com.tencent.mm.model.bd.iB(bdVar.field_content)));
                                } else {
                                    bdVar.setContent(decode);
                                }
                                arrayList.add(bdVar);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            cursor = Hf;
                        } catch (Throwable e3) {
                            th = e3;
                            cursor = Hf;
                        }
                    }
                }
                cursor2 = Hf;
            } else {
                cursor2 = null;
            }
            if (cursor2 != null) {
                try {
                    cursor2.close();
                    cursor2 = null;
                } catch (Exception e4) {
                    cursor = cursor2;
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            cursor = cursor2;
            x.i("MicroMsg.SubCoreWalletCore", "updateMsg: %s", arrayList);
            if (arrayList.size() > 0) {
                for (bd bdVar2 : arrayList) {
                    x.i("MicroMsg.SubCoreWalletCore", "do update msg: %s %s", Long.valueOf(bdVar2.field_msgId), bdVar2.field_content);
                    ((i) g.l(i.class)).bcY().a(bdVar2.field_msgId, bdVar2);
                }
            }
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        } catch (Exception e5) {
            e3 = e5;
        }
        try {
            x.printErrStackTrace("MicroMsg.SubCoreWalletCore", e3, "parse c2c content update msg error", e3.getMessage());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e32) {
            th = e32;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
