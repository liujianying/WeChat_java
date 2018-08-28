package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context context;
    List<k> dataList = new ArrayList();
    int mode;

    private class a {
        public ImageView eBM;
        public TextView eBN;
        public TextView eBO;
        public TextView eBP;
        public TextView eBQ;
        public TextView eBR;

        public a(View view) {
            this.eBM = (ImageView) view.findViewById(f.aa_query_list_item_avatar);
            this.eBN = (TextView) view.findViewById(f.aa_query_list_item_chatroom);
            this.eBO = (TextView) view.findViewById(f.aa_query_list_item_title);
            this.eBP = (TextView) view.findViewById(f.aa_query_list_item_date);
            this.eBQ = (TextView) view.findViewById(f.aa_query_list_item_amount);
            this.eBR = (TextView) view.findViewById(f.aa_query_list_item_status);
        }
    }

    public b(Context context, int i) {
        this.context = context;
        this.mode = i;
    }

    public final int getCount() {
        return this.dataList.size();
    }

    public final Object getItem(int i) {
        return this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = y.gq(this.context).inflate(g.aa_query_list_item, viewGroup, false);
            view.setTag(new a(view));
        }
        a aVar = (a) view.getTag();
        k kVar = (k) getItem(i);
        aVar.eBM.setImageResource(h.aa_record_default_icon);
        com.tencent.mm.pluginsdk.ui.a.b.g(aVar.eBM, kVar.qYd, h.aa_record_default_icon);
        aVar.eBO.setText(j.a(this.context, kVar.title, aVar.eBO.getTextSize()));
        CharSequence gT = ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.a.b.class)).gT(kVar.qYd);
        if (bi.oW(gT) || gT.endsWith("@chatroom")) {
            gT = this.context.getString(a$i.aa_chatting_roominfo_noname);
        }
        aVar.eBN.setText(j.a(this.context, gT, aVar.eBN.getTextSize()));
        if (this.mode == 2) {
            aVar.eBP.setText(kVar.qYp);
        } else {
            aVar.eBP.setText(kVar.qYm);
        }
        aVar.eBQ.setText(String.format("%s%s", new Object[]{Float.valueOf(((float) kVar.cfh) / 100.0f), this.context.getString(a$i.aa_yuan)}));
        aVar.eBR.setVisibility(0);
        if (this.mode != 2) {
            switch (kVar.state) {
                case 1:
                    aVar.eBR.setText(a$i.aa_list_record_status_part);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(c.aa_query_list_hint_color));
                    break;
                case 2:
                    aVar.eBR.setText(a$i.aa_list_record_status_finish);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(c.aa_query_list_hint_color));
                    break;
                case 3:
                    aVar.eBR.setText(a$i.aa_list_record_status_close);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(c.red));
                    break;
                case 4:
                    aVar.eBR.setText(a$i.aa_list_record_status_expire);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(c.red));
                    break;
                default:
                    aVar.eBR.setVisibility(4);
                    break;
            }
        }
        switch (kVar.state) {
            case 1:
                aVar.eBR.setText(a$i.aa_list_record_status_unpaied);
                aVar.eBR.setTextColor(this.context.getResources().getColor(c.aa_query_list_hint_color));
                break;
            case 2:
                aVar.eBR.setText(a$i.aa_list_record_status_paied);
                aVar.eBR.setTextColor(this.context.getResources().getColor(c.aa_query_list_hint_color));
                break;
            default:
                aVar.eBR.setVisibility(4);
                break;
        }
        return view;
    }

    public final void Wf() {
        this.dataList.clear();
    }
}
