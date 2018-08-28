package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;

class e$a {
    TextView eCm;
    ImageView gmn;
    View idE;
    ImageView idF;
    final /* synthetic */ e idG;

    public e$a(e eVar, View view) {
        this.idG = eVar;
        this.idF = (ImageView) view.findViewById(R.h.emoji_store_manager_list_item_updonw);
        this.gmn = (ImageView) view.findViewById(R.h.emoji_store_manager_list_item_icon);
        this.eCm = (TextView) view.findViewById(R.h.emoji_store_manager_list_item_title);
        this.idE = view.findViewById(R.h.emoji_item_container);
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = e.a(eVar);
            view.setLayoutParams(layoutParams);
        }
    }
}
