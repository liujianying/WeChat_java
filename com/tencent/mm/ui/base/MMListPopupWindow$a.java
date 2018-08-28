package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.bw.a.b;

class MMListPopupWindow$a extends ListView {
    private boolean Qh;
    private boolean Qi;

    /* synthetic */ MMListPopupWindow$a(Context context, boolean z, byte b) {
        this(context, z);
    }

    private MMListPopupWindow$a(Context context, boolean z) {
        super(context, null, b.dropDownListViewStyle);
        this.Qi = z;
        setCacheColorHint(0);
    }

    public final boolean isInTouchMode() {
        return (this.Qi && this.Qh) || super.isInTouchMode();
    }

    public final boolean hasWindowFocus() {
        return this.Qi || super.hasWindowFocus();
    }

    public final boolean isFocused() {
        return this.Qi || super.isFocused();
    }

    public final boolean hasFocus() {
        return this.Qi || super.hasFocus();
    }

    final int S(int i, int i2) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i3 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i4 = 0;
        listPaddingBottom = 0;
        View view = null;
        while (i4 < count) {
            listPaddingTop = adapter.getItemViewType(i4);
            if (listPaddingTop != listPaddingBottom) {
                view = null;
            } else {
                listPaddingTop = listPaddingBottom;
            }
            view = adapter.getView(i4, view, this);
            listPaddingBottom = view == null ? 0 : view.getLayoutParams().height;
            if (listPaddingBottom > 0) {
                listPaddingBottom = MeasureSpec.makeMeasureSpec(listPaddingBottom, 1073741824);
            } else {
                listPaddingBottom = MeasureSpec.makeMeasureSpec(0, 0);
            }
            if (view != null) {
                view.measure(i, listPaddingBottom);
            }
            if (i4 > 0) {
                i3 += dividerHeight;
            }
            if (view != null) {
                i3 += view.getMeasuredHeight();
            }
            if (i3 >= i2) {
                return i2;
            }
            i4++;
            listPaddingBottom = listPaddingTop;
        }
        return i3;
    }
}
