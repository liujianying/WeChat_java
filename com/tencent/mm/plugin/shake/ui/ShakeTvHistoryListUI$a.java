package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.n;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.r;
import java.util.GregorianCalendar;

class ShakeTvHistoryListUI$a extends r<n> {
    private LayoutInflater Bc;
    final /* synthetic */ ShakeTvHistoryListUI nbu;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        n nVar = (n) obj;
        if (nVar == null) {
            nVar = new n();
        }
        nVar.d(cursor);
        return nVar;
    }

    public ShakeTvHistoryListUI$a(ShakeTvHistoryListUI shakeTvHistoryListUI, Context context) {
        this.nbu = shakeTvHistoryListUI;
        super(context, new n());
        this.Bc = LayoutInflater.from(context);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.Bc.inflate(R.i.shake_tv_history_item, viewGroup, false);
            aVar = new a(this);
            aVar.nbw = (MMImageView) view.findViewById(R.h.shake_tv_history_item_icon);
            aVar.gsY = (TextView) view.findViewById(R.h.shake_tv_history_item_title);
            aVar.kLE = (TextView) view.findViewById(R.h.shake_tv_history_item_time);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        n nVar = (n) getItem(i);
        e.a(aVar.nbw, nVar.field_iconurl, 0, true);
        aVar.gsY.setText(nVar.field_title);
        TextView textView = aVar.kLE;
        ActionBarActivity actionBarActivity = this.nbu.mController.tml;
        long j = nVar.field_createtime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? h.h(actionBarActivity.getString(R.l.fmt_longdate), j / 1000) : actionBarActivity.getString(R.l.fmt_pre_yesterday);
            } else {
                charSequence = h.h(actionBarActivity.getString(R.l.fmt_normal_time_24), j / 1000);
            }
        }
        textView.setText(charSequence);
        return view;
    }

    public final void WT() {
        setCursor(m.buE().bvi());
        super.notifyDataSetChanged();
    }

    protected final void WS() {
        WT();
    }
}
