package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.d.a;
import com.tencent.mm.ui.contact.a.d.b;

public class a$a extends b {
    final /* synthetic */ a lvf;

    public a$a(a aVar) {
        this.lvf = aVar;
        super(aVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.i.multitalk_listcontactitem, viewGroup, false);
        a aVar = (a) a.a(this.lvf);
        aVar.eCl = (ImageView) inflate.findViewById(R.h.avatar_iv);
        aVar.eCm = (TextView) inflate.findViewById(R.h.title_tv);
        aVar.eCn = (TextView) inflate.findViewById(R.h.desc_tv);
        aVar.contentView = inflate.findViewById(R.h.select_item_content_layout);
        aVar.eCo = (CheckBox) inflate.findViewById(R.h.select_cb);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
        a aVar3 = (a) aVar;
        d dVar = (d) aVar2;
        if (dVar.username == null || dVar.username.length() <= 0) {
            aVar3.eCl.setImageResource(R.g.default_avatar);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(aVar3.eCl, dVar.username);
        }
        m.a(dVar.eCh, aVar3.eCm);
        if (this.lvf.ujX) {
            if (z) {
                aVar3.eCo.setChecked(true);
                aVar3.eCo.setEnabled(false);
            } else {
                aVar3.eCo.setChecked(z2);
                aVar3.eCo.setEnabled(true);
            }
            aVar3.eCo.setVisibility(0);
            return;
        }
        aVar3.eCo.setVisibility(8);
    }
}
