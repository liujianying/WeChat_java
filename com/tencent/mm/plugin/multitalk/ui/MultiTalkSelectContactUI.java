package com.tencent.mm.plugin.multitalk.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.m;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.o;
import java.util.HashSet;

@a(3)
public class MultiTalkSelectContactUI extends MMBaseSelectContactUI {
    private String chatroomName;
    private HashSet<String> eCq;
    private HashSet<String> eCr;
    private c ltK = new c<jr>() {
        {
            this.sFo = jr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jr jrVar = (jr) bVar;
            if ((jrVar instanceof jr) && jrVar.bTt.action == 0) {
                MultiTalkSelectContactUI.this.finish();
            }
            return false;
        }
    };
    private boolean lva;
    private d lvb;
    private boolean lvc = false;

    protected final void Wj() {
        super.Wj();
        this.lva = getIntent().getBooleanExtra("key_need_gallery", false);
        this.chatroomName = getIntent().getStringExtra("chatroomName");
        if (!s.fq(this.chatroomName)) {
            finish();
        }
        this.eCr = new HashSet();
        this.eCq = new HashSet();
    }

    protected void initView() {
        super.initView();
        lF(getResources().getColor(R.e.dark_actionbar_color));
        cqh();
        this.lvb = new d(this);
        if (this.lva) {
            this.lvb.setVisible(true);
        } else {
            this.lvb.setVisible(false);
        }
        int i = R.l.app_ok;
        if (this.lva) {
            i = R.l.multitalk_start_talk;
        }
        a(1, getString(i), new 1(this), com.tencent.mm.ui.s.b.tmX);
        Wp();
        this.lbw.setBackgroundResource(R.e.dark_actionbar_color);
        this.lbw.getInputText().setTextColor(-1);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bi.oW(stringExtra)) {
            this.eCq.addAll(bi.F(stringExtra.split(",")));
        }
        this.eCq.add(q.GF());
        if (this.lva) {
            this.lvb.HQ(q.GF());
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.ltK);
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.ltK);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.multitalk_select_contact_ui;
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        return getIntent().getStringExtra("titile");
    }

    protected final o Wn() {
        return new a(this, this.chatroomName);
    }

    protected final m Wo() {
        return new b(this, this.chatroomName);
    }

    public final void iV(int i) {
        boolean z = true;
        n cyp = cyp();
        com.tencent.mm.ui.contact.a.a FM = cyp.FM(i - getContentLV().getHeaderViewsCount());
        if (FM != null && FM.guS != null) {
            x.i("MicroMsg.multitalk.MultiTalkSelectContactUI", "ClickUser=%s", new Object[]{FM.guS.field_username});
            String str = FM.guS.field_username;
            if (!q.GF().equals(str)) {
                cyv();
                if (this.eCr.contains(str)) {
                    if (this.lva) {
                        d dVar = this.lvb;
                        if (dVar.size != 0) {
                            int i2;
                            boolean z2;
                            int i3 = -1;
                            for (i2 = 0; i2 < dVar.lvA.getChildCount(); i2++) {
                                if (dVar.lvA.getChildAt(i2).getTag().equals(str)) {
                                    i3 = i2;
                                    z2 = true;
                                    break;
                                }
                            }
                            z2 = false;
                            if (i3 < 0) {
                                i2 = 0;
                                while (i2 < dVar.lvB.getChildCount()) {
                                    if (dVar.lvB.getChildAt(i2).getTag().equals(str)) {
                                        break;
                                    }
                                    i2++;
                                }
                            }
                            i2 = i3;
                            z = false;
                            if (i2 >= 0) {
                                if (z) {
                                    dVar.lvB.removeViewAt(i2);
                                    dVar.size--;
                                }
                                if (z2) {
                                    if (dVar.size <= 5) {
                                        dVar.lvA.removeViewAt(i2);
                                        dVar.size--;
                                    } else {
                                        dVar.lvA.removeViewAt(i2);
                                        View childAt = dVar.lvB.getChildAt(0);
                                        dVar.lvB.removeViewAt(0);
                                        dVar.lvA.addView(childAt);
                                        dVar.size--;
                                    }
                                }
                                dVar.tm(dVar.size);
                                dVar.tn(dVar.size);
                            }
                        }
                    }
                    this.eCr.remove(str);
                } else if (this.eCq.size() + this.eCr.size() == 9) {
                    this.lvc = true;
                    Toast.makeText(this, R.l.multitalk_select_at, 0).show();
                    return;
                } else {
                    if (this.lva) {
                        this.lvb.HQ(str);
                    }
                    this.eCr.add(str);
                }
                cyp.notifyDataSetChanged();
                Wp();
            }
        }
    }

    protected final void bbH() {
        super.bbH();
        YC();
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.eCr.contains(aVar.guS.field_username);
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.eCq.contains(aVar.guS.field_username);
    }

    private void Wp() {
        if (this.eCr.size() > 0) {
            enableOptionMenu(1, true);
        } else {
            enableOptionMenu(1, false);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
