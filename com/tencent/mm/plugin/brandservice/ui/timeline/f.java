package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ac.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.brandservice.ui.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.y.g$a;
import com.tencent.mm.y.i;
import java.util.LinkedList;
import java.util.List;

public final class f extends BaseAdapter {
    private List<q> gxs = new LinkedList();
    c hnE = new 1(this);
    private BizTimeLineNewMsgUI hrT;

    public f(BizTimeLineNewMsgUI bizTimeLineNewMsgUI, List<q> list) {
        this.hrT = bizTimeLineNewMsgUI;
        z.Nf().a(this.hnE, Looper.getMainLooper());
        this.gxs = list;
    }

    public final int getCount() {
        return this.gxs.size();
    }

    /* renamed from: nz */
    public final q getItem(int i) {
        if (i < this.gxs.size()) {
            return (q) this.gxs.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        q nz = getItem(i);
        if (nz == null) {
            x.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
        } else {
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.hrT, e.biz_time_line_new_msg_item, null);
                aVar2.eBM = (ImageView) view.findViewById(d.avatar_iv);
                aVar2.eIH = (TextView) view.findViewById(d.nick_name_tv);
                aVar2.hrV = (TextView) view.findViewById(d.time_tv);
                aVar2.eBO = (TextView) view.findViewById(d.title_tv);
                aVar2.hrW = view.findViewById(d.bottom_line);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            b.a(aVar.eBM, nz.field_talker);
            aVar.eIH.setText(j.a(this.hrT, r.gT(nz.field_talker), aVar.eIH.getTextSize()));
            aVar.hrV.setText(a.e(this.hrT, nz.field_createTime));
            if (nz.cky()) {
                aVar.eBO.setText(i.gs(nz.field_content));
            } else {
                if (!nz.isText()) {
                    int i2;
                    if (nz.field_type == 10000) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        if (nz.ckA()) {
                            aVar.eBO.setText(this.hrT.getString(h.app_pic));
                        } else if (nz.ckz()) {
                            aVar.eBO.setText(this.hrT.getString(h.app_voice));
                        } else {
                            if (nz.field_type == 43) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                aVar.eBO.setText(this.hrT.getString(h.app_video));
                            } else {
                                if ((nz.field_type & 65535) == 49) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                if (i2 != 0) {
                                    g$a gp = g$a.gp(nz.field_content);
                                    if (gp != null) {
                                        aVar.eBO.setText(gp.getTitle());
                                    }
                                }
                                aVar.eBO.setText(this.hrT.getString(h.biz_time_line_item_un_support_type));
                            }
                        }
                    }
                }
                aVar.eBO.setText(nz.field_content);
            }
            if (i == getCount() - 1) {
                aVar.hrW.setVisibility(4);
            } else {
                aVar.hrW.setVisibility(0);
            }
            g.Em().H(new 2(this, nz));
        }
        return view;
    }
}
