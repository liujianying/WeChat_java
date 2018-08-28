package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.protocal.c.eh;
import java.util.List;

public class a$a extends a<a> {
    private List<eh> gxs;

    public a$a(List<eh> list) {
        this.gxs = list;
    }

    public final int getItemCount() {
        return this.gxs == null ? 0 : this.gxs.size();
    }
}
