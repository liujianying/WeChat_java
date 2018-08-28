package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.Spanned;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.nativenote.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f {
    public static ArrayList<b> gvR;
    private static String qqt;

    public static void c(Context context, ArrayList<b> arrayList) {
        if (gvR != null) {
            gvR.clear();
        }
        gvR = arrayList;
        Set hashSet = new HashSet();
        if (gvR != null) {
            Iterator it = gvR.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                String d = c.d(bVar);
                if (!bi.oW(d)) {
                    hashSet.add(d);
                }
                String e = c.e(bVar);
                if (!bi.oW(e)) {
                    hashSet.add(e);
                }
            }
        }
        an.iXj = hashSet;
        StringBuilder stringBuilder = new StringBuilder("");
        if (gvR != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= gvR.size()) {
                    break;
                }
                if (i2 != gvR.size() - 1) {
                    stringBuilder.append(c.a(context, (b) gvR.get(i2))).append("<br/>");
                } else {
                    stringBuilder.append(c.a(context, (b) gvR.get(i2)));
                }
                i = i2 + 1;
            }
        }
        qqt = c.Su(stringBuilder.toString());
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText(a.Sk(qqt));
        }
    }

    public static ArrayList<b> bZS() {
        ArrayList<b> arrayList = new ArrayList();
        if (gvR == null) {
            return arrayList;
        }
        Iterator it = gvR.iterator();
        while (it.hasNext()) {
            Object obj;
            b c = c.c((b) it.next());
            if (c == null) {
                obj = null;
            } else {
                obj = 1;
                int type = c.getType();
                if (type == 2 || type == 6 || type == 4 || type == 5) {
                    String d = c.d(c);
                    if (bi.oW(d) || !FileOp.cn(d)) {
                        obj = null;
                    }
                }
                if (type == 2 || type == 6) {
                    String e = c.e(c);
                    if (bi.oW(e) || !FileOp.cn(e)) {
                        obj = null;
                    }
                }
            }
            if (obj != null) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    public static void acV() {
        if (gvR != null) {
            gvR.clear();
        }
        qqt = "";
        an.iXj = null;
    }

    public static boolean eD(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager.getText().length() >= 16384) {
            return true;
        }
        if (c.Ss(clipboardManager.getText().toString()) >= 16384) {
            return true;
        }
        return false;
    }

    public static int eE(Context context) {
        int i;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null || clipboardManager.getText() == null || clipboardManager.getText().length() <= 0) {
            i = 1;
        } else {
            i = 0;
        }
        int i2;
        if (gvR == null || gvR.size() <= 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i != 0 && i2 != 0) {
            return 1;
        }
        if (i == 0 && i2 != 0) {
            return 2;
        }
        if (i != 0) {
            return 3;
        }
        String a;
        String str = "";
        try {
            CharSequence text = clipboardManager.getText();
            if (text instanceof Spanned) {
                a = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a((Spanned) text);
            } else {
                a = text.toString();
            }
        } catch (Exception e) {
            x.e("WNNoteClipboardManager", "get clipboard data error : ", new Object[]{e});
            a = str;
        }
        if (a.equals(qqt)) {
            return 3;
        }
        return 2;
    }
}
