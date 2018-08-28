package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.r;

public final class v extends r<bd> {
    private String dIc;
    private String hnS;
    private boolean tGg;
    public a tLf;
    public String talker;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        bd bdVar = (bd) obj;
        if (bdVar == null) {
            bdVar = new bd();
        }
        bdVar.d(cursor);
        return bdVar;
    }

    public v(Context context, bd bdVar, String str, String str2, boolean z) {
        super(context, bdVar);
        this.talker = str;
        this.dIc = str2;
        this.tGg = z;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.search_chat_content_item, null);
            bVar = new b((byte) 0);
            bVar.eCl = (ImageView) view.findViewById(R.h.avatar_iv);
            bVar.eTm = (TextView) view.findViewById(R.h.nickname_tv);
            bVar.hkS = (TextView) view.findViewById(R.h.update_time_tv);
            bVar.tLg = (TextView) view.findViewById(R.h.msg_tv);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bd bdVar = (bd) getItem(i);
        if (bdVar != null) {
            if (this.tGg && bdVar.field_isSend == 0) {
                String str = bdVar.field_content;
                String iB = com.tencent.mm.model.bd.iB(str);
                if (!ai.oW(iB)) {
                    b.a(bVar.eCl, iB);
                    bVar.eTm.setText(j.a(this.context, com.tencent.mm.model.r.gT(iB), bVar.eTm.getTextSize()));
                }
                bVar.hkS.setText(aE(bdVar));
                bVar.tLg.setText(j.a(this.context, com.tencent.mm.model.bd.iC(str), bVar.tLg.getTextSize()));
            } else {
                b.a(bVar.eCl, aD(bdVar));
                bVar.eTm.setText(j.a(this.context, com.tencent.mm.model.r.gT(aD(bdVar)), bVar.eTm.getTextSize()));
                bVar.hkS.setText(aE(bdVar));
                bVar.tLg.setText(j.a(this.context, bdVar.field_content, bVar.tLg.getTextSize()));
            }
        }
        return view;
    }

    public final void pi(String str) {
        this.hnS = str;
        if (!ai.oW(this.hnS)) {
            aYc();
            WT();
        }
    }

    private String aD(bd bdVar) {
        return bdVar.field_isSend == 1 ? this.dIc : this.talker;
    }

    public final void WT() {
        au.HU();
        setCursor(c.FT().dH(this.talker, this.hnS));
        if (!(this.tLf == null || ai.oW(this.hnS))) {
            this.tLf.ET(getCount());
        }
        super.notifyDataSetChanged();
    }

    protected final void WS() {
        aYc();
        WT();
    }

    private CharSequence aE(bd bdVar) {
        return bdVar.field_createTime == Long.MAX_VALUE ? "" : h.c(this.context, bdVar.field_createTime, true);
    }
}
