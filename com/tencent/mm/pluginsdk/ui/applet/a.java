package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.p;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class a implements e {
    private String chatroomName = "";
    private Context context;
    public String eNh = "";
    public String juZ = "";
    private LinkedList<String> mjv;
    private LinkedList<Integer> mjw;
    private a qHW;
    public b qHX;
    private LinkedList<String> qHY;
    public String qHZ;
    String qIa = "";
    public String qIb;
    public String qIc;
    public boolean qId = true;
    public boolean qIe = true;
    public boolean qIf = false;
    private p tipDialog;

    public a(Context context, a aVar) {
        this.context = context;
        this.qHW = aVar;
        this.mjv = new LinkedList();
        this.qHY = new LinkedList();
        this.tipDialog = null;
    }

    public final void b(String str, String str2, LinkedList<Integer> linkedList) {
        this.chatroomName = str2;
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void c(String str, LinkedList<Integer> linkedList) {
        a(str, (LinkedList) linkedList, false, "");
    }

    public final void a(String str, LinkedList<Integer> linkedList, String str2) {
        a(str, (LinkedList) linkedList, false, str2);
    }

    public final void TC(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.qHY.add(str);
        }
    }

    public final void b(String str, LinkedList<Integer> linkedList, boolean z) {
        a(str, (LinkedList) linkedList, z, "");
    }

    private void a(String str, LinkedList<Integer> linkedList, boolean z, String str2) {
        boolean z2 = str != null && str.length() > 0;
        Assert.assertTrue(z2);
        if (linkedList != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.qId = z;
        g.Eh().dpP.a(30, this);
        g.Eh().dpP.a(667, this);
        if (this.qIe) {
            Context context = this.context;
            this.context.getString(h.app_tip);
            this.tipDialog = com.tencent.mm.ui.base.h.a(context, this.context.getString(h.contact_info_adding_tip), true, new 1(this));
        }
        this.mjw = linkedList;
        this.mjv.add(str);
        this.qIa = str;
        if (ab.XR(str)) {
            g.Eh().dpP.a(new com.tencent.mm.openim.b.a(str, this.qHY.isEmpty() ? "" : (String) this.qHY.getFirst()), 0);
            return;
        }
        m mVar = new m(1, this.mjv, linkedList, this.qHY, "", this.juZ, null, this.chatroomName, str2);
        if (!bi.oW(this.qIb)) {
            mVar.fy(this.qIb, this.qIc);
        }
        g.Eh().dpP.a(mVar, 0);
    }

    private void c(boolean z, boolean z2, String str, String str2) {
        if (this.qHW != null) {
            this.qHW.a(z, z2, str, str2);
        }
        if (z) {
            jn jnVar = new jn();
            jnVar.bTh.username = str;
            com.tencent.mm.sdk.b.a.sFg.m(jnVar);
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.AddContact", "onSceneEnd, errType = " + i + ", errCode = " + i2 + "," + str);
        if (lVar.getType() == 30 || lVar.getType() == 667) {
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            g.Eh().dpP.b(30, this);
            g.Eh().dpP.b(667, this);
            if (i == 0 && i2 == 0) {
                if (lVar.getType() == 30) {
                    this.qIa = ((m) lVar).cby();
                } else if (lVar.getType() == 667) {
                    this.qIa = ((com.tencent.mm.openim.b.a) lVar).eup;
                }
                c(true, false, this.qIa, this.eNh);
                return;
            } else if (i2 == -44) {
                String str2 = this.eNh;
                if (this.qHX != null) {
                    this.qHX.pm(this.qHY.isEmpty() ? "" : (String) this.qHY.getFirst());
                    c(false, false, this.qIa, str2);
                    return;
                }
                s sVar = new s(this.context, new 4(this));
                if (this.qHZ != null) {
                    sVar.qHZ = this.qHZ;
                }
                if (this.qId) {
                    List list = this.mjv;
                    List list2 = this.mjw;
                    sVar.qJK = false;
                    sVar.onStart();
                    sVar.qJJ = list;
                    sVar.mjw = list2;
                    if (list.size() == 1 && ab.XR((String) list.getFirst())) {
                        sVar.cdY();
                        return;
                    } else {
                        g.Eh().dpP.a(new m(2, list, list2, "", ""), 0);
                        return;
                    }
                }
                sVar.a(this.mjv, this.mjw, this.qHY);
                return;
            } else if (i2 == -87) {
                com.tencent.mm.ui.base.h.b(this.context, this.context.getString(h.contact_info_biz_join_fans_limit), "", true);
                return;
            } else if (i2 == -101 && !bi.oW(str)) {
                x.d("MicroMsg.AddContact", "jacks catch add Contact errCode: %d && errMsg: %s", new Object[]{Integer.valueOf(i2), str});
                com.tencent.mm.ui.base.h.a(this.context, str, "", false, new 2(this));
                return;
            } else if (i2 == -302) {
                if (lVar.getType() != 667) {
                    x.d("MicroMsg.AddContact", "onSceneEnd, verify relation out of date, opCode = %d", new Object[]{Integer.valueOf(((m) lVar).bOh)});
                    if (((m) lVar).bOh == 3) {
                        com.tencent.mm.ui.base.h.a(this.context, this.context.getString(h.contact_info_verify_outofdate_msg), this.context.getString(h.app_tip), this.context.getString(h.app_add), this.context.getString(h.app_cancel), new 3(this, lVar), null);
                        return;
                    }
                    return;
                }
                return;
            } else if (i2 != -2) {
                s(i, i2, str);
                return;
            } else if (bi.oW(str)) {
                s(i, i2, null);
                return;
            } else {
                com.tencent.mm.ui.base.h.a(this.context, str, this.context.getString(h.app_tip), this.context.getString(h.app_ok), null);
                return;
            }
        }
        x.w("MicroMsg.AddContact", "not expected scene,  type = " + lVar.getType());
    }

    private void s(int i, int i2, String str) {
        if (this.qIf && !bi.oW(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else if (i == 4 && i2 == -22) {
            Toast.makeText(this.context, this.context.getString(h.addcontact_fail_blacklist), 1).show();
        } else if (i == 4 && i2 == -24 && !bi.oW(str)) {
            Toast.makeText(this.context, str, 1).show();
        } else {
            Toast.makeText(this.context, this.context.getString(h.addcontact_fail), 1).show();
        }
        c(false, false, this.qIa, this.eNh);
    }
}
