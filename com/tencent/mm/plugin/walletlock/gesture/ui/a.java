package com.tencent.mm.plugin.walletlock.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.walletlock.a.d;
import com.tencent.mm.plugin.walletlock.a.e;
import com.tencent.mm.plugin.walletlock.gesture.ui.widget.PatternLockView;

final class a {
    View mView = null;
    TextView pHA = null;
    TextView pHx = null;
    FrameLayout pHy = null;
    PatternLockView pHz = null;

    public a(Activity activity) {
        this.mView = View.inflate(activity, e.input_pattern_view, null);
        this.pHx = (TextView) this.mView.findViewById(d.tv_info);
        this.pHy = (FrameLayout) this.mView.findViewById(d.pattern_view_wrapper);
        this.pHz = (PatternLockView) this.mView.findViewById(d.pattern_view);
        this.pHA = (TextView) this.mView.findViewById(d.tv_forgotpwd);
    }
}
