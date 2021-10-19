package hu.kzs.nytimes

import android.os.Bundle
import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import hu.kzs.nytimes.ui.main.MainFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigator.add(MainFragment())
        }
    }
}
