package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.selectcontact.a$f;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.pluginsdk.ui.a.b;

public class e$b extends a$b {
    final /* synthetic */ e umG;

    public e$b(e eVar) {
        this.umG = eVar;
        super(eVar);
    }

    public final View a(Context context, ViewGroup viewGroup) {
        View inflate;
        if (a.fi(context)) {
            inflate = LayoutInflater.from(context).inflate(a$f.select_ui_listcontactitem_large, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(context).inflate(a$f.select_ui_listcontactitem, viewGroup, false);
        }
        e.a aVar = this.umG.umF;
        aVar.eCl = (ImageView) inflate.findViewById(e.avatar_iv);
        aVar.eTm = (TextView) inflate.findViewById(e.title_tv);
        aVar.eCn = (TextView) inflate.findViewById(e.desc_tv);
        aVar.eCn.setVisibility(8);
        aVar.eCo = (CheckBox) inflate.findViewById(e.select_cb);
        inflate.setTag(aVar);
        return inflate;
    }

    public final void a(Context context, a.a aVar, a aVar2, boolean z, boolean z2) {
        e eVar = (e) aVar2;
        e.a aVar3 = (e.a) aVar;
        if (this.umG.umD == 0 || this.umG.umC == null) {
            m.a(eVar.eCh, aVar3.eTm);
            b.a(aVar3.eCl, eVar.username);
            if (this.umG.ujX) {
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
            return;
        }
        aVar3.eCl.setImageResource(this.umG.umD);
        aVar3.eTm.setText(this.umG.umC);
    }

    public final boolean Wi() {
        return false;
    }
}
