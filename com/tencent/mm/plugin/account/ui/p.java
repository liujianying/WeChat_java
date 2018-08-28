package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.account.a$e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.g;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.o;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public final class p {
    public static o a(Context context, View view, String[] strArr, OnItemClickListener onItemClickListener) {
        View inflate = View.inflate(context, g.popup_menu, null);
        HorizontalListView horizontalListView = (HorizontalListView) inflate.findViewById(f.suggest_alias_lv);
        a aVar = new a(context, strArr);
        horizontalListView.setAdapter(aVar);
        horizontalListView.setOnItemClickListener(onItemClickListener);
        horizontalListView.setBackgroundResource(a$e.signup_chose_bg);
        o oVar = new o(inflate);
        oVar.setHeight(a.fromDPToPix(context, TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR));
        int i = 0;
        for (int i2 = 0; i2 < aVar.getCount(); i2++) {
            View view2 = aVar.getView(i2, null, horizontalListView);
            view2.measure(0, 0);
            i += view2.getMeasuredWidth();
        }
        oVar.setWidth(a.fromDPToPix(context, 20) + i);
        oVar.showAsDropDown(view, (view.getWidth() - (a.fromDPToPix(context, 20) + i)) / 2, 0);
        return oVar;
    }
}
