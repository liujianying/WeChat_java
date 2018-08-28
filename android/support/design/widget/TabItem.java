package android.support.design.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.view.View;

public final class TabItem extends View {
    final Drawable hh;
    final int hi;
    final CharSequence mText;

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ap a = ap.a(context, attributeSet, i.TabItem);
        this.mText = a.getText(i.TabItem_android_text);
        this.hh = a.getDrawable(i.TabItem_android_icon);
        this.hi = a.getResourceId(i.TabItem_android_layout, 0);
        a.Ww.recycle();
    }
}
