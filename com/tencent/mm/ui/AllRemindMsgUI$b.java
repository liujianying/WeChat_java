package com.tencent.mm.ui;

import android.support.v7.widget.RecyclerView$t;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.AllRemindMsgUI.d;

class AllRemindMsgUI$b extends a {
    final /* synthetic */ AllRemindMsgUI tgf;

    AllRemindMsgUI$b(AllRemindMsgUI allRemindMsgUI) {
        this.tgf = allRemindMsgUI;
    }

    public final RecyclerView$t a(ViewGroup viewGroup, int i) {
        return new AllRemindMsgUI$c(this.tgf, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.remind_item, viewGroup, false));
    }

    public final void a(RecyclerView$t recyclerView$t, int i) {
        d dVar = (d) AllRemindMsgUI.d(this.tgf).get(i);
        ((AllRemindMsgUI$c) recyclerView$t).SU.setTag(dVar);
        ((AllRemindMsgUI$c) recyclerView$t).mVa.setText(j.a(this.tgf.mController.tml, dVar.nickname, ((AllRemindMsgUI$c) recyclerView$t).mVa.getTextSize()));
        ((AllRemindMsgUI$c) recyclerView$t).eBO.setText(j.a(this.tgf.mController.tml, dVar.title, ((AllRemindMsgUI$c) recyclerView$t).eBO.getTextSize()));
        long currentTimeMillis = System.currentTimeMillis();
        if (dVar.timestamp - currentTimeMillis < 60000) {
            ((AllRemindMsgUI$c) recyclerView$t).tgi.setText(this.tgf.mController.tml.getString(R.l.fmt_in_some_min, new Object[]{Integer.valueOf(1)}));
        } else if (dVar.timestamp - currentTimeMillis < 3600000) {
            ((AllRemindMsgUI$c) recyclerView$t).tgi.setText(this.tgf.mController.tml.getString(R.l.fmt_in_some_min, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 60000)}));
        } else if (dVar.timestamp - currentTimeMillis < 10800000) {
            ((AllRemindMsgUI$c) recyclerView$t).tgi.setText(this.tgf.mController.tml.getString(R.l.fmt_in_some_hour_min, new Object[]{Long.valueOf((dVar.timestamp - currentTimeMillis) / 3600000), Long.valueOf(((dVar.timestamp - currentTimeMillis) - (((dVar.timestamp - currentTimeMillis) / 3600000) * 3600000)) / 60000)}));
        } else {
            ((AllRemindMsgUI$c) recyclerView$t).tgi.setText(h.c(this.tgf.mController.tml, dVar.timestamp, true));
        }
        if (dVar.bID == 2) {
            ((AllRemindMsgUI$c) recyclerView$t).eKk.setImageDrawable(this.tgf.mController.tml.getResources().getDrawable(R.g.app_add_to_favorite));
        } else {
            b.a(((AllRemindMsgUI$c) recyclerView$t).eKk, dVar.username);
        }
    }

    public final int getItemCount() {
        return AllRemindMsgUI.d(this.tgf) == null ? 0 : AllRemindMsgUI.d(this.tgf).size();
    }
}
