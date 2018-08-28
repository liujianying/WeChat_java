package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.widget.b.a;

public final class f implements OnCreateContextMenuListener, OnItemLongClickListener {
    private Activity activity;
    private ai conversation = null;
    private n$d hqV = new 1(this);
    private String talker = "";
    private g unL;
    private ListView unh;
    private int[] uoE = new int[2];

    public f(g gVar, ListView listView, Activity activity, int[] iArr) {
        this.unL = gVar;
        this.unh = listView;
        this.activity = activity;
        this.uoE = iArr;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < this.unh.getHeaderViewsCount()) {
            x.d("MicroMsg.ConversationClickListener", "on long click header view");
            return true;
        }
        this.conversation = (ai) this.unL.Dy(i - this.unh.getHeaderViewsCount());
        if (this.conversation == null) {
            x.e("MicroMsg.ConversationClickListener", "headercount:%d, postion:%d", new Object[]{Integer.valueOf(this.unh.getHeaderViewsCount()), Integer.valueOf(i)});
            return true;
        }
        this.talker = this.conversation.field_username;
        new a(this.activity).a(view, i, j, this, this.hqV, this.uoE[0], this.uoE[1]);
        if (s.fq(this.talker)) {
            h.mEJ.h(14553, new Object[]{Integer.valueOf(1), Integer.valueOf(0), this.talker});
        } else {
            h.mEJ.h(14553, new Object[]{Integer.valueOf(0), Integer.valueOf(0), this.talker});
        }
        return true;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = 1;
        au.HU();
        ab Yg = c.FR().Yg(this.talker);
        if (Yg == null) {
            x.e("MicroMsg.ConversationClickListener", "onCreateContextMenu, contact is null, talker = " + this.talker);
            return;
        }
        CharSequence BL = Yg.BL();
        if (BL.toLowerCase().endsWith("@chatroom") && com.tencent.mm.platformtools.ai.oW(Yg.field_nickname)) {
            BL = this.activity.getString(R.l.chatting_roominfo_noname);
        }
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        contextMenu.setHeaderTitle(j.a(this.activity, BL));
        if (((this.conversation != null ? 1 : 0) & s.b(this.conversation)) != 0) {
            String str = this.talker;
            au.HU();
            ai Yq = c.FW().Yq(str);
            if (Yq == null) {
                i = 0;
            } else if (Yq.field_unReadCount > 0 || Yq.gh(1048576)) {
                i = 0;
            }
            if (i != 0) {
                contextMenu.add(adapterContextMenuInfo.position, 8, 0, R.l.main_conversation_longclick_setUnRead);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.main_conversation_longclick_markRead);
            }
        }
        if (this.conversation != null && s.a(this.conversation)) {
            au.HU();
            if (c.FW().Yx(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 6, 0, R.l.main_conversation_longclick_unplacedtop);
            } else if (Yg.ckW()) {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.contact_info_stick_biz);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 5, 0, R.l.main_conversation_longclick_placedtop);
            }
        }
        if (Yg.ckW() && com.tencent.mm.l.a.gd(Yg.field_type) && !s.hP(Yg.field_username) && !s.hr(Yg.field_username)) {
            d kH = com.tencent.mm.ac.f.kH(Yg.field_username);
            if (kH != null && kH.LV()) {
                contextMenu.add(adapterContextMenuInfo.position, 10, 0, R.l.main_conversation_longclick_delete_biz_service);
            }
        }
        if (this.conversation != null && this.conversation.field_conversationTime != -1) {
            if (s.hk(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.main_delete_tmessage);
            } else if (s.hl(this.talker)) {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.main_delete_bottleentry);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 4, 0, R.l.main_delete);
            }
        }
    }
}
