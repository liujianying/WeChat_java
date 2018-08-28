package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.h.d;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    private TextView meJ;
    private ImageView meK;
    ComposeUI mgk;
    ViewGroup mgl;
    Map<String, y> mgm;
    Map<String, o> mgn;
    Map<String, String> mgo;
    Map<String, String> mgp;
    b mgq;
    private OnClickListener mgr;
    int mode;

    private class a {
        TextView eMe;
        ImageView gmn;
        TextView mfT;
        ProgressBar mgA;
        TextView mgB;
        ImageView mgC;
        ImageView mgD;

        private a() {
        }

        /* synthetic */ a(b bVar, byte b) {
            this();
        }
    }

    public interface b {
        void boM();

        void onComplete();
    }

    private b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        this.mgm = new HashMap();
        this.mgn = new HashMap();
        this.mgo = new LinkedHashMap();
        this.mgp = new LinkedHashMap();
        this.mgq = null;
        this.mgr = null;
        this.mode = 5;
        this.mgk = composeUI;
        this.mgl = viewGroup;
        this.mgr = null;
        this.meJ = textView;
        this.meK = imageView;
        boV();
        au.DF().a(484, this);
    }

    public b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b) {
        this(composeUI, textView, imageView, viewGroup);
    }

    public final void bN(List<y> list) {
        if (list != null) {
            for (y yVar : list) {
                a(yVar);
                this.mgm.put(yVar.path, yVar);
            }
            if (this.mode == 6) {
                for (y yVar2 : list) {
                    this.mgo.put(yVar2.path, yVar2.meb);
                    this.mgp.put(yVar2.path, yVar2.name);
                }
            }
        }
    }

    public final void eg(String str, String str2) {
        if (str != null && str.length() != 0 && !this.mgm.containsKey(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                y yVar = new y();
                yVar.path = str;
                if (str2 == null) {
                    yVar.name = file.getName();
                } else {
                    yVar.name = str2;
                }
                yVar.size = file.length();
                yVar.state = 0;
                this.mgm.put(str, yVar);
                a(yVar);
            }
        }
    }

    private void a(final y yVar) {
        LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.mgk, R.i.qqmail_comm_widget, null)).findViewById(R.h.plugin_qqmail_compose_attach_item_ll);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.plugin_qqmail_compose_attach_item_icon_iv);
        TextView textView = (TextView) linearLayout.findViewById(R.h.plugin_qqmail_compose_attach_item_name_tv);
        TextView textView2 = (TextView) linearLayout.findViewById(R.h.plugin_qqmail_compose_attach_item_size_tv);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.h.plugin_qqmail_compose_attach_item_uploading_pb);
        TextView textView3 = (TextView) linearLayout.findViewById(R.h.plugin_qqmail_compose_attach_upload_failed_tv);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(R.h.plugin_qqmail_compose_attach_item_reupload_iv);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.h.plugin_qqmail_compose_attach_item_delete_iv);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.TY(yVar.name));
        textView.setText(yVar.name);
        textView2.setText(bi.bF(yVar.size));
        a aVar = new a(this, (byte) 0);
        aVar.gmn = imageView;
        aVar.eMe = textView;
        aVar.mfT = textView2;
        aVar.mgA = progressBar;
        aVar.mgB = textView3;
        aVar.mgC = imageView2;
        aVar.mgD = imageView3;
        linearLayout.setTag(aVar);
        linearLayout.setId(Math.abs(yVar.path.hashCode() / 2));
        if (this.mgr != null) {
            linearLayout.setOnClickListener(this.mgr);
        }
        this.mgl.addView(linearLayout);
        boV();
        linearLayout.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
            }
        });
        imageView2.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (b.this.mode == 5) {
                    yVar.mea = b.this.Kb(yVar.path);
                } else if (b.this.mode == 6) {
                    yVar.mea = b.this.eh(yVar.path, yVar.name);
                }
            }
        });
        imageView3.setOnClickListener(new 3(this, yVar, linearLayout));
        this.mgl.post(new 4(this, yVar));
        if (yVar.state != 0) {
            return;
        }
        if (this.mode == 5) {
            yVar.mea = Kb(yVar.path);
        } else if (this.mode == 6) {
            yVar.mea = eh(yVar.path, yVar.name);
        }
    }

    public final String boR() {
        String str = "";
        for (String str2 : this.mgm.keySet()) {
            if (str.length() > 0) {
                str = str + "|";
            }
            str = str + ((y) this.mgm.get(str2)).meb;
        }
        return str;
    }

    public final LinkedList<y> boS() {
        LinkedList<y> linkedList = new LinkedList();
        for (String str : this.mgm.keySet()) {
            linkedList.add(this.mgm.get(str));
        }
        return linkedList;
    }

    public final void boT() {
        y yVar;
        if (this.mode == 5) {
            for (String str : this.mgm.keySet()) {
                yVar = (y) this.mgm.get(str);
                if (yVar.state != 2) {
                    w.bow().cancel(yVar.mea);
                    yVar.state = 3;
                    b(yVar);
                }
            }
        } else if (this.mode == 6) {
            for (String str2 : this.mgm.keySet()) {
                yVar = (y) this.mgm.get(str2);
                if (yVar.state != 2) {
                    o oVar = (o) this.mgn.get(yVar.path);
                    if (oVar != null) {
                        au.DF().c(oVar);
                        yVar.state = 3;
                        b(yVar);
                    }
                    this.mgo.remove(yVar.path);
                    this.mgp.remove(yVar.path);
                    this.mgn.remove(yVar.path);
                }
            }
        }
    }

    final long Kb(String str) {
        c cVar = new c();
        cVar.mdl = false;
        cVar.mdk = true;
        return w.bow().a("/cgi-bin/uploaddata", 1, null, new d("UploadFile", str), cVar, new 5(this, str));
    }

    final long eh(String str, String str2) {
        if (this.mgn.containsKey(str)) {
            return (long) ((o) this.mgn.get(str)).hashCode();
        }
        o oVar = new o(str, str, new 6(this, str, str2));
        y yVar = (y) this.mgm.get(str);
        if (yVar != null) {
            yVar.state = 1;
        }
        b(yVar);
        au.DF().a(oVar, 0);
        this.mgn.put(str, oVar);
        return (long) oVar.hashCode();
    }

    public final boolean boU() {
        for (String str : this.mgm.keySet()) {
            y yVar = (y) this.mgm.get(str);
            if (yVar.state != 2 && yVar.state != 3) {
                return false;
            }
        }
        return true;
    }

    public final void boV() {
        if (this.mgm.size() == 0) {
            this.meJ.setText(this.mgk.getString(R.l.plugin_qqmail_composeui_attach) + " " + this.mgk.getString(R.l.plugin_qqmail_composeui_attach_hint));
            this.meK.setImageResource(R.k.qqmail_attach_icon_normal);
            ((View) this.mgl.getParent()).setVisibility(8);
        } else {
            this.meJ.setText(this.mgk.getString(R.l.plugin_qqmail_composeui_attach) + this.mgk.getResources().getQuantityString(R.j.plugin_qqmail_composeui_attach_summary, this.mgm.size(), new Object[]{Integer.valueOf(this.mgm.size()), bi.bF((long) boW())}));
            this.meK.setImageResource(R.k.qqmail_attach_icon_pressed);
            ((View) this.mgl.getParent()).setVisibility(0);
        }
        int childCount = this.mgl.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (childCount == 1) {
                this.mgl.getChildAt(i).setBackgroundResource(R.g.mail_attach_list_item);
            } else if (i == 0) {
                this.mgl.getChildAt(i).setBackgroundResource(R.g.mail_attach_list_item1);
            } else if (i <= 0 || i >= childCount - 1) {
                this.mgl.getChildAt(i).setBackgroundResource(R.g.mail_attach_list_item3);
            } else {
                this.mgl.getChildAt(i).setBackgroundResource(R.g.mail_attach_list_item2);
            }
            i++;
        }
    }

    public final int boW() {
        int i = 0;
        Iterator it = this.mgm.keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            long j = (long) i2;
            i = (int) (((y) this.mgm.get((String) it.next())).size + j);
        }
    }

    final void b(y yVar) {
        LinearLayout linearLayout = (LinearLayout) this.mgl.findViewById(Math.abs(yVar.path.hashCode() / 2));
        if (linearLayout != null) {
            a aVar = (a) linearLayout.getTag();
            switch (yVar.state) {
                case 0:
                case 1:
                    aVar.eMe.setTextColor(-16777216);
                    aVar.mgA.setVisibility(0);
                    aVar.mgB.setVisibility(8);
                    aVar.mgC.setVisibility(8);
                    aVar.mgD.setVisibility(0);
                    return;
                case 2:
                    aVar.eMe.setTextColor(-16777216);
                    aVar.mgA.setVisibility(8);
                    aVar.mgB.setVisibility(8);
                    aVar.mgC.setVisibility(8);
                    aVar.mgD.setVisibility(0);
                    return;
                case 3:
                    aVar.eMe.setTextColor(com.tencent.mm.bp.a.g(this.mgk, R.e.lightgrey));
                    aVar.mgA.setVisibility(8);
                    aVar.mgB.setVisibility(0);
                    aVar.mgC.setVisibility(0);
                    aVar.mgD.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 484) {
            o oVar = (o) lVar;
            String str2 = oVar.filePath;
            y yVar = (y) this.mgm.get(str2);
            if (yVar == null) {
                return;
            }
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str2});
                yVar.state = 3;
                this.mgn.remove(str2);
                au.DF().c(oVar);
                ah.A(new 7(this, yVar));
            }
        }
    }
}
