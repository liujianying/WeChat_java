package com.tencent.mm.vending.a;

import android.database.Cursor;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class b<_Struct, _Item> extends com.tencent.mm.vending.base.b<_Struct, Cursor> {
    protected Map<Integer, _Item> htT = null;
    public int mCount;
    public a uPD;
    protected _Item uPE;
    public Cursor yV = null;

    public abstract _Item a(_Item _item, Cursor cursor);

    public abstract Cursor bEl();

    protected /* synthetic */ Object prepareVendingDataAsynchronous() {
        if (this.uPD != null) {
            this.uPD.bEg();
        }
        Cursor bEl = bEl();
        if (this.uPD != null) {
            this.uPD.bEh();
        }
        return bEl;
    }

    public b(_Item _item) {
        this.uPE = _item;
        this.mCount = -1;
        cBs();
    }

    private Cursor getCursor() {
        if (this.yV == null || this.yV.isClosed()) {
            Assert.assertNotNull(this.yV);
        }
        return this.yV;
    }

    public void destroyAsynchronous() {
        aYc();
    }

    public final void aYc() {
        if (this.htT != null) {
            this.htT.clear();
        }
        if (this.yV != null) {
            this.yV.close();
        }
        this.mCount = -1;
    }

    public final void cBs() {
        if (this.htT == null) {
            this.htT = new HashMap();
        }
    }

    public final int cBt() {
        if (this.mCount < 0) {
            this.mCount = getCursor().getCount();
        }
        return this.mCount;
    }

    public final _Item getItem(int i) {
        _Item _item;
        if (this.htT != null) {
            _item = this.htT.get(Integer.valueOf(i));
            if (_item != null) {
                return _item;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        if (this.htT == null) {
            return a(this.uPE, getCursor());
        }
        _item = a(null, getCursor());
        this.htT.put(Integer.valueOf(i), _item);
        return _item;
    }
}
