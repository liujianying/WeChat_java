package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.be.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

class NearbySayHiListUI$a extends r<ba> {
    private MMActivity bGc;
    protected g hkN;
    protected c hkO;
    protected d hkQ = MMSlideDelView.getItemStatusCallBack();
    final /* synthetic */ NearbySayHiListUI lCB;
    protected f lCE;
    private bb lCu;
    int limit = -1;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        ba baVar = (ba) obj;
        if (baVar == null) {
            baVar = new ba();
        }
        baVar.d(cursor);
        return baVar;
    }

    public NearbySayHiListUI$a(NearbySayHiListUI nearbySayHiListUI, Context context, bb bbVar, int i) {
        this.lCB = nearbySayHiListUI;
        super(context, new ba());
        this.bGc = (MMActivity) context;
        this.limit = i;
        this.lCu = bbVar;
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(f fVar) {
        this.lCE = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        bb bbVar;
        if (a.cbf()) {
            bbVar = this.lCu;
            int i = this.limit;
            setCursor(bbVar.diF.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + bbVar.getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i) + ") b left join " + bbVar.getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i, null));
        } else {
            bbVar = this.lCu;
            setCursor(bbVar.diF.rawQuery("SELECT * FROM " + bbVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.limit, null));
        }
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        ba baVar = (ba) getItem(i);
        if (view == null) {
            a aVar2 = new a(this);
            MMSlideDelView mMSlideDelView = (MMSlideDelView) View.inflate(this.bGc, R.i.base_slide_del_view, null);
            View inflate = View.inflate(this.bGc, R.i.say_hi_item, null);
            aVar2.eBM = (ImageView) inflate.findViewById(R.h.contactitem_avatar_iv);
            aVar2.eIz = (TextView) inflate.findViewById(R.h.display_name);
            aVar2.laT = (TextView) inflate.findViewById(R.h.sayhi_content);
            aVar2.hkW = mMSlideDelView.findViewById(R.h.slide_del_del_view);
            aVar2.hkX = (TextView) mMSlideDelView.findViewById(R.h.slide_del_view_del_word);
            mMSlideDelView.setView(inflate);
            mMSlideDelView.setPerformItemClickListener(this.hkN);
            mMSlideDelView.setGetViewPositionCallback(this.hkO);
            mMSlideDelView.setItemStatusCallBack(this.hkQ);
            mMSlideDelView.setEnable(false);
            mMSlideDelView.setTag(aVar2);
            aVar = aVar2;
            view = mMSlideDelView;
        } else {
            aVar = (a) view.getTag();
        }
        if (baVar.field_flag != 0) {
            charSequence = bd.d.YY(baVar.field_content).nickname;
        } else {
            charSequence = baVar.field_talker;
        }
        aVar.eIz.setText(j.a(this.bGc, charSequence, aVar.eIz.getTextSize()));
        aVar.laT.setText(j.a(this.bGc, baVar.field_sayhicontent, aVar.laT.getTextSize()));
        aVar.hkW.setTag(Long.valueOf(baVar.field_svrid));
        aVar.hkW.setOnClickListener(new 1(this));
        b.a(aVar.eBM, baVar.field_sayhiuser);
        return view;
    }
}
