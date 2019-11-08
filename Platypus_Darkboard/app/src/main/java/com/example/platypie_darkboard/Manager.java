package com.example.platypie_darkboard;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;

/*
    Asset Manager Class
    Manages
    -Icons from assets/sample_icons
        //Should be used for alarm sound and info in the future

    Michael Marinaro November 2019
*/
public class Manager {
    private static final String TAG = "AssetManager";
    private static final String ICON_FOLDER = "sample_icons";

    private AssetManager mAssets;

    public Manager(Context context) {
        mAssets = context.getAssets();

        //Load Assets
        loadIcons();
    }

    private void loadIcons() {
        String[] iconNames;
        try {
            iconNames = mAssets.list(ICON_FOLDER);
            Log.i(TAG, "Found " + iconNames.length + " icons.");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
            return;
        }
    }

}
