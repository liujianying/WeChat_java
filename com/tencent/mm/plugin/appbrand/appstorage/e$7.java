package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.plugin.appbrand.q.h;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

class e$7 implements a {
    final /* synthetic */ e fkl;

    e$7(e eVar) {
        this.fkl = eVar;
    }

    public final j a(File file, Object... objArr) {
        if (!file.isDirectory()) {
            return j.fkQ;
        }
        if (k.z(file)) {
            return j.fkS;
        }
        List linkedList = new LinkedList();
        file.listFiles(new 1(this, Pattern.quote(file.getAbsolutePath()), linkedList));
        ((h) objArr[0]).value = linkedList;
        return j.fkI;
    }
}
