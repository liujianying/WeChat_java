package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.b.c;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.plugin.record.ui.b.e;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public abstract class h extends BaseAdapter {
    ListView CU;
    protected Context context;
    private Runnable iYm = new 2(this);
    protected ag msM = null;
    SparseArray<b> msN = new SparseArray();
    boolean msO = false;
    private boolean msP = false;
    protected a msQ;
    protected a msR;
    protected List<vx> msv = new LinkedList();
    private int padding = a.fromDPToPix(this.context, 35);

    public abstract void a(a aVar);

    public abstract void d(b bVar);

    public h(Context context, a aVar) {
        this.context = context;
        this.msM = new ag(Looper.getMainLooper()) {
            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    x.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
                    h.this.notifyDataSetChanged();
                }
            }
        };
        this.msR = aVar;
    }

    public final void bqG() {
        this.msN.put(0, new d(this.context));
        this.msN.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.msR, this.CU));
        this.msN.put(2, new e());
        this.msN.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.msR, this.msM));
        this.msN.put(4, new c(this.msR));
    }

    public final void destroy() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.msN.size()) {
                break;
            }
            b bVar = (b) this.msN.valueAt(i2);
            if (bVar != null) {
                bVar.destroy();
            }
            i = i2 + 1;
        }
        if (this.msR != null) {
            this.msR.bqy();
            this.msR = null;
        }
    }

    public int getItemViewType(int i) {
        return m(vo(i));
    }

    private static int m(vx vxVar) {
        switch (vxVar.bjS) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 3;
        }
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        return this.msv == null ? 0 : this.msv.size();
    }

    private vx vo(int i) {
        if (this.msv != null && i >= 0 && i < this.msv.size()) {
            return (vx) this.msv.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        b aVar;
        vx vo = vo(i);
        b bVar = (b) this.msN.get(m(vo));
        if (view == null) {
            view = bVar.eb(this.context);
        }
        switch (vo.bjS) {
            case 2:
                aVar = new com.tencent.mm.plugin.record.ui.a.a();
                break;
            case 15:
                aVar = new com.tencent.mm.plugin.record.ui.a.c();
                break;
            default:
                aVar = new b();
                break;
        }
        aVar.bOz = vo;
        d(aVar);
        bVar.a(view, i, aVar);
        ImageView imageView = (ImageView) view.findViewById(R.h.record_listitem_avatar);
        TextView textView = (TextView) view.findViewById(R.h.record_listitem_title);
        textView.setText(j.a(textView.getContext(), vo.rAk, textView.getTextSize()));
        textView = (TextView) view.findViewById(R.h.record_listitem_time);
        x.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[]{vo.rAm});
        if (vo.rAm != null) {
            if (this.msO) {
                String str = vo.rAm;
                textView.setText(str.substring(str.indexOf("-") + 1));
            } else {
                String[] split = vo.rAm.split(" ");
                if (split.length < 2) {
                    textView.setText(vo.rAm);
                } else {
                    textView.setText(split[1]);
                }
            }
        }
        if (i == 0) {
            if (vo.rAi != null) {
                vz vzVar = vo.rAi.rAJ;
                imageView.setVisibility(0);
                if (vzVar.rBi) {
                    Ku(vzVar.rBh);
                    if (com.tencent.mm.ac.a.e.lb(vzVar.rBh)) {
                        o.Pj().a(com.tencent.mm.ac.a.e.le(vzVar.rBh), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, vzVar.rBh);
                    }
                } else if (!vzVar.rBd || (q.GF().equals(vzVar.bSS) && vzVar.bSS.equals(vzVar.toUser))) {
                    imageView.setVisibility(8);
                    view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                    this.msP = true;
                } else {
                    Ku(vzVar.bSS);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, vzVar.bSS);
                }
            } else {
                imageView.setVisibility(8);
                view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                this.msP = true;
            }
        } else if (i <= 0 || this.msP) {
            imageView.setVisibility(8);
            view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
        } else {
            String str2 = "";
            vz vzVar2 = vo.rAi.rAJ;
            if (vo(i - 1).rAi.rAJ.rBi) {
                str2 = vo(i - 1).rAi.rAJ.rBh;
            } else if (vo(i - 1).rAi.rAJ.rBd) {
                str2 = vo(i - 1).rAi.rAJ.bSS;
            }
            imageView.setVisibility(0);
            String str3;
            if (vo.rAi.rAJ.rBi) {
                str3 = vo.rAi.rAJ.rBh;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    Ku(str3);
                    if (com.tencent.mm.ac.a.e.lb(vzVar2.rBh)) {
                        o.Pj().a(com.tencent.mm.ac.a.e.le(vzVar2.rBh), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                    }
                }
            } else if (vo.rAi.rAJ.rBd) {
                str3 = vo.rAi.rAJ.bSS;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    Ku(str3);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i == getCount() - 1) {
            view.findViewById(R.h.record_listitem_end_divider).setVisibility(8);
        } else {
            view.findViewById(R.h.record_listitem_end_divider).setVisibility(0);
        }
        return view;
    }

    private static void Ku(String str) {
        if (!s.he(str)) {
            com.tencent.mm.aa.j jVar = new com.tencent.mm.aa.j();
            jVar.username = str;
            com.tencent.mm.aa.q.KH().a(jVar);
        }
    }

    protected final void bqH() {
        this.msM.post(this.iYm);
    }
}
