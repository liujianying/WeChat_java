package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.b;
import com.tencent.mm.plugin.comm.a;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.c;
import java.util.LinkedList;
import junit.framework.Assert;

public final class s implements e {
    String content = "";
    Context context;
    View eIU;
    c eIW = null;
    EditText meN;
    LinkedList<Integer> mjw;
    TextView mlc;
    private LinkedList<String> qHY = new LinkedList();
    String qHZ;
    a qJI;
    LinkedList<String> qJJ;
    boolean qJK = true;
    private boolean qJL = false;
    p tipDialog;

    public s(Context context, a aVar) {
        this.context = context;
        this.qJI = aVar;
    }

    final void onStart() {
        g.Eh().dpP.a(30, this);
        g.Eh().dpP.a(com.tencent.mm.plugin.appbrand.jsapi.h.g.CTRL_INDEX, this);
    }

    final void onStop() {
        g.Eh().dpP.b(30, this);
        g.Eh().dpP.b(com.tencent.mm.plugin.appbrand.jsapi.h.g.CTRL_INDEX, this);
        if (this.eIW != null) {
            this.eIW.dismiss();
            this.eIW = null;
        }
    }

    public final void g(LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        a(linkedList, linkedList2, new LinkedList());
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Integer> linkedList2, LinkedList<String> linkedList3) {
        boolean z;
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.qJJ = linkedList;
        this.mjw = linkedList2;
        this.qHY = linkedList3;
        this.eIU = View.inflate(this.context, f.sendrequest_dialog, null);
        String str = "MicroMsg.SendVerifyRequest";
        String str2 = "verifyTip is null: %b, length : %d, value : [%s]";
        Object[] objArr = new Object[3];
        if (this.qHZ == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.qHZ == null ? 0 : this.qHZ.length());
        objArr[2] = this.qHZ;
        x.i(str, str2, objArr);
        if (!bi.oW(this.qHZ)) {
            ((TextView) this.eIU.findViewById(a.e.sendrequest_tip)).setText(this.qHZ);
        }
        this.meN = (EditText) this.eIU.findViewById(a.e.sendrequest_content);
        this.mlc = (TextView) this.eIU.findViewById(a.e.wordcount);
        this.mlc.setVisibility(0);
        this.meN.setText(null);
        this.mlc.setText("50");
        this.meN.setFilters(h.qTb);
        this.meN.addTextChangedListener(new 1(this));
        this.eIW = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(a.h.sendrequest_title), this.eIU, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (s.this.eIW != null) {
                    s.this.eIW.dismiss();
                    s.this.eIW = null;
                }
                new al(new 1(this), false).J(500, 500);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (s.this.eIW != null) {
                    s.this.eIW.dismiss();
                    s.this.eIW = null;
                }
                s.this.onStop();
                if (s.this.qJI != null) {
                    s.this.qJI.ea(false);
                }
            }
        });
        if (this.eIW == null) {
            onStop();
        }
        this.meN.post(new Runnable() {
            public final void run() {
                if (s.this.context instanceof MMActivity) {
                    ((MMActivity) s.this.context).showVKB();
                }
            }
        });
    }

    final void cdY() {
        if (this.qHY.isEmpty()) {
            this.qJL = true;
            g.Eh().dpP.a(881, this);
            g.Eh().dpP.a(new b((String) this.qJJ.getFirst(), "", ""), 0);
            return;
        }
        g.Eh().dpP.a(new com.tencent.mm.openim.b.f((String) this.qJJ.getFirst(), this.content, (String) this.qHY.getFirst()), 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 881) {
            g.Eh().dpP.b(881, this);
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.context, this.context.getString(a.h.sendrequest_send_fail), 1).show();
            } else if (this.qJL) {
                g.Eh().dpP.a(new com.tencent.mm.openim.b.f((String) this.qJJ.getFirst(), this.content, ((b) lVar).eur.rcw), 0);
            }
            this.qJL = false;
        } else if (lVar.getType() == 30 || lVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.h.g.CTRL_INDEX) {
            x.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            onStop();
            if (i == 0 && i2 == 0) {
                if (this.qJK) {
                    com.tencent.mm.ui.base.h.bA(this.context, this.context.getString(a.h.sendrequest_send_success));
                }
                this.qJI.ea(true);
                return;
            }
            CharSequence str2;
            if (i == 4 && i2 == -34) {
                str2 = this.context.getString(a.h.fmessage_request_too_offen);
            } else if (i == 4 && i2 == -94) {
                str2 = this.context.getString(a.h.fmessage_user_not_support);
            } else if (!(i == 4 && i2 == -24 && !bi.oW(str2)) && (i != 4 || bi.oW(str2))) {
                str2 = this.context.getString(a.h.sendrequest_send_fail);
            }
            if (this.qJK) {
                Toast.makeText(this.context, str2, 1).show();
            }
            this.qJI.ea(false);
        } else {
            x.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + lVar.getType());
        }
    }
}
