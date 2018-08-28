package com.tencent.mm.console.a;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.secinforeport.a.d;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements a {
    static {
        b.a(new e(), new String[]{"//normsg"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (!com.tencent.mm.sdk.a.b.chp() || strArr.length < 2) {
            return false;
        }
        try {
            if (strArr.length >= 3) {
                Integer.valueOf(strArr[2]).intValue();
            }
        } catch (Exception e) {
        }
        String toLowerCase = strArr[1].toLowerCase();
        long nanoTime = System.nanoTime();
        boolean z = true;
        switch (toLowerCase.hashCode()) {
            case -1621532861:
                if (toLowerCase.equals("testturing")) {
                    z = true;
                    break;
                }
                break;
            case -1422437344:
                if (toLowerCase.equals("testrpp")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                d.mOw.a(0, true, true, true);
                Toast.makeText(context, "info is reported.", 0).show();
                break;
            case true:
                com.tencent.mm.plugin.normsg.a.b.lFJ.S(1, 1, 4);
                ah.i(new 1(this), 4000);
                Toast.makeText(context, "turing info is reported.", 0).show();
                break;
            default:
                return false;
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        CharSequence format = String.format("[NorMsgTest] cmd: %s, time: %d ns.", new Object[]{strArr[1], Long.valueOf(nanoTime2)});
        x.i("MicroMsg.NorMsgTest", format);
        Toast.makeText(context, format, 0).show();
        return true;
    }
}
