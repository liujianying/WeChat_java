package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class i {
    public static boolean fb(long j) {
        int i = 2;
        int i2 = 0;
        n fi = af.byo().fi(j);
        if (fi == null) {
            return false;
        }
        boolean z;
        boolean z2;
        String[] split = ((String) g.Ei().DT().get(a.taf, "")).split("&");
        if (split.length <= 0 || !bi.getBoolean(split[0], false)) {
            z = false;
        } else {
            z = true;
        }
        if (split.length < 2 || !bi.getBoolean(split[1], false)) {
            z2 = false;
        } else {
            z2 = true;
        }
        List arrayList = new ArrayList();
        while (i < split.length) {
            long j2 = bi.getLong(split[i], 0);
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
            i++;
        }
        if (fi.bAJ().sqc.ruz == 15) {
            if (z) {
                return false;
            }
            z = true;
        } else if (fi.bAJ().sqc.ruz != 1 || r3) {
            return false;
        } else {
            z2 = true;
        }
        if (!arrayList.contains(Long.valueOf(j))) {
            arrayList.add(Long.valueOf(j));
        }
        StringBuilder append = new StringBuilder().append(z).append("&").append(z2);
        while (i2 < arrayList.size()) {
            append.append("&").append(arrayList.get(i2));
            i2++;
        }
        g.Ei().DT().a(a.taf, append.toString());
        h(Long.valueOf(j));
        return true;
    }

    public static void fc(long j) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        String[] split = ((String) g.Ei().DT().get(a.taf, "")).split("&");
        if (split.length <= 0 || !bi.getBoolean(split[0], false)) {
            z = false;
        } else {
            z = true;
        }
        if (split.length < 2 || !bi.getBoolean(split[1], false)) {
            z2 = false;
        }
        List arrayList = new ArrayList();
        for (int i2 = 2; i2 < split.length; i2++) {
            long j2 = bi.getLong(split[i2], 0);
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        arrayList.remove(Long.valueOf(j));
        Collections.reverse(arrayList);
        h(arrayList.size() > 0 ? (Long) arrayList.get(0) : null);
        StringBuilder append = new StringBuilder().append(z).append("&").append(z2);
        while (i < arrayList.size()) {
            append.append("&").append(arrayList.get(i));
            i++;
        }
        g.Ei().DT().a(a.taf, append.toString());
    }

    public static void h(Long l) {
        g.Ei().DT().a(a.tah, l);
    }
}
