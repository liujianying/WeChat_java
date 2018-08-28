package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.a.e;
import com.tencent.mm.ac.a.j;
import com.tencent.mm.ac.a.k;
import com.tencent.mm.ac.z;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.bizchat.BizChatAtSomeoneUI.b;
import com.tencent.mm.ui.r;
import java.util.List;

class BizChatAtSomeoneUI$a extends r<j> {
    String dBm;
    private List<String> gRN;
    private c hOC = null;
    private com.tencent.mm.ac.a.c tDV;
    private String[] tDY;
    private Bitmap tDZ;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        j jVar = new j();
        jVar.d(cursor);
        return jVar;
    }

    protected final /* bridge */ /* synthetic */ Object aVa() {
        return null;
    }

    public BizChatAtSomeoneUI$a(Context context, j jVar, com.tencent.mm.ac.a.c cVar, String[] strArr, List<String> list) {
        super(context, jVar);
        this.tDV = cVar;
        this.tDY = strArr;
        this.gRN = list;
        a aVar = new a();
        aVar.dXB = e.lj(this.tDV.field_brandUserName);
        aVar.dXy = true;
        aVar.dXV = true;
        aVar.dXN = R.k.default_avatar;
        this.hOC = aVar.Pt();
        this.tDZ = com.tencent.mm.sdk.platformtools.c.s(context.getResources().getDrawable(R.k.at_all_avater));
    }

    protected final int aUZ() {
        return BizChatAtSomeoneUI.access$100() ? 1 : 0;
    }

    public final boolean qY(int i) {
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        b bVar;
        if (view == null) {
            inflate = View.inflate(this.context, R.i.at_someone_item, null);
            bVar = new b((byte) 0);
            bVar.hPe = (MaskLayout) inflate.findViewById(R.h.at_someone_item_avatar);
            bVar.eMf = (TextView) inflate.findViewById(R.h.at_someone_item_nick);
            inflate.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
            inflate = view;
        }
        if (i == 0 && BizChatAtSomeoneUI.access$100()) {
            bVar.tEa.setImageBitmap(this.tDZ);
            bVar.eMf.setText(this.context.getResources().getString(R.l.at_all, new Object[]{"@"}));
            return inflate;
        }
        j jVar = (j) getItem(i - (BizChatAtSomeoneUI.access$100() ? 1 : 0));
        bVar.eMf.setTextColor(com.tencent.mm.bp.a.ac(this.context, R.e.mm_list_textcolor_one));
        o.Pj().a(jVar.field_headImageUrl, (ImageView) bVar.hPe.getContentView(), this.hOC);
        bVar.hPe.setMaskDrawable(null);
        bVar.eMf.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, BizChatAtSomeoneUI.a(this.tDV, jVar.field_userId), bVar.eMf.getTextSize()));
        return inflate;
    }

    public final void WT() {
        String str;
        aYc();
        k Nc = z.Nc();
        String[] strArr = this.tDY;
        String str2 = this.dBm;
        List list = this.gRN;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select *  from BizChatUserInfo where ");
        StringBuilder append = stringBuilder.append(k.a(strArr, list));
        if (str2 == null || str2.equals("")) {
            str = "";
        } else {
            str = " and (" + "userName like '%" + str2 + "%' )";
        }
        append.append(str);
        StringBuilder append2 = stringBuilder.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(BizChatUserInfo.userNamePY) ");
        stringBuffer.append(" else upper(BizChatUserInfo.userName) end asc, ");
        stringBuffer.append(" upper(BizChatUserInfo.userNamePY) asc, ");
        stringBuffer.append(" upper(BizChatUserInfo.userName) asc ");
        append2.append(stringBuffer.toString());
        setCursor(Nc.diF.rawQuery(stringBuilder.toString(), null));
        super.notifyDataSetChanged();
    }

    protected final void WS() {
        WT();
    }
}
