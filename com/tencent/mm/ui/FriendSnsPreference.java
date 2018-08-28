package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.ui.base.preference.IconPreference;

public final class FriendSnsPreference extends IconPreference {
    private Context context;
    String tiV;
    Bitmap tiW;
    long tiX;

    public FriendSnsPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FriendSnsPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tiV = null;
        this.tiW = null;
        this.context = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.tiV != null && g.Eg().Dx()) {
            b.a(this.kYT, this.tiV);
        }
        if (this.tiX != 0 && this.kYT != null) {
            ((m) g.l(m.class)).a(this.tiX, this.kYT, this.mContext.hashCode());
        }
    }
}
