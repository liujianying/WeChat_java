package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

class SnsTagPartlyUI$a extends r<t> {
    private Context context;
    final /* synthetic */ SnsTagPartlyUI obN;
    public boolean obP = false;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        t tVar = (t) obj;
        if (tVar == null) {
            tVar = new t();
            x.d("MicroMsg.SnsTagPartlyUI", "new SnsInfo");
        }
        tVar.d(cursor);
        return tVar;
    }

    public SnsTagPartlyUI$a(SnsTagPartlyUI snsTagPartlyUI, Context context) {
        this.obN = snsTagPartlyUI;
        super(context, new t());
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.context, g.partly_item_view, null);
            aVar.obQ = (TextView) view.findViewById(f.tag_name);
            aVar.obR = (TextView) view.findViewById(f.sns_tag_count);
            aVar.eOQ = (Button) view.findViewById(f.del_btn);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (qY(i)) {
            aVar.obQ.setText(j.tag_add_friend);
            aVar.obR.setVisibility(8);
            aVar.eOQ.setVisibility(8);
        } else {
            int i2;
            t tVar = (t) getItem(i);
            aVar.obQ.setText(tVar.field_tagName);
            aVar.obR.setVisibility(0);
            aVar.obR.setText(" (" + tVar.field_count + ") ");
            Button button = aVar.eOQ;
            if (this.obP) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            button.setVisibility(i2);
            aVar.eOQ.setOnClickListener(SnsTagPartlyUI.b(this.obN));
            aVar.eOQ.setTag(Integer.valueOf(i));
        }
        return view;
    }

    public final void WT() {
        setCursor(af.byu().getCursor());
        notifyDataSetChanged();
    }

    protected final void WS() {
        aYc();
        WT();
    }

    protected final int aUZ() {
        return 1;
    }
}
