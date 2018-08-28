package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.support.design.a$i;
import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.b;

public class m extends a {
    public CharSequence eCh;
    public CharSequence eCi;
    public l fyJ;
    public int jyF;
    public CharSequence jyG;
    private b jyH = new b(this);
    a jyI = new a(this);
    public String username;

    public m(int i) {
        super(6, i);
    }

    public void a(Context context, a.a aVar, Object... objArr) {
        a aVar2 = (a) aVar;
        this.username = this.fyJ.jrv;
        this.eCh = j.b(context, d.Bc(this.username), aVar2.eTm.getTextSize());
        if (this.fyJ.userData instanceof Integer) {
            this.jyF = ((Integer) this.fyJ.userData).intValue();
        }
        if (this.jyF < 2) {
            CharSequence charSequence = "";
            String str = "";
            bd dW = ((i) g.l(i.class)).bcY().dW(this.fyJ.jsA);
            com.tencent.mm.y.g.a gp;
            String str2;
            Object charSequence2;
            switch (this.fyJ.jru) {
                case 41:
                    str = dW.field_content;
                    if (s.fq(this.username)) {
                        str = com.tencent.mm.model.bd.iC(str);
                        break;
                    }
                    break;
                case a$i.AppCompatTheme_dialogTheme /*42*/:
                    gp = com.tencent.mm.y.g.a.gp(dW.field_content);
                    if (gp != null) {
                        str2 = gp.title;
                    } else {
                        str2 = str;
                    }
                    charSequence2 = context.getString(n.g.fts_message_file_tag);
                    str = str2;
                    break;
                case a$i.AppCompatTheme_dialogPreferredPadding /*43*/:
                    gp = com.tencent.mm.y.g.a.gp(dW.field_content);
                    if (gp != null) {
                        str = gp.title;
                    }
                    charSequence2 = context.getString(n.g.fts_message_link_tag);
                    break;
                case a$i.AppCompatTheme_listDividerAlertDialog /*44*/:
                    com.tencent.mm.y.g.a gp2 = com.tencent.mm.y.g.a.gp(dW.field_content);
                    if (gp2 != null) {
                        str2 = gp2.title + ": ";
                        str = gp2.description;
                        charSequence2 = str2;
                        break;
                    }
                    break;
                case a$i.AppCompatTheme_actionDropDownStyle /*45*/:
                    gp = com.tencent.mm.y.g.a.gp(dW.field_content);
                    if (gp != null) {
                        str = bi.aG(gp.title, "") + ": " + bi.aG(gp.description, "");
                        break;
                    }
                    break;
                case a$i.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                case a$i.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    com.tencent.mm.y.g.a gp3 = com.tencent.mm.y.g.a.gp(dW.field_content);
                    if (dW.field_isSend != 1) {
                        str = bi.aG(gp3.dxZ, "") + ": " + bi.aG(gp3.dxV, "");
                        break;
                    } else {
                        str = bi.aG(gp3.dxZ, "") + ": " + bi.aG(gp3.dxW, "");
                        break;
                    }
                case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
                    gp = com.tencent.mm.y.g.a.gp(dW.field_content);
                    if (gp != null) {
                        str = gp.title;
                    }
                    charSequence2 = context.getString(n.g.fts_message_appbrand_tag);
                    break;
                case a$i.AppCompatTheme_actionButtonStyle /*49*/:
                    gp = com.tencent.mm.y.g.a.gp(dW.field_content);
                    if (gp != null) {
                        str = gp.description;
                    }
                    charSequence2 = context.getString(n.g.fts_message_note_tag);
                    break;
                case 50:
                    str2 = dW.field_content;
                    if (s.fq(this.username)) {
                        str = com.tencent.mm.model.bd.iC(str2);
                    } else {
                        str = str2;
                    }
                    b GS = ((i) g.l(i.class)).bcY().GS(str);
                    if (GS.cmK()) {
                        str = GS.kFa;
                    }
                    charSequence2 = context.getString(n.g.fts_message_location_tag);
                    break;
            }
            this.eCi = j.b(context, bi.aG(str, "").replace(10, ' '), (float) c.jvy);
            if (bi.K(charSequence2)) {
                this.eCi = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.eCi, this.jrx, (float) com.tencent.mm.plugin.fts.ui.b.a.jvq, c.jvz)).jrO;
            } else {
                this.eCi = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.eCi, this.jrx, ((float) com.tencent.mm.plugin.fts.ui.b.a.jvq) - c.jvz.measureText(charSequence2.toString()), c.jvz)).jrO;
                this.eCi = TextUtils.concat(new CharSequence[]{charSequence2, this.eCi});
            }
            this.jyG = h.c(context, this.fyJ.timestamp, true);
            return;
        }
        this.eCi = context.getResources().getString(n.g.search_message_count, new Object[]{Integer.valueOf(this.jyF)});
    }

    public a.b BV() {
        return this.jyH;
    }

    protected final a.a afD() {
        return this.jyI;
    }

    public final int afF() {
        return this.fyJ.jsJ;
    }

    public int aQj() {
        if (this.jyF < 2) {
            return 0;
        }
        return 1;
    }
}
