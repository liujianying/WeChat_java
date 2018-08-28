package com.tencent.mm.plugin.fav.ui.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.ui.k;
import com.tencent.mm.plugin.fav.ui.m.i;
import com.tencent.mm.protocal.c.wn;

public final class n extends a {
    public n(k kVar) {
        super(kVar);
    }

    public final View a(View view, ViewGroup viewGroup, g gVar) {
        return new View(viewGroup.getContext());
    }

    public final void a(View view, wn wnVar) {
        if (view != null) {
            Toast.makeText(view.getContext(), i.favorite_unknown_type, 0).show();
        }
    }
}
