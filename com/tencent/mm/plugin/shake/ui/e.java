package com.tencent.mm.plugin.shake.ui;

import android.database.Cursor;
import android.widget.ImageView;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public static void a(ImageView imageView, String str, int i, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bi.oW(str)) {
                a aVar = new a();
                aVar.dXA = m.lV(str);
                aVar.dXy = true;
                aVar.dXV = true;
                aVar.dXW = z;
                if (i != 0) {
                    aVar.dXR = i;
                }
                o.Pj().a(str, imageView, aVar.Pt());
            }
        }
    }

    public static String bvA() {
        g buD = m.buD();
        List<f> arrayList = new ArrayList();
        Cursor b = buD.diF.b("SELECT * FROM " + buD.getTableName() + " where status != 1", null, 2);
        if (b != null) {
            while (b.moveToNext()) {
                f fVar = new f();
                fVar.d(b);
                arrayList.add(fVar);
            }
            b.close();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (f fVar2 : arrayList) {
            stringBuilder.append(fVar2.field_reserved1);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }
}
