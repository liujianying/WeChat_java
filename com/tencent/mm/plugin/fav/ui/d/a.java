package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.i;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.protocal.c.wr;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;

public abstract class a {
    protected k iYh = null;
    public final a jem = new a();

    public abstract View a(View view, ViewGroup viewGroup, g gVar);

    public abstract void a(View view, wn wnVar);

    public a(k kVar) {
        this.iYh = kVar;
    }

    protected final View a(View view, b bVar, g gVar) {
        if (view == null) {
            throw new NullPointerException("base item view is null");
        }
        bVar.jep = view.findViewById(e.fav_type_layout);
        if (bVar.jep == null) {
            throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
        }
        bVar.eMe = (TextView) view.findViewById(e.fav_name);
        if (bVar.eMe == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_name");
        }
        bVar.hrs = (TextView) view.findViewById(e.fav_time);
        if (bVar.hrs == null) {
            throw new IllegalArgumentException("base item view do not contain id named fav_time");
        }
        bVar.eCo = (CheckBox) view.findViewById(e.fav_checkbox);
        if (bVar.eCo == null) {
            throw new IllegalArgumentException("base item view do not contain id named checkbox");
        }
        bVar.jeq = (ImageView) view.findViewById(e.fav_tag_iv);
        if (bVar.jeq == null) {
            throw new IllegalArgumentException("base item view do not contain id named tagIV");
        }
        bVar.eCo.setOnCheckedChangeListener(new 1(this));
        bVar.iWQ = gVar;
        view.setTag(bVar);
        bVar.jer = (LinearLayout) view.findViewById(e.fav_sync_error_ll);
        bVar.jes = (TextView) view.findViewById(e.fav_sync_error_btn);
        bVar.jes.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                x.d("MicroMsg.FavBaseListItem", "manual restart upload");
                if (view.getTag() instanceof g) {
                    b.l((g) view.getTag());
                }
            }
        });
        return view;
    }

    protected final void a(b bVar, g gVar) {
        bVar.iWQ = gVar;
        if (bVar.iWQ.field_type == 18) {
            bVar.jep.setVisibility(0);
        } else {
            bVar.jep.setVisibility(8);
        }
        if (this.jem.jbQ) {
            bVar.hrs.setText(b.dp(bVar.iWQ.field_datatotalsize));
        } else {
            bVar.hrs.setText(i.f(bVar.hrs.getContext(), bVar.iWQ.field_updateTime));
        }
        Context context = bVar.eMe.getContext();
        ab Yf = ((com.tencent.mm.plugin.messenger.foundation.a.i) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yf(bVar.iWQ.field_fromUser);
        if (Yf == null || !Yf.field_username.equals(bVar.iWQ.field_fromUser)) {
            x.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[]{bVar.iWQ.field_fromUser});
            bVar.eMe.setText("");
            com.tencent.mm.model.am.a.dBr.a(bVar.iWQ.field_fromUser, "", null);
        } else {
            CharSequence Bc;
            if (s.fq(bVar.iWQ.field_fromUser)) {
                wr wrVar = bVar.iWQ.field_favProto.rBG;
                Bc = q.GF().equals(wrVar.bSS) ? b.Bc(wrVar.toUser) : ((com.tencent.mm.plugin.messenger.a.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.messenger.a.b.class)).gS(wrVar.bSS);
            } else {
                Bc = b.Bc(Yf.field_username);
            }
            bVar.eMe.setText(j.a(context, Bc, bVar.eMe.getTextSize()));
        }
        if (bVar.iWQ.aLg()) {
            bVar.jer.setVisibility(0);
        } else {
            bVar.jer.setVisibility(8);
        }
        bVar.eCo.setTag(gVar);
        if (this.jem.jbI || this.jem.jbQ) {
            boolean z;
            bVar.eCo.setVisibility(0);
            CheckBox checkBox = bVar.eCo;
            if (this.jem.jbJ.get(Long.valueOf(gVar.field_localId)) != null) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
        } else {
            bVar.eCo.setVisibility(8);
        }
        bVar.jes.setTag(gVar);
        if (gVar.field_tagProto.rBX == null || gVar.field_tagProto.rBX.isEmpty()) {
            bVar.jeq.setVisibility(8);
        } else {
            bVar.jeq.setVisibility(0);
        }
    }
}
