package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.e.a;
import com.tencent.mm.ac.e.a.b;
import com.tencent.mm.ac.z;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i extends LinearLayout implements a {
    private Context context;
    private LinearLayout jeZ = null;
    private List<String> ujt;
    private Map<String, View> uju;
    private a ujv;

    public i(Context context, a aVar) {
        super(context);
        this.context = context;
        this.ujv = aVar;
        init();
    }

    public final int getEnterpriseFriendCount() {
        if (this.ujt == null) {
            return 0;
        }
        return this.ujt.size();
    }

    private void init() {
        int i = 0;
        e MY = z.MY();
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        e.a(stringBuilder);
        e.c(stringBuilder);
        stringBuilder.append(" and bizinfo.type = 2 ");
        stringBuilder.append(" order by ");
        stringBuilder.append(e.MD());
        x.i("MicroMsg.BizInfoStorage", "getEnterpriseFatherBizLst sql %s", stringBuilder.toString());
        Cursor rawQuery = MY.rawQuery(r3, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                do {
                    arrayList.add(rawQuery.getString(0));
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
        }
        this.ujt = arrayList;
        if (this.ujt == null || this.ujt.size() <= 0) {
            x.e("MicroMsg.EnterpriseBizView", "bizList is null");
            return;
        }
        x.i("MicroMsg.EnterpriseBizView", "biz list size = %s", Integer.valueOf(this.ujt.size()));
        this.uju = new HashMap();
        if (this.jeZ == null) {
            View.inflate(getContext(), R.i.enterprise_biz_in_addressui_header, this);
            this.jeZ = (LinearLayout) findViewById(R.h.container);
        }
        while (i < this.ujt.size()) {
            String str = (String) this.ujt.get(i);
            j jVar = new j(getContext(), str);
            this.jeZ.addView(jVar);
            this.uju.put(str, jVar);
            if (i == this.ujt.size() - 1) {
                jVar.findViewById(R.h.enterprise_biz_item_ll).setBackgroundResource(R.g.mm_trans);
            }
            i++;
        }
    }

    public final void a(b bVar) {
        if (bVar.dMc != null) {
            if (bVar.dMc.LY()) {
                ah.A(new 1(this, bVar));
            } else {
                x.i("MicroMsg.EnterpriseBizView", "onEvent, not enterprise father");
            }
        }
    }
}
