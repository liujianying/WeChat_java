package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.storage.z;
import java.util.List;

class SnsSelectContactDialog$a extends BaseAdapter {
    private Context context;
    private List<String> dEw;
    private int nKI = 0;
    final /* synthetic */ SnsSelectContactDialog nZA;
    private int type;

    public SnsSelectContactDialog$a(SnsSelectContactDialog snsSelectContactDialog, Context context, int i) {
        this.nZA = snsSelectContactDialog;
        this.dEw = i;
        this.context = context;
        this.type = 0;
        refresh();
    }

    public final void refresh() {
        if (this.dEw == null) {
            this.nKI = 0;
        } else {
            this.nKI = this.dEw.size();
        }
        this.nKI++;
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.nKI;
    }

    public final Object getItem(int i) {
        return this.dEw.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        SnsSelectContactDialog$b snsSelectContactDialog$b;
        View inflate;
        if (view == null) {
            snsSelectContactDialog$b = new SnsSelectContactDialog$b();
            if (this.type == 0) {
                inflate = View.inflate(this.context, g.sns_upload_alert_item, null);
            } else {
                inflate = View.inflate(this.context, g.sns_alert_item, null);
            }
            snsSelectContactDialog$b.ilX = (ImageView) inflate.findViewById(f.image);
            snsSelectContactDialog$b.nZB = (ImageView) inflate.findViewById(f.item_del);
            inflate.setTag(snsSelectContactDialog$b);
        } else {
            snsSelectContactDialog$b = (SnsSelectContactDialog$b) view.getTag();
            inflate = view;
        }
        inflate.setVisibility(0);
        if (i == this.nKI - 1) {
            snsSelectContactDialog$b.ilX.setBackgroundDrawable(null);
            snsSelectContactDialog$b.ilX.setImageResource(e.sns_add_item);
            snsSelectContactDialog$b.nZB.setVisibility(8);
            if (this.dEw.size() >= z.sOr) {
                inflate.setVisibility(8);
            }
        } else {
            snsSelectContactDialog$b.ilX.setBackgroundDrawable(null);
            snsSelectContactDialog$b.nZB.setVisibility(0);
            if (this.type == 0) {
                b.a(snsSelectContactDialog$b.ilX, (String) this.dEw.get(i));
            } else {
                snsSelectContactDialog$b.ilX.setImageBitmap(c.e((String) this.dEw.get(i), af.byw(), af.byw(), true));
            }
        }
        snsSelectContactDialog$b.ilX.setScaleType(ScaleType.CENTER_CROP);
        return inflate;
    }
}
