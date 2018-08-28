package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.b.b.c;
import com.tencent.mm.ui.chatting.c.a;
import java.net.URLDecoder;

public final class g {

    public static class b extends b {
        private a tKy;

        public final boolean bba() {
            return false;
        }

        public final boolean aq(int i, boolean z) {
            if (z || i != 503316529) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            r rVar = new r(layoutInflater, R.i.chatting_item_from_text_c2c);
            rVar.setTag(new a().q(rVar, true));
            return rVar;
        }

        protected final boolean b(a aVar) {
            return aVar.cwr();
        }

        private static String aaB(String str) {
            try {
                com.tencent.mm.y.g.a gp = com.tencent.mm.y.g.a.gp(str);
                if (gp != null) {
                    return URLDecoder.decode(gp.content, "UTF-8");
                }
            } catch (Exception e) {
                x.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", new Object[]{e.getMessage()});
            }
            return "";
        }

        public final void a(b$a b_a, int i, a aVar, bd bdVar, String str) {
            String trim;
            CharSequence aaB;
            TextView textView;
            int type;
            this.tKy = aVar;
            a aVar2 = (a) b_a;
            String str2 = bdVar.field_content;
            String talkerUserName = aVar.getTalkerUserName();
            c cVar = (c) aVar.O(c.class);
            if (aVar.cwr() && !cVar.cur()) {
                int iA = com.tencent.mm.model.bd.iA(str2);
                if (iA != -1) {
                    trim = str2.substring(0, iA).trim();
                    if (trim == null || trim.length() <= 0) {
                        trim = talkerUserName;
                    }
                    str2 = str2.substring(iA + 1).trim();
                    aaB = aaB(str2);
                    a(aVar2, aVar, bdVar, trim);
                    a(aVar2, aVar, trim, bdVar);
                    aVar2.uaW.setText(aaB);
                    textView = aVar2.uaW;
                    type = bdVar.getType();
                    str2 = aVar.getTalkerUserName();
                    if (type != 301989937) {
                        j.a(textView, str2);
                    }
                    textView.getText();
                    aVar2.uaW.setTag(au.b(bdVar, aVar.cwr(), i));
                    aVar2.uaW.setOnLongClickListener(c(aVar));
                    aVar2.uaW.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctv());
                }
            }
            trim = talkerUserName;
            aaB = aaB(str2);
            a(aVar2, aVar, bdVar, trim);
            a(aVar2, aVar, trim, bdVar);
            aVar2.uaW.setText(aaB);
            textView = aVar2.uaW;
            type = bdVar.getType();
            str2 = aVar.getTalkerUserName();
            if (type != 301989937) {
                j.a(textView, str2);
            }
            textView.getText();
            aVar2.uaW.setTag(au.b(bdVar, aVar.cwr(), i));
            aVar2.uaW.setOnLongClickListener(c(aVar));
            aVar2.uaW.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.b.b.g) aVar.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctv());
        }

        protected final boolean cxM() {
            return false;
        }

        public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
            contextMenu.add(((au) view.getTag()).position, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
            return false;
        }

        public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
            return false;
        }

        public final boolean b(View view, a aVar, bd bdVar) {
            return false;
        }
    }
}
