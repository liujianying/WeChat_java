package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.tencent.mm.ui.ao;

public class o extends PopupWindow {
    private Context mContext = null;
    private OnTouchListener twh;

    public o(Context context) {
        super(context);
        this.mContext = context;
        super.setBackgroundDrawable(null);
        setContentView(new a(this, this.mContext));
    }

    public o(View view) {
        super(view);
        super.setBackgroundDrawable(null);
    }

    public o(View view, int i, int i2) {
        super(view, i, i2);
        super.setBackgroundDrawable(null);
    }

    public o(View view, int i, int i2, boolean z) {
        super(view, i, i2, z);
        super.setBackgroundDrawable(null);
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            ao.v("dismiss exception, e = " + e.getMessage(), new Object[0]);
        }
    }

    public Drawable getBackground() {
        View contentView = getContentView();
        if (contentView != null && (contentView instanceof a)) {
            return contentView.getBackground();
        }
        return null;
    }

    public void setContentView(View view) {
        int i = -2;
        View contentView = getContentView();
        if (contentView == null) {
            super.setContentView(view);
        } else if (contentView instanceof a) {
            a aVar = (a) contentView;
            aVar.removeAllViews();
            if (view == null) {
                super.setContentView(aVar);
                return;
            }
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                i = -1;
            }
            aVar.addView(view, new FrameLayout.LayoutParams(-1, i));
            super.setContentView(aVar);
            return;
        }
        super.setContentView(view);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        int i = -2;
        View contentView = getContentView();
        if (contentView != null) {
            Context context = contentView.getContext();
            if (contentView instanceof a) {
                contentView.setBackgroundDrawable(drawable);
                return;
            }
            LayoutParams layoutParams = contentView.getLayoutParams();
            if (layoutParams == null || layoutParams.height != -2) {
                i = -1;
            }
            a aVar = new a(this, context);
            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, i);
            aVar.setBackgroundDrawable(drawable);
            aVar.addView(contentView, layoutParams2);
            super.setContentView(aVar);
        }
    }

    public void setTouchInterceptor(OnTouchListener onTouchListener) {
        this.twh = onTouchListener;
    }
}
