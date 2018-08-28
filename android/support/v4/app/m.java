package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.app.Fragment.SavedState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public abstract class m {
    public abstract Fragment J(String str);

    public abstract Fragment R(int i);

    public abstract void S(int i);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract q bk();

    public abstract Fragment c(Bundle bundle, String str);

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract SavedState e(Fragment fragment);

    public abstract boolean executePendingTransactions();

    public abstract int getBackStackEntryCount();

    public abstract List<Fragment> getFragments();

    public abstract boolean isDestroyed();

    public abstract void popBackStack();

    public abstract boolean popBackStackImmediate();
}
