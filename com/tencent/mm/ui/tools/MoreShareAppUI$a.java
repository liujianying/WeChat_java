package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import java.util.List;

class MoreShareAppUI$a extends ArrayAdapter<f> {
    private List<f> idD;
    private Context mContext;

    public MoreShareAppUI$a(Context context, List<f> list) {
        super(context, R.i.more_share_app_list_item, list);
        this.mContext = context;
        this.idD = list;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.more_share_app_list_item, null);
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eCm.setText(((f) getItem(i)).field_appName);
        view.setVisibility(0);
        return view;
    }
}
