package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public final class c extends r<com.tencent.mm.ac.a.c> implements b {
    private final MMActivity bGc;
    private com.tencent.mm.ak.a.a.c hOC = null;
    protected g hkN;
    protected com.tencent.mm.ui.base.MMSlideDelView.c hkO;
    protected f hkP;
    protected d hkQ = MMSlideDelView.getItemStatusCallBack();
    private final String hpJ;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.ac.a.c cVar = (com.tencent.mm.ac.a.c) obj;
        if (cVar == null) {
            cVar = new com.tencent.mm.ac.a.c();
        }
        cVar.d(cursor);
        return cVar;
    }

    public c(Context context, a aVar, String str) {
        super(context, new com.tencent.mm.ac.a.c());
        this.tlG = aVar;
        this.bGc = (MMActivity) context;
        this.hpJ = str;
        com.tencent.mm.ak.a.a.c.a aVar2 = new com.tencent.mm.ak.a.a.c.a();
        aVar2.dXB = e.cy(this.hpJ);
        aVar2.dXy = true;
        aVar2.dXV = true;
        aVar2.dXN = R.k.default_avatar;
        this.hOC = aVar2.Pt();
    }

    public final void WT() {
        aYc();
        com.tencent.mm.ac.a.d Na = z.Na();
        String str = this.hpJ;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from BizChatInfo");
        stringBuilder.append(" where brandUserName = '").append(str).append("'");
        stringBuilder.append(" and (bitFlag & 8) != 0 ");
        StringBuilder append = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(BizChatInfo.chatNamePY) ");
        stringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatName) asc ");
        append.append(stringBuffer.toString());
        x.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", new Object[]{stringBuilder.toString()});
        setCursor(Na.diF.rawQuery(stringBuilder.toString(), null));
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

    public final void setGetViewPositionCallback(com.tencent.mm.ui.base.MMSlideDelView.c cVar) {
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
        com.tencent.mm.ac.a.c cVar = (com.tencent.mm.ac.a.c) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.bGc, R.i.enterprise_bizchat_list_item, null);
            aVar2.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            aVar2.eTm = (TextView) view.findViewById(R.h.name_tv);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        o.Pj().a(cVar.field_headImageUrl, aVar.eCl, this.hOC);
        aVar.eTm.setText(j.a(this.bGc, cVar.field_chatName, (int) aVar.eTm.getTextSize()));
        return view;
    }

    protected final void WS() {
        WT();
    }

    public final void a(int i, m mVar, Object obj) {
        super.a(i, mVar, obj);
    }
}
