package com.example.gandroid

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit internal var editUrl: EditText
    lateinit internal var go: Button
    lateinit internal var back: Button
    lateinit internal var web: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editUrl = findViewById(R.id.editUrl)
        go = findViewById(R.id.go)
        back = findViewById(R.id.back)
        web = findViewById(R.id.webView)

        web.webViewClient = JunHeeWebView()

        var webSet = web.settings
        webSet.builtInZoomControls = true

        go.setOnClickListener {
            web.loadUrl(editUrl.text.toString())
        }

        back.setOnClickListener {
            web.goBack()
        }

        showActionBar()
    }

    private fun showActionBar() {
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.gachon)
    }

    @Deprecated("deprecated")
    class JunHeeWebView : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            return super.shouldOverrideUrlLoading(view, url)
        }
    }

}