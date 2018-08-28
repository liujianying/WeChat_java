package com.tencent.map.lib.thread;

import com.tencent.map.lib.thread.HighThreadExecutor.a;
import com.tencent.map.lib.thread.HighThreadExecutor.a.b;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HighThreadExecutor$a$a implements Iterator<E> {
    final /* synthetic */ a a;
    private b<E> b;
    private b<E> c;
    private E d;

    HighThreadExecutor$a$a(a aVar) {
        this.a = aVar;
        a.a(aVar);
        try {
            this.b = aVar.a.b;
            if (this.b != null) {
                this.d = this.b.a;
            }
            aVar.a();
        } catch (Throwable th) {
            aVar.a();
        }
    }

    public boolean hasNext() {
        return this.b != null;
    }

    private b<E> a(b<E> bVar) {
        b bVar2;
        do {
            bVar2 = bVar2.b;
            if (bVar2 == null) {
                break;
            }
        } while (bVar2.a == null);
        return bVar2;
    }

    public E next() {
        a.a(this.a);
        E e;
        try {
            if (this.b == null) {
                throw new NoSuchElementException();
            }
            e = this.d;
            this.c = this.b;
            this.b = a(this.b);
            this.d = this.b == null ? null : this.b.a;
            return e;
        } finally {
            e = this.a;
            e.a();
        }
    }

    public void remove() {
        a.a(this.a);
        try {
            b bVar = this.c;
            this.c = null;
            b bVar2 = this.a.a;
            b bVar3 = bVar2.b;
            b bVar4 = bVar2;
            while (bVar3 != null) {
                if (bVar3 == bVar) {
                    this.a.a(bVar3, bVar4);
                    break;
                } else {
                    bVar4 = bVar3;
                    bVar3 = bVar3.b;
                }
            }
            this.a.a();
        } catch (Throwable th) {
            this.a.a();
        }
    }
}
