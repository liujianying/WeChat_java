package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.j;
import com.tencent.mm.w.a.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class h {

    public interface c {
        void ju(int i);
    }

    public static void a(Context context, Dialog dialog) {
        if (context instanceof MMActivity) {
            ((MMActivity) context).addDialog(dialog);
        }
    }

    public static Toast bx(Context context, String str) {
        return bA(context, str);
    }

    public static Toast by(Context context, String str) {
        return bA(context, str);
    }

    public static void bz(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static Toast bA(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.show();
        return makeText;
    }

    public static com.tencent.mm.ui.widget.a.c D(Context context, String str, String str2) {
        return b(context, str, str2, true);
    }

    public static com.tencent.mm.ui.widget.a.c b(Context context, String str, String str2, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.mF(z);
        aVar.Gt(k.app_ok).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c i(Context context, int i, int i2) {
        return b(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", true);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, OnClickListener onClickListener) {
        return a(context, i, i2, true, onClickListener);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        if (i2 > 0) {
            aVar.Gq(i2);
        }
        aVar.Gr(i);
        aVar.Gt(k.app_ok).a(onClickListener);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, OnClickListener onClickListener) {
        return a(context, str, str2, true, onClickListener);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.Gt(k.app_ok).a(onClickListener);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        return a(context, str, str2, str3, true, onClickListener);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.abx(str3).a(onClickListener);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.Gt(k.app_ok).a(onClickListener);
        aVar.Gu(k.app_cancel).b(onClickListener2);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.Gt(k.app_ok).a(onClickListener);
        aVar.Gu(k.app_cancel).b(onClickListener2);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, str, str2, str3, str4, z, onClickListener, onClickListener2, -1);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.abx(str3).a(onClickListener);
        aVar.aby(str4).b(onClickListener2);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        if (i > 0) {
            anj.Go(context.getResources().getColor(i));
        }
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", onClickListener, onClickListener2);
    }

    public static com.tencent.mm.ui.widget.a.c b(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", false, onClickListener, onClickListener2);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i5) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2, i5);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        if (i2 != 0) {
            aVar.Gq(i2);
        }
        aVar.Gr(i);
        aVar.Gt(i3).a(onClickListener);
        aVar.Gu(i4).b(onClickListener2);
        aVar.e(new 10(onClickListener2));
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.abx(str3).a(onClickListener);
        aVar.aby(str4).b(onClickListener2);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.abx(str3).a(onClickListener);
        aVar.aby(str4).b(onClickListener2);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.Go(context.getResources().getColor(i));
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.abx(str3).a(onClickListener);
        aVar.aby(str4).b(onClickListener2);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i, int i2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.abx(str3).a(onClickListener);
        aVar.aby(str4).b(onClickListener2);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        if (i > 0) {
            anj.Go(context.getResources().getColor(i));
        }
        if (i2 > 0) {
            anj.Gp(context.getResources().getColor(i2));
        }
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str);
        aVar.dR(view);
        aVar.Gt(k.app_ok).a(onClickListener);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, true, str, view, str2, str3, onClickListener, onClickListener2);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, z, str, view, str2, str3, onClickListener, onClickListener2, -1);
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str);
        aVar.dR(view);
        aVar.abx(str2).a(onClickListener);
        aVar.aby(str3).b(onClickListener2);
        aVar.mF(z);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        if (i > 0) {
            anj.Go(context.getResources().getColor(i));
        }
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str);
        aVar.dR(view);
        aVar.abx(str2).a(onClickListener);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, View view, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str);
        aVar.abu(null);
        aVar.dR(view);
        aVar.Gt(k.app_ok).a(onClickListener);
        aVar.Gu(k.app_cancel).b(onClickListener2);
        aVar.e(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
            }
        });
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, String str3, int i, b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.mF(false);
        aVar.mG(true);
        aVar.Gu(k.app_cancel).b(null);
        aVar.abt(str);
        View inflate = View.inflate(context, com.tencent.mm.w.a.h.mm_alert_input, null);
        MMEditText mMEditText = (MMEditText) inflate.findViewById(g.edittext);
        if (!bi.oW(str2)) {
            mMEditText.abr(str2);
        }
        TextView textView = (TextView) inflate.findViewById(g.tips_tv);
        if (bi.oW(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.Gt(k.app_ok).a(false, new 12(bVar, mMEditText, context));
        if (i > 0) {
            com.tencent.mm.ui.tools.a.c.d(mMEditText).Gi(i).a(null);
        }
        aVar.dR(inflate);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        if (!(context instanceof MMActivity)) {
            return anj;
        }
        inflate.post(new 13(context));
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, List<String> list, int i, a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (list.isEmpty()) {
            x.w("MicroMsg.MMAlert", "show switch alert fail");
            return null;
        }
        a aVar2 = new a(context);
        aVar2.mF(false);
        aVar2.Gu(k.app_cancel);
        aVar2.abt(str);
        View inflate = View.inflate(context, com.tencent.mm.w.a.h.mm_alert_switch, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(g.switcher_container);
        for (int size = list.size() - 1; size >= 0; size--) {
            TextView textView = (TextView) View.inflate(context, com.tencent.mm.w.a.h.radio_btn_item, null);
            textView.setText((CharSequence) list.get(size));
            if (size == i) {
                textView.setCompoundDrawablesWithIntrinsicBounds(j.radio_on, 0, 0, 0);
            }
            if (size == list.size() - 1) {
                context.getResources().getDimensionPixelSize(e.NormalPadding);
                textView.setBackgroundResource(f.submenu_item_selector_no_divider);
            }
            textView.setTag(Integer.valueOf(size));
            linearLayout.addView(textView, 0);
            textView.setOnClickListener(new 14(linearLayout, aVar));
        }
        aVar2.dR(inflate);
        com.tencent.mm.ui.widget.a.c anj = aVar2.anj();
        linearLayout.setTag(anj);
        anj.show();
        a(context, anj);
        return anj;
    }

    public static com.tencent.mm.ui.widget.a.c a(Context context, String str, String str2, OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.abt(str2);
        aVar.abu(str);
        aVar.Gt(k.app_ok).a(onClickListener);
        aVar.e(onCancelListener);
        com.tencent.mm.ui.widget.a.c anj = aVar.anj();
        anj.show();
        a(context, anj);
        return anj;
    }

    public static p a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        return a(context, 0, str, z, onCancelListener);
    }

    public static p b(Context context, String str, OnCancelListener onCancelListener) {
        return a(context, 2, str, true, onCancelListener);
    }

    private static p a(Context context, int i, String str, boolean z, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        x.b(true, null);
        p b = p.b(context, str, z, i, new 15(new WeakReference(onCancelListener)));
        a(context, b);
        return b;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, d dVar) {
        return b(context, str, list, list2, str2, true, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, boolean z, d dVar) {
        return b(context, str, list, list2, str2, z, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, d dVar) {
        return b(context, str, list, list2, null, true, dVar);
    }

    @Deprecated
    private static Dialog b(Context context, String str, List<String> list, List<Integer> list2, String str2, boolean z, final d dVar) {
        if ((list == null || list.size() == 0) && bi.oW(str2)) {
            return null;
        }
        List list3;
        if (list3 == null) {
            list3 = new ArrayList();
        }
        if (z) {
            com.tencent.mm.ui.tools.k kVar = new com.tencent.mm.ui.tools.k(context);
            kVar.ofp = new 2(str, list3, list2, str2);
            kVar.ofq = new d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    if (dVar != null) {
                        dVar.bx(i, menuItem.getItemId());
                    }
                }
            };
            kVar.d(null);
            Dialog bEo = kVar.bEo();
            a(context, bEo);
            return bEo;
        }
        com.tencent.mm.ui.widget.a.d dVar2 = new com.tencent.mm.ui.widget.a.d(context, 1, false);
        dVar2.ofp = new 4(str, list3, list2, str2);
        dVar2.ofq = new 5(dVar);
        dVar2.bXO();
        return null;
    }

    public static Dialog a(Context context, String str, String[] strArr, c cVar) {
        return a(context, str, strArr, null, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar) {
        return a(context, str, strArr, str2, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, boolean z, c cVar) {
        return a(context, str, strArr, str2, z, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar, OnCancelListener onCancelListener) {
        return a(context, str, strArr, str2, true, cVar, onCancelListener);
    }

    @Deprecated
    public static Dialog a(Context context, String str, String[] strArr, String str2, boolean z, c cVar, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if ((strArr == null || strArr.length == 0) && bi.oW(str2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            Collections.addAll(arrayList, strArr);
        }
        if (!bi.oW(str2)) {
            arrayList.add(str2);
        }
        if (z) {
            com.tencent.mm.ui.tools.k kVar = new com.tencent.mm.ui.tools.k(context);
            kVar.ofp = new 6(str, arrayList);
            kVar.ofq = new 7(cVar);
            kVar.d(onCancelListener);
            Dialog bEo = kVar.bEo();
            a(context, bEo);
            return bEo;
        }
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(context, 1, false);
        dVar.ofp = new 8(str, arrayList);
        dVar.ofq = new 9(cVar);
        dVar.bXO();
        return null;
    }
}
