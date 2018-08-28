package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

class Sort3rdAppUI$a extends ArrayAdapter<f> {
    private c iAs;
    List<f> idD;
    private Context mContext;
    private long seU;

    public Sort3rdAppUI$a(Context context, List<f> list, long j) {
        super(context, R.i.sort_3rd_app_ui_item, list);
        this.seU = j;
        this.mContext = context;
        this.idD = list;
        a aVar = new a();
        aVar.dXN = R.g.my_device_default_icon;
        this.iAs = aVar.Pt();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        boolean z = true;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.sort_3rd_app_ui_item, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i);
        aVar.eCm.setText(fVar.field_appName);
        Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bp.a.getDensity(this.mContext));
        if (b == null || b.isRecycled()) {
            o.Pj().a(fVar.field_appIconUrl, aVar.gmn, this.iAs);
        } else {
            aVar.gmn.setImageBitmap(b);
        }
        MMSwitchBtn mMSwitchBtn = aVar.kAq;
        if ((fVar.field_appInfoFlag & 16384) != 0) {
            z = false;
        }
        mMSwitchBtn.setCheck(z);
        aVar.kAq.setSwitchListener(new 1(this, fVar));
        view.setVisibility(0);
        return view;
    }
}
