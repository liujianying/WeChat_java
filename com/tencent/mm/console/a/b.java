package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.c.avk;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public final class b implements a {
    static {
        com.tencent.mm.pluginsdk.cmd.b.a(new b(), new String[]{"//fts"});
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr) {
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        Object obj = -1;
        switch (str.hashCode()) {
            case -1354714445:
                if (str.equals("copydb")) {
                    obj = 2;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    obj = 7;
                    break;
                }
                break;
            case -1132164145:
                if (str.equals("clearconfig")) {
                    obj = 5;
                    break;
                }
                break;
            case -617644996:
                if (str.equals("clearunread")) {
                    obj = 8;
                    break;
                }
                break;
            case 3237038:
                if (str.equals("info")) {
                    obj = 6;
                    break;
                }
                break;
            case 104187309:
                if (str.equals("msbiz")) {
                    obj = null;
                    break;
                }
                break;
            case 819712873:
                if (str.equals("deletedb")) {
                    obj = 1;
                    break;
                }
                break;
            case 955180557:
                if (str.equals("corrupt")) {
                    obj = 3;
                    break;
                }
                break;
            case 1873247692:
                if (str.equals("addchatroomcontact")) {
                    obj = 4;
                    break;
                }
                break;
        }
        File file;
        i iVar;
        switch (obj) {
            case null:
                avl bTb = com.tencent.mm.plugin.websearch.api.x.bTb();
                StringBuilder stringBuilder = new StringBuilder();
                Iterator it = bTb.hbG.iterator();
                while (it.hasNext()) {
                    avk avk = (avk) it.next();
                    stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{r.gT(avk.rdS), Double.valueOf(avk.rYh), h.h("yyyy-MM-dd HH:mm", avk.rYi / 1000)}));
                    stringBuilder.append("\n");
                }
                C(context, stringBuilder.toString());
                break;
            case 1:
                au.HU();
                file = new File(c.Gp(), "FTS5IndexMicroMsg.db");
                if (file.exists()) {
                    file.delete();
                }
                Process.killProcess(Process.myPid());
                break;
            case 2:
                au.HU();
                file = new File(c.Gp(), "FTS5IndexMicroMsg.db");
                File file2 = new File("/sdcard/IndexMicroMsg.db");
                if (file2.exists()) {
                    file2.delete();
                }
                FileOp.y(file.getAbsolutePath(), file2.getAbsolutePath());
                break;
            case 3:
                iVar = new i();
                iVar.jsn = 65522;
                ((n) g.n(n.class)).search(10000, iVar);
                break;
            case 4:
                iVar = new i();
                iVar.bWm = strArr[2];
                iVar.jsn = 65523;
                ((n) g.n(n.class)).search(10000, iVar);
                break;
            case 5:
                aa.a[] aVarArr = new aa.a[]{aa.a.sWu, aa.a.sWv, aa.a.sWw, aa.a.sWx, aa.a.sWy, aa.a.sWz, aa.a.sWA, aa.a.sWB, aa.a.sWC, aa.a.sWD, aa.a.sWE, aa.a.sWF, aa.a.sWG, aa.a.sWH, aa.a.sWI, aa.a.sWJ, aa.a.sWK, aa.a.sWL, aa.a.sWM, aa.a.sWN, aa.a.sWO, aa.a.sWP, aa.a.sWQ, aa.a.sWR, aa.a.sWS, aa.a.sWT};
                for (int i = 0; i < 26; i++) {
                    aa.a aVar = aVarArr[i];
                    au.HU();
                    c.DT().a(aVar, "");
                }
                break;
            case 6:
                file = new File(com.tencent.mm.plugin.fts.a.c.jqx, "FTS5IndexMicroMsgInfo.txt");
                if (file.exists()) {
                    try {
                        C(context, FileOp.ct(file.getAbsolutePath()));
                        break;
                    } catch (IOException e) {
                        break;
                    }
                }
                break;
            case 7:
                iVar = new i();
                iVar.jsn = 65521;
                iVar.jss = 100;
                if (strArr.length > 2) {
                    try {
                        iVar.jss = Integer.valueOf(strArr[2]).intValue();
                    } catch (Exception e2) {
                    }
                }
                ((n) g.n(n.class)).search(10000, iVar);
                break;
            case 8:
                iVar = new i();
                iVar.jsn = 65524;
                ((n) g.n(n.class)).search(10000, iVar);
                break;
        }
        return true;
    }

    private static void C(Context context, String str) {
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.LargePadding);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        com.tencent.mm.ui.base.h.a(context, null, textView, null);
    }
}
