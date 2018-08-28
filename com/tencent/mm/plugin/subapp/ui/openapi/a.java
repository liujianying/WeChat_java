package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class a extends BaseAdapter implements com.tencent.mm.sdk.e.j.a {
    private Context context;
    private List<f> mSx;
    boolean osC = false;
    private int osD = 0;

    public a(Context context, int i) {
        this.context = context;
        this.osD = i;
        init();
    }

    private void init() {
        int i = 0;
        this.mSx = new ArrayList();
        Cursor rawQuery = ao.bmf().rawQuery("select * from AppInfo where status = " + this.osD + " and (appType is null or appType not like ',1,')", new String[0]);
        if (rawQuery == null) {
            x.e("MicroMsg.AppInfoStorage", "getAppByStatusExcludeByType: curosr is null");
            rawQuery = null;
        }
        if (rawQuery != null) {
            int count = rawQuery.getCount();
            while (i < count) {
                rawQuery.moveToPosition(i);
                f fVar = new f();
                fVar.d(rawQuery);
                if (g.r(this.context, fVar.field_appId)) {
                    this.mSx.add(fVar);
                }
                i++;
            }
            rawQuery.close();
        }
    }

    public final void iw(boolean z) {
        this.osC = z;
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null) {
            dVar = new d();
            view = View.inflate(this.context, R.i.app_item, null);
            dVar.gxd = (ImageView) view.findViewById(R.h.appitem_icon_iv);
            dVar.osY = (TextView) view.findViewById(R.h.appitem_del_tv);
            dVar.eHU = (TextView) view.findViewById(R.h.appitem_name_tv);
            dVar.osZ = view.findViewById(R.h.appitem_new_icon);
            view.setTag(dVar);
        } else {
            dVar = (d) view.getTag();
        }
        dVar.osZ.setVisibility(4);
        if (qY(i)) {
            dVar.gxd.setVisibility(4);
            dVar.osY.setVisibility(4);
            dVar.eHU.setVisibility(4);
        } else {
            f fVar = (f) getItem(i);
            dVar.gxd.setVisibility(0);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bp.a.getDensity(this.context));
            if (b == null) {
                dVar.gxd.setBackgroundResource(R.g.app_panel_unknowed_icon);
            } else {
                dVar.gxd.setBackgroundDrawable(new BitmapDrawable(b));
            }
            dVar.eHU.setVisibility(0);
            dVar.eHU.setText(g.b(this.context, fVar, null));
            if (this.osC) {
                dVar.osY.setVisibility(0);
            } else {
                dVar.osY.setVisibility(8);
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
        init();
        super.notifyDataSetChanged();
    }
}
