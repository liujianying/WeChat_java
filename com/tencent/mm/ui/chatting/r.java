package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.an.a.b;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.viewitems.c.f;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.g$a;
import com.tencent.mm.y.i;
import com.tencent.mm.y.l;
import com.tencent.mm.y.m;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.HashMap;

public final class r {
    public static void dr(View view) {
        if (view.getTag() instanceof f) {
            f fVar = (f) view.getTag();
            long j = fVar.bJC;
            b bVar;
            String valueOf;
            String str;
            if (fVar.uaH == -1) {
                boolean z;
                int g;
                bd bdVar;
                com.tencent.mm.modelstat.b bVar2;
                au.HU();
                bd dW = c.FT().dW(fVar.bJC);
                if (KK(String.valueOf(j))) {
                    h.mEJ.k(10231, "1");
                    com.tencent.mm.an.b.PW();
                    if (dW.field_msgId == j) {
                        com.tencent.mm.modelstat.b bVar3 = com.tencent.mm.modelstat.b.ehL;
                        z = false;
                        g = com.tencent.mm.y.h.g(dW);
                        bdVar = dW;
                        bVar2 = bVar3;
                    } else {
                        return;
                    }
                }
                g$a gp = g$a.gp(fVar.bVv);
                if (gp != null) {
                    h.mEJ.k(10090, "0,1");
                    bVar = (b) g.l(b.class);
                    valueOf = String.valueOf(fVar.bJC);
                    str = fVar.bSw;
                    au.HU();
                    com.tencent.mm.an.b.b(bVar.a(gp, valueOf, str, c.Gq(), fVar.bSw));
                }
                if (dW.field_msgId == j) {
                    bVar2 = com.tencent.mm.modelstat.b.ehL;
                    if (gp != null) {
                        g = gp.type;
                        z = true;
                        bdVar = dW;
                    } else {
                        g = 0;
                        z = true;
                        bdVar = dW;
                    }
                } else {
                    return;
                }
                bVar2.a(bdVar, z, g);
                return;
            }
            String str2 = fVar.bJC + "_" + fVar.uaH;
            au.HU();
            bd dW2 = c.FT().dW(fVar.bJC);
            l wS = ((a) g.l(a.class)).wS(fVar.bVv);
            h hVar;
            Object[] objArr;
            if (KK(str2)) {
                h.mEJ.k(10231, "1");
                com.tencent.mm.an.b.PW();
                if (dW2.field_msgId == j) {
                    com.tencent.mm.modelstat.b.ehL.a(dW2, false, com.tencent.mm.y.h.g(dW2));
                }
                if (wS != null && wS.dzs != null && wS.dzs.size() > fVar.uaH) {
                    m mVar = (m) wS.dzs.get(fVar.uaH);
                    hVar = h.mEJ;
                    objArr = new Object[2];
                    objArr[0] = Integer.valueOf(mVar.type == 6 ? 1 : 0);
                    objArr[1] = Integer.valueOf(1);
                    hVar.h(14972, objArr);
                    return;
                }
                return;
            }
            if (!(wS == null || wS.dzs == null || wS.dzs.size() <= fVar.uaH)) {
                h.mEJ.k(10090, "0,1");
                m mVar2 = (m) wS.dzs.get(fVar.uaH);
                bVar = (b) g.l(b.class);
                valueOf = fVar.bSw;
                str = mVar2.title;
                String str3 = mVar2.dzM;
                String str4 = mVar2.url;
                String str5 = mVar2.url;
                String str6 = mVar2.dzL;
                au.HU();
                com.tencent.mm.an.b.b(bVar.a(0, valueOf, str, str3, str4, str5, str6, str2, c.Gq(), fVar.bSw, "", ""));
                hVar = h.mEJ;
                objArr = new Object[2];
                objArr[0] = Integer.valueOf(mVar2.type == 6 ? 1 : 0);
                objArr[1] = Integer.valueOf(0);
                hVar.h(14972, objArr);
            }
            if (dW2.field_msgId == j) {
                com.tencent.mm.modelstat.b.ehL.a(dW2, true, com.tencent.mm.y.h.g(dW2));
            }
        }
    }

    private static boolean KK(String str) {
        avq Qa = com.tencent.mm.an.b.Qa();
        if (Qa == null || Qa.rsp == null || Qa.rYj != 0 || !com.tencent.mm.an.b.PY()) {
            return false;
        }
        try {
            if (bi.fS(Qa.rsp, str)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public static void a(View view, Context context, String str) {
        com.tencent.mm.ui.chatting.viewitems.au auVar = (com.tencent.mm.ui.chatting.viewitems.au) view.getTag();
        Object obj = auVar.bKk;
        if (TextUtils.isEmpty(obj)) {
            obj = ((com.tencent.mm.plugin.emoji.b.c) g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zn(auVar.cGB);
        }
        if (TextUtils.isEmpty(obj)) {
            Intent intent = new Intent();
            intent.putExtra("geta8key_username", str);
            intent.putExtra("rawUrl", auVar.cGB);
            d.b(context, "webview", ".ui.tools.WebViewUI", intent);
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("extra_id", obj);
        intent2.putExtra("extra_name", auVar.title);
        if (auVar.ufz) {
            intent2.putExtra("download_entrance_scene", 20);
            intent2.putExtra("preceding_scence", 3);
            intent2.putExtra("reward_tip", true);
            h.mEJ.h(12953, new Object[]{Integer.valueOf(1), obj});
        } else if (auVar.ufA) {
            intent2.putExtra("download_entrance_scene", 25);
            intent2.putExtra("preceding_scence", 9);
            intent2.putExtra("reward_tip", true);
        } else {
            intent2.putExtra("download_entrance_scene", 22);
            intent2.putExtra("preceding_scence", TbsListener$ErrorCode.DOWNLOAD_HAS_COPY_TBS_ERROR);
            h.mEJ.h(10993, new Object[]{Integer.valueOf(2), obj});
        }
        d.b(context, "emoji", ".ui.EmojiStoreDetailUI", intent2);
    }

    public static void a(m mVar, View view, String str) {
        if (view != null && mVar != null) {
            view.setOnClickListener(new 1(mVar, str));
        }
    }

    public static void a(int i, Context context, String str, String str2, long j, long j2) {
        l wS = ((a) g.l(a.class)).wS(str);
        if (wS == null) {
            x.w("MicroMsg.ChattingItemHelper", "transmitAppBrandMsg reader is null");
        } else if (i >= 0 && i < wS.dzs.size()) {
            m mVar = (m) wS.dzs.get(i);
            String a = g$a.a(l.a(str2, mVar), null, null);
            if (!bi.oW(a)) {
                Serializable hashMap = new HashMap();
                hashMap.put("desc", mVar.dzA);
                hashMap.put("type", Integer.valueOf(2));
                hashMap.put("title", mVar.title);
                hashMap.put("app_id", mVar.dzH);
                hashMap.put("pkg_type", Integer.valueOf(mVar.dzG));
                hashMap.put("pkg_version", Integer.valueOf(mVar.dzF));
                hashMap.put("img_url", mVar.dzI);
                hashMap.put("is_dynamic", Boolean.valueOf(false));
                hashMap.put("cache_key", "");
                hashMap.put("path", mVar.dzE);
                Intent intent = new Intent(context, MsgRetransmitUI.class);
                intent.putExtra("appbrand_params", hashMap);
                intent.putExtra("Retr_Msg_content", a);
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", i);
                intent.putExtra("Retr_Msg_Id", j);
                intent.putExtra("Retr_MsgFromScene", 3);
                a = u.ic(String.valueOf(j2));
                intent.putExtra("reportSessionId", a);
                u.b v = u.Hx().v(a, true);
                v.p("prePublishId", "msg_" + j2);
                v.p("preUsername", str2);
                v.p("preChatName", str2);
                v.p("preMsgIndex", Integer.valueOf(i));
                v.p("sendAppMsgScene", Integer.valueOf(1));
                context.startActivity(intent);
            }
        }
    }

    public static void a(long j, int i, Context context, Fragment fragment, Activity activity, bd bdVar) {
        String str = bdVar.field_talker;
        String ic = u.ic(bdVar.field_msgSvrId);
        u.b v = u.Hx().v(ic, true);
        v.p("prePublishId", "msg_" + bdVar.field_msgSvrId);
        v.p("preUsername", str);
        v.p("preChatName", str);
        v.p("preMsgIndex", Integer.valueOf(i));
        v.p("sendAppMsgScene", Integer.valueOf(1));
        ch chVar = new ch();
        chVar.bJF.bJJ = i;
        chVar.bJF.bJK = ic;
        chVar.bJF.nd = fragment;
        chVar.bJF.activity = activity;
        chVar.bJF.bJM = 40;
        e.a(chVar, bdVar);
        com.tencent.mm.sdk.b.a.sFg.m(chVar);
        if (chVar.bJG.ret == 0) {
            g$a gp = g$a.gp(i.a(context, i, bdVar.field_content, bdVar.field_talker));
            if (bdVar.aQm()) {
                com.tencent.mm.modelstat.b.ehL.b(bdVar, gp != null ? gp.type : 0);
            } else {
                com.tencent.mm.modelstat.b.ehL.x(bdVar);
            }
            if (gp != null && gp.type == 5 && gp.url != null) {
                x.d("MicroMsg.ChattingItemHelper", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", new Object[]{Integer.valueOf(13378), gp.url, Long.valueOf(j), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
                str = "";
                try {
                    str = URLEncoder.encode(gp.url, "UTF-8");
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.ChattingItemHelper", e, "", new Object[0]);
                }
                h.mEJ.h(13378, new Object[]{str, Long.valueOf(j), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1)});
            }
        }
    }

    public static void a(bd bdVar, Context context, com.tencent.mm.ui.chatting.c.a aVar) {
        int i = 1;
        au.HU();
        if (c.isSDCardAvailable()) {
            com.tencent.mm.ak.e bq;
            com.tencent.mm.ak.e eVar = null;
            if (bdVar.field_msgId > 0) {
                eVar = o.Pf().br(bdVar.field_msgId);
            }
            if ((eVar == null || eVar.dTK <= 0) && bdVar.field_msgSvrId > 0) {
                bq = o.Pf().bq(bdVar.field_msgSvrId);
            } else {
                bq = eVar;
            }
            if (bq != null) {
                int i2;
                if (bdVar.field_isSend == 1) {
                    if (bq.ON()) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else if (bq.ON()) {
                    if (com.tencent.mm.a.e.cn(o.Pf().o(com.tencent.mm.ak.f.a(bq).dTL, "", ""))) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 0;
                }
                if (bdVar.cmu()) {
                    x.i("MicroMsg.ChattingItemHelper", "image is clean!!!");
                    com.tencent.mm.ui.base.h.a(context, context.getString(R.l.imgdownload_cleaned), context.getString(R.l.app_tip), new 2());
                    return;
                } else if (com.tencent.mm.ui.chatting.b.i.e(bdVar, o.Pf().o(com.tencent.mm.ak.f.c(bq), "", ""))) {
                    x.i("MicroMsg.ChattingItemHelper", "img is expired or clean!!!");
                    Intent intent = new Intent(context, ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", bdVar.field_msgId);
                    intent.putExtra("img_gallery_msg_svr_id", bdVar.field_msgSvrId);
                    intent.putExtra("img_gallery_talker", bdVar.field_talker);
                    intent.putExtra("img_gallery_chatroom_name", bdVar.field_talker);
                    intent.putExtra("img_gallery_is_restransmit_after_download", true);
                    intent.putExtra("Retr_show_success_tips", true);
                    if (aVar != null) {
                        com.tencent.mm.ui.chatting.b.i.a(aVar, bdVar, intent);
                    } else if (bdVar != null) {
                        String str = bdVar.field_talker;
                        String str2 = bdVar.field_talker;
                        Bundle bundle = new Bundle();
                        String str3 = "stat_scene";
                        if (s.hf(str)) {
                            i = 7;
                        }
                        bundle.putInt(str3, i);
                        bundle.putString("stat_msg_id", "msg_" + Long.toString(bdVar.field_msgSvrId));
                        bundle.putString("stat_chat_talker_username", str);
                        bundle.putString("stat_send_msg_user", str2);
                        intent.putExtra("_stat_obj", bundle);
                    }
                    context.startActivity(intent);
                    return;
                } else if (bq.offset < bq.dHI || bq.dHI == 0) {
                    Intent intent2 = new Intent(context, MsgRetransmitUI.class);
                    intent2.putExtra("Retr_File_Name", o.Pf().E(bdVar.field_imgPath, true));
                    intent2.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                    intent2.putExtra("Retr_Msg_Type", 0);
                    intent2.putExtra("Retr_show_success_tips", true);
                    intent2.putExtra("Retr_Compress_Type", i2);
                    context.startActivity(intent2);
                    return;
                } else {
                    Intent intent3 = new Intent(context, MsgRetransmitUI.class);
                    intent3.putExtra("Retr_File_Name", o.Pf().o(com.tencent.mm.ak.f.c(bq), "", ""));
                    intent3.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                    intent3.putExtra("Retr_Msg_Type", 0);
                    intent3.putExtra("Retr_show_success_tips", true);
                    intent3.putExtra("Retr_Compress_Type", i2);
                    context.startActivity(intent3);
                    return;
                }
            }
            return;
        }
        com.tencent.mm.ui.base.s.gH(context);
    }
}
