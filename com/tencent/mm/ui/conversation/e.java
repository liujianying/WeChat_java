package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import junit.framework.Assert;

public final class e implements OnItemClickListener {
    private Activity activity;
    private g unL;
    private ListView unh;

    public e(g gVar, ListView listView, Activity activity) {
        this.unL = gVar;
        this.unh = listView;
        this.activity = activity;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = false;
        if (i >= this.unh.getHeaderViewsCount()) {
            int headerViewsCount = i - this.unh.getHeaderViewsCount();
            ai aiVar = (ai) this.unL.Dy(headerViewsCount);
            if (aiVar == null) {
                x.e("MicroMsg.ConversationClickListener", "null user at position = " + headerViewsCount);
                return;
            }
            boolean z2;
            if (aiVar.gh(16777216)) {
                aiVar.gg(16777216);
                au.HU();
                c.FW().a(aiVar, aiVar.field_username);
            }
            if (aiVar.gh(33554432)) {
                aiVar.gg(33554432);
                au.HU();
                c.FW().a(aiVar, aiVar.field_username);
            }
            if (s.hk(aiVar.field_username)) {
                if (q.GX()) {
                    d.A(this.activity, "tmessage", ".ui.TConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    z2 = false;
                }
            } else if (s.hl(aiVar.field_username)) {
                if (q.GW()) {
                    d.A(this.activity, "bottle", ".ui.BottleConversationUI");
                    z2 = false;
                } else {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    z2 = false;
                }
            } else if (s.hq(aiVar.field_username)) {
                MMAppMgr.cancelNotification(aiVar.field_username);
                d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                z2 = false;
            } else {
                Intent intent;
                if (s.hi(aiVar.field_username)) {
                    g.Ek();
                    if (bi.f((Integer) g.Ei().DT().get(17, null)) == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                        z2 = false;
                    }
                } else if (s.hw(aiVar.field_username)) {
                    z2 = false;
                } else if (s.hv(aiVar.field_username)) {
                    if (q.Hc()) {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra("type", 20);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                        z2 = false;
                    }
                } else if (s.hD(aiVar.field_username)) {
                    if (q.Hd()) {
                        intent = new Intent();
                        intent.addFlags(67108864);
                        intent.putExtra("type", 11);
                        d.b(this.activity, "readerapp", ".ui.ReaderAppUI", intent);
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                        z2 = false;
                    }
                } else if (s.hn(aiVar.field_username)) {
                    d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                    z2 = false;
                } else if (s.ho(aiVar.field_username)) {
                    if (q.Hf()) {
                        d.b(this.activity, "masssend", ".ui.MassSendHistoryUI", new Intent().addFlags(67108864));
                        z2 = false;
                    } else {
                        d.b(this.activity, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", aiVar.field_username));
                        z2 = false;
                    }
                } else if (s.hC(aiVar.field_username)) {
                    if (a.dBu != null) {
                        a.dBu.ix(aiVar.field_username);
                    }
                    z2 = true;
                } else if (s.hE(aiVar.field_username)) {
                    if (com.tencent.mm.storage.s.auK()) {
                        this.activity.startActivity(new Intent(this.activity, BizTimeLineUI.class));
                        z2 = false;
                    } else {
                        this.activity.startActivity(new Intent(this.activity, BizConversationUI.class));
                        z2 = false;
                    }
                } else if (s.hf(aiVar.field_username) && f.kM(aiVar.field_username)) {
                    if (s.he(aiVar.field_username)) {
                        intent = new Intent(this.activity, EnterpriseConversationUI.class);
                        intent.putExtra("enterprise_biz_name", aiVar.field_username);
                        intent.putExtra("enterprise_biz_display_name", r.gT(aiVar.field_username));
                        intent.putExtra("enterprise_from_scene", 1);
                        this.activity.startActivity(intent);
                        z2 = false;
                    } else {
                        h.bA(this.activity, this.activity.getString(R.l.enterprise_not_contact));
                        return;
                    }
                } else if (s.hf(aiVar.field_username) && f.eZ(aiVar.field_username)) {
                    if (s.he(aiVar.field_username)) {
                        intent = new Intent(this.activity, BizChatConversationUI.class);
                        intent.putExtra("Contact_User", aiVar.field_username);
                        intent.putExtra("biz_chat_from_scene", 1);
                        intent.addFlags(67108864);
                        this.activity.startActivity(intent);
                        z2 = false;
                    } else {
                        h.bA(this.activity, this.activity.getString(R.l.enterprise_not_contact));
                        return;
                    }
                } else if (s.hN(aiVar.field_username)) {
                    intent = new Intent();
                    intent.setClassName(this.activity, "com.tencent.mm.ui.conversation.AppBrandServiceConversationUI");
                    intent.putExtra("Contact_User", aiVar.field_username);
                    intent.putExtra("app_brand_conversation_from_scene", 1);
                    intent.addFlags(67108864);
                    this.activity.startActivity(intent);
                    z2 = false;
                }
                z2 = true;
            }
            if (z2) {
                com.tencent.mm.plugin.report.service.g.vu(9);
                LauncherUI launcherUI = (LauncherUI) this.activity;
                String str = "Launcher should not be empty.";
                if (launcherUI != null) {
                    z = true;
                }
                Assert.assertTrue(str, z);
                launcherUI.startChatting(aiVar.field_username, null, true);
            }
        }
    }
}
