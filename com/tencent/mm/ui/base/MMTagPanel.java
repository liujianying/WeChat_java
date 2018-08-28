package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.IBinder;
import android.text.InputFilter;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.c.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.w.a.d;
import com.tencent.mm.w.a.e;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.h;
import com.tencent.mm.w.a.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MMTagPanel extends FlowLayout {
    public boolean jNo = true;
    private boolean jaz = false;
    private int jbU = d.normal_text_color;
    private int jbV = f.tag_white_tab_selector;
    private int kwf = f.tag_green_tab_selector;
    private int kwg = d.wechat_green;
    public LinkedList<d> rBV = new LinkedList();
    public boolean txB = true;
    private boolean txC = false;
    public boolean txD = true;
    public boolean txE = false;
    public boolean txF = false;
    private int txG = f.tag_deletetab;
    private int txH = 0;
    private int txI = f.tag_highlight_tab_selector;
    private int txJ = d.white;
    private d txK = null;
    private LinkedList<d> txL = new LinkedList();
    private a txM;
    private int txN;
    private View txO;
    MMEditText txP;
    private boolean txQ = false;
    private OnClickListener txR = new 8(this);

    public MMTagPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public MMTagPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void aMU() {
    }

    private void init() {
        this.txN = getContext().getResources().getDimensionPixelSize(e.HintTextSize);
        this.txO = LayoutInflater.from(getContext()).inflate(h.mm_tag_panel_edittext, null);
        this.txP = (MMEditText) this.txO.findViewById(g.edittext);
        this.txP.setOnKeyListener(new 1(this));
        this.txP.addTextChangedListener(new 2(this));
        this.txP.setOnFocusChangeListener(new 3(this));
        this.txP.setOnClickListener(new 4(this));
        this.txP.setOnEditorActionListener(new 5(this));
        c cVar = new c(this);
        b bVar = new b(this);
        this.txP.setFilters(new InputFilter[]{cVar, bVar});
        crP();
        setOnClickListener(new 6(this));
        setOnTouchListener(new 7(this, cVar));
    }

    public void setTagEditTextBG(int i) {
        this.txH = i;
        if (this.txP != null) {
            a.fromDPToPix(getContext(), 6);
            getResources().getDimensionPixelSize(e.NormalPadding);
            this.txP.setBackgroundResource(this.txH);
        }
    }

    public void setTagTipsDrawable(int i) {
        this.txG = i;
    }

    public void setTagNormalBG(int i) {
        this.jbV = i;
    }

    public void setTagNormalTextColorRes(int i) {
        this.jbU = i;
    }

    public void setTagSelectedBG(int i) {
        this.kwf = i;
    }

    public void setTagSelectedTextColorRes(int i) {
        this.kwg = i;
    }

    public void setTagHighlineBG(int i) {
        this.txI = i;
    }

    public void setTaghighlineTextColorRes(int i) {
        this.txJ = i;
    }

    public void setEditTextColor(int i) {
        if (this.txP != null) {
            this.txP.setTextColor(i);
        }
    }

    public void setEditHint(String str) {
        if (this.txP != null) {
            this.txP.setHint(str);
        }
    }

    public String getEditText() {
        if (this.txP != null) {
            return this.txP.getText().toString();
        }
        return "";
    }

    public final void crN() {
        if (this.txP != null) {
            this.txP.setText("");
        }
    }

    public final void crO() {
        if (this.txP != null && !this.txP.isFocused()) {
            this.txP.requestFocus();
        }
    }

    public final void crP() {
        if (this.txP != null && this.txP.isFocused()) {
            x.d("MicroMsg.MMTagPanel", "do clear edit focus");
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                IBinder windowToken = this.txP.getWindowToken();
                if (windowToken != null) {
                    inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
                    this.txP.clearFocus();
                }
            }
        }
    }

    public final void lL(boolean z) {
        if (z != this.txC) {
            this.txC = z;
            removeView(this.txO);
            if (this.txC) {
                addView(this.txO);
                crP();
            }
        }
    }

    public void setCallBack(a aVar) {
        this.txM = aVar;
    }

    public Set<String> getTagSet() {
        Set<String> treeSet = new TreeSet();
        Iterator it = this.rBV.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!bi.oW(dVar.tyd)) {
                treeSet.add(dVar.tyd);
            }
        }
        return treeSet;
    }

    public ArrayList<String> getTagList() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.rBV.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (!bi.oW(dVar.tyd)) {
                arrayList.add(dVar.tyd);
            }
        }
        return arrayList;
    }

    public int getTagCount() {
        return this.rBV.size();
    }

    public void crI() {
        this.rBV.clear();
        removeAllViews();
        Iterator it = this.rBV.iterator();
        while (it.hasNext()) {
            a((d) it.next());
        }
    }

    public final void a(Collection<String> collection, List<String> list) {
        crI();
        if (this.txC) {
            addView(this.txO);
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                bu(str, collection == null ? false : collection.contains(str));
            }
        }
    }

    public final d crQ() {
        if (!this.txL.isEmpty()) {
            return (d) this.txL.removeFirst();
        }
        d dVar = new d();
        TextView textView = new TextView(getContext());
        textView.setBackgroundResource(this.jbV);
        textView.setTextColor(getResources().getColor(this.jbU));
        textView.setTag(Integer.valueOf(0));
        textView.setGravity(17);
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.txG, 0);
        textView.setOnClickListener(this.txB ? this.txR : null);
        textView.setEllipsize(TruncateAt.END);
        textView.setSingleLine();
        dVar.tye = textView;
        return dVar;
    }

    public final void a(d dVar) {
        dVar.tye.setOnClickListener(null);
        if (this.txL.size() < 16) {
            this.txL.add(dVar);
        }
    }

    public final void a(d dVar, String str, boolean z) {
        dVar.tyd = str;
        TextView textView = dVar.tye;
        getContext();
        textView.setText(b.c(str, this.txN));
        dVar.tye.setOnClickListener(this.txB ? this.txR : null);
        a(dVar.tye, z, false);
    }

    public final void crR() {
        if (this.txP != null) {
            x.d("MicroMsg.MMTagPanel", "do clear high light info, edittext is focus %B", new Object[]{Boolean.valueOf(this.txP.isFocused())});
            this.txP.setCursorVisible(true);
        }
        if (this.txK != null) {
            boolean z;
            TextView textView = this.txK.tye;
            if (((Integer) this.txK.tye.getTag()).intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            a(textView, z, false);
            this.txK = null;
        }
    }

    public final void a(TextView textView, boolean z, boolean z2) {
        textView.setTextSize(0, getContext().getResources().getDimension(e.HintTextSize) * a.fe(getContext()));
        if (z2) {
            textView.setBackgroundResource(this.txI);
            textView.setTextColor(getResources().getColor(this.txJ));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, this.txG, 0);
        } else if (z) {
            textView.setTag(Integer.valueOf(1));
            textView.setBackgroundResource(this.kwf);
            textView.setTextColor(getResources().getColor(this.kwg));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            textView.setTag(Integer.valueOf(0));
            textView.setBackgroundResource(this.jbV);
            textView.setTextColor(getResources().getColor(this.jbU));
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public final void bu(String str, boolean z) {
        if (bi.oW(str)) {
            x.w("MicroMsg.MMTagPanel", "want to add tag, but it is null or empty");
            return;
        }
        String trim = str.trim();
        x.d("MicroMsg.MMTagPanel", "want to add tag %s, do remove tag first", new Object[]{trim});
        removeTag(trim);
        Iterator it = this.rBV.iterator();
        while (it.hasNext()) {
            if (trim.equals(((d) it.next()).tyd)) {
                x.w("MicroMsg.MMTagPanel", "want to add tag %s, but it exsited!", new Object[]{trim});
                return;
            }
        }
        d crQ = crQ();
        a(crQ, trim, z);
        this.rBV.add(crQ);
        if (this.txC) {
            addView(crQ.tye, getChildCount() - 1);
        } else {
            addView(crQ.tye);
        }
        crR();
    }

    public final void removeTag(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.MMTagPanel", "want to remove tag, but it is null or empty");
            return;
        }
        Iterator it = this.rBV.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.tyd)) {
                this.rBV.remove(dVar);
                removeView(dVar.tye);
                a(dVar);
                crR();
                return;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to remove tag %s, but it not exsited!", new Object[]{str});
    }

    public final void bv(String str, boolean z) {
        if (bi.oW(str)) {
            x.w("MicroMsg.MMTagPanel", "want to update tag status, but it is null or empty");
            return;
        }
        Iterator it = this.rBV.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equals(dVar.tyd)) {
                a(dVar, str, z);
                crR();
                return;
            }
        }
        x.w("MicroMsg.MMTagPanel", "want to update tag %s status, but it not exsited!", new Object[]{str});
    }

    public void setPanelClickable(boolean z) {
        this.jNo = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jNo) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void setEditTextHit(boolean z) {
        if (this.txP == null) {
            return;
        }
        if (z) {
            this.txP.setHint(k.add_tag_tips);
        } else {
            this.txP.setHint("");
        }
    }

    public void setIsAllowEnterCharacter(boolean z) {
        this.txQ = z;
    }
}
