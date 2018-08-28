package com.tencent.xweb.c;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.regex.Pattern;
import org.xwalk.core.XWalkEnvironment;

public class a$b {
    public int vCA = -1;
    public int vCs = -1;
    public int vCt = -1;
    public int vCu = -1;
    public int vCv = -1;
    public int vCw = -1;
    public int vCx = -1;
    public String vCy = "";
    public int vCz = -1;

    public final boolean cID() {
        if (au(XWalkEnvironment.getAvailableVersion(), this.vCu, this.vCv) && au(21, this.vCs, this.vCt) && au(VERSION.SDK_INT, this.vCw, this.vCx) && au(XWalkEnvironment.getGrayValue(), this.vCz, this.vCA)) {
            String str = this.vCy;
            CharSequence charSequence = "";
            new StringBuilder().append(Build.BRAND).append(" ").append(Build.MODEL);
            if (Build.BRAND != null) {
                charSequence = charSequence + Build.BRAND;
            }
            if (Build.MODEL != null) {
                charSequence = charSequence + " " + Build.MODEL;
            }
            boolean find = (str == null || charSequence == null || str.isEmpty()) ? false : Pattern.compile(str).matcher(charSequence).find();
            if (!find) {
                return true;
            }
        }
        return false;
    }

    private static boolean au(int i, int i2, int i3) {
        if (i3 > 0 && i > i3) {
            XWalkEnvironment.addXWalkInitializeLog(" _IsInRange return false nVal = " + i + " nMin = " + i2 + " nMax = " + i3);
            return false;
        } else if (i2 <= 0 || i >= i2) {
            return true;
        } else {
            XWalkEnvironment.addXWalkInitializeLog(" _IsInRange return false nVal = " + i + " nMin = " + i2 + " nMax = " + i3);
            return false;
        }
    }
}
