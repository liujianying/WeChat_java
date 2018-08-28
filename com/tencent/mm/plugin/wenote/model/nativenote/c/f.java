package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;

public final class f {
    public static View g(RecyclerView recyclerView, int i) {
        if (recyclerView == null) {
            return null;
        }
        View be;
        try {
            h layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                be = ((LinearLayoutManager) layoutManager).be(i);
                return be;
            }
        } catch (Exception e) {
        }
        be = null;
        return be;
    }

    public static c dd(View view) {
        if (view == null) {
            return null;
        }
        WXRTEditText wXRTEditText = (WXRTEditText) view.findViewById(R.h.rte_text);
        WXRTEditText wXRTEditText2 = (WXRTEditText) view.findViewById(R.h.btnPrev);
        WXRTEditText wXRTEditText3 = (WXRTEditText) view.findViewById(R.h.btnNext);
        c cVar = wXRTEditText != null ? new c(wXRTEditText) : (wXRTEditText2 == null || wXRTEditText3 == null) ? null : new c(wXRTEditText2, wXRTEditText3);
        return cVar;
    }
}
