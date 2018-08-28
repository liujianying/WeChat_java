package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class a extends r<ai> implements b {
    private final MMActivity bGc;
    protected g hkN;
    protected c hkO;
    protected f hkP;
    protected d hkQ = MMSlideDelView.getItemStatusCallBack();

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ai aiVar = (ai) obj;
        if (aiVar == null) {
            aiVar = new ai();
        }
        aiVar.ed("");
        aiVar.ee("");
        aiVar.d(cursor);
        return aiVar;
    }

    public a(Context context, com.tencent.mm.ui.r.a aVar) {
        super(context, new ai());
        this.tlG = aVar;
        this.bGc = (MMActivity) context;
    }

    public final void WT() {
        au.HU();
        setCursor(com.tencent.mm.model.c.FW().clF());
        if (this.tlG != null) {
            this.tlG.Xb();
        }
        super.notifyDataSetChanged();
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(f fVar) {
        this.hkP = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    public final int getItemViewType(int i) {
        return 0;
    }

    public final void onPause() {
        if (this.hkQ != null) {
            this.hkQ.aYl();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int i2;
        ai aiVar = (ai) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            View view2 = (MMSlideDelView) View.inflate(this.bGc, R.i.base_slide_del_view, null);
            View inflate = View.inflate(this.bGc, R.i.tmessage_item, null);
            aVar2.eCl = (ImageView) inflate.findViewById(R.h.avatar_iv);
            aVar2.eTm = (TextView) inflate.findViewById(R.h.nickname_tv);
            aVar2.hkS = (TextView) inflate.findViewById(R.h.update_time_tv);
            aVar2.hkT = (TextView) inflate.findViewById(R.h.last_msg_tv);
            aVar2.hkU = (ImageView) inflate.findViewById(R.h.state_iv);
            aVar2.hkV = (TextView) inflate.findViewById(R.h.tipcnt_tv);
            aVar2.hkW = view2.findViewById(R.h.slide_del_del_view);
            aVar2.hkX = (TextView) view2.findViewById(R.h.slide_del_view_del_word);
            view2.setView(inflate);
            view2.setPerformItemClickListener(this.hkN);
            view2.setGetViewPositionCallback(this.hkO);
            view2.setItemStatusCallBack(this.hkQ);
            view2.setEnable(false);
            view2.setTag(aVar2);
            aVar = aVar2;
            view = view2;
        } else {
            aVar = (a) view.getTag();
        }
        au.HU();
        aVar.eTm.setText(B(com.tencent.mm.model.c.FR().Yg(aiVar.field_username)));
        aVar.hkS.setText(aiVar.field_status == 1 ? this.bGc.getString(R.l.main_sending) : h.c(this.bGc, aiVar.field_conversationTime, true));
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eCl, ab.XV(aiVar.field_username));
        au.HU();
        aVar.hkT.setText(j.a(this.bGc, com.tencent.mm.model.c.FW().vu().a(aiVar.field_isSend, aiVar.field_username, aiVar.field_content, wW(aiVar.field_msgType), this.bGc), aVar.hkT.getTextSize()));
        aVar.hkT.setTextColor(com.tencent.mm.bp.a.ac(this.bGc, R.e.mm_list_textcolor_two));
        if (wW(aiVar.field_msgType) == 34 && aiVar.field_isSend == 0 && !bi.oW(aiVar.field_content) && !new n(aiVar.field_content).enG) {
            aVar.hkT.setTextColor(com.tencent.mm.bp.a.ac(this.bGc, R.e.mm_list_textcolor_unread));
        }
        switch (aiVar.field_status) {
            case 0:
                i2 = -1;
                break;
            case 1:
                i2 = R.k.msg_state_sending;
                break;
            case 2:
                i2 = -1;
                break;
            case 5:
                i2 = R.k.msg_state_failed;
                break;
            default:
                i2 = -1;
                break;
        }
        if (i2 != -1) {
            aVar.hkU.setBackgroundResource(i2);
            aVar.hkU.setVisibility(0);
        } else {
            aVar.hkU.setVisibility(8);
        }
        aVar.hkW.setTag(aiVar.field_username);
        aVar.hkW.setOnClickListener(new 1(this));
        i2 = view.getPaddingBottom();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingLeft = view.getPaddingLeft();
        if (aiVar.field_unReadCount > 100) {
            aVar.hkV.setText("...");
            aVar.hkV.setVisibility(0);
            x.v("MicroMsg.BottleConversationAdapter", "has unread 100");
        } else if (aiVar.field_unReadCount > 0) {
            aVar.hkV.setText(aiVar.field_unReadCount);
            aVar.hkV.setVisibility(0);
            x.v("MicroMsg.BottleConversationAdapter", "has unread");
        } else {
            aVar.hkV.setVisibility(4);
            x.v("MicroMsg.BottleConversationAdapter", "no unread");
        }
        view.setBackgroundResource(R.g.mm_listitem);
        view.setPadding(paddingLeft, paddingTop, paddingRight, i2);
        return view;
    }

    final String B(ab abVar) {
        return com.tencent.mm.plugin.bottle.a.c.a(this.bGc, abVar);
    }

    private static int wW(String str) {
        int i = 1;
        if (str == null || str.length() <= 0) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    protected final void WS() {
        WT();
    }
}
