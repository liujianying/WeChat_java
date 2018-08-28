package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.protocal.c.bhl;
import com.tencent.mm.protocal.c.bsw;
import com.tencent.mm.protocal.c.bsy;
import com.tencent.mm.protocal.c.bta;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class g implements a {
    public final boolean a(Context context, String[] strArr) {
        if (strArr.length < 2) {
            x.d("MicroMsg.Tinker.TinkerBootsCommand", "no args input.");
            return false;
        }
        boolean z;
        String str = strArr[1];
        if (b.chp()) {
            z = true;
            switch (str.hashCode()) {
                case -838846263:
                    if (str.equals("update")) {
                        z = false;
                        break;
                    }
                    break;
                case -309518737:
                    if (str.equals("process")) {
                        z = true;
                        break;
                    }
                    break;
                case 3510:
                    if (str.equals("nd")) {
                        z = true;
                        break;
                    }
                    break;
                case 3083269:
                    if (str.equals("diff")) {
                        z = true;
                        break;
                    }
                    break;
                case 3089570:
                    if (str.equals("down")) {
                        z = true;
                        break;
                    }
                    break;
                case 3529469:
                    if (str.equals("show")) {
                        z = true;
                        break;
                    }
                    break;
                case 94746189:
                    if (str.equals("clear")) {
                        z = true;
                        break;
                    }
                    break;
            }
            bta bta;
            bhl bhl;
            switch (z) {
                case false:
                    bsw bsw;
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "command checkout update.");
                    Object linkedList = new LinkedList();
                    String str2 = "tinker_id_d1ddc930233f0ec33f573e365038b6d979b6ebde";
                    String str3 = "";
                    if (strArr.length >= 3) {
                        str = strArr[2];
                    } else {
                        str = str2;
                    }
                    if (strArr.length >= 4) {
                        str3 = strArr[3];
                    }
                    if (strArr.length >= 5) {
                        bsw = new bsw();
                        bsw.aAL = "sdk";
                        bsw.value = strArr[4];
                        linkedList.add(bsw);
                    } else {
                        bsw = new bsw();
                        bsw.aAL = "sdk";
                        bsw.value = String.valueOf(VERSION.SDK_INT);
                        linkedList.add(bsw);
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        bsw = (bsw) it.next();
                        stringBuilder.append(bsw.aAL).append(":").append(bsw.value).append("\n");
                    }
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "BaseID:%s PatchID:%s %s", str, str3, stringBuilder.toString());
                    au.DF().a(new com.tencent.mm.plugin.hp.c.a(str, str3, linkedList), 0);
                    return true;
                case true:
                    i.a(ad.getContext().getString(R.l.fmt_update), ad.getContext().getString(R.l.fmt_update), ad.getContext().getString(R.l.install_now), new 1(this), ad.getContext().getString(R.l.update_cancel), null);
                    return true;
                case true:
                    au.Em().H(new 2(this, strArr));
                    return true;
                case true:
                    bta = new bta();
                    bta.sqw = 1000;
                    bta.sqt = 2;
                    bta.squ = 2;
                    bta.state = 2;
                    bta.rsQ = "android_tinker_id_123123131231231";
                    bhl = new bhl();
                    bhl.rwt = "c3282ad2467fad9561227bc9b5b6712c";
                    bhl.ruE = 118617;
                    bhl.jPK = "http://dldir1.qq.com/weixin/checkresupdate/0x2605136d.3144f5.0x26051334.bf52fb_1510754399.apk";
                    bta.sqt = 3;
                    bhl.rwt = "3ba62fdbd98df2bdf5da7d726010d867";
                    bhl.ruE = 33338711;
                    bhl.jPK = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    bta.sqv = bhl;
                    new e(new com.tencent.mm.plugin.hp.d.b(bta)).fL(false);
                    return true;
                case true:
                    if (strArr.length >= 6) {
                        bi.WV(strArr[5]);
                    }
                    return true;
                case true:
                    com.tencent.mm.plugin.hp.tinker.g.as(ad.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.at(ad.getContext(), "");
                    com.tencent.mm.plugin.hp.tinker.g.G(ad.getContext(), 0);
                    i.ccl();
                    return true;
                case true:
                    bta = new bta();
                    bta.sqw = 1000;
                    bta.sqt = 3;
                    bta.squ = 2;
                    bta.state = 2;
                    bta.rsQ = "android_tinker_id_123123131231231";
                    bhl = new bhl();
                    bhl.rwt = "3ba62fdbd98df2bdf5da7d726010d867";
                    bhl.ruE = 33338711;
                    bhl.jPK = "http://dldir1.qq.com/weixin/checkresupdate/0x26051363.6cc887.0x26051087.a44d04_1510750804.apk";
                    bta.sqv = bhl;
                    bsy bsy = new bsy();
                    bsy.aAL = "clientVersion";
                    bsy.value = "0x26060510";
                    bta.sqx.add(bsy);
                    bsy = new bsy();
                    bsy.aAL = "alphaTitle";
                    bsy.value = "叫你更新你就更新";
                    bta.sqx.add(bsy);
                    bsy = new bsy();
                    bsy.aAL = "alphaContent";
                    bsy.value = "这个包可以抢到的红包最大，抢红包速度最快。";
                    bta.sqx.add(bsy);
                    bsy = new bsy();
                    bsy.aAL = "alphaUrl";
                    bsy.value = "www.qq.com";
                    bta.sqx.add(bsy);
                    new e(new com.tencent.mm.plugin.hp.d.b(bta)).fL(true);
                    return true;
                default:
                    x.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a debugger command.", str);
                    break;
            }
        }
        z = true;
        switch (str.hashCode()) {
            case 94627080:
                if (str.equals("check")) {
                    z = false;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
                try {
                    com.tinkerboots.sdk.a.cJC().na(true);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Tinker.TinkerBootsCommand", e, "", new Object[0]);
                }
                return true;
            default:
                x.d("MicroMsg.Tinker.TinkerBootsCommand", "%s is not a release command.", str);
                return false;
        }
    }
}
