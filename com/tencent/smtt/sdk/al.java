package com.tencent.smtt.sdk;

import android.os.HandlerThread;

class al extends HandlerThread {
    private static al a;

    public al(String str) {
        super(str);
    }

    public static synchronized al a() {
        al alVar;
        synchronized (al.class) {
            if (a == null) {
                alVar = new al("TbsHandlerThread");
                a = alVar;
                alVar.start();
            }
            alVar = a;
        }
        return alVar;
    }
}
