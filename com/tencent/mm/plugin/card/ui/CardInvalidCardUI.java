package com.tencent.mm.plugin.card.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.d.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.n.a;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class CardInvalidCardUI extends CardBaseUI {
    static /* synthetic */ LinkedList c(CardInvalidCardUI cardInvalidCardUI) {
        LinkedList linkedList = new LinkedList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= cardInvalidCardUI.htl.getCount()) {
                return linkedList;
            }
            CardInfo cardInfo = (CardInfo) cardInvalidCardUI.htr.nE(i2);
            if (cardInfo != null) {
                linkedList.add(cardInfo.field_card_id);
            }
            i = i2 + 1;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.initView();
    }

    protected final void initView() {
        super.initView();
    }

    protected final int avE() {
        return a.hwO;
    }

    protected final void avD() {
        setMMTitle(a$g.card_invalid_card);
        addTextOptionMenu(0, getString(a$g.card_clear), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                d.a(CardInvalidCardUI.this, new 2(CardInvalidCardUI.this));
                return true;
            }
        });
        if (this.htl.getCount() > 0) {
            enableOptionMenu(true);
        } else {
            enableOptionMenu(false);
        }
    }

    protected final int getLayoutId() {
        return a$e.card_invalid_card_ui;
    }

    public final void a(int i, int i2, String str, l lVar) {
        super.a(i, i2, str, lVar);
        if (i == 0 && i2 == 0 && (lVar instanceof r)) {
            if (this.htp) {
                h.bA(this, getResources().getString(a$g.card_clear_success_tips));
            } else {
                h.bA(this, getResources().getString(a$g.card_delete_success_tips));
            }
        }
        this.htp = false;
    }
}
