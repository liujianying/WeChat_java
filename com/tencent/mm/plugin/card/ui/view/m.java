package com.tencent.mm.plugin.card.ui.view;

import android.database.Cursor;
import com.tencent.mm.plugin.card.b.g;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public final class m extends g {
    public final boolean h(b bVar) {
        if (this.htQ == null) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            return true;
        } else if (bVar == null) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            return false;
        } else if (this.htQ.awn().rnr != bVar.awn().rnr) {
            x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain is_commom_card is different！");
            return true;
        } else {
            pr prVar = this.htQ.awn().rnq;
            pr prVar2 = bVar.awn().rnq;
            if ((prVar == null && prVar2 != null) || (prVar != null && prVar2 == null)) {
                x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field is different！");
                return true;
            } else if (prVar == null || prVar2 == null || prVar.title == null || prVar2.title == null || !prVar.title.equals(prVar2.title)) {
                prVar = this.htQ.awm().rok;
                prVar2 = bVar.awm().rok;
                if ((prVar == null && prVar2 != null) || (prVar != null && prVar2 == null)) {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    return true;
                } else if (prVar != null && prVar2 != null && prVar.title != null && prVar2.title != null && !prVar.title.equals(prVar2.title)) {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    return true;
                } else if (prVar == null || prVar2 == null || prVar.huY == null || prVar2.huY == null || prVar.huY.equals(prVar2.huY)) {
                    return false;
                } else {
                    x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    return true;
                }
            } else {
                x.i("MicroMsg.CarDynamicCodeView", "isNeedUpdateViewAgain unavailable_qrcode_field title is different！");
                return true;
            }
        }
    }

    public final String e(c cVar) {
        x.i("MicroMsg.CarDynamicCodeView", "code from dynamic offline");
        g axy = am.axy();
        b bVar = this.htQ;
        String str = "";
        if (bVar == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! cardInfo is null");
            return str;
        }
        int i;
        axy.awD();
        axy.htX = cVar;
        String awq = bVar.awq();
        Cursor rawQuery = am.axw().diF.rawQuery("select count(1) from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{awq});
        if (rawQuery != null) {
            rawQuery.moveToFirst();
            i = rawQuery.getInt(0);
            rawQuery.close();
        } else {
            i = 0;
        }
        if (i == 0) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！db is empty!");
            i = 0;
        } else {
            i xn = am.axx().xn(awq);
            if (xn != null) {
                if (g.a(xn)) {
                    axy.htX = c.hIw;
                    i = 0;
                } else if (i < xn.field_lower_bound && l.isNetworkAvailable(ad.getContext())) {
                    x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ currentCodeSize < lower_bound,currentCodeSize =%d,lower_bound=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(xn.field_lower_bound)});
                    axy.htX = c.hIC;
                    i = 0;
                }
            }
            i = 1;
        }
        if (i == 0) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "can not getFrom db！ request doNetSceneGetDynamicQrcode!");
            axy.a(bVar, q.hIS);
            return "";
        }
        k xp = am.axw().xp(bVar.awq());
        if (xp == null) {
            x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get code is failure! db is  empty! doNetSceneGetDynamicQrcode! cardId= %s", new Object[]{bVar.awq()});
            axy.a(bVar, q.hIS);
            return "";
        }
        k xq = am.axw().xq(awq);
        if (xq != null && am.axw().ca(awq, xq.field_code_id)) {
            axy.a(awq, xq.field_code_id, cVar);
        }
        axy.htY = 0;
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "update current code showing! newQrCodeData cardId= %s,codeId=%s，refreshReason=%d", new Object[]{awq, xp.field_code_id, Integer.valueOf(cVar.action)});
        awq = bVar.awq();
        if (xp == null) {
            str = "";
        } else {
            str = e.cg(awq, xp.field_code);
            i xn2 = am.axx().xn(awq);
            if (xn2 == null || bi.oW(str) || !xn2.field_need_insert_show_timestamp || bi.oW(xn2.field_show_timestamp_encrypt_key)) {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData only decrypt qrcode!");
            } else {
                x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "getCodeData is need insert show timestamp! code signTimestamp!");
                str = e.ci(str, xn2.field_show_timestamp_encrypt_key);
            }
        }
        if (bi.oW(str)) {
            axy.U(1, "");
            return "";
        }
        xp.field_status = 1;
        if (am.axw().c(xp, new String[]{"card_id", "code_id"})) {
            x.i("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  success! card_id = %s, code_id = %s ,status = %d", new Object[]{xp.field_card_id, xp.field_code_id, Integer.valueOf(xp.field_status)});
        } else {
            x.e("MicroMsg.CardQrCodeDataInfoStorage", "update qrCodeData  failure! card_id = %s, code_id = %s ,status = %d", new Object[]{xp.field_card_id, xp.field_code_id, Integer.valueOf(xp.field_status)});
        }
        g axy2 = am.axy();
        i xn3 = am.axx().xn(bVar.awq());
        if (xn3 == null) {
            x.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRequestCodeTimer failure! CardQrCodeConfi is null!");
            return str;
        }
        long j = (long) (xn3.field_show_expire_interval * BaseReportManager.MAX_READ_COUNT);
        x.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "startRefreshCodeTimer refreshTime: " + j);
        axy2.htZ.J(j, j);
        return str;
    }

    public final ab azN() {
        return new n(this, this.gKS);
    }

    public final ab azO() {
        return new f(this, this.gKS);
    }

    public final ab azP() {
        return new t(this, this.gKS);
    }
}
