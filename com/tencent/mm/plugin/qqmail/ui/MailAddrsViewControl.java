package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.stub.ReadMailProxy;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class MailAddrsViewControl extends RelativeLayout {
    private static final Pattern mgZ = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");
    private boolean eYJ = false;
    private ag handler = new ag();
    private LinkedList<i> mgT = new LinkedList();
    AutoCompleteTextView mgU;
    private b mgV;
    private c mgW;
    private View mgX;
    private a mgY = null;
    private GestureDetector mgc;
    private SimpleOnGestureListener mha = new 8(this);

    public void setInvalidMailAddrListener(a aVar) {
        this.mgY = aVar;
    }

    public final boolean boY() {
        Editable text = this.mgU.getText();
        if (text == null || text.toString().length() <= 0) {
            return true;
        }
        return false;
    }

    public MailAddrsViewControl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mgc = new GestureDetector(context, this.mha);
    }

    public void setEditable(boolean z) {
        this.eYJ = z;
        if (z && this.mgU == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (!(childAt instanceof AutoCompleteTextView)) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) childAt;
                        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                            View childAt2 = viewGroup.getChildAt(i2);
                            if (childAt2 instanceof AutoCompleteTextView) {
                                this.mgU = (AutoCompleteTextView) childAt2;
                            }
                        }
                    }
                    if (this.mgU != null) {
                        break;
                    }
                    i++;
                } else {
                    this.mgU = (AutoCompleteTextView) childAt;
                    break;
                }
            }
            if (this.mgU != null) {
                this.mgU.setDropDownBackgroundResource(R.g.qqmail_dropdown_thumb);
                setOnClickListener(new 1(this));
                this.mgU.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        MailAddrsViewControl.this.e(MailAddrsViewControl.this.mgV.uZ(i));
                        MailAddrsViewControl.this.mgU.setText("");
                    }
                });
                this.mgU.setOnEditorActionListener(new 4(this));
                this.mgU.setOnKeyListener(new 5(this));
                this.mgU.addTextChangedListener(new 6(this));
                this.mgU.setOnFocusChangeListener(new 7(this));
            }
        } else if (!z && this.mgU != null) {
            this.mgU.setVisibility(8);
        }
    }

    public void setAddrsAdapter(b bVar) {
        if (this.mgU != null && bVar != null) {
            this.mgV = bVar;
            this.mgU.setAdapter(bVar);
        }
    }

    public void setOnActionListener(c cVar) {
        this.mgW = cVar;
    }

    public LinkedList<i> getMailAddrs() {
        return this.mgT;
    }

    public final String[] a(boolean z, d dVar) {
        int i = 0;
        String userBindEmail;
        if (dVar == null || !dVar.isConnected()) {
            userBindEmail = q.getUserBindEmail();
        } else {
            try {
                userBindEmail = (String) new ReadMailProxy(dVar, null).REMOTE_CALL("getUserBindEmail", new Object[0]);
            } catch (Exception e) {
                x.e("MicroMsg.QQMail.MailAddrsViewControl", "getMailAddrStringArray, getUserBindEmail fail, ex = %s", new Object[]{e.getMessage()});
                return null;
            }
        }
        String[] strArr = new String[this.mgT.size()];
        while (i < this.mgT.size()) {
            i iVar = (i) this.mgT.get(i);
            if (z && iVar.kCs.equalsIgnoreCase(userBindEmail)) {
                strArr[i] = "";
            } else {
                strArr[i] = iVar.name + " " + iVar.kCs;
            }
            i++;
        }
        return strArr;
    }

    public final boolean boZ() {
        String trim = this.mgU.getEditableText().toString().trim();
        return !bi.oW(trim) && Kc(trim);
    }

    public String getAddrsString() {
        boolean z = false;
        if (boZ()) {
            aK(this.mgU.getEditableText().toString(), false);
        }
        String str = "";
        while (true) {
            boolean z2 = z;
            if (z2 >= this.mgT.size()) {
                return str;
            }
            i iVar = (i) this.mgT.get(z2);
            if (z2) {
                str = str + ",";
            }
            str = str + iVar.kCs;
            z = z2 + 1;
        }
    }

    public int getSize() {
        return this.mgT.size();
    }

    public final void e(i iVar) {
        if (iVar != null) {
            Object obj;
            Iterator it = this.mgT.iterator();
            while (it.hasNext()) {
                if (((i) it.next()).kCs.equalsIgnoreCase(iVar.kCs)) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                ViewGroup viewGroup = (ViewGroup) View.inflate(getContext(), R.i.qqmail_comm_widget, null);
                Button button = (Button) viewGroup.findViewById(R.h.qqmail_single_addr_btn);
                viewGroup.removeView((View) button.getParent());
                button.setText(iVar.name);
                if (this.eYJ) {
                    button.setCompoundDrawables(null, null, null, null);
                }
                button.setTag(this.mgT.size());
                View view = (View) button.getParent();
                button.setTag(iVar);
                view.setVisibility(4);
                view.setTag(iVar);
                addView(view, this.mgT.size());
                this.mgT.add(iVar);
                this.handler.postDelayed(new 2(this, button), 100);
            }
        }
    }

    public final void a(String[] strArr, boolean z) {
        if (z) {
            removeAllViews();
            this.mgT.clear();
            bpb();
            invalidate();
        }
        if (strArr != null && strArr.length != 0) {
            for (String JT : strArr) {
                i JT2 = j.JT(JT);
                if (JT2 != null) {
                    e(JT2);
                }
            }
        }
    }

    public final void bO(List<i> list) {
        if (list != null) {
            for (i e : list) {
                e(e);
            }
        }
    }

    public void setMailAdds(List<i> list) {
        if (list != null) {
            int i;
            i iVar;
            int i2;
            for (i = 0; i < this.mgT.size(); i++) {
                iVar = (i) this.mgT.get(i);
                i2 = 0;
                while (i2 < list.size()) {
                    if (iVar.kCs.equalsIgnoreCase(((i) list.get(i2)).kCs)) {
                        break;
                    }
                    i2++;
                }
                if (i2 == list.size()) {
                    f(iVar);
                }
            }
            for (i = 0; i < list.size(); i++) {
                iVar = (i) list.get(i);
                i2 = 0;
                while (i2 < this.mgT.size()) {
                    if (iVar.kCs.equalsIgnoreCase(((i) this.mgT.get(i2)).kCs)) {
                        break;
                    }
                    i2++;
                }
                if (i2 == this.mgT.size()) {
                    e(iVar);
                }
            }
        }
    }

    public final void f(i iVar) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.mgT.size()) {
                if (iVar.kCs.equalsIgnoreCase(((i) this.mgT.get(i2)).kCs)) {
                    removeViewAt(i2);
                    this.mgT.remove(i2);
                    bpb();
                    invalidate();
                    return;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    private static boolean Kc(String str) {
        return mgZ.matcher(str).matches();
    }

    public final boolean bpa() {
        Iterator it = this.mgT.iterator();
        while (it.hasNext()) {
            if (!Kc(((i) it.next()).kCs)) {
                return false;
            }
        }
        return true;
    }

    final void bpb() {
        int childCount = getChildCount();
        int measuredWidth = getMeasuredWidth();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8 || (childAt instanceof AutoCompleteTextView)) {
                int i4;
                int width = childAt.getWidth();
                int height = childAt.getHeight();
                if (width == 0) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
                    width = childAt.getMeasuredWidth();
                }
                if (this.mgU == null || i != childCount - 1 || this.mgU.isFocused()) {
                    i4 = width;
                } else {
                    i4 = 0;
                }
                if (i3 + i4 > measuredWidth) {
                    i2 += height;
                    i3 = 0;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.setMargins(i3, i2, layoutParams.rightMargin, layoutParams.bottomMargin);
                childAt.setLayoutParams(layoutParams);
                i3 += i4;
                childAt.setVisibility(0);
            }
            i++;
        }
    }

    private void aK(String str, boolean z) {
        Object trim = str.trim();
        if (trim.length() != 0) {
            List JS = w.bow().mcZ.JS(trim);
            if (JS.size() > 0) {
                e((i) JS.get(0));
                this.mgU.setText("");
            } else if (Kc(trim)) {
                i iVar = new i();
                iVar.name = trim;
                iVar.kCs = trim;
                iVar.mcC = 0;
                e(iVar);
                this.mgU.setText("");
            } else if (z) {
                if (this.mgY != null) {
                    this.mgY.boN();
                } else {
                    Toast.makeText(getContext(), R.l.plugin_qqmail_mail_addr_format_invalid, 2000).show();
                }
                this.mgU.setText(trim);
                this.mgU.setSelection(trim.length());
            } else if (this.mgY != null) {
                this.mgY.b(this);
            }
        }
    }
}
