package com.google.android.gms.common;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.R;
import com.google.android.gms.b.c.a;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.internal.zzab;

public final class SignInButton extends FrameLayout implements OnClickListener {
    private View aJN;
    private OnClickListener aJO;
    private int fi;
    private int pN;

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJO = null;
        setStyle(0, 0);
    }

    private void setStyle(int i, int i2) {
        int v;
        boolean z = i >= 0 && i < 3;
        w.a(z, "Unknown button size %d", new Object[]{Integer.valueOf(i)});
        z = i2 >= 0 && i2 < 2;
        w.a(z, "Unknown color scheme %s", new Object[]{Integer.valueOf(i2)});
        this.fi = i;
        this.pN = i2;
        Context context = getContext();
        if (this.aJN != null) {
            removeView(this.aJN);
        }
        try {
            this.aJN = b.b(context, this.fi, this.pN);
        } catch (a e) {
            int i3 = this.fi;
            int i4 = this.pN;
            zzab zzab = new zzab(context);
            Resources resources = context.getResources();
            z = i3 >= 0 && i3 < 3;
            w.a(z, "Unknown button size %d", new Object[]{Integer.valueOf(i3)});
            z = i4 >= 0 && i4 < 2;
            w.a(z, "Unknown color scheme %s", new Object[]{Integer.valueOf(i4)});
            zzab.setTypeface(Typeface.DEFAULT_BOLD);
            zzab.setTextSize(14.0f);
            float f = resources.getDisplayMetrics().density;
            zzab.setMinHeight((int) ((f * 48.0f) + 0.5f));
            zzab.setMinWidth((int) ((f * 48.0f) + 0.5f));
            switch (i3) {
                case 0:
                case 1:
                    v = zzab.v(i4, R.drawable.common_signin_btn_text_dark, R.drawable.common_signin_btn_text_light);
                    break;
                case 2:
                    v = zzab.v(i4, R.drawable.common_signin_btn_icon_dark, R.drawable.common_signin_btn_icon_light);
                    break;
                default:
                    throw new IllegalStateException("Unknown button size: " + i3);
            }
            if (v == -1) {
                throw new IllegalStateException("Could not find background resource!");
            }
            zzab.setBackgroundDrawable(resources.getDrawable(v));
            zzab.setTextColor(resources.getColorStateList(zzab.v(i4, R.color.common_signin_btn_text_dark, R.color.common_signin_btn_text_light)));
            switch (i3) {
                case 0:
                    zzab.setText(resources.getString(R.string.common_signin_button_text));
                    break;
                case 1:
                    zzab.setText(resources.getString(R.string.common_signin_button_text_long));
                    break;
                case 2:
                    zzab.setText(null);
                    break;
                default:
                    throw new IllegalStateException("Unknown button size: " + i3);
            }
            this.aJN = zzab;
        }
        addView(this.aJN);
        this.aJN.setEnabled(isEnabled());
        this.aJN.setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (this.aJO != null && view == this.aJN) {
            this.aJO.onClick(this);
        }
    }

    public final void setColorScheme(int i) {
        setStyle(this.fi, i);
    }

    public final void setEnabled(boolean z) {
        super.setEnabled(z);
        this.aJN.setEnabled(z);
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.aJO = onClickListener;
        if (this.aJN != null) {
            this.aJN.setOnClickListener(this);
        }
    }

    public final void setSize(int i) {
        setStyle(i, this.pN);
    }
}
