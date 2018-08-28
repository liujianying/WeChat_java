package com.tencent.mm.plugin.appbrand.debugger;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.debugger.j.1;
import com.tencent.mm.plugin.appbrand.debugger.j.3;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.s.h;
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONObject;

public final class n extends l {
    j ftC;
    h ftb;

    protected final b aaE() {
        this.ftC = new j();
        return this.ftC;
    }

    public final void j(String str, String str2, int i) {
        if (bi.oW(str2)) {
            str2 = "{}";
        }
        x.d("MicroMsg.RemoteDebugService", "dispatch, event: %s, data size: %s, srcId: %d", new Object[]{str, Integer.valueOf(str2.length()), Integer.valueOf(i)});
        this.ftC.ftc = str;
        j jVar = this.ftC;
        String str3 = "typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.subscribeHandler(\"%s\" , %s, %s, %s)";
        Object[] objArr = new Object[4];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = i == 0 ? "undefined" : String.valueOf(i);
        objArr[3] = Db();
        jVar.evaluateJavascript(String.format(str3, objArr), null);
    }

    public final void E(int i, String str) {
        if (bi.oW(str)) {
            str = "{}";
        }
        this.ftC.ftf.D(i, str);
        this.fEE.H(i, str);
    }

    public final int a(b bVar, int i) {
        return i;
    }

    protected final void aaJ() {
    }

    public final void qw(String str) {
    }

    public final void h(g gVar) {
        super.h(gVar);
        if (p.ftI != null) {
            this.ftb = p.ftI;
            p.ftI = null;
        } else {
            this.ftb = new h();
        }
        h hVar = this.ftb;
        String str = this.fdO.fct.extInfo;
        hVar.fsw = this;
        hVar.fsC = p.sr(str);
        AppBrandSysConfig appBrandSysConfig = hVar.fsw.fdO.fcu;
        if (appBrandSysConfig != null) {
            appBrandSysConfig.fqO = hVar.fsC.fqO;
            appBrandSysConfig.fqw = true;
        }
        j jVar = this.ftC;
        jVar.ftb = this.ftb;
        jVar.fcy = jVar.ftb.fsw;
        jVar.ftd = jVar.fcy.getContext();
        jVar.ftg = new q(jVar.ftd, jVar.ftb, new 1(jVar));
        q qVar = jVar.ftg;
        qVar.ftJ = (ViewGroup) jVar.fcy.fdO.fcA.getParent();
        for (int i = 0; i < qVar.ftJ.getChildCount(); i++) {
            View childAt = qVar.ftJ.getChildAt(i);
            if (childAt instanceof q) {
                qVar.ftJ.removeView(childAt);
            }
        }
        qVar.ftJ.addView(qVar);
        qVar.ftJ.bringChildToFront(qVar);
        qVar.ftK = (RemoteDebugMoveView) LayoutInflater.from(qVar.getContext()).inflate(h.app_brand_remote_debug_move_view, null);
        qVar.ftN = (TextView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_connect_tv);
        qVar.ftM = (TextView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_server_tv);
        qVar.ftO = (TextView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_info_tv);
        qVar.ftP = (TextView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_quit_tv);
        qVar.ftQ = (TextView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_expand_tv);
        qVar.ftR = (TextView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_collapse_tv);
        qVar.ftS = (TextView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_error_tv);
        qVar.ftU = (ImageView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_connect_dot);
        qVar.ftT = (ImageView) qVar.ftK.findViewById(s.g.app_brand_remote_debug_server_dot);
        qVar.ftV = qVar.ftK.findViewById(s.g.app_brand_remote_debug_detail_layout);
        qVar.show();
        qVar.ftQ.setOnClickListener(qVar.mOnClickListener);
        qVar.ftR.setOnClickListener(qVar.mOnClickListener);
        qVar.ftP.setOnClickListener(qVar.mOnClickListener);
        qVar.postDelayed(new q.1(qVar), 100);
        jVar.connect();
        if (bi.oW(jVar.ftb.aeu())) {
            x.i("MicroMsg.RemoteDebugJsEngine", "getRemoteDebugTicket");
            ahh ahh = new ahh();
            a aVar = new a();
            aVar.dIG = ahh;
            aVar.dIH = new ahi();
            aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getremotedebugticket";
            aVar.dIF = 1862;
            aVar.dII = 0;
            aVar.dIJ = 0;
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.KT(), new 3(jVar));
        }
    }

    public final void init() {
    }

    public final void onResume() {
        this.ftC.ftg.bringToFront();
    }

    public final String aeI() {
        JSONObject aaK = aaK();
        String str = this.fdO.fcv.foU;
        return String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", new Object[]{aaK.toString(), str});
    }
}
