package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.l.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.sns.b.k;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.contact.SnsTagContactListUI.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

class SnsTagContactListUI$a extends BaseAdapter {
    private Context context = null;
    private ay nUe = null;
    private Map<Integer, a> uma = new HashMap();
    private ColorStateList umb;
    private ColorStateList umc;
    private Map<Integer, String> umi = new HashMap();

    public SnsTagContactListUI$a(Context context, List<Long> list) {
        this.context = context;
        this.uma.clear();
        this.umi.clear();
        au.HU();
        this.nUe = c.FR();
        int i = 0;
        for (Long longValue : list) {
            long longValue2 = longValue.longValue();
            k kVar = n.nkA;
            if (kVar != null) {
                for (String str : kVar.eD(longValue2)) {
                    a aVar = new a();
                    aVar.setUsername(str);
                    this.umi.put(Integer.valueOf(this.uma.size()), kVar.eE(longValue2));
                    int i2 = i + 1;
                    this.uma.put(Integer.valueOf(i), aVar);
                    i = i2;
                }
            }
            i = i;
        }
        try {
            XmlPullParser xml = context.getResources().getXml(R.e.mm_list_textcolor_one);
            XmlPullParser xml2 = context.getResources().getXml(R.e.mm_list_textcolor_spuser);
            this.umb = ColorStateList.createFromXml(context.getResources(), xml);
            this.umc = ColorStateList.createFromXml(context.getResources(), xml2);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SnsTagContactList", e, "", new Object[0]);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsTagContactList", e2, "", new Object[0]);
        }
    }

    public final int getCount() {
        return this.uma.size();
    }

    public final Object getItem(int i) {
        if (i < 0) {
            return null;
        }
        a aVar = (a) this.uma.get(Integer.valueOf(i));
        if (aVar.field_showHead != 0) {
            return aVar;
        }
        ab Yg = this.nUe.Yg(aVar.field_username);
        if (Yg == null) {
            return aVar;
        }
        this.uma.put(Integer.valueOf(i), Yg);
        return Yg;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.contact_item, null);
            b bVar2 = new b((byte) 0);
            bVar2.kuR = (TextView) view.findViewById(R.h.contactitem_catalog);
            bVar2.hPe = (MaskLayout) view.findViewById(R.h.contactitem_avatar);
            bVar2.eMf = (TextView) view.findViewById(R.h.contactitem_nick);
            bVar2.ume = (TextView) view.findViewById(R.h.contactitem_account);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        if (((a) getItem(i - 1)) == null) {
            Object obj = "";
        } else {
            String obj2 = FP(i - 1);
        }
        a aVar = (a) getItem(i);
        if (i == 0) {
            bVar.kuR.setVisibility(0);
            bVar.kuR.setText(FP(i));
            bVar.kuR.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else if (i <= 0 || FP(i).equals(obj2)) {
            bVar.kuR.setVisibility(8);
        } else {
            bVar.kuR.setVisibility(0);
            bVar.kuR.setText(FP(i));
            bVar.kuR.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        bVar.eMf.setTextColor(!s.hO(aVar.field_username) ? this.umb : this.umc);
        com.tencent.mm.pluginsdk.ui.a.b.p((ImageView) bVar.hPe.getContentView(), aVar.field_username);
        bVar.ume.setVisibility(8);
        bVar.hPe.setVisibility(0);
        bVar.eMf.setText(j.a(this.context, aVar.BL(), bVar.eMf.getTextSize()));
        bVar.eMf.setVisibility(0);
        return view;
    }

    private String FP(int i) {
        if (this.umi.containsKey(Integer.valueOf(i))) {
            return (String) this.umi.get(Integer.valueOf(i));
        }
        return "";
    }
}
