package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView$d;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.y;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

class IPCallMsgUI$a extends r<g> {
    int edl = this.hFO;
    int hFO = 10;
    protected MMSlideDelView.g hkN;
    protected c hkO;
    protected MMSlideDelView$d hkQ = new MMSlideDelView$d() {
        public final void a(MMSlideDelView mMSlideDelView, boolean z) {
            if (z) {
                kwC.add(mMSlideDelView);
            } else {
                kwC.remove(mMSlideDelView);
            }
        }

        public final boolean aYk() {
            return kwC.size() > 0;
        }

        public final void aYl() {
            for (MMSlideDelView mMSlideDelView : kwC) {
                if (mMSlideDelView != null) {
                    mMSlideDelView.crM();
                }
            }
            kwC.clear();
        }

        public final void aYm() {
            for (MMSlideDelView mMSlideDelView : kwC) {
                if (mMSlideDelView != null) {
                    mMSlideDelView.crL();
                }
            }
            kwC.clear();
        }
    };
    final /* synthetic */ IPCallMsgUI kwA;
    private Set<MMSlideDelView> kwC = new HashSet();

    public IPCallMsgUI$a(IPCallMsgUI iPCallMsgUI, Context context, g gVar) {
        this.kwA = iPCallMsgUI;
        super(context, gVar);
    }

    public final long getItemId(int i) {
        return ((g) getItem(i)).sKx;
    }

    protected final void WS() {
        aYc();
        WT();
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.hkN = gVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    public final synchronized void a(String str, l lVar) {
        super.a(str, lVar);
    }

    public final void WT() {
        this.edl = i.aXy().getCount();
        h aXy = i.aXy();
        int i = this.hFO;
        setCursor(aXy.diF.query("IPCallMsg", h.ksE, null, null, null, null, "pushTime desc limit " + i));
        notifyDataSetChanged();
    }

    public final boolean ayQ() {
        return this.hFO >= this.edl;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        g gVar = (g) getItem(i);
        if (view == null || !(view.getTag() instanceof a)) {
            view = y.gq(this.context).inflate(R.i.ipcall_msg_item, null);
            aVar = new a(this);
            aVar.eBO = (TextView) view.findViewById(R.h.titleTv);
            aVar.eZj = (TextView) view.findViewById(R.h.contentTv);
            aVar.hrV = (TextView) view.findViewById(R.h.timeTv);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eBO.setText(gVar.field_title);
        aVar.eZj.setText(gVar.field_content);
        TextView textView = aVar.hrV;
        ActionBarActivity actionBarActivity = this.kwA.mController.tml;
        long j = gVar.field_pushTime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        String str = (String) DateFormat.format(actionBarActivity.getString(R.l.fmt_date), j);
        if (str.indexOf("-") > 0) {
            charSequence = (str.split("-")[1] + " " + com.tencent.mm.plugin.ipcall.b.c.aA(actionBarActivity, str.split("-")[0]) + " ") + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(actionBarActivity, j));
        } else {
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? str + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(actionBarActivity, j)) : actionBarActivity.getString(R.l.fmt_pre_yesterday) + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.h(actionBarActivity, j));
            } else {
                charSequence = ((String) com.tencent.mm.plugin.ipcall.b.c.h(actionBarActivity, j));
            }
        }
        textView.setText(charSequence);
        if ((gVar.field_isRead == (short) 1 ? 1 : null) != null) {
            aVar.eBO.setTextColor(this.kwA.getResources().getColor(R.e.ipcall_msg_ui_has_read_color));
        } else {
            aVar.eBO.setTextColor(this.kwA.getResources().getColor(R.e.ipcall_msg_ui_not_read_color));
        }
        return view;
    }
}
