package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import java.util.List;

public final class b extends BaseAdapter implements a {
    private Context context;
    private List<f> mSx;
    boolean osC = false;

    public b(Context context, List<f> list) {
        this.context = context;
        this.mSx = list;
    }

    public final void iw(boolean z) {
        this.osC = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            cVar = new c();
            view = View.inflate(this.context, R.i.app_item, null);
            cVar.gxd = (ImageView) view.findViewById(R.h.appitem_icon_iv);
            cVar.osY = (TextView) view.findViewById(R.h.appitem_del_tv);
            cVar.eHU = (TextView) view.findViewById(R.h.appitem_name_tv);
            cVar.osZ = view.findViewById(R.h.appitem_new_icon);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        cVar.osZ.setVisibility(4);
        if (qY(i)) {
            cVar.gxd.setVisibility(4);
            cVar.osY.setVisibility(4);
            cVar.eHU.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            cVar.gxd.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 5, com.tencent.mm.bp.a.getDensity(this.context));
            if (b == null) {
                cVar.gxd.setBackgroundResource(R.g.app_panel_unknowed_icon);
            } else {
                cVar.gxd.setBackgroundDrawable(new BitmapDrawable(b));
            }
            cVar.eHU.setVisibility(0);
            cVar.eHU.setText(g.b(this.context, fVar, null));
            if (this.osC) {
                cVar.osY.setVisibility(0);
            } else {
                cVar.osY.setVisibility(8);
            }
        }
        return view;
    }

    public final int getCount() {
        return aFL() + aUZ();
    }

    public final boolean qY(int i) {
        int size = this.mSx.size();
        return i >= size && i < size + aUZ();
    }

    public final Object getItem(int i) {
        if (qY(i)) {
            return null;
        }
        return this.mSx.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    private int aFL() {
        return this.mSx.size();
    }

    private int aUZ() {
        return (4 - (aFL() % 4)) % 4;
    }

    public final void a(String str, l lVar) {
        notifyDataSetChanged();
    }
}
