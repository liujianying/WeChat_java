package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.selectcontact.a.d;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.ui.contact.a.a.a;
import com.tencent.mm.ui.contact.a.a.b;

public class j$a extends b {
    final /* synthetic */ j umV;

    public j$a(j jVar) {
        this.umV = jVar;
        super(jVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(f.select_ui_listnonlimititem, viewGroup, false);
        j.b bVar = this.umV.umU;
        bVar.eCm = (TextView) inflate.findViewById(e.title_tv);
        bVar.contentView = inflate.findViewById(e.select_item_content_layout);
        bVar.eCo = (CheckBox) inflate.findViewById(e.select_cb);
        inflate.setTag(bVar);
        return inflate;
    }

    public final void a(Context context, a aVar, a aVar2, boolean z, boolean z2) {
        j.b bVar = (j.b) aVar;
        bVar.eCm.setText(h.select_contact_nonlimit);
        bVar.eCo.setBackgroundResource(d.mm_checkbox_btn_grey_noborder);
        bVar.eCo.setChecked(z2);
        bVar.eCo.setEnabled(true);
        bVar.eCo.setVisibility(0);
        bVar.contentView.setBackgroundResource(d.comm_list_item_selector_no_divider);
    }

    public final boolean Wi() {
        return false;
    }
}
