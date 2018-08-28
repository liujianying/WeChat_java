package com.tencent.mm.plugin.topstory.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.topstory.PluginTopStory;
import com.tencent.mm.plugin.topstory.ui.b.b;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.base.h;

public final class c implements a {
    public boolean ozq;
    public boolean ozr;
    public boolean ozs;

    public final boolean a(Context context, String[] strArr) {
        boolean z = true;
        if (x.getLogLevel() > 1) {
            return false;
        }
        if (strArr.length < 2) {
            return true;
        }
        String str = strArr[1];
        switch (str.hashCode()) {
            case 3173:
                if (str.equals("ch")) {
                    z = false;
                    break;
                }
                break;
            case 3183:
                if (str.equals("cr")) {
                    z = true;
                    break;
                }
                break;
            case 3185:
                if (str.equals("ct")) {
                    z = true;
                    break;
                }
                break;
            case 3186:
                if (str.equals("cu")) {
                    z = true;
                    break;
                }
                break;
            case 3489:
                if (str.equals("mn")) {
                    z = true;
                    break;
                }
                break;
            case 3634:
                if (str.equals("rd")) {
                    z = true;
                    break;
                }
                break;
            case 3681:
                if (str.equals("st")) {
                    z = true;
                    break;
                }
                break;
            case 3237038:
                if (str.equals("info")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                g.Ei().DT().a(aa.a.USERINFO_TOP_STORY_RED_DOT_RESULT_STRING, (Object) "");
                break;
            case true:
                rq rqVar = new rq();
                rqVar.ccx.actionType = 2;
                com.tencent.mm.sdk.b.a.sFg.m(rqVar);
                break;
            case true:
                this.ozq = true;
                break;
            case true:
                this.ozr = true;
                break;
            case true:
                this.ozs = true;
                break;
            case true:
                btf btf = new btf();
                btf.bWQ = strArr[2];
                btf.text = "测试测试";
                btf.type = 1;
                try {
                    btf.pMm = Integer.valueOf(strArr[3]).intValue();
                } catch (Exception e) {
                    btf.pMm = 2;
                }
                btf.sqG = System.currentTimeMillis();
                btf.eiD = 30;
                btf.sqE = System.currentTimeMillis();
                ((PluginTopStory) g.n(PluginTopStory.class)).getRedDotMgr().a(btf);
                break;
            case true:
                try {
                    CharSequence ct = e.ct(com.tencent.mm.compatible.util.e.bnE + "topstory/trace.info");
                    View textView = new TextView(context);
                    textView.setText(ct);
                    textView.setGravity(19);
                    textView.setTextSize(1, 10.0f);
                    textView.setLayoutParams(new LayoutParams(-1, -2));
                    textView.setTextColor(-16711936);
                    textView.setTypeface(Typeface.MONOSPACE);
                    int dimensionPixelSize = context.getResources().getDimensionPixelSize(b.LargePadding);
                    textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                    textView.setMovementMethod(ScrollingMovementMethod.getInstance());
                    h.a(context, null, textView, null);
                    break;
                } catch (Exception e2) {
                    break;
                }
            case true:
                FileOp.I(p.zL(1).adP(), false);
                Process.killProcess(Process.myPid());
                break;
        }
        return true;
    }
}
