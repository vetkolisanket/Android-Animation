package com.example.admin.animations.coordinator


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.example.admin.animations.R
import kotlinx.android.synthetic.main.activity_parallax.*

class ParallaxActivity : AppCompatActivity() {

    private var menu: Menu? = null

    companion object {
        fun newIntent(context: Context) = Intent(context, ParallaxActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parallax)
        setSupportActionBar(toolbar)
        init()
    }

    private fun init() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        ablParallax.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = ablParallax.totalScrollRange
                }

                if (scrollRange + verticalOffset == 0) {
                    isShow = true
                    showOption(R.id.action_info)
                } else {
                    isShow = false
                    hideOption(R.id.action_info)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            this.menu = menu
            menuInflater.inflate(R.menu.menu_parallax, menu)
            hideOption(R.id.action_info)
            return true
    }

    fun hideOption(id: Int) {
        menu?.findItem(id)?.isVisible = false
    }

    fun showOption(id: Int) {
         menu?.findItem(id)?.isVisible = true
    }

}
