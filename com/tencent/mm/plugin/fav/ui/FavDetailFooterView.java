package com.tencent.mm.plugin.fav.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.m.i;

public class FavDetailFooterView extends TextView {
    public FavDetailFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public FavDetailFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void D(g gVar) {
        if (gVar != null) {
            if (gVar.field_edittime > 0) {
                setText(getContext().getString(i.favorite_edit_prefix) + i.f(getContext(), gVar.field_edittime * 1000));
            } else {
                setText(getContext().getString(i.favorite_time_prefix) + i.f(getContext(), gVar.field_updateTime));
            }
        }
    }
}
