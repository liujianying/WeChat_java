package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.s.b;
import java.util.HashSet;

public class SelectLabelContactUI extends MMBaseSelectContactUI {
    private HashSet<String> eCr;
    private int hOX;
    private String label;
    private HashSet<String> ulw;

    protected final void Wj() {
        super.Wj();
        this.label = getIntent().getStringExtra("label");
        this.hOX = getIntent().getIntExtra("list_attr", 0);
        this.eCr = new HashSet();
        this.ulw = new HashSet();
        String stringExtra = getIntent().getStringExtra("always_select_contact");
        if (!bi.oW(stringExtra)) {
            this.ulw.addAll(bi.F(stringExtra.split(",")));
        }
        stringExtra = getIntent().getStringExtra("already_select_contact");
        if (!bi.oW(stringExtra)) {
            this.eCr.addAll(bi.F(stringExtra.split(",")));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (s.fb(this.hOX, 64)) {
            a(1, getString(R.l.app_ok), new 1(this), b.tmX);
        }
        Wp();
    }

    public final void iV(int i) {
        int headerViewsCount = i - getContentLV().getHeaderViewsCount();
        n cyp = cyp();
        a FM = cyp.FM(headerViewsCount);
        if (FM != null && FM.guS != null) {
            String str = FM.guS.field_username;
            x.i("MicroMsg.SelectLabelContactUI", "ClickUser=%s", new Object[]{str});
            if (!s.fb(this.hOX, 64)) {
                aaO(str);
            } else if (this.ulw.contains(str) || this.eCr.contains(str) || !s.fb(this.hOX, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) || this.ulw.size() + this.eCr.size() < getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE)) {
                if (!this.ulw.contains(str)) {
                    if (this.eCr.contains(str)) {
                        this.eCr.remove(str);
                    } else {
                        this.eCr.add(str);
                    }
                }
                Wp();
                cyp.notifyDataSetChanged();
            } else {
                h.a(this.mController.tml, getString(R.l.select_contact_num_limit_tips, new Object[]{Integer.valueOf(getIntent().getIntExtra("max_limit_num", Integer.MAX_VALUE))}), getString(R.l.app_remind), new 2(this));
            }
        }
    }

    private void Wp() {
        if (!s.fb(this.hOX, 64) || this.eCr.size() <= 0) {
            updateOptionMenuText(1, getString(R.l.app_ok));
            enableOptionMenu(1, false);
            return;
        }
        updateOptionMenuText(1, getString(R.l.app_ok) + "(" + this.eCr.size() + ")");
        enableOptionMenu(1, true);
    }

    private void aaO(String str) {
        Intent intent;
        if (s.fb(this.hOX, 16384)) {
            intent = new Intent();
            intent.putExtra("Select_Contact", str);
            setResult(-1, intent);
            finish();
            return;
        }
        intent = new Intent();
        intent.setClass(this, ChattingUI.class);
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", true);
        startActivity(intent);
        finish();
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        return this.label;
    }

    protected final o Wn() {
        return new h(this, s.fb(this.hOX, 64), com.tencent.mm.plugin.label.a.a.aYK().FD(com.tencent.mm.plugin.label.a.a.aYK().FA(this.label)));
    }

    protected final m Wo() {
        return null;
    }

    public final boolean a(a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.eCr.contains(aVar.guS.field_username);
    }

    public final boolean b(a aVar) {
        if (!aVar.ujX || aVar.guS == null) {
            return false;
        }
        return this.ulw.contains(aVar.guS.field_username);
    }
}
