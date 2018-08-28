package com.tencent.mm.pluginsdk.ui.applet;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.R;
import com.tencent.mm.aa.f.c;
import com.tencent.mm.aa.q;
import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public final class b implements c, a, o {
    private String dlQ;
    ProgressDialog eEX;
    private int fdx;
    String gtX;
    ab ipd;
    Context mContext;
    private n qIh;
    com.tencent.mm.ui.widget.a.c qIi;
    e qIj;
    private boolean qIk;

    public b(Context context, String str, n nVar) {
        this(context, str, 0, nVar, true, "");
    }

    public b(Context context, String str, int i, n nVar, String str2) {
        this(context, str, i, nVar, true, str2);
    }

    public b(Context context, String str, int i, n nVar, boolean z, String str2) {
        this.qIj = null;
        this.qIk = true;
        this.mContext = context;
        this.gtX = str;
        this.fdx = i;
        this.qIh = nVar;
        this.qIk = z;
        this.dlQ = str2;
    }

    public final void show() {
        g.Ek();
        this.ipd = ((i) g.l(i.class)).FR().Yg(this.gtX);
        if (this.ipd != null && ((int) this.ipd.dhP) <= 0) {
            x.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", new Object[]{this.gtX});
            g.Ek();
            this.ipd = ((i) g.l(i.class)).FR().Yd(this.gtX);
        }
        Context context;
        if (this.ipd != null && ((int) this.ipd.dhP) > 0) {
            x.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
            if (this.ipd == null) {
                x.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
                gW(-1);
                return;
            }
            String str = this.ipd.field_username;
            if (this.ipd.ckW()) {
                if (com.tencent.mm.l.a.gd(this.ipd.field_type)) {
                    h.bA(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
                    gW(-2);
                    return;
                }
                O(this.ipd);
            } else if (((com.tencent.mm.api.h) g.l(com.tencent.mm.api.h.class)).cB(str)) {
                context = this.mContext;
                this.mContext.getString(R.l.app_tip);
                this.eEX = h.a(context, this.mContext.getString(R.l.wv_following), true, null);
                TD(str);
            } else {
                Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.confirm_dialog_failweb);
                if ((this.mContext instanceof MMActivity) && g.a(((MMActivity) this.mContext).mController, decodeResource, this.mContext.getResources().getString(R.l.wv_is_not_biz_contact), new 5(this)) == null) {
                    x.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
                    gW(-1);
                }
            }
        } else if (this.mContext != null) {
            context = this.mContext;
            this.mContext.getString(R.l.app_tip);
            this.eEX = h.a(context, this.mContext.getString(R.l.wv_following), true, new 1(this));
            TD(this.gtX);
        }
    }

    final void O(ab abVar) {
        if (abVar == null) {
            x.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
            gW(-1);
            return;
        }
        String string = this.mContext.getString(R.l.wv_follow_brand_account);
        Bitmap a = com.tencent.mm.aa.c.a(abVar.field_username, false, -1);
        if (a == null) {
            q.Kp().a(this);
        }
        if (a != null && abVar.ckW()) {
            a = com.tencent.mm.sdk.platformtools.c.a(a, false, (float) (a.getWidth() / 2));
        }
        String str = abVar.field_nickname;
        this.qIi = null;
        if (this.mContext instanceof MMActivity) {
            if (this.qIk) {
                int i = R.l.contact_info_biz_add;
                abVar.ckW();
                this.qIi = g.a(((MMActivity) this.mContext).mController, string, a, str, "", i, new 2(this, abVar));
            } else {
                P(abVar);
                return;
            }
        }
        if (this.qIi == null) {
            x.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
            gW(-1);
        }
    }

    final void P(ab abVar) {
        if (this.eEX != null) {
            this.eEX.dismiss();
        }
        Context context = this.mContext;
        this.mContext.getString(R.l.app_tip);
        this.eEX = h.a(context, this.mContext.getString(R.l.wv_following), true, null);
        a aVar = new a(this.mContext, this);
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.fdx));
        aVar.a(abVar.field_username, linkedList, this.dlQ);
    }

    public final void jX(String str) {
        Object obj = 1;
        if (this.ipd != null) {
            Object obj2 = (this.ipd.field_username == null || !this.ipd.field_username.equals(str)) ? null : 1;
            if (this.ipd.wM() == null || !this.ipd.wM().equals(str)) {
                obj = null;
            }
            if (obj2 == null && obj == null) {
                return;
            }
        } else if (this.gtX == null || !this.gtX.equals(str)) {
            return;
        }
        if (this.qIi != null && this.qIi.isShowing()) {
            ah.A(new 3(this));
        }
    }

    private void TD(String str) {
        x.i("MicroMsg.AddContactDialog", "searchContact %s", new Object[]{str});
        if (this.qIj == null) {
            this.qIj = new 4(this);
        }
        g.Ek();
        g.Eh().dpP.a(i$l.AppCompatTheme_ratingBarStyle, this.qIj);
        f fVar = new f(str);
        g.Ek();
        g.Eh().dpP.a(fVar, 0);
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (this.eEX != null) {
            this.eEX.dismiss();
        }
        if (z) {
            this.ipd.Bb();
            g.Ek();
            ((i) g.l(i.class)).FR().a(this.ipd.field_username, this.ipd);
            h.bA(this.mContext, this.mContext.getResources().getString(R.l.wv_has_follow));
            gW(1);
            return;
        }
        gW(-1);
    }

    final void gW(int i) {
        if (this.qIh != null) {
            this.qIh.ky(i);
        }
    }
}
