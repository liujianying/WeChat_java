package com.tencent.mm.plugin.label.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;

class ContactLabelManagerUI$a extends BaseAdapter {
    final /* synthetic */ ContactLabelManagerUI kBk;
    ArrayList<ad> mData;

    ContactLabelManagerUI$a(ContactLabelManagerUI contactLabelManagerUI) {
        this.kBk = contactLabelManagerUI;
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    /* renamed from: rM */
    public final ad getItem(int i) {
        return (this.mData == null || i > this.mData.size()) ? null : (ad) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.kBk).inflate(R.i.contact_label_list_item, viewGroup, false);
            cVar = new c(view);
            LayoutParams layoutParams = cVar.kCf.getLayoutParams();
            layoutParams.height = (int) (((float) a.ae(this.kBk, R.f.SmallListHeight)) * a.fh(this.kBk));
            cVar.kCf.setLayoutParams(layoutParams);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        ad rM = getItem(i);
        cVar.kCe.setText(j.a(this.kBk.mController.tml, rM.field_labelName, ContactLabelManagerUI.l(this.kBk)));
        if (ContactLabelManagerUI.j(this.kBk) == null || !ContactLabelManagerUI.j(this.kBk).containsKey(Integer.valueOf(rM.field_labelID))) {
            cVar.hrM.setVisibility(0);
            cVar.hrM.setText("(0)");
        } else {
            cVar.hrM.setVisibility(0);
            cVar.hrM.setText("(" + ContactLabelManagerUI.j(this.kBk).get(Integer.valueOf(rM.field_labelID)) + ")");
        }
        return view;
    }
}
