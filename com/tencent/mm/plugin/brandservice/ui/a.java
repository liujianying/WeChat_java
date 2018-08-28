package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.ac.d$b.d;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.qu;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.sortview.a.b;
import java.util.List;

public final class a extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b hnW;
    protected CharSequence hnX;
    protected CharSequence hnY;
    protected CharSequence hnZ;
    protected boolean hoa;
    protected boolean hob;
    protected String iconUrl;
    protected CharSequence nickName;
    protected String username;

    public a(Object obj) {
        super(5, obj);
    }

    public final b auQ() {
        if (hnW == null) {
            hnW = new b();
        }
        return hnW;
    }

    public final com.tencent.mm.ui.base.sortview.a.a auR() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.ui.base.sortview.a.a aVar, Object... objArr) {
        d dVar = null;
        if (!this.tDC) {
            if (context == null || aVar == null || this.data == null) {
                x.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                x.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (this.data instanceof jz) {
                a aVar2 = (a) aVar;
                jz jzVar = (jz) this.data;
                if (jzVar.rlB == null || jzVar.rlB.rlj == null) {
                    x.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return;
                }
                com.tencent.mm.ac.d dVar2;
                bjv bjv = jzVar.rlB.rlj;
                jv jvVar = jzVar.rlB.rlg;
                if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                    this.hqc = (List) objArr[1];
                }
                this.username = bjv.rvi.siM;
                this.iconUrl = bjv.rra;
                this.hnY = jvVar == null ? "" : jvVar.rlp;
                String str = bjv.rQz == null ? null : bjv.rQz.siM;
                try {
                    List list = this.hqc;
                    aVar2.eMf.getTextSize();
                    this.nickName = com.tencent.mm.plugin.brandservice.b.a.b(context, str, list);
                } catch (Exception e) {
                    this.nickName = "";
                }
                String str2 = bjv.rvi.siM;
                qu quVar = bjv.sjI;
                if (quVar != null) {
                    dVar2 = new com.tencent.mm.ac.d();
                    dVar2.field_username = str2;
                    com.tencent.mm.plugin.brandservice.b.a.a(dVar2, quVar);
                } else {
                    dVar2 = null;
                }
                if (!(dVar2 == null || dVar2.bG(false) == null)) {
                    dVar = dVar2.bG(false).Mt();
                }
                if (dVar != null) {
                    boolean z;
                    if (!dVar2.bG(false).Mv() || bi.oW(dVar.dLJ)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.hob = z;
                    this.hoa = bjv.rTe != 0;
                }
                x.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[]{Integer.valueOf(bjv.rTe)});
                String str3 = bjv.eJM;
                if (this.hqc.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.hqc.get(0)).toLowerCase())) {
                    try {
                        List list2 = this.hqc;
                        aVar2.hog.getTextSize();
                        this.hnZ = com.tencent.mm.plugin.brandservice.b.a.b(context, str3, list2);
                        this.hnZ = TextUtils.concat(new CharSequence[]{context.getResources().getString(h.search_contact_tag_wxid), this.hnZ});
                    } catch (Exception e2) {
                        this.hnZ = "";
                    }
                }
                if (this.hnZ == null || this.hnZ.length() == 0 || this.hnY == null || this.hnY.length() == 0) {
                    try {
                        str = bjv.eJK;
                        List list3 = this.hqc;
                        aVar2.hoe.getTextSize();
                        this.hnX = com.tencent.mm.plugin.brandservice.b.a.b(context, str, list3);
                    } catch (Exception e3) {
                        this.hnX = "";
                    }
                }
                x.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[]{this.nickName, this.hnY});
                this.tDC = true;
            } else {
                x.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }
    }
}
