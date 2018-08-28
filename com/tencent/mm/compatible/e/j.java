package com.tencent.mm.compatible.e;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.mm.compatible.e.d.a;
import com.tencent.mm.sdk.platformtools.bi;

final class j implements a {
    j() {
    }

    public static d$a$a zg() {
        d$a$a d_a_a = new d$a$a();
        try {
            d_a_a.ddt = Camera.open();
            d_a_a.bYE = 0;
            if (d_a_a.ddt == null) {
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                d_a_a.bYE = 90;
                d_a_a.ddt.setDisplayOrientation(90);
            } else {
                int i;
                if (Build.MODEL.equals("M9")) {
                    String str = Build.DISPLAY;
                    if (str.substring(0, 0).equals("1")) {
                        i = -1;
                    } else {
                        String[] split = str.split("-");
                        i = (split == null || split.length < 2) ? -1 : bi.getInt(split[1], 0);
                    }
                } else {
                    i = -1;
                }
                if (i >= 7093) {
                    d_a_a.bYE = 90;
                    d_a_a.ddt.setDisplayOrientation(180);
                }
            }
            return d_a_a;
        } catch (Exception e) {
            return null;
        }
    }
}
