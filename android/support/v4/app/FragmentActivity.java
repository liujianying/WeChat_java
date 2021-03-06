package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.media.session.MediaController;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.e.j;
import android.support.v4.e.k;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.wcdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FragmentActivity extends h implements android.support.v4.app.a.a, android.support.v4.app.c.a {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final k mFragments = new k(new a());
    final Handler mHandler = new Handler() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (FragmentActivity.this.mStopped) {
                        FragmentActivity.this.doReallyStop(false);
                        return;
                    }
                    return;
                case 2:
                    FragmentActivity.this.onResumeFragments();
                    FragmentActivity.this.mFragments.execPendingActions();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    };
    android.support.v4.media.session.a mMediaController;
    int mNextCandidateRequestIndex;
    boolean mOptionsMenuInvalidated;
    k<String> mPendingFragmentActivityResults;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStartedActivityFromFragment;
    boolean mStopped;

    static final class b {
        Object nA;
        List<Fragment> nB;
        j<String, t> nC;

        b() {
        }
    }

    class a extends l<FragmentActivity> {
        public final /* bridge */ /* synthetic */ Object onGetHost() {
            return FragmentActivity.this;
        }

        public a() {
            super(FragmentActivity.this);
        }

        public final void a(String str, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, null, printWriter, strArr);
        }

        public final boolean bh() {
            return !FragmentActivity.this.isFinishing();
        }

        public final LayoutInflater onGetLayoutInflater() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public final void bi() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        public final void a(Fragment fragment, Intent intent, int i, Bundle bundle) {
            FragmentActivity.this.startActivityFromFragment(fragment, intent, i, bundle);
        }

        public final void a(Fragment fragment, String[] strArr, int i) {
            FragmentActivity.this.requestPermissionsFromFragment(fragment, strArr, i);
        }

        public final boolean H(String str) {
            return a.a(FragmentActivity.this, str);
        }

        public final boolean onHasWindowAnimations() {
            return FragmentActivity.this.getWindow() != null;
        }

        public final int onGetWindowAnimations() {
            Window window = FragmentActivity.this.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public final void onAttachFragment(Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public final View onFindViewById(int i) {
            return FragmentActivity.this.findViewById(i);
        }

        public final boolean onHasView() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.noteStateNotSaved();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.mPendingFragmentActivityResults.get(i4);
            this.mPendingFragmentActivityResults.remove(i4);
            if (str != null) {
                Fragment findFragmentByWho = this.mFragments.findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    findFragmentByWho.onActivityResult(65535 & i, i2, intent);
                    return;
                }
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        if (!this.mFragments.mHost.mFragmentManager.popBackStackImmediate()) {
            onBackPressedNotHandled();
        }
    }

    public final void setSupportMediaController(android.support.v4.media.session.a aVar) {
        this.mMediaController = aVar;
        if (VERSION.SDK_INT >= 21) {
            setMediaController((MediaController) aVar.sB.bM());
        }
    }

    public final android.support.v4.media.session.a getSupportMediaController() {
        return this.mMediaController;
    }

    public void supportFinishAfterTransition() {
        if (VERSION.SDK_INT >= 21) {
            finishAfterTransition();
        } else {
            finish();
        }
    }

    public void setEnterSharedElementCallback(al alVar) {
        if (VERSION.SDK_INT >= 21) {
            setEnterSharedElementCallback(b.a(a.a(alVar)));
        }
    }

    public void setExitSharedElementCallback(al alVar) {
        if (VERSION.SDK_INT >= 21) {
            setExitSharedElementCallback(b.a(a.a(alVar)));
        }
    }

    public void supportPostponeEnterTransition() {
        if (VERSION.SDK_INT >= 21) {
            postponeEnterTransition();
        }
    }

    public void supportStartPostponedEnterTransition() {
        if (VERSION.SDK_INT >= 21) {
            startPostponedEnterTransition();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.mHost.mFragmentManager.dispatchConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle) {
        k kVar = this.mFragments;
        kVar.mHost.mFragmentManager.a(kVar.mHost, kVar.mHost, null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.mFragments.mHost.nE = bVar.nC;
        }
        if (bundle != null) {
            this.mFragments.mHost.mFragmentManager.restoreAllState(bundle.getParcelable(FRAGMENTS_TAG), bVar != null ? bVar.nB : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (!(intArray == null || stringArray == null || intArray.length != stringArray.length)) {
                    this.mPendingFragmentActivityResults = new k(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.mPendingFragmentActivityResults.put(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new k();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.mHost.mFragmentManager.dispatchCreate();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        k kVar = this.mFragments;
        onCreatePanelMenu |= kVar.mHost.mFragmentManager.dispatchCreateOptionsMenu(menu, getMenuInflater());
        if (VERSION.SDK_INT >= 11) {
            return onCreatePanelMenu;
        }
        return true;
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.mHost.mFragmentManager.onCreateView(view, str, context, attributeSet);
    }

    public void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.mHost.mFragmentManager.dispatchDestroy();
        l lVar = this.mFragments.mHost;
        if (lVar.mLoaderManager != null) {
            lVar.mLoaderManager.bw();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.mHost.mFragmentManager.dispatchLowMemory();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case 0:
                return this.mFragments.mHost.mFragmentManager.dispatchOptionsItemSelected(menuItem);
            case 6:
                return this.mFragments.mHost.mFragmentManager.dispatchContextItemSelected(menuItem);
            default:
                return false;
        }
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case 0:
                this.mFragments.mHost.mFragmentManager.dispatchOptionsMenuClosed(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
            onResumeFragments();
        }
        this.mFragments.mHost.mFragmentManager.T(4);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.noteStateNotSaved();
    }

    public void onStateNotSaved() {
        this.mFragments.noteStateNotSaved();
    }

    public void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(2);
        this.mResumed = true;
        this.mFragments.execPendingActions();
    }

    public void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(2);
        onResumeFragments();
        this.mFragments.execPendingActions();
    }

    protected void onResumeFragments() {
        this.mFragments.mHost.mFragmentManager.dispatchResume();
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.mHost.mFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public final Object onRetainNonConfigurationInstance() {
        List list;
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        n nVar = this.mFragments.mHost.mFragmentManager;
        if (nVar.nK != null) {
            list = null;
            for (int i = 0; i < nVar.nK.size(); i++) {
                Fragment fragment = (Fragment) nVar.nK.get(i);
                if (fragment != null && fragment.mRetainInstance) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(fragment);
                    fragment.mRetaining = true;
                    fragment.mTargetIndex = fragment.mTarget != null ? fragment.mTarget.mIndex : -1;
                    if (n.DEBUG) {
                        new StringBuilder("retainNonConfig: keeping retained ").append(fragment);
                    }
                }
            }
        } else {
            list = null;
        }
        j bj = this.mFragments.mHost.bj();
        if (list == null && bj == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        Object bVar = new b();
        bVar.nA = onRetainCustomNonConfigurationInstance;
        bVar.nB = list;
        bVar.nC = bj;
        return bVar;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable saveAllState = this.mFragments.mHost.mFragmentManager.saveAllState();
        if (saveAllState != null) {
            bundle.putParcelable(FRAGMENTS_TAG, saveAllState);
        }
        if (this.mPendingFragmentActivityResults.size() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.size()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.size()];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.mPendingFragmentActivityResults.size()) {
                    iArr[i2] = this.mPendingFragmentActivityResults.keyAt(i2);
                    strArr[i2] = (String) this.mPendingFragmentActivityResults.valueAt(i2);
                    i = i2 + 1;
                } else {
                    bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
                    bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
                    return;
                }
            }
        }
    }

    public void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(1);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.mHost.mFragmentManager.dispatchActivityCreated();
        }
        this.mFragments.noteStateNotSaved();
        this.mFragments.execPendingActions();
        l lVar = this.mFragments.mHost;
        if (!lVar.mLoadersStarted) {
            lVar.mLoadersStarted = true;
            if (lVar.mLoaderManager != null) {
                lVar.mLoaderManager.br();
            } else if (!lVar.mCheckedForLoaderManager) {
                lVar.mLoaderManager = lVar.b("(root)", lVar.mLoadersStarted, false);
                if (!(lVar.mLoaderManager == null || lVar.mLoaderManager.mg)) {
                    lVar.mLoaderManager.br();
                }
            }
            lVar.mCheckedForLoaderManager = true;
        }
        this.mFragments.mHost.mFragmentManager.dispatchStart();
        l lVar2 = this.mFragments.mHost;
        if (lVar2.nE != null) {
            int i;
            int size = lVar2.nE.size();
            u[] uVarArr = new u[size];
            for (i = size - 1; i >= 0; i--) {
                uVarArr[i] = (u) lVar2.nE.valueAt(i);
            }
            for (i = 0; i < size; i++) {
                u uVar = uVarArr[i];
                if (uVar.mRetaining) {
                    if (u.DEBUG) {
                        new StringBuilder("Finished Retaining in ").append(uVar);
                    }
                    uVar.mRetaining = false;
                    for (int size2 = uVar.oX.size() - 1; size2 >= 0; size2--) {
                        a aVar = (a) uVar.oX.valueAt(size2);
                        if (aVar.mRetaining) {
                            if (u.DEBUG) {
                                new StringBuilder("  Finished Retaining: ").append(aVar);
                            }
                            aVar.mRetaining = false;
                            if (!(aVar.mg == aVar.pf || aVar.mg)) {
                                aVar.stop();
                            }
                        }
                        if (aVar.mg && aVar.pd && !aVar.pg) {
                            aVar.c(aVar.pc, aVar.mData);
                        }
                    }
                }
                uVar.bv();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(1);
        this.mFragments.mHost.mFragmentManager.dispatchStop();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public Object getLastCustomNonConfigurationInstance() {
        b bVar = (b) getLastNonConfigurationInstance();
        return bVar != null ? bVar.nA : null;
    }

    public void supportInvalidateOptionsMenu() {
        if (VERSION.SDK_INT >= 11) {
            invalidateOptionsMenu();
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = VERSION.SDK_INT;
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print("mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.mReallyStopped);
        l lVar = this.mFragments.mHost;
        printWriter.print(str2);
        printWriter.print("mLoadersStarted=");
        printWriter.println(lVar.mLoadersStarted);
        if (lVar.mLoaderManager != null) {
            printWriter.print(str2);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(lVar.mLoaderManager)));
            printWriter.println(":");
            lVar.mLoaderManager.dump(str2 + "  ", fileDescriptor, printWriter, strArr);
        }
        this.mFragments.mHost.mFragmentManager.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.println("View Hierarchy:");
        dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
    }

    private static String viewToString(View view) {
        char c;
        char c2 = 'F';
        char c3 = '.';
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case 0:
                stringBuilder.append('V');
                break;
            case 4:
                stringBuilder.append('I');
                break;
            case 8:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        if (view.isFocusable()) {
            c = 'F';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isEnabled()) {
            c = 'E';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        if (view.isHorizontalScrollBarEnabled()) {
            c = 'H';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isVerticalScrollBarEnabled()) {
            c = 'V';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isClickable()) {
            c = 'C';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isLongClickable()) {
            c = 'L';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c2 = '.';
        }
        stringBuilder.append(c2);
        if (view.isSelected()) {
            c = 'S';
        } else {
            c = '.';
        }
        stringBuilder.append(c);
        if (view.isPressed()) {
            c3 = 'P';
        }
        stringBuilder.append(c3);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(viewToString(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i++) {
                    dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(1);
            onReallyStop();
        }
    }

    void onReallyStop() {
        k kVar = this.mFragments;
        boolean z = this.mRetaining;
        l lVar = kVar.mHost;
        lVar.nF = z;
        if (lVar.mLoaderManager != null && lVar.mLoadersStarted) {
            lVar.mLoadersStarted = false;
            if (z) {
                lVar.mLoaderManager.bt();
            } else {
                lVar.mLoaderManager.bs();
            }
        }
        this.mFragments.mHost.mFragmentManager.T(2);
    }

    public void onAttachFragment(Fragment fragment) {
    }

    public m getSupportFragmentManager() {
        return this.mFragments.mHost.mFragmentManager;
    }

    public t getSupportLoaderManager() {
        l lVar = this.mFragments.mHost;
        if (lVar.mLoaderManager != null) {
            return lVar.mLoaderManager;
        }
        lVar.mCheckedForLoaderManager = true;
        lVar.mLoaderManager = lVar.b("(root)", lVar.mLoadersStarted, true);
        return lVar.mLoaderManager;
    }

    public void startActivityForResult(Intent intent, int i) {
        if (this.mStartedActivityFromFragment || i == -1 || (-65536 & i) == 0) {
            super.startActivityForResult(intent, i);
            return;
        }
        throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1 && (-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.mPendingFragmentActivityResults.get(i3);
            this.mPendingFragmentActivityResults.remove(i3);
            if (str != null) {
                Fragment findFragmentByWho = this.mFragments.findFragmentByWho(str);
                if (findFragmentByWho != null) {
                    findFragmentByWho.onRequestPermissionsResult(i & 65535, strArr, iArr);
                }
            }
        }
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public void startActivityFromFragment(Fragment fragment, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                a.a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            a.a(this, intent, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    private int allocateRequestIndex(Fragment fragment) {
        if (this.mPendingFragmentActivityResults.size() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.put(i, fragment.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return i;
    }

    private void requestPermissionsFromFragment(Fragment fragment, String[] strArr, int i) {
        if (i == -1) {
            a.a(this, strArr, i);
        } else if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        } else {
            try {
                this.mRequestedPermissionsFromFragment = true;
                a.a(this, strArr, ((allocateRequestIndex(fragment) + 1) << 16) + (65535 & i));
            } finally {
                this.mRequestedPermissionsFromFragment = false;
            }
        }
    }
}
