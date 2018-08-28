package com.tencent.mm.plugin.backup.a;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a {
    private static String TAG = "MicroMsg.BackupBaseModel";
    private static LinkedList<a> gRj = new LinkedList();

    public abstract void aqK();

    public static void a(a aVar) {
        gRj.add(aVar);
    }

    public static void aqJ() {
        Iterator it = gRj.iterator();
        while (it.hasNext()) {
            ((a) it.next()).aqK();
        }
        gRj.clear();
    }
}
