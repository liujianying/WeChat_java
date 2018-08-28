package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.game.f$b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.protocal.c.xy;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends BaseAdapter {
    private String bHt = "";
    private Context context;
    private LinkedList<a> dzs = new LinkedList();

    public s(Context context) {
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a rb = getItem(i);
        if (view == null) {
            view = View.inflate(this.context, f.game_search_recmd_item, null);
            b bVar2 = new b((byte) 0);
            bVar2.eGX = (TextView) view.findViewById(e.game_search_recmd_title);
            bVar2.kcn = (ViewGroup) bVar2.eGX.getParent();
            bVar2.kco = (TextView) view.findViewById(e.game_search_recmd_keyword_hot);
            bVar2.kcp = (TextView) view.findViewById(e.game_search_description);
            bVar2.kcq = (ViewGroup) bVar2.kco.getParent();
            bVar2.kcr = (TextView) view.findViewById(e.game_search_recmd_keyword);
            bVar2.kcs = (ViewGroup) bVar2.kcr.getParent().getParent();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (rb.type) {
            case 1:
                bVar.kcn.setVisibility(0);
                bVar.kcq.setVisibility(8);
                bVar.kcs.setVisibility(8);
                bVar.kcn.setOnClickListener(null);
                bVar.eGX.setText(rb.text);
                break;
            case 2:
                bVar.kcn.setVisibility(8);
                bVar.kcq.setVisibility(0);
                bVar.kcs.setVisibility(8);
                bVar.kco.setText(rb.text);
                bVar.kcp.setText(rb.description);
                break;
            case 3:
                bVar.kcn.setVisibility(8);
                bVar.kcq.setVisibility(8);
                bVar.kcs.setVisibility(0);
                bVar.kcr.setTextColor(this.context.getResources().getColor(f$b.normal_text_color));
                int color = this.context.getResources().getColor(f$b.gc_search_recmd_keyword_match);
                int indexOf = rb.text.indexOf(this.bHt);
                if (indexOf < 0) {
                    bVar.kcr.setText(rb.text);
                    break;
                }
                CharSequence spannableString = new SpannableString(rb.text);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.bHt.length() + indexOf, 33);
                bVar.kcr.setText(spannableString);
                break;
        }
        return view;
    }

    public final int getCount() {
        return this.dzs.size();
    }

    /* renamed from: rb */
    public final a getItem(int i) {
        return (a) this.dzs.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void a(String str, String str2, LinkedList<xy> linkedList) {
        if (!bi.cX(linkedList)) {
            this.bHt = str;
            this.dzs.clear();
            if (bi.oW(str)) {
                a aVar = new a();
                aVar.type = 1;
                if (bi.oW(str2)) {
                    aVar.text = this.context.getString(i.game_search_recmd_title);
                } else {
                    aVar.text = str2;
                }
                this.dzs.add(aVar);
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                xy xyVar = (xy) it.next();
                a aVar2 = new a();
                aVar2.type = bi.oW(str) ? 2 : 3;
                aVar2.appId = xyVar.jPc;
                aVar2.text = xyVar.rDO;
                aVar2.description = xyVar.rej;
                aVar2.actionType = xyVar.rDF;
                aVar2.kcm = xyVar.rDG;
                this.dzs.add(aVar2);
            }
            notifyDataSetChanged();
        }
    }
}
