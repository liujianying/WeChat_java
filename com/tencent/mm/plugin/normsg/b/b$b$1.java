package com.tencent.mm.plugin.normsg.b;

import android.os.IInterface;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.plugin.normsg.b.b.b;
import com.tencent.mm.plugin.normsg.b.b.e;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class b$b$1 extends e {
    final /* synthetic */ Integer lGG;
    final /* synthetic */ View lGH;
    final /* synthetic */ b lGI;

    b$b$1(b bVar, IInterface iInterface, Integer num, View view) {
        this.lGI = bVar;
        this.lGG = num;
        this.lGH = view;
        super(bVar.lGB, iInterface);
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (b.bjX().equals(name)) {
            List arrayList = new ArrayList();
            if (objArr[0] != null) {
                arrayList.add((AccessibilityNodeInfo) objArr[0]);
            }
            b.a(this.lGI.lGB, this.lGG.intValue(), this.lGH, arrayList);
            if (arrayList.isEmpty()) {
                objArr[0] = null;
            } else {
                objArr[0] = arrayList.get(0);
            }
        } else if (b.bjY().equals(name)) {
            List list = (List) objArr[0];
            if (list == null) {
                list = new ArrayList();
            }
            b.a(this.lGI.lGB, this.lGG.intValue(), this.lGH, list);
        }
        return super.invoke(obj, method, objArr);
    }
}
