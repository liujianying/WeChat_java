package android.support.v4.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {
    Context mContext;
    public int mId;
    public boolean mg = false;
    public b<D> qW;
    public a<D> qX;
    public boolean qY = false;
    public boolean qZ = true;
    public boolean ra = false;
    public boolean rb = false;

    public interface a<D> {
    }

    public interface b<D> {
        void b(c<D> cVar, D d);
    }

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public final void deliverResult(D d) {
        if (this.qW != null) {
            this.qW.b(this, d);
        }
    }

    public final void a(b<D> bVar) {
        if (this.qW == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.qW != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.qW = null;
        }
    }

    public final void a(a<D> aVar) {
        if (this.qX == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.qX != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.qX = null;
        }
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public void onReset() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        android.support.v4.e.c.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.mId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.qW);
        if (this.mg || this.ra || this.rb) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mg);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.ra);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.rb);
        }
        if (this.qY || this.qZ) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.qY);
            printWriter.print(" mReset=");
            printWriter.println(this.qZ);
        }
    }
}
