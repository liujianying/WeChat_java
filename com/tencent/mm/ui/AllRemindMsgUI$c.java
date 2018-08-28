package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView$t;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;

class AllRemindMsgUI$c extends RecyclerView$t {
    View SU;
    TextView eBO;
    ImageView eKk;
    TextView mVa;
    final /* synthetic */ AllRemindMsgUI tgf;
    TextView tgi;

    static /* synthetic */ void a(Context context, String str, long j) {
        if (str == null) {
            x.e("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] username is null");
            return;
        }
        au.HU();
        x.i("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] msgLocalId:%s", new Object[]{Long.valueOf(c.FT().I(str, j).field_msgId)});
        if (str.contains("@")) {
            au.HU();
            if (c.Ga().ih(str) == null) {
                x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] member is null! username:%s", new Object[]{str});
                h.a(context, context.getString(R.l.remind_not_found_room), context.getString(R.l.tip_title), null);
                return;
            }
        }
        au.HU();
        ab Yg = c.FR().Yg(str);
        if (Yg == null || !a.gd(Yg.field_type)) {
            if (Yg == null) {
                x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] contact is null! username:%s", new Object[]{str});
            } else {
                x.w("MicroMsg.emoji.AllRemindMsgUI", "[gotoChattingUIWithPosition] isContact not ! username:%s", new Object[]{str});
            }
            h.a(context, context.getString(R.l.remind_not_found_room), context.getString(R.l.tip_title), null);
            return;
        }
        com.tencent.mm.plugin.chatroom.a.ezn.e(new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", r0), context);
    }

    public AllRemindMsgUI$c(AllRemindMsgUI allRemindMsgUI, View view) {
        this.tgf = allRemindMsgUI;
        super(view);
        this.SU = view;
        this.eBO = (TextView) view.findViewById(R.h.title);
        this.tgi = (TextView) view.findViewById(R.h.timestamp);
        this.mVa = (TextView) view.findViewById(R.h.nickname);
        this.eKk = (ImageView) view.findViewById(R.h.avatar);
        this.SU.setOnClickListener(new 1(this, allRemindMsgUI));
        this.SU.setOnTouchListener(new 2(this, allRemindMsgUI));
        this.SU.setOnLongClickListener(new 3(this, allRemindMsgUI));
    }
}
