package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.r;

public class SelectMemberChattingRecordUI$a extends r<bd> {
    int edl = -1;
    String gBf;
    final /* synthetic */ SelectMemberChattingRecordUI hPm;
    String hPn;
    int hPo = -1;
    private u hPp;
    Context mContext;

    public SelectMemberChattingRecordUI$a(SelectMemberChattingRecordUI selectMemberChattingRecordUI, Context context, String str, String str2, int i) {
        this.hPm = selectMemberChattingRecordUI;
        super(context, new bd());
        this.mContext = context;
        this.edl = i;
        this.gBf = str;
        this.hPn = str2;
        au.HU();
        this.hPp = c.Ga().ii(SelectMemberChattingRecordUI.b(selectMemberChattingRecordUI));
    }

    public final void WT() {
        if (this.hPo < 0 || this.hPo > this.edl) {
            this.hPo = this.edl - 16;
        }
        if (!bi.oW(SelectMemberChattingRecordUI.c(this.hPm)) && q.gQ(SelectMemberChattingRecordUI.c(this.hPm))) {
            au.HU();
            setCursor(c.FT().bG(this.gBf, this.edl - this.hPo));
        } else if (!q.gQ(SelectMemberChattingRecordUI.c(this.hPm))) {
            au.HU();
            setCursor(c.FT().E(this.gBf, this.hPn, this.edl - this.hPo));
        }
    }

    protected final void WS() {
        WT();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SelectMemberChattingRecordUI$b selectMemberChattingRecordUI$b;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.member_record_item, null, false);
            selectMemberChattingRecordUI$b = new SelectMemberChattingRecordUI$b();
            selectMemberChattingRecordUI$b.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            selectMemberChattingRecordUI$b.eTm = (TextView) view.findViewById(R.h.nickname_tv);
            selectMemberChattingRecordUI$b.hPq = (TextView) view.findViewById(R.h.msg_tv);
            selectMemberChattingRecordUI$b.hrs = (TextView) view.findViewById(R.h.update_time_tv);
            view.setTag(selectMemberChattingRecordUI$b);
        }
        bd bdVar = (bd) getItem(i);
        selectMemberChattingRecordUI$b = (SelectMemberChattingRecordUI$b) view.getTag();
        b.a(selectMemberChattingRecordUI$b.eCl, this.hPn);
        String str = this.hPn;
        au.HU();
        ab Yg = c.FR().Yg(str);
        CharSequence a = !bi.oW(Yg.field_conRemark) ? Yg.field_conRemark : SelectMemberChattingRecordUI.a(this.hPp, Yg.field_username);
        if (bi.oW(a)) {
            a = Yg.BK();
        }
        if (!a.gd(Yg.field_type)) {
            au.HU();
            bq Hh = c.FS().Hh(Yg.field_username);
            if (!(Hh == null || bi.oW(Hh.field_conRemark))) {
                a = Hh.field_conRemark;
            }
        }
        a(a, selectMemberChattingRecordUI$b.eTm);
        a(SelectMemberChattingRecordUI.a(ad.getContext(), bdVar.getType(), bdVar.field_content, this.hPn, bdVar.field_isSend).trim(), selectMemberChattingRecordUI$b.hPq);
        a(h.c(this.hPm, bdVar.field_createTime, true), selectMemberChattingRecordUI$b.hrs);
        return view;
    }

    private static boolean a(CharSequence charSequence, TextView textView) {
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return false;
        }
        textView.setText(j.a(textView.getContext(), charSequence));
        textView.setVisibility(0);
        return true;
    }
}
