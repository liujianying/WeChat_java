package com.tencent.mm.ui.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.l;

public final class b extends o {
    public long mDuration = 3000;
    @SuppressLint({"HandlerLeak"})
    private ag mHandler = new 1(this);

    private b(View view) {
        super(view);
    }

    public static b gZ(Context context) {
        View inflate = LayoutInflater.from(context).inflate(h.toast_popup, null);
        ((TextView) inflate.findViewById(g.toast_text)).setVisibility(8);
        b bVar = new b(inflate);
        bVar.setFocusable(false);
        bVar.setContentView(inflate);
        bVar.setWidth(-1);
        bVar.setHeight(-1);
        bVar.setAnimationStyle(l.ToastPopupWindow);
        bVar.mDuration = 1200;
        return bVar;
    }

    public final void showAsDropDown(View view, int i, int i2) {
        super.showAsDropDown(view, i, i2);
        this.mHandler.removeMessages(GLIcon.TOP);
        this.mHandler.sendEmptyMessageDelayed(GLIcon.TOP, this.mDuration);
    }

    public final void showAsDropDown(View view) {
        super.showAsDropDown(view);
        this.mHandler.removeMessages(GLIcon.TOP);
        this.mHandler.sendEmptyMessageDelayed(GLIcon.TOP, this.mDuration);
    }

    public final void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        this.mHandler.removeMessages(GLIcon.TOP);
        this.mHandler.sendEmptyMessageDelayed(GLIcon.TOP, this.mDuration);
    }
}
