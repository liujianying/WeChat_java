package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.st;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.model.q;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.chatting.b.b.r;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.File;
import java.util.ArrayList;

class p$10 implements a {
    d lXx = null;
    final /* synthetic */ p tJl;

    p$10(p pVar) {
        this.tJl = pVar;
    }

    public final void bcy() {
        if (!com.tencent.mm.p.a.bw(p.e(this.tJl).tTq.getContext())) {
            st stVar = new st();
            com.tencent.mm.sdk.b.a.sFg.m(stVar);
            if (this.tJl.getTalkerUserName().equals(stVar.cdA.talker) || !(stVar.cdA.cdC || stVar.cdA.cdD)) {
                if (1 == g.AT().getInt("EnableVoiceVoipFromPlugin", 0)) {
                    boolean z = ab.XR(p.e(this.tJl).oLT.field_username) ? (((b) com.tencent.mm.kernel.g.l(b.class)).oD(p.e(this.tJl).oLT.field_openImAppid) & 8192) == 0 : false;
                    this.lXx = new d(p.e(this.tJl).tTq.getContext(), 1, false);
                    this.lXx.ofp = new 1(this, z);
                    this.lXx.ofq = new 2(this);
                    this.lXx.bXO();
                } else {
                    this.tJl.ctp();
                }
                h.mEJ.h(11033, new Object[]{Integer.valueOf(4), Integer.valueOf(1), Integer.valueOf(0)});
                return;
            }
            Toast.makeText(p.e(this.tJl).tTq.getContext(), stVar.cdA.cdB ? R.l.cannot_use_voip_bcz_video_talking : R.l.cannot_use_voip_bcz_voice_talking, 0).show();
            x.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        }
    }

    public final void bcz() {
        if (!com.tencent.mm.p.a.bw(p.e(this.tJl).tTq.getContext())) {
            st stVar = new st();
            com.tencent.mm.sdk.b.a.sFg.m(stVar);
            if (this.tJl.getTalkerUserName().equals(stVar.cdA.talker) || !(stVar.cdA.cdC || stVar.cdA.cdD)) {
                this.tJl.cto();
                return;
            }
            Toast.makeText(p.e(this.tJl).tTq.getContext(), stVar.cdA.cdB ? R.l.cannot_use_voip_bcz_video_talking : R.l.cannot_use_voip_bcz_voice_talking, 0).show();
            x.i("MicroMsg.ChattingFooterEventImpl", "voip is running, can't do this");
        }
    }

    public final void bcA() {
        if (!com.tencent.mm.p.a.by(p.e(this.tJl).tTq.getContext()) && !com.tencent.mm.p.a.bw(p.e(this.tJl).tTq.getContext())) {
            x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(p.e(this.tJl).tTq.getContext(), "android.permission.RECORD_AUDIO", 81, "", "")), bi.cjd(), p.e(this.tJl).tTq.getContext()});
            if (com.tencent.mm.pluginsdk.permission.a.a(p.e(this.tJl).tTq.getContext(), "android.permission.RECORD_AUDIO", 81, "", "")) {
                this.tJl.ctq();
            }
        }
    }

    public final void bcB() {
        ((r) p.e(this.tJl).O(r.class)).cvF();
    }

    public final void bcC() {
        ((com.tencent.mm.ui.chatting.b.b.d) p.e(this.tJl).O(com.tencent.mm.ui.chatting.b.b.d.class)).cuG();
    }

    public final void st(int i) {
        switch (i) {
            case 0:
                File file = new File(e.dgl);
                if (file.exists() || file.mkdir()) {
                    x.i("MicroMsg.ChattingFooterEventImpl", "summerper checkPermission checkcamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(p.e(this.tJl).tTq.getContext(), "android.permission.CAMERA", 20, "", "")), bi.cjd(), p.e(this.tJl).tTq.getContext()});
                    if (com.tencent.mm.pluginsdk.permission.a.a(p.e(this.tJl).tTq.getContext(), "android.permission.CAMERA", 20, "", "")) {
                        this.tJl.ctr();
                        return;
                    }
                    return;
                }
                Toast.makeText(p.e(this.tJl).tTq.getContext(), p.e(this.tJl).tTq.getMMResources().getString(R.l.chatting_toast_sdk_fail), 1).show();
                return;
            case 1:
                String string = p.e(this.tJl).tTq.getContext().getSharedPreferences(ad.chY(), 0).getString("gallery", "1");
                com.tencent.mm.plugin.report.service.g.vu(19);
                if (string.equalsIgnoreCase("0")) {
                    l.k(p.e(this.tJl).tTq);
                } else {
                    string = p.e(this.tJl).cwp();
                    String talkerUserName = p.e(this.tJl).getTalkerUserName();
                    if (p.m(this.tJl) && p.tJa) {
                        l.b(p.e(this.tJl).tTq, 3, string, talkerUserName);
                    } else if (ab.gr(talkerUserName)) {
                        l.a(p.e(this.tJl).tTq, 12, string, talkerUserName);
                    } else {
                        l.a(p.e(this.tJl).tTq, 3, string, talkerUserName);
                    }
                }
                h.mEJ.h(13822, new Object[]{Integer.valueOf(2), Integer.valueOf(1)});
                ah.i(new 3(this), 1000);
                return;
            default:
                return;
        }
    }

    public final void b(f fVar) {
        ((com.tencent.mm.ui.chatting.b.b.a) p.e(this.tJl).O(com.tencent.mm.ui.chatting.b.b.a.class)).n(fVar);
    }

    public final void bcD() {
        com.tencent.mm.bg.d.b(p.e(this.tJl).tTq.getContext(), "subapp", ".ui.openapi.AddAppUI", new Intent());
    }

    public final void bcE() {
        Intent intent = new Intent();
        Iterable arrayList = new ArrayList();
        arrayList.add("3");
        if (com.tencent.mm.ac.f.eZ(p.n(this.tJl).field_username)) {
            arrayList.add("4");
            arrayList.add("7");
            arrayList.add("9");
            arrayList.add("10");
            arrayList.add("11");
            arrayList.add("12");
            arrayList.add("13");
            arrayList.add("15");
            arrayList.add("16");
            arrayList.add("17");
            arrayList.add("18");
        }
        intent.putExtra("key_to_user", p.n(this.tJl).field_username);
        intent.putExtra("key_fav_item_id", TextUtils.join(",", arrayList));
        com.tencent.mm.plugin.fav.a.b.a(p.e(this.tJl).tTq.getContext(), ".ui.FavSelectUI", intent);
        h.mEJ.h(14103, new Object[]{Integer.valueOf(1)});
    }

    public final void bcF() {
        Intent intent = new Intent();
        intent.putExtra("service_app_talker_user", this.tJl.getTalkerUserName());
        com.tencent.mm.bg.d.a(p.e(this.tJl).tTq, "subapp", ".ui.openapi.ServiceAppUI", intent, TbsListener$ErrorCode.UNLZMA_FAIURE);
    }

    public final void bcG() {
        Intent intent = new Intent();
        intent.putExtra("download_entrance_scene", 17);
        intent.putExtra("preceding_scence", 13);
        com.tencent.mm.bg.d.b(p.e(this.tJl).tTq.getContext(), "emoji", ".ui.v2.EmojiStoreV2UI", intent);
        h.mEJ.h(12065, new Object[]{Integer.valueOf(4)});
    }

    public final void su(int i) {
        if (!com.tencent.mm.p.a.bx(p.e(this.tJl).tTq.getContext()) && !com.tencent.mm.p.a.by(p.e(this.tJl).tTq.getContext()) && !com.tencent.mm.p.a.bw(p.e(this.tJl).tTq.getContext())) {
            this.tJl.EN(i);
        }
    }

    public final void bcH() {
        h.mEJ.h(12097, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
        h.mEJ.h(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
        Intent intent;
        if (p.o(this.tJl)) {
            h.mEJ.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(2)});
            intent = new Intent();
            int gK = m.gK(this.tJl.getTalkerUserName());
            intent.putExtra("key_way", 1);
            intent.putExtra("key_chatroom_num", gK);
            intent.putExtra("key_type", 1);
            intent.putExtra("key_from", 1);
            intent.putExtra("key_username", this.tJl.getTalkerUserName());
            intent.putExtra("pay_channel", 14);
            com.tencent.mm.bg.d.b(p.e(this.tJl).tTq.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
            return;
        }
        au.HU();
        Integer num = (Integer) c.DT().get(aa.a.sPn, Integer.valueOf(0));
        au.HU();
        Integer num2 = (Integer) c.DT().get(aa.a.sPo, Integer.valueOf(0));
        if (num.intValue() == 1 || num2.intValue() == 1) {
            if ((q.GM() == 0 ? 1 : 0) != 0) {
                com.tencent.mm.ui.base.h.a(p.e(this.tJl).tTq.getContext(), null, new String[]{p.e(this.tJl).tTq.getMMResources().getString(R.l.chatting_lucky_money_new_year), p.e(this.tJl).tTq.getMMResources().getString(R.l.chatting_lucky_money_short_title)}, null, new 4(this));
                return;
            }
        }
        h.mEJ.h(11701, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(1)});
        intent = new Intent();
        intent.putExtra("key_way", 0);
        intent.putExtra("key_type", 0);
        intent.putExtra("key_from", 1);
        intent.putExtra("key_username", this.tJl.getTalkerUserName());
        intent.putExtra("pay_channel", 11);
        com.tencent.mm.bg.d.b(p.e(this.tJl).tTq.getContext(), "luckymoney", ".ui.LuckyMoneyPrepareUI", intent);
    }

    public final void bcI() {
        au.HU();
        c.DT().set(81, Boolean.valueOf(false));
        if (ao.isNetworkConnected(p.e(this.tJl).tTq.getContext())) {
            this.tJl.ctn();
        } else {
            com.tencent.mm.ax.e.a(p.e(this.tJl).tTq.getContext(), R.l.voip_net_unavailable, null);
        }
    }

    public final void bcJ() {
        Intent intent = new Intent();
        intent.putExtra("enterprise_scene", 4);
        intent.putExtra("enterprise_biz_name", this.tJl.getTalkerUserName());
        intent.putExtra("biz_chat_chat_id", ((com.tencent.mm.ui.chatting.b.b.c) p.e(this.tJl).O(com.tencent.mm.ui.chatting.b.b.c.class)).cuC());
        com.tencent.mm.bg.d.b(p.e(this.tJl).tTq.getContext(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent);
    }

    public final void bcK() {
        if (p.o(this.tJl)) {
            Intent intent = new Intent();
            intent.putExtra("enter_scene", 1);
            intent.putExtra("chatroom_name", this.tJl.getTalkerUserName());
            com.tencent.mm.bg.d.b(p.e(this.tJl).tTq.getContext(), "aa", ".ui.LaunchAAUI", intent);
        }
    }

    public final void bcL() {
        h.mEJ.h(14523, new Object[]{Integer.valueOf(0)});
        Intent intent = new Intent();
        intent.setClass(p.e(this.tJl).tTq.getContext(), NewFileExplorerUI.class);
        intent.putExtra("TO_USER", p.p(this.tJl));
        p.e(this.tJl).a(intent, TbsListener$ErrorCode.HOST_CONTEXT_IS_NULL, new 5(this));
    }
}
