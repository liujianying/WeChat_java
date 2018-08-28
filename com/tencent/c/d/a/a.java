package com.tencent.c.d.a;

import com.tencent.c.f.h;
import java.io.File;

public final class a {
    public static boolean aco(String str) {
        if (!new File(str).exists()) {
            return true;
        }
        try {
            boolean aco = com.tencent.c.d.b.a.aco(str);
            if (!aco) {
                h.i("BootScriptChecker found no-elf file : " + str);
            }
            return aco;
        } catch (Throwable e) {
            h.k(e);
            return true;
        }
    }

    public static boolean acp(String str) {
        boolean z = true;
        File file = new File(str);
        if (file.exists() && file.length() <= 51200) {
            try {
                String str2 = new String(com.tencent.c.d.b.a.acq(file.getAbsolutePath()));
                z = str2.contains("applypatch ");
                h.d("BootScriptChecker script (" + str + ") content : \n" + str2);
                if (!z) {
                    h.i("BootScriptChecker found unofficial file : " + str);
                }
            } catch (Throwable e) {
                h.k(e);
            }
        }
        return z;
    }
}
