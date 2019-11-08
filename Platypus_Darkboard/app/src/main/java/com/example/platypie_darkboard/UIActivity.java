package com.example.platypie_darkboard;


/*  Basic activity which hosts UIFragment

    Michael Marinaro November 2019
 */

import androidx.fragment.app.Fragment;

public class UIActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return UIFragment.newInstance();
    }
}
