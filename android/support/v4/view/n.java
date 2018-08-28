package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

final class n {

    static class a implements OnActionExpandListener {
        private b uR;

        public a(b bVar) {
            this.uR = bVar;
        }

        public final boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.uR.onMenuItemActionExpand(menuItem);
        }

        public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.uR.onMenuItemActionCollapse(menuItem);
        }
    }

    interface b {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    public static MenuItem a(MenuItem menuItem, b bVar) {
        return menuItem.setOnActionExpandListener(new a(bVar));
    }
}
