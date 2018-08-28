package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.d;

class a$7 implements OnTouchListener {
    final /* synthetic */ a hqX;

    a$7(a aVar) {
        this.hqX = aVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                a.c(this.hqX, (int) motionEvent.getRawX());
                a.d(this.hqX, (int) motionEvent.getRawY());
                if (view instanceof BizAvatarLayout) {
                    ((TextView) view.findViewById(d.nick_name_tv)).setTextColor(a.b(this.hqX).getResources().getColor(a.normal_text_color));
                    break;
                }
                break;
            case 1:
                if ((view instanceof BizAvatarLayout) && (view instanceof BizAvatarLayout)) {
                    ((TextView) view.findViewById(d.nick_name_tv)).setTextColor(a.b(this.hqX).getResources().getColor(a.grey_text_color));
                    break;
                }
        }
        return false;
    }
}
