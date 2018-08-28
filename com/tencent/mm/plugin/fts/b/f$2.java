package com.tencent.mm.plugin.fts.b;

import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.b.f.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class f$2 implements e {
    final /* synthetic */ f juX;

    f$2(f fVar) {
        this.juX = fVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof c) {
            c cVar = (c) lVar;
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.FTS.FTSSearchTestLogic", "bind contact %s success", new Object[]{cVar.qyZ.toString()});
                return;
            }
            x.e("MicroMsg.FTS.FTSSearchTestLogic", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            List list = cVar.qyZ;
            if (i2 == -44) {
                List linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(1));
                Map hashMap = new HashMap();
                hashMap.put(list.get(0), Integer.valueOf(0));
                g.DF().a(new c(this.juX, list, linkedList, "你好，我是珍惜", cVar.juZ, hashMap, cVar.juZ), 0);
            }
            if (i == 4 && i2 == -24 && !bi.oW(str)) {
                Toast.makeText(ad.getContext(), str, 1).show();
            }
        }
    }
}
