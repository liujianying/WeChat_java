package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelstat.a$a;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.b.b.w;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.t.d;
import com.tencent.mm.y.g;
import java.util.Map;

public class z$c extends d {
    private b udl;

    public z$c(a aVar, b bVar) {
        super(aVar);
        this.udl = bVar;
    }

    public final void a(View view, a aVar, bd bdVar) {
        e eVar;
        Map z;
        g.a go;
        au auVar = (au) view.getTag();
        b.ehL.z(auVar.bXQ);
        bd bdVar2 = auVar.bXQ;
        com.tencent.mm.modelstat.a.a(bdVar2, a$a.Click);
        int[] iArr = new int[2];
        int i = 0;
        int i2 = 0;
        if (view != null) {
            view.getLocationInWindow(iArr);
            i = view.getWidth();
            i2 = view.getHeight();
        }
        if (bdVar2.field_isSend == 1) {
            e br = o.Pf().br(bdVar2.field_msgId);
            if (br.dTK != 0) {
                eVar = br;
                z = bl.z(bdVar2.field_content, "msg");
                if (z != null) {
                    bi.getLong((String) z.get(".msg.img.$hdlength"), 0);
                }
                au.HU();
                if (!c.isSDCardAvailable()) {
                    s.gH(this.tKy.tTq.getContext());
                } else if (bdVar2.field_isSend == 1) {
                    if (com.tencent.mm.a.e.cn(o.Pf().o(f.c(eVar), "", ""))) {
                        a(this.tKy, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
                    } else {
                        if (com.tencent.mm.a.e.cn(o.Pf().o(eVar.dTL, "", ""))) {
                            a(this.tKy, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
                        } else {
                            a(bdVar2.field_msgId, bdVar2.field_msgSvrId, auVar.userName, auVar.chatroomName, iArr, i, i2);
                        }
                    }
                } else if (eVar.OM()) {
                    String str;
                    a aVar2;
                    String str2 = eVar.dTL;
                    if (eVar.ON()) {
                        e a = f.a(eVar);
                        if (a != null && a.dTK > 0 && a.OM() && com.tencent.mm.a.e.cn(o.Pf().o(a.dTL, "", ""))) {
                            str = a.dTL;
                            aVar2 = this.tKy;
                            o.Pf().o(str, "", "");
                            a(aVar2, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
                        }
                    }
                    str = str2;
                    aVar2 = this.tKy;
                    o.Pf().o(str, "", "");
                    a(aVar2, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
                } else {
                    if (eVar.status == -1) {
                        x.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[]{Long.valueOf(eVar.dTK)});
                        eVar.setStatus(0);
                        eVar.bWA = 256;
                        o.Pf().a(Long.valueOf(eVar.dTK), eVar);
                    }
                    a(bdVar2.field_msgId, bdVar2.field_msgSvrId, auVar.userName, auVar.chatroomName, iArr, i, i2);
                }
                go = g.a.go(bdVar.field_content);
                if (go != null && !bi.oW(go.appId) && this.udl != null) {
                    com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(go.appId, false);
                    if (bl != null && bl.aaq()) {
                        b.a(aVar, go, this.udl instanceof z.a ? b.d(aVar, bdVar) : q.GF(), bl, bdVar.field_msgSvrId);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        eVar = o.Pf().bq(bdVar2.field_msgSvrId);
        z = bl.z(bdVar2.field_content, "msg");
        if (z != null) {
            bi.getLong((String) z.get(".msg.img.$hdlength"), 0);
        }
        au.HU();
        if (!c.isSDCardAvailable()) {
            s.gH(this.tKy.tTq.getContext());
        } else if (bdVar2.field_isSend == 1) {
            if (com.tencent.mm.a.e.cn(o.Pf().o(f.c(eVar), "", ""))) {
                a(this.tKy, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
            } else {
                if (com.tencent.mm.a.e.cn(o.Pf().o(eVar.dTL, "", ""))) {
                    a(this.tKy, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
                } else {
                    a(bdVar2.field_msgId, bdVar2.field_msgSvrId, auVar.userName, auVar.chatroomName, iArr, i, i2);
                }
            }
        } else if (eVar.OM()) {
            String str3;
            a aVar22;
            String str22 = eVar.dTL;
            if (eVar.ON()) {
                e a2 = f.a(eVar);
                if (a2 != null && a2.dTK > 0 && a2.OM() && com.tencent.mm.a.e.cn(o.Pf().o(a2.dTL, "", ""))) {
                    str3 = a2.dTL;
                    aVar22 = this.tKy;
                    o.Pf().o(str3, "", "");
                    a(aVar22, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
                }
            }
            str3 = str22;
            aVar22 = this.tKy;
            o.Pf().o(str3, "", "");
            a(aVar22, bdVar2, eVar.dTS, eVar.bYu, auVar.userName, auVar.chatroomName, iArr, i, i2, false);
        } else {
            if (eVar.status == -1) {
                x.i("MicroMsg.DesignerClickListener", "retry downloadImg, %d", new Object[]{Long.valueOf(eVar.dTK)});
                eVar.setStatus(0);
                eVar.bWA = 256;
                o.Pf().a(Long.valueOf(eVar.dTK), eVar);
            }
            a(bdVar2.field_msgId, bdVar2.field_msgSvrId, auVar.userName, auVar.chatroomName, iArr, i, i2);
        }
        go = g.a.go(bdVar.field_content);
        if (go != null) {
        }
    }

    private void a(long j, long j2, String str, String str2, int[] iArr, int i, int i2) {
        String str3;
        int i3;
        Bundle bundle;
        Intent intent = new Intent(this.tKy.tTq.getContext(), ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("show_search_chat_content_result", ((w) this.tKy.O(w.class)).cvQ());
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.b.b.c) this.tKy.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur());
        intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.b.b.c) this.tKy.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuC());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", ((w) this.tKy.O(w.class)).cvL());
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ab.gr(str));
        String talkerUserName = this.tKy.getTalkerUserName();
        Bundle bundle2 = new Bundle();
        if (this.tKy.cwr()) {
            str3 = "stat_scene";
            i3 = 2;
            bundle = bundle2;
        } else {
            str3 = "stat_scene";
            if (com.tencent.mm.model.s.hf(talkerUserName)) {
                i3 = 7;
                bundle = bundle2;
            } else {
                i3 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str3, i3);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
        bundle2.putString("stat_chat_talker_username", talkerUserName);
        bundle2.putString("stat_send_msg_user", str);
        intent.putExtra("_stat_obj", bundle2);
        this.tKy.startActivity(intent);
        this.tKy.tTq.overridePendingTransition(0, 0);
    }

    public static void a(a aVar, bd bdVar, long j, long j2, String str, String str2, int[] iArr, int i, int i2, boolean z) {
        String str3;
        int i3;
        Bundle bundle;
        Intent intent = new Intent(aVar.tTq.getContext(), ImageGalleryUI.class);
        intent.putExtra("img_gallery_msg_id", j);
        intent.putExtra("img_gallery_msg_svr_id", j2);
        intent.putExtra("show_search_chat_content_result", ((w) aVar.O(w.class)).cvQ());
        intent.putExtra("key_is_biz_chat", ((com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class)).cur());
        intent.putExtra("key_biz_chat_id", ((com.tencent.mm.ui.chatting.b.b.c) aVar.O(com.tencent.mm.ui.chatting.b.b.c.class)).cuC());
        intent.putExtra("img_gallery_talker", str);
        intent.putExtra("img_gallery_chatroom_name", str2);
        intent.putExtra("img_gallery_left", iArr[0]);
        intent.putExtra("img_gallery_top", iArr[1]);
        intent.putExtra("img_gallery_width", i);
        intent.putExtra("img_gallery_height", i2);
        intent.putExtra("img_gallery_enter_from_chatting_ui", ((w) aVar.O(w.class)).cvL());
        intent.putExtra("img_gallery_enter_PhotoEditUI", z);
        intent.putExtra("img_gallery_enter_from_appbrand_service_chatting_ui", ab.gr(str));
        String talkerUserName = aVar.getTalkerUserName();
        if (bdVar.field_isSend == 1) {
            str = aVar.cwp();
        }
        Bundle bundle2 = new Bundle();
        if (com.tencent.mm.model.s.fq(aVar.getTalkerUserName())) {
            str3 = "stat_scene";
            i3 = 2;
            bundle = bundle2;
        } else {
            str3 = "stat_scene";
            if (com.tencent.mm.model.s.hf(talkerUserName)) {
                i3 = 7;
                bundle = bundle2;
            } else {
                i3 = 1;
                bundle = bundle2;
            }
        }
        bundle.putInt(str3, i3);
        bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
        bundle2.putString("stat_chat_talker_username", talkerUserName);
        bundle2.putString("stat_send_msg_user", str);
        intent.putExtra("_stat_obj", bundle2);
        aVar.tTq.startActivity(intent);
        aVar.tTq.overridePendingTransition(0, 0);
    }
}
