package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public final class d {
    private static a thj;
    private static HashMap<Integer, Long> thk = new HashMap();
    private static int thl = 1100;
    private static int thm = MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN;
    private static long thn = 0;

    public interface a {
        void b(long j, String str, String str2);
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
    }

    public static synchronized boolean a(Context context, boolean z, Intent[] intentArr, Object... objArr) {
        boolean z2;
        synchronized (d.class) {
            for (Intent ar : intentArr) {
                if (ar(ar)) {
                    z2 = false;
                    break;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.toString()).append(",");
            for (Object append : intentArr) {
                stringBuilder.append(append);
                stringBuilder.append(",");
            }
            for (Object append2 : objArr) {
                stringBuilder.append(append2);
                stringBuilder.append(",");
            }
            Integer valueOf = Integer.valueOf(stringBuilder.toString().hashCode());
            Long l = (Long) thk.get(valueOf);
            Long valueOf2 = Long.valueOf(System.currentTimeMillis());
            if (z && l != null) {
                if (valueOf2.longValue() - l.longValue() <= ((long) thm)) {
                    thj.b(valueOf2.longValue() - l.longValue(), ZQ(context.getClass().toString()), intentArr[0].getComponent() != null ? ZQ(intentArr[0].getComponent().getClassName()) : "None");
                }
                if (valueOf2.longValue() - l.longValue() <= ((long) thl)) {
                    thk.put(valueOf, valueOf2);
                    x.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", Integer.valueOf(thl), r5, l, valueOf2);
                    z2 = true;
                }
            }
            if (thk.size() > 100 && thn != 0 && System.currentTimeMillis() - thn > ((long) thl)) {
                thk.clear();
            }
            thk.put(valueOf, valueOf2);
            thn = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            x.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", Long.valueOf(currentTimeMillis2));
            z2 = false;
        }
        return z2;
    }

    public static void a(a aVar) {
        thj = aVar;
    }

    private static String ZQ(String str) {
        String[] split = str.split("\\.");
        if (split.length > 0) {
            return split[split.length - 1];
        }
        return "";
    }

    public static int coR() {
        return thl;
    }

    private static boolean ar(Intent intent) {
        if (intent != null) {
            try {
                if (!(intent.getComponent() == null || bi.oW(intent.getComponent().getClassName()))) {
                    if (Class.forName(intent.getComponent().getClassName()).getAnnotation(b.class) == null) {
                        return false;
                    }
                    return true;
                }
            } catch (Exception e) {
                x.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", e);
                return false;
            }
        }
        return false;
    }
}
