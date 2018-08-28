package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.os.Looper;
import android.support.v4.view.z;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.widget.input.c.e;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.plugin.appbrand.widget.input.u.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.tools.g;
import java.lang.ref.WeakReference;
import junit.framework.Assert;

public abstract class AppBrandInputInvokeHandler implements y<w> {
    private static final String TAG = "MicroMsg.AppBrandInputInvokeHandler";
    private final ag H = new ag(Looper.getMainLooper());
    private final a inputExceedMaxLengthCallback = new 8(this);
    private final Runnable mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle = new 9(this);
    private w mInput;
    final OnFocusChangeListener mInputFocusChangeListenerImpl = new 1(this);
    private int mInputId;
    private int mLastContentHeight = -1;
    private int mLastLineCount = -1;
    private t mNumberKeyboard;
    private volatile a mOnInputFocusChangeListener;
    private volatile b mOnLineHeightChangeListener;
    protected WeakReference<p> mPageRef;
    private e mParams;
    private boolean mPerformingDelete = false;
    private final Runnable mResetPerformingDelete = new 10(this);
    private final d mSmileyChosenListener = new 2(this);
    private final c mSmileyOnDoneListener = new 3(this);
    private u mSmileyPanel;
    private final u.e mSmileyVisibilityListener = new 4(this);
    private int mTextDoneReason$25f24e96 = 0;
    private final com.tencent.mm.plugin.appbrand.widget.input.a.a mValueChangeNotify = new com.tencent.mm.plugin.appbrand.widget.input.a.a();

    public interface b {
        void bM(int i, int i2);
    }

    public abstract void onBackspaceWhenValueEmpty();

    public abstract void onInputDone(String str, int i, boolean z, boolean z2);

    public abstract void onInputInitialized();

    public abstract void onRuntimeFail();

    public void setOnValueChangeListener(com.tencent.mm.plugin.appbrand.widget.input.a.c cVar) {
        this.mValueChangeNotify.gKC = cVar;
    }

    public void setOnLineHeightChangeListener(b bVar) {
        this.mOnLineHeightChangeListener = bVar;
    }

    public void setOnInputFocusChangeListener(a aVar) {
        this.mOnInputFocusChangeListener = aVar;
    }

    public final void insertInput(e eVar, int i, int i2) {
        com.tencent.mm.plugin.appbrand.r.c.br(this);
        this.mParams = eVar;
        insertInputImpl(i, i2);
    }

    final boolean updateInput(h hVar) {
        if (this.mParams == null || this.mInput == null) {
            return false;
        }
        this.mParams.a(hVar);
        if (!this.mParams.gLy && (this.mParams.gLC == null || this.mParams.gLC.intValue() <= 0)) {
            return false;
        }
        this.mInput.setWillNotDraw(true);
        resetInputAttributes();
        if (this.mParams.gLA != null) {
            this.mInput.q(bi.oV(this.mParams.gLA));
        }
        if (af.f(this.mParams.gLU)) {
            mayAutoResizeInputHeight();
            lineHeightMaybeChanged();
        } else {
            updateInputPosition(this.mInput, this.mParams);
        }
        this.mInput.setWillNotDraw(false);
        this.mInput.invalidate();
        return true;
    }

    public boolean isAttachedTo(p pVar) {
        return (pVar == null || this.mPageRef == null || pVar != this.mPageRef.get()) ? false : true;
    }

    public boolean showKeyboard(int i, int i2) {
        doShowKeyboard();
        setInputSelection(i, i2);
        return true;
    }

    public boolean hideKeyboard() {
        doHideKeyboard();
        return true;
    }

    public void updateValue(String str, Integer num) {
        if (this.mInput != null) {
            this.mInput.q(str);
            Integer valueOf = Integer.valueOf(num == null ? -1 : num.intValue());
            setInputSelection(valueOf.intValue(), valueOf.intValue());
            lineHeightMaybeChanged();
        }
    }

    public boolean isFocused() {
        return this.mInput != null && (this.mInput.isFocused() || (findSmileyPanel() != null && findSmileyPanel().getAttachedEditText() == this.mInput));
    }

    @Deprecated
    private void doHideKeyboard() {
        if (isFocused()) {
            u findSmileyPanel = findSmileyPanel();
            if (findSmileyPanel != null) {
                findSmileyPanel.setVisibility(8);
                return;
            }
            return;
        }
        x.d(TAG, "doHideKeyboard, not focused, return");
    }

    @Deprecated
    private void doShowKeyboard() {
        if (this.mInput != null && this.mPageRef != null && this.mPageRef.get() != null) {
            this.mInput.performClick();
        }
    }

    public boolean removeSelf() {
        if (!removeInput()) {
            return false;
        }
        onDestroy();
        return true;
    }

    @Deprecated
    private boolean removeInput() {
        if (this.mInput == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        this.mInput.destroy();
        f fVar = ((p) this.mPageRef.get()).gnr;
        if (fVar == null) {
            return false;
        }
        if (this.mInput.hasFocus()) {
            if (this.mNumberKeyboard != null) {
                this.mNumberKeyboard.setVisibility(8);
            }
            findSmileyPanel();
            if (this.mSmileyPanel != null) {
                this.mSmileyPanel.setVisibility(8);
            }
        }
        fVar.bU(this.mInput);
        return true;
    }

    public View getInputPanel() {
        return this.mSmileyPanel;
    }

    public w getWidget() {
        return this.mInput;
    }

    public boolean adjustPositionOnFocused() {
        return this.mParams != null && af.f(this.mParams.gLZ);
    }

    public int getInputPanelMarginBottom() {
        if (this.mParams != null && this.mParams.gLW != null) {
            return this.mParams.gLW.intValue();
        }
        if (this.mInput == null || !this.mInput.apv()) {
            return 0;
        }
        return 5;
    }

    private void onDestroy() {
        this.mInput = null;
        com.tencent.mm.plugin.appbrand.r.c.az(this);
    }

    public final int getInputId() {
        return this.mInputId;
    }

    private void mayAutoResizeInputHeight() {
        if (this.mInput != null && af.f(this.mParams.gLU) && af.f(this.mParams.gLS)) {
            ((o) this.mInput).setAutoHeight(true);
            int lineHeight = this.mInput.getLineHeight();
            int apL = this.mInput.apL();
            int intValue = (this.mParams.gLF == null || this.mParams.gLF.intValue() <= 0) ? lineHeight : this.mParams.gLF.intValue();
            lineHeight = (this.mParams.gLG == null || this.mParams.gLG.intValue() <= 0) ? Integer.MAX_VALUE : Math.max(this.mParams.gLG.intValue(), lineHeight);
            this.mInput.setMinHeight(intValue);
            this.mInput.setMaxHeight(lineHeight);
            this.mParams.gLC = Integer.valueOf(Math.max(intValue, Math.min(apL, lineHeight)));
            updateInputPosition(this.mInput, this.mParams);
        }
    }

    private void resetInputAttributes() {
        b.a(this.mInput, this.mParams);
        if (this.mParams.gLL == null) {
            this.mParams.gLL = Integer.valueOf(140);
        } else if (this.mParams.gLL.intValue() <= 0) {
            this.mParams.gLL = Integer.valueOf(Integer.MAX_VALUE);
        }
        com.tencent.mm.ui.tools.a.c Gi = n.a(this.mInput).Gi(this.mParams.gLL.intValue());
        Gi.uCR = false;
        Gi.gHz = g.a.uzY;
        Gi.a(this.inputExceedMaxLengthCallback);
        this.mInput.setPasswordMode(this.mParams.gLw);
        if (af.f(this.mParams.gLQ)) {
            this.mInput.setEnabled(false);
            this.mInput.setFocusable(false);
            this.mInput.setFocusableInTouchMode(false);
            this.mInput.setClickable(false);
        } else {
            this.mInput.setEnabled(true);
            this.mInput.setClickable(true);
        }
        if (this.mInput instanceof o) {
            if (this.mParams.gMa != null) {
                ((o) this.mInput).setLineSpace((float) this.mParams.gMa.intValue());
            }
            if (this.mParams.gMb != null) {
                ((o) this.mInput).setLineHeight((float) this.mParams.gMb.intValue());
            }
        }
    }

    private void setInputSelection(int i, int i2) {
        b.a(this.mInput, i, i2);
        mayAutoScrollIfMultiLine();
    }

    private void lineHeightMaybeChanged() {
        if (this.mInput != null) {
            if (this.mInput.getLineCount() != this.mLastLineCount || this.mInput.apL() != this.mLastContentHeight) {
                Object obj = this.mLastLineCount == -1 ? 1 : null;
                this.mLastLineCount = this.mInput.getLineCount();
                this.mLastContentHeight = this.mInput.apL();
                if (this.mOnLineHeightChangeListener != null) {
                    this.mOnLineHeightChangeListener.bM(this.mLastLineCount, this.mLastContentHeight);
                }
                if (this.mParams.gLS.booleanValue() && obj == null) {
                    mayAutoResizeInputHeight();
                    mayAutoScrollIfMultiLine();
                }
            }
        }
    }

    private void mayAutoScrollIfMultiLine() {
        if (this.mParams.gLS.booleanValue() && this.mSmileyPanel != null && this.mSmileyPanel.isShown() && this.mInput != null && this.mInput == this.mSmileyPanel.getAttachedEditText()) {
            i.a(this.mPageRef).apo();
        }
    }

    private void setupSmileyFocus() {
        if (this.mParams.gLS.booleanValue()) {
            findSmileyPanel();
        }
        if (this.mSmileyPanel != null && this.mInput != null) {
            this.mSmileyPanel.gIp = this.mInput;
            this.mSmileyPanel.setShowDoneButton(af.f(this.mParams.gLT));
            setupSmileyPanelListeners();
            if (j.bM(this.mInput) && this.mInput.hasFocus()) {
                this.mSmileyPanel.show();
            }
        }
    }

    private void notifyInputFocusChange(boolean z) {
        if (z) {
            setupSmileyFocus();
        }
        if (this.mSmileyPanel == null) {
            this.mSmileyPanel = findSmileyPanel();
        }
        if (this.mOnInputFocusChangeListener != null) {
            this.mOnInputFocusChangeListener.cO(z);
        }
        if (this.mInput != null && z && this.mParams.gLS.booleanValue()) {
            ah.i(this.mAutoScrollForMultiLineRunnerAfterSmileyPanelSettle, 100);
        }
        if (!(this.mInput == null || z || this.mParams.gLx)) {
            if (this.mTextDoneReason$25f24e96 == 0) {
                dispatchKeyboardComplete(false);
            }
            this.mInput.setFocusable(false);
            this.mInput.setFocusableInTouchMode(false);
            if (this.mSmileyPanel.getAttachedEditText() == this.mInput) {
                this.mSmileyPanel.hide();
                this.mSmileyPanel.b(this.mInput);
            }
        }
        if (this.mSmileyPanel != null && this.mInput != null && !z && this.mParams.gLx) {
            removeInputWhenFocusLoss();
        }
    }

    private void removeInputWhenFocusLoss() {
        dispatchKeyboardComplete(false);
        if (this.mParams.gLx) {
            removeInputImpl(this.mInput);
            onDestroy();
        }
    }

    private void insertInputImpl(int i, int i2) {
        this.mPageRef = this.mParams.gGm;
        p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
        if (pVar == null || pVar.gns == null) {
            x.e(TAG, "insertInputImpl, view not ready, return fail");
            onRuntimeFail();
            return;
        }
        w oVar;
        if (af.f(this.mParams.gLS)) {
            oVar = new o(pVar.mContext);
        } else {
            oVar = new r(pVar.mContext);
        }
        this.mInput = oVar;
        resetInputAttributes();
        this.mInput.setText(bi.oV(this.mParams.gLA));
        if (af.f(this.mParams.gLU)) {
            lineHeightMaybeChanged();
        }
        this.mInput.addTextChangedListener(new 11(this));
        this.mInput.setOnComposingDismissedListener(new 12(this));
        this.mInput.setOnKeyUpPostImeListener(new 13(this));
        if (addInputImpl(this.mInput, this.mParams)) {
            if (!(this.mParams.gLz == null || bi.cX(this.mParams.gLz.gLk))) {
                com.tencent.mm.plugin.appbrand.widget.input.autofill.d.a(pVar, this.mInput, this.mParams.gLz);
            }
            if (!af.f(this.mParams.gLS)) {
                b.a(this.mInput, i, i2);
            }
            if (af.f(this.mParams.gLS)) {
                this.mInput.post(new 14(this));
            }
            if ("text".equalsIgnoreCase(this.mParams.gLv) || "emoji".equalsIgnoreCase(this.mParams.gLv)) {
                initSmileyPanelAndShow();
            } else {
                Assert.assertTrue("Number type implementation removed from here", false);
            }
            this.mInputId = this.mParams.gGq;
            this.mInput.setInputId(this.mInputId);
            this.mInput.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (AppBrandInputInvokeHandler.this.mInput != null) {
                        if (AppBrandInputInvokeHandler.this.mInput.hasFocus()) {
                            AppBrandInputInvokeHandler.this.setupSmileyFocus();
                            return;
                        }
                        p pVar = AppBrandInputInvokeHandler.this.mPageRef == null ? null : (p) AppBrandInputInvokeHandler.this.mPageRef.get();
                        if (pVar != null) {
                            g.apm().o(pVar.gns);
                        }
                        if (AppBrandInputInvokeHandler.this.mInput != null && view == AppBrandInputInvokeHandler.this.mInput) {
                            AppBrandInputInvokeHandler.this.mInput.setFocusable(true);
                            AppBrandInputInvokeHandler.this.mInput.setFocusableInTouchMode(true);
                            AppBrandInputInvokeHandler.this.mSmileyPanel.gIp = AppBrandInputInvokeHandler.this.mInput;
                            AppBrandInputInvokeHandler.this.mInput.requestFocus();
                        }
                    }
                }
            });
            m.a(this.mInputId, this);
            onInputInitialized();
            return;
        }
        x.e(TAG, "add custom view into webView failed");
        onRuntimeFail();
    }

    boolean addInputImpl(w wVar, e eVar) {
        if (wVar == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        f fVar = ((p) this.mPageRef.get()).gnr;
        if (fVar != null) {
            if (fVar.a(((p) this.mPageRef.get()).gns, wVar, eVar.gLB.intValue(), eVar.gLC.intValue(), eVar.gLE.intValue(), eVar.gLD.intValue())) {
                return true;
            }
        }
        return false;
    }

    boolean updateInputPosition(w wVar, e eVar) {
        if (wVar == null || this.mPageRef == null || this.mPageRef.get() == null) {
            return false;
        }
        f fVar = ((p) this.mPageRef.get()).gnr;
        if (fVar != null) {
            if (fVar.b(((p) this.mPageRef.get()).gns, wVar, eVar.gLB.intValue(), eVar.gLC.intValue(), eVar.gLE.intValue(), eVar.gLD.intValue())) {
                return true;
            }
        }
        return false;
    }

    void removeInputImpl(w wVar) {
        if (wVar != null) {
            wVar.b(this.mInputFocusChangeListenerImpl);
            p pVar = this.mPageRef == null ? null : (p) this.mPageRef.get();
            if (pVar != null) {
                f fVar = pVar.gnr;
                if (fVar != null) {
                    fVar.bU(wVar);
                }
            }
        }
    }

    private void setupSmileyPanelListeners() {
        if (this.mSmileyPanel != null) {
            this.mSmileyPanel.setOnSmileyChosenListener(this.mSmileyChosenListener);
            this.mSmileyPanel.setOnDoneListener(this.mSmileyOnDoneListener);
            this.mSmileyPanel.setOnVisibilityChangedListener(this.mSmileyVisibilityListener);
        }
    }

    private void initSmileyPanelAndShow() {
        p pVar = (p) this.mPageRef.get();
        if (z.ak(pVar.getContentView())) {
            this.mSmileyPanel = u.cc(pVar.getContentView());
            setupSmileyPanelListeners();
            hideNumberKeyboard();
            this.mInput.a(this.mInputFocusChangeListenerImpl);
            this.mInput.setOnKeyListener(new 5(this));
            m.a((p) this.mPageRef.get(), this.mInput);
            u uVar = this.mSmileyPanel;
            boolean z = !this.mParams.gLw && "emoji".equals(this.mParams.gLv);
            uVar.setCanSmileyInput(z);
            if (this.mParams.gLS.booleanValue()) {
                this.mInput.setOnEditorActionListener(null);
                this.mInput.setImeOptions(0);
            } else {
                com.tencent.mm.plugin.appbrand.widget.input.c.b aqj;
                if (this.mParams.gLX == null) {
                    aqj = com.tencent.mm.plugin.appbrand.widget.input.c.b.aqj();
                } else {
                    aqj = this.mParams.gLX;
                }
                int i = aqj.gLq;
                this.mInput.setImeOptions(i);
                this.mInput.setOnEditorActionListener(new 6(this, i));
            }
            this.mSmileyPanel.setShowDoneButton(this.mParams.gLT.booleanValue());
            this.mSmileyPanel.gIp = this.mInput;
            if (this.mParams.gLS.booleanValue()) {
                this.mInput.setFocusable(false);
                this.mInput.setFocusableInTouchMode(false);
                this.mSmileyPanel.hide();
            } else {
                this.mInput.requestFocus();
                this.mSmileyPanel.show();
            }
            if (!this.mParams.gLS.booleanValue()) {
                i.a(this.mPageRef).apo();
            }
            ((p) this.mPageRef.get()).a(new 7(this));
        }
    }

    private void dispatchKeyboardComplete(boolean z) {
        if (this.mInput != null) {
            onInputDone(this.mInput.getText().toString(), this.mInput.getSelectionEnd(), this.mTextDoneReason$25f24e96 == c.gGH, z);
        }
    }

    private void doneTextInput() {
        boolean z = this.mTextDoneReason$25f24e96 == c.gGH && af.f(this.mParams.gLY);
        if (!z) {
            hideSmileyPanel();
        }
        if (this.mInput != null) {
            if (this.mInput.hasFocus()) {
                dispatchKeyboardComplete(z);
            }
            if (!z) {
                if (this.mSmileyPanel != null) {
                    this.mSmileyPanel.b(this.mInput);
                }
                if (this.mParams.gLx) {
                    removeInputImpl(this.mInput);
                    onDestroy();
                    return;
                }
                this.mInput.setFocusable(false);
                this.mInput.setFocusableInTouchMode(false);
            }
        }
    }

    private u findSmileyPanel() {
        if (this.mSmileyPanel != null) {
            return this.mSmileyPanel;
        }
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                u cb = u.cb(pVar.getContentView());
                this.mSmileyPanel = cb;
                return cb;
            }
        }
        return null;
    }

    private void hideSmileyPanel() {
        if (findSmileyPanel() != null) {
            this.mSmileyPanel.hide();
        } else if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                Activity cJ = j.cJ(pVar.mContext);
                if (cJ instanceof MMActivity) {
                    ((MMActivity) cJ).YC();
                }
            } else {
                return;
            }
        }
        i.a(this.mPageRef).app();
    }

    private t findNumberKeyboard() {
        if (this.mNumberKeyboard != null) {
            return this.mNumberKeyboard;
        }
        if (this.mPageRef != null) {
            p pVar = (p) this.mPageRef.get();
            if (pVar != null) {
                t bZ = t.bZ(pVar.getContentView());
                this.mNumberKeyboard = bZ;
                return bZ;
            }
        }
        return null;
    }

    private void hideNumberKeyboard() {
        if (findNumberKeyboard() != null) {
            this.mNumberKeyboard.setVisibility(8);
        }
    }
}
