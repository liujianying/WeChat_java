package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.chatting.b.b.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class o$1 implements OnMenuItemClickListener {
    final /* synthetic */ o tIY;

    o$1(o oVar) {
        this.tIY = oVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        Set<Long> ctL = ((g) this.tIY.bAG.O(g.class)).ctL();
        if (ctL != null) {
            List<Long> arrayList = new ArrayList();
            for (Long l : ctL) {
                if (l != null) {
                    arrayList.add(l);
                }
            }
            long[] jArr = new long[arrayList.size()];
            int i = 0;
            for (Long l2 : arrayList) {
                int i2 = i + 1;
                jArr[i] = l2.longValue();
                i = i2;
            }
            intent.putExtra("k_outside_expose_proof_item_list", jArr);
            this.tIY.bAG.tTq.getContext().setResult(-1, intent);
        } else {
            this.tIY.bAG.tTq.getContext().setResult(0, intent);
        }
        intent.putExtra("k_is_group_chat", this.tIY.bAG.cwr());
        this.tIY.bAG.tTq.csV();
        return false;
    }
}
