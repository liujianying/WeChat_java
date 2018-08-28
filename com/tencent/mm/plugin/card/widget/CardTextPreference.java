package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.ui.base.preference.Preference;

public class CardTextPreference extends Preference {
    private TextView Wx;
    private TextView hIY;
    public int hIZ = 0;
    boolean hJa = true;
    Context mContext;

    public CardTextPreference(Context context) {
        super(context, null);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    public CardTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutResource(e.mm_preference);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.hIY = (TextView) view.findViewById(16908304);
        this.Wx = (TextView) view.findViewById(16908310);
        azV();
        dU(this.hJa);
    }

    public final void azV() {
        if (this.hIY != null && this.hIZ != 0) {
            this.hIY.setTextColor(this.hIZ);
        }
    }

    public final void azW() {
        dU(false);
        this.hJa = false;
    }

    private void dU(boolean z) {
        if (this.Wx != null) {
            View view = this.Wx;
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            this.Wx.setSingleLine(z);
            if (!z) {
                rect.top = this.mContext.getResources().getDimensionPixelOffset(b.LargePadding);
                rect.bottom = this.mContext.getResources().getDimensionPixelOffset(b.LargePadding);
                view = this.Wx;
                if (view != null) {
                    view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                }
            }
        }
    }
}
