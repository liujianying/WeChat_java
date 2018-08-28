package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.z;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.c.am;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.s;
import com.tencent.mm.modelmulti.b.a;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelsimple.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.p;

public final class b {
    static /* synthetic */ void a(String str, PBool pBool, ProgressDialog progressDialog) {
        if (l.gz(str)) {
            o.PN().a(new a(str, 0, 0, 0, 0));
        }
        bd.a(str, new 4(pBool, progressDialog, str));
    }

    static /* synthetic */ void a(String str, ai aiVar, PBool pBool, ProgressDialog progressDialog) {
        bd.a(str, new 3(pBool, progressDialog));
        au.HU();
        com.tencent.mm.g.c.ai Yg = c.FR().Yg(str);
        Yg.Bi();
        Yg.Bj();
        if (Yg.ckW() && f.kI(str)) {
            h.mEJ.h(13773, Integer.valueOf(0), Integer.valueOf(aiVar.field_unReadCount), Integer.valueOf(1), aiVar.field_username);
        }
        com.tencent.mm.bk.a aue = new aue();
        x.i("MicroMsg.ConvDelLogic", "oplog modContact user:%s remark:%s type:%d ", Yg.field_username, Yg.field_conRemark, Integer.valueOf(Yg.field_type));
        aue.rvi = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.field_username));
        aue.rQz = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.field_nickname));
        aue.ruT = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.wP()));
        aue.ruU = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.wQ()));
        aue.eJH = Yg.sex;
        aue.ruj = 561023;
        aue.ruk = Yg.field_type;
        aue.rWH = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.field_conRemark));
        aue.rWI = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.field_conRemarkPYShort));
        aue.rWJ = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.field_conRemarkPYFull));
        aue.rup = Yg.csF;
        aue.rXd = new bhz().VO(com.tencent.mm.platformtools.ai.oV(Yg.field_domainList));
        aue.rut = Yg.csI;
        aue.eJL = Yg.csJ;
        aue.eJK = com.tencent.mm.platformtools.ai.oV(Yg.signature);
        aue.eJJ = com.tencent.mm.platformtools.ai.oV(Yg.getCityCode());
        aue.eJI = com.tencent.mm.platformtools.ai.oV(Yg.cla());
        aue.rTg = com.tencent.mm.platformtools.ai.oV(Yg.csO);
        aue.rTi = Yg.field_weiboFlag;
        aue.rWZ = 0;
        aue.rcn = new bhy();
        aue.eJQ = com.tencent.mm.platformtools.ai.oV(Yg.getCountryCode());
        au.HU();
        c.FQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.h.a(2, aue));
        au.HU();
        c.FR().a(str, Yg);
        au.HU();
        am Yq = c.FW().Yq(str);
        au.HU();
        c.FW().Yp(str);
        if (Yq == null) {
            return;
        }
        if (Yq.gh(4194304) || (Yg.ckW() && !com.tencent.mm.l.a.gd(Yg.field_type) && Yq.field_conversationTime < z.Nm())) {
            au.DF().a(new e(str), 0);
        }
    }

    static /* synthetic */ void c(Context context, boolean z, String str) {
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.putExtra("chat_from_scene", 4);
            d.e(context, ".ui.chatting.ChattingUI", intent);
            return;
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.startChatting(str, null, true);
        }
    }

    public static void a(String str, Context context, ai aiVar, Runnable runnable, boolean z, boolean z2) {
        PBool pBool = new PBool();
        String str2;
        if (s.fq(str)) {
            str2 = null;
            au.HU();
            cm GD = c.FT().GD(str);
            au.HU();
            c.FQ().b(new com.tencent.mm.aq.d(str, GD.field_msgSvrId));
            pBool.value = false;
            context.getString(R.l.app_tip);
            p a = com.tencent.mm.ui.base.h.a(context, context.getString(R.l.app_waiting), true, new 1(pBool));
            if (!pBool.value) {
                str2 = com.tencent.mm.pluginsdk.wallet.e.Uk(str);
            }
            if (com.tencent.mm.platformtools.ai.oW(str2)) {
                a.dismiss();
                com.tencent.mm.ui.base.h.a(context, context.getString(R.l.fmt_delconvmsg_confirm_group), "", context.getString(R.l.app_delete), context.getString(R.l.app_cancel), new 9(str, pBool, a, runnable), null, R.e.alert_btn_color_warn);
            } else {
                a.dismiss();
                com.tencent.mm.ui.base.h.a(context, false, context.getString(R.l.wallet_chatting_del_conversation_note, new Object[]{str2}), null, context.getString(R.l.goto_conversation), context.getString(R.l.del_conversation), new 7(pBool, context, z2, str, z), new 8(a, pBool, str, z, runnable), -1, R.e.alert_btn_color_warn);
            }
        } else if (s.hv(str)) {
            au.HU();
            c.FW().GL(str);
            mk mkVar = new mk();
            mkVar.bXl.opType = 4;
            mkVar.bXl.bXq = 20;
            com.tencent.mm.sdk.b.a.sFg.m(mkVar);
        } else if (s.hl(str)) {
            au.HU();
            c.FW().GL(str);
        } else if (s.ho(str)) {
            au.HU();
            c.FW().Yp(str);
        } else if (f.eZ(str)) {
            pBool.value = false;
            context.getString(R.l.app_tip);
            p a2 = com.tencent.mm.ui.base.h.a(context, context.getString(R.l.app_waiting), true, new 10(pBool));
            a2.dismiss();
            com.tencent.mm.ui.base.h.a(context, context.getString(R.l.fmt_delconvmsg_confirm), "", context.getString(R.l.app_delete), context.getString(R.l.app_cancel), new 11(str, pBool, a2, str), null, R.e.alert_btn_color_warn);
        } else {
            au.HU();
            cm GD2 = c.FT().GD(str);
            au.HU();
            c.FQ().b(new com.tencent.mm.aq.d(str, GD2.field_msgSvrId));
            pBool.value = false;
            context.getString(R.l.app_tip);
            p a3 = com.tencent.mm.ui.base.h.a(context, context.getString(R.l.app_waiting), true, new 12(pBool));
            str2 = null;
            if (!pBool.value) {
                str2 = com.tencent.mm.pluginsdk.wallet.e.Uk(str);
            }
            if (com.tencent.mm.platformtools.ai.oW(str2)) {
                a3.dismiss();
                com.tencent.mm.ui.base.h.a(context, context.getString(s.hE(str) ? R.l.fmt_delconvmsg_confirm_biz : R.l.fmt_delconvmsg_confirm), "", context.getString(R.l.app_delete), context.getString(R.l.app_cancel), new 2(context, str, aiVar, pBool, a3, runnable), null, R.e.alert_btn_color_warn);
            } else {
                a3.dismiss();
                com.tencent.mm.ui.base.h.a(context, false, context.getString(R.l.wallet_chatting_del_conversation_note, new Object[]{str2}), null, context.getString(R.l.goto_conversation), context.getString(R.l.del_conversation), new 13(pBool, context, z2, str, z), new 14(a3, pBool, context, str, aiVar, runnable, z), -1, R.e.alert_btn_color_warn);
            }
        }
        if (s.hm(str)) {
            x.i("MicroMsg.ConvDelLogic", "del all qmessage");
            bd.Im();
            au.HU();
            c.FW().GL("@qqim");
        } else if (s.hk(str)) {
            x.i("MicroMsg.ConvDelLogic", "del all tmessage");
            bd.In();
            au.HU();
            c.FW().GL("@t.qq.com");
        }
    }
}
