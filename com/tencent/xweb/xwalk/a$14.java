package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import org.xwalk.core.R;

class a$14 implements OnClickListener {
    final /* synthetic */ a vEm;

    a$14(a aVar) {
        this.vEm = aVar;
    }

    public final void onClick(View view) {
        LinearLayout linearLayout = (LinearLayout) this.vEm.vEj.findViewById(R.id.config_memu);
        if (linearLayout.getVisibility() == 8) {
            linearLayout.setVisibility(0);
            ((Button) view).setText("隐藏高级设置");
            return;
        }
        linearLayout.setVisibility(8);
        ((Button) view).setText("高级设置");
    }
}
