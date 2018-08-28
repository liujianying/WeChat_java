package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.b;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g.a;
import java.io.File;

class c$b {
    static boolean a(Context context, a aVar) {
        if (aVar == null || context == null) {
            return false;
        }
        if (aVar.type == 3) {
            return g.m(context, 16);
        }
        if (aVar.type == 4) {
            return g.m(context, 8);
        }
        if (aVar.type == 5) {
            return g.m(context, 32);
        }
        if (aVar.type != 6) {
            return false;
        }
        Long Sy = b.a.Sy(aVar.dwp);
        if (Sy != null) {
            return g.m(context, Sy.longValue());
        }
        return false;
    }

    static void a(com.tencent.mm.ui.chatting.c.a aVar, bd bdVar, String str) {
        String b = com.tencent.mm.model.bd.b(aVar.cwr(), bdVar.field_content, bdVar.field_isSend);
        Intent intent = new Intent(aVar.tTq.getContext(), MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", b);
        intent.putExtra("Retr_MsgFromScene", 2);
        a gp = a.gp(b);
        if (gp != null && 19 == gp.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (gp != null && 24 == gp.type) {
            intent.putExtra("Retr_Msg_Type", 10);
        } else if (gp == null || 16 != gp.type) {
            intent.putExtra("Retr_Msg_Type", 2);
            b = bdVar.field_talker;
            String ic = u.ic(bdVar.field_msgSvrId);
            intent.putExtra("reportSessionId", ic);
            u.b v = u.Hx().v(ic, true);
            v.p("prePublishId", "msg_" + bdVar.field_msgSvrId);
            v.p("preUsername", str);
            v.p("preChatName", b);
            if (!(gp == null || gp.u(com.tencent.mm.y.a.class) == null)) {
                v.p("appservicetype", Integer.valueOf(((com.tencent.mm.y.a) gp.u(com.tencent.mm.y.a.class)).dvE));
                intent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.y.a) gp.u(com.tencent.mm.y.a.class)).dvE);
            }
            if (gp != null && 33 == gp.type) {
                if (aVar.cwr()) {
                    v.p("fromScene", Integer.valueOf(2));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                } else {
                    v.p("fromScene", Integer.valueOf(1));
                    intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                }
                intent.putExtra("Retr_MsgFromUserName", str);
                intent.putExtra("Retr_MsgTalker", bdVar.field_talker);
            }
            v.p("sendAppMsgScene", Integer.valueOf(1));
            ((i) com.tencent.mm.kernel.g.l(i.class)).a("adExtStr", v, bdVar);
        } else {
            intent.putExtra("Retr_Msg_Type", 14);
        }
        intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
        if (gp == null || gp.type != 6) {
            aVar.startActivity(intent);
            return;
        }
        h hVar = h.mEJ;
        Object[] objArr = new Object[6];
        objArr[0] = gp.dwD;
        objArr[1] = Integer.valueOf(gp.dws == 1 ? 7 : 5);
        objArr[2] = Integer.valueOf(gp.dwo);
        objArr[3] = Integer.valueOf(2);
        objArr[4] = Long.valueOf((System.currentTimeMillis() - bdVar.field_createTime) / 1000);
        objArr[5] = gp.dwp;
        hVar.h(14665, objArr);
        boolean z = gp.dws != 0 || gp.dwo > 26214400;
        intent.putExtra("Retr_Big_File", z);
        com.tencent.mm.pluginsdk.model.app.b SZ = l.SZ(gp.bGP);
        if (SZ != null) {
            File file = new File(SZ.field_fileFullPath);
            if (file.exists() && file.length() == SZ.field_totalLen) {
                aVar.startActivity(intent);
                return;
            } else if (SZ.field_offset > 0 && SZ.field_totalLen > SZ.field_offset) {
                a(aVar, intent, bdVar, SZ.field_fileFullPath);
                return;
            }
        }
        x.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", new Object[]{Integer.valueOf(gp.dwo), gp.dwD, bi.Xf(gp.dwK)});
        if (z) {
            intent.putExtra("Retr_Big_File", z);
            com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
            iVar.dPV = new 1(aVar, intent, bdVar, SZ);
            iVar.field_mediaId = d.a("checkExist", bi.VF(), str, bdVar.field_msgId);
            iVar.field_fileId = gp.dwD;
            iVar.field_aesKey = gp.dwK;
            iVar.field_filemd5 = gp.filemd5;
            iVar.field_fileType = com.tencent.mm.modelcdntran.b.dOm;
            iVar.field_talker = str;
            iVar.field_priority = com.tencent.mm.modelcdntran.b.dOk;
            iVar.field_svr_signature = "";
            iVar.field_onlycheckexist = true;
            x.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.modelcdntran.g.ND().c(iVar)), iVar.field_fileId, iVar.field_mediaId, bi.Xf(iVar.field_aesKey)});
            if (!com.tencent.mm.modelcdntran.g.ND().c(iVar)) {
                a(aVar, intent, bdVar, null);
                return;
            }
            return;
        }
        a(aVar, intent, bdVar, null);
    }

    private static void a(com.tencent.mm.ui.chatting.c.a aVar, Intent intent, bd bdVar, String str) {
        if (bdVar.cmu() || e(bdVar, str)) {
            x.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
            com.tencent.mm.ui.base.h.a(aVar.tTq.getContext(), aVar.tTq.getContext().getString(R.l.file_fail_or_clean), aVar.tTq.getContext().getString(R.l.app_tip), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return;
        }
        aVar.startActivity(intent);
    }

    public static boolean e(bd bdVar, String str) {
        if (System.currentTimeMillis() - bdVar.field_createTime <= 259200000 || (!bi.oW(str) && e.cn(str))) {
            return false;
        }
        return true;
    }
}
