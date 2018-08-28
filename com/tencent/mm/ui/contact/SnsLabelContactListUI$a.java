package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.XmlResourceParser;
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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.ui.base.MaskLayout;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

class SnsLabelContactListUI$a extends BaseAdapter {
    private Context context = null;
    private ay nUe = null;
    private Map<Integer, a> uma = new HashMap();
    private ColorStateList umb;
    private ColorStateList umc;

    public SnsLabelContactListUI$a(Context context, List<String> list) {
        Throwable e;
        XmlResourceParser xmlResourceParser;
        XmlResourceParser xmlResourceParser2;
        int i = 0;
        this.context = context;
        this.uma.clear();
        au.HU();
        this.nUe = c.FR();
        Iterator it = list.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                String str = (String) it.next();
                a aVar = new a();
                aVar.setUsername(str);
                i = i2 + 1;
                this.uma.put(Integer.valueOf(i2), aVar);
            } else {
                try {
                    break;
                } catch (XmlPullParserException e2) {
                    e = e2;
                    xmlResourceParser = null;
                    xmlResourceParser2 = null;
                } catch (IOException e3) {
                    e = e3;
                    xmlResourceParser = null;
                    xmlResourceParser2 = null;
                    x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                    if (xmlResourceParser2 != null) {
                        xmlResourceParser2.close();
                    }
                    if (xmlResourceParser == null) {
                        xmlResourceParser.close();
                    }
                } catch (Throwable th) {
                    e = th;
                    xmlResourceParser = null;
                    xmlResourceParser2 = null;
                    if (xmlResourceParser2 != null) {
                        xmlResourceParser2.close();
                    }
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw e;
                }
            }
        }
        xmlResourceParser2 = context.getResources().getXml(R.e.mm_list_textcolor_one);
        try {
            xmlResourceParser = context.getResources().getXml(R.e.mm_list_textcolor_spuser);
            try {
                this.umb = ColorStateList.createFromXml(context.getResources(), xmlResourceParser2);
                this.umc = ColorStateList.createFromXml(context.getResources(), xmlResourceParser);
                if (xmlResourceParser2 != null) {
                    xmlResourceParser2.close();
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (XmlPullParserException e4) {
                e = e4;
                try {
                    x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                    if (xmlResourceParser2 != null) {
                        xmlResourceParser2.close();
                    }
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (xmlResourceParser2 != null) {
                        xmlResourceParser2.close();
                    }
                    if (xmlResourceParser != null) {
                        xmlResourceParser.close();
                    }
                    throw e;
                }
            } catch (IOException e5) {
                e = e5;
                x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
                if (xmlResourceParser2 != null) {
                    xmlResourceParser2.close();
                }
                if (xmlResourceParser == null) {
                    xmlResourceParser.close();
                }
            }
        } catch (XmlPullParserException e6) {
            e = e6;
            xmlResourceParser = null;
        } catch (IOException e7) {
            e = e7;
            xmlResourceParser = null;
            x.printErrStackTrace("MicroMsg.SnsLabelContactListUI", e, "", new Object[0]);
            if (xmlResourceParser2 != null) {
                xmlResourceParser2.close();
            }
            if (xmlResourceParser == null) {
                xmlResourceParser.close();
            }
        } catch (Throwable th3) {
            e = th3;
            xmlResourceParser = null;
            if (xmlResourceParser2 != null) {
                xmlResourceParser2.close();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw e;
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
        SnsLabelContactListUI.c cVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.contact_item, null);
            SnsLabelContactListUI.c cVar2 = new SnsLabelContactListUI.c((byte) 0);
            cVar2.kuR = (TextView) view.findViewById(R.h.contactitem_catalog);
            cVar2.hPe = (MaskLayout) view.findViewById(R.h.contactitem_avatar);
            cVar2.eMf = (TextView) view.findViewById(R.h.contactitem_nick);
            cVar2.ume = (TextView) view.findViewById(R.h.contactitem_account);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (SnsLabelContactListUI.c) view.getTag();
        }
        getItem(i);
        a aVar = (a) getItem(i);
        cVar.kuR.setVisibility(8);
        cVar.eMf.setTextColor(!s.hO(aVar.field_username) ? this.umb : this.umc);
        b.p((ImageView) cVar.hPe.getContentView(), aVar.field_username);
        cVar.ume.setVisibility(8);
        cVar.hPe.setVisibility(0);
        cVar.eMf.setText(j.a(this.context, aVar.BL(), cVar.eMf.getTextSize()));
        cVar.eMf.setVisibility(0);
        return view;
    }
}
