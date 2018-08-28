package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;

final class b extends r<bo> {
    private MMActivity bGc;
    protected g hkN;
    protected c hkO;
    protected d hkQ = MMSlideDelView.getItemStatusCallBack();
    protected f lCE;
    private int limit = -1;
    private bp mZg;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        bo boVar = (bo) obj;
        if (boVar == null) {
            boVar = new bo();
        }
        boVar.d(cursor);
        return boVar;
    }

    public b(Context context, bp bpVar, int i) {
        super(context, new bo());
        this.bGc = (MMActivity) context;
        this.limit = i;
        this.mZg = bpVar;
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

    public final void vZ(int i) {
        aYc();
        this.limit = i;
        WT();
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        bp bpVar = this.mZg;
        setCursor(bpVar.diF.rawQuery("SELECT * FROM " + bpVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.limit, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        bo boVar = (bo) getItem(i);
        if (view == null) {
            View view2 = (MMSlideDelView) View.inflate(this.bGc, R.i.base_slide_del_view, null);
            a aVar2 = new a();
            View inflate = View.inflate(this.bGc, R.i.say_hi_item, null);
            aVar2.eBM = (ImageView) inflate.findViewById(R.h.contactitem_avatar_iv);
            aVar2.eIz = (TextView) inflate.findViewById(R.h.display_name);
            aVar2.laT = (TextView) inflate.findViewById(R.h.sayhi_content);
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
        aVar.hkW.setTag(Long.valueOf(boVar.field_svrid));
        aVar.hkW.setOnClickListener(new 1(this));
        aVar.eIz.setText(j.a(this.bGc, bd.d.YY(boVar.field_content).getDisplayName(), aVar.eIz.getTextSize()));
        aVar.laT.setText(boVar.field_sayhicontent);
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eBM, boVar.field_sayhiuser);
        return view;
    }
}
