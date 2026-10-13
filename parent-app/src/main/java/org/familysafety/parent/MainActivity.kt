package org.familysafety.parent

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import org.familysafety.parent.pairing.PairingCode

/** Parent dashboard starter. Real remote control requires authenticated backend sync. */
class MainActivity : Activity() {
    private lateinit var status: TextView
    private var currentCode: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val pad = (resources.displayMetrics.density * 20).toInt()
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(pad, pad, pad, pad)
            setBackgroundColor(Color.rgb(247, 249, 252))
        }
        content.addView(TextView(this).apply {
            text = "Family Safety Parent"
            textSize = 26f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.rgb(24, 38, 66))
        })
        content.addView(TextView(this).apply {
            text = "Manage linked-device setup and family safety rules."
            textSize = 15f
            setTextColor(Color.DKGRAY)
            setPadding(0, pad / 3, 0, pad)
        })
        status = TextView(this).apply {
            text = "Child device: not paired"
            textSize = 16f
            setTextColor(Color.rgb(30, 70, 55))
            setPadding(0, pad / 2, 0, pad / 2)
        }
        content.addView(status)
        addButton(content, "Create local pairing code") {
            currentCode = PairingCode.generate()
            status.text = "Demo pairing code: $currentCode\nLocal demo only — not connected to a server."
        }
        addButton(content, "View safety feature checklist") {
            status.text = "Planned modules: adult-content filter, screen time, app rules, SOS, and supported device status. None are remotely active in this starter."
        }
        content.addView(TextView(this).apply {
            text = "\nSecurity note\nNever use a static shared secret in a release app. Production pairing needs short-lived server-issued codes, expiry, rate limiting, authenticated accounts, and device unlink/revoke."
            textSize = 14f
            setTextColor(Color.DKGRAY)
        })
        setContentView(ScrollView(this).apply { addView(content) })
    }

    private fun addButton(parent: LinearLayout, label: String, action: () -> Unit) {
        parent.addView(Button(this).apply {
            text = label
            isAllCaps = false
            setOnClickListener { action() }
        }, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT))
    }
}
