package com.tencent.mm.ui.contact;

import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.contact.a.a;

public class SelectSpecialContactUI extends MMBaseSelectContactUI {
    private int hOX;
    private String title;

    protected final void Wj() {
        super.Wj();
        this.title = getIntent().getStringExtra("titile");
        this.hOX = getIntent().getIntExtra("list_attr", 0);
    }

    public final void iV(int i) {
        a FM = cyp().getItem(i);
        if (FM != null && FM.guS != null) {
            String str = FM.guS.field_username;
            x.i("MicroMsg.SelectSpecialContactUI", "ClickUser=%s", new Object[]{str});
            Intent intent = new Intent();
            if (s.fb(this.hOX, 16384)) {
                intent.putExtra("Select_Contact", str);
                setResult(-1, intent);
                finish();
            } else if (s.fb(this.hOX, 32768)) {
                intent.putExtra("Contact_User", str);
                d.b(this, "profile", ".ui.ContactInfoUI", intent);
                finish();
            } else {
                intent.setClass(this, ChattingUI.class);
                intent.putExtra("Chat_User", str);
                intent.putExtra("finish_direct", true);
                startActivity(intent);
                finish();
            }
        }
    }

    protected final boolean Wk() {
        return false;
    }

    protected final boolean Wl() {
        return false;
    }

    protected final String Wm() {
        return this.title;
    }

    protected final o Wn() {
        return new z(this, getIntent().getStringExtra("filter_type"));
    }

    protected final m Wo() {
        return null;
    }
}
