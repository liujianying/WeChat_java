package com.tencent.mm.plugin.wear.model;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.pluginsdk.model.m;
import java.util.LinkedList;
import java.util.List;

class b$a extends d {
    final /* synthetic */ b pIZ;

    private b$a(b bVar) {
        this.pIZ = bVar;
    }

    /* synthetic */ b$a(b bVar, byte b) {
        this(bVar);
    }

    public final void execute() {
        au.DF().a(30, this.pIZ);
        List linkedList = new LinkedList();
        linkedList.add("gh_43f2581f6fd6");
        List linkedList2 = new LinkedList();
        linkedList2.add(Integer.valueOf(1));
        au.DF().a(new m(1, linkedList, linkedList2, "", ""), 0);
    }

    public final String getName() {
        return "AddContactTask";
    }
}
