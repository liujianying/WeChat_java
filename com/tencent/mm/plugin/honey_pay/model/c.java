package com.tencent.mm.plugin.honey_pay.model;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.honey_pay.a;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a$c;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.protocal.c.alr;
import com.tencent.mm.protocal.c.asp;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.protocal.c.btd;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c {
    private static String kjP = (e.bnE + "wallet");

    public static String dK(long j) {
        return com.tencent.mm.wallet_core.ui.e.b(String.valueOf(j), "100", RoundingMode.HALF_UP).toString();
    }

    public static void a(MMActivity mMActivity, Bundle bundle, alr alr) {
        RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
        realnameGuideHelper.a(alr.qYW, alr.kRt, alr.kRu, alr.kRv, alr.kRw, 0);
        bundle.putString("realname_verify_process_jump_plugin", "honey_pay");
        realnameGuideHelper.a(mMActivity, bundle, null, false);
    }

    public static void a(MMActivity mMActivity, bhw bhw, int i, String str, int i2, btd btd) {
        if (bhw != null && bhw.siH != null && !bhw.siH.isEmpty()) {
            1 1 = new 1(mMActivity, bhw, str, btd, i2);
            if (bi.oW(bhw.title)) {
                mMActivity.addIconOptionMenu(0, i, 1);
            } else {
                mMActivity.a(0, bhw.title, a$c.white, 1);
            }
        }
    }

    public static void a(MMActivity mMActivity, bhw bhw, String str, int i, btd btd) {
        a(mMActivity, bhw, h.actionbar_dark_icon_more, str, i, btd);
    }

    public static void a(Context context, asp asp, OnClickListener onClickListener) {
        com.tencent.mm.ui.base.h.a(context, asp.bSc, "", asp.kRv, asp.kRu, false, onClickListener, null);
    }

    public static String x(String str, String str2, int i) {
        if (i >= 0) {
            return str.replace("$" + str2 + "$", com.tencent.mm.wallet_core.ui.e.dx(com.tencent.mm.wallet_core.ui.e.gT(str2), i));
        }
        return str.replace("$" + str2 + "$", com.tencent.mm.wallet_core.ui.e.gT(str2));
    }

    public static String dn(String str, String str2) {
        return x(str, str2, -1);
    }

    public static int rh(int i) {
        if (i == 1) {
            return h.honey_pay_father_card_icon;
        }
        if (i == 2) {
            return h.honey_pay_mother_card_icon;
        }
        if (i == 3) {
            return h.honey_pay_child_card_icon;
        }
        return -1;
    }

    public static int aWc() {
        return h.honey_pay_input_logo;
    }

    public static void R(String str, String str2, String str3) {
        k(str, str2, str3, null);
    }

    public static void k(String str, String str2, String str3, String str4) {
        x.i("MicroMsg.HoneyPayUtil", "update msg: %s, %s", new Object[]{str, Boolean.valueOf(bi.oW(str2))});
        if (!bi.oW(str2) && !bi.oW(str)) {
            String str5;
            String x = x(str2, str3, 6);
            if (bi.oW(str4)) {
                str5 = x;
            } else {
                str5 = x(x, str4, 6);
            }
            a aVar = new a();
            aVar.field_payMsgId = str;
            a.aWa().aWb().b(aVar, new String[0]);
            if (aVar.field_msgId > 0) {
                x.i("MicroMsg.HoneyPayUtil", "find msg: %s", new Object[]{Long.valueOf(aVar.field_msgId)});
                bd dW = ((i) g.l(i.class)).bcY().dW(aVar.field_msgId);
                if (dW.field_msgId > 0) {
                    dW.setContent(str5);
                    ((i) g.l(i.class)).bcY().a(dW.field_msgId, dW);
                    return;
                }
                x.w("MicroMsg.HoneyPayUtil", "can't find msg: %s, may be deleted", new Object[]{Long.valueOf(aVar.field_msgId)});
            }
        }
    }

    public static void S(String str, String str2, String str3) {
        x.i("MicroMsg.HoneyPayUtil", "insert sys msg: %s, %s", new Object[]{str, Boolean.valueOf(bi.oW(str2))});
        if (!bi.oW(str2) && !bi.oW(str)) {
            String x = x(x(str2, str, -1), str3, -1);
            bd bdVar = new bd();
            bdVar.eX(0);
            bdVar.ep(str);
            bdVar.setStatus(3);
            bdVar.setContent(x);
            bdVar.ay(com.tencent.mm.model.bd.o(str, System.currentTimeMillis() / 1000));
            bdVar.setType(10000);
            bdVar.fg(bdVar.field_flag | 8);
            x.i("MicroMsg.HoneyPayUtil", "insert msgId: %s", new Object[]{Long.valueOf(((i) g.l(i.class)).bcY().T(bdVar))});
            if (((i) g.l(i.class)).bcY().T(bdVar) <= 0) {
                x.w("MicroMsg.HoneyPayUtil", "insert sys msg fail!");
            }
        }
    }

    public static void EF(String str) {
        sz szVar = new sz();
        szVar.cdR.scene = 8;
        com.tencent.mm.sdk.b.a.sFg.m(szVar);
        x.i("MicroMsg.HoneyPayUtil", "trigger offline event");
        ri riVar = new ri();
        riVar.ccb.ccc = false;
        riVar.ccb.scene = 1;
        riVar.ccb.ccd = true;
        riVar.ccb.cce = 65281;
        com.tencent.mm.sdk.b.a.sFg.m(riVar);
        if (!bi.oW(str)) {
            com.tencent.mm.plugin.offline.c.a.Ja(str);
        }
    }

    public static String dL(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1000 * j));
    }
}
